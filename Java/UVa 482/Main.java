/*************************
 *  UVa 482 - Permutation Arrays
 *  Cameron Boyce
 *  6/22/2016
 *************************/

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Main permutationArrays = new Main();
		permutationArrays.begin();
	}
	
	void begin() {
		Scanner input = new Scanner(new BufferedInputStream(System.in));
		int noOfCases = input.nextInt();
		String discard = input.nextLine();
		
		for(int i = 0; i < noOfCases; i++) {
			discard = input.nextLine();
			String line1 = input.nextLine();
			String line2 = input.nextLine();
			String[] lineArr1 = line1.split(" ");
			String[] lineArr2 = line2.split(" ");
			int[] p = new int[lineArr1.length];
			String[] r = new String[lineArr2.length];
			for(int j = 0; j < p.length; j++) {
				p[j] = Integer.parseInt(lineArr1[j]);
				int index = p[j] - 1;
				r[index] = lineArr2[j];	
			}
			for(int k = 0; k < p.length; k++) {
				System.out.println(r[k]);
			}
			if(i < noOfCases - 1)
				System.out.println("");
		}
		input.close();	
	}

}
