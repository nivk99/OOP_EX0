package ex0.online.test;

import ex0.online.LinkedFloor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *This class checks all LinkedFloor functions
 */
class LinkedFloorTest {

    @Test//Function test
    void getSize() {
        LinkedFloor lis=new LinkedFloor();
        assertEquals(lis.getSize(),0);
        lis.enqueue(5,0);
        assertEquals(lis.getSize(),1);
        lis.enqueue(4,0);
        lis.enqueue(7,0);
        assertEquals(lis.getSize(),3);
        lis.dequeue();
        lis.dequeue();
        lis.dequeue();
        assertEquals(lis.getSize(),0);
    }

    @Test//Function test
    void isEmpty() {
        LinkedFloor lis=new LinkedFloor();
        assertTrue(lis.isEmpty());
    }

    @Test//Function test
    void enqueue() {
        LinkedFloor lis=new LinkedFloor();
        lis.enqueue(6,0);
        lis.enqueue(10,0);
        lis.enqueue(8,0);
        assertEquals(lis.getSize(),3);
    }

    @Test//Function test
    void dequeue() {
        LinkedFloor lis=new LinkedFloor();
        lis.enqueue(6,0);
        lis.enqueue(10,0);
        lis.enqueue(8,0);
        assertEquals(lis.getSize(),3);
        lis.dequeue();
        lis.dequeue();
        assertEquals(lis.getSize(),1);

    }

}