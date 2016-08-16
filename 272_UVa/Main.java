/*************************************************************
 *  UVa 272 - TEX Quotes
 *  Cameron Boyce
 *  08/14/2016
 *************************************************************/

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Main texQuotes = new Main();
		texQuotes.begin();
	}
	
	void begin() {
		Scanner input = new Scanner(new BufferedInputStream(System.in));
		boolean left = true;
		while(input.hasNext()) {
			String line = input.nextLine();
			char[] C = line.toCharArray();
			ArrayList<Character> list = new ArrayList<Character>();
			int count = 0;
			for(char c : C) {
				list.add(c);
				if(c == '"' && left == true) {
					list.set(count, '`');
					list.add('`');
					count++;
					left = false;
				}
				else if(c == '"' && left == false) {
					list.set(count, '\'');
					list.add(count, '\'');
					count++;
					left = true;
				}
				count++;
			}
			print(list);
		}
		input.close();
	}
	
	void print(ArrayList<Character> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
		System.out.println("");
	}

}
