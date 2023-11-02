package classes;

public class Main {

    public static void main(String[] args) {
        boolean isrun = true;
        int choice;
        BrandList brandList = new BrandList();
        CarList carList = new CarList();
        String ID = null;
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
                    brandList.searchID(ID);
                    break;
                case 4:
                    brandList.updateBrand();
                    break;
                case 5:
                    brandList.saveToFile("Brand.txt");
                    break;
                case 6:
                    carList.listCars();
                    break;
                case 7:
                    carList.listCarsByBrand();
                    break;
                case 8:
                    carList.addCar(brandList);
                    break;
                case 9:
                    carList.removeCar();
                    break;
                case 10:
                    carList.updateCar(brandList);
                case 11:
                    carList.saveToFile("Cars.txt");
                    break;
                case 12: brandList.loadFromFile("Brand.txt"); break;
                case 13: 
                    carList.loadFromFile("Cars.txt", brandList);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (isrun);
    }

}
