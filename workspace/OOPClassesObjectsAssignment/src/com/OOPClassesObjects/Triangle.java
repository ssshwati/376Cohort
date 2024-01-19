package com.OOPClassesObjects;

public class Triangle extends Shape{
    private double base;
    private double height;

    // Parameterized constructor
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // Getter for base
    public double getBase() {
        return base;
    }

    // Setter for base
    public void setBase(double base) {
        this.base = base;
    }

    // Getter for height
    public double getHeight() {
        return height;
    }

    // Setter for height
    public void setHeight(double height) {
        this.height = height;
    }

    // Method to calculate area
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
    
    
}
