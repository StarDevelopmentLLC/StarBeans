package com.stardevllc.beans.mutable;

import com.stardevllc.beans.value.DoubleValue;
import com.stardevllc.starlib.values.MutableValue;

public class MutableDouble implements MutableValue<Double>, DoubleValue {
    
    public static MutableDouble of() {
        return new MutableDouble();
    }
    
    public static MutableDouble of(double value) {
        return new MutableDouble(value);
    }
    
    protected double value;
    
    public MutableDouble() {}
    
    public MutableDouble(double value) {
        this.value = value;
    }
    
    public void set(double value) {
        this.value = value;
    }
    
    @Override
    public void setValue(Double value) {
        set(value);
    }
    
    public double get() {
        return value;
    }
    
    @Override
    public Double getValue() {
        return get();
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Double v) {
            return value == v;
        }
        
        return this == obj;
    }
    
    @Override
    public MutableDouble plus(byte other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableDouble plus(short other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableDouble plus(int other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableDouble plus(long other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableDouble plus(float other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableDouble plus(double other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableDouble minus(byte other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableDouble minus(short other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableDouble minus(int other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableDouble minus(long other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableDouble minus(float other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableDouble minus(double other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableDouble multiply(byte other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableDouble multiply(short other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableDouble multiply(int other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableDouble multiply(long other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableDouble multiply(float other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableDouble multiply(double other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableDouble divide(byte other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public MutableDouble divide(short other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public MutableDouble divide(int other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public MutableDouble divide(long other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public MutableDouble divide(float other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public MutableDouble divide(double other) {
        this.value /= other;
        return this;
    }
}
