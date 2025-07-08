/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// public class Codec {

//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
//         if (root == null)
//             return new String();

//         List<String> serialized = new ArrayList<>();
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             while (size-- > 0) {
//                 TreeNode curr = queue.poll();

//                 if (curr.val == 1001) {
//                     serialized.add("null");
//                 } else {
//                     serialized.add(String.valueOf(curr.val));
//                 }
//                 if (curr.val != 1001) {
//                     if (curr.left != null) {
//                         queue.offer(curr.left);
//                     } else {
//                         queue.offer(new TreeNode(1001)); //Dummy reference
//                     }

//                     if (curr.right != null) {
//                         queue.offer(curr.right);
//                     } else {
//                         queue.offer(new TreeNode(1001)); //Dummy reference
//                     }
//                 }
//             }
//         }
//         // System.out.println("[" + String.join(",", serialized) + "]");
//         return String.join(",", serialized);
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         if (data.isEmpty())
//             return null;

//         String[] deserialized = data.split(",");
//         int n = deserialized.length;
//         TreeNode root = new TreeNode(Integer.parseInt(deserialized[0]));
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
//         int i=1;
//         while(i<n){
//             TreeNode curr = queue.poll();
//             if(!deserialized[i].equals("null")){
//                 curr.left = new TreeNode(Integer.parseInt(deserialized[i]));
//                 queue.offer(curr.left);
//             }
//             i++;
//             if(i<n && !deserialized[i].equals("null")){
//                 curr.right = new TreeNode(Integer.parseInt(deserialized[i]));
//                 queue.offer(curr.right);
//             }
//             i++;
//         }
//         return root;
//     }
// }

// ----------- REVISION --------
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder serialized = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                serialized.append("#").append(",");
            } else {
                serialized.append(curr.val).append(",");
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        return serialized.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()|| data == null|| data.equals("#,")) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        StringBuilder serialized = new StringBuilder(data);
        int commaIndex = serialized.indexOf(",");
        String rootString = serialized.substring(0, commaIndex);
        serialized.delete(0, commaIndex + 1);

        TreeNode root = new TreeNode(Integer.parseInt(rootString));
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            commaIndex = serialized.indexOf(",");
            String nodeString = serialized.substring(0, commaIndex);
            serialized.delete(0, commaIndex + 1);

            if (!nodeString.equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodeString));
                node.left = leftNode;
                queue.offer(leftNode);
            }

            commaIndex = serialized.indexOf(",");
            nodeString = serialized.substring(0, commaIndex);
            serialized.delete(0, commaIndex + 1);

            if (!nodeString.equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodeString));
                node.right = rightNode;
                queue.offer(rightNode);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));