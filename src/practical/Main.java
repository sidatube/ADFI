package practical;

public class Main {
    public static void main(String[] args) {
        Complex cp1 = new Complex(3,5);
        Complex cp2 = new Complex(8,2);
        System.out.println("Add: "+cp1.add(cp2));
        System.out.println("Subtract: "+cp1.subtract(cp2));
        System.out.println("Multiply: "+cp1.multiply(cp2));
        System.out.println("Divide: "+cp1.divide(cp2));
//        System.out.println("Base1: "+cp1);
//        System.out.println("Base2: "+cp2);
    }
}
