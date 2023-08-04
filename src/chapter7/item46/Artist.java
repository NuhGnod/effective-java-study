package chapter7.item46;

public class Artist implements Comparable<Artist> {
    String name;

    public Artist(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Artist o) {
        return this.name.hashCode() - o.name.hashCode();
    }
}
