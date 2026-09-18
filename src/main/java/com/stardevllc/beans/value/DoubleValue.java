package com.stardevllc.beans.value;

public interface DoubleValue extends NumberValue<Double> {
    double get();
    
    @Override
    default byte byteValue() {
        return (byte) get();
    }
    
    @Override
    default short shortValue() {
        return (short) get();
    }
    
    @Override
    default int intValue() {
        return (int) get();
    }
    
    @Override
    default long longValue() {
        return (long) get();
    }
    
    @Override
    default double doubleValue() {
        return get();
    }
    
    @Override
    default float floatValue() {
        return (float) get();
    }
}