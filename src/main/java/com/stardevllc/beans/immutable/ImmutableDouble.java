package com.stardevllc.beans.immutable;

import com.stardevllc.beans.value.DoubleValue;

public final class ImmutableDouble implements DoubleValue {
    
    public static ImmutableDouble of(double value) {
        return new ImmutableDouble(value);
    }
    
    private final double value;
    
    public ImmutableDouble(double value) {
        this.value = value;
    }
    
    public double get() {
        return value;
    }
    
    @Override
    public Double getValue() {
        return get();
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Double v) {
            return value == v;
        }
        
        return this == obj;
    }
    
    @Override
    public ImmutableDouble plus(byte other) {
        return new ImmutableDouble(this.value + other);
    }
    
    @Override
    public ImmutableDouble plus(short other) {
        return new ImmutableDouble(this.value + other);
    }
    
    @Override
    public ImmutableDouble plus(int other) {
        return new ImmutableDouble(this.value + other);
    }
    
    @Override
    public ImmutableDouble plus(long other) {
        return new ImmutableDouble(this.value + other);
    }
    
    @Override
    public ImmutableDouble plus(float other) {
        return new ImmutableDouble(this.value + other);
    }
    
    @Override
    public ImmutableDouble plus(double other) {
        return new ImmutableDouble(this.value + other);
    }
    
    @Override
    public ImmutableDouble minus(byte other) {
        return new ImmutableDouble(this.value - other);
    }
    
    @Override
    public ImmutableDouble minus(short other) {
        return new ImmutableDouble(this.value - other);
    }
    
    @Override
    public ImmutableDouble minus(int other) {
        return new ImmutableDouble(this.value - other);
    }
    
    @Override
    public ImmutableDouble minus(long other) {
        return new ImmutableDouble(this.value - other);
    }
    
    @Override
    public ImmutableDouble minus(float other) {
        return new ImmutableDouble(this.value - other);
    }
    
    @Override
    public ImmutableDouble minus(double other) {
        return new ImmutableDouble(this.value - other);
    }
    
    @Override
    public ImmutableDouble multiply(byte other) {
        return new ImmutableDouble(this.value * other);
    }
    
    @Override
    public ImmutableDouble multiply(short other) {
        return new ImmutableDouble(this.value * other);
    }
    
    @Override
    public ImmutableDouble multiply(int other) {
        return new ImmutableDouble(this.value * other);
    }
    
    @Override
    public ImmutableDouble multiply(long other) {
        return new ImmutableDouble(this.value * other);
    }
    
    @Override
    public ImmutableDouble multiply(float other) {
        return new ImmutableDouble(this.value * other);
    }
    
    @Override
    public ImmutableDouble multiply(double other) {
        return new ImmutableDouble(this.value * other);
    }
    
    @Override
    public ImmutableDouble divide(byte other) {
        return new ImmutableDouble(this.value / other);
    }
    
    @Override
    public ImmutableDouble divide(short other) {
        return new ImmutableDouble(this.value / other);
    }
    
    @Override
    public ImmutableDouble divide(int other) {
        return new ImmutableDouble(this.value / other);
    }
    
    @Override
    public ImmutableDouble divide(long other) {
        return new ImmutableDouble(this.value / other);
    }
    
    @Override
    public ImmutableDouble divide(float other) {
        return new ImmutableDouble(this.value / other);
    }
    
    @Override
    public ImmutableDouble divide(double other) {
        return new ImmutableDouble(this.value / other);
    }
}