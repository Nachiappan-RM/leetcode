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
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> res = new ArrayList<List<Integer>>();

//         if(root == null){
//             return res;
//         }

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);

//         while(queue.size()>0){
//             List<Integer> level = new ArrayList<>();
//             int size = queue.size();
//             for(int i=0; i<size; i++){
//                 TreeNode node = queue.poll();
//                 level.add(node.val);
//                 if(node.left!=null){
//                     queue.add(node.left);
//                 }
//                 if(node.right!=null){
//                     queue.add(node.right);
//                 }
//             }
//             res.add(level);
//         }

//         return res;

//     }
// }

// ------ REVISION ---------------
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> levelOrders = new ArrayList<>();

        if(root == null) return levelOrders;

        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            while(size-->0){
                TreeNode curr = queue.poll();
                currLevel.add(curr.val);
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            levelOrders.add(currLevel);
        }
        return levelOrders;
    }
}