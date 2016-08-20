/*************************************************************
 *  UVa 441 - Lotto
 *  Cameron Boyce
 *  08/19/2016
 *************************************************************/

import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Main {

	int count;
	int[] S;
	ArrayList<ArrayList<Integer>> list;


	public static void main(String[] args) {
		Main lotto = new Main();
		lotto.begin();
	}
	
	public void begin() {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		int k;
		boolean first = false;
		while((k = in.nextInt()) != 0) {
			if(first) System.out.println("");
			first = true;
			S = new int[k];
			list = new ArrayList<ArrayList<Integer>>();
			for(int i = 0; i < k; ++i) {
				S[i] = in.nextInt();
			}
			count = 0;
			gen();
			Collections.sort(list, new comp());
			print(list);
		}
		in.close();
	}
	
	public void gen() {
		for(int mask = 0; mask < Math.pow(2, S.length); ++mask) {
			int bitcount = bitcount(mask);
			if(bitcount == 6) {
				bitprint(mask);
			}
		}
	}
	
	public int bitcount(int mask) {
		int n;
		for(n = 0; mask > 0; ++n, mask &= (mask - 1));
		return n;
	}
	
	public void bitprint(int mask) {
		list.add(new ArrayList<Integer>());
		for(int i = 0; i < Math.pow(2, S.length); ++i, mask >>= 1) {
			if((mask & 1) > 0) list.get(count).add(S[i]);
		}
		count++;
	}
	
	public void print(ArrayList<ArrayList<Integer>> list) {
		PrintStream out = new PrintStream(System.out);
		for(int i = 0; i < list.size(); ++i) {
			for(int j = 0; j < 6; ++j) {
				out.printf("%d%c", list.get(i).get(j), j == 5 ? '\n' : ' ');
			}
		}
	}
	
}

class comp implements Comparator<ArrayList<Integer>> {
	@Override
	public int compare(ArrayList<Integer> row1, ArrayList<Integer> row2) {
		for(int col = 0; col < row1.size() && col < row2.size(); col++) {
			if(row1.get(col) > row2.get(col)) return 1;
			else if(row1.get(col) < row2.get(col)) return -1;
		}
		return 0;
	}
}

