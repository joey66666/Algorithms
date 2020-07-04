public class UnionFindTest {
    // TODO: UnionFind待测试

    public static void main(String[] args) {
        UnionFind u = new UnionFind(6);
        u.union(0, 1);
        u.union(2, 3);
        u.union(1, 2);
        System.out.println(u.parent(0));
        System.out.println(u.parent(2));
        System.out.println(u.sizeOf(0));
        System.out.println(u.connected(0,3));


    }


}
