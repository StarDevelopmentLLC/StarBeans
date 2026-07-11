package com.stardevllc.beans.iterator;

import com.stardevllc.starlib.function.IntBiObjectPredicate;
import com.stardevllc.starlib.function.IntObjectPredicate;

import java.util.List;
import java.util.ListIterator;

public class ObservableListIterator<E> implements ListIterator<E> {
    
    private final List<E> list;
    private final ListIterator<E> iterator;
    private final IntObjectPredicate<E> addPredicate, removePredicate;
    private final IntBiObjectPredicate<E> setPredicate;
    
    private int currentIndex;
    private E currentElement;
    
    public ObservableListIterator(List<E> list, ListIterator<E> iterator, IntObjectPredicate<E> addPredicate, IntObjectPredicate<E> removePredicate, IntBiObjectPredicate<E> setPredicate) {
        this.list = list;
        this.iterator = iterator;
        this.addPredicate = addPredicate;
        this.removePredicate = removePredicate;
        this.setPredicate = setPredicate;
    }
    
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
    
    @Override
    public E next() {
        nextIndex();
        return currentElement;
    }
    
    @Override
    public boolean hasPrevious() {
        return iterator.hasPrevious();
    }
    
    @Override
    public E previous() {
        previousIndex();
        return currentElement;
    }
    
    @Override
    public int nextIndex() {
        this.currentIndex = iterator.nextIndex();
        this.currentElement = list.get(currentIndex);
        return currentIndex;
    }
    
    @Override
    public int previousIndex() {
        this.currentIndex = iterator.previousIndex();
        this.currentElement = list.get(currentIndex);
        return currentIndex;
    }
    
    @Override
    public void remove() {
        if (removePredicate.test(this.currentIndex, this.currentElement)) {
            this.iterator.remove();
        }
    }
    
    @Override
    public void set(E e) {
        if (setPredicate.test(this.currentIndex, e, this.currentElement)) {
            this.iterator.set(e);
        }
    }
    
    @Override
    public void add(E e) {
        if (this.addPredicate.test(this.currentIndex, this.currentElement)) {
            this.iterator.add(e);
        }
    }
}
