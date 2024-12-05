/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// ContainerManager with Interface implementation
package models;

import java.util.ArrayList;

public final class ContainerManager implements CRUDOperations {
    private final ArrayList<Container> containers = new ArrayList<>();
    public static int totalContainers = 0; // Static keyword

    // Method to add a container
    @Override
    public void addContainer(Container container) {
        containers.add(container);
        totalContainers++;
        System.out.println("Container added successfully!");
    }

    // Method to display all containers
    @Override
    public void displayAllContainers() {
        if (containers.isEmpty()) {
            System.out.println("No containers available.");
        } else {
            for (Container container : containers) {
                container.displayInfo();
                System.out.println("------------");
            }
        }
    }

    // Method to update a container
    @Override
    public void updateContainer(String id, String newType, double newWeight) {
        boolean found = false;
        for (Container container : containers) {
            if (container.getId().equals(id)) {
                container.setType(newType);
                container.setWeight(newWeight);
                System.out.println("Container updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Container with ID " + id + " not found.");
        }
    }

    // Method to delete a container
    @Override
    public void deleteContainer(String id) {
        boolean found = false;
        for (Container container : containers) {
            if (container.getId().equals(id)) {
                containers.remove(container);
                totalContainers--;
                System.out.println("Container deleted successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Container with ID " + id + " not found.");
        }
    }
}
