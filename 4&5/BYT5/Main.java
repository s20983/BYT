import java.util.Scanner;

//TASK - Example of the builder method pattern

public class Main{

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number");
        int first = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter operation (+ or - or * or /)");
        String operation = scanner.nextLine();

        System.out.println("Enter second number");
        int second = scanner.nextInt();

        new Director(first, operation, second);
    }
}

class Director {

    Director(int first, String operation, int second) {
        if(operation.equals("+"))
            Builder.build(first, second, true, false, false, false);
        if(operation.equals("-"))
            Builder.build(first, second, false,true, false, false);
        if(operation.equals("*"))
            Builder.build(first, second, false, false, true, false);
        if(operation.equals("/"))
            Builder.build(first, second, false, false, false, true);

    }

}

class Builder{
    static void build(int first, int second, boolean addition, boolean subtraction,
                      boolean multiplication, boolean division) {
        if(addition) {
            System.out.println(first + "+" + second + "=" + (first + second));
        }
        if(subtraction) {
            System.out.println(first + "-" + second + "=" + (first - second));
        }
        if(multiplication) {
            System.out.println(first + "*" + second + "=" + (first * second));
        }
        if(division) {
            System.out.println(first + "/" + second + "=" + (first / second));
        }
    }
}