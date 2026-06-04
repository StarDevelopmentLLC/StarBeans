package com.stardevllc.beans.collections.list;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Represents an ObservableArrayList
 *
 * @param <E> The element type
 */
public class ObservableArrayList<E> extends AbstractObservableList<E> {
    
    private final ArrayList<E> backingArrayList = new ArrayList<>();
    
    /**
     * Creates an empty observable array list
     */
    public ObservableArrayList() {
    }
    
    /**
     * Creates an observable array list from a collection
     *
     * @param collection The collection
     */
    public ObservableArrayList(Collection<E> collection) {
        if (collection != null) {
            backingArrayList.addAll(collection);
        }
    }
    
    public E set(int index, E element) {
        if (!this.handleChange(index, element, get(index))) {
            return this.backingArrayList.set(index, element);
        }
        
        return null;
    }
    
    public void add(int index, E element) {
        if (!this.handleChange(index, element, null)) {
            this.backingArrayList.add(index, element);
        }
    }
    
    public E remove(int index) {
        if (!this.handleChange(index, null, get(index))) {
            return this.backingArrayList.remove(index);
        }
        
        return null;
    }
    
    @Override
    public E get(int index) {
        return this.backingArrayList.get(index);
    }
    
    @Override
    public @NotNull ListIterator<E> listIterator(int index) {
        return new ObservableListIterator<>(this, this.backingArrayList.listIterator(index));
    }
    
    @Override
    public int size() {
        return this.backingArrayList.size();
    }
}