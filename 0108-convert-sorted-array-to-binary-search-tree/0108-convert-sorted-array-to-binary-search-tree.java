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
//     public TreeNode sortedArrayToBST(int[] nums) {
//         /*
//         Convert from sorted array, inorder traversal
//         */
//         return buildBinaryTree(nums, 0, nums.length-1);
//     }

//     TreeNode buildBinaryTree(int[] nums, int low, int high){
//         if(low>high){
//             return null;
//         }
        
//         int mid = (low+high)/2;
//         TreeNode root = new TreeNode(nums[mid]);
//         root.left = buildBinaryTree(nums, low, mid-1);
//         root.right = buildBinaryTree(nums, mid+1, high);
//         return root;
//     }
// }

// --------- REVISION ------------
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int low, int high) {
        if(low>high) {
            return null;
        }
        
        int mid = low + (high-low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, low, mid-1);
        root.right = buildTree(nums, mid+1, high);
        return root;
    }
}