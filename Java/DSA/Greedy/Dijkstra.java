class Dijkstra {
    public void dijkstra(int[][] graph, int source) {
        int c = graph.length;
        boolean[] visitedVert = new boolean[c];
        int[] dist = new int[c];
        for (int i = 0; i < c; i++) {
            visitedVert[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }

        dist[source] = 0;
        for (int i = 0; i < c; i++) {

            int u = findMinDistance(dist, visitedVert);
            visitedVert[u] = true;

            for (int v = 0; v < c; v++) {
                if (!visitedVert[v] && graph[u][v] != 0 && (dist[u] + graph[u][v] < dist[v])) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        for (int i = 0; i < dist.length; i++)
            System.out.println("Distance from " + source + " to " + i + dist[i]);

    }

    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDist = Integer.MAX_VALUE;
        int minDistVert = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visitedVertex[i] && distance[i] < minDist) {
                minDist = distance[i];
                minDistVert = i;
            }
        }
        return minDistVert;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] { { 0, 0, 1, 2, 0, 0, 0 }, { 0, 0, 2, 0, 0, 3, 0 }, { 1, 2, 0, 1, 3, 0, 0 },
                { 2, 0, 1, 0, 0, 0, 1 }, { 0, 0, 3, 0, 0, 2, 0 }, { 0, 3, 0, 0, 2, 0, 1 }, { 0, 0, 0, 1, 0, 1, 0 } };
        Dijkstra obj = new Dijkstra();
        obj.dijkstra(graph, 0);
    }
}
