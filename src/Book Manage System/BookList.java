package BookManageSystem.src;    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author hoangson
 */
public class BookList extends ArrayList<Book> {

    // Constructor
    public BookList() {

    }

    // Take input
    // public static Scanner sc = new Scanner(System.in);
    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // checking whether a code is duplicated or not
    private boolean isCodeDuplicated(String code) {
        code = code.trim().toUpperCase();
        return search(code) != null;
    }

    // Input & add book(s) to the end
    public void input() throws IOException {
        String newCode;
        String newTitle;
        int newQuantity;
        double newPrice;
        boolean codeDuplicated = false;
        do {
            System.out.println("Input code of the new book(s): ");
            newCode = reader.readLine();
            newCode = newCode.trim().toUpperCase();
            codeDuplicated = isCodeDuplicated(newCode); // check code duplication
            if (codeDuplicated == true) {
                System.out.println("Code is duplicated!");
            }
        } while (codeDuplicated == true);
        System.out.println("Input title of the new book(s): ");
        newTitle = reader.readLine();
        System.out.println("Input quantity of books: ");
        newQuantity = Integer.parseInt(reader.readLine());
        System.out.println("Input price of the new book(s): ");
        newPrice = Double.parseDouble(reader.readLine());
        Book b = new Book(newCode, newTitle, newQuantity, newPrice);
        this.add(b);
        System.out.println("Book " + newCode + " has been added.");
    }

    // Display all books in format (code, title, quantity, price)
    public void display() {
        if (this.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            System.out.println("Book list: ");
            for (Book iter : this) {
                System.out.println(iter);
            }
        }
    }

    // search a Book based on Book's code. return the Book found
    public Book search(String code) {
        code = code.trim().toUpperCase();
        for (int i = 0; i < this.size(); ++i) {
            if (this.get(i).getCode().equals(code)) {
                return this.get(i); // Book found
            }
        }
        return null; // Book not found
    }

    // Search a book for given code
    public void searchBook() throws IOException {
        if (this.isEmpty()) {
            System.out.println("Empty list. No search can be performed");
        } else {
            System.out.print("Input book code for search: ");
            String searchCode = reader.readLine();
            Book b = this.search(searchCode); // search book based on code
            if (b == null) {
                System.out.println("Book " + searchCode + " doesn't exist!");
            } else {
                System.out.println("Found: " + b);
            }
        }
    }

    // Update the book's price for given code
    public void updateBook() throws IOException {
        if (this.isEmpty()) {
            System.out.println("Empty lít. No update can be performed!");
        } else {
            System.out.println("Input book code for update: ");
            String updateCode = reader.readLine();
            Book b = this.search(updateCode); // search for book code
            if (b == null) {
                System.out.println("Book " + updateCode + " doesn't exist!");
            } else {
                // update book's price
                double oldPrice = b.getPrice();
                System.out.println("Old price: " + oldPrice);
                System.out.print("New price: ");
                double newPrice = Double.parseDouble(reader.readLine());
                b.setPrice(newPrice);
                System.out.println("Book " + updateCode + " has been update price!");
            }
        }
    }

    // Find the (first) max price value
    public void findMax() {
        Book maxPrice = Collections.max(this, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        System.out.println("Max price value: " + maxPrice.getPrice());
    }

    // Sort the list ascendingly by code
    public void sortByCode() {
        Collections.sort(this, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getCode().compareTo(o2.getCode());
            }
        });
        for (Book iter : this) {
            System.out.println(iter);
        }
    }

    // Remove the book having given code
    public void removeBook() throws IOException {
        if (this.isEmpty()) {
            System.out.println("Empty list. No remove can be performed!");
        } else {
            System.out.print("Input book code for remove: ");
            String removeCode = reader.readLine();
            Book b = this.search(removeCode);
            if (b == null) {
                System.out.println("Book " + removeCode + " doesn't exist!");
            } else {
                this.remove(b);
                System.out.println("Book " + removeCode + " has been removed!");
            }
        }
    }

    // Load data from file
    public void loadFile() throws IOException {
        String fileDirectory;
        System.out.print("Input file directory: ");
        fileDirectory = reader.readLine();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileDirectory));
            String line;
            String[] arr;
            String code;
            String title;
            int quantity;
            double price;
            while (true) {
                line = br.readLine();
                if (line == null || line.trim().length() < 4)
                    break;
                arr = line.split(" ");
                code = arr[0].trim();
                title = arr[1].trim();
                quantity = Integer.parseInt(arr[2].trim());
                price = Double.parseDouble(arr[3].trim());
                add(new Book(code, title, quantity, price));
            }
            br.close();
        } catch (IOException ie) {
            // ie.printStackTrace();
            System.out.println(ie);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(e);
        }
    }
}
