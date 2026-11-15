package com.stardevllc.beans.immutable;

import com.stardevllc.beans.value.FloatValue;

public final class ImmutableFloat implements FloatValue {
    
    public static ImmutableFloat of(float value) {
        return new ImmutableFloat(value);
    }
    
    private final float value;
    
    public ImmutableFloat(float value) {
        this.value = value;
    }
    
    @Override
    public ImmutableFloat plus(byte other) {
        return new ImmutableFloat(this.value + other);
    }
    
    @Override
    public ImmutableFloat plus(short other) {
        return new ImmutableFloat(this.value + other);
    }
    
    @Override
    public ImmutableFloat plus(int other) {
        return new ImmutableFloat(this.value + other);
    }
    
    @Override
    public ImmutableFloat plus(long other) {
        return new ImmutableFloat(this.value + other);
    }
    
    @Override
    public ImmutableFloat plus(float other) {
        return new ImmutableFloat(this.value + other);
    }
    
    @Override
    public ImmutableFloat minus(byte other) {
        return new ImmutableFloat(this.value - other);
    }
    
    @Override
    public ImmutableFloat minus(short other) {
        return new ImmutableFloat(this.value - other);
    }
    
    @Override
    public ImmutableFloat minus(int other) {
        return new ImmutableFloat(this.value - other);
    }
    
    @Override
    public ImmutableFloat minus(long other) {
        return new ImmutableFloat(this.value - other);
    }
    
    @Override
    public ImmutableFloat minus(float other) {
        return new ImmutableFloat(this.value - other);
    }
    
    @Override
    public ImmutableFloat multiply(byte other) {
        return new ImmutableFloat(this.value * other);
    }
    
    @Override
    public ImmutableFloat multiply(short other) {
        return new ImmutableFloat(this.value * other);
    }
    
    @Override
    public ImmutableFloat multiply(int other) {
        return new ImmutableFloat(this.value * other);
    }
    
    @Override
    public ImmutableFloat multiply(long other) {
        return new ImmutableFloat(this.value * other);
    }
    
    @Override
    public ImmutableFloat multiply(float other) {
        return new ImmutableFloat(this.value * other);
    }
    
    @Override
    public ImmutableFloat divide(byte other) {
        return new ImmutableFloat(this.value / other);
    }
    
    @Override
    public ImmutableFloat divide(short other) {
        return new ImmutableFloat(this.value / other);
    }
    
    @Override
    public ImmutableFloat divide(int other) {
        return new ImmutableFloat(this.value / other);
    }
    
    @Override
    public ImmutableFloat divide(long other) {
        return new ImmutableFloat(this.value / other);
    }
    
    @Override
    public ImmutableFloat divide(float other) {
        return new ImmutableFloat(this.value / other);
    }
    
    public float get() {
        return value;
    }
    
    @Override
    public Float getValue() {
        return get();
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Float v) {
            return value == v;
        }
        
        return this == obj;
    }
}