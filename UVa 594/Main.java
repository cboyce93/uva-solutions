/*************************************************************
 *  UVa 594 - One Little, Two Little, Three Little Endians
 *  Cameron Boyce
 *  6/28/2016
 *************************************************************/

import java.util.Scanner;
import java.io.BufferedInputStream;

public class Main {
	
	public static void main(String[] args) {
		Main endian = new Main();
		endian.begin();
	}
	
	void begin() {
		Scanner input = new Scanner(new BufferedInputStream(System.in));
		while(input.hasNext()) {
			int value = input.nextInt();
			int a = 0;
			int b = value;
			for(int i = 0; i < 3; i++) {
				a |= (b & 255);
				a <<= 8;
				b >>= 8;		
			}
			a |= (b & 255);
			System.out.println(value + " converts to " + a);
		}
		input.close();
	}

}
