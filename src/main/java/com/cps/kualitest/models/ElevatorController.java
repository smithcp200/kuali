package com.cps.kualitest.models;

import com.cps.kualitest.exceptions.InvalidFloorRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clint on 1/17/16.
 */
public class ElevatorController {

    List<Elevator> elevatorList = new ArrayList<Elevator>();

    /**
     * Feature #7
     * 
     * @param fromFloor
     * @param toFloor
     * @return
     */
    public boolean receiveRequest(int fromFloor, int toFloor){

        boolean requestFilled = false;
        // check to see if any of the elevators are on the "fromFloor".  If so, then it will fill the request;
        for(Elevator currentElevator : elevatorList){
            int closestDistance = 1000;
            Elevator closestElevator = null;
            if(currentElevator.inService && currentElevator.currentFloor == fromFloor){
                try {
                    currentElevator.gotoFloor(toFloor);
                } catch (InvalidFloorRequest invalidFloorRequest) {
                    invalidFloorRequest.printStackTrace();
                }
                requestFilled = true;
                break;
            }else{
                // go through each elevator and see how far away it is.  Choose the closest
                if(currentElevator.distanceFromFloor(fromFloor) < closestDistance){
                    closestDistance = currentElevator.distanceFromFloor(fromFloor);
                    closestElevator = currentElevator;
                }
            }
            if(closestElevator != null){
                requestFilled = true;
                try {
                    closestElevator.gotoFloor(fromFloor);
                } catch (InvalidFloorRequest invalidFloorRequest) {
                    invalidFloorRequest.printStackTrace();
                }
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
