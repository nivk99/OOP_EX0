package ex0.online.test;

import ex0.Building;
import ex0.CallForElevator;
import ex0.algo.ElevatorAlgo;
import ex0.online.OnlineAlgo;
import ex0.simulator.Call_A;
import ex0.simulator.ElevetorCallList;
import ex0.simulator.Simulator_A;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.TimeZone;
import java.util.TimerTask;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *This class tests all the functions of OnlineAlgo
 * Initializes the variables
 */
class OnlineAlgoTest {
    Building stage0;
    ElevatorAlgo algo_stage0;
    Building stage1;
    ElevatorAlgo algo_stage1;
    Building stage2;
    ElevatorAlgo algo_stage2;
    Building stage3;
    ElevatorAlgo algo_stage3;
    Building stage4;
    ElevatorAlgo algo_stage4;
    Building stage5;
    ElevatorAlgo algo_stage5;
    Building stage6;
    ElevatorAlgo algo_stage6;
    Building stage7;
    ElevatorAlgo algo_stage7;
    Building stage8;
    ElevatorAlgo algo_stage8;
    Building stage9;
    ElevatorAlgo algo_stage9;
    //Initializes the variables
    public OnlineAlgoTest(){
        Simulator_A.initData(0,null);
        stage0 = Simulator_A.getBuilding();
        algo_stage0 = new OnlineAlgo(stage0);
        Simulator_A.initData(1,null);
        stage1 = Simulator_A.getBuilding();
        algo_stage1 = new OnlineAlgo(stage1);
        Simulator_A.initData(2,null);
        stage2 = Simulator_A.getBuilding();
        algo_stage2 =new OnlineAlgo(stage2);
        Simulator_A.initData(3,null);
        stage3 = Simulator_A.getBuilding();
        algo_stage3 =new OnlineAlgo(stage3);
        Simulator_A.initData(4,null);
        stage4= Simulator_A.getBuilding();
        algo_stage4 =new OnlineAlgo(stage4);
        Simulator_A.initData(5,null);
        stage5 = Simulator_A.getBuilding();
        algo_stage5 =new OnlineAlgo(stage5);
        Simulator_A.initData(6,null);
        stage6 = Simulator_A.getBuilding();
        algo_stage6 =new OnlineAlgo(stage6);
        Simulator_A.initData(7,null);
        stage7 = Simulator_A.getBuilding();
        algo_stage7 =new OnlineAlgo(stage7);
        Simulator_A.initData(8,null);
        stage8 = Simulator_A.getBuilding();
        algo_stage8 =new OnlineAlgo(stage8);
        Simulator_A.initData(9,null);
        stage9 = Simulator_A.getBuilding();
        algo_stage9 =new OnlineAlgo(stage9);
    }
    @Test//Function test
        //This is a function that checks whether he has received the building
    void getBuilding() {
      assertEquals( algo_stage0.getBuilding(),stage0);
       assertEquals( algo_stage1.getBuilding(),stage1);
        assertEquals( algo_stage2.getBuilding(),stage2);
        assertEquals( algo_stage3.getBuilding(),stage3);
        assertEquals( algo_stage4.getBuilding(),stage4);
        assertEquals( algo_stage5.getBuilding(),stage5);
        assertEquals( algo_stage6.getBuilding(),stage6);
        assertEquals( algo_stage7.getBuilding(),stage7);
        assertEquals( algo_stage8.getBuilding(),stage8);
        assertEquals( algo_stage9.getBuilding(),stage9);
        assertNotEquals(algo_stage9.getBuilding(),stage1);
        assertNotEquals(algo_stage4.getBuilding(),stage5);
        assertNotEquals(algo_stage2.getBuilding(),stage8);
    }

    @Test//Function test
    //This is a function that checks the name of the algorithm
    void algoName() {
       assertEquals(algo_stage0.algoName(),"Ex0_Online_Algorithm_Elevator");
        assertEquals(algo_stage1.algoName(),"Ex0_Online_Algorithm_Elevator");
        assertEquals(algo_stage2.algoName(),"Ex0_Online_Algorithm_Elevator");
        assertEquals(algo_stage3.algoName(),"Ex0_Online_Algorithm_Elevator");
        assertEquals(algo_stage4.algoName(),"Ex0_Online_Algorithm_Elevator");
        assertEquals(algo_stage5.algoName(),"Ex0_Online_Algorithm_Elevator");
        assertEquals(algo_stage6.algoName(),"Ex0_Online_Algorithm_Elevator");
        assertEquals(algo_stage7.algoName(),"Ex0_Online_Algorithm_Elevator");
        assertEquals(algo_stage8.algoName(),"Ex0_Online_Algorithm_Elevator");
        assertEquals(algo_stage9.algoName(),"Ex0_Online_Algorithm_Elevator");
   }

    //Continuation of the code is in:class OnlineAlgoTest2 and OnlineAlgoTest3

}