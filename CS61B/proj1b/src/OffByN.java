/* A classs for off-by-N comparators */
public class OffByN implements CharacterComparator {

    int n;

    public OffByN(int N) {
        this.n = N;
    }


    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == n;
    }
}
