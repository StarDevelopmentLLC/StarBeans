package com.stardevllc.beans.value;

public interface ShortValue extends NumberValue<Short> {
    short get();
    
    ShortValue plus(byte other);
    
    default ShortValue plus(ByteValue other) {
        return plus(other.get());
    }
    
    ShortValue plus(short other);
    
    default ShortValue plus(ShortValue other) {
        return plus(other.get());
    }
    
    ShortValue minus(byte other);
    
    default ShortValue minus(ByteValue other) {
        return minus(other.get());
    }
    
    ShortValue minus(short other);
    
    default ShortValue minus(ShortValue other) {
        return minus(other.get());
    }
    
    ShortValue multiply(byte other);
    
    default ShortValue multiply(ByteValue other) {
        return multiply(other.get());
    }
    
    ShortValue multiply(short other);
    
    default ShortValue multiply(ShortValue other) {
        return multiply(other.get());
    }
    
    ShortValue divide(byte other);
    
    default ShortValue divide(ByteValue other) {
        return divide(other.get());
    }
    
    ShortValue divide(short other);
    
    default ShortValue divide(ShortValue other) {
        return divide(other.get());
    }
    
    @Override
    default byte byteValue() {
        return (byte) get();
    }
    
    @Override
    default short shortValue() {
        return get();
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