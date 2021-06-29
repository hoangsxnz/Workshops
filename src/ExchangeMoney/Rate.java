/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExchangeMoney;

/**
 *
 * @author hoangson
 */
public class Rate {

    String CODE1;
    String CODE2;
    private String rate;

    public Rate() {
        
    }

    public Rate(String CODE1, String CODE2) {
        this.CODE1 = CODE1;
        this.CODE2 = CODE2;
    }
    
    public Rate(String CODE1, String CODE2, String rate) {
        this.CODE1 = CODE1;
        this.CODE2 = CODE2;
        this.rate = rate;
    }

    public String getCODE1() {
        return CODE1;
    }

    public void setCODE1(String CODE1) {
        this.CODE1 = CODE1;
    }

    public String getCODE2() {
        return CODE2;
    }

    public void setCODE2(String CODE2) {
        this.CODE2 = CODE2;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
