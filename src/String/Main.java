/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringWS;

/**
 *
 * @author hoangson
 */
public class Main {
    public static void main(String[] args) {
        Func st = new Func("hello you are you end");
        System.out.println(st.contain("me"));
        System.out.println(st.contain("why"));
        System.out.println(st.contain("well"));
        System.out.println(st.countYou());
        System.out.println(st.replaceUpper());
        System.out.println(st.replaceLowUp());
        st.displayArr();
        System.out.print("\n");
        st.removeChar("l");
        System.out.println(st.countWord());
        st.displayLetters();
        System.out.print("\n");
        System.out.println(st.reverseString());
        System.out.println(st.replaceAB());
        System.out.println(st.countUpper());
    }
}
