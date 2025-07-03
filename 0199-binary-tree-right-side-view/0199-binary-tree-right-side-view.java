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
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if(root == null) return result;

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);

//         while(!queue.isEmpty()){
//             int size = queue.size();
//             int lastVal = root.val; //To start dummy
//             while(size-->0){
//                 TreeNode curr = queue.poll();
//                 lastVal = curr.val;
//                 if(curr.left!=null) queue.offer(curr.left);
//                 if(curr.right!=null) queue.offer(curr.right);
//             }
//             result.add(lastVal);
//         }
//         return result;
//     }
// }

// --------- REVISION ------------
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> rightView = new ArrayList<>();

        if(root == null) return rightView;

        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                TreeNode curr = queue.poll();
                if(size == 0) rightView.add(curr.val);

                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
        }
        return rightView;
    }
}