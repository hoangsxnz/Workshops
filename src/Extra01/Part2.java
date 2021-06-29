/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extra01;

import java.util.Scanner;

/**
 *
 * @author hoangson
 */
public class Part2 {

    public static void main(String[] args) {
        float num1, num2;
        String op;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the number 1: ");
        num1 = sc.nextFloat();
        System.out.print("Input the number 2: ");
        num2 = sc.nextFloat();
        System.out.print("Input the operator: ");
        sc = new Scanner(System.in);
        op = sc.nextLine();
        switch (op) {
            case ("+"):
                System.out.println("The result of " + num1 + op + num2 + "=" + (num1 + num2));
                break;
            case ("-"):
                System.out.println("The result of " + num1 + op + num2 + "=" + (num1 - num2));
                break;
            case ("*"):
                System.out.println("The result of " + num1 + op + num2 + "=" + (num1 * num2));
                break;
            case ("/"):
                System.out.println("The result of " + num1 + op + num2 + "=" + (num1 / num2));
                break;
            default:
                break;
        }
    }
}
