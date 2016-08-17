/*************************************************************
 *  UVa 739 - Soundex Indexing
 *  Cameron Boyce
 *  08/17/2016
 *************************************************************/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.PrintStream;

public class Main {
	
	public static void main(String[] args) {
		Main soundexIndexing = new Main();
		soundexIndexing.begin();
	}
	
	public void begin() {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		int i = 0;
		while(in.hasNext()) {
			String name = in.next();
			char[] arr = name.toCharArray();
			StringBuilder newName = new StringBuilder();
			for(int j = 0; j < 20; j++) {
				if(j < arr.length) newName.append(arr[j]);
				else newName.append(' ');
			}
			list.add(new ArrayList<String>());
			list.get(i).add(newName.toString());
			list.get(i).add(soundex(arr));
			i++;
		}
		print(list);
		in.close();
	}
	
	public String soundex(char[] arr) {
		int code = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length && sb.length() < 4; i++) {
			if((arr[i] == 'B' || arr[i] == 'P' || arr[i] == 'F' || arr[i] == 'V') && code != 1) {
				code = 1;
			}
			else if((arr[i] == 'C' || arr[i] == 'S' || arr[i] == 'K' || arr[i] == 'G'||
					arr[i] == 'J' || arr[i] == 'Q' || arr[i] == 'X' || arr[i] == 'Z') && code != 2) {
				code = 2;
			}
			else if((arr[i] == 'D' || arr[i] == 'T') && code != 3) {
				code = 3;
			}
			else if((arr[i] == 'L') && code != 4) {
				code = 4;
			}
			else if((arr[i] == 'M' || arr[i] == 'N') && code != 5) {
				code = 5;
			}
			else if((arr[i] == 'R') && code != 6) {
				code = 6;
			}
			else if(arr[i] == 'A' || arr[i] == 'E' || arr[i] == 'I' || arr[i] == 'O'||
					arr[i] == 'U' || arr[i] == 'Y' || arr[i] == 'W' || arr[i] == 'H') {
				code = 0;
			}
			if(i == 0) sb.append(arr[0]);
			else if (code > 0) sb.append(code);
		}
		if(sb.length() < 4) {
			for(int j = sb.length(); j < 4; j++) {
				sb.append('0');
			}
		}
		return sb.toString();
	}
	
	public void print(ArrayList<ArrayList<String>> list) {
		PrintStream out = new PrintStream(System.out);
		out.println("         NAME                     SOUNDEX CODE");
		for(int i = 0; i < list.size(); i++) {
			out.printf("         %s", list.get(i).get(0));
			out.printf("%9s\n", list.get(i).get(1));
		}
		out.printf("%32s\n", "END OF OUTPUT");
	}

}
