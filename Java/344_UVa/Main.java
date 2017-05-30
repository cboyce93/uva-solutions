/***********************************************************************
 *  UVa 377
 *  Cameron Boyce
 *  08/1/2016
 ***********************************************************************/

import java.util.Scanner;
import java.io.BufferedInputStream;

public class Main {

	public static void main(String[] args) {
		Main romanDigititis = new Main();
		romanDigititis.begin();
	}
	
	void begin() {
		Scanner input = new Scanner(new BufferedInputStream(System.in));
		int next;
		while((next = input.nextInt()) != 0) {
			int i = 0; int v = 0; int x = 0; int l = 0; int c = 0;
			for(int k = 1; k <= next; k++) {
				String num = Integer.toString(k);
				char[] digits = num.toCharArray();
				int length = digits.length;
				// PROCESS ONES COLUMN
				int index = length - 1;
				if(digits[index] == '1') i++;
				else if(digits[index] == '2') i += 2;
				else if(digits[index] == '3') i += 3;
				else if(digits[index] == '4') {
					i++;
					v++;
				}
				else if(digits[index] == '5') v++;
				else if(digits[index] == '6') {
					i++;
					v++;
				}
				else if(digits[index] == '7') {
					i += 2;
					v++;
				}
				else if(digits[index] == '8') {
					i += 3;
					v++;
				}
				else if(digits[index] == '9') {
					i++;
					x++;
				}
				// PROCESS TENS
				if(length > 1) {
					if(length == 2)	index = 0;
					if(length == 3) index = 1;
					if(digits[index] == '4') {
						x++;
						l++;
					}
					else if(digits[index] == '5') l++;
					else if(digits[index] == '6') {
						l++;
						x++;
					}
					else if(digits[index] == '7') {
						l++;
						x += 2;
					}
					else if(digits[index] == '8') {
						l++;
						x += 3;
					}
					else if(digits[index] == '9') {
						x++;
						c++;
					}
					else {
						x += (digits[index] - 48);
					}
				}
				// PROCESS HUNDREDS
				if(length > 2) {
					c++;
				}
			}
			System.out.println(next + ": " + i + " i, " + v + " v, " + x + " x, " + l + " l, " + c + " c");
		}
		input.close();
	}
	
}