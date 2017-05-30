/*************************************************************
 *  UVa 750 - 8 Queens Chess Problem
 *  Cameron Boyce
 *  08/16/2016
 *************************************************************/

import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.lang.Math;

public class Main {
	
	private int a, b;
	private int lineCounter;
	private int[] arr;
	
	public static void main(String[] args) {
		Main eightQueens = new Main();
		eightQueens.begin();
	}
	
	public void begin() {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintStream out = new PrintStream(System.out);
		int runs = in.nextInt();
		for(int i = 0; i < runs; i++) {
			a = in.nextInt() - 1;
			b = in.nextInt() - 1;
			out.println("SOLN       COLUMN");
			out.println(" #      1 2 3 4 5 6 7 8");
			out.println("");
			lineCounter = 1;
			arr = new int[8];
			NQueens(0);
			if(i != (runs - 1)) System.out.println("");
		}
		in.close();
	}
	
	public void NQueens(int queen) {
		for(int row = 0; row < 8; row++) {
			if(canPlace(queen, row)) {
				arr[queen] = row;
				if(queen == 7 && arr[b] == a) {
					if(lineCounter > 9) System.out.print(lineCounter++ + "     ");
					else System.out.print(" " + lineCounter++ + "     ");
					for(int j = 0; j < 8; j++) {
						System.out.print(" " + (arr[j] + 1));
					}
					System.out.println("");
				}
				else NQueens(queen + 1);
			}
		}
	}
	
	public boolean canPlace(int queen, int row) {
		for(int prev = 0; prev <= queen - 1; prev++) {
			if(arr[prev] == row || (Math.abs(arr[prev] - row) == Math.abs(prev - queen)))
				return false;
		}
		return true;
	}

}
