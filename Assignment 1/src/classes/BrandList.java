package classes;

import java.util.*;
import java.lang.*;
import java.text.DecimalFormat;

public class BrandList {

    private ArrayList<Brand> brandList;

    public BrandList() {
        brandList = new ArrayList<Brand>();
    }

    public ArrayList<Brand> getBrandList() {
        return brandList;
    }

//Done    public boolean loadFromFile(String);
//Done    public boolean saveToFile(String);
//Done    public int searchID (String ID);
//Done    public Brand getUserChoice();
//Done    public void addBrand();
//Done    public void updateBrand();
//Done    public void listBrands();
    public void saveToFile(String filename) {

        //Clear the file
        FileIO.writeFile(filename, "");
        for (int i = 0; i < brandList.size(); i++) {
            String s = brandList.get(i).getBrandID() + "|" + brandList.get(i).getBrandName()
                    + "|" + brandList.get(i).getSoundBrand() + "|" + brandList.get(i).getPrice() + "\n";
            FileIO.appendToFile(filename, s);
        }
        System.out.println("Save to file successfully! ");
    }

    public Brand getUserChoice() {
        int i = 1;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        System.out.println(String.format("%-5s. || %-15s || %-40s || %-20s || %-10s", "STT", "BrandID", "BrandName", "SoundBrand", "Price"));
        for (Brand b : brandList) {
            String formattedPrice = decimalFormat.format(b.getPrice());
            System.out.println(String.format("%-5s. || %-15s || %-40s || %-20s || %-10s", i, b.getBrandID(), b.getBrandName(), b.getSoundBrand(), formattedPrice));
            i++;
        }
        int choice = Inputer.inputInt("Choose the brand: ", 1, brandList.size());
        return brandList.get(choice - 1);
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
        System.out.println("Load from file successfully! ");
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

    public void searchBrand() {
        String ID = Inputer.inputString("Enter ID of brand you want to search: ");
        for (int i = 0; i < brandList.size(); i++) {
            if (brandList.get(i).getBrandID().equals(ID)) {
                System.out.println("Found: " + brandList.get(i).toString());
                return;
            }
        }
        System.out.println("Not found Brand with ID" + ID);
    }

    public void addBrand() {
        int index;
        String brandID;

        while (true) {
            brandID = Inputer.inputString("Enter brand ID: ");
            index = searchID(brandID);
            if (brandID.equals("back")) {
                return;
            }
            if (index != -1) {
                System.out.println("Brand with the same ID already exists!");
                System.out.println("Please try again! or input back to return MainMenu!");
            } else {
                break;
            }
        }
        String brandName = Inputer.inputString("Enter brand name: ");
        String soundBrand = Inputer.inputString("Enter sound brand: ");
        double price = Inputer.inputDouble("Enter price: ", 0d, 100000000000d);
        Brand brand = new Brand(brandID, brandName, soundBrand, price);
        brandList.add(brand);
        System.out.println("Brand added successfully!");
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
            brandList.set(index, brand);
            System.out.println("Brand updated successfully!");
        }
    }

    public void listBrands() {
        int i = 1;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        System.out.println(String.format("%-5s. || %-15s || %-40s || %-20s || %-10s", "STT", "BrandID", "BrandName", "SoundBrand", "Price"));
        for (Brand b : brandList) {
            String formattedPrice = decimalFormat.format(b.getPrice());
            System.out.println(String.format("%-5s. || %-15s || %-40s || %-20s || %-10s", i, b.getBrandID(), b.getBrandName(), b.getSoundBrand(), formattedPrice));
            i++;
        }
    }

    public void removeBrand(String id) {
        int index = searchID(id);
        if (index == -1) {
            System.out.println("Not found brand ID!");
        } else {
            brandList.remove(index);
            System.out.println("Remove brand successfully!");
        }
    }

    public Brand getBrand(String brandID) {
        int pos = searchID(brandID);
        if (pos == -1) {
            return null;
        } else {
            return brandList.get(pos);
        }
    }
}
