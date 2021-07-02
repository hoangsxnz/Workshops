/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extra06;

// Class for inputting data using constraints
import java.util.Scanner;

/**
 *
 * @author hoangson
 */
public class Inputter {
    public static Scanner sc = new Scanner(System.in);
    // Get an integer between min...max
    public static int inputInt(String msg, int min, int max) {
        if(min > max) {
            int t = min;
            min = max;
            max = t;
        }
        int data;
        do {
            System.out.print(msg);
            data = Integer.parseInt(sc.nextLine());
        } while(data<min || data>max);
        return data;
    }
    // Get a string with no condition
    public static String inputStr(String msg) {
        System.out.print(msg);
        String data = sc.nextLine().trim();
        return data;
    }
    // Get a non-blank string
    public static String inputNonBlankStr(String msg) {
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
        } while(data.length()==0);
        return data;
    }
    // Get a string following a pattern
    public static String inputPattern(String msg, String pattern) {
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
        } while(!data.matches((pattern)));
        return data;
    }
}
