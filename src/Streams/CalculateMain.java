package Streams;

public class CalculateMain {
    public static void main(String[] args) {
        Calculator test1= new Calculator();
        test1.addOperation("sum", (x,y)->x+y);
        test1.addOperation("minus", (x,y)->x-y);

        test1.calculate("sum", 4.0, 5.0);
        test1.calculate("minus", 4.0, 2.0);
    }
}
