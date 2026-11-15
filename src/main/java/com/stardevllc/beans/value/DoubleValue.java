package com.stardevllc.beans.value;

public interface DoubleValue extends NumberValue<Double> {
    double get();
    
    DoubleValue plus(byte other);
    
    default DoubleValue plus(ByteValue other) {
        return plus(other.get());
    }
    
    DoubleValue plus(short other);
    
    default DoubleValue plus(ShortValue other) {
        return plus(other.get());
    }
    
    DoubleValue plus(int other);
    
    default DoubleValue plus(IntValue other) {
        return plus(other.get());
    }
    
    DoubleValue plus(long other);
    
    default DoubleValue plus(LongValue other) {
        return plus(other.get());
    }
    
    DoubleValue plus(float other);
    
    default DoubleValue plus(FloatValue other) {
        return plus(other.get());
    }
    
    DoubleValue plus(double other);
    
    default DoubleValue plus(DoubleValue other) {
        return plus(other.get());
    }
    
    DoubleValue minus(byte other);
    
    default DoubleValue minus(ByteValue other) {
        return minus(other.get());
    }
    
    DoubleValue minus(short other);
    
    default DoubleValue minus(ShortValue other) {
        return minus(other.get());
    }
    
    DoubleValue minus(int other);
    
    default DoubleValue minus(IntValue other) {
        return minus(other.get());
    }
    
    DoubleValue minus(long other);
    
    default DoubleValue minus(LongValue other) {
        return minus(other.get());
    }
    
    DoubleValue minus(float other);
    
    default DoubleValue minus(FloatValue other) {
        return minus(other.get());
    }
    
    DoubleValue minus(double other);
    
    default DoubleValue minus(DoubleValue other) {
        return minus(other.get());
    }
    
    DoubleValue multiply(byte other);
    
    default DoubleValue multiply(ByteValue other) {
        return multiply(other.get());
    }
    
    DoubleValue multiply(short other);
    
    default DoubleValue multiply(ShortValue other) {
        return multiply(other.get());
    }
    
    DoubleValue multiply(int other);
    
    default DoubleValue multiply(IntValue other) {
        return multiply(other.get());
    }
    
    DoubleValue multiply(long other);
    
    default DoubleValue multiply(LongValue other) {
        return multiply(other.get());
    }
    
    DoubleValue multiply(float other);
    
    default DoubleValue multiply(FloatValue other) {
        return multiply(other.get());
    }
    
    DoubleValue multiply(double other);
    
    default DoubleValue multiply(DoubleValue other) {
        return multiply(other.get());
    }
    
    DoubleValue divide(byte other);
    
    default DoubleValue divide(ByteValue other) {
        return divide(other.get());
    }
    
    DoubleValue divide(short other);
    
    default DoubleValue divide(ShortValue other) {
        return divide(other.get());
    }
    
    DoubleValue divide(int other);
    
    default DoubleValue divide(IntValue other) {
        return divide(other.get());
    }
    
    DoubleValue divide(long other);
    
    default DoubleValue divide(LongValue other) {
        return divide(other.get());
    }
    
    DoubleValue divide(float other);
    
    default DoubleValue divide(FloatValue other) {
        return divide(other.get());
    }
    
    DoubleValue divide(double other);
    
    default DoubleValue divide(DoubleValue other) {
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
        return (float) get();
    }
}