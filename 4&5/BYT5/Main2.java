import java.util.Scanner;

//TASK - Example of the builder method pattern 2

public class Main2 {

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What animal is it?");

        System.out.println("Enter number of legs");
        int legs = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Does it swim? (yes or no)");
        String doesItSwim = scanner.nextLine();

        new Director(legs, doesItSwim);
    }
}

class Director {

    Director(int legs, String doesItSwim) {
        boolean zeroLegs = false, twoLegs = false, fourLegs = false, sixLegs = false,
                eightLegs = false, moreLegs = false, swim = false;

        if(legs==0)
            zeroLegs = true;
        if(legs==2)
            twoLegs = true;
        if(legs==4)
            fourLegs = true;
        if(legs==6)
            sixLegs = true;
        if(legs==8)
            eightLegs= true;
        if(legs>8)
            moreLegs = true;

        if(doesItSwim.equals("yes"))
            swim = true;

        Builder.build(zeroLegs,twoLegs,fourLegs,sixLegs,eightLegs,moreLegs,swim);
    }

}

class Builder{
    static void build(boolean zeroLegs, boolean twoLegs, boolean fourLegs, boolean sixLegs,
                      boolean eightLegs, boolean moreLegs, boolean swim) {
        if(zeroLegs) {
            if(swim) {
                System.out.println("It's probably a fish.");
            } else {
                System.out.println("It's probably a snake.");
            }
        }
        if(twoLegs) {
            if(swim) {
                System.out.println("It's probably a duck.");
            } else {
                System.out.println("It's probably a bird.");
            }
        }
        if(fourLegs) {
            if(swim) {
                System.out.println("It's probably a dog.");
            } else {
                System.out.println("It's probably a cat.");
            }
        }
        if(sixLegs) {
            if(swim) {
                System.out.println("It's probably a bug.");
            } else {
                System.out.println("It's probably a bug.");
            }
        }
        if(eightLegs) {
            if(swim) {
                System.out.println("It's probably a swimming spider.");
            } else {
                System.out.println("It's probably a spider.");
            }
        }
        if(moreLegs) {
            if(swim) {
                System.out.println("It's probably something creepy.");
            } else {
                System.out.println("It's probably a woodlouse.");
            }
        }
    }
}