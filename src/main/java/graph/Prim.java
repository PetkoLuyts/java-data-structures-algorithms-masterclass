package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prim {
    ArrayList<DisjointSet.WeightedNode> nodeList = new ArrayList<>();


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

    public Prim(ArrayList<DisjointSet.WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
        Kruskal.UndirectedEdge edge = new Kruskal.UndirectedEdge(nodeList.get(firstIndex), nodeList.get(secondIndex), weight);
        DisjointSet.WeightedNode first = edge.firstNode;
        DisjointSet.WeightedNode second = edge.secondNode;
        first.neighbours.add(second);
        second.neighbours.add(first);
        first.weightMap.put(second, weight);
        second.weightMap.put(first, weight);
    }

    public void prim(DisjointSet.WeightedNode node) {
        for (int i = 0; i < nodeList.size(); i++) {
            nodeList.get(i).distance = Integer.MAX_VALUE;
        }

        node.distance = 0;
        PriorityQueue<DisjointSet.WeightedNode> queue = new PriorityQueue<>();
        queue.addAll(nodeList);

        while (!queue.isEmpty()) {
            DisjointSet.WeightedNode currentNode = queue.remove();

            for (DisjointSet.WeightedNode neighbour : currentNode.neighbours) {
                if (queue.contains(neighbour)) {
                    if (neighbour.distance > currentNode.weightMap.get(neighbour)) {
                        neighbour.distance = currentNode.weightMap.get(neighbour);
                        neighbour.parent = currentNode;
                        queue.remove(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }

        int cost = 0;

        for (DisjointSet.WeightedNode nodeToCheck : nodeList) {
            System.out.println("Node " + nodeToCheck + ", key " + nodeToCheck.distance + " Paremt:" + nodeToCheck.parent);
            cost += nodeToCheck.distance;
        }

        System.out.println("Total cost of Minimum Spanning Tree: " + cost);
    }
}
