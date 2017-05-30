/*************************************************************
 *  UVa 154 - Recycling
 *  Cameron Boyce
 *  08/16/2016
 *************************************************************/

import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.ArrayList;

public class Main {
	
	private int row;

	public static void main(String[] args) {
		Main recycling = new Main();
		recycling.begin();
	}
	
	public void begin() {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		String next;
		while(!(next = in.next()).contentEquals("#")) {
			ArrayList<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>(); 
			row = 0;
			do {
				char[] line = next.toCharArray();
				list.add(new ArrayList<Character>());
				for(int i = 0; i < 5; i++) {
					list.get(row).add(' ');
				}
				boolean color = true;
				int col = 0;
				for(int i = 0; line[0] != 'e' & i < line.length; i += 2) {
					if(color) {
						if(line[i] == 'b') col = 0;
						else if(line[i] == 'g') col = 1;
						else if(line[i] == 'o') col = 2;
						else if(line[i] == 'r') col = 3;
						else col = 4;
						color = false;
					}
					else {
						list.get(row).set(col, line[i]);
						color = true;
					}
				}
				row++;
			} while(!(next = in.next()).contains("e"));
			int toAdopt = totalChange(list);
			System.out.println(toAdopt);
		}	
		in.close();
	}
	
	public int totalChange(ArrayList<ArrayList<Character>> list) {
		int[] changes = new int[list.size()];
		int a, b;
		for(int col = 0; col < 5; col++) {
			for(int index = 0; index < list.size(); index++) {
				a = list.get(index).get(col);
				for(int row = 0; row < list.size(); row++) {
					if(row != index) {
						b = list.get(row).get(col);
						if(a == b) changes[index]++;
					}
				}
			}
		}
		return max(changes);
	}
	
	public int max(int[] changes) {
		int max = changes[0];
		int maxCol = 0;
		for(int i = 1; i < changes.length; i++) {
			if(changes[i] > max) {
				max = changes[i];
				maxCol = i;
			}
		}
		return maxCol + 1;
	}
	
}
