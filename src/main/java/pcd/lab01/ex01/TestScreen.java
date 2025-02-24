package pcd.lab01.ex01;

import static org.fusesource.jansi.Ansi.*;
import static pcd.lab01.ex01.AuxLib.getWordsPos;

import org.fusesource.jansi.AnsiConsole;

/**
 * 
 * Simple program showing basic features 
 * of J-ANSI lib.
 *
 * To be run from a command line.
 * 
 */
public class TestScreen {

	public static void main(String[] args) {

		Screen screen = Screen.getInstance();
		screen.clear();

		var sentence = "This is a simple sentence with words ready to fall";
		var wordList = getWordsPos(sentence);

		for (var wp: wordList) {
			//System.out.println("Word: " + wp.word() + " -- Pos: " + wp.pos());
			Thread thread = new WordThread(wp.pos(), 0 , wp.word());
			thread.start();
		}
	}

}
