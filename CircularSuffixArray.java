// Circular Suffix Array
// 11 October 2016
// Magnus M. Halldorsson
package s5;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class CircularSuffixArray {
    // TO BE ADDED


    /**
     * Returns the length of the input string.
     * @return the length of the input string
     */
	public int length() // length of s
	{
	    // TO BE ADDED
	}
	
	/**
     * Returns the index into the original string of the <em>i</em>th smallest circular suffix.
     * That is, {@code text.substring(sa.index(i))} is the <em>i</em>th smallest circular suffix.
     * @param i an integer between 0 and <em>n</em>-1
     * @return the index into the original string of the <em>i</em>th smallest suffix
     * @throws java.lang.IndexOutOfBoundsException unless {@code 0 <= i < n}
     */
	public int index(int i) // returns index of ith sorted suffix
	{
	    // TO BE ADDED
	}
	
	public static void main(String[] args) // unit testing
	{
	    
	   In in = new In(args[0]);
	   String s = in.readAll();  // Read whole file
	   String pair = s + s;
	   CircularSuffixArray suffix = new CircularSuffixArray(s);
	   
	   StdOut.println("  i ind select");
	   StdOut.println("-------------------");
	   
	   for (int i = 0; i < s.length(); i++) {
	       int index = suffix.index(i);
	       String ith = "\"" + pair.substring(index, index+Math.min(index + 50, s.length())) + "\"";
	       StdOut.printf("%3d %3d %s\n", i, index, ith);
	   }	
	}	

}
