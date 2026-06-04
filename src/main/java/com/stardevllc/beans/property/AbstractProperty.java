package com.stardevllc.beans.property;

import com.stardevllc.beans.ObservableValue;
import com.stardevllc.beans.Property;
import com.stardevllc.beans.observable.listener.ChangeListener;
import com.stardevllc.beans.observable.listener.InvalidationListener;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractProperty<T> implements Property<T> {
    private final Object bean;
    private final Class<T> typeClass;
    private final String name;
    
    private ObservableValue<T> boundValue;
    private ChangeListener<T> boundChangeListener;
    
    protected final List<ChangeListener<T>> changeListeners = new ArrayList<>();
    protected final List<InvalidationListener> invalidationListeners = new ArrayList<>();
    
    private boolean valid = true;
    
    public AbstractProperty(Class<T> typeClass) {
        this(null, typeClass, null);
    }
    
    public AbstractProperty(Object bean, Class<T> typeClass, String name) {
        this.bean = bean;
        this.typeClass = typeClass;
        this.name = name;
    }
    
    @Override
    public Object getBean() {
        return this.bean;
    }
    
    @Override
    public Class<T> getTypeClass() {
        return this.typeClass;
    }
    
    @Override
    public void bind(ObservableValue<T> other) {
        if (this.boundValue != null && this.boundChangeListener != null) {
            this.boundValue.removeChangeListener(this.boundChangeListener);
        }
        
        this.boundValue = other;
        this.boundChangeListener = (v, o, n) -> setValue(n);
        this.boundValue.addChangeListener(this.boundChangeListener);
    }
    
    protected final ObservableValue<T> getBoundValue() {
        return boundValue;
    }
    
    @Override
    public boolean isBound() {
        return this.boundValue != null;
    }
    
    @Override
    public void unbind() {
        this.boundValue = null;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public void addChangeListener(ChangeListener<T> listener) {
        this.changeListeners.add(listener);
    }
    
    @Override
    public void removeChangeListener(ChangeListener<T> listener) {
        this.changeListeners.remove(listener);
    }
    
    @Override
    public void addInvalidationListener(InvalidationListener listener) {
        this.invalidationListeners.add(listener);
    }
    
    @Override
    public void removeInvalidationListener(InvalidationListener listener) {
        this.invalidationListeners.remove(listener);
    }
    
    protected final void checkValid() {
        if (!isValid()) {
            throw new IllegalStateException(getClass().getSimpleName() + " is invalid");
        }
    }
    
    protected final void fireInvalidationListeners() {
        invalidationListeners.forEach(l -> l.onInvalidate(this));
    }
    
    protected final void fireChangeListeners(T oldValue, T newValue) {
        changeListeners.forEach(l -> l.onChange(this, oldValue, newValue));
    }
    
    @Override
    public void invalidate() {
        if (this.valid) {
            this.valid = false;
            fireInvalidationListeners();
            if (this.boundValue != null) {
                this.boundValue.removeChangeListener(this.boundChangeListener);
            }
            
            this.boundValue = null;
            this.boundChangeListener = null;
        }
    }
    
    @Override
    public boolean isValid() {
        return valid;
    }
}
