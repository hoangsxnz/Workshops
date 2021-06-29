/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extra05;

/**
 *
 * @author hoangson
 */
public class Colony extends Organization {
    protected String place;

    public Colony() {
    }

    public Colony(int size, String place) {
        super(size);
        this.place = place;
    }
    
    public void grow() {
        System.out.println("an annual cycle of growth that begins in spring");
    }
    
    public void reproduce() {
        System.out.println("colony can reproduce itself through a process");
    }
    
    @Override
    public void communicateByTool() {
        System.out.println("the colony communicate by sound");
    }

    @Override
    public String toString() {
        return "the colony's size is " + super.size + ", the colony's place is " + place;
    }
}
