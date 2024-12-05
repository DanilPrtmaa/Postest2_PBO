/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

public interface CRUDOperations {
    void addContainer(Container container);
    void displayAllContainers();
    void updateContainer(String id, String newType, double newWeight);
    void deleteContainer(String id);
}
