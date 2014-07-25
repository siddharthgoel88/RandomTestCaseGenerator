package com.rgen.main;
import java.util.InputMismatchException;

import com.rgen.modules.*;

import edu.princeton.cs.introcs.Out;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class RandomTestGenerator {
	private int module;
	private Generator chosen;
	private String result;
	
	private enum Modules {
		NUMBER_LIST (new NumberList());
		
		private Modules(Generator gen) { this.obj = gen; }
		private Generator obj;
		
		public Generator getObj() { return obj; }
		
	}
	
	public void init() {
		this.displayModules();
		this.getResult();
		this.makeFile();
	}
	
	private void displayModules() {
		byte flag;
		
		do {
			StdOut.println("List of modules are as follows:");
			for (Modules mod : Modules.values()) {
				Generator obj = mod.getObj();
				StdOut.println(mod.ordinal()+1 + ". " + obj.type());
			}
			StdOut.print("Enter your choice of generator (enter number):");
			module = StdIn.readInt();
			
			try {
				flag = 0;
				chosen = Modules.values()[module-1].getObj();
			} catch(Exception e) {
				StdOut.println("Oh ! Invalid input. Choose input correctly");
				flag = 1;
			}
		} while (flag == 1);
	}
	
	private void makeFile() {
		String filename;
		StdOut.println("Enter name of file where you want to save result:");
		filename = StdIn.readString();
		Out file = new Out(filename);
		file.print(result);
		file.close();
	}
	
	private void getResult() {
		chosen.takeInput();
		result = chosen.generate();
	}

	public static void main(String[] args) {
		RandomTestGenerator gen = new RandomTestGenerator();
		gen.init();
	}

}
