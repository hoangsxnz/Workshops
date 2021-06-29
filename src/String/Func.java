/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringWS;

import com.sun.xml.internal.ws.util.StringUtils;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author hoangson
 */
public class Func {
    private String str;

    public Func(String str) {
        this.str = str;
    }

    public boolean contain(String sequence) {
        return str.contains(sequence);
    }
    
    public int countYou() {
        return str.split("you", 0).length - 1;
    }
    
    public String replaceUpper() {
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String arr1 : arr) {
            sb.append(Character.toUpperCase(arr1.charAt(0)));
            sb.append(arr1.substring(1));
            sb.append(" ");
        }          
        return sb.toString().trim();
    }
    
    public String replaceLowUp() {
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String arr1 : arr) {
            sb.append(Character.toLowerCase(arr1.charAt(0)));
            sb.append(arr1.substring(1, arr1.length()-1));
            sb.append(Character.toUpperCase(arr1.charAt(arr1.length()-1)));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    
    public void displayArr() {
        String[] words = str.split(" ");
        Arrays.sort(words);
        for(String word : words) {
                System.out.print(word + " ");
        }
    }
    
    public void removeChar(String c) {
        StringBuilder sb = new StringBuilder(str);
        if(str.contains(c)) {
            sb.deleteCharAt(str.indexOf(c));
        }
        System.out.println(sb.toString());
    }
    
    public int countWord() {
        String[] words = str.split(" ");
        return words.length;
    }
    
    public void displayLetters() {
        String[] letters = str.split("");
        for(String letter : letters) {
            if(!" ".equals(letter))
                System.out.print(letter + " ");
        }
    }
    
    public String reverseString() {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }
    
    public String replaceAB() {
        String str1 = str.replace('a', 'A');
        String str2 = str1.replace('b', 'B');
        return str2;
    }
    
    public int countUpper() {
        int countUpper = 0;
        for(int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if(ch >= 'A' && ch <= 'Z') {
                countUpper++;
            }
        }
        return countUpper;
    }
}
