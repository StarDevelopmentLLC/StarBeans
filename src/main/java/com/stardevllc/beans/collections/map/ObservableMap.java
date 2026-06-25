package com.stardevllc.beans.collections.map;

import com.stardevllc.beans.Observable;

import java.util.Map;

public interface ObservableMap<K, V> extends Observable, Map<K, V> {
    
    Map<K, V> asMap();
    
    void addChangeListener(ChangeListener<K, V> changeListener);
    
    void removeChangeListener(ChangeListener<K, V> changeListener);
    
    @FunctionalInterface
    interface ChangeListener<K, V> {
        void changed(Change<K, V> change);
    }
    
    final class Change<K, V> {
        private final ObservableMap<K, V> map;
        private final K key;
        private final V added, removed;
        private boolean cancelled;
        
        public Change(ObservableMap<K, V> map, K key, V added, V removed) {
            this.map = map;
            this.key = key;
            this.added = added;
            this.removed = removed;
        }
        
        public ObservableMap<K, V> getMap() {
            return map;
        }
        
        public K getKey() {
            return key;
        }
        
        public V getAdded() {
            return added;
        }
        
        public V getRemoved() {
            return removed;
        }
        
        public boolean isCancelled() {
            return cancelled;
        }
        
        public void setCancelled(boolean cancelled) {
            this.cancelled = cancelled;
        }
    }
}