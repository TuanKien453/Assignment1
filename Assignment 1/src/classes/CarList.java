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
            return false;
    }
        
    public void addCar() {
        
    }
}
