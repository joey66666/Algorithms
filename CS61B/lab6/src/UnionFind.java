public class UnionFind {

    public int[] parentArray;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        parentArray = new int[n];
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        // TODO: 未完全理解意思，待实现
        int i = parentArray[vertex];
    }

    /* Returns the size of the set v1 belongs to. */
    // root store the -size
    // e.g: -6 as the size is 6,
    public int sizeOf(int v1) {
        int count = parentArray[v1];
        while (count >= 0) {
            count = parentArray[count];
        }
        return count;
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        return parentArray[v1];

    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        return find(v1)==find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        // TODO
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        // TODO: 理解Path-compression方法并实现，为connected()的依赖
        return -1;
    }

}
