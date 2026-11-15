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
    public ImmutableInt plus(byte other) {
        return new ImmutableInt(this.value + other);
    }
    
    @Override
    public ImmutableInt plus(short other) {
        return new ImmutableInt(this.value + other);
    }
    
    @Override
    public ImmutableInt plus(int other) {
        return new ImmutableInt(this.value + other);
    }
    
    @Override
    public ImmutableInt minus(byte other) {
        return new ImmutableInt(this.value - other);
    }
    
    @Override
    public ImmutableInt minus(short other) {
        return new ImmutableInt(this.value - other);
    }
    
    @Override
    public ImmutableInt minus(int other) {
        return new ImmutableInt(this.value - other);
    }
    
    @Override
    public ImmutableInt multiply(byte other) {
        return new ImmutableInt(this.value * other);
    }
    
    @Override
    public ImmutableInt multiply(short other) {
        return new ImmutableInt(this.value * other);
    }
    
    @Override
    public ImmutableInt multiply(int other) {
        return new ImmutableInt(this.value * other);
    }
    
    @Override
    public ImmutableInt divide(byte other) {
        return new ImmutableInt(this.value / other);
    }
    
    @Override
    public ImmutableInt divide(short other) {
        return new ImmutableInt(this.value / other);
    }
    
    @Override
    public ImmutableInt divide(int other) {
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