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
//     int max = Integer.MIN_VALUE;
//     public int maxPathSum(TreeNode root) {
//         maxSum(root);
//         return max;
//     }
//     private int maxSum(TreeNode root){
//         if(root == null) return 0;
        
//         int left = Math.max(0, maxSum(root.left));
//         int right = Math.max(0, maxSum(root.right));
//         max = Math.max(max, left+right+root.val);
//         return Math.max(right, left)+root.val;
//     }
// }

// ---------- REVISION --------------
class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        maxPath(root);
        return maxSum;
    }

    private int maxPath(TreeNode root){
        if(root == null) {
            return 0;
        }
        
        int left = Math.max(maxPath(root.left), 0);
        int right = Math.max(maxPath(root.right), 0);
        maxSum = Math.max(maxSum, left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}