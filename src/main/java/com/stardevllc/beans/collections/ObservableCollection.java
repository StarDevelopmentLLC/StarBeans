package com.stardevllc.beans.collections;

import com.stardevllc.beans.Observable;

import java.util.Collection;

/**
 * Represents an collection that can be observed for changes
 *
 * @param <E> The element type
 */
public interface ObservableCollection<E> extends Observable, Collection<E> {
}