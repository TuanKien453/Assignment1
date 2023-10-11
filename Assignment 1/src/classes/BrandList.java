package classes;
import java.util.*;
import java.io.*;


public class BrandList {
    private ArrayList<Brand> brandList;

    public BrandList() {
        brandList = new ArrayList<Brand>();
    }
    
    public boolean loadFromFile(String filename){
        File f = new File(filename);
        if (!f.exists()){
                       
        }
        else{
            f.
        }
    }
//    public boolean loadFromFile(String);
//    public boolean saveToFile(String);
//    public int searchID (String ID);
//    public Brand getUserChoice();
//    public void addBrand();
//    public void updateBrand();
//    public void listBrands();
    public boolean searchID(String ID) {
        for (int i = 0; i < brandList.size(); i++) {
            if (brandList.get(i).getBrandID().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    public void addBrand() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter brand ID: ");
        String brandID = scanner.nextLine();
        boolean index = searchID(brandID);
        if (!index) {
            System.out.print("Enter brand name: ");
            String brandName = scanner.nextLine();
            System.out.print("Enter sound brand: ");
            String soundBrand = scanner.nextLine();
            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Clear the newline character from the input buffer
            Brand brand = new Brand(brandID, brandName, soundBrand, price);
            brandList.add(brand);
            System.out.println("Brand added successfully!");
        } else {
            System.out.println("Brand with the same ID already exists!");
        }
    }
    
}
