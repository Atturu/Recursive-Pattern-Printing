
import java.util.Scanner;

public class RecursivePatternPrinting {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter a positive odd number(min 3): ");
            int end = input.nextInt();
            if (end < 3 && end % 2 == 0) {
                System.out.println("You didn't enter a positive odd number!");
                System.exit(0);
            }
            System.out.print("Enter any char to create your pattern: ");
            char ch = input.next().charAt(0);
            int p = 1, start = 1;
            // p is the pointer, start is the first postion X, and end is last postion of X
            printX1(p, start, end, ch);
        } catch (Exception e) {
            System.out.println("Wrong input!");
        }
    }

    public static void printX1(int p, int start, int end, char ch) {
        if (p == start) {
            // middle point, turning point
            if (start == end) {
                System.out.println(ch);
                //start printing other half of pattern
                printX2(1, start - 1, end + 1, ch);
                return;//finished pattern
            }
            System.out.print(ch);
            //print X and continue on same line
            printX1(p + 1, start, end, ch);
        } else if (p == end) {
            System.out.println(ch);
            //go to next line, reset p and increment start, and decrement end by 1
            printX1(1, start + 1, end - 1, ch);
        } else {
            System.out.print(" ");
            //print space and continue on same line
            printX1(p + 1, start, end, ch);
        }
    }

    public static void printX2(int p, int start, int end, char ch) {
        // to stop
        if (start < 1) {
            return;
        }
        if (p == start) {
            System.out.print(ch);
            //print X and continue on same line
            printX2(p + 1, start, end, ch);
        } else if (p == end) {
            System.out.println(ch);
            //go to next line, reset p and decrement start, and increment end by 1
            printX2(1, start - 1, end + 1, ch);
        } else {
            System.out.print(" ");
            //print space and continue on same line
            printX2(p + 1, start, end, ch);
        }
    }
}
