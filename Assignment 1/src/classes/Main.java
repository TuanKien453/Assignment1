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
            "Search Car based on it's ID",
            "Quit the program"};

        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    brandList.listBrands();
                    Inputer.inputEnter("Press Enter to continue!");
                    break;
                case 2:
                    brandList.addBrand();
                   Inputer.inputEnter("Press Enter to continue!");
                    break;
                case 3:
                    brandList.searchBrand();
                    Inputer.inputEnter("Press Enter to continue!");
                    break;
                case 4:
                    brandList.updateBrand();
                    Inputer.inputEnter("Press Enter to continue");
                    break;
                case 5:
                    brandList.saveToFile("Brand.txt");
                    Inputer.inputEnter("Press Enter to continue!");
                    break;
                case 6:
                    carList.listCars();
                    Inputer.inputEnter("Press Enter to continue!");
                    break;
                case 7:
                    carList.printBaseBrandName(brandList);
                    Inputer.inputEnter("Press Enter to continue!");
                    break;
                case 8:
                    carList.addCar(brandList);
                    Inputer.inputEnter("Press Enter to continue!");
                    break;
                case 9:
                    carList.removeCar();
                    Inputer.inputEnter("Press Enter to continue!");
                    break;
                case 10:
                    carList.updateCar(brandList);
                    Inputer.inputEnter("Press Enter to continue!");
                    break;
                case 11:
                    carList.saveToFile("Cars.txt");
                    Inputer.inputEnter("Press Enter to continue!");
                    break;
                case 12:
                    brandList.loadFromFile("Brand.txt");
                    Inputer.inputEnter("Press Enter to continue!");
                    break;
                case 13:
                    carList.loadFromFile("Cars.txt", brandList);
                    Inputer.inputEnter("Press Enter to continue!");
                    break;
                case 14: 
                    carList.searchCar();
                    Inputer.inputEnter("Press Enter to continue!");
                    break;
                case 15:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (isrun);
    }

}
