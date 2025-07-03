/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         List<TreeNode> pathFromPToRoot = new ArrayList<>();
//         List<TreeNode> pathFromQToRoot = new ArrayList<>();
//         findPath(root, p, pathFromPToRoot);
//         findPath(root, q, pathFromQToRoot);
//         int i = 0, n=Math.min(pathFromPToRoot.size(), pathFromQToRoot.size());
        
//         TreeNode lca = null;
//         while(i<n && pathFromPToRoot.get(i) == pathFromQToRoot.get(i)){
//             lca = pathFromPToRoot.get(i);
//             i++;
//         }
//         return lca;
//     }

//     private boolean findPath(TreeNode root, TreeNode p, List<TreeNode> path){
//         if(root == null) return false;

//         path.add(root);
//         if(root.val == p.val){
//             return true;
//         }
//         if(findPath(root.left, p, path) || findPath(root.right, p, path)) return true;

//         path.remove(path.size()-1);
//         return false;
//     }
// }


// -------- REVISION -------------
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathForP = new ArrayList<>();
        List<TreeNode> pathForQ = new ArrayList<>();

        // Assumption p is always smaller than q
        if(p.val > q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        getPathFromRoot(pathForP, root, p);
        getPathFromRoot(pathForQ, root, q);
        int i = 0;
        int j = 0;

        while(i<pathForP.size() && j<pathForQ.size() && pathForP.get(i) == pathForQ.get(j)){
            i++;
            j++;
        }
        return pathForP.get(i-1);
    }

    private void getPathFromRoot(List<TreeNode> list, TreeNode root, TreeNode p){
        if(root.val == p.val){
            list.add(root);
            return;
        }
        list.add(root);
        if(root.val>p.val){
            getPathFromRoot(list, root.left, p);
        }else{
            getPathFromRoot(list, root.right, p);
        }
    }
}