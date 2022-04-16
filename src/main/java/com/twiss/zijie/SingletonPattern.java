package com.twiss.zijie;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程安全单例模式
 * @Author: Twiss
 * @Date: 2022/4/16 11:40 下午
 */
public class SingletonPattern {

    private AtomicLong id = new AtomicLong(0);
    private static SingletonPattern instance;
    private SingletonPattern(){}

    public static SingletonPattern getInstance(){
        if (instance==null){
            synchronized (SingletonPattern.class){
                if (instance==null){
                    instance = new SingletonPattern();
                }
            }
        }
        return instance;
    }

    public long getId(){
        return id.incrementAndGet();
    }
}
