// Name - Mahir Patel
// Student number - 200454762

package models;

import Utilities.DBUtility;

import java.util.List;

import static Utilities.DBUtility.getSkiBrands;
import static Utilities.DBUtility.tennisRacquetModelsByBrand;

public class Skis extends InventoryItem{
    private String brand, model;
    private int length;

    public Skis(String brand, String model, int length, double purchasePrice, double sellingPrice, int quantityInStock) {
        super(purchasePrice, sellingPrice, quantityInStock);
        setBrand(brand);
        setModel(model);
        setLength(length);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        List<String> brands = getSkiBrands();
        if(brands.contains(brand))
            this.brand = brand;
        else
            throw new IllegalArgumentException("Brands are not in the list");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if(length >= 60 && length <= 220)
        {
            this.length = length;
        }
        else
        {
            throw new IllegalArgumentException("Length must be in range of 60 - 220");
        }
    }
}
