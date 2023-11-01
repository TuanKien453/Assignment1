package classes;

public class Main {

    public static void main(String[] args) {
        boolean isrun = true;
        int choice;
        BrandList brandList = new BrandList();
        CarList carList = new CarList();
        String[] options = {
            "List all brands",
            "Add a new brand",
            "Search a brand based on its ID",
            "Update a brand",
            "Save brands to the file",
            "List all cars in ascending order of brand names",
            "List cars based on a part of an input brand name",
            "Add a car",
            "Remove a car based on its ID",
            "Update a car based on its ID",
            "Save cars to file, named cars.txt",
            "Load brand from file",
            "Load car from file"};

        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    brandList.listBrands();
                    break;
                case 2:
                    brandList.addBrand();
                    break;
                case 3:
                case 4:
                case 5:
                    brandList.saveToFile("Brand.txt");
                    break;
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12: brandList.loadFromFile("Brand.txt"); break;
                case 13: 
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (isrun);
    }

}
