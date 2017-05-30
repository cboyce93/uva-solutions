/*************************************************************
 *  UVa 628 - Passwords
 *  Cameron Boyce
 *  08/16/2016
 *************************************************************/

import java.util.Scanner;
import java.io.BufferedInputStream;

public class Main {
	 
	private int n, m;
	private String[] dictionary;
	private String[] rules;
	
	public static void main(String[] args) {
		Main passwords = new Main();
		passwords.begin();
	}
	
	public void begin() {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		while(in.hasNext()) {
			System.out.println("--");
			n = in.nextInt();
			dictionary = new String[n];
			for(int i = 0; i < n; i++) {
				dictionary[i] = in.next();
			}
			m = in.nextInt();
			rules = new String[m];
			for(int i = 0; i < m; i++) {
				rules[i] = in.next();
				char[] arr = rules[i].toCharArray();
				String sb = "";
				findAllPasswords(arr, sb, 0);
			}
		}
		in.close();
	}
	
	public void findAllPasswords(char[] rule, String sb, int index) {
		if(index >= rule.length) System.out.println(sb.toString());
		else if(rule[index] == '#') {
			for(int i = 0; i < dictionary.length; i++) {
				findAllPasswords(rule, sb + dictionary[i], index + 1);
			}
		}
		else if(rule[index] == '0') {
			for(int j = 0; j < 10; j++) {
				findAllPasswords(rule, sb + (char) (48 + j), index + 1);
			}
		}
	}
}
