package ex08;

public class NO {
    public int item;
    public NO dir;
    public NO esq;

    public NO(int i) {
        item = i;
        dir = null;
        esq = null;
    }
}