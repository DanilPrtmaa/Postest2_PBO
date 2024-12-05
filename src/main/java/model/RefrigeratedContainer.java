/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Subclass RefrigeratedContainer
package models;

public class RefrigeratedContainer extends Container {
    private final double coolingCapacity;

    public RefrigeratedContainer(String id, double weight, double coolingCapacity) {
        super(id, "Refrigerated", weight);
        this.coolingCapacity = coolingCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Container ID: " + getId());
        System.out.println("Type: " + getType());
        System.out.println("Weight: " + getWeight() + " kg");
        System.out.println("Cooling Capacity: " + coolingCapacity + " kW");
    }
}
