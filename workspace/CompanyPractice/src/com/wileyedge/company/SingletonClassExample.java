package com.wileyedge.company;

public class SingletonClassExample {  
    private static final SingletonClassExample instance = new SingletonClassExample();  
    private SingletonClassExample() {}  
    public static SingletonClassExample getInstance() {  
        return instance;  
    }  
}
