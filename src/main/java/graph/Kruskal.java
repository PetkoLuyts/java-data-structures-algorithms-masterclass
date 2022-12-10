package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal {
    ArrayList<DisjointSet.WeightedNode> nodeList = new ArrayList<>();
    ArrayList<UndirectedEdge> edgeList = new ArrayList<>();

    public static class UndirectedEdge {
        public DisjointSet.WeightedNode firstNode;
        public DisjointSet.WeightedNode secondNode;
        public int weight;

        public UndirectedEdge(DisjointSet.WeightedNode firstNode, DisjointSet.WeightedNode secondNode, int weight) {
            this.firstNode = firstNode;
            this.secondNode = secondNode;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge (" + firstNode + ", " + secondNode + "), weight = " + weight;
        }
    }

    public Kruskal(ArrayList<DisjointSet.WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
        UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex), nodeList.get(secondIndex), weight);
        DisjointSet.WeightedNode first = edge.firstNode;
        DisjointSet.WeightedNode second = edge.secondNode;
        first.neighbours.add(second);
        second.neighbours.add(first);
        first.weightMap.put(second, weight);
        second.weightMap.put(first, weight);
        edgeList.add(edge);
    }

    public void kruskal() {
        DisjointSet.makeSet(nodeList);
        Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
            @Override
            public int compare(UndirectedEdge o1, UndirectedEdge o2) {
                return o1.weight - o2.weight;
            }
        };

        Collections.sort(edgeList, comparator);
        int cost = 0;

        for (UndirectedEdge edge : edgeList) {
            DisjointSet.WeightedNode first = edge.firstNode;
            DisjointSet.WeightedNode second = edge.secondNode;

            if (!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))) {
                DisjointSet.union(first, second);
                cost += edge.weight;
                System.out.println("Taken " + edge);
            }
        }

        System.out.println("The total cost of Minimum Spanning Tree is: " + cost);
    }
}
