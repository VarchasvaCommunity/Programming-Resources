import java.util.*;

public class GraphTraversal {
  private int numVertices;
  private LinkedList<Integer> adjacencyList[];

  GraphTraversal(int v) {
    numVertices = v;
    adjacencyList = new LinkedList[v];
    for (int i = 0; i < v; ++i)
      adjacencyList[i] = new LinkedList();
  }

  void addEdge(int v, int w) {
    adjacencyList[v].add(w);
  }

  void BreadthFirstSearch(int start) {

    boolean visited[] = new boolean[numVertices];

    LinkedList<Integer> queue = new LinkedList();

    visited[start] = true;
    queue.add(start);

    while (queue.size() != 0) {
      start = queue.poll();
      System.out.print(start + " ");

      Iterator<Integer> iterator = adjacencyList[start].listIterator();
      while (iterator.hasNext()) {
        int neighbor = iterator.next();
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.add(neighbor);
        }
      }
    }
  }

  public static void main(String args[]) {
    GraphTraversal graph = new GraphTraversal(4);

    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);

    System.out.println("Breadth First Traversal starting from vertex 2:");

    graph.BreadthFirstSearch(2);
  }
}
