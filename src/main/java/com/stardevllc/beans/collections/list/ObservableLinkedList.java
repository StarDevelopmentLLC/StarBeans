package com.stardevllc.beans.collections.list;

import com.stardevllc.beans.collections.ObservableSequencedCollection;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ObservableLinkedList<E> extends AbstractObservableList<E> implements ObservableSequencedCollection<E>, Deque<E> {
    
    private final LinkedList<E> backingLinkedList = new LinkedList<>();
    
    public ObservableLinkedList() {
    }
    
    public ObservableLinkedList(Collection<E> collection) {
        if (collection != null) {
            this.backingLinkedList.addAll(collection);
        }
    }
    
    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }
    
    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }
    
    @Override
    public E pollFirst() {
        return getFirst();
    }
    
    @Override
    public E pollLast() {
        return getLast();
    }
    
    @Override
    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }
    
    @Override
    public boolean removeLastOccurrence(Object o) {
        ListIterator<E> it = this.listIterator(size() - 1);
        
        while (it.hasPrevious()) {
            E previous = it.previous();
            if (Objects.equals(o, previous)) {
                it.remove();
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public boolean offer(E e) {
        return add(e);
    }
    
    @Override
    public E remove() {
        return removeFirst();
    }
    
    @Override
    public E poll() {
        return removeFirst();
    }
    
    @Override
    public void push(E e) {
        addFirst(e);
    }
    
    @Override
    public E pop() {
        return removeFirst();
    }
    
    @Override
    public void addFirst(E element) {
        if (!handleChange(0, element, null)) {
            this.backingLinkedList.addFirst(element);
        }
    }
    
    @Override
    public void addLast(E element) {
        if (!handleChange(size() - 1, element, null)) {
            this.backingLinkedList.addLast(element);
        }
    }
    
    @Override
    public E removeLast() {
        E last = this.getLast();
        if (!handleChange(size() - 1, null, last)) {
            return this.removeLast();
        }
        return null;
    }
    
    @Override
    public E removeFirst() {
        E first = this.getFirst();
        if (!handleChange(0, null, first)) {
            return this.removeFirst();
        }
        return null;
    }
    
    @Override
    public E get(int index) {
        return this.backingLinkedList.get(index);
    }
    
    @Override
    public E getLast() {
        return this.backingLinkedList.getLast();
    }
    
    @Override
    public E getFirst() {
        return this.backingLinkedList.getFirst();
    }
    
    @Override
    public @NotNull ListIterator<E> listIterator(int index) {
        return new ObservableListIterator<>(this, this.backingLinkedList.listIterator(index));
    }
    
    @Override
    public E peekFirst() {
        return this.backingLinkedList.peekFirst();
    }
    
    @Override
    public E peekLast() {
        return this.backingLinkedList.peekLast();
    }
    
    @Override
    public E element() {
        return this.backingLinkedList.element();
    }
    
    @Override
    public E peek() {
        return this.backingLinkedList.peek();
    }
    
    @Override
    public int size() {
        return this.backingLinkedList.size();
    }
    
    public E set(int index, E element) {
        if (!this.handleChange(index, element, get(index))) {
            return this.backingLinkedList.set(index, element);
        }
        
        return null;
    }
    
    public void add(int index, E element) {
        if (!this.handleChange(index, element, null)) {
            this.backingLinkedList.add(index, element);
        }
    }
    
    public E remove(int index) {
        if (!this.handleChange(index, null, get(index))) {
            return this.backingLinkedList.remove(index);
        }
        
        return null;
    }
    
    @Override
    public @NotNull Iterator<E> descendingIterator() {
        return new DescItr();
    }
    
    @Override
    public ObservableLinkedList<E> reversed() {
        return new Reversed();
    }
    
    private class Reversed extends ObservableLinkedList<E> {
        @Override
        public E set(int index, E element) {
            return ObservableLinkedList.this.set(ObservableLinkedList.this.size() - 1 - index, element);
        }
        
        @Override
        public void add(int index, E element) {
            ObservableLinkedList.this.add(ObservableLinkedList.this.size() - 1 - index, element);
        }
        
        @Override
        public E remove(int index) {
            return ObservableLinkedList.this.remove(ObservableLinkedList.this.size() - 1 - index);
        }
        
        @Override
        public @NotNull ListIterator<E> listIterator(int index) {
            return new DescItr();
        }
    }
    
    private class DescItr implements ListIterator<E> {
        
        private final ListIterator<E> backingIterator;
        private E current;
        
        public DescItr() {
            this.backingIterator = ObservableLinkedList.this.listIterator(ObservableLinkedList.this.size() - 1);
        }
        
        @Override
        public boolean hasNext() {
            return this.backingIterator.hasPrevious();
        }
        
        @Override
        public E next() {
            return current = this.backingIterator.previous();
        }
        
        @Override
        public boolean hasPrevious() {
            return this.backingIterator.hasNext();
        }
        
        @Override
        public E previous() {
            return current = this.backingIterator.next();
        }
        
        @Override
        public int nextIndex() {
            return this.backingIterator.previousIndex();
        }
        
        @Override
        public int previousIndex() {
            return this.backingIterator.nextIndex();
        }
        
        @Override
        public void remove() {
            if (!handleChange(nextIndex() - 1, null, current)) {
                this.backingIterator.remove();
                current = null;
            }
        }
        
        @Override
        public void set(E e) {
            if (!handleChange(nextIndex() - 1, e, current)) {
                this.backingIterator.set(e);
                this.current = e;
            }
        }
        
        @Override
        public void add(E e) {
            if (!handleChange(nextIndex() - 1, e, null)) {
                this.backingIterator.add(e);
                this.current = e;
            }
        }
    }
}