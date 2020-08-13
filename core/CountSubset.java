package com.core;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Test {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        String tree1 = "";
        inorder(s, tree1);
        
        String tree2 = "";
        inorder(t, tree2);
        
        System.out.println(tree1);
        System.out.println(tree2);
        
        
        return tree1.contains(tree2);
    }
    
    public void inorder(TreeNode root, String str){
        
        if(root != null){
            inorder(root.left, str);
            str += root.val;
            inorder(root.right, str);
            
        }else{
            str += "#";
        }
    }
}