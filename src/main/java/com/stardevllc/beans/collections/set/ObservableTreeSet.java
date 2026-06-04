package com.stardevllc.beans.collections.set;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ObservableTreeSet<E> extends AbstractObservableSequencedSet<E> implements NavigableSet<E> {
    
    private final TreeSet<E> backingTreeSet;
    
    @SuppressWarnings("SortedCollectionWithNonComparableKeys")
    public ObservableTreeSet() {
        this.backingTreeSet = new TreeSet<>();
    }
    
    public ObservableTreeSet(Collection<E> collection) {
        this.backingTreeSet = new TreeSet<>(collection);
    }
    
    public ObservableTreeSet(Comparator<? super E> comparator) {
        this.backingTreeSet = new TreeSet<>(comparator);
    }
    
    @Override
    public boolean add(E e) {
        if (handleChange(e, null)) {
            return this.backingTreeSet.add(e);
        }
        
        return false;
    }
    
    @Override
    public boolean contains(Object o) {
        return this.backingTreeSet.contains(o);
    }
    
    @Override
    public boolean remove(Object o) {
        if (handleChange(null, (E) o)) {
            this.backingTreeSet.remove(o);
        }
        
        return false;
    }
    
    @Override
    public int size() {
        return backingTreeSet.size();
    }
    
    @Override
    public @Nullable E lower(E e) {
        return this.backingTreeSet.lower(e);
    }
    
    @Override
    public @Nullable E floor(E e) {
        return this.backingTreeSet.floor(e);
    }
    
    @Override
    public @Nullable E ceiling(E e) {
        return this.backingTreeSet.ceiling(e);
    }
    
    @Override
    public @Nullable E higher(E e) {
        return this.backingTreeSet.higher(e);
    }
    
    @Override
    public @Nullable E pollFirst() {
        if (handleChange(null, this.backingTreeSet.first())) {
            return this.backingTreeSet.pollFirst();
        }
        return null;
    }
    
    @Override
    public @Nullable E pollLast() {
        if (handleChange(null, this.backingTreeSet.last())) {
            return this.backingTreeSet.pollLast();
        }
        return null;
    }
    
    @Override
    public @NotNull Iterator<E> iterator() {
        return new Itr(this.backingTreeSet.iterator());
    }
    
    @Override
    public @NotNull ObservableTreeSet<E> descendingSet() {
        return null;
    }
    
    @Override
    public @NotNull Iterator<E> descendingIterator() {
        return new Itr(this.backingTreeSet.descendingIterator());
    }
    
    @Override
    public @NotNull NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return null;
    }
    
    @Override
    public @NotNull NavigableSet<E> headSet(E toElement, boolean inclusive) {
        return null;
    }
    
    @Override
    public @NotNull NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        return null;
    }
    
    @Override
    public @Nullable Comparator<? super E> comparator() {
        return this.backingTreeSet.comparator();
    }
    
    @Override
    public @NotNull SortedSet<E> subSet(E fromElement, E toElement) {
        return null;
    }
    
    @Override
    public @NotNull SortedSet<E> headSet(E toElement) {
        return null;
    }
    
    @Override
    public @NotNull SortedSet<E> tailSet(E fromElement) {
        return null;
    }
    
    @Override
    public E first() {
        return this.backingTreeSet.first();
    }
    
    @Override
    public E last() {
        return this.backingTreeSet.last();
    }
    
    @Override
    public @NotNull ObservableTreeSet<E> reversed() {
        class Reversed extends ObservableTreeSet<E> {
            @Override
            public boolean add(E e) {
                return ObservableTreeSet.this.add(e);
            }
            
            @Override
            public boolean contains(Object o) {
                return ObservableTreeSet.this.contains(o);
            }
            
            @Override
            public boolean remove(Object o) {
                return ObservableTreeSet.this.remove(o);
            }
            
            @Override
            public int size() {
                return ObservableTreeSet.this.size();
            }
            
            @Override
            public @NotNull Iterator<E> iterator() {
                return new Itr(ObservableTreeSet.this.backingTreeSet.reversed().iterator());
            }
            
            @Override
            public @NotNull ObservableTreeSet<E> reversed() {
                return ObservableTreeSet.this;
            }
            
            @Override
            public void addFirst(E e) {
                ObservableTreeSet.this.addLast(e);
            }
            
            @Override
            public void addLast(E e) {
                ObservableTreeSet.this.addFirst(e);
            }
            
            @Override
            public E getFirst() {
                return ObservableTreeSet.this.getLast();
            }
            
            @Override
            public E getLast() {
                return ObservableTreeSet.this.getFirst();
            }
            
            @Override
            public E removeFirst() {
                return ObservableTreeSet.this.removeLast();
            }
            
            @Override
            public E removeLast() {
                return ObservableTreeSet.this.removeFirst();
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
