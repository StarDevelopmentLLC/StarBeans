package com.stardevllc.beans.iterator;

import java.util.Iterator;
import java.util.function.Predicate;

/**
 * A wrapper implementation for an Iterator that can be observed for changes
 * @param <E> The element type
 */
public class ObservableIterator<E> implements Iterator<E> {
    
    private final Iterator<E> iterator;
    private final Predicate<E> predicate;
    
    private E current;
    
    public ObservableIterator(Iterator<E> iterator, Predicate<E> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }
    
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
    
    @Override
    public E next() {
        return current = iterator.next();
    }
    
    @Override
    public void remove() {
        if (predicate.test(current)) {
            iterator.remove();
            current = null;
        }
    }
}