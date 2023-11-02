package classes;

import java.text.DecimalFormat;

public class Brand {

    private String brandID;
    private String brandName;
    private String soundBrand;
    private double price;

    public Brand(String brandID, String brandName, String soundBrand, double price) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }

    public Brand() {
    }

    public String getBrandID() {
        return brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getSoundBrand() {
        return soundBrand;
    }

    public double getPrice() {
        return price;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setSoundBrand(String soundBrand) {
        this.soundBrand = soundBrand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedPrice = decimalFormat.format(price);
        return "brandID=" + brandID + "; brandName=" + brandName + "; soundBrand=" + soundBrand + "; price=" + formattedPrice;
    }

}
