package org.ysavenko.gfg.n2024_03_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//{ Driver Code Starts
//Initial Template for Java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class GFG2 {
	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	public static void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data);
		inorder(root.right);
	}

	/* Drier program to test above functions */
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			Node root = buildTree(s);
			GFG g = new GFG();

			ArrayList<Integer> res = g.zigZagTraversal(root);
			for (int i = 0; i < res.size(); i++)
				System.out.print(res.get(i) + " ");
			System.out.println();

			t--;

		}
	}
}
// } Driver Code Ends

//User function Template for Java

/*
 * class Node { int data; Node left,right; Node(int d) { data=d;
 * left=right=null; } }
 */

class GFG {
	// Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root) {
		final ArrayList<Node> result = new ArrayList<>();
		result.add(root);

		boolean right = true;
		int start = 0, end = 1;

		while (start >= result.size()) {
			final Integer position = right ? null : result.size();
			IntStream.range(start, end).filter(Objects::nonNull).mapToObj(i -> result.get(i)).forEach(node -> {
				int index = position == null ? result.size() : position;
				result.add(index, node.left);
				result.add(index, node.right);
			});
			start = end;
			end = result.size();
		}
		return new ArrayList<>(result.stream().map(node->node.data).collect(Collectors.toList()));
	}
}