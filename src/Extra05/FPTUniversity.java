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
public class FPTUniversity extends University implements Role {
    String address;

    public FPTUniversity() {
    }

    public FPTUniversity(int size, String name, String address) {
        super(size, name);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public String toString() {
        return "FPTU has five campuses HaNoi, HCM, DaNang, CanTho, QuyNhon";
    }
    
    @Override
    public void createWorker() {
        System.out.println("providing human resources");
    }
}
