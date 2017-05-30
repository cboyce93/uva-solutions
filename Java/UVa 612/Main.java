/***********************************************************************
 *  UVa 612 - DNA Sorting
 *  Cameron Boyce
 *  07/03/2016
 ***********************************************************************/

import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	static int inversions = 0;
	
	public static void main(String[] args) {
		Main dnaSorting = new Main();
		dnaSorting.begin();
	}
	
	void begin() {
		Scanner input = new Scanner(new BufferedInputStream(System.in));
		final int NO_OF_DATA_SETS = input.nextInt();
		for(int i = 0; i < NO_OF_DATA_SETS; i++) {
			int length = input.nextInt();
			int noOfStrings = input.nextInt();
			char[] sequence = new char[length];
			int[][] inversionsArr = new int[noOfStrings][2];
			String[] sequenceArr = new String[noOfStrings];
			for(int j = 0; j < noOfStrings; j++) {
				String next = input.next();
				sequence = next.toCharArray();
				mergeSort(sequence);
				inversionsArr[j][0] = inversions;
				inversionsArr[j][1] = j;
				sequenceArr[j] = next;
				// System.out.println(inversions);
				inversions = 0;
			}
			Arrays.sort(inversionsArr, new ColumnComparator(0));
			for(int k = 0; k < noOfStrings; k++) {
				System.out.println(sequenceArr[inversionsArr[k][1]]);
			}
			if(i < NO_OF_DATA_SETS - 1)
				System.out.println("");
		}
		input.close();
	}
	
	public static void mergeSort(char[] toSort) {
		if(toSort.length < 2) return;
		char[] first = new char[toSort.length / 2];
		char[] second = new char[toSort.length - first.length];
		System.arraycopy(toSort, 0, first, 0, first.length);
		System.arraycopy(toSort, first.length, second, 0, second.length);
		mergeSort(first);
		mergeSort(second);
		merge(first, second, toSort);
	}
	
	public static void merge(char[] first, char[] second, char[] merged) {
		int i = 0; int j = 0;
		while(i + j < merged.length) {
			if(j == second.length || (i < first.length && (first[i] <= second[j]))) {
				merged[i + j] = first[i++];
			}
			else {
				merged[i + j] = second[j++];
				inversions += first.length - i;
			}			
		}
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
			return 1;
		else if(row1[mColumnToSort] < row2[mColumnToSort]) 
			return -1;
		else if(row1[mOtherColumn] > row2[mOtherColumn])
			return 1;
		else
			return  0;
	}
}
