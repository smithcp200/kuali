package com.cps.kualitest.models;

/**
 * Created by clint on 1/17/16.
 */
public class BuildingFloor {

    public BuildingFloor(int floorNumber, ElevatorController controller){
        this.floorNumber = floorNumber;
        this.controller = controller;
    }

    ElevatorController controller;
    int floorNumber;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    /**
     * Make a request from this floor to another floor via the controller
     * Feature #6
     * @param toFloor
     * @return
     */
    public boolean makeRequest(int toFloor){
        return controller.receiveRequest(getFloorNumber(), toFloor);
    }
}
