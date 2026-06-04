package com.stardevllc.beans;

public interface MutableValue<T> extends Value<T> {
    void setValue(T value);
}