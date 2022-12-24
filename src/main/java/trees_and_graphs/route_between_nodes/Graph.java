package trees_and_graphs.route_between_nodes;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    static ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public enum State {
        Unvisited, Visited, Visiting;
    }

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addDirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbors.add(second);
    }

    public static boolean search(GraphNode start, GraphNode end) {
        LinkedList<GraphNode> q = new LinkedList<>();

        for (GraphNode node : nodeList) {
            node.state = State.Unvisited;
        }

        start.state = State.Visiting;
        q.add(start);
        GraphNode currentNode;

        while (!q.isEmpty()) {
            currentNode = q.removeFirst();

            if (currentNode != null) {
                for (GraphNode v : currentNode.neighbors) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visited;
                            q.add(v);
                        }
                    }
                }

                currentNode.state = State.Visited;
            }
        }

        return false;
    }
}
