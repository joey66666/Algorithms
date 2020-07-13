public class UnionFind {

    public int[] parentArray;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        parentArray = new int[n];
        for (int i = 0; i < n; i += 1) {
            parentArray[i] = -1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        if (vertex < 0 || vertex >= parentArray.length) {
            throw new IllegalArgumentException("invalid index");
        }
    }

    /* Returns the size of the set v1 belongs to. */
    // root store the -size
    // e.g: -6 as the size is 6
    public int sizeOf(int v1) {
        validate(v1);
        return -parent(find(v1));
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        validate(v1);
        return parentArray[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        validate(v1);
        validate(v2);
        return find(v1) == find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        validate(v1);
        validate(v2);

        if (!connected(v1, v2)) {
            int size1 = sizeOf(v1);
            int size2 = sizeOf(v2);
            if (size1 <= size2) {
                // v1接到v2上
                parentArray[find(v2)] -= size1;
                parentArray[find(v1)] = find(v2);
            } else {
                // v2接到v1上
                parentArray[find(v1)] -= size2;
                parentArray[find(v2)] = find(v1);
            }
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        // Path-Compression: call isConnected(x,y)时连接x,y所有parent到各自的root
        validate(vertex);
        int root = vertex;
        while (parent(root) >= 0) {
            root = parent(root);
        }

        //Path-Compression
        int curParent;
        while (vertex != root) {
            curParent = parent(vertex);
            parentArray[vertex] = root;
            vertex = curParent;
        }
        return root;
    }

}