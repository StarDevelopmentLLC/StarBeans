package com.stardevllc.beans.collections.map;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ObservableTreeMap<K extends Comparable<K>, V> extends AbstractObservableMap<K, V> implements NavigableMap<K, V> {
    
    private final TreeMap<K, V> backingTreeMap = new TreeMap<>();
    
    /**
     * Creates an empty observable tree map
     */
    public ObservableTreeMap() {
    }
    
    /**
     * Creates an observable tree map from an existing map
     *
     * @param map The map
     */
    public ObservableTreeMap(Map<K, V> map) {
        if (map != null) {
            this.backingTreeMap.putAll(map);
        }
    }
    
    @Override
    public Map<K, V> asMap() {
        return this;
    }
    
    @Override
    public Entry<K, V> lowerEntry(K key) {
        return null; //TODO
    }
    
    @Override
    public K lowerKey(K key) {
        return this.backingTreeMap.lowerKey(key);
    }
    
    @Override
    public Entry<K, V> floorEntry(K key) {
        return null; //TODO
    }
    
    @Override
    public K floorKey(K key) {
        return this.backingTreeMap.floorKey(key);
    }
    
    @Override
    public Entry<K, V> ceilingEntry(K key) {
        return null; //TODO
    }
    
    @Override
    public K ceilingKey(K key) {
        return this.backingTreeMap.ceilingKey(key);
    }
    
    @Override
    public Entry<K, V> higherEntry(K key) {
        return null; //TODO
    }
    
    @Override
    public K higherKey(K key) {
        return this.backingTreeMap.higherKey(key);
    }
    
    @Override
    public Entry<K, V> firstEntry() {
        return null; //TODO
    }
    
    @Override
    public Entry<K, V> lastEntry() {
        return null; //TODO
    }
    
    @Override
    public Entry<K, V> pollFirstEntry() {
        return null; //TODO
    }
    
    @Override
    public Entry<K, V> pollLastEntry() {
        return null; //TODO
    }
    
    @Override
    public NavigableMap<K, V> descendingMap() {
        return null; //TODO
    }
    
    @Override
    public NavigableSet<K> descendingKeySet() {
        return null; //TODO
    }
    
    @Override
    public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
        return null; //TODO
    }
    
    @Override
    public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
        return null; //TODO
    }
    
    @Override
    public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
        return null; //TODO
    }
    
    @Override
    public Comparator<? super K> comparator() {
        return this.backingTreeMap.comparator();
    }
    
    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        return subMap(fromKey, true, toKey, false);
    }
    
    @Override
    public SortedMap<K, V> headMap(K toKey) {
        return headMap(toKey, false);
    }
    
    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        return tailMap(fromKey, true);
    }
    
    @Override
    public K firstKey() {
        return this.backingTreeMap.firstKey();
    }
    
    @Override
    public K lastKey() {
        return this.backingTreeMap.lastKey();
    }
    
    @Override
    public int size() {
        return this.backingTreeMap.size();
    }
    
    @Override
    public boolean containsKey(Object key) {
        return this.backingTreeMap.containsKey(key);
    }
    
    @Override
    public boolean containsValue(Object value) {
        return this.backingTreeMap.containsValue(value);
    }
    
    @Override
    public V get(Object key) {
        return this.backingTreeMap.get(key);
    }
    
    @Override
    public @Nullable V put(K key, V value) {
        V v = get(key);
        if (handleChange(key, value, v)) {
            return this.backingTreeMap.put(key, value);
        }
        
        return null;
    }
    
    @Override
    public V remove(Object key) {
        V v = get(key);
        if (handleChange((K) key, null, v)) {
            return this.backingTreeMap.remove(key);
        }
        
        return null;
    }
    
    @Override
    public @NotNull Set<K> keySet() {
        return navigableKeySet();
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
    
    private class Values extends AbstractCollection<V> {
        
        @Override
        public Iterator<V> iterator() {
            return new ValueItr();
        }
        
        @Override
        public int size() {
            return backingTreeMap.size();
        }
    }
    
    @Override
    public @NotNull Collection<V> values() {
        return new Values();
    }
    
    private class EntryItr implements Iterator<Entry<K, V>> {
        
        private final Iterator<Entry<K, V>> iterator = backingTreeMap.entrySet().iterator();
        
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
    
    private class EntrySet extends AbstractSet<Entry<K, V>> {
        
        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new EntryItr();
        }
        
        @Override
        public int size() {
            return backingTreeMap.size();
        }
    }
    
    @Override
    public @NotNull Set<Entry<K, V>> entrySet() {
        return new EntrySet();
    }
    
    private class KeySet extends AbstractSet<K> implements NavigableSet<K> {
        
        private final NavigableSet<K> keySet = backingTreeMap.navigableKeySet();
        
        @Override
        public @Nullable K lower(K k) {
            return keySet.lower(k);
        }
        
        @Override
        public @Nullable K floor(K k) {
            return keySet.floor(k);
        }
        
        @Override
        public @Nullable K ceiling(K k) {
            return keySet.ceiling(k);
        }
        
        @Override
        public @Nullable K higher(K k) {
            return keySet.higher(k);
        }
        
        @Override
        public @Nullable K pollFirst() {
            return null; //TODO
        }
        
        @Override
        public @Nullable K pollLast() {
            return null; //TODO
        }
        
        @Override
        public Iterator<K> iterator() {
            return null; //TODO
        }
        
        @Override
        public @NotNull NavigableSet<K> descendingSet() {
            return null; //TODO
        }
        
        @Override
        public @NotNull Iterator<K> descendingIterator() {
            return null; //TODO
        }
        
        @Override
        public @NotNull NavigableSet<K> subSet(K fromElement, boolean fromInclusive, K toElement, boolean toInclusive) {
            return null; //TODO
        }
        
        @Override
        public @NotNull NavigableSet<K> headSet(K toElement, boolean inclusive) {
            return null; //TODO
        }
        
        @Override
        public @NotNull NavigableSet<K> tailSet(K fromElement, boolean inclusive) {
            return null; //TODO
        }
        
        @Override
        public @Nullable Comparator<? super K> comparator() {
            return keySet.comparator();
        }
        
        @Override
        public @NotNull SortedSet<K> subSet(K fromElement, K toElement) {
            return null; //TODO
        }
        
        @Override
        public @NotNull SortedSet<K> headSet(K toElement) {
            return null; //TODO
        }
        
        @Override
        public @NotNull SortedSet<K> tailSet(K fromElement) {
            return null; //TODO
        }
        
        @Override
        public K first() {
            return keySet.first();
        }
        
        @Override
        public K last() {
            return keySet.last();
        }
        
        @Override
        public int size() {
            return backingTreeMap.size();
        }
    }
    
    @Override
    public NavigableSet<K> navigableKeySet() {
        return new KeySet();
    }
}