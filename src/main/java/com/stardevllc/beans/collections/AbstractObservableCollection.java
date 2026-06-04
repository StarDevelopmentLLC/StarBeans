package com.stardevllc.beans.collections;

import com.stardevllc.beans.observable.listener.InvalidationListener;
import com.stardevllc.starlib.helper.ArrayHelper;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * An abstract class for common elements between the different collections <br>
 * The real magic comes from the Iterator implementation as that should fully respect the observability of this collection
 *
 * @param <E> The collection's element type
 */
@SuppressWarnings("RedundantNoArgConstructor")
public abstract class AbstractObservableCollection<E> implements ObservableCollection<E> {
    
    private boolean valid = true;
    protected final List<InvalidationListener> invalidationListeners = new ArrayList<>();
    
    /**
     * Constructs an empty obserable collection
     */
    public AbstractObservableCollection() {
    }
    
    /**
     * The backing collection is what actually does the collection things
     *
     * @return The backing collection of this observable collection
     */
    @Deprecated
    protected Collection<E> getBackingCollection() {
        return new ArrayList<>();
    }
    
    @Override
    public final void addInvalidationListener(InvalidationListener listener) {
        this.invalidationListeners.add(listener);
    }
    
    @Override
    public final void removeInvalidationListener(InvalidationListener listener) {
        this.invalidationListeners.remove(listener);
    }
    
    @Override
    public final void invalidate() {
        this.valid = false;
        for (InvalidationListener invalidationListener : this.invalidationListeners) {
            invalidationListener.onInvalidate(this);
        }
        
        this.invalidationListeners.clear();
    }
    
    @Override
    public final boolean isValid() {
        return this.valid;
    }
    
    @Override
    public @NotNull Object[] toArray() {
        return ArrayHelper.toArray(this);
    }
    
    @Override
    public @NotNull <T> T[] toArray(@NotNull T[] a) {
        return ArrayHelper.toArray(this, a);
    }
    
    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public boolean contains(Object o) {
        Iterator<E> it = iterator();
        if (o == null) {
            while (it.hasNext())
                if (it.next() == null)
                    return true;
        } else {
            while (it.hasNext())
                if (o.equals(it.next()))
                    return true;
        }
        return false;
    }
    
    public boolean remove(Object o) {
        Iterator<E> it = iterator();
        if (o==null) {
            while (it.hasNext()) {
                if (it.next()==null) {
                    it.remove();
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (o.equals(it.next())) {
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }
    
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c)
            if (add(e))
                modified = true;
        return modified;
    }
    
    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<?> it = iterator();
        while (it.hasNext()) {
            if (c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }
    
    public boolean retainAll(Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }
    
    public void clear() {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }
}