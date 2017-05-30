/*************************************************************
 *  UVa 483 - Word Scramble
 *  Cameron Boyce
 *  08/12/2016
 *************************************************************/

import java.util.Scanner;
import java.io.BufferedInputStream;

public class Main {
	
	public static void main(String[] args) {
		Main wordScramble = new Main();
		wordScramble.begin();
	}
	
	void begin() {
		Scanner input = new Scanner(new BufferedInputStream(System.in));
		while(input.hasNext()) {
			String line = input.nextLine();
			String[] tokens = line.split("\\s");
			int count = 0;
			for (String word : tokens) {
				char[] arr = word.toCharArray();
				for(int i = 0; i < arr.length; i++) {
					System.out.print(arr[arr.length - i - 1]);
				}
				if(count < (tokens.length - 1)) {
					System.out.print(" ");
					count++;
				}
			}
			System.out.println("");
		}
		input.close();
	}
}