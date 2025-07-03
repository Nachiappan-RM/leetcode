/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     public boolean isBalanced(TreeNode root) {
//         if(root==null) return true;
//         int left = 0, right =0;
//         if(root.left!=null){
//             left = height(root.left);
//         }
//         if(root.right!=null){
//             right = height(root.right);
//         }
//         // System.out.println(left);
//         // System.out.println(right);
//         int ans = (height(root.left)-height(root.right));
//         // System.out.println(ans==0 || ans==1 || ans==-1);
//         // return Math.abs(right-left)<=1;
//         return (ans==0 || ans==1 || ans==-1) && isBalanced(root.left) && isBalanced(root.right);
//     }

//     int height(TreeNode root){
//         if(root==null){
//             return 0;
//         }
//         int left = 0, right =0;
//         if(root.left!=null){
//             left = height(root.left);
//         }
        
//         if(root.right!=null){
//             right = height(root.right);
//         }

//         return Math.max(left,right)+1;
//     }   
// }


// ------REVISION------------
class Solution{
    public boolean isBalanced(TreeNode root){
        if(root == null) return true;
        if(Math.abs(height(root.left) - height(root.right))>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root){
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right))+1;
    }
}