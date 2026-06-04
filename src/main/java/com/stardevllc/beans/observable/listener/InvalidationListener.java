package com.stardevllc.beans.observable.listener;

import com.stardevllc.beans.Observable;

@FunctionalInterface
public interface InvalidationListener {
    void onInvalidate(Observable observable);
}