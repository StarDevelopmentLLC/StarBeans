package com.stardevllc.beans.collections.set;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ObservableLinkedHashSet<E> extends AbstractObservableSequencedSet<E> {
    
    private final LinkedHashSet<E> backingLinkedHashSet = new LinkedHashSet<>();
    
    public ObservableLinkedHashSet() {
        
    }
    
    public ObservableLinkedHashSet(Collection<E> collection) {
        this.backingLinkedHashSet.addAll(collection);
    }
    
    @Override
    public boolean add(E e) {
        if (handleChange(e, null)) {
            return this.backingLinkedHashSet.add(e);
        }
        
        return false;
    }
    
    @Override
    public boolean contains(Object o) {
        return this.backingLinkedHashSet.contains(o);
    }
    
    @Override
    public boolean remove(Object o) {
        if (handleChange(null, (E) o)) {
            this.backingLinkedHashSet.remove(o);
        }
        
        return false;
    }
    
    @Override
    public int size() {
        return backingLinkedHashSet.size();
    }
    
    @Override
    public @NotNull Iterator<E> iterator() {
        return new Itr(this.backingLinkedHashSet.iterator());
    }
    
    @Override
    public @NotNull ObservableLinkedHashSet<E> reversed() {
        class Reversed extends ObservableLinkedHashSet<E> {
            @Override
            public boolean add(E e) {
                return ObservableLinkedHashSet.this.add(e);
            }
            
            @Override
            public boolean contains(Object o) {
                return ObservableLinkedHashSet.this.contains(o);
            }
            
            @Override
            public boolean remove(Object o) {
                return ObservableLinkedHashSet.this.remove(o);
            }
            
            @Override
            public int size() {
                return ObservableLinkedHashSet.this.size();
            }
            
            @Override
            public @NotNull Iterator<E> iterator() {
                return new Itr(ObservableLinkedHashSet.this.backingLinkedHashSet.reversed().iterator());
            }
            
            @Override
            public @NotNull ObservableLinkedHashSet<E> reversed() {
                return ObservableLinkedHashSet.this;
            }
            
            @Override
            public void addFirst(E e) {
                ObservableLinkedHashSet.this.addLast(e);
            }
            
            @Override
            public void addLast(E e) {
                ObservableLinkedHashSet.this.addFirst(e);
            }
            
            @Override
            public E getFirst() {
                return ObservableLinkedHashSet.this.getLast();
            }
            
            @Override
            public E getLast() {
                return ObservableLinkedHashSet.this.getFirst();
            }
            
            @Override
            public E removeFirst() {
                return ObservableLinkedHashSet.this.removeLast();
            }
            
            @Override
            public E removeLast() {
                return ObservableLinkedHashSet.this.removeFirst();
            }
        }
        
        return new Reversed();
    }
    
    private class Itr implements Iterator<E> {
        
        private final Iterator<E> backingIterator;
        private E current;
        
        private Itr(Iterator<E> backingIterator) {
            this.backingIterator = backingIterator;
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
