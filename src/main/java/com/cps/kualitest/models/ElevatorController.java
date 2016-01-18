package com.cps.kualitest.models;

import com.cps.kualitest.exceptions.InvalidFloorRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clint on 1/17/16.
 */
public class ElevatorController {

    List<Elevator> elevatorList = new ArrayList<Elevator>();

    public boolean receiveRequest(int fromFloor, int toFloor){

        boolean requestFilled = false;
        // check to see if any of the elevators are on the "fromFloor".  If so, then it will fill the request;
        for(Elevator currentElevator : elevatorList){
            if(currentElevator.inService && currentElevator.currentFloor == fromFloor){
                try {
                    currentElevator.gotoFloor(toFloor);
                } catch (InvalidFloorRequest invalidFloorRequest) {
                    invalidFloorRequest.printStackTrace();
                }
                requestFilled = true;
                break;
            }
        }
        return requestFilled;
    }

    public void init(int numberOfElevators, int numberOfFloors) {
        // just init elevators
        for(int i = 0; i < numberOfElevators; i++){
            elevatorList.add(new Elevator(i, numberOfFloors));
        }
    }

    public List<Elevator> getElevatorList() {
        return elevatorList;
    }

    public void setElevatorList(List<Elevator> elevatorList) {
        this.elevatorList = elevatorList;
    }
}
