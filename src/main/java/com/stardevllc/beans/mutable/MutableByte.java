package com.stardevllc.beans.mutable;

import com.stardevllc.beans.value.ByteValue;
import com.stardevllc.starlib.values.MutableValue;

public class MutableByte implements ByteValue, MutableValue<Byte> {
    
    public static MutableByte of() {
        return new MutableByte();
    }
    
    public static MutableByte of(byte value) {
        return new MutableByte(value);
    }
    
    protected byte value;
    
    public MutableByte() {}
    
    public MutableByte(byte value) {
        this.value = value;
    }
    
    @Override
    public ByteValue plus(byte other) {
        this.value += other;
        return this;
    }
    
    @Override
    public ByteValue minus(byte other) {
        this.value -= other;
        return this;
    }
    
    @Override
    public ByteValue multiply(byte other) {
        this.value *= other;
        return this;
    }
    
    @Override
    public ByteValue divide(byte other) {
        this.value /= other;
        return this;
    }
    
    public void set(byte value) {
        this.value = value;
    }
    
    @Override
    public void setValue(Byte value) {
        set(value);
    }
    
    public byte get() {
        return value;
    }
    
    @Override
    public Byte getValue() {
        return get();
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
    
    @Override
    public boolean equals(Object obj) {
        return switch(obj) {
            case Byte b -> get() == b;
            case ByteValue bv -> get() == bv.get();
            default -> false;
        };
    }
}
