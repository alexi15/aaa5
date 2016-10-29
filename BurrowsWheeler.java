package aaa5;

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
		
		int first = 0;
		
		while (first < circularSuffix.length() && circularSuffix.index(first) != 0) {
            first++;
        }
		
		
		out.write(first);
		
		for(int i = 0; i < circularSuffix.length(); i++)
		{
			out.write(s.charAt((circularSuffix.index(i) + s.length() - 1) % s.length()));
		}
		
		
	}
	
	// apply Burrows-Wheeler inverse transform, reading from standard input and writing to standard output
	public static void inverseTransform(BinaryIn in, BinaryOut out) {
			int first = in.readInt();
	        char[] chars = (in.readString()).toCharArray();
	        int length = chars.length;
	        
	        int[] asc = new int[256+1], next = new int[length];
	        
	        for (int i = 0; i < length; i++)
	            asc[chars[i] + 1]++;
	        
	        for (int i = 1; i < 256 + 1; i++)
	            asc[i] += asc[i - 1];
	        
	        for(int i = 0; i < length; i++)
	        	next[asc[chars[i]]++] = i;
	        
	        for(int i = next[first], c = 0; c < length; i = next[i], c++)
	        	out.write(chars[i]);
	        
	}

	public static void main(String[] args) {
		if (args.length < 3) {
			StdOut.println("Usage: java BurrowsWheeler (-|+) <infile> <outfile>");
			return;
		}
		
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
