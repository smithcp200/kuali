package com.cps.kualitest.models;

import com.cps.kualitest.exceptions.InvalidNumberFloorsException;
import com.cps.kualitest.exceptions.InvalidNumberOfElevatorsException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clint on 1/17/16.
 */
public class Building {

    public Building(int numberOfFloors, int numberOfElevators) throws InvalidNumberOfElevatorsException, InvalidNumberFloorsException {
        // must have at least on floor and one elevator
        if(numberOfElevators < 1){
            throw new InvalidNumberOfElevatorsException();
        }

        if(numberOfFloors < 1){
            throw new InvalidNumberFloorsException();
        }

        //initialize the floors and the elevators
        for(int i = 0; i < numberOfFloors; i++){
            floors.add(new BuildingFloor(i+1));
        }

        controller.init(numberOfElevators);

    }

    List<BuildingFloor> floors = new ArrayList<BuildingFloor>();
    ElevatorController controller = new ElevatorController();

    public List<BuildingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<BuildingFloor> floors) {
        this.floors = floors;
    }

    public ElevatorController getController() {
        return controller;
    }

    public void setController(ElevatorController controller) {
        this.controller = controller;
    }
}
