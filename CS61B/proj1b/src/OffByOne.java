/* A classs for off-by-1 comparators */
public class OffByOne implements CharacterComparator {
//    @Override
//    public boolean equalChars(char x, char y) {
//        return x == y;
//    }

    /* a==b, r==q
     *  a!=e, z!=a
     *  equals by one apart*/
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }


}
