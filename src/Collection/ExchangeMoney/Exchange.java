/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection.q1;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author hoangson
 */
public class Exchange extends Rate {

    private double amount;

    Exchange(String c1, String c2, double amount) {
        super(c1, c2);
        this.amount = amount;
    }

    public void convert(String code1, String code2, double amount) {
        ArrayList<String> currency = new ArrayList<String>();
        Rate[] rates = new Rate[5];
        currency.add("USD;VND;17000");
        currency.add("EUR;USD;1.2");
        currency.add("USD;IDN;15789");
        currency.add("USD;EUR;0.83");
        currency.add("CAD;IDN;16869");
        for (int i = 0; i < currency.size(); ++i) {
            StringTokenizer st = new StringTokenizer(currency.get(i), ";");
            rates[i] = new Rate();
            rates[i].setCODE1(st.nextToken());
            rates[i].setCODE2(st.nextToken());
            rates[i].setRate(st.nextToken());
        }
        for (int i = 0; i < rates.length; ++i) {
            if (code1.equals(rates[i].getCODE1()) && code2.equals(rates[i].getCODE2())) {
                double r = Double.parseDouble(rates[i].getRate());
                System.out.println(amount * r);
            }
        }
    }
}
