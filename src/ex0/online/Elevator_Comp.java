package ex0.online;

import ex0.CallForElevator;
import ex0.Elevator;

import java.util.Comparator;

/**
 * This class implements the Comparator interface.
 * The function of this department is to sort the elevator array according to the reading condition,
 * the elevator speed and the elevator location.
 *This class has a flag that symbolizes the reading mode. 1 = up, 1- = down, 0 = normal.
 * In addition, this class has the location of the reading for calculating the nearest elevator
 */
public class Elevator_Comp implements Comparator<Elevator> {
    private int flag;//Reading mode
    private int place;//Source location
    private LinkedFloor[] arr;

    /**
     * This function initializes the variables
     * @param flag = state
     * @param place = source
     *  @param arr = Queue of elevators
     */
    public Elevator_Comp(int flag, int place,LinkedFloor[] arr) {
        this.flag = flag;
        this.place = place;
       this.arr=arr;
    }

    /**
     * This function sorts by the fastest elevator
     * @param e1=One elevator
     * @param e2=Second elevator
     * @return The fastest elevator in relation to reading
     */

    @Override
    public int compare(Elevator e1, Elevator e2) {
        double time_e1 = e1.getSpeed();//Elevator speed
        double time_e2 = e2.getSpeed();//Elevator speed
          int t1=Math.abs(e1.getPos()-place);
      int t2=Math.abs(e2.getPos()-place);
        int state1 = e1.getState();//Elevator condition
        int state2 = e2.getState();//Elevator condition
        //*****************************flag 1*************************************
        if (flag == 0) {//Normal mode
            if (time_e1 > time_e2) {//What's faster
                return -1;
            }
            if (time_e1 < time_e2) {
                return 1;
            } else {
                return 0;
            }
        }
        //*****************************flag 1*************************************
        if (flag == 1) {//UP
            if(state1 == Elevator.UP && e1.getPos() < place&&state2 == Elevator.UP && e2.getPos() < place){//Those who have not yet passed the source location
                if (time_e1 > time_e2) //What's faster
                    return -1;
                   if (time_e1 < time_e2)
                    return 1;
            }
            if (state1 == Elevator.UP && e1.getPos() < place)
                return -1;

            if (state2 == Elevator.UP && e2.getPos() < place)
                return 1;

            if (state1 == Elevator.LEVEL && state2 == Elevator.LEVEL) {
                if (t1 < t2) //Location by elevator
                    return -1;
               else
                   return 1;
            }
            if (state1 == Elevator.LEVEL && state2 != Elevator.LEVEL)
                return -1;

            if (state1 != Elevator.LEVEL && state2 == Elevator.LEVEL)
                return 1;
           if (arr!=null){
               int v1 = Math.abs(arr[e1.getID()].getHead() - place);
               int v2 = Math.abs(arr[e2.getID()].getHead() - place);
                if(v1<v2)
                    return -1;
                if(v1>v2)
                    return 1;
                if(arr[e1.getID()].getSize() < arr[e2.getID()].getSize())
                    return -1;
                else
                    return 1;
            }
          return 0;
        }
        //*****************************flag -1*************************************
        if (flag == -1) {//down
            if(state1 == Elevator.DOWN && e1.getPos() > place&&state2 == Elevator.DOWN && e2.getPos() > place){//Those who have not yet passed the source location
                if (time_e1 > time_e2) //What's faster
                    return -1;

                if (time_e1 < time_e2)
                    return 1;

            }
            if (state1 == Elevator.DOWN && e1.getPos() > place)
                return -1;

            if (state2 == Elevator.DOWN && e2.getPos() > place)
                return 1;

            if (state1 == Elevator.LEVEL && state2 == Elevator.LEVEL) {
                if (t1 < t2) //Location by elevator
                    return -1;
                else
                    return 1;
            }
            if (state1 == Elevator.LEVEL && state2 != Elevator.LEVEL)
                return -1;

            if (state1 != Elevator.LEVEL && state2 == Elevator.LEVEL)
                return 1;
            if(arr!=null){
                int v1 = Math.abs(arr[e1.getID()].getHead() - place);
                int v2 = Math.abs(arr[e2.getID()].getHead() - place);
                if(v1<v2)
                    return -1;
                if(v1>v2)
                    return 1;
                if(arr[e1.getID()].getSize() < arr[e2.getID()].getSize())
                    return -1;
               else
                   return 1;
            }
            return 0;



        }
        return 0;

    }
}

