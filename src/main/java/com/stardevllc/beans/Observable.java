package com.stardevllc.beans;

import com.stardevllc.beans.observable.listener.InvalidationListener;

public interface Observable {
    default void addInvalidationListener(InvalidationListener listener) {
        
    }
    
    default void removeInvalidationListener(InvalidationListener listener) {
        
    }
    
    default void invalidate() {
        
    }
    
    default boolean isValid() {
        return true;
    }
}