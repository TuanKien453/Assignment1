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
    public boolean saveToFile(String filename){
        boolean result = false;
        // clear all car in file
        FileIO.writeFile(filename, "");
        for(int i = 0; i<carList.size(); i++){
            String carData = carList.get(i).getCarID() + "|" + carList.get(i).getBrand().getBrandID() + "|";
            carData += carList.get(i).getColor() + "|" + carList.get(i).getEngineID() + "|" + carList.get(i).getFrameID() + "\n";
            result = FileIO.appendToFile(filename, carData);
        }
        return result;
    }
    
    public boolean loadFromFile (String filename, BrandList bl ){
        String Data = FileIO.readFile(filename);
        String arr[] = Data.split("\n");
        // clear all car in car list
        carList.removeAll(carList);
        for(int i = 0; i<arr.length; i++){
            String carData[] = arr[i].split("\\|");
            Brand br=bl.getBrands(carData[1]);
            Car car = new Car(carData[0], br, carData[2], carData[3], carData[4]);
            
        }
    }

//    public boolean loadFromFile(String filename)
//Done    public boolean saveToFile(String)
//Done    public boolean searchID(String cardID)
//Done    public boolean searchFrame(String fID)
//Done    public boolean searchEngine(String eID)
//    public void addCar() 
//    public void printBaseBrandName()        
//    public boolean removeCar()
//    public boolean updateCar()        
//    public void listCars()        
                                                
    public int searchID(String carID) {
        for (int i = 0; i < carList.size() - 1; i++) {
            if (carList.get(i).getCarID().equals(carID)) {
                return i;
            }
        }
        return -1;
    }                    
    
    public int searchFrame(String frameID) {
        for (int i = 0; i < carList.size() - 1; i++) {
            if (carList.get(i).getFrameID().equals(frameID)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean searchEngine(String engineID) {
        for (int i = 0; i < carList.size() - 1; i++) {
            if (carList.get(i).getEngineID().equals(engineID)) {
                return true;
            }
        }
        return false;
    }
    
   
}
