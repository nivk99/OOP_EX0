package ex0.online.test;

import ex0.Building;
import ex0.Elevator;
import ex0.algo.ElevatorAlgo;
import ex0.online.Elevator_Comp;
import ex0.online.OnlineAlgo;
import ex0.simulator.Builging_A;
import ex0.simulator.Simulator_A;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 *This class tests all Elevator_Comp functions
 */
class Elevator_CompTest {
    Building stage9;
    OnlineAlgo algo_stage9;
         public Elevator_CompTest() {
        Simulator_A.initData(9, null);
        stage9 = Simulator_A.getBuilding();
        algo_stage9 = new OnlineAlgo(stage9);
    }
    @Test
//Function test
    void compare() {
        Elevator[] elev1=new Elevator[stage9.numberOfElevetors()];
        Elevator[] elev2=new Elevator[stage9.numberOfElevetors()];
        for (int i = 0; i < stage9.numberOfElevetors(); i++) {
            elev1[i]=stage9.getElevetor(i);
            elev2[i]=stage9.getElevetor(i);
        }
        Arrays.sort(elev1,new Elevator_Comp(0,0,null));//sort the array elev1 --> flag 0
        System.out.println();
        System.out.println("**********************************flag 0*******************************************");
        System.out.println();
        for (int i = 0; i < stage9.numberOfElevetors(); i++) {
            System.out.println(i+")"+"Without sorting:"+" "+elev2[i]);//Print without sorting
            System.out.println(i+")"+"After sorting:"+" "+elev1[i] + " ,"+stage9.getElevetor(i).getState());//Printing after sorting
            if (i!=1)
                //You can see the fastest elevator is the one with the largest speed while the slowest elevator is the one with the lowest speed
            assertNotEquals(elev1[i],elev2[i]);// not equals: speed i != speed j
            else
                assertEquals(elev1[i],elev2[i]);//equals: speed 10 == speed 10
        }
        Arrays.sort(elev1,new Elevator_Comp(1,1,null));//sort the array elev1 --> flag 1
        System.out.println();
        System.out.println("**********************************flag 1*******************************************");
        System.out.println();
        for (int i = 0; i < stage9.numberOfElevetors(); i++) {
            System.out.println(i + ")" + "Without sorting:" + " " + elev2[i]);//Print without sorting
            System.out.println(i + ")" + "After sorting:" + " " + elev1[i]);//Printing after sorting
            // not equals because You can see elevator 0 is at the end and elevator 1 is the first because elevator 0 is on the lowest floor while elevator 1 is on the way to the middle of the building
            assertNotEquals(elev1[i],elev2[i]);
        }
        Arrays.sort(elev1,new Elevator_Comp(-1,stage9.minFloor(),null));//sort the array elev1 --> flag -1
        System.out.println();
        System.out.println("**********************************flag -1*******************************************");
        System.out.println();
        for (int i = 0; i < stage9.numberOfElevetors(); i++) {
            System.out.println(i + ")" + "Without sorting:" + " " + elev2[i]);//Print without sorting
            System.out.println(i + ")" + "After sorting:" + " " + elev1[i]+" ,");//Printing after sorting
            //not equals because You can see elevator 0 is at the end and elevator 1 is the first because elevator 0 is on the lowest floor while elevator 1 is on the way to the middle of the building
            if (i!=6&&i!=1)
           assertNotEquals(elev1[i],elev2[i]);
           else
                assertEquals(elev1[i],elev2[i]);
        }
    }

}