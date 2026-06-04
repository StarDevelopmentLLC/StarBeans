package com.stardevllc.beans.collections.set;

import com.stardevllc.beans.collections.AbstractObservableCollection;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObservableSet<E> extends AbstractObservableCollection<E> implements ObservableSet<E> {
    
    protected final List<ChangeListener<E>> changeListeners = new ArrayList<>();
    
    @Override
    public void addListener(ChangeListener<E> changeListener) {
        this.changeListeners.add(changeListener);
    }
    
    @Override
    public void removeListener(ChangeListener<E> changeListener) {
        this.changeListeners.remove(changeListener);
    }
    
    protected boolean handleChange(final Change<E> change) {
        for (ChangeListener<E> changeListener : changeListeners) {
            changeListener.changed(change);
            if (change.isCancelled()) {
                return false;
            }
        }
        
        return change.isCancelled();
    }
    
    protected boolean handleChange(final E added, final E removed) {
        return handleChange(new Change<>(this, added, removed));
    }
}
