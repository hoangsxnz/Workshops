/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extra02;

import java.util.Scanner;

/**
 *
 * @author hoangson
 */
public class Part2 {

    public static void main(String[] args) {
        boolean cont = false;
        do {
            try {
                String s = "";
                String regex = "^SE\\d{3}$";
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the string: ");
                s = sc.next();
                if (!s.matches(regex)) {
                    throw new Exception();
                }
                System.out.println("The string is: " + s);
                cont = false;
            } catch (Exception e) {
                System.out.println("The string is invalid");
                cont = true;
            }
        } while (cont);
    }

}
