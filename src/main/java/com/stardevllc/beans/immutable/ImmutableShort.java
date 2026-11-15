package com.stardevllc.beans.immutable;

import com.stardevllc.beans.value.ShortValue;

public final class ImmutableShort implements ShortValue {
    
    public static ImmutableShort of(short value) {
        return new ImmutableShort(value);
    }
    
    private final short value;
    
    public ImmutableShort(short value) {
        this.value = value;
    }
    
    public short get() {
        return value;
    }
    
    @Override
    public ImmutableShort plus(byte other) {
        return new ImmutableShort((short) (this.value + other));
    }
    
    @Override
    public ImmutableShort plus(short other) {
        return new ImmutableShort((short) (this.value + other));
    }
    
    @Override
    public ImmutableShort minus(byte other) {
        return new ImmutableShort((short) (this.value - other));
    }
    
    @Override
    public ImmutableShort minus(short other) {
        return new ImmutableShort((short) (this.value - other));
    }
    
    @Override
    public ImmutableShort multiply(byte other) {
        return new ImmutableShort((short) (this.value * other));
    }
    
    @Override
    public ImmutableShort multiply(short other) {
        return new ImmutableShort((short) (this.value * other));
    }
    
    @Override
    public ImmutableShort divide(byte other) {
        return new ImmutableShort((short) (this.value / other));
    }
    
    @Override
    public ImmutableShort divide(short other) {
        return new ImmutableShort((short) (this.value / other));
    }
    
    @Override
    public Short getValue() {
        return get();
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Short v) {
            return value == v;
        }
        
        return this == obj;
    }
}