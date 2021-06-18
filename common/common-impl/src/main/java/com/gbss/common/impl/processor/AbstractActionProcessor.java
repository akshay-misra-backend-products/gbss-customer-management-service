package com.gbss.common.impl.processor;

public abstract class AbstractActionProcessor<T> {

    public abstract T process(T entity);
}
