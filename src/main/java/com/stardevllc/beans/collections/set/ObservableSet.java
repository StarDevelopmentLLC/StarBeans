package com.stardevllc.beans.collections.set;

import com.stardevllc.beans.collections.ObservableCollection;

import java.util.Set;

public interface ObservableSet<E> extends ObservableCollection<E>, Set<E> {
    
    void addListener(ChangeListener<E> changeListener);
    
    void removeListener(ChangeListener<E> changeListener);
    
    @FunctionalInterface
    interface ChangeListener<E> {
        void changed(Change<E> change);
    }
    
    final class Change<E> {
        private final ObservableSet<E> set;
        private final E added, removed;
        boolean cancelled;
        
        public Change(ObservableSet<E> set, E added, E removed) {
            this.set = set;
            this.added = added;
            this.removed = removed;
        }
        
        public ObservableSet<E> set() {
            return set;
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
    
    @Deprecated
    default <S extends Set<E>> S addContentMirror(S set) {
        return null;
    }
}