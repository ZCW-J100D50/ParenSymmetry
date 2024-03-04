package src.main.java;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ParenSymmetry {


    private Boolean isBalanced(String s) {
        int numberOpen = 0;
        int numberClosed = 0;
        for(int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                numberOpen++;
            }
            if (s.charAt(i) == ')') {
                numberClosed++;
            }
        }
            if(numberOpen==numberClosed && numberOpen >0)
                return true;
            else
                return false;

    }

    private void checkFile(String filename) {
        // open file named filename
        try
        {
            Scanner s = new Scanner( new File(filename) );
            while( s.hasNextLine() )
            {
                System.out.println( isBalanced(s.nextLine() ));
            }
        }
        catch(IOException e)
        {	System.out.println( e );
        }
        // for each line in the file
            // read the line
            // print whether or not the line's parenthesis are balanced

        // CLOSE the file
    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);


        System.out.println("TestStrings0.txt");
        ps.checkFile("TestStrings0.txt");

        System.out.println("TestStrings1.txt");
        ps.checkFile("TestStrings1.txt");

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
