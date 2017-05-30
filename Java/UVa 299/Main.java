/*************************************************************
 *  UVa 299 - Train Swapping
 *  Cameron Boyce
 *  6/29/2016
 *************************************************************/

import java.util.Scanner;
import java.io.BufferedInputStream;

public class Main {
	
	public static void main(String[] args) {
		Main trainSwapping = new Main();
		trainSwapping.begin();
	}
	
	void begin() {
		Scanner input = new Scanner(new BufferedInputStream(System.in));
		int noOfTestCases = input.nextInt();
		for(int i = 0; i < noOfTestCases; i++) {
			int noOfTrains = input.nextInt();
			int[] arr = new int[noOfTrains];
			for(int j = 0; j < noOfTrains; j++) {
				arr[j] = input.nextInt();
			}
			int count = countSwaps(arr);
			System.out.println("Optimal train swapping takes " + count + " swaps.");
		}
	}
	
	public int countSwaps(int[] arr) {
		int count = 0;
		boolean swapped = true;
		while(swapped == true) {
			swapped = false;
			for(int i = 1; i < arr.length; i++) {
				if(arr[i - 1] > arr[i]) {
					int temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
					swapped = true;
					count++;
				}
			}
		}
		return count;
	}

}
