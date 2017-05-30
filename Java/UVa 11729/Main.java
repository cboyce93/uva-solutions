/*************************************************************
 *  UVa 11729 - Commando War
 *  Cameron Boyce
 *  6/28/2016
 *************************************************************/

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Main {
	public static void main(String[] args) {
		Main commandoWar = new Main();
		commandoWar.begin();
	}
	
	void begin() {
		Scanner input = new Scanner(System.in);
		int noOfSoldiers;
		int cases = 1;
		while((noOfSoldiers = input.nextInt()) != 0) {
			int[][] arr = new int[noOfSoldiers][2];
			for(int i = 0; i < noOfSoldiers; i++) {
				for(int j = 0; j < 2; j++) {
					arr[i][j] = input.nextInt();
				}
			}
			Arrays.sort(arr, new ColumnComparator(1));
			int[] one = new int[noOfSoldiers];
			int sum2 = 0;
			for(int i = 0; i < noOfSoldiers; i++) {
				one[i] = sum2 + arr[i][0] + arr[i][1];
				sum2 += arr[i][0];
			}
			System.out.printf("Case %d: " + max(one) +"\n", cases);
			cases++;
		}
		input.close();
	}
	
	public int max(int[] arr) {
		int currMax = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > currMax)
				currMax = arr[i];
		}
		return currMax;
	}
}

class ColumnComparator implements Comparator<int[]> {
	int mColumnToSort;
	int mOtherColumn;
	public ColumnComparator(int columnToSort) {
		mColumnToSort = columnToSort;
		mOtherColumn = (columnToSort == 1) ? 0 : 1;
	}
	@Override
	public int compare(int[] row1, int[] row2) {
		if(row1[mColumnToSort] > row2[mColumnToSort]) 
			return -1;
		else if(row1[mColumnToSort] < row2[mColumnToSort]) 
			return 1;
		else if(row1[mOtherColumn] > row2[mOtherColumn])
			return -1;
		else
			return  0;
	}
}


