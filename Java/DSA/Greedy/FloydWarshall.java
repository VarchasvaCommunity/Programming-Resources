class FloydWarshall {
  final static int INF = 9999, V = 4;

  void floydWarshall(int graph[][]) {
    int dist[][] = new int[V][V];
    int i, j, k;

    for (i = 0; i < V; i++)
      for (j = 0; j < V; j++)
        dist[i][j] = graph[i][j];

    for (k = 0; k < V; k++) {
      for (i = 0; i < V; i++) {
        for (j = 0; j < V; j++) {
          if (dist[i][k] + dist[k][j] < dist[i][j])
            dist[i][j] = dist[i][k] + dist[k][j];
        }
      }
    }
    printMatrix(dist);
  }

  void printMatrix(int dist[][]) {
    for (int i = 0; i < V; ++i) {
      for (int j = 0; j < V; ++j) {
        if (dist[i][j] == INF)
          System.out.print("INF ");
        else
          System.out.print(dist[i][j] + "  ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int graph[][] = { { 0, 3, INF, 5 }, { 2, 0, INF, 4 }, { INF, 1, 0, INF }, { INF, INF, 2, 0 } };
    FloydWarshall fw = new FloydWarshall();
    fw.floydWarshall(graph);
  }
}
