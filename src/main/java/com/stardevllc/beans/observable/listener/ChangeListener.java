package com.stardevllc.beans.observable.listener;

import com.stardevllc.beans.ObservableValue;

@FunctionalInterface
public interface ChangeListener<T> {
    void onChange(ObservableValue<T> observableValue, T oldValue, T newValue);    
}