package pcd.lab01.ex02;

import org.fusesource.jansi.Ansi;
import pcd.lab01.ex01.Screen;

import java.sql.Array;
import java.util.*;

import static java.rmi.server.LogStream.log;

public class MyThread extends Thread{

    private int f[];
    private int y;
    private int e;



    public MyThread(int x[],int start, int end) {
        this.y = start;
        this.e=end;
        f=x;

    }

    @Override
    public void run(){
        long t0 = System.nanoTime();
        Arrays.sort(f,y,e);
        long t1 = System.nanoTime();
        System.out.println("Done. Time elapsed: " + ((t1 - t0) / 1000000) + " ms");
        //mostra();
    }

    public void mostra(){
        for(int i=0;i<f.length;i++){
            System.out.println("Il "+i+"-esimo numero è: "+f[i]);
        }
    }
}
