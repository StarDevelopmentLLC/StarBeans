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
    public LongValue plus(byte other) {
        this.value += other;
        return this;
    }
    
    @Override
    public LongValue plus(short other) {
        this.value += other;
        return this;
    }
    
    @Override
    public LongValue plus(int other) {
        this.value += other;
        return this;
    }
    
    @Override
    public LongValue plus(long other) {
        this.value += other;
        return this;
    }
    
    @Override
    public LongValue minus(byte other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public LongValue minus(short other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public LongValue minus(int other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public LongValue minus(long other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public LongValue multiply(byte other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public LongValue multiply(short other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public LongValue multiply(int other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public LongValue multiply(long other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public LongValue divide(byte other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public LongValue divide(short other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public LongValue divide(int other) {
        this.value /= other;
        return this;
    }
    
    @Override
    public LongValue divide(long other) {
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
