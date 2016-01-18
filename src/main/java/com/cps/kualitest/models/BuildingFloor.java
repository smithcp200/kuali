package com.cps.kualitest.models;

/**
 * Created by clint on 1/17/16.
 */
public class BuildingFloor {

    public BuildingFloor(int floorNumber){
        this.floorNumber = floorNumber;
    }

    int floorNumber;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
