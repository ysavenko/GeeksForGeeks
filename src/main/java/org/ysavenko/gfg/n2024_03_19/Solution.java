package org.ysavenko.gfg.n2024_03_19;

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(read.readLine());

			int edges[][] = new int[n - 1][3];
			for (int i = 0; i < (n - 1); i++) {
				String input_line[] = read.readLine().trim().split("\\s+");
				for (int j = 0; j < 3; j++) {
					edges[i][j] = Integer.parseInt(input_line[j]);
				}
			}

			int q = Integer.parseInt(read.readLine());

			String input_line[] = read.readLine().trim().split("\\s+");
			int queries[] = new int[q];
			for (int i = 0; i < q; i++)
				queries[i] = Integer.parseInt(input_line[i]);

			Solution ob = new Solution();
			ArrayList<Integer> ans = ob.maximumWeight(n, edges, q, queries);
			for (Integer val : ans)
				System.out.print(val + " ");
			System.out.println();
		}
	}
}
// } Driver Code Ends

//User function Template for Java

class Solution {
	ArrayList<Integer> maximumWeight(int n, int edges[][], int q, int queries[]) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		return result;
	}
}

