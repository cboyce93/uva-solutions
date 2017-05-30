/*************************************************************
 *  UVa 10611 - The Playboy Chimp
 *  Cameron Boyce
 *  08/24/2016
 *************************************************************/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.PrintStream;

public class Main {
	
	int N, Q, flag;
	int[] line;
	ArrayList<Integer> lineTwo;

	public static void main(String[] args) {
		Main playboyChimp = new Main();
		playboyChimp.begin();
	}
	
	public void begin() {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		N = in.nextInt();
		line = new int[N];
		for(int i = 0; i < N; ++i) {
			line[i] = in.nextInt();
		}
		lineTwo = removeDuplicates();
		Q = in.nextInt();
		for(int i = 0; i < Q; ++i) {
			flag = 0;
			print(search(0, lineTwo.size() - 1, in.nextInt()));
		}
		in.close();
	}
	
	public int search(int low, int high, int toFind) {
		int mid = (high + low) / 2;
		if(lineTwo.get(mid) == toFind) return mid;
		else if(mid == 0) {
			flag = 1;
			return 0;
		}
		else if((mid + 1) >= lineTwo.size()) {
			flag = 1;
			return lineTwo.size();
		}
		else if((lineTwo.get(mid + 1) > toFind && lineTwo.get(mid) < toFind))	{
			flag = 1;
			return mid + 1;
		}
		else if((lineTwo.get(mid) > toFind && lineTwo.get(mid - 1) < toFind))	{
			flag = 1;
			return mid;
		}
		
		if(toFind < lineTwo.get(mid)) return search(0, mid, toFind);
		else if(toFind > lineTwo.get(mid)) return search(mid + 1, high, toFind);
		else return -1;
	}
	
	public void print(int index) {
		PrintStream out = new PrintStream(System.out);
		String oneShorter = "X";
		String oneTaller = "X";
		if(flag == 0) {
			if((index - 1) >= 0) oneShorter = Integer.toString(lineTwo.get(index - 1));
			if((index + 1) < lineTwo.size()) oneTaller = Integer.toString(lineTwo.get(index + 1));
		}
		else {
			if((index - 1) >= 0) oneShorter = Integer.toString(lineTwo.get(index - 1));
			if(index < lineTwo.size()) oneTaller = Integer.toString(lineTwo.get(index));
		}
		out.println(oneShorter + " " + oneTaller);
	}
	
	public ArrayList<Integer> removeDuplicates() {
		ArrayList<Integer> lineTwo = new ArrayList<Integer>();
		for(int i = 0; i < line.length - 1; i++) {
			if(line[i] != line[i + 1]) {
				lineTwo.add(line[i]);
			}
		}
		lineTwo.add(line[line.length - 1]);
		return lineTwo;
	}
	
}
	