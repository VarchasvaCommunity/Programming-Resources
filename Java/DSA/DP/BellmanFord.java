class CreateG {

    class CreateEdge {
        int s, d, w;

        CreateEdge() {
            s = d = w = 0;
        }
    };

    int V, E;
    CreateEdge edge[];

    CreateG(int v, int e) {
        V = v;
        E = e;
        edge = new CreateEdge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new CreateEdge();
    }

    void BellmanFord(CreateG graph, int s) {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];

        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;

        dist[s] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                // Get the edge data
                int u = graph.edge[j].s;
                int v = graph.edge[j].d;
                int w = graph.edge[j].w;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
                    dist[v] = dist[u] + w;
            }
        }

        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].s;
            int v = graph.edge[j].d;
            int w = graph.edge[j].w;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("Graph contains negative w cycle");
                return;
            }
        }

        printAns(dist, V);
    }

    void printAns(int dist[], int V) {
        System.out.println("Vertex" + "   " + "Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "        " + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 8;

        CreateG graph = new CreateG(V, E);

        graph.edge[0].s = 0;
        graph.edge[0].d = 1;
        graph.edge[0].w = 5;

        graph.edge[1].s = 0;
        graph.edge[1].d = 2;
        graph.edge[1].w = 4;

        graph.edge[2].s = 1;
        graph.edge[2].d = 3;
        graph.edge[2].w = 3;

        graph.edge[3].s = 2;
        graph.edge[3].d = 1;
        graph.edge[3].w = 6;

        graph.edge[4].s = 3;
        graph.edge[4].d = 2;
        graph.edge[4].w = 2;

        graph.BellmanFord(graph, 0);
    }
}
