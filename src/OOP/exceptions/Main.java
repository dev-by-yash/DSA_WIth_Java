package OOP.exceptions;

public class Main {
    static int divide(int a, int b) throws ArithmeticException{
        if (b == 0){
            throw new ArithmeticException("cant / by 0");
        }
        return a/b;
    }

    public static void main(String[] args) {
        try {
            divide(2,0);
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}
