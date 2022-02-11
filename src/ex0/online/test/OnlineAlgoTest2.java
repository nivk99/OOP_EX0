package ex0.online.test;

import ex0.Building;
import ex0.algo.ElevatorAlgo;
import ex0.online.OnlineAlgo;
import ex0.online.test.call;
import ex0.simulator.Simulator_A;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a continuation of the testing department
 */

class OnlineAlgoTest2 {
        Building stage9;
        ElevatorAlgo algo_stage9;
        public OnlineAlgoTest2(){
            Simulator_A.initData(9,null);
            stage9 = Simulator_A.getBuilding();
            algo_stage9 =new OnlineAlgo(stage9);
        }

    @Test
    void allocateAnElevator() {
        int test9= algo_stage9.allocateAnElevator(new call(0,1,1))  ;
        assertEquals(test9,1);//This is the result because this is the elevator which reaches the middle of the building
        algo_stage9.cmdElevator(test9);
       test9= algo_stage9.allocateAnElevator(new call(stage9.minFloor(),1,-1));
        algo_stage9.cmdElevator(test9);
        assertEquals(test9,3);//This is the result because this is the fastest elevator
         test9= algo_stage9.allocateAnElevator(new call((stage9.maxFloor()-stage9.minFloor())/2+1,(stage9.maxFloor()-stage9.minFloor()/2+2),1) ) ;
        assertEquals(test9,3);
        //He chose 0 because he is the one with the elevator who is free and not busy
        test9= algo_stage9.allocateAnElevator(new call(stage9.maxFloor(),stage9.minFloor(),-1) ) ;
        assertEquals(test9,0);
     cmdElevator();

    }

    @After
    void cmdElevator() {
        for (int i = 0; i < stage9.numberOfElevetors(); i++) {
            algo_stage9.cmdElevator(i);
            if (i!=3)//3 This is the fastest elevator and it stays in place and does not move
            assertEquals(stage9.getElevetor(i).getState(), 1);
            assertFalse(stage9.getElevetor(i).goTo(i));
        }

    }


}