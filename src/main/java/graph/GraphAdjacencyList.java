package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class GraphAdjacencyList {
    ArrayList<GraphNode> nodeList = new ArrayList<>();

    public static class GraphNode {
        public String name;
        public int index;
        public boolean isVisited = false;
        public GraphNode parent;
        public ArrayList<GraphNode> neighbours = new ArrayList<>();

        public GraphNode(String name, int index) {
            this.name = name;
            this.index = index;
        }
    }

    public GraphAdjacencyList(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbours.add(second);
        second.neighbours.add(first);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");

            for (int j =0; j < nodeList.get(i).neighbours.size(); j++) {
                if (j == nodeList.get(i).neighbours.size()-1 ) {
                    s.append((nodeList.get(i).neighbours.get(j).name) );
                } else {
                    s.append((nodeList.get(i).neighbours.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }

        return s.toString();
    }

    public void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");

            for (GraphNode neighbour : currentNode.neighbours) {
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    public void bfs() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                bfsVisit(node);
            }
        }
    }

    public void dfsVisit(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            GraphNode currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");

            for (GraphNode neighbour : currentNode.neighbours) {
                if (!neighbour.isVisited) {
                    stack.push(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    public void dfs() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                dfsVisit(node);
            }
        }
    }

    public void addDirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbours.add(second);
    }

    public void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
        for (GraphNode neighbour : node.neighbours) {
            if (!neighbour.isVisited) {
                topologicalVisit(neighbour, stack);
            }
        }

        node.isVisited = true;
        stack.push(node);
    }

    public void topologicalSort() {
        Stack<GraphNode> stack = new Stack<>();

        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                topologicalVisit(node, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().name + " ");
        }
    }

    public static void pathPrint(GraphNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }

        System.out.print(node.name + " ");
    }

    public void BFSForSSSPP(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print("Printing path for node: " + currentNode.name + ": ");
            pathPrint(currentNode);
            System.out.println();

            for (GraphNode neighbour : currentNode.neighbours) {
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                    neighbour.parent = currentNode;
                }
            }
        }
    }
}
