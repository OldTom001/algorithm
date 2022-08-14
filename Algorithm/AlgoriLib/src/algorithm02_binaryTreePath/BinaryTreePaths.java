package algorithm02_binaryTreePath;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null)return new ArrayList<>();

        List<String> res = new ArrayList<>();
        dfs(root,1, res);
        return res;

    }
    public void dfs(TreeNode node, int index, List<String> res){
        if(node==null)return;

        if(node.left==null&&node.right==null){//判断叶子结点
            res.add(getPath(index));
        }
        dfs(node.left, 2*index, res);
        dfs(node.right, 2*index+1, res);
    }
    public String getPath(int index){
        int bits = index>>1;
        StringBuffer sb = new StringBuffer("1");
        int pathIndex = 1;
        while(bits >0){
            int bit = bits & index;
            if(bit == 0){
                pathIndex*=2;
                sb.append("->" + pathIndex);

            }else{
                pathIndex = pathIndex*2+1;
                sb.append("->" + pathIndex);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BinaryTreePaths b = new BinaryTreePaths();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> res = b.binaryTreePaths(root);
        for(String s : res){
            System.out.println(s);
        }
    }
}
