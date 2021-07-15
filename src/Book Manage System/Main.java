package BookManageSystem.src;    

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BookList list = new BookList();
        String[] options = {"1. Input & add book(s) to the end",
                            "2. Display all books",
                            "3. Search a book for given code",
                            "4. Update the book's price for given code",
                            "5. Find the (first) max price value",
                            "6. Sort the list ascendingly by code",
                            "7. Remove the book having given code",
                            "8. Load data from file",
                            "0. Exit"};
        for(String option : options) {
            System.out.println(option);
        }
        int choice = -1;
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            choice = Integer.parseInt(reader.readLine());
            // sc.nextLine(); // consume the newline '\n' left-over
            switch(choice) {
                case 1: list.input(); break;
                case 2: list.display(); break;
                case 3: list.searchBook(); break;
                case 4: list.updateBook(); break;
                case 5: list.findMax(); break;
                case 6: list.sortByCode(); break;
                case 7: list.removeBook(); break;
                case 8: list.loadFile(); break;
                default: System.out.println("Exit program.");
            }
        } while(choice >= 1 && choice <= 8);
    }
}
