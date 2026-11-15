package com.stardevllc.beans.mutable;

import com.stardevllc.beans.value.FloatValue;
import com.stardevllc.starlib.values.MutableValue;

public class MutableFloat implements MutableValue<Float>, FloatValue {
    
    public static MutableFloat of() {
        return new MutableFloat();
    }
    
    public static MutableFloat of(float value) {
        return new MutableFloat(value);
    }
    
    protected float value;
    
    public MutableFloat() {}
    
    public MutableFloat(float value) {
        this.value = value;
    }
    
    public void set(float value) {
        this.value = value;
    }
    
    @Override
    public void setValue(Float value) {
        set(value);
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
    
    @Override
    public MutableFloat plus(byte other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableFloat plus(short other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableFloat plus(int other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableFloat plus(long other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableFloat plus(float other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableFloat minus(byte other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableFloat minus(short other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableFloat minus(int other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableFloat minus(long other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableFloat minus(float other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableFloat multiply(byte other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableFloat multiply(short other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableFloat multiply(int other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableFloat multiply(long other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableFloat multiply(float other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableFloat divide(byte other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public MutableFloat divide(short other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public MutableFloat divide(int other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public MutableFloat divide(long other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public MutableFloat divide(float other) {
        this.value /= other;
        return this;
    }
}
