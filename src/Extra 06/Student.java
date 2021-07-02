/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extra06;

/**
 *
 * @author hoangson
 */
public class Student implements Comparable<Student> {
    String code = "";
    String name = "";
    int mark = 0;

    public Student() {
    }
    
    public Student(String code, String name, int mark) {
        this.code = code.toUpperCase();
        this.name = name.toUpperCase();
        this.mark = (mark>=0 && mark<=10)? mark : 0;
    }
    // Get data as a string for printing
    @Override
    public String toString() {
        return code + ", " + name + ", " + mark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.trim().toUpperCase();
        if(name.length()>0) {
            this.name = name; // check validity
        }
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        if(mark>=0 && mark<=10) {
            this.mark = mark; // check validity
        }
    }

    @Override
    public int compareTo(Student t) {
        return -(this.getMark() - t.getMark());
    }
}
