/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection.q3;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author hoangson
 * 
 */
public class Dictionary extends Hashtable<String, String> {


    public Dictionary() {
        this.put("apple","qua tao");
        this.put("ball","qua bong");
        this.put("cat","con meo");
        this.put("dog","con cho");
        this.put("elephant","con voi");
        this.put("fish","con ca");
        this.put("gift","mon qua");
        this.put("home","nha");
    }

    public String lookup(String word) {
        Enumeration<String> enumerations = this.keys();
        while (enumerations.hasMoreElements()) {
            String nextElement = enumerations.nextElement();
            if(nextElement.equalsIgnoreCase(word)){
                return this.get(nextElement);
            }
        }
        return "not found";
    }
}
