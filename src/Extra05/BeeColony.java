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
public class BeeColony extends Colony implements Role {
    String type;

    public BeeColony() {
    }

    public BeeColony(int size, String place, String type) {
        super(size, place);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }
    
    
    @Override
    public void createWorker() {
        System.out.println("worker bees perform all the work of the bees");
    }

    @Override
    public String toString() {
        return "the colony type's is " + type + ", size is about " + size + ", and the place is " + place;
    }
}
