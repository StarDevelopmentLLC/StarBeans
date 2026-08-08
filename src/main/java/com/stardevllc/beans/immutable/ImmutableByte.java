package com.stardevllc.beans.immutable;

import com.stardevllc.beans.value.ByteValue;

public final class ImmutableByte implements ByteValue {
    
    public static ImmutableByte of(byte value) {
        return new ImmutableByte(value);
    }
    
    private final byte value;
    
    public ImmutableByte(byte value) {
        this.value = value;
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