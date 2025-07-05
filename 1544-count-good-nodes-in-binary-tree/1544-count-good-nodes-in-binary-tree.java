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
//     int goodNodesCount = 0;
//     public int goodNodes(TreeNode root) {
//         if(root == null) return goodNodesCount;
//         lookForGoodNodes(root, root.val);
//         return goodNodesCount;
//     }
//     private void lookForGoodNodes(TreeNode root, int v){
//         if(root == null) return;
//         if(root.val>=v)goodNodesCount++;
//         lookForGoodNodes(root.left, Math.max(root.val, v));
//         lookForGoodNodes(root.right, Math.max(root.val, v));
//     }
// }


// -------- REVISION ------------
class Solution {
    int numberOfGoodNodes = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return numberOfGoodNodes;
        computeGoodNodes(root, root.val);
        return numberOfGoodNodes;
    }
    private void computeGoodNodes(TreeNode root, int max){
        if(root == null) {
            return;
        }

        if(root.val>=max){
            numberOfGoodNodes++;
            max = root.val; 
        }

        computeGoodNodes(root.left, max);
        computeGoodNodes(root.right, max);
    }   
}