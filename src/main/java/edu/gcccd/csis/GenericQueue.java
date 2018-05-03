package edu.gcccd.csis;

import sun.invoke.empty.Empty;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class GenericQueue<T> {

    private final ArrayList<T> elements;

    //no-argument constructor creates a queue of the default size
    public GenericQueue() { this(10); }

    //constructor creates a queue of the specified number of elements
    public GenericQueue(int capacity){
        int initCapacity = capacity > 0 ? capacity : 10; //validate
        elements = new ArrayList<T>(initCapacity);
    }

    //push element onto queue
    public void enqueue(T enqueueValue) {
        elements.add(enqueueValue);
    }

    //return the first element if not empty; else throw EmptyStackException
    public T dequeue() {
        if (elements.isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        //remove and return top element
        return elements.remove(0);
    }

    //return all elements
    public ArrayList<T> getElements() { return elements; }

    //return queue size
    public int length() { return elements.size(); }
}