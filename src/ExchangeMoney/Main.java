/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExchangeMoney;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author hoangson
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first currency code: ");
        String code1 = sc.nextLine();
        System.out.print("Enter the second currency code: ");
        String code2 = sc.nextLine();
        System.out.print("Enter the amount of first currency: ");
        double amount = sc.nextDouble();
        Exchange userInput = new Exchange(code1, code2, amount);
        System.out.print("The amount after converted: ");
        userInput.convert(code1, code2, amount);
    }
}
