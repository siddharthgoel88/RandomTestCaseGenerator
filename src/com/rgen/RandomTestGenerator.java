package com.rgen;
import com.rgen.modules.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import edu.princeton.cs.introcs.*;

public class RandomTestGenerator {
	private final int INTMAX = 999999;
	private final double DBMIN = 0.0;
	private final double DBMAX = 999999.0;
	String result;
	String filename;
	
	public RandomTestGenerator() {
		result = "";
	}

	public void init() {
		this.takeInput();
		this.makeFile();
		this.generateLink();
	}
	
	private void generateLink() {
		String option;
		StdOut.print("Do you want to upload this file to pastebin? (Y/N):");
		option = StdIn.readString().trim().toLowerCase();
		if (option == "y" || option == "yes")
			try {
				generatePastebinLink();
			} catch(Exception e) {
				e.printStackTrace();
			}
	}

	private void generatePastebinLink() throws Exception {
		String url = "http://pastebin.com/api/api_post.php";
		String pastebinDevKey = "";
		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		File devKeyFile = new File("./.pastebin-devkey");

		if(!devKeyFile.exists()) {
			StdOut.print("Oh. I do not have your pastebin api dev key. "
					+ "Login pastebin and visit http://pastebin.com/api "
					+ "to get your dev key.I will try to remember it.\n"
					+ "Enter your key:");
			pastebinDevKey = StdIn.readString().trim();
			Out file = new Out(".pastebin-devkey");
			file.print(pastebinDevKey);
			file.close();
		} else {
			In file = new In(devKeyFile);
			pastebinDevKey = file.readString().trim();
			file.close();
		}

		String urlParameters = "api_option=paste&api_paste_private=0&"
				+ "api_dev_key=" + pastebinDevKey + "&api_paste_name="
				+ filename + "&api_paste_code=" + URLEncoder.encode(result, "UTF-8");

		//Sending post
		StdOut.println("Sending ...");
		conn.setDoOutput(true);
		DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
		writer.writeBytes(urlParameters);
		writer.flush();
		writer.close();
		StdOut.println("Done sending!");

		//Response
		StdOut.println("Receiving response ...");
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		StdOut.println("Done receiving !");

		//print result
		System.out.println(response.toString());
	}

	//Take test-case related input from the user.
	private void takeInput() {
		String option;
		StdOut.print("Enter the filename :");
		filename = StdIn.readString();

		StdOut.print("Choose the type of data to be generated:\n"
				+ "1. List of random numbers\n"
				+ "2. Graph\n"
				+ "Enter the option number:");
		option = StdIn.readString().trim();

		switch(option) {
			case "1":
				generateList();
				break;
			case "2":
				generateGraph();
				break;
			default:
				generateList();
				break;
		}
	}
	
	private void generateGraph() {
		// TODO Auto-generated method stub
		result = "Graph test case yet to implemented.";
	}

	private void generateList() {
		int count=0;
		String option;
		StdOut.print("Type of list:\n"
				+ "1. Interger\n"
				+ "2. Float\n"
				+ "Enter the option number:");
		option = StdIn.readString().trim();

		StdOut.print("Size of list you want:");
		count = StdIn.readInt();

		StdOut.println(filename + " will be of following format:\n"
				+ "[size]\n"
				+ "[Number 1]\n"
				+ "[Number 2]\n"
				+ "...\n"
				+ "[Number n]\n");

		result = Integer.toString(count) + "\n";
		while(count-- > 0)
			result += generateNumber(option);

	}

	private String generateNumber(String option) {
		switch(option) {
		case "1":
			return Integer.toString(StdRandom.uniform(INTMAX)) + "\n";
		case "2":
			return Double.toString(StdRandom.uniform(DBMIN,DBMAX)) + "\n";
		default:
			return Integer.toString(StdRandom.uniform(INTMAX)) + "\n";
		}
	}

	//Write the result to the file
	private void makeFile() {
		StdOut.println("Creating file ...");
		Out file = new Out(filename);
		file.print(result);
		file.close();
		StdOut.println("File created.");
	}
	
	public static void main(String[] args) {
		RandomTestGenerator obj = new RandomTestGenerator();
		obj.init();
	}

}
