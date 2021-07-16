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
public class CarList extends ArrayList<Car> {
    BrandList brandList;
    public static String frameID_format = "F\\d{5}";
    public static String engineID_format = "E\\d{5}";

    // Constructor
    public CarList(BrandList bList) {
        brandList = bList;
    }

    // Take input from user
    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // checking whether a car ID is duplicated or not
    private boolean isCarIDDuplicated(String carID) {
        carID = carID.trim();
        return searchID(carID) != -1;
    }

    // checking whether a frame ID is duplicated or not
    private boolean isFrameIDDuplicated(String frameID) {
        frameID = frameID.trim();
        return searchFrame(frameID) != -1;
    }

    // checking whether a engine ID is duplicated or not
    private boolean isEngineIDDuplicated(String engineID) {
        engineID = engineID.trim();
        return searchEngine(engineID) != -1;
    }


    // Load data from file
    public boolean loadFromFile(String fileDirectory) throws FileNotFoundException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileDirectory)));
            String line;
            String arr[];
            String carID, brandID, color, frameID, engineID;
            while(true) {
                line = br.readLine();
                if(line == null || line.trim().length() < 5) break;
                arr = line.split(",");
                carID = arr[0].trim();
                brandID = arr[1].trim();
                color = arr[2].trim();
                frameID = arr[3].trim();
                engineID = arr[4].trim();
                int pos = brandList.searchID(brandID);
                Brand b = brandList.get(pos);
                this.add(new Car(carID, b, color, frameID, engineID));
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
            for(Car iter : this) {
                pw.print(iter);
                System.out.println("\n");
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

    // Search a car based on car ID. Return the existed position (int)
    public int searchID(String carID) {
        if(this.isEmpty()) {
            System.out.println("Empty list. No ID search can be performed.");
        } else {
            System.out.print("Position of car: ");
            for(int i = 0; i < this.size(); ++i) {
                if(this.get(i).getCarID().equalsIgnoreCase(carID)) {
                    return i;
                }
            }
        }
        return -1;
    }

    // Search a car by its frame ID. Use in checking frames are not duplicated
    public int searchFrame(String frameID) {
        if(this.isEmpty()) {
            System.out.println("Empty list. No frame search can be performed.");
        } else {
            System.out.print("Position of car: ");
            for(int i = 0; i < this.size(); ++i) {
                if(this.get(i).getFrameID().equalsIgnoreCase(frameID)) {
                    return i;
                }
            }
        }
        return -1;
    }

    // Search a car by its engine ID. Use in checking engines are not duplicated
    public int searchEngine(String engineID) {
        if(this.isEmpty()) {
            System.out.println("Empty list. No engine search can be performed.");
        } else {
            System.out.print("Position of car: ");
            for(int i = 0; i < this.size(); ++i) {
                if(this.get(i).getEngineID().equalsIgnoreCase(engineID)) {
                    return i;
                }
            }
        }
        return -1;
    }

    // Add new car
    public void addCar() throws NumberFormatException, IOException {
        String carID;
        String color;
        String frameID;
        String engineID;
        do {
            System.out.println("Input new car ID: ");
            carID = reader.readLine();
            if(isCarIDDuplicated(carID) == true) {
                System.out.println("Car ID is duplicated.");
            }
        } while(isCarIDDuplicated(carID) == true);
        Menu menu = new Menu();
        Brand b = (Brand)menu.ref_getChoice(brandList);
        do {
            System.out.println("Input new color: ");
            color = reader.readLine();
        } while(color == null);

        do {
            System.out.println("Input new frame ID: ");
            frameID = reader.readLine();
            if(isFrameIDDuplicated(frameID) == true) {
                System.out.println("Frame ID is duplicated.");
            }
            if(!frameID.matches(frameID_format)) {
                System.out.println("Frame ID is not in the format F0000.");
            }
        } while((isFrameIDDuplicated(frameID) == true) || !frameID.matches(frameID_format));

        do {
            System.out.println("Input new engine ID: ");
            engineID = reader.readLine();
            if(isEngineIDDuplicated(engineID) == true) {
                System.out.println("Engine ID is duplicated.");
            }
            if(!engineID.matches(engineID_format)) {
                System.out.println("Engine ID is not in the format E0000.");
            }
        } while((isEngineIDDuplicated(engineID) == true) || !engineID.matches(engineID_format));

        this.add(new Car(carID, b, color, frameID, engineID));
        System.out.println("New car has been added.");
    }

    // Print based on brand name
    public void printBasedBrandName() throws IOException {
        if(this.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            String aPartOfBrandName;
            System.out.println("Input a part of brand name: ");
            aPartOfBrandName = reader.readLine();
            int count = 0;
            for(Car iter : this) {
                if(iter.getBrand().getBrandName().contains(aPartOfBrandName)) {
                    System.out.println(iter.screenString());
                    ++count;
                }
            }
            if(count == 0) {
                System.out.println("No car is detected.");
            }
        }
    }

    // Remove a car based on its ID
    public boolean removeCar() throws IOException {
        if(this.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            String removeID;
            System.out.println("Input car ID for remove: ");
            removeID = reader.readLine();
            int pos = this.searchID(removeID);
            if(pos < 0) {
                System.out.println("Not found.");
                return false;
            } else {
                this.remove(pos);
            }
        }
        return true;
    }

    // Update a car based on its ID
    public boolean updateCar() throws IOException {
        if(this.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            String updateID;
            String color;
            String frameID;
            String engineID;
            System.out.println("Input car ID for update: ");
            updateID = reader.readLine();
            int pos = this.searchID(updateID);
            if(pos < 0) {
                System.out.println("Not found.");
                return false;
            } else {
                Menu menu = new Menu();
                Brand b = (Brand)menu.ref_getChoice(brandList);
                do {
                    System.out.println("Input new color: ");
                    color = reader.readLine();
                } while(color == null);
        
                do {
                    System.out.println("Input new frame ID: ");
                    frameID = reader.readLine();
                    if(isFrameIDDuplicated(frameID) == true) {
                        System.out.println("Frame ID is duplicated.");
                    }
                    if(!frameID.matches(frameID_format)) {
                        System.out.println("Frame ID is not in the format F0000.");
                    }
                } while((isFrameIDDuplicated(frameID) == true) || !frameID.matches(frameID_format));
        
                do {
                    System.out.println("Input new engine ID: ");
                    engineID = reader.readLine();
                    if(isEngineIDDuplicated(engineID) == true) {
                        System.out.println("Engine ID is duplicated.");
                    }
                    if(!engineID.matches(engineID_format)) {
                        System.out.println("Engine ID is not in the format E0000.");
                    }
                } while((isEngineIDDuplicated(engineID) == true) || !engineID.matches(engineID_format));
        
                this.get(pos).setBrand(b);
                this.get(pos).setColor(color);
                this.get(pos).setFrameID(frameID);
                this.get(pos).setEngineID(engineID);
            }
        }
        return true;
    }

    // Listing cars in ascending order of brand names
    public void listCars() {
        if(this.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            Collections.sort(this);
            for(Car iter : this) {
                System.out.println(iter);
            }
        }
    }
}
