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
public class Menu {
    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public int int_getChoice(BrandList brandList) throws NumberFormatException, IOException {
        int response;
        int n  = brandList.size();
        for(int i = 0; i < n; ++i) {
            System.out.println("" + (i+1) + brandList.get(i));
        }
        System.out.print("Please choose an option 1..n: ");
        response = Integer.parseInt(reader.readLine());
        return response;
    }

    public int int_getChoice(CarList carList) throws NumberFormatException, IOException {
        int response;
        int n  = carList.size();
        for(int i = 0; i < n; ++i) {
            System.out.println("" + (i+1) + carList.get(i));
        }
        System.out.print("Please choose an option 1..n: ");
        response = Integer.parseInt(reader.readLine());
        return response;
    }

    public Brand ref_getChoice(BrandList brandList) throws NumberFormatException, IOException {
        int response;
        int n = brandList.size();
        do {
            response = int_getChoice(brandList);
        } while(response < 0 || response > n);
        return brandList.get(response-1);
    }

    public Car ref_getChoice(CarList carList) throws NumberFormatException, IOException {
        int response;
        int n = carList.size();
        do {
            response = int_getChoice(carList);
        } while(response < 0 || response > n);
        return carList.get(response-1);
    }
}
