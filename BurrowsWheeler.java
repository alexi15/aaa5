package aaa5;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinaryIn;
import edu.princeton.cs.algs4.BinaryOut;
import edu.princeton.cs.algs4.StdOut;

public class BurrowsWheeler {

	// apply Burrows-Wheeler transform, reading from standard input and writing to standard output
	public static void transform(BinaryIn in, BinaryOut out) {
	    // FILL IN
		String s = in.readString();
		//char [] input = s.toCharArray();
		CircularSuffixArray circularSuffix = new CircularSuffixArray(s);
		int index = circularSuffix.index(0);
		
		out.write(index);
		//out.write("\n");
		
		for(int i = 0; i < circularSuffix.length(); i++)
		{
			out.write(s.charAt((circularSuffix.index(i) + s.length() - 1) % s.length()));
		}
		
		
	}
	
	// apply Burrows-Wheeler inverse transform, reading from standard input and writing to standard output
	public static void inverseTransform(BinaryIn in, BinaryOut out) {
	    // FILL IN
		//String s = in.readString();
		//int first = Character.getNumericValue(s.charAt(0));
		/*char[] chars = (in.readString()).toCharArray();
		
		char[] sorted = chars.clone();
		
		int first = Character.getNumericValue(chars[0]);
		
		int length = chars.length;
		
		Arrays.sort(sorted);
		
		int[] next = new int[length];
		int[] ascciIndex = new int[256];
		
		for(int i = 0; i < length; i++)
		{
			for(int i = )
		}
		*/
		int R = 256;
		
		 int first = in.readInt();
	        String t = in.readString();
	        int n = t.length();
	        int[] count = new int[R + 1], next = new int[n];
	        for (int i = 0; i < n; i++)
	            count[t.charAt(i) + 1]++;
	        for (int i = 1; i < R + 1; i++)
	            count[i] += count[i - 1];
	        for (int i = 0; i < n; i++)
	            next[count[t.charAt(i)]++] = i;
	        for (int i = next[first], c = 0; c < n; i = next[i], c++)
	        	out.write(t.charAt(i));
	 
		
		
		
	}

	public static void main(String[] args) {
		if (args.length < 3) {
			StdOut.println("Usage: java BurrowsWheeler (-|+) <infile> <outfile>");
			return;
		}
		
		/*char ch = '-';
		String n1 = "C:\\Users\\Alex\\workspace\\Reiknirit\\src\\s5\\abra.txt";
		String n2 = "C:\\Users\\Alex\\Documents\\GitHub\\aaa5\\abraout.txt";
		*/
		BinaryIn in = new BinaryIn(args[1]);
		BinaryOut out = new BinaryOut(args[2]);
		char ch = args[0].charAt(0);
		if (ch == '-')
			transform(in, out);
		else if (ch == '+')
			inverseTransform(in,out);
		else if (ch == 'b') { // Do both encode then decode
			transform(in, out);
			out.close();
			BinaryIn in2 = new BinaryIn(args[2]);
			out = new BinaryOut(args[2]+".out");
			inverseTransform(in2,out);
		}
		out.close();
	}

}
