package OOP.interfaces;

public class Car implements Engine, Brakes{
    @Override
    public void brake() {
        System.out.println("braking");
    }

    @Override
    public void start() {
        System.out.println("starting the engine");
    }

    @Override
    public void stop() {
        System.out.println("stoping the engine");
    }

    @Override
    public void acc() {
        System.out.println("accelarating the engine");
    }
}
