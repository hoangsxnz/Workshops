package BookManageSystem.src;    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoangson
 */
public class Book {
    private String code;
    private String title;
    private int quantity;
    private double price;
    
    public Book() {
    }

    public Book(String code, String title, int quantity, double price) {
        this.code = code;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "(" + code + ", " + title + ", " + quantity + ", " + price + ")";
    }
}
