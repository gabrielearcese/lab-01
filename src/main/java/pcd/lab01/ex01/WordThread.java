package pcd.lab01.ex01;

import org.fusesource.jansi.Ansi;
import java.util.Random;

public class WordThread extends Thread{

    private int x;
    private int y;
    private int speed;
    private String word;
    Random rand = new Random();
    Screen screen = Screen.getInstance();


    public WordThread(int x, int y, String word) {
        this.x = x;
        this.y = y;
        this.word = word;
        speed = rand.nextInt(250);
    }

    @Override
    public void run(){
        for (int i = 1; i < 20; i++) {
            screen.writeStringAt(y + i, x, Ansi.Color.RED, this.word);
            try {
                Thread.sleep(speed);
            } catch (Exception ex) {}
            screen.writeStringAt(y + i, x, Ansi.Color.BLACK, this.word);
            if(i==19){
                screen.writeStringAt(i, x, Ansi.Color.RED, this.word);
            }
        }
    }
}


