package com.cps.kualitest.models;

import com.cps.kualitest.enums.ElevatorDirection;
import com.cps.kualitest.exceptions.InvalidFloorRequest;

/**
 * Created by clint on 1/17/16.
 */
public class Elevator {

    public Elevator(int elevatorId, int maxFloorLevel){
        this.elevatorId = elevatorId;
        this.maxFloorLevel = maxFloorLevel;
    }

    int elevatorId;
    int maxFloorLevel;
    int minFloorLevel = 1;
    boolean idle;
    int currentFloor;
    ElevatorDirection direction;

    public void openDoor(){

    }

    public void closeDoor(){

    }

    public void gotoFloor(int floor) throws InvalidFloorRequest {
        if(floor < minFloorLevel || floor > maxFloorLevel){
            throw new InvalidFloorRequest();
        }

        closeDoor();
        idle = false;
        if(floor > currentFloor){
            direction = ElevatorDirection.UP;
        }else if(floor < currentFloor){
            direction = ElevatorDirection.DOWN;
        }

        // now go from floor to floor, reporting progress
        while(currentFloor != floor){
            if(direction == ElevatorDirection.UP){
                currentFloor = currentFloor + 1;
                System.out.println("Elevator moving past floor " + currentFloor + " en route to floor " + floor);
            }else if(direction == ElevatorDirection.DOWN){
                currentFloor = currentFloor - 1;
                System.out.println("Elevator moving past floor " + currentFloor + " en route to floor " + floor);
            }
        }

        idle = true;
        openDoor();
        System.out.println("Elevator has arrived at destination floor " + floor);
    }

    public int distanceFromFloor(int floor){
        int result = 1000;

        // if we are going UP and the floor is below up, return the max value
        if(floor < currentFloor && direction == ElevatorDirection.UP){
            result = 1000;
        }else if(floor > currentFloor && direction == ElevatorDirection.DOWN){
            result = 1000;
        }else{
            if(direction == ElevatorDirection.DOWN){
                result = currentFloor - floor;
            }else{
                result = floor - currentFloor;
            }
        }

        return result;
    }
}
