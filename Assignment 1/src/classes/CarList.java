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
//Done    public boolean searchID(String cardID)
//    public boolean searchFrame(String fID)
//    public boolean searchEngine(String eID)
//    public void addCar()
//    public void printBaseBrandName()        
//    public boolean removeCar()
//    public boolean updateCar()        
//    public void listCars()        
                                                
    public boolean searchID(String carID) {
        for (int i = 0; i < carList.size() - 1; i++) {
            if (carList.get(i).getCarID().equals(carID)) {
                return true;
            }
        }
        return false;
    }                    
    
    public boolean searchFrame(String frameID) {
        for (int i = 0; i < carList.size() - 1; i++) {
            if (carList.get(i).getFrameID().equals(frameID)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean searchEngine(String engineID) {
        for (int i = 0; i < carList.size() - 1; i++) {
            if (carList.get(i).getEngineID().equals(engineID)) {
                return true;
            }
        }
        return false;
    }
    
    public void addCar(BrandList listBrand){
        String carID = Inputer.inputString("Enter Car ID: ");
        boolean index = searchID(carID);
        if (index) {
            Brand newBrand = listBrand.getUserChoice();
            String color = Inputer.inputString("Enter color: ");
            String frameID = Inputer.inputPattern("Enter frameID: ", "F0000");
            String engineID = Inputer.inputPattern("Enter engineID: ", "E0000");
            
            Car car = new Car(carID, newBrand, color, frameID, engineID);
            carList.add(car);
            System.out.println("Brand added successfully.");
        }else{
            System.out.println("Car with the same ID is existed.");
        }
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
