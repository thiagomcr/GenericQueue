package edu.gcccd.csis;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;


public class GenericQueueTest {

    private double[] doubleElements = {1.1, 2.2, 3.3, 4.4, 5.5};
    GenericQueue<Double> doubleQueue;


    @Test
    public void enqueue() throws Exception {
        doubleQueue = new GenericQueue<>();

        for(double value: doubleElements){
            doubleQueue.enqueue(value);//push onto doubleQueue
        }
        assertEquals(5, doubleQueue.length());

        doubleQueue.enqueue(7.7);
        assertTrue(doubleQueue.getElements().indexOf(7.7) == 5);

    }

    @Test
    public void dequeue() throws Exception {
        doubleQueue = new GenericQueue<>(5);

        for(double value: doubleElements){
            doubleQueue.enqueue(value);
        }

        assertTrue( doubleQueue.dequeue()==1.1);
    }

    @Test
    public void length() throws Exception {
        doubleQueue = new GenericQueue<>();

        assertEquals(0,doubleQueue.length());

        doubleQueue.enqueue(1.1);
        doubleQueue.enqueue(2.2);
        doubleQueue.enqueue(3.3);

        assertEquals(3, doubleQueue.length());

        doubleQueue.dequeue();
        doubleQueue.dequeue();
        doubleQueue.dequeue();

        assertEquals(0,doubleQueue.length());

        try {
            doubleQueue.dequeue();
            fail();
        } catch (NoSuchElementException ex){
            assertTrue(true);
        }
    }
}