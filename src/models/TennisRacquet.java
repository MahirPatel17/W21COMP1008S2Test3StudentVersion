// Name - Mahir Patel
// Student number - 200454762

package models;

import Utilities.DBUtility;

import java.util.List;
import java.util.Locale;

import static Utilities.DBUtility.*;

public class TennisRacquet extends InventoryItem  {
    private double weight;  //240-310
    private String headSize; //midsize, midplus, oversize, super oversize
    private String brand; //Head, Babolat, Dunlop, Yonex
    private String model;

    public TennisRacquet(String brand, String model, double weight, String headSize, double purchasePrice, double sellingPrice, int quantityInStock) {
        super(purchasePrice, sellingPrice, quantityInStock);
        setWeight(weight);
        setHeadSize(headSize);
        setBrand(brand);
        setModel(model);
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if(weight >= 240 && weight <= 310)
        {
            this.weight = weight;
        }
        else
        {
            throw new IllegalArgumentException("weight must be in range of 240 - 310");
        }
    }

    public String getHeadSize() {
        return headSize;
    }

    public void setHeadSize(String headSize) {
        headSize = headSize.toLowerCase();
        List<String> headSizes = getTennisRacquetHeadSizes();
        if(headSizes.contains(headSize))
            this.headSize = headSize;
        else
            throw new IllegalArgumentException("Head size is not in the list");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        List<String> brands = tennisEquipmentBrands();
        if(brands.contains(brand))
            this.brand = brand;
        else
            throw new IllegalArgumentException("Brands are not in the list");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        List<String> models = tennisRacquetModelsByBrand(model);
        if(models.contains(model))
            this.model = model;
        else
            throw new IllegalArgumentException("Models are not in the list");
    }
}
