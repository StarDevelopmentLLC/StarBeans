package com.stardevllc.beans.value;

import com.stardevllc.starlib.values.Value;

public interface NumberValue<N extends Number> extends Value<N> {
    byte byteValue();
    short shortValue();
    int intValue();
    long longValue();
    
    double doubleValue();
    float floatValue();
}