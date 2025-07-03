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
//     int diameter = Integer.MIN_VALUE;
//     public int diameterOfBinaryTree(TreeNode root) {
//         if(root == null) return 0;
//         depth(root);
//         return diameter;
//     }

//     private int depth(TreeNode node){
//         if(node == null){
//             return 0;
//         }
//         int l = depth(node.left);
//         int r = depth(node.right);
//         if(l+r>diameter){
//             diameter = l+r;
//         }

//         return Math.max(l,r)+1;
//     }
// }

class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculateDiameter(root);
        return diameter;
    }

    private int calculateDiameter(TreeNode root){
        if(root == null) {
            return 0;
        }
        int l = calculateDiameter(root.left);
        int r = calculateDiameter(root.right);


        diameter = Math.max(diameter, l+r);
        
        return 1+Math.max(r,l);
    }
}