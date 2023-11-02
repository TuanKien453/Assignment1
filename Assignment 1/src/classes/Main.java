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
            "Load car from file",
            "Quit the program"};

        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    brandList.listBrands();
                    Inputer.inputString("Press Enter to continue");
                    break;
                case 2:
                    brandList.addBrand();
                    Inputer.inputString("Press Enter to continue");
                    break;
                case 3:
                    brandList.searchBrand();
                    Inputer.inputString("Press Enter to continue");
                    break;
                case 4:
                    brandList.updateBrand();
                    Inputer.inputString("Press Enter to continue");
                    break;
                case 5:
                    brandList.saveToFile("Brand.txt");
                    Inputer.inputString("Press Enter to continue");
                    break;
                case 6:
                    carList.listCars();
                    Inputer.inputString("Press Enter to continue");
                    break;
                case 7:
                    carList.listCarsByBrand();
                    Inputer.inputString("Press Enter to continue");
                    break;
                case 8:
                    carList.addCar(brandList);
                    Inputer.inputString("Press Enter to continue");
                    break;
                case 9:
                    carList.removeCar();
                    Inputer.inputString("Press Enter to continue");
                    break;
                case 10:
                    carList.updateCar(brandList);
                    Inputer.inputString("Press Enter to continue");
                    break;
                case 11:
                    carList.saveToFile("Cars.txt");
                    Inputer.inputString("Press Enter to continue");
                    break;
                case 12:
                    brandList.loadFromFile("Brand.txt");
                    Inputer.inputString("Press Enter to continue");
                    break;
                case 13:
                    carList.loadFromFile("Cars.txt", brandList);
                    Inputer.inputString("Press Enter to continue");
                    break;
                case 14:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (isrun);
    }

}
