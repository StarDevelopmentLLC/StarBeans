package com.stardevllc.beans.collections.map;

import java.util.*;

public class ObservableHashMap<K, V> extends AbstractObservableMap<K, V> {
    
    private final HashMap<K, V> backingHashMap = new HashMap<>();
    
    public ObservableHashMap() {
    }
    
    public ObservableHashMap(Map<K, V> map) {
        this.backingHashMap.putAll(map);
    }
    
    @Override
    public Map<K, V> asMap() {
        return this;
    }
    
    @Override
    public int size() {
        return this.backingHashMap.size();
    }
    
    @Override
    public boolean containsKey(Object key) {
        return this.backingHashMap.containsKey(key);
    }
    
    @Override
    public boolean containsValue(Object value) {
        return this.backingHashMap.containsValue(value);
    }
    
    @Override
    public V get(Object key) {
        return this.backingHashMap.get(key);
    }
    
    @Override
    public V put(K key, V value) {
        if (handleChange(key, value, get(key))) {
            return this.backingHashMap.put(key, value);
        }
        
        return null;
    }
    
    @Override
    public V remove(Object key) {
        if (handleChange((K) key, null, get(key))) {
            this.backingHashMap.remove(key);
        }
        
        return null;
    }
    
    private class KeyItr implements Iterator<K> {
        private final EntryItr iterator = new EntryItr();
        
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
        
        @Override
        public K next() {
            return iterator.next().getKey();
        }
        
        @Override
        public void remove() {
            iterator.remove();
        }
    }
    
    private class KeySet extends AbstractSet<K> {
        @Override
        public Iterator<K> iterator() {
            return new KeyItr();
        }
        
        @Override
        public int size() {
            return ObservableHashMap.this.size();
        }
    }
    
    @Override
    public Set<K> keySet() {
        return new KeySet();
    }
    
    private class ValueItr implements Iterator<V> {
        private final EntryItr iterator = new EntryItr();
        
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
        
        @Override
        public V next() {
            return iterator.next().getValue();
        }
        
        @Override
        public void remove() {
            iterator.remove();
        }
    }
    
    @Override
    public Collection<V> values() {
        return new AbstractCollection<>() {
            @Override
            public Iterator<V> iterator() {
                return new ValueItr();
            }
            
            @Override
            public int size() {
                return ObservableHashMap.this.size();
            }
        };
    }
    
    private class EntryItr implements Iterator<Entry<K, V>> {
        private final Iterator<Entry<K, V>> iterator = backingHashMap.entrySet().iterator();
        
        private Entry<K, V> current;
        
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
        
        @Override
        public Entry<K, V> next() {
            return current = iterator.next();
        }
        
        @Override
        public void remove() {
            if (current == null) {
                return;
            }
            
            if (handleChange(current.getKey(), null, current.getValue())) {
                iterator.remove();
                current = null;
            }
        }
    }
    
    protected class EntrySet extends AbstractSet<Entry<K, V>> {
        
        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new EntryItr();
        }
        
        @Override
        public int size() {
            return ObservableHashMap.this.size();
        }
    }
    
    @Override
    public Set<Entry<K, V>> entrySet() {
        return new EntrySet();
    }
}