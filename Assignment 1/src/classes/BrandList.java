package classes;

import java.util.*;
import java.io.*;

public class BrandList {

    private ArrayList<Brand> brandList;
    Scanner scanner = new Scanner(System.in);

    public BrandList() {
        brandList = new ArrayList<Brand>();
    }

//Done    public boolean loadFromFile(String);
//Done    public boolean saveToFile(String);
//Done    public int searchID (String ID);
//    public Brand getUserChoice();
//Done    public void addBrand();
//Done    public void updateBrand();
//Done    public void listBrands();
    public boolean saveToFile(String filename) {
        boolean result = false;
        //Clear the file
        FileIO.writeFile(filename, "");
        for (int i = 0; i < brandList.size(); i++) {
            String s = brandList.get(i).getBrandID() + "|" + brandList.get(i).getBrandName()
                    + "|" + brandList.get(i).getSoundBrand() + "|" + brandList.get(i).getPrice() + "\n";
            result = FileIO.appendToFile(filename, s);
        }
        return result;
    }

    public void loadFromFile(String filename) {
        String Data = FileIO.readFile(filename);
        String arr[] = Data.split("\n");
        //clear all Brand in brandList
        brandList.removeAll(brandList);
        for (int i = 0; i < arr.length; i++) {
            String brandData[] = arr[i].split("\\|");
            brandList.add(new Brand(brandData[0], brandData[1], brandData[2], Double.valueOf(brandData[3])));
        }
    }

    public int searchID(String ID) {
        for (int i = 0; i < brandList.size(); i++) {
            if (brandList.get(i).getBrandID().equals(ID)) {
                return i;
            }
        }
        //if not found id return -1
        return -1;
    }

    public void addBrand() {
        String brandID = Inputer.inputString("Enter brand ID: ");
        int index = searchID(brandID);
        if (index == -1) {
            String brandName = Inputer.inputString("Enter brand name: ");
            String soundBrand = Inputer.inputString("Enter sound brand: ");
            double price = Inputer.inputDouble("Enter price: ", 0d, 100000000000d);
            Brand brand = new Brand(brandID, brandName, soundBrand, price);
            brandList.add(brand);
            System.out.println("Brand added successfully!");
        } else {
            System.out.println("Brand with the same ID already exists!");
        }
    }

    public void updateBrand() {
        String brandID = Inputer.inputString("Enter brand ID: ");
        int index = searchID(brandID);
        if (index == -1) {
            System.out.println("Not found brand ID!");
        } else {
            String brandName = Inputer.inputString("Enter brand name: ");
            String soundBrand = Inputer.inputString("Enter sound brand: ");
            double price = Inputer.inputDouble("Enter price: ", 0d, 100000000000d);
            Brand brand = new Brand(brandID, brandName, soundBrand, price);
            brandList.add(index, brand);
            System.out.println("Brand updated successfully!");
        }
    }

    public void listBrands() {
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < brandList.size(); i++) {
            System.out.println(brandList.get(i).toString());
        }
        System.out.println("-----------------------------------------------");
    }

}
