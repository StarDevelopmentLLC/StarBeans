package com.stardevllc.beans.collections.list;

import com.stardevllc.beans.collections.ObservableCollection;

import java.util.List;

public interface ObservableList<E> extends ObservableCollection<E>, List<E> {
    
    List<E> asList();
    
    void addChangeListener(ChangeListener<E> changeListener);
    
    void removeChangeListener(ChangeListener<E> changeListener);
    
    @FunctionalInterface
    interface ChangeListener<E> {
        void changed(Change<E> change);
    }
    
    final class Change<E> {
        private final ObservableList<E> list;
        private final int index;
        private final E added, removed;
        boolean cancelled;
        
        public Change(ObservableList<E> list, int index, E added, E removed) {
            this.list = list;
            this.index = index;
            this.added = added;
            this.removed = removed;
        }
        
        public ObservableList<E> list() {
            return list;
        }
        
        public int index() {
            return index;
        }
        
        public E added() {
            return this.added;
        }
        
        public E removed() {
            return this.removed;
        }
        
        public boolean isCancelled() {
            return cancelled;
        }
        
        public void setCancelled(boolean cancelled) {
            this.cancelled = cancelled;
        }
    }
}