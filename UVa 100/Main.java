/*************************************************************
 *  UVa 100 - The 3n + 1 Problem
 *  Cameron Boyce
 *  6/22/2016
 *************************************************************/

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Main threeNplusOne = new Main();
		threeNplusOne.begin();
	}
	
	void begin() {
		Scanner input = new Scanner(new BufferedInputStream(System.in));
		while(input.hasNext()) {
			int i = input.nextInt();
			int j = input.nextInt();
			int temp = 0;
			// swap
			if(i > j) {
				temp = i;
				i = j;
				j = temp;
			}
			int currMax = 0;
			for(int count = i; count <= j; count++) {
				int n = count;
				int cycleLength = 1;
				while(n > 1) {
					if((n % 2) != 0)
						n = (3 * n) + 1;
					else
						n /= 2;
					cycleLength++;
				}
				if(cycleLength > currMax)
					currMax = cycleLength;
			}
			if(temp != 0)
				System.out.println(j + " " + i + " " + currMax);
			else
				System.out.println(i + " " + j + " " + currMax);
		}
		input.close();
	}
}
