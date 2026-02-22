class SingleTon {
    static SingleTon singleTon;
    String name;

    private SingleTon() {
    }

    static SingleTon getSameInstance() {
        if (singleTon == null) {
            singleTon = new SingleTon();
            return singleTon;
        }
        return singleTon;
    }
}

public class Ruff {
    public static void main(String[] args) {
        SingleTon s1 = SingleTon.getSameInstance();
        SingleTon s2 = SingleTon.getSameInstance();

        s1.name = "Pruthviraj";
        s2.name = "Nikhil";
        System.out.println(s1.name);
        System.out.println(s2.name);
    }
}