import java.util.Scanner;

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

        System.out.println(first + operation + second + "=" + MainHandler.calculate(first, operation, second));
    }
}

class MainHandler{
    static int calculate(int first, String operation, int second) {
        return AdditionHandler.calculate(first, operation, second);
    }
}

class AdditionHandler{

    static int calculate(int first, String operation, int second) {
        if(operation.equals("+")) {
            return SubtractionHandler.calculate(first, operation, second, first+second);
        }
        return SubtractionHandler.calculate(first, operation, second, 0);
    }

}

class SubtractionHandler{

    static int calculate(int first, String operation, int second, int result) {
        if(operation.equals("-") && result==0) {
            return MultiplicationHandler.calculate(first, operation, second, first-second);
        }
        return MultiplicationHandler.calculate(first, operation, second, 0);
    }

}

class MultiplicationHandler{

    static int calculate(int first, String operation, int second, int result) {
        if(operation.equals("*") && result==0) {
            return DivisionHandler.calculate(first, operation, second, first*second);
        }
        return DivisionHandler.calculate(first, operation, second, 0);
    }

}

class DivisionHandler{

    static int calculate(int first, String operation, int second, int result) {
        if(operation.equals("/") && result==0) {
            return first/second;
        }
        return result;
    }

}



