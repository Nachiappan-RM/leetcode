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
//     private int res;
//     private int i = 1;
//     public int kthSmallest(TreeNode root, int k) {
//         findKth(root, k);
//         return res;
//     }

//     private void findKth(TreeNode root, int k){
//         if(root == null){
//             return;
//         }

//         findKth(root.left,k);
//         // System.out.println(root.val);
//         if(i == k){
//             res = root.val;
//         }
//         i++;
//         findKth(root.right, k);
//         return;
//     }
// }


// ---------- REVISION -------------
class Solution {
    /**
    Looks like in-order traversal and return the k-th value
     */
    int kthsmaller = 0;
    int i = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return kthsmaller;
    }

    private void inorder(TreeNode root, int k){
        if(root == null) return;
        inorder(root.left, k);
        i = i+1;
        if(i == k){
            kthsmaller = root.val;
            return;
        }
        inorder(root.right, k);
    }
}