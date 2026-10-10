package com.stardevllc.beans.value;

public interface ByteValue extends NumberValue<Byte> {
    byte get();
    
    ByteValue plus(byte other);
    
    default ByteValue plus(ByteValue other) {
        return plus(other.get());
    }
    
    ByteValue minus(byte other);
    
    default ByteValue minus(ByteValue other) {
        return minus(other.get());
    }
    
    ByteValue multiply(byte other);
    
    default ByteValue multiply(ByteValue other) {
        return multiply(other.get());
    }
    
    ByteValue divide(byte other);
    
    default ByteValue divide(ByteValue other) {
        return divide(other.get());
    }
    
    @Override
    default byte byteValue() {
        return get();
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