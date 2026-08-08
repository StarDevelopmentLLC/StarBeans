package com.stardevllc.beans.mutable;

import com.stardevllc.beans.value.BooleanValue;
import com.stardevllc.starlib.values.MutableValue;
import org.jetbrains.annotations.Contract;

public class MutableBoolean implements BooleanValue, MutableValue<Boolean> {
    
    public static MutableBoolean of() {
        return new MutableBoolean();
    }
    
    public static MutableBoolean of(boolean value) {
        return new MutableBoolean(value);
    }
    
    protected boolean value;
    
    public MutableBoolean() {}
    
    public MutableBoolean(boolean value) {
        this.value = value;
    }
    
    public void set(boolean value) {
        this.value = value;
    }
    
    @Override
    public void setValue(Boolean value) {
        set(value);
    }
    
    public boolean get() {
        return value;
    }
    
    @Override
    @Contract(mutates = "this")
    public MutableBoolean and(BooleanValue other) {
        this.value = get() && other.get();
        return this;
    }
    
    @Override
    @Contract(mutates = "this")
    public MutableBoolean and(boolean b) {
        this.value = get() && b;
        return this;
    }
    
    @Override
    @Contract(mutates = "this")
    public MutableBoolean or(BooleanValue other) {
        this.value = get() || other.get();
        return this;
    }
    
    @Override
    @Contract(mutates = "this")
    public MutableBoolean or(boolean b) {
        this.value = get() || b;
        return this;
    }
    
    @Override
    @Contract(mutates = "this")
    public MutableBoolean not() {
        this.value = !get();
        return this;
    }
    
    @Override
    @Contract(mutates = "this")
    public MutableBoolean xor(BooleanValue other) {
        this.value = get() ^ other.get();
        return this;
    }
    
    @Override
    @Contract(mutates = "this")
    public MutableBoolean xor(boolean b) {
        this.value = get() ^ b;
        return this;
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
