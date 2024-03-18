package org.ysavenko.gfg.n2024_03_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

//level-order-traversal
public class Solution {

	static ArrayList<Integer> levelOrder(Node root) {
		final ArrayList<Integer> result = new ArrayList<>();
		for (List<Node> upperLevel = Arrays.asList(root); upperLevel.size() > 0;) {
			ArrayList<Node> level = new ArrayList<>();
			for (Node node : upperLevel) {
				result.add(node.data);
				if (node.left != null) {
					level.add((node.left));
				}
				if (node.right != null) {
					level.add((node.right));
				}
			}
			upperLevel = level;
		}

		return result;
	}

}
