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
//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         if(subRoot==null) return true;
//         if(root==null && subRoot==null) return true;
//         if(root==null) return false;
        
//         if(root.val == subRoot.val && isSameTree(root, subRoot)){
//             return true;
//         }
//         return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
//     }

//     private boolean isSameTree(TreeNode root1, TreeNode root2){
//         if(root1==null && root2==null) return true;
//         if(root1==null || root2==null) return false;
//         return (root1.val==root2.val) && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
//     }
// }


// ---------------REVISION-----------------
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        
        return (p.val==q.val) && isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}