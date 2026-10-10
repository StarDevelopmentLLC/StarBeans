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
    public LongValue plus(byte other) {
        return new ImmutableLong(this.value + other);
    }
    
    @Override
    public LongValue plus(short other) {
        return new ImmutableLong(this.value + other);
    }
    
    @Override
    public LongValue plus(int other) {
        return new ImmutableLong(this.value + other);
    }
    
    @Override
    public LongValue plus(long other) {
        return new ImmutableLong(this.value + other);
    }
    
    @Override
    public LongValue minus(byte other) {
        return new ImmutableLong(this.value - other);
    }
    
    @Override
    public LongValue minus(short other) {
        return new ImmutableLong(this.value - other);
    }
    
    @Override
    public LongValue minus(int other) {
        return new ImmutableLong(this.value - other);
    }
    
    @Override
    public LongValue minus(long other) {
        return new ImmutableLong(this.value - other);
    }
    
    @Override
    public LongValue multiply(byte other) {
        return new ImmutableLong(this.value * other);
    }
    
    @Override
    public LongValue multiply(short other) {
        return new ImmutableLong(this.value * other);
    }
    
    @Override
    public LongValue multiply(int other) {
        return new ImmutableLong(this.value * other);
    }
    
    @Override
    public LongValue multiply(long other) {
        return new ImmutableLong(this.value * other);
    }
    
    @Override
    public LongValue divide(byte other) {
        return new ImmutableLong(this.value / other);
    }
    
    @Override
    public LongValue divide(short other) {
        return new ImmutableLong(this.value / other);
    }
    
    @Override
    public LongValue divide(int other) {
        return new ImmutableLong(this.value / other);
    }
    
    @Override
    public LongValue divide(long other) {
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