package vn.edu.ntu.model;

public class Product {
    private String Name;
    private int Price;
    private String Deacription;
    // getter setter
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getDeacription() {
        return Deacription;
    }

    public void setDeacription(String deacription) {
        Deacription = deacription;
    }
    // constructor
    public Product() {
    }

    public Product(String name, int price, String deacription) {
        Name = name;
        Price = price;
        Deacription = deacription;

    }
}
