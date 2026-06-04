package com.stardevllc.beans.collections.list;

import com.stardevllc.beans.Observable;
import com.stardevllc.beans.collections.AbstractObservableCollection;

import java.util.*;

/**
 * An abstract class that provides common functionality for obserable lists
 *
 * @param <E> The element ty pe
 */
@SuppressWarnings("RedundantNoArgConstructor")
public abstract class AbstractObservableList<E> extends AbstractObservableCollection<E> implements ObservableList<E> {
    
    protected final List<ChangeListener<E>> changeListeners = new ArrayList<>();
    
    /**
     * Constructs an empty obserable list
     */
    public AbstractObservableList() {
    }
    
    @Override
    public List<E> asList() {
        return new AbstractList<>() {
            @Override
            public E get(int index) {
                return AbstractObservableList.this.get(index);
            }
            
            @Override
            public int size() {
                return AbstractObservableList.this.size();
            }
        };
    }
    
    @Override
    public void addChangeListener(ChangeListener<E> changeListener) {
        this.changeListeners.add(changeListener);
    }
    
    @Override
    public void removeChangeListener(ChangeListener<E> changeListener) {
        this.changeListeners.remove(changeListener);
    }
    
    protected boolean handleChange(Change<E> change) {
        for (ChangeListener<E> changeListener : this.changeListeners) {
            changeListener.changed(change);
            if (change.isCancelled()) {
                return false;
            }
        }
        
        return change.isCancelled();
    }
    
    protected boolean handleChange(int index, E added, E removed) {
        return handleChange(new Change<>(this, index, added, removed));
    }
    
    @Override
    public Iterator<E> iterator() {
        return listIterator();
    }
    
    @Override
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }
    
    public boolean add(E e) {
        add(size(), e);
        return true;
    }
    
    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }
    
    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }
    
    public E remove(int index) {
        throw new UnsupportedOperationException();
    }
    
    public int indexOf(Object o) {
        ListIterator<E> it = listIterator();
        if (o == null) {
            while (it.hasNext())
                if (it.next() == null)
                    return it.previousIndex();
        } else {
            while (it.hasNext())
                if (o.equals(it.next()))
                    return it.previousIndex();
        }
        return -1;
    }
    
    public int lastIndexOf(Object o) {
        ListIterator<E> it = listIterator(size());
        if (o == null) {
            while (it.hasPrevious())
                if (it.previous() == null)
                    return it.nextIndex();
        } else {
            while (it.hasPrevious())
                if (o.equals(it.previous()))
                    return it.nextIndex();
        }
        return -1;
    }
    
    public void clear() {
        removeRange(0, size());
    }
    
    public boolean addAll(int index, Collection<? extends E> c) {
        rangeCheckForAdd(index);
        boolean modified = false;
        for (E e : c) {
            add(index++, e);
            modified = true;
        }
        return modified;
    }
    
    public List<E> subList(int fromIndex, int toIndex) {
        subListRangeCheck(fromIndex, toIndex, size());
        return new SubList<>(this, fromIndex, toIndex);
    }
    
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size();
    }
    
    protected void removeRange(int fromIndex, int toIndex) {
        ListIterator<E> it = listIterator(fromIndex);
        for (int i = 0, n = toIndex - fromIndex; i < n; i++) {
            it.next();
            it.remove();
        }
    }
    
    static void subListRangeCheck(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (toIndex > size)
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                    ") > toIndex(" + toIndex + ")");
    }
    
    private static class SubList<E> extends AbstractObservableList<E> {
        private final AbstractObservableList<E> root;
        private final AbstractObservableList.SubList<E> parent;
        private final int offset;
        protected int size;
        
        /**
         * Constructs a sublist of an arbitrary AbstractList, which is
         * not a SubList itself.
         */
        public SubList(AbstractObservableList<E> root, int fromIndex, int toIndex) {
            this.root = root;
            this.parent = null;
            this.offset = fromIndex;
            this.size = toIndex - fromIndex;
        }
        
        /**
         * Constructs a sublist of another SubList.
         */
        protected SubList(SubList<E> parent, int fromIndex, int toIndex) {
            this.root = parent.root;
            this.parent = parent;
            this.offset = parent.offset + fromIndex;
            this.size = toIndex - fromIndex;
        }
        
        public E set(int index, E element) {
            Objects.checkIndex(index, size);
            return root.set(offset + index, element);
        }
        
        public E get(int index) {
            Objects.checkIndex(index, size);
            return root.get(offset + index);
        }
        
        public int size() {
            return size;
        }
        
        public void add(int index, E element) {
            rangeCheckForAdd(index);
            root.add(offset + index, element);
            updateSize(1);
        }
        
        public E remove(int index) {
            Objects.checkIndex(index, size);
            E result = root.remove(offset + index);
            updateSize(-1);
            return result;
        }
        
        protected void removeRange(int fromIndex, int toIndex) {
            root.removeRange(offset + fromIndex, offset + toIndex);
            updateSize(fromIndex - toIndex);
        }
        
        public boolean addAll(Collection<? extends E> c) {
            return addAll(size, c);
        }
        
        public boolean addAll(int index, Collection<? extends E> c) {
            rangeCheckForAdd(index);
            int cSize = c.size();
            if (cSize == 0)
                return false;
            root.addAll(offset + index, c);
            updateSize(cSize);
            return true;
        }
        
        public ListIterator<E> listIterator(int index) {
            rangeCheckForAdd(index);
            
            return new ListIterator<>() {
                private final ListIterator<E> i =
                        root.listIterator(offset + index);
                
                public boolean hasNext() {
                    return nextIndex() < size;
                }
                
                public E next() {
                    if (hasNext())
                        return i.next();
                    else
                        throw new NoSuchElementException();
                }
                
                public boolean hasPrevious() {
                    return previousIndex() >= 0;
                }
                
                public E previous() {
                    if (hasPrevious())
                        return i.previous();
                    else
                        throw new NoSuchElementException();
                }
                
                public int nextIndex() {
                    return i.nextIndex() - offset;
                }
                
                public int previousIndex() {
                    return i.previousIndex() - offset;
                }
                
                public void remove() {
                    i.remove();
                    updateSize(-1);
                }
                
                public void set(E e) {
                    i.set(e);
                }
                
                public void add(E e) {
                    i.add(e);
                    updateSize(1);
                }
            };
        }
        
        public List<E> subList(int fromIndex, int toIndex) {
            subListRangeCheck(fromIndex, toIndex, size);
            return new SubList<>(this, fromIndex, toIndex);
        }
        
        private void rangeCheckForAdd(int index) {
            if (index < 0 || index > size)
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
        
        private String outOfBoundsMsg(int index) {
            return "Index: " + index + ", Size: " + size;
        }
        
        private void updateSize(int sizeChange) {
            SubList<E> slist = this;
            do {
                slist.size += sizeChange;
                slist = slist.parent;
            } while (slist != null);
        }
    }
    
    /**
     * The obserable list iterator that allows for listening to changes when using an iterator
     *
     * @param <E> The element type
     */
    protected static class ObservableListIterator<E> implements Observable, ListIterator<E> {
        
        /**
         * The backing obserable list
         */
        protected final AbstractObservableList<E> backingList;
        
        /**
         * The backing iterator
         */
        protected final ListIterator<E> backingIterator;
        
        /**
         * The current element of the iterator
         */
        protected E current;
        
        /**
         * Constructs a new obserable list iterator
         *
         * @param backingList     The backing list
         * @param backingIterator The backing iterator
         */
        public ObservableListIterator(AbstractObservableList<E> backingList, ListIterator<E> backingIterator) {
            this.backingList = backingList;
            this.backingIterator = backingIterator;
        }
        
        /**
         * Constructs a new obserable list iterator
         *
         * @param backingList     The backing list
         * @param backingIterator The backing iterator
         * @param startingIndex   The index to start at
         */
        public ObservableListIterator(AbstractObservableList<E> backingList, ListIterator<E> backingIterator, int startingIndex) {
            this(backingList, backingIterator);
            for (int i = 0; i < startingIndex; i++) {
                next();
            }
        }
        
        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return backingIterator.hasNext();
        }
        
        /**
         * {@inheritDoc}
         */
        @Override
        public E next() {
            current = backingIterator.next();
            return current;
        }
        
        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasPrevious() {
            return backingIterator.hasPrevious();
        }
        
        /**
         * {@inheritDoc}
         */
        @Override
        public E previous() {
            current = backingIterator.previous();
            return current;
        }
        
        /**
         * {@inheritDoc}
         */
        @Override
        public int nextIndex() {
            return backingIterator.nextIndex();
        }
        
        /**
         * {@inheritDoc}
         */
        @Override
        public int previousIndex() {
            return backingIterator.previousIndex();
        }
        
        /**
         * {@inheritDoc}
         */
        @Override
        public void remove() {
            if (!backingList.handleChange(nextIndex() - 1, null, current)) {
                backingIterator.remove();
            }
        }
        
        /**
         * {@inheritDoc}
         */
        @Override
        public void set(E e) {
            if (!backingList.handleChange(nextIndex() - 1, e, current)) {
                backingIterator.set(e);
            }
        }
        
        /**
         * {@inheritDoc}
         */
        @Override
        public void add(E e) {
            if (!backingList.handleChange(nextIndex() - 1, e, null)) {
                backingIterator.add(e);
            }
        }
    }
}
