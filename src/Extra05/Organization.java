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
public abstract class Organization {
    protected int size;

    public Organization() {
    }

    public Organization(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public abstract void communicateByTool();

    @Override
    public String toString() {
        return "the organization's size is" + size;
    }
}
