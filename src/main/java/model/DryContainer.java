/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Subclass DryContainer
package models;

public class DryContainer extends Container {
    public DryContainer(String id, double weight) {
        super(id, "Dry", weight);
    }

    @Override
    public void displayInfo() {
        System.out.println("Container ID: " + getId());
        System.out.println("Type: " + getType());
        System.out.println("Weight: " + getWeight() + " kg");
    }
}
