/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Abstract class Container
package models;

public abstract class Container {
    private String id;
    private String type;
    private double weight;

    // Constructor
    public Container(String id, String type, double weight) {
        this.id = id;
        this.type = type;
        this.weight = weight;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Abstract method (Abstraction)
    public abstract void displayInfo();
}
