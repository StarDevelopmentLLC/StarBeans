package com.stardevllc.beans.mutable;

import com.stardevllc.beans.value.LongValue;
import com.stardevllc.starlib.values.MutableValue;

public class MutableLong implements LongValue, MutableValue<Long> {
    
    public static MutableLong of() {
        return new MutableLong();
    }
    
    public static MutableLong of(long value) {
        return new MutableLong(value);
    }
    
    protected long value;
    
    public MutableLong() {}
    
    public MutableLong(long value) {
        this.value = value;
    }
    
    public void set(long value) {
        this.value = value;
    }
    
    @Override
    public MutableLong plus(byte other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableLong plus(short other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableLong plus(int other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableLong plus(long other) {
        this.value += other;
        return this;
    }
    
    @Override
    public MutableLong minus(byte other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableLong minus(short other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableLong minus(int other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableLong minus(long other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public MutableLong multiply(byte other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableLong multiply(short other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableLong multiply(int other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableLong multiply(long other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public MutableLong divide(byte other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public MutableLong divide(short other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public MutableLong divide(int other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public MutableLong divide(long other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public void setValue(Long value) {
        set(value);
    }
    
    public long get() {
        return value;
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
