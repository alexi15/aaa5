// Move-to-front
// 11 October 2016, Magnus M. Halldorsson
package aaa5;

import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;

import edu.princeton.cs.algs4.BinaryIn;
import edu.princeton.cs.algs4.BinaryOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class MoveToFront {
	
	private static char[] alph = new char[256];
	PriorityQueue<Character> priQ = new PriorityQueue<Character>();
	Queue<Character> Q = new Queue<Character>();
	private static ArrayList<Character> AL = new ArrayList<Character>();
	
	
	private static void init() {
		
		for(char i = 0; i < 256; i++)
		{
			//order[i] = (char) (i & 0xff);
			AL.add(i);
			//StdOut.println(add.get(i));
		}
		
		
	}

	// apply move-to-front encoding
	public static void encode(BinaryIn in, BinaryOut out) {
		init();
		
	    // TO BE ADDED
		
		while(!in.isEmpty())
		{
			char currIn = in.readChar();
			int count = 0;
			for(int i = 0; i < 256; i++)
			{
				if(currIn == AL.get(i))
				{
					break;
				}
				count++;
			}
			out.write((byte)count);
			AL.remove(count);
			AL.add(0, currIn);
			StdOut.println(AL.get(0));
		}					
	}

	
	// apply move-to-front decoding
	public static void decode(BinaryIn in, BinaryOut out) {
	    // TO BE ADDED
		init();
		
		while(!in.isEmpty())
		{
			char currIn = in.readChar();
			out.write(currIn);
			AL.remove(currIn);
			AL.add(0, currIn);
			
		}
	}
	
	// if args[0] is '-', apply move-to-front encoding
	// if args[0] is '+', apply move-to-front decoding
	// if args[0] is 'b', perform both
	public static void main(String[] args) {
		if (args.length < 1) {
			StdOut.println("Usage: java MoveToFront (-|+|b) <infile> <outfile>");
			return;
		}
		/*
		char n0 = '-';
		String n1 = "C:/Users/Arnar/Downloads/Data/abra.txt";
		String n2 = "C:/Users/Arnar/Downloads/Data/abraOut.txt";
		*/
		BinaryIn in = new BinaryIn(args[1]);
		BinaryOut out = new BinaryOut(args[2]);
		char ch = args[0].charAt(0);
		if (ch == '-')
			encode(in, out);
		else if (ch == '+')
			decode(in,out);
		else if (ch == 'b') { // Do both encode then decode
			encode(in,out);
			out.close();
			BinaryIn in2 = new BinaryIn(args[2]);
			out = new BinaryOut(args[2]+".out");
			decode(in2,out);
		}
		out.close(); 
	}

}
