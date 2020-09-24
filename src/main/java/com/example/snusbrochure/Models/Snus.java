package com.example.snusbrochure.Models;

public class Snus {
    public int snusId;
    public String name;
    public String brand;
    public int price;
    public int strength;
    public String country;
    public String imagelink;

    public Snus(int snusId, String name, String brand, int price, int strength, String country, String imagelink) {
        this.snusId = snusId;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.strength = strength;
        this.country = country;
        this.imagelink = imagelink;
    }

    public Snus() {

    }

    public int getSnusId() {
        return snusId;
    }

    public void setSnusId(int snusId) {
        this.snusId = snusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    @Override
    public String toString() {
        return "Snus{" +
                "snusId=" + snusId +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", strength=" + strength +
                ", country='" + country + '\'' +
                ", imagelink='" + imagelink + '\'' +
                '}';
    }
}
