/***********************************************************************
 *  UVa 101 - The Blocks Problem
 *  Cameron Boyce
 *  07/13/2016
 ***********************************************************************/

import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;


public class TheBlocksProblem {
	
	public List<Stack<Integer>> blocks = new ArrayList<Stack<Integer>>();
	public int pos[];
	public int NO_OF_BLOCKS;
	
	public static void main(String[] args) {
		TheBlocksProblem one = new TheBlocksProblem();
		one.begin();
	}
	
	void begin() {
		Scanner input = new Scanner(new BufferedInputStream(System.in));
		NO_OF_BLOCKS = input.nextInt();
		pos = new int[NO_OF_BLOCKS];
		for(int i = 0; i < NO_OF_BLOCKS; i++) {
			blocks.add(new Stack<Integer>());
			blocks.get(i).push(i);
			pos[i] = i;
		}
		String cmd1; String cmd2; int block1; int block2;
		while(!(cmd1 = input.next()).contentEquals("quit")) {
			block1 = input.nextInt();
			cmd2 = input.next();
			block2 = input.nextInt();
			if(block1 == block2) continue;
			else if(pos[block1] == pos[block2]) continue;
			else if(cmd1.contentEquals("move") && cmd2.contentEquals("onto"))
				moveOnto(block1, block2);
			else if(cmd1.contentEquals("move") && cmd2.contentEquals("over"))
				moveOver(block1, block2);
			else if(cmd1.contentEquals("pile") && cmd2.contentEquals("onto"))
				pileOnto(block1, block2);
			else
				pileOver(block1, block2);			
		}
		print();
		input.close();
	}
	
	public void moveOnto(int block1, int block2) {
		clearAbove(block1);
		clearAbove(block2);
		blocks.get(pos[block2]).push(blocks.get(pos[block1]).pop());
		pos[block1] = pos[block2];
	}
	
	public void moveOver(int block1, int block2) {
		clearAbove(block1);
		blocks.get(pos[block2]).push(blocks.get(pos[block1]).pop());
		pos[block1] = pos[block2];
	}
	
	public void pileOnto(int block1, int block2) {
		clearAbove(block2);
		pileOver(block1, block2);
	}
	
	public void pileOver(int block1, int block2) {
		Stack<Integer> temp = new Stack<Integer>();
		while(blocks.get(pos[block1]).peek() != block1) {
			temp.push(blocks.get(pos[block1]).pop());
		}
		blocks.get(pos[block2]).push(blocks.get(pos[block1]).pop());
		pos[block1] = pos[block2];
		while(!temp.isEmpty()) {
			int tempi = temp.pop();
			blocks.get(pos[block2]).push(tempi);
			pos[tempi] = pos[block2];
		}
	}
	
	public void clearAbove(int block) {
		while(blocks.get(pos[block]).peek() != block) {
			initialize(blocks.get(pos[block]).pop());
		}
	}
	
	public void initialize(int block) {
		while(!blocks.get(block).isEmpty()) {
			initialize(blocks.get(block).pop());
		}
		blocks.get(block).push(block);
		pos[block] = block;
	}
	
	public void print() {
		for(int i = 0; i < NO_OF_BLOCKS; i++) {
			StringBuilder line = new StringBuilder();
			line.append(i + ":");
			Stack<Integer> temp = new Stack<Integer>();
			while(!blocks.get(i).isEmpty()) {
				temp.push(blocks.get(i).pop());
			}
			while(!temp.isEmpty()) {
				line.append(" " + temp.pop());
			}
			System.out.println(line.toString());
		}
	}
	
}
