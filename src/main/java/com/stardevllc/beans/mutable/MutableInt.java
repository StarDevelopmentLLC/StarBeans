package com.stardevllc.beans.mutable;

import com.stardevllc.beans.value.IntValue;
import com.stardevllc.starlib.values.MutableValue;

public class MutableInt implements IntValue, MutableValue<Integer> {
    
    public static MutableInt of() {
        return new MutableInt();
    }
    
    public static MutableInt of(int value) {
        return new MutableInt(value);
    }
    
    protected int value;
    
    public MutableInt() {}
    
    public MutableInt(int value) {
        this.value = value;
    }
    
    public void set(int value) {
        this.value = value;
    }
    
    @Override
    public MutableInt plus(byte other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableInt plus(short other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableInt plus(int other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableInt minus(byte other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableInt minus(short other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableInt minus(int other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableInt multiply(byte other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableInt multiply(short other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableInt multiply(int other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableInt divide(byte other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public MutableInt divide(short other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public MutableInt divide(int other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public void setValue(Integer value) {
        set(value);
    }
    
    public int get() {
        return value;
    }
    
    @Override
    public Integer getValue() {
        return get();
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
