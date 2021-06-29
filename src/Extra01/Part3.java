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
public class Part3 {
    public String chuanHoa(String str) {
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        return str;
    }
 
    public String chuanHoaTen(String str) {
        str = chuanHoa(str);
        String temp[] = str.split(" ");
        str = "";
        for (int i = 0; i < temp.length; i++) {
            str += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1)
                str += " ";
        }
        return str;
    }

    public static void main(String[] args) {
        String[] list = new String[10];
        for (int i = 0; i < 10; i++) {
            Scanner sc = new Scanner(System.in);
            list[i] = sc.nextLine();
        }
        for(String name:list) {
            Part3 obj = new Part3();
            name = obj.chuanHoaTen(name);
            System.out.println(name);
        }
    }
}
