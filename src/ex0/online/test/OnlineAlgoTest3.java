package ex0.online.test;

import ex0.Building;
import ex0.algo.ElevatorAlgo;
import ex0.online.OnlineAlgo;
import ex0.simulator.Simulator_A;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a continuation of the testing department
 */
class OnlineAlgoTest3 {

    Building stage8;
    ElevatorAlgo algo_stage8;
    public OnlineAlgoTest3() {
        Simulator_A.initData(8, null);
        stage8 = Simulator_A.getBuilding();
        algo_stage8 = new OnlineAlgo(stage8);
    }

    @Test
    void allocateAnElevator() {
        call c=new call(stage8.minFloor(),10,1);
        assertEquals(stage8.getElevetor(1).getState(),0);
        int x=algo_stage8.allocateAnElevator(c);
        algo_stage8.cmdElevator(x);
       assertEquals(c.getState(),0);
        call c1=new call(stage8.minFloor(),stage8.minFloor(),1);
        int x1=algo_stage8.allocateAnElevator(c1);
        assertEquals(x1,1);
        cmdElevator();
    }


    @Before
    void cmdElevator() {
        for (int i = 0; i < stage8.numberOfElevetors(); i++) {
            algo_stage8.cmdElevator(i);
            if(i!=1)
            assertEquals(stage8.getElevetor(i).getState(),1);
        }
    }
}