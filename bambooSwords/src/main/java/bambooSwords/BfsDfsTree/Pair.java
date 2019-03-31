package bambooSwords.BfsDfsTree;

public class Pair {
    int a;
    int b;

    Pair(int p,int q){
        a = p;
        b = q;
    }
    public boolean equals(Object o) {
        if (o instanceof Pair) {
            Pair p = (Pair)o;
            return p.a == a && p.b == b;
        }
        return false;
    }
    public int hashCode() {
        return new Integer(a).hashCode() * 31 + new Integer(b).hashCode();
    }
}
