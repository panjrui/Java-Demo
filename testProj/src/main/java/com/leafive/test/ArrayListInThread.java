package com.leafive.test;

import java.util.List;
import java.util.Vector;
import java.util.ArrayList;

public class ArrayListInThread implements Runnable
{
    List<String> list1 = new ArrayList<>();//线程不安全
    Vector<String> list2 = new Vector<>();//线程安全
    
    public void run()
    {
        list2.add(Thread.currentThread().getName());
        list1.add(Thread.currentThread().getName());
        
    }

    public static void main(String[] args) throws Exception {
        ArrayListInThread listThread = new ArrayListInThread();  
        for(int i = 0; i < 1000; i++){  
            Thread thread = new Thread(listThread, "线程" + String.valueOf(i)); //线程名是i 
            thread.start();  
        }
        Thread.sleep(3000);

        System.out.println(listThread.list1.size());
        System.out.println(listThread.list2.size());
    }

}