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

    public void saveToFile(String filename) {

        // clear all car in file
        FileIO.writeFile(filename, "");
        for (int i = 0; i < carList.size(); i++) {
            String carData = carList.get(i).getCarID() + "|" + carList.get(i).getBrand().getBrandID() + "|";
            carData += carList.get(i).getColor() + "|" + carList.get(i).getFrameID() + "|" + carList.get(i).getEngineID() + "\n";
            FileIO.appendToFile(filename, carData);
        }
        System.out.println("Save to file successfully! ");
    }

    public void loadFromFile(String filename, BrandList bl) {
        String Data = FileIO.readFile(filename);
        String arr[] = Data.split("\n");
        // clear all car in car list
        carList.removeAll(carList);
        for (int i = 0; i < arr.length; i++) {
            String carData[] = arr[i].split("\\|");
            Brand br = bl.getBrand(carData[1]);
            if (br == null) {
                System.out.println("Faile to load from file! Brand not found.");
                return;
            }

            Car car = new Car(carData[0], br, carData[2], carData[3], carData[4].trim());
            carList.add(car);
        }
        System.out.println("Load from file successfully! ");
    }

//Done    public boolean loadFromFile(String filename)
//Done    public boolean saveToFile(String)
//Done    public boolean searchID(String cardID)
//Done    public boolean searchFrame(String fID)
//Done    public boolean searchEngine(String eID)
//Done    public void addCar() 
//Done    public void printBaseBrandName()        
//Done    public boolean removeCar()
//Done    public boolean updateCar()        
//Done    public void listCars()        
    public int searchID(String carID) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getCarID().equals(carID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchFrame(String frameID) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getFrameID().equals(frameID)) {
                return i;
            }
        }
        return -1;
    }

    public boolean searchEngine(String engineID) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getEngineID().equals(engineID)) {
                return true;
            }
        }
        return false;
    }

    public void addCar(BrandList listBrand) {
//        for (int i = 0; i < 50; i++) {
//            carList.add(GeneratorInstant.generateRandomCar("C" + String.valueOf(i), listBrand));
//        }
        int index;
        String carID;
        while (true) {
            carID = Inputer.inputString("Enter Car ID: ");
            index = searchID(carID);
            if (carID.equals("back")) {
                return;
            }
            if (index != -1) {
                System.out.println("Car with the same ID already exists!");
                System.out.println("Please try again! or input back to return MainMenu!");
            } else {
                break;
            }
        }

        Brand newBrand = listBrand.getUserChoice();

        String color = Inputer.inputString("Enter color: ");
        String frameID = Inputer.inputString("Enter frameID: ");
        String engineID = Inputer.inputString("Enter engineID: ");
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
                System.out.println(String.format("%-5s. || %-10s || %-15s || %-15s || %-15s || %-15s",
                        i + 1, c.getCarID(), c.getBrand().getBrandID(), c.getColor(), c.getFrameID(), c.getEngineID()));
            }
        }
        if (count == 0) {
            System.out.println("No car is detected.");
        }
    }

    public void updateCar(BrandList brandList) {
        String updateID = Inputer.inputString("Enter ID you want to update: ");
        int index = searchID(updateID);
        if (index == -1) {
            System.out.println("Car with ID " + updateID + " is not found.");
        } else {
            Brand newBrand = brandList.getUserChoice();
            String newBrandID = newBrand.getBrandID();
            String updateColor = Inputer.inputString("Enter updateColor: ");
            String updateFrameID = Inputer.inputString("Enter updateFrameID: ");
            String updateEngineID = Inputer.inputString("Enter updateEngineID: ");
            Car car = new Car(updateID, newBrand, updateColor, updateFrameID, updateEngineID);
            carList.set(index, car);
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
        int i = 1;
        System.out.println(String.format("%-5s. || %-7s || %-40s || %-12s || %-12s || %-12s || %-12s", "STT", "CarID", "BrandName", "BrandID", "Color", "FrameID", "EngineID"));
        for (Car c : carList) {
            System.out.println(String.format("%-5s. || %-7s || %-40s || %-12s || %-12s || %-12s || %-12s",
                    i, c.getCarID(), c.getBrand().getBrandName(), c.getBrand().getBrandID(), c.getColor(), c.getFrameID(), c.getEngineID()));
            i++;
        }
    }

    public void printBaseBrandName(BrandList bl) {
        String input = Inputer.inputString("Enter the brand name: ");
        int i = 1;
        ArrayList<Brand> PrintbrandList = new ArrayList();
        for (Brand b : bl.getBrandList()) {
            if (b.getBrandName().contains(input)) {
                PrintbrandList.add(b);
            }
        }
        if (PrintbrandList.isEmpty()) {
            System.out.println("Not found any cars");
            return;
        }

        System.out.println("All cars contain '" + input + "' in brand name: ");
        for (Car c : carList) {
            for (Brand b : PrintbrandList) {
                if (c.getBrand().equals(b)) {
                    System.out.println(String.format("%-5s. || %-7s || %-40s || %-12s || %-12s || %-12s || %-12s",
                            i, c.getCarID(), c.getBrand().getBrandName(), c.getBrand().getBrandID(), c.getColor(), c.getFrameID(), c.getEngineID()));
                    i++;
                }
            }
        }

    }
}
