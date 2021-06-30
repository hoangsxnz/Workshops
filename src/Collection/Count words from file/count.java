/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author hoangson
 */
public class q2 {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        Scanner file = new Scanner(new File("C:\\Users\\ADMIN\\Desktop\\Code\\Java\\src\\Collection\\stringArray.txt"));
        while(file.hasNextLine()) {
            String line = file.nextLine();
            for(String word : line.split(" ")) {
                if(!wordCount.containsKey(word)) {
                    wordCount.put(word,1);
                } else {
                    wordCount.put(word, wordCount.get(word)+1);
                }
            }
        }
        for(String word: wordCount.keySet()) {
            System.out.println(word + ": " + wordCount.get(word));
        }
    }
}
