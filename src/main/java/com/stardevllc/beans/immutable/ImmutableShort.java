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
    public ShortValue plus(byte other) {
        return new ImmutableShort((short) (this.value + other));
    }
    
    @Override
    public ShortValue plus(short other) {
        return new ImmutableShort((short) (this.value + other));
    }
    
    @Override
    public ShortValue minus(byte other) {
        return new ImmutableShort((short) (this.value - other));
    }
    
    @Override
    public ShortValue minus(short other) {
        return new ImmutableShort((short) (this.value - other));
    }
    
    @Override
    public ShortValue multiply(byte other) {
        return new ImmutableShort((short) (this.value * other));
    }
    
    @Override
    public ShortValue multiply(short other) {
        return new ImmutableShort((short) (this.value * other));
    }
    
    @Override
    public ShortValue divide(byte other) {
        return new ImmutableShort((short) (this.value / other));
    }
    
    @Override
    public ShortValue divide(short other) {
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