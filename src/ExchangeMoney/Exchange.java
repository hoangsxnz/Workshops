/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExchangeMoney;

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
        String[] currency = new String[5];
        Rate[] rates = new Rate[5];
        currency[0] = "USD;VND;17000";
        currency[1] = "EUR;USD;1.2";
        currency[2] = "USD;IDN;15789";
        currency[3] = "USD;EUR;0.83";
        currency[4] = "CAD;IDN;16869";
        for (int i = 0; i < currency.length; ++i) {
            StringTokenizer st = new StringTokenizer(currency[i], ";");
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
