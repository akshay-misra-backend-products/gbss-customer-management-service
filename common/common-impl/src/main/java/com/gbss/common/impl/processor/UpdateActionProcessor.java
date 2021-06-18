package com.gbss.common.impl.processor;

public abstract class UpdateActionProcessor<T> extends CreateActionProcessor<T> {

    @Override
    public T process(T entity) {
        this.preValidation(entity);
        final T merged = this.merge(entity);
        this.postValidation(merged);
        final T persisted = this.doAction(merged);

        return persisted;
    }

    public abstract T merge(T entity);
}
