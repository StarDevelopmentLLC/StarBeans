package com.stardevllc.beans.immutable;

import com.stardevllc.beans.value.BooleanValue;

public final class ImmutableBoolean implements BooleanValue {
    
    public static ImmutableBoolean of(boolean value) {
        return new ImmutableBoolean(value);
    }
    
    private final boolean value;
    
    public ImmutableBoolean(boolean value) {
        this.value = value;
    }
    
    public boolean get() {
        return value;
    }
    
    @Override
    public ImmutableBoolean and(BooleanValue other) {
        return new ImmutableBoolean(get() && other.get());
    }
    
    @Override
    public ImmutableBoolean and(boolean b) {
        return new ImmutableBoolean(get() && b);
    }
    
    @Override
    public ImmutableBoolean or(BooleanValue other) {
        return new ImmutableBoolean(get() || other.get());
    }
    
    @Override
    public ImmutableBoolean or(boolean b) {
        return new ImmutableBoolean(get() || b);
    }
    
    @Override
    public ImmutableBoolean not() {
        return new ImmutableBoolean(!get());
    }
    
    @Override
    public ImmutableBoolean xor(BooleanValue other) {
        return new ImmutableBoolean(get() ^ other.get());
    }
    
    @Override
    public ImmutableBoolean xor(boolean b) {
        return new ImmutableBoolean(get() ^ b);
    }
    
    @Override
    public Boolean getValue() {
        return get();
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
    
    @Override
    public boolean equals(Object obj) {
        return switch (obj) {
            case Boolean v -> value == v;
            case BooleanValue bv -> this.value == bv.get();
            case null, default -> false;
        };
    }
}