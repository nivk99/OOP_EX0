package ex0.online;

import ex0.Building;
import ex0.CallForElevator;
import ex0.Elevator;
import ex0.*;
import ex0.algo.ElevatorAlgo;

import java.awt.*;
import java.security.PublicKey;
import java.util.*;

/**
 *This class implements ElevatorAlgo.
 * This class is the online algorithm of making the elevators. She finds the elevator to her floor in the shortest time. It is assisted in several steps.
 * Step One: Appoint the linked list of all the elevators according to the fastest elevator.
 * Step Two: Put the rises in the floors according to the remainder in 2.
 * Step 3: Receives a reading and sorts the list according to the reading mode, elevator location and reading location, elevator speed and elevator status.
 * Step 4: After sorting the first organ in the list is best suited for the type of reading.
 * Step 5: Put the location and destination as everyone's elevators.
 * Step 6: Operator moved according to the queue of elevators which is sorted by elevator condition.
 *   ID0=208236315L, ID1 = 313131476L
 */
public class OnlineAlgo implements ElevatorAlgo {
    private Building _building;
    private LinkedList<Elevator> list;//List of all elevators
    private LinkedFloor[] arr;//An array of all the queues of the elevators according to the elevator index

    /**
     *This function builds the department according to the receipt of the building.
     *  In addition, it initializes the department's variables.
     * @param building -The building with all the elevators
     */
    public OnlineAlgo(Building building) {
        this._building = building;
        this.arr=new LinkedFloor[this._building.numberOfElevetors()];
        list = new LinkedList<>();
        sortElevator();//Initializing and sorting
       distanceElevator();//Scatter the elevators
    }

    /**
     *This function puts all the elevators in the linked list and also initializes the queue of each elevator.
     * Finally sorts the link list by the fastest elevator.
     */
    private void sortElevator() {
        for (int i = 0; i < this._building.numberOfElevetors(); i++) {
            Elevator temp = this._building.getElevetor(i);
            list.add(temp);
            arr[i]=new LinkedFloor();
        }
        list.sort(new Elevator_Comp(0, 0,arr));//Sort elevators
    }

    /**
     *This function scatters the elevators in the remainder 2.
     */
    private void distanceElevator() {
        int floors = this._building.maxFloor() -this._building.minFloor();//How many floors are there in the building
        if(list.size()>1) {
            this.list.get(1).goTo(floors / 2);
        }
        else
            this.list.get(0).goTo(floors / 2);
        for (int i = 2; i < this._building.numberOfElevetors(); i++) {
                this.list.get(i).goTo(0);
        }
    }

    /**
     * @return the Building on which the (online) elevator algorithm works on.
     */
    @Override
    public Building getBuilding() {// מקבל את שם הבניין
        return this._building;
    }

    /**
     * @return he algorithm name
     */
    @Override
    public String algoName() {// מקבל את שם האלגוריתם
        return "Ex0_Online_Algorithm_Elevator";
    }
    /**
     *This function receives a call to the elevator and returns the elevator index.
     * This function performs sorting according to the situation and also puts in the queue of readings of the elevator.
     * @param c the call for elevator (src, dest)
     * @return Elevators Index
     */
    @Override
    public int allocateAnElevator(CallForElevator c) {
        int t = c.getType();
        list.sort(new Elevator_Comp(t, c.getSrc(),arr));//Performs sorting on a linked list according to the status of an elevator call
          Elevator  ans = this.list.get(0);//The best elevator
       this.arr[ans.getID()].enqueue(c.getSrc(), t);//Put in a queue of readings according to the situation
       this.arr[ans.getID()].enqueue(c.getDest(), t);
        return ans.getID();
    }

    /**
     *This function moves the elevator according to the reading queue of the elevator
     * @param elev the current Elevator index on which the operation is performs.
     */
    @Override
    public void cmdElevator(int elev) {
        if(this._building.getElevetor(elev).getState() == Elevator.LEVEL) {
            if ((!this.arr[elev].isEmpty())) {
                int f = this.arr[elev].dequeue();//Takes out the first floor the elevator needs to reach
                this._building.getElevetor(elev).goTo(f);
            }
        }

    }
}
