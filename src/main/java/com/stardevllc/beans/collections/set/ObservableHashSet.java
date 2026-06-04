package com.stardevllc.beans.collections.set;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ObservableHashSet<E> extends AbstractObservableSet<E> {
    
    private final HashSet<E> backingHashSet = new HashSet<>();
    
    public ObservableHashSet() {
        
    }
    
    public ObservableHashSet(Collection<E> collection) {
        this.backingHashSet.addAll(collection);
    }
    
    @Override
    public int size() {
        return this.backingHashSet.size();
    }
    
    @Override
    public @NotNull Iterator<E> iterator() {
        return new Itr();
    }
    
    @Override
    public boolean add(E e) {
        if (handleChange(e, null)) {
            return this.backingHashSet.add(e);
        }
        
        return false;
    }
    
    @Override
    public boolean contains(Object o) {
        return this.backingHashSet.contains(o);
    }
    
    @Override
    public boolean remove(Object o) {
        if (handleChange(null, (E) o)) {
            this.backingHashSet.remove(o);
        }
        
        return false;
    }
    
    private class Itr implements Iterator<E> {
        
        private final Iterator<E> backingIterator;
        private E current;
        
        private Itr() {
            this.backingIterator = backingHashSet.iterator();
        }
        
        @Override
        public boolean hasNext() {
            return this.backingIterator.hasNext();
        }
        
        @Override
        public E next() {
            return current = this.backingIterator.next();
        }
        
        @Override
        public void remove() {
            if (handleChange(null, current)) {
                this.backingIterator.remove();
                this.current = null;
            }
        }
    }
}
