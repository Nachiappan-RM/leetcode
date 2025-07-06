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
//     Map<Integer, Integer> inorderIndexMap;
//     int preorderIndex;
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         inorderIndexMap = new HashMap<>();
//         preorderIndex = 0;
//         for(int i=0; i<inorder.length; i++){
//             inorderIndexMap.put(inorder[i], i);
//         }

//         return build(preorder, 0, preorder.length-1);
//     }
//     private TreeNode build(int[] preorder, int start, int end){
//         if(start>end) return null;
//         int curr = preorder[preorderIndex++];
//         TreeNode root = new TreeNode(curr);
//         root.left = build(preorder, start, inorderIndexMap.get(curr)-1);
//         root.right = build(preorder, inorderIndexMap.get(curr)+1, end);
//         return root;
//     }
// }

// ---------- REVISION -----------
class Solution {
    /**
    We can use preorder for roots
    left should be left side of that root in inorder and right should be right side of that root in inoder
    Pretty much all the nodes.
    We can recursively call build on left half and right half.

     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n == 0) return null;

        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        //Generating a hashmap for inorder to see the left substree and right subtree
        for(int i=0; i<n; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return helper(preorder, 0, n-1, inorder, 0, n-1, inorderMap);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inorderMap){
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inRoot = inorderMap.get(preorder[preStart]);

        int leftSubTreeCount = inRoot-inStart;

        root.left = helper(preorder, preStart+1, preStart+leftSubTreeCount, inorder, inStart, inRoot-1, inorderMap);
        root.right = helper(preorder, preStart+leftSubTreeCount+1, preEnd, inorder, inRoot+1, inEnd, inorderMap);
        return root;
    }
}