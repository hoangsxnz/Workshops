/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarManagement.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author hoangson
 */
public class CarManager {
    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] options = {"1. List all brands",
                            "2. Add a new brand",
                            "3. Search a brand based on its ID",
                            "4. Update a brand",
                            "5. Save brands to the file, named brands.txt",
                            "6. List all cars in ascending order of brand names",
                            "7. List all cars based on a part of an input brand name",
                            "8. Add a car",
                            "9. Remove a car based on its ID",
                            "10. Update a car based on its ID",
                            "11. Save cars to file, named cars.txt",
                            "0. Exit"};
        for(String option : options) {
            System.out.println(option);
        }

        BrandList brandList = new BrandList();
        brandList.loadFromFile("C:\\Users\\ADMIN\\Desktop\\Code\\Java\\src\\CarManagement\\src\\brands.txt");
        CarList carList = new CarList(brandList);
        carList.loadFromFile("C:\\Users\\ADMIN\\Desktop\\Code\\Java\\src\\CarManagement\\src\\cars.txt");
        
        int choice = -1;
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            choice = Integer.parseInt(reader.readLine());
            switch(choice) {
                case 1: brandList.listBrands(); break;
                case 2: brandList.addBrand(); break;
                case 3: String brandID = reader.readLine(); brandList.searchID(brandID); break;
                case 4: brandList.updateBrand(); break;
                case 5: brandList.saveToFile("C:\\Users\\ADMIN\\Desktop\\Code\\Java\\src\\CarManagement\\src\\brands.txt"); break;
                case 6: carList.listCars(); break;
                case 7: carList.printBasedBrandName(); break;
                case 8: carList.addCar(); break;
                case 9: carList.removeCar(); break;
                case 10: carList.updateCar(); break;
                case 11: carList.saveToFile("C:\\Users\\ADMIN\\Desktop\\Code\\Java\\src\\CarManagement\\src\\cars.txt"); break;
                default: System.out.println("Exit program.");
            }
        } while(choice >=1 && choice <= 11);
    }
}
