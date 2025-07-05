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
//     public boolean isValidBST(TreeNode root) {
//         if(root==null){
//             return true;
//         }
//         if(root.left ==null && root.right == null){
//             return true;
//         }
//         return checkValid(root, null, null);
//         // return isValidLeftSubTree(root.left, root.val, root.val) && isValidRightSubTree(root.right, root.val, root.val);
//     }

//     private boolean checkValid(TreeNode root, Integer l, Integer r){
//         if(root == null){
//             return true;
//         }
//         int v = root.val;
//         if(l!=null && l>=v){
//             return false;
//         }

//         if(r!=null && r<=v){
//             return false;
//         }
        
//         return checkValid(root.right, v, r) && checkValid(root.left, l, v);
//     }

//     // private boolean isValidLeftSubTree(TreeNode root, int r, int l){
//     //     if(root==null){
//     //         return true;
//     //     }

//     //     // if(root.left ==null && root.right == null){
//     //     //     return root.val<r;
//     //     // }

//     //     boolean isValid = root.val<r && root.val>l;
//     //     if(root.left!=null){
//     //         isValid = isValid && (root.left.val<root.val); 
//     //     }
//     //     if(root.right!=null){
//     //         isValid = isValid && (root.right.val>root.val);
//     //     }
//     //     boolean val =  isValid && isValidLeftSubTree(root.left, Math.max(r, root.val), Math.min(l, root.val)) && isValidLeftSubTree(root.right, Math.max(r, root.val), Math.min(l, root.val));
//     //     // System.out.println(root.val +"->" + val);
//     //     return val;
//     // }

//     // private boolean isValidRightSubTree(TreeNode root, int r, int l){
       
//     //     if(root==null){
//     //         return true;
//     //     }

//     //     // if(root.left ==null && root.right == null){
//     //     //     return root.val>r;
//     //     // }
//     //     boolean isValid = root.val>r && root.val<l;
//     //     if(root.left!=null){
//     //         isValid = isValid && (root.left.val<root.val); 
//     //     }
//     //     if(root.right!=null){
//     //         isValid = isValid && (root.right.val>root.val);
//     //     }
//     //     return isValid && isValidRightSubTree(root.left, Math.min(r, root.val), Math.max(l, root.val)) && isValidRightSubTree(root.right, Math.min(r, root.val), Math.max(l, root.val));
//     // }
// }


class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val>= max || root.val<=min) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}