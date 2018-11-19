package com.designpattern.itecompo;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator{
    Stack<E> stack = new Stack();

    public CompositeIterator(Iterator iterator){
        stack.push(iterator);
    }
    @Override
    public Object next() {
        return null;
    }
    @Override
    public boolean hasNext() {
        return false;
    }
    @Override
    public void remove() {
        Iterator.super.remove();
    }
}