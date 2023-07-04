import java.util.* ;

import java.io.*; 
public class Solution {

  public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
	if(root == null) return new ArrayList<>();
    ArrayList<Integer> ans = new ArrayList<>();
	Queue<BinaryTreeNode> q = new LinkedList<>();
	q.add(root);
	while(!q.isEmpty()){
		int len = q.size();
		for(int i = 0; i < len ; i++){
			BinaryTreeNode a = q.poll();
			ans.add(a.val);
			if(a.left != null) q.add(a.left);
			if(a.right != null) q.add(a.right);
		}
	}
	return ans;
  }



}
