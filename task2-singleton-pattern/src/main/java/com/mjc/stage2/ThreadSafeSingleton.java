package com.mjc.stage2;

public class ThreadSafeSingleton {
  private volatile static ThreadSafeSingleton instance = new ThreadSafeSingleton();

  private ThreadSafeSingleton() {
  }

  public static synchronized ThreadSafeSingleton getInstance() {
    return instance;
  }

}
