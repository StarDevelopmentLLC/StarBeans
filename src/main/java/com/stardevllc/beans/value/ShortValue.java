package com.stardevllc.beans.value;

public interface ShortValue extends NumberValue<Short> {
    short get();
    
    @Override
    default byte byteValue() {
        return (byte) get();
    }
    
    @Override
    default short shortValue() {
        return get();
    }
    
    @Override
    default int intValue() {
        return get();
    }
    
    @Override
    default long longValue() {
        return get();
    }
    
    @Override
    default double doubleValue() {
        return get();
    }
    
    @Override
    default float floatValue() {
        return get();
    }
}