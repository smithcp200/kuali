package com.cps.kualitest.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clint on 1/17/16.
 */
public class ElevatorController {

    List<Elevator> elevatorList = new ArrayList<Elevator>();

    public void init(int numberOfElevators) {
        // just init elevators
        for(int i = 0; i < numberOfElevators; i++){
            elevatorList.add(new Elevator());
        }
    }

    public List<Elevator> getElevatorList() {
        return elevatorList;
    }

    public void setElevatorList(List<Elevator> elevatorList) {
        this.elevatorList = elevatorList;
    }
}
