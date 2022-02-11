package ex0.online.test;

import ex0.online.Link;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class tests all of LinkTest's functions
 */
class LinkTest {


    @Test//Function test
    void getData() {
        Link t1=new Link(5);
        Link t2=new Link(0);
        Link t3=new Link(-5);
        Link t4=new Link(-100);
        Link t5=new Link(25);
       assertEquals(5,t1.getData());
        assertEquals(0,t2.getData());
        assertEquals(-5,t3.getData());
        assertEquals(-100,t4.getData());
        assertNotEquals(10,t5.getData());
    }

    @Test//Function test
    void setData() {
        Link t1=new Link(5);
        assertEquals(5,t1.getData());
        t1.setData(-7);
        assertEquals(-7,t1.getData());
        t1.setData(20);
        assertEquals(20,t1.getData());
    }

    @Test//Function test
    void getNext() {
        Link t1=new Link(5);
        Link t2=new Link(5,t1);
        assertEquals(t2.getNext(),t1);
        t1=new Link(5,t2);
        assertEquals(t1.getNext(),t2);
    }

    @Test//Function test
    void setNext() {
        Link t1=new Link(5);
        Link t2=new Link(5);
        assertEquals(t2.getNext(),null);
        t2.setNext(t1);
        assertEquals(t2.getNext(),t1);
        t2.setNext(null);
        assertEquals(t2.getNext(),null);
    }

}