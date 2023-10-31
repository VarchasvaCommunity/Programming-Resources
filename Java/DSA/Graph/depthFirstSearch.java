import java.util.*;

class Graph {
  private LinkedList<Integer> neighbors[];
  private boolean visited[];

  Graph(int numVertices) {
    neighbors = new LinkedList[numVertices];
    visited = new boolean[numVertices];

    for (int i = 0; i < numVertices; i++)
      neighbors[i] = new LinkedList<Integer>();
  }

  void addEdge(int source, int destination) {
    neighbors[source].add(destination);
  }

  void depthFirstSearch(int startVertex) {
    visited[startVertex] = true;
    System.out.print(startVertex + " ");

    Iterator<Integer> iterator = neighbors[startVertex].listIterator();
    while (iterator.hasNext()) {
      int adjacent = iterator.next();
      if (!visited[adjacent])
        depthFirstSearch(adjacent);
    }
  }

  public static void main(String args[]) {
    Graph g = new Graph(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 3);

    System.out.println("Depth First Traversal:");

    g.depthFirstSearch(2);
  }
}
