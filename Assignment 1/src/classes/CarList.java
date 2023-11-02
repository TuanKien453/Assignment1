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

    public boolean saveToFile(String filename) {
        boolean result = false;
        // clear all car in file
        FileIO.writeFile(filename, "");
        for (int i = 0; i < carList.size(); i++) {
            String carData = carList.get(i).getCarID() + "|" + carList.get(i).getBrand().getBrandID() + "|";
            carData += carList.get(i).getColor() + "|" + carList.get(i).getEngineID() + "|" + carList.get(i).getFrameID() + "\n";
            result = FileIO.appendToFile(filename, carData);
        }
        return result;
    }

    public void loadFromFile(String filename, BrandList bl) {
        String Data = FileIO.readFile(filename);
        String arr[] = Data.split("\n");
        // clear all car in car list
        carList.removeAll(carList);
        for (int i = 0; i < arr.length; i++) {
            String carData[] = arr[i].split("\\|");
            Brand br = bl.getBrand(carData[1]);
            Car car = new Car(carData[0], br, carData[2], carData[3], carData[4]);
            carList.add(car);
        }
    }

//Done    public boolean loadFromFile(String filename)
//Done    public boolean saveToFile(String)
//Done    public boolean searchID(String cardID)
//Done    public boolean searchFrame(String fID)
//Done    public boolean searchEngine(String eID)
//Done    public void addCar() 
//Done    public void printBaseBrandName()        
//Done    public boolean removeCar()
//    public boolean updateCar()        
//Done    public void listCars()        
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

    public void addCar(BrandList listBrand) {
        int index;
        String carID;
        do {
            carID = Inputer.inputString("Enter Car ID: ");
            index = searchID(carID);
            if (index!=-1) {
                System.out.println("Car with the same ID already exists!.");
            }
        } while (index==-1);
        Brand newBrand = listBrand.getUserChoice();
        String newBrandID = newBrand.getBrandID();
        String color = Inputer.inputString("Enter color: ");
        String frameID = Inputer.inputPattern("Enter frameID: ", "F0000");
        String engineID = Inputer.inputPattern("Enter engineID: ", "E0000");
        Car newCar = new Car(carID, newBrand, color, frameID, engineID);
        carList.add(newCar);
        System.out.println("Car added succesfully!.");
    }

    public void printBasedBrandName() {
        String name = Inputer.inputString("Enter a part of brand name: ");
        int count = 0;
        for (int i = 0; i < carList.size(); i++) {
            Car c = carList.get(i);
            if (c.getBrand().getBrandID().contains(name)) {
                System.out.println(c);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No car is detected.");
        }
    }
    
    public void updateCar(BrandList brandList){
        String updateID = Inputer.inputString("Enter ID you want to update: ");
        int index = searchID(updateID);
        if (index==-1) {
            System.out.println("Car with ID "+updateID+" is not found.");
        }
        else{
            Brand newBrand = brandList.getUserChoice();
            String newBrandID = newBrand.getBrandID();
            String updateColor = Inputer.inputString("Enter updateColor: ");
            String updateFrameID = Inputer.inputPattern("Enter updateFrameID: ","F0000");
            String updateEngineID = Inputer.inputPattern("Enter updateEngineID: ", "E0000");
            Car car = new Car(updateID, newBrand, updateColor, updateFrameID, updateEngineID);
            carList.add(index, car);
            System.out.println("Car updated successfully!");
        }
    }

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

    public void listCars() {
        Collections.sort(carList, new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return c2.getBrand().getBrandName().compareTo(c1.getBrand().getBrandName());
            }
        });
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i).screenString());
        }
        System.out.println("-----------------------------------------------");
    }

    public void listCarsByBrand() {
        
    }
}
