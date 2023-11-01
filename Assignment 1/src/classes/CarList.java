/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.*;
import java.lang.*;

public class CarList {
    private ArrayList<Car> carList;
    public CarList() {
        carList = new ArrayList<Car>(); 
    }

   
//    public String toString()
//    public String screenString()
//    public boolean loadFromFile(String filename)
//    public boolean saveToFile(String)
//Done    public int searchID(String cardID)
//Done    public int searchFrame(String fID)
//Done    public int searchEngine(String eID)
//    public void addCar()
//    public void printBaseBrandName()        
//    public boolean removeCar()
//    public boolean updateCar()        
//    public void listCars()        
                                                
     public int searchID (String carID) {
        for (int i = 0; i < carList.size(); i++) {
            if (carID.equals(carList.get(i).getCarID())) {
                return i;
            }
        }
        return -1;
    }
    
    private int searchEngineID(String searchEngineID) {
        for (int i = 0; i < carList.size(); i++) {
            if (searchEngineID.equals(carList.get(i).getEngineID())) {
                return i;
            }
        }
        return -1;
    }

    private int searchFrameID(String searchFrameID) {
        for (int i = 0; i < carList.size(); i++) {
            if (searchFrameID.equals(carList.get(i).getFrameID())) {
                return i;
            }
        }
        return -1;
    }
    
    public void addCar(BrandList listBrand){
        String carID = Inputer.inputString("Enter Car ID: ");
        boolean index = searchID(carID);
        if (index) {
            Brand newBrand = listBrand.getUserChoice();
            String color = Inputer.inputString("Enter color: ");
            String frameID = Inputer.inputPattern("Enter frameID: ", "F0000");
            String engineID = Inputer.inputPattern("Enter engineID: ", "E0000");
        }
    }

   // public void addCar() {
        
  //  }
    
    public boolean removeCar() {
        String removedID;
        int pos;
        removedID = Inputer.inputString("Input car ID to removed: ");
        pos = searchID(removedID);
        if (pos >= 0) {
            carList.remove(pos);
            return true;
        } else {
            System.out.println("Not found carID");
        }
        return false;
    }

     public void listCars () {
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i).toString());
        }
        System.out.println("-----------------------------------------------");
    }

    
    public void printBasedBrandName(){
        String name = Inputer.inputString("Enter a part of brand name: ");
        int count =0;
        for (int i = 0; i <carList.size() ; i++) {
            Car c = carList.get(i);
            if (c.getBrand().getBrandID().contains(name)) {
                System.out.println(c);
                count++;
            }
        }
        if (count==0) {
            System.out.println("No car is detected.");
        }
    }
    
    
}
