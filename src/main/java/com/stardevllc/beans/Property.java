package com.stardevllc.beans;

public interface Property<T> extends ObservableValue<T> {
    Object getBean();
    
    Class<T> getTypeClass();
    
    void bind(ObservableValue<T> other);
    
    void unbind();
    
    boolean isBound();
}