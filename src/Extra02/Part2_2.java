/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extra02;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hoangson
 */
public class Part2_2 {
    public String inputString() throws Exception {
        String regex = "^\\(\\+\\d{2}\\)\\d{9}$";
        String s = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the string: ");
        s = sc.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if(!matcher.find()) {
            throw new Exception();
        }
        return s;
    }
    
    public static void main(String[] args) {
        Part2_2 obj = new Part2_2();
        boolean cont = false;
        do {
            try {
                String s = obj.inputString();
                System.out.println("The string is " + s);
                cont = false;
            } catch(Exception e) {
                System.out.println("The string is invalid");
                cont = true;
            }
        } while(cont);
    }
}
