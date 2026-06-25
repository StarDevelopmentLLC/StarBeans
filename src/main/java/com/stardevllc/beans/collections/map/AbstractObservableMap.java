package com.stardevllc.beans.collections.map;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public abstract class AbstractObservableMap<K, V> implements ObservableMap<K, V> {
    
    protected final List<ChangeListener<K, V>> changeListeners = new ArrayList<>();
    
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    
    @Override
    public void putAll(@NotNull Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }
    
    @Override
    public void clear() {
        Iterator<Entry<K, V>> iter = entrySet().iterator();
        while (iter.hasNext()) {
            iter.next();
            iter.remove();
        }
    }
    
    @Override
    public void addChangeListener(ChangeListener<K, V> changeListener) {
        this.changeListeners.add(changeListener);
    }
    
    @Override
    public void removeChangeListener(ChangeListener<K, V> changeListener) {
        this.changeListeners.remove(changeListener);
    }
    
    protected boolean handleChange(Change<K, V> change) {
        for (ChangeListener<K, V> changeListener : this.changeListeners) {
            changeListener.changed(change);
            if (change.isCancelled()) {
                return false;
            }
        }
        
        return !change.isCancelled();
    }
    
    protected boolean handleChange(K key, V added, V removed) {
        return handleChange(new Change<>(this, key, added, removed));
    }
}