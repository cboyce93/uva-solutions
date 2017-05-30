/*************************************************************
 *  UVa 729 - The Hamming Distance Problem
 *  Cameron Boyce
 *  08/18/2016
 *************************************************************/

import java.util.Scanner;
import java.io.BufferedInputStream;
import java.lang.Math;

public class Main {
	
	public static void main(String[] args) {
		Main hamming = new Main();
		hamming.begin();
	}
	
	public void begin() {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		int runs = in.nextInt();
		for(int i = 0; i < runs; i++) {
			int N = in.nextInt();
			int H = in.nextInt();
			generateBinaryStrings(N, H);
			if(i != runs - 1) System.out.println("");
		}
		in.close();
	}
	
	public void generateBinaryStrings(int N, int H) {
		int A = 0;
		for(int B = 0; B <= Math.pow(2, N); B++) {
			findHammingDist(A, B, N, H);
		}
	}
	
	public void findHammingDist(int A, int B, int N, int H) {
		String x = Integer.toBinaryString(A ^ B);
		char[] xor = x.toCharArray();
		int h = 0;
		if(xor.length > N) return;
		for(char c : xor) {
			if(c == '1') h++;
		}
		if(h == H) print(x, N);
	}
	
	public void print(String toPrint, int N) {
		if(toPrint.length() < N) {
			print((char) 48 + toPrint , N);
		}
		else System.out.println(toPrint);
	}
	
}

