import java.util.List;
import java.util.LinkedList;

class Liquid {
    private String name;
    private double quantity;

    public Liquid(String name, double quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String toString() {
        return name + " " + quantity;
    }
}

class Water extends Liquid {
    public Water(String name, double quantity) {
        super(name, quantity);
    }
}

class Mineralwater extends Water {
    public Mineralwater(double quantity) {
        super("Mineral Water", quantity);
    }
}

class Milk extends Liquid {
    public Milk() {
        super("Milk", 200);
    }
}

public class MyClass {

    public static void sellLiquid(List<Liquid> list, Liquid liquid) {
        list.remove(liquid);
    }

    public static void buyLiquid(LinkedList<Liquid> list, Liquid liquid) {
        list.add(liquid);
    }

    public static void main(String[] args) {

        LinkedList<Liquid> storage = new LinkedList<Liquid>();

        Water w = new Water("Water", 200);
        Mineralwater mw = new Mineralwater(250);
        Milk m = new Milk();

        buyLiquid(storage, w);
        buyLiquid(storage, mw);
        buyLiquid(storage, m);

        sellLiquid(storage, m);

        for (Liquid item : storage)
            System.out.println(item);
    }
}