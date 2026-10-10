package com.stardevllc.beans.immutable;

import com.stardevllc.beans.value.IntValue;

public final class ImmutableInt implements IntValue {
    
    public static ImmutableInt of(int value) {
        return new ImmutableInt(value);
    }
    
    private final int value;
    
    public ImmutableInt(int value) {
        this.value = value;
    }
    
    public int get() {
        return value;
    }
    
    @Override
    public Integer getValue() {
        return get();
    }
    
    @Override
    public IntValue plus(byte other) {
        return new ImmutableInt(this.value + other);
    }
    
    @Override
    public IntValue plus(short other) {
        return new ImmutableInt(this.value + other);
    }
    
    @Override
    public IntValue plus(int other) {
        return new ImmutableInt(this.value + other);
    }
    
    @Override
    public IntValue minus(byte other) {
        return new ImmutableInt(this.value - other);
    }
    
    @Override
    public IntValue minus(short other) {
        return new ImmutableInt(this.value - other);
    }
    
    @Override
    public IntValue minus(int other) {
        return new ImmutableInt(this.value - other);
    }
    
    @Override
    public IntValue multiply(byte other) {
        return new ImmutableInt(this.value * other);
    }
    
    @Override
    public IntValue multiply(short other) {
        return new ImmutableInt(this.value * other);
    }
    
    @Override
    public IntValue multiply(int other) {
        return new ImmutableInt(this.value * other);
    }
    
    @Override
    public IntValue divide(byte other) {
        return new ImmutableInt(this.value / other);
    }
    
    @Override
    public IntValue divide(short other) {
        return new ImmutableInt(this.value / other);
    }
    
    @Override
    public IntValue divide(int other) {
        return new ImmutableInt(this.value / other);
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Integer v) {
            return value == v;
        }
        
        return this == obj;
    }
}