package com.petkingdom.business;

public interface IManagement<T> {
    boolean add(T item);

    void displayAll();

    T findById(String id);

    boolean delete(String id);

}
