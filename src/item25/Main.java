package item25;

public class Main {
    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
    }
}

class Utensil {
    static final String NAME = "PAN";
}
class Dessert{
    static final String NAME = "CAKE";
}