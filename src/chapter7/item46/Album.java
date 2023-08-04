package chapter7.item46;

public class Album {
    Artist artist;
    long sales;

    String name;

    public Artist artist() {
        return this.artist;
    }

    public long sales() {
        return this.sales;
    }
    public Album(Artist artist, int sales, String name) {
        this.artist = artist;
        this.name = name;
        this.sales = sales;
    }
}
