package com.geekbrains.client;

@FunctionalInterface
public interface Callback {

    void onReceive(String message);

}
