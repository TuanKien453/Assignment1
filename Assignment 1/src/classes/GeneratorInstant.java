package classes;

import java.util.Random;

public class GeneratorInstant {

    private static final String[] brandIDs = {
        "B7-2018", "B7-MS", "B7-MS20", "B7-PE", "B5-18",
        "B7019", "BX4-18", "BX4-17", "B3-GT18", "B3-S19",
        "B5-X19", "B5-X20"
    };
    private static final String[] brandNames = {
        "BMW 730Li (2018)", "BMW 730Li M Sport", "BMW 730Li M Sport (2020)",
        "BMW 730Li Pure Excellence", "BMW 530i (2018)", "BMW 530i (2019)",
        "BMW X4 xDrive20i (2018)", "BMW X4 xDrive20i (2019)", "BMW 320i GT (2018)",
        "BMW 320i Sportline (2019)", "BMW X5 xDrive40i XLine (2019)",
        "BMW X5 xDrive40i XLine (2020)"
    };
    private static final String[] soundBrands = {
        "Harman Kardon", "Alpine", "Sony", "Bose"
    };
    private static final String[] models = {
        "B7-2018", "B7-MS", "B7-MS20", "B7-PE", "B5-18", "B5-X20"
    };
    private static final String[] colors = {
        "red", "black", "orange", "white", "pink", "grey"
    };
    //DEV by Hoàng Tuấn Kiên 
    public static Brand generateRandomBrand() {
        Random random = new Random();
        int index = random.nextInt(brandIDs.length);
        String brandID = brandIDs[index];
        String brandName = brandNames[index];
        String soundBrand = soundBrands[random.nextInt(soundBrands.length)];
        double price = 1.0 + (10.0 - 1.0) * random.nextDouble();;
        return new Brand(brandID, brandName, soundBrand, price);
    }
    //DEV by Hoàng Tuấn Kiên 
    public static Car generateRandomCar(String ID,BrandList bl){
        Random random = new Random();
        String color = colors[random.nextInt(colors.length)];
        int randomNumber = random.nextInt(99999 + 1 - 0) + 0;
        String frameID="F" + String.valueOf(randomNumber);
        randomNumber = random.nextInt(99999 + 1 - 0) + 0;
        String engineID = "E" + String.valueOf(randomNumber);
        randomNumber = random.nextInt(bl.getBrandList().size());
        Brand brand = bl.getBrandList().get(randomNumber);
        return new Car(ID, brand, color, frameID, engineID);
    }
}
