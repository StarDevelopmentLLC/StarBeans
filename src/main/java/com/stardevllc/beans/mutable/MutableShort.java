package com.stardevllc.beans.mutable;

import com.stardevllc.beans.value.ShortValue;
import com.stardevllc.starlib.values.MutableValue;

public class MutableShort implements ShortValue, MutableValue<Short> {
    
    public static MutableShort of() {
        return new MutableShort();
    }
    
    public static MutableShort of(short value) {
        return new MutableShort(value);
    }
    
    protected short value;
    
    public MutableShort() {}
    
    public MutableShort(short value) {
        this.value = value;
    }
    
    public void set(short value) {
        this.value = value;
    }
    
    @Override
    public void setValue(Short value) {
        set(value);
    }
    
    public short get() {
        return value;
    }
    
    @Override
    public ShortValue plus(byte other) {
        this.value += other;
        return this;
    }
    
    @Override
    public ShortValue plus(short other) {
        this.value += other;
        return this;
    }
    
    @Override
    public ShortValue minus(byte other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public ShortValue minus(short other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public ShortValue multiply(byte other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public ShortValue multiply(short other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public ShortValue divide(byte other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public ShortValue divide(short other) {
        this.value /= other;
        return this;
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
