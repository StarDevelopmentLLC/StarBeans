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
    public FloatValue plus(byte other) {
        return new ImmutableFloat(this.value + other);
    }
    
    @Override
    public FloatValue plus(short other) {
        return new ImmutableFloat(this.value + other);
    }
    
    @Override
    public FloatValue plus(int other) {
        return new ImmutableFloat(this.value + other);
    }
    
    @Override
    public FloatValue plus(long other) {
        return new ImmutableFloat(this.value + other);
    }
    
    @Override
    public FloatValue plus(float other) {
        return new ImmutableFloat(this.value + other);
    }
    
    @Override
    public FloatValue minus(byte other) {
        return new ImmutableFloat(this.value - other);
    }
    
    @Override
    public FloatValue minus(short other) {
        return new ImmutableFloat(this.value - other);
    }
    
    @Override
    public FloatValue minus(int other) {
        return new ImmutableFloat(this.value - other);
    }
    
    @Override
    public FloatValue minus(long other) {
        return new ImmutableFloat(this.value - other);
    }
    
    @Override
    public FloatValue minus(float other) {
        return new ImmutableFloat(this.value - other);
    }
    
    @Override
    public FloatValue multiply(byte other) {
        return new ImmutableFloat(this.value * other);
    }
    
    @Override
    public FloatValue multiply(short other) {
        return new ImmutableFloat(this.value * other);
    }
    
    @Override
    public FloatValue multiply(int other) {
        return new ImmutableFloat(this.value * other);
    }
    
    @Override
    public FloatValue multiply(long other) {
        return new ImmutableFloat(this.value * other);
    }
    
    @Override
    public FloatValue multiply(float other) {
        return new ImmutableFloat(this.value * other);
    }
    
    @Override
    public FloatValue divide(byte other) {
        return new ImmutableFloat(this.value / other);
    }
    
    @Override
    public FloatValue divide(short other) {
        return new ImmutableFloat(this.value / other);
    }
    
    @Override
    public FloatValue divide(int other) {
        return new ImmutableFloat(this.value / other);
    }
    
    @Override
    public FloatValue divide(long other) {
        return new ImmutableFloat(this.value / other);
    }
    
    @Override
    public FloatValue divide(float other) {
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