// class WordDictionary {
//     // Idea is to have Tire 
//     // - To add words 
//     // -To look its easy if we have to the search if current char is . we have to try to see all possible character in the level    
//     TrieNode root;
//     class TrieNode{
//         TrieNode[] children = new TrieNode[26];
//         boolean isEnd = false;
//     }
//     public WordDictionary() {
//         this.root = new TrieNode();
//     }
    
//     public void addWord(String word) {
//         TrieNode curr = root;
//         for(int i=0; i<word.length(); i++){
//             if(curr.children[word.charAt(i)-'a'] == null){
//                 curr.children[word.charAt(i)-'a'] = new TrieNode();
//             }
//             curr = curr.children[word.charAt(i)-'a'];
//         }
//         curr.isEnd = true;
//     }
    
//     public boolean search(String word) {
//         return search(word, root, 0);
//     }

//     private boolean search(String word, TrieNode start, int ind){
//         TrieNode curr = start;
//         for(int i=ind; i<word.length(); i++){
//             char c = word.charAt(i);
//             if(c == '.'){
//                 for(int j=0; j<26; j++){
//                     TrieNode child = curr.children[j];
//                     if(child!=null && search(word, child, i+1)){
//                         return true;
//                     }
//                 }
//                 return false;
//             }else{
//                 if(curr.children[word.charAt(i)-'a'] == null) return false;
//                 curr = curr.children[word.charAt(i)-'a'];
//             }
//         }
//         return curr.isEnd;
//     }
// }

// /**
//  * Your WordDictionary object will be instantiated and called as such:
//  * WordDictionary obj = new WordDictionary();
//  * obj.addWord(word);
//  * boolean param_2 = obj.search(word);
//  */

// ------------- REVISION ------------
class WordDictionary {
    class TrieNode {
        public TrieNode() {
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
        boolean isEnd;
        TrieNode children[];
    }

    TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        if(word.length() == 0) {
            //throw some exceptions
            return;
        }

        TrieNode curr = root;
        
        for(char c: word.toCharArray()) {
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int i, TrieNode node) {
        if(node == null || i>word.length()) {
            return false;
        }
        if(i==word.length()) {
            return node.isEnd;
        }

        if(word.charAt(i) == '.') {
            for(TrieNode child: node.children) {
                if(searchHelper(word, i+1, child)) {
                    return true;
                }
            }
            return false;
        }
        return searchHelper(word, i+1, node.children[word.charAt(i)-'a']);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */