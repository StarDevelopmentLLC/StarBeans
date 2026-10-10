package com.stardevllc.beans.value;

public interface IntValue extends NumberValue<Integer> {
    int get();
    
    IntValue plus(byte other);
    
    default IntValue plus(ByteValue other) {
        return plus(other.get());
    }
    
    IntValue plus(short other);
    
    default IntValue plus(ShortValue other) {
        return plus(other.get());
    }
    
    IntValue plus(int other);
    
    default IntValue plus(IntValue other) {
        return plus(other.get());
    }
    
    IntValue minus(byte other);
    
    default IntValue minus(ByteValue other) {
        return minus(other.get());
    }
    
    IntValue minus(short other);
    
    default IntValue minus(ShortValue other) {
        return minus(other.get());
    }
    
    IntValue minus(int other);
    
    default IntValue minus(IntValue other) {
        return minus(other.get());
    }
    
    IntValue multiply(byte other);
    
    default IntValue multiply(ByteValue other) {
        return multiply(other.get());
    }
    
    IntValue multiply(short other);
    
    default IntValue multiply(ShortValue other) {
        return multiply(other.get());
    }
    
    IntValue multiply(int other);
    
    default IntValue multiply(IntValue other) {
        return multiply(other.get());
    }
    
    IntValue divide(byte other);
    
    default IntValue divide(ByteValue other) {
        return divide(other.get());
    }
    
    IntValue divide(short other);
    
    default IntValue divide(ShortValue other) {
        return divide(other.get());
    }
    
    IntValue divide(int other);
    
    default IntValue divide(IntValue other) {
        return divide(other.get());
    }
    
    @Override
    default byte byteValue() {
        return (byte) get();
    }
    
    @Override
    default short shortValue() {
        return (short) get();
    }
    
    @Override
    default int intValue() {
        return get();
    }
    
    @Override
    default long longValue() {
        return get();
    }
    
    @Override
    default double doubleValue() {
        return get();
    }
    
    @Override
    default float floatValue() {
        return get();
    }
}