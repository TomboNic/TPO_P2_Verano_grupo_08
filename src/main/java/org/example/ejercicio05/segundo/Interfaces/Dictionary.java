package org.example.ejercicio05.segundo.Interfaces;

public interface Dictionary {

    int get(int key);
    Set getKeys();
    void add(int key, int value);
    void remove(int key);

}
