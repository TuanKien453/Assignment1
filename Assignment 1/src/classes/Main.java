package classes;

public class Main {

    public static void main(String[] args) {
        boolean isrun = true;
        int choice;
        BrandList brandList = new BrandList();
        CarList carList = new CarList();
        String[] options = {
            "1 - List all brands",
            "2 - Add a new brand",
            "3 - Search a brand based on its ID",
            "4 - Update a brand",
            "5 - Save brands to the file",
            "6 - List all cars in ascending order of brand names",
            "7 - List cars based on a part of an input brand name",
            "8 - Add a car",
            "9 - Remove a car based on its ID",
            "10- Update a car based on its ID",
            "11- Save cars to file, named cars.txt",
            "12- Load brand from file",
            "13- Load car from file"};
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
                    carList.saveToFile("cars.txt");
                    break;
                case 12: brandList.loadFromFile("Brand.txt"); break;
                case 13: 
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (isrun);
    }

}
