import java.util.*;

class Kruskal {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    static class subset {
        int parent, rank;
    }

    int vertices, edges;
    Edge[] edge;

    Kruskal(int v, int e) {
        vertices = v;
        edges = e;
        edge = new Edge[edges];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    int find(subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void Union(subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void KruskalAlgo() {
        Edge[] result = new Edge[vertices];
        int e = 0;
        int i;
        for (i = 0; i < vertices; ++i)
            result[i] = new Edge();

        // Sorting the edges
        Arrays.sort(edge);
        subset[] subsets = new subset[vertices];
        for (i = 0; i < vertices; ++i)
            subsets[i] = new subset();

        for (int v = 0; v < vertices; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i = 0;
        while (e < vertices - 1) {
            Edge next_edge = new Edge();
            next_edge = edge[i++];
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].weight);
    }

    public static void main(String[] args) {
        int v = 6;
        int e = 8;
        Kruskal graph = new Kruskal(v, e);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 4;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 2;

        graph.edge[3].src = 2;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 3;

        graph.edge[4].src = 2;
        graph.edge[4].dest = 5;
        graph.edge[4].weight = 2;

        graph.edge[5].src = 2;
        graph.edge[5].dest = 4;
        graph.edge[5].weight = 4;

        graph.edge[6].src = 3;
        graph.edge[6].dest = 4;
        graph.edge[6].weight = 3;

        graph.edge[7].src = 5;
        graph.edge[7].dest = 4;
        graph.edge[7].weight = 3;
        graph.KruskalAlgo();
    }
}
