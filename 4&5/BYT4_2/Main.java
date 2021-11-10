import java.util.Scanner;

//TASK - Example of handling different behaviors depending on state, using the state pattern.

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

        Context.calculate(first, operation, second);
    }
}

class Context{
    static void calculate(int first, String operation, int second) {
        Calculation calculation= new Calculation(first, operation, second);
        if(calculation.getState() != State.DONE)
            calculation.calculate();
    }
}

enum State{
    TOBEDONE,
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
    DONE
}

class Calculation {
    private State state = State.TOBEDONE;
    int first;
    int second;

    Calculation(int first, String operation, int second) {
        this.first = first;
        this.second = second;
        if(operation.equals("+"))
            state = State.ADD;
        if(operation.equals("-"))
            state = State.SUBTRACT;
        if(operation.equals("*"))
            state = State.MULTIPLY;
        if(operation.equals("/"))
            state = State.DIVIDE;
    }

    public State getState() {
        return state;
    }

    void calculate() {
        if(state==State.ADD) {
            System.out.println(first + "+" + second + "=" + (first + second));
            state = State.DONE;
        }
        if(state==State.SUBTRACT) {
            System.out.println(first + "-" + second + "=" + (first - second));
            state = State.DONE;
        }
        if(state==State.MULTIPLY) {
            System.out.println(first + "*" + second + "=" + (first * second));
            state = State.DONE;
        }
        if(state==State.DIVIDE) {
            System.out.println(first + "/" + second + "=" + (first / second));
            state = State.DONE;
        }
    }
}