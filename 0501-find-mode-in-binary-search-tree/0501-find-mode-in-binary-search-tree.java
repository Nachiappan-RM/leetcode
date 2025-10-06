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
/**
Counting the elements should work here. - BST

HashMap to count the elements -> count

Doing sort of dfs and populate hashmap with counts
tracking the global maxcount
after traversal - result array from map entires equal to maxCount

TC - O(n)
SC - O(n) and recursion stack for dfs O(n)
*/
/*
class Solution {
    private Map<Integer, Integer> countMap = new HashMap<>();
    private int max = 0;
    public int[] findMode(TreeNode root) {
        dfs(root);

        //get all keys with frq == max
        List<Integer> modes = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            if(entry.getValue() == max) {
                modes.add(entry.getKey());
            }
        }

        //List to int
        int[] result = new int[modes.size()];
        for(int i=0; i<modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;
    }

    private void dfs(TreeNode node) {
        if( node == null) return;

        dfs(node.left);

        countMap.put(node.val, countMap.getOrDefault(node.val,0) + 1);
        max = Math.max(max, countMap.get(node.val));

        dfs(node.right);
    }
}
*/

/**
Thinking of eliminating that hashmap,
in-order gives proper sorted since its BST
We can use in-order and traversing n+n and keeping the space O(1) without recursive stack



*/
class Solution {
    private Integer prevValue = null;
    private int currCount = 0;
    private int max = 0;
    private List<Integer> modes = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] result = new int[modes.size()];
        for(int i =0; i< modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inorder(TreeNode node) {
        if(node == null) return;


        inorder(node.left);
        int val = node.val;
        //same as previous
        if(prevValue != null && val == prevValue) {
            currCount++;
        } else {
            currCount = 1;
            prevValue = val;
        }

        if(currCount > max) {
            max = currCount;
            modes.clear();
            modes.add(val);
        } else if(currCount == max) {
            modes.add(val);
        }
        
        inorder(node.right);
    }
}