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
	
	int[] order = new int[256];
	PriorityQueue<Character> priQ = new PriorityQueue<Character>();
	Queue<Character> Q = new Queue<Character>();
	private static ArrayList<Character> AL = new ArrayList<Character>();
	
	
	private static void init() {
		// TODO Auto-generated constructor stub
		for(int i = 0; i < 256; i++)
		{
			//order[i] = (char) i;
			AL.add((char) i);
//			StdOut.println(AL.get(i));
		}
	}

	// apply move-to-front encoding
	public static void encode(BinaryIn in, BinaryOut out) {
		init();
		
	    // TO BE ADDED
		
		while(!in.isEmpty())
		{
			char currIn = in.readChar();
				AL.remove(currIn);
				AL.add(0, currIn);
		}
		
	}
	
	// apply move-to-front decoding
	public static void decode(BinaryIn in, BinaryOut out) {
	    // TO BE ADDED
	}
	
	// if args[0] is '-', apply move-to-front encoding
	// if args[0] is '+', apply move-to-front decoding
	// if args[0] is 'b', perform both
	public static void main(String[] args) {
		/*if (args.length < 1) {
			StdOut.println("Usage: java MoveToFront (-|+|b) <infile> <outfile>");
			return;
		}
		*/
		char n0 = '-';
		String n1 = "C:\\Users\\Alex\\workspace\\Reiknirit\\src\\s5\\abra.txt";
		String n2 = "abra.mdf";
		
		BinaryIn in = new BinaryIn(n1);//args[1]);
		BinaryOut out = new BinaryOut(n2);//args[2]);
		char ch = n0;//args[0].charAt(0);
		if (ch == '-')
			encode(in, out);
		else if (ch == '+')
			decode(in,out);
		else if (ch == 'b') { // Do both encode then decode
			encode(in,out);
			out.close();
			BinaryIn in2 = new BinaryIn(args[2]);
			out = new BinaryOut(n2/*args[2]*/+".out");
			decode(in2,out);
		}
		out.close(); 
	}

}
