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
//     int max = 0;
//     public int maxDepth(TreeNode root) {
//         findMaxDepth(root, 0);
//         return max;
//     }

//     private void findMaxDepth(TreeNode root, int h){
//         if(root==null){
//             max = Math.max(max, h);
//             return;
//         }
//         findMaxDepth(root.left, h+1);
//         findMaxDepth(root.right, h+1);
//     }
// }

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}