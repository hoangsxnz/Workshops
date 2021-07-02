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
public class StudentManager {
    public static void main(String[] args) {
        // options in menu
        String[] options = {"Add new student", "Search a student", "Update name and mark", "Remove a student", "List all","Sort decreasing","Sort increasing", "Quit"};
        int choice = 0; // user choice
        StudentList list = new StudentList(); // init empty list
        do {
            System.out.println("Student managing program");
            choice = Menu.getChoice(options);
            switch(choice) {
                case 1: list.addStudent(); break;
                case 2: list.searchStudent(); break;
                case 3: list.updateStudent(); break;
                case 4: list.removeStudent(); break;
                case 5: list.printAll(); break;
                case 6: list.sortByMarkDecreasing(); break;
                case 7: list.sortByMarkInCreasing(); break;
                default: System.out.println("Bye!");
            }
        } while(choice>0 && choice<options.length);
    }
}
