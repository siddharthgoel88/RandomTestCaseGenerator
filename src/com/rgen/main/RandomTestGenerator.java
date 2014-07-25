package com.rgen.main;
import com.rgen.modules.*;

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
	
	private void displayModules() {
		StdOut.println("List of modules are as follows:");
		for (Modules mod : Modules.values()) {
			Generator obj = mod.getObj();
			StdOut.println(mod.ordinal()+1 + ". " + obj.type());
		}
		StdOut.print("Enter your choice of generator (enter number):");
		module = StdIn.readInt();
		chosen = Modules.values()[module-1].getObj();
	}
	
	private void getResult() {
		chosen.takeInput();
		result = chosen.generate();
		StdOut.println(result);
	}

	public static void main(String[] args) {
		RandomTestGenerator gen = new RandomTestGenerator();
		gen.displayModules();
		gen.getResult();
	}

}
