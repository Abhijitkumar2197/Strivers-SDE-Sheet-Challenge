/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/
import java.util.*;

public class Solution 
{
    public static String serializeTree(TreeNode<Integer> root)
        {
            if (root == null) return "n";
            StringBuilder ans = new StringBuilder("");
            ans.append(bfsserilaize(root));
            return ans.toString();
        }
        public static String bfsserilaize(TreeNode root) {
            StringBuilder ans = new StringBuilder("");
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            ans.append(root.data + " ");
            while (!q.isEmpty()) {
                int len = q.size();
                for (int i = 0; i < len; i++) {
                    TreeNode temp = q.poll();
                    if (temp.left != null) {
                        q.offer(temp.left);
                        ans.append(temp.left.data + " ");
                    } else {
                        ans.append("n ");
                    }
                    if (temp.right != null) {
                        q.offer(temp.right);
                        ans.append(temp.right.data + " ");
                    } else {
                        ans.append("n ");
                    }
                }
            }
            return ans.toString();
        }

        public static TreeNode<Integer> deserializeTree(String str)
        {
            if(str == "n") return null;
            String[] arr = str.split(" ");
            TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            for(int i = 1 ; i< arr.length ;i++){
                TreeNode temp = q.poll();
                if(!arr[i].equals("n")){
                    TreeNode t = new TreeNode(Integer.valueOf(arr[i]));
                    temp.left = t;
                    q.add(t);
                }
                if(i + 1 < arr.length && !arr[++i].equals("n")){
                    TreeNode t = new TreeNode(Integer.valueOf(arr[i]));
                    temp.right= t;
                    q.add(t);
                }
            }
            return root;
        }
}
