/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarManagement.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author hoangson
 */
public class BrandList extends ArrayList<Brand> {

    // Constructor
    public BrandList() {

    }

    // Take input from user
    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // Load data from file
    public boolean loadFromFile(String fileDirectory) throws FileNotFoundException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileDirectory)));
            String line;
            String arr[];
            String brandID, brandName, soundBrand;
            double price;
            while(true) {
                line = br.readLine();
                if(line == null || line.trim().length() < 4) break;
                arr = line.split(",");
                brandID = arr[0].trim();
                brandName = arr[1].trim();
                soundBrand = arr[2].trim();
                price = Double.parseDouble(arr[3].trim());
                this.add(new Brand(brandID, brandName, soundBrand, price));
            }
            System.out.println("File loaded.");
            br.close();
        } catch(FileNotFoundException fe) {
            // fe.printStackTrace();
            System.out.println(fe);
        } catch(Exception e) {
            // e.printStackTrace();
            System.out.println(e);
        }
        return true;
    }

    // Save data to file
    public boolean saveToFile(String fileName) throws IOException {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
            for(Brand iter : this) {
                pw.print(iter);
            }
            System.out.println("File saved.");
            pw.close();
        } catch(IOException ie) {
            // ie.printStackTrace();
            System.out.println(ie);
        } catch(Exception e) {
            // e.printStackTrace();
            System.out.println(e);
        }
        return true;
    }

    // Search a brand based on brand ID. Return the existence position (int)
    public int searchID(String brandID) {
        if (this.isEmpty()) {
            System.out.println("Empty list. No search can be performed");
        } else {    
            for(int i = 0; i < this.size(); ++i) {
                if(this.get(i).getBrandID().equalsIgnoreCase(brandID)) {
                    return i;
                }
            }
        }
        System.out.println("Not found.");
        return -1;
    }

    // Transform the list to a menu, the user will choose a brand from this menu
    public Brand getUserChoice() throws NumberFormatException, IOException {
        Menu mnu = new Menu();
        return (Brand) mnu.ref_getChoice(this);
    }

    // Add a new brand to the list
    public void addBrand() throws NumberFormatException, IOException {
        String brandID;
        String brandName;
        String soundBrand;
        double price;
        System.out.println("Input ID of new brand: ");
        brandID = reader.readLine();
        System.out.println("Input name of new brand: ");
        brandName = reader.readLine();
        System.out.println("Input sound of new brand: ");
        soundBrand = reader.readLine();
        System.out.println("Input price of new brand: ");
        price = Double.parseDouble(reader.readLine());
        this.add(new Brand(brandID, brandName, soundBrand, price));
        System.out.println("Brand " + brandID + " has been added.");
    }

    // Update name, sound, price of an existed brand
    public void updateBrand() throws IOException {
        if (this.isEmpty()) {
            System.out.println("Empty list. No update can be performed!");
        } else {
            String brandID;
            String brandName;
            String soundBrand;
            double price;
            System.out.println("Input ID of brand for update: ");
            brandID = reader.readLine();
            int pos = searchID(brandID);
            if(pos < 0) {
                System.out.println("Not found.");
            } else {
                System.out.println("Input new name of brand: ");
                brandName = reader.readLine();
                System.out.println("Input new sound of brand: ");
                soundBrand = reader.readLine();
                System.out.println("Input new price of brand: ");
                price = Double.parseDouble(reader.readLine());
                this.get(pos).setBrandName(brandName);
                this.get(pos).setSoundBrand(soundBrand);
                this.get(pos).setPrice(price);
                System.out.println("Brand " + brandID + " has been updated.");
            }
        }
    }

    // List all brands
    public void listBrands() {
        if(this.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            System.out.println("List of brands: ");
            for(Brand iter : this) {
                System.out.println(iter);
            }
        }
    }
}
