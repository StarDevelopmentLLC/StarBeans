package com.stardevllc.beans.value;

import com.stardevllc.starlib.values.Value;

public interface BooleanValue extends Value<Boolean> {
    boolean get();
    
    BooleanValue and(BooleanValue other);
    
    BooleanValue and(boolean b);
    
    BooleanValue or(BooleanValue other);
    
    BooleanValue or(boolean b);
    
    BooleanValue not();
    
    BooleanValue xor(BooleanValue other);
    
    BooleanValue xor(boolean b);
}