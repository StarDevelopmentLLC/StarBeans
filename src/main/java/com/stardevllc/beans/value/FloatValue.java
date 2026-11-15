package com.stardevllc.beans.value;

public interface FloatValue extends NumberValue<Float> {
    float get();
    
    FloatValue plus(byte other);
    
    default FloatValue plus(ByteValue other) {
        return plus(other.get());
    }
    
    FloatValue plus(short other);
    
    default FloatValue plus(ShortValue other) {
        return plus(other.get());
    }
    
    FloatValue plus(int other);
    
    default FloatValue plus(IntValue other) {
        return plus(other.get());
    }
    
    FloatValue plus(long other);
    
    default FloatValue plus(LongValue other) {
        return plus(other.get());
    }
    
    FloatValue plus(float other);
    
    default FloatValue plus(FloatValue other) {
        return plus(other.get());
    }
    
    FloatValue minus(byte other);
    
    default FloatValue minus(ByteValue other) {
        return minus(other.get());
    }
    
    FloatValue minus(short other);
    
    default FloatValue minus(ShortValue other) {
        return minus(other.get());
    }
    
    FloatValue minus(int other);
    
    default FloatValue minus(IntValue other) {
        return minus(other.get());
    }
    
    FloatValue minus(long other);
    
    default FloatValue minus(LongValue other) {
        return minus(other.get());
    }
    
    FloatValue minus(float other);
    
    default FloatValue minus(FloatValue other) {
        return minus(other.get());
    }
    
    FloatValue multiply(byte other);
    
    default FloatValue multiply(ByteValue other) {
        return multiply(other.get());
    }
    
    FloatValue multiply(short other);
    
    default FloatValue multiply(ShortValue other) {
        return multiply(other.get());
    }
    
    FloatValue multiply(int other);
    
    default FloatValue multiply(IntValue other) {
        return multiply(other.get());
    }
    
    FloatValue multiply(long other);
    
    default FloatValue multiply(LongValue other) {
        return multiply(other.get());
    }
    
    FloatValue multiply(float other);
    
    default FloatValue multiply(FloatValue other) {
        return multiply(other.get());
    }
    
    FloatValue divide(byte other);
    
    default FloatValue divide(ByteValue other) {
        return divide(other.get());
    }
    
    FloatValue divide(short other);
    
    default FloatValue divide(ShortValue other) {
        return divide(other.get());
    }
    
    FloatValue divide(int other);
    
    default FloatValue divide(IntValue other) {
        return divide(other.get());
    }
    
    FloatValue divide(long other);
    
    default FloatValue divide(LongValue other) {
        return divide(other.get());
    }
    
    FloatValue divide(float other);
    
    default FloatValue divide(FloatValue other) {
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
        return (long) get();
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