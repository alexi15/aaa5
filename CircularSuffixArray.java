// Circular Suffix Array
// 11 October 2016
// Magnus M. Halldorsson
package aaa5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class CircularSuffixArray {
    // TO BE ADDED
	//private ST<String, Integer> strings = new ST<String, Integer>(); 
	private Node[] strings;
	
	private class Node implements Comparable<Node>{
		private String key;
		private int val;
		
		public Node(String s, int n){
			key = s;
			val = n;
		}

		public int compareTo(Node that) {
			return this.key.compareTo(that.key);
		}
		
		public int getValue(){
			return val;
		}
	}

    public CircularSuffixArray(String s) {
		strings = new Node[s.length()];
		String sub = s;
		char first;
		
		strings[0] = new Node(sub, 0);
		
		for(int i = 1; i < s.length(); i++)
		{
			first = sub.charAt(0);
			sub = sub.substring(1);
			sub = sub + first;
			strings[i] = new Node(sub, i);
		}
		
		Arrays.sort(strings);
	}

	/**
     * Returns the length of the input string.
     * @return the length of the input string
     */
	public int length() // length of s
	{
		return strings.length;
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
		return strings[i].getValue();
	    // TO BE ADDED
	}
	
	public static void main(String[] args) // unit testing
	{
	    
	   In in = new In("C:\\Users\\Alex\\workspace\\Reiknirit\\src\\s5\\abra.txt");
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
