package com.stardevllc.beans.value;

public interface LongValue extends NumberValue<Long> {
    long get();
    
    LongValue plus(byte other);
    
    default LongValue plus(ByteValue other) {
        return plus(other.get());
    }
    
    LongValue plus(short other);
    
    default LongValue plus(ShortValue other) {
        return plus(other.get());
    }
    
    LongValue plus(int other);
    
    default LongValue plus(IntValue other) {
        return plus(other.get());
    }
    
    LongValue plus(long other);
    
    default LongValue plus(LongValue other) {
        return plus(other.get());
    }
    
    LongValue minus(byte other);
    
    default LongValue minus(ByteValue other) {
        return minus(other.get());
    }
    
    LongValue minus(short other);
    
    default LongValue minus(ShortValue other) {
        return minus(other.get());
    }
    
    LongValue minus(int other);
    
    default LongValue minus(IntValue other) {
        return minus(other.get());
    }
    
    LongValue minus(long other);
    
    default LongValue minus(LongValue other) {
        return minus(other.get());
    }
    
    LongValue multiply(byte other);
    
    default LongValue multiply(ByteValue other) {
        return multiply(other.get());
    }
    
    LongValue multiply(short other);
    
    default LongValue multiply(ShortValue other) {
        return multiply(other.get());
    }
    
    LongValue multiply(int other);
    
    default LongValue multiply(IntValue other) {
        return multiply(other.get());
    }
    
    LongValue multiply(long other);
    
    default LongValue multiply(LongValue other) {
        return multiply(other.get());
    }
    
    LongValue divide(byte other);
    
    default LongValue divide(ByteValue other) {
        return divide(other.get());
    }
    
    LongValue divide(short other);
    
    default LongValue divide(ShortValue other) {
        return divide(other.get());
    }
    
    LongValue divide(int other);
    
    default LongValue divide(IntValue other) {
        return divide(other.get());
    }
    
    LongValue divide(long other);
    
    default LongValue divide(LongValue other) {
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
        return (int) get();
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