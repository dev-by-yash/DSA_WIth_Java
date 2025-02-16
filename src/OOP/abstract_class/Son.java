package OOP.abstract_class;

public class Son extends Example{
    @Override
    void career(String name) {
        System.out.println("my name is: " + name);
    }

    @Override
    void anime(String name, int rating) {
        System.out.println(name + " "+ rating);
    }
}
