package automates;

public interface Automata {
    public boolean accept(String mot);
    public boolean isEmpty();
    public AFN deterministic();
    public String toString();
}
