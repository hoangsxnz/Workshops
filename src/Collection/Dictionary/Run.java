/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection.q3;

import java.util.Scanner;

/**
 *
 * @author hoangson
 */
public class Run {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();
        String word;
        do{
            System.out.print("Enter the word: ");
            word = scanner.nextLine();
            if (word.isEmpty()) {
                break;
            }else{
                System.out.println("Meaning: " + dictionary.lookup(word));
            }
        } while(true);
    }
}
