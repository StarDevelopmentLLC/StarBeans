package com.stardevllc.beans.immutable;

import com.stardevllc.beans.value.LongValue;

public final class ImmutableLong implements LongValue {
    
    public static ImmutableLong of(long value) {
        return new ImmutableLong(value);
    }
    
    private final long value;
    
    public ImmutableLong(long value) {
        this.value = value;
    }
    
    public long get() {
        return value;
    }
    
    @Override
    public ImmutableLong plus(byte other) {
        return new ImmutableLong(this.value + other);
    }
    
    @Override
    public ImmutableLong plus(short other) {
        return new ImmutableLong(this.value + other);
    }
    
    @Override
    public ImmutableLong plus(int other) {
        return new ImmutableLong(this.value + other);
    }
    
    @Override
    public ImmutableLong plus(long other) {
        return new ImmutableLong(this.value + other);
    }
    
    @Override
    public ImmutableLong minus(byte other) {
        return new ImmutableLong(this.value - other);
    }
    
    @Override
    public ImmutableLong minus(short other) {
        return new ImmutableLong(this.value - other);
    }
    
    @Override
    public ImmutableLong minus(int other) {
        return new ImmutableLong(this.value - other);
    }
    
    @Override
    public ImmutableLong minus(long other) {
        return new ImmutableLong(this.value - other);
    }
    
    @Override
    public ImmutableLong multiply(byte other) {
        return new ImmutableLong(this.value * other);
    }
    
    @Override
    public ImmutableLong multiply(short other) {
        return new ImmutableLong(this.value * other);
    }
    
    @Override
    public ImmutableLong multiply(int other) {
        return new ImmutableLong(this.value * other);
    }
    
    @Override
    public ImmutableLong multiply(long other) {
        return new ImmutableLong(this.value * other);
    }
    
    @Override
    public ImmutableLong divide(byte other) {
        return new ImmutableLong(this.value / other);
    }
    
    @Override
    public ImmutableLong divide(short other) {
        return new ImmutableLong(this.value / other);
    }
    
    @Override
    public ImmutableLong divide(int other) {
        return new ImmutableLong(this.value / other);
    }
    
    @Override
    public ImmutableLong divide(long other) {
        return new ImmutableLong(this.value / other);
    }
    
    @Override
    public Long getValue() {
        return get();
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Long v) {
            return value == v;
        }
        
        return this == obj;
    }
}