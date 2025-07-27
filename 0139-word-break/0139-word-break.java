/*
class Solution {
    class TrieNode{
        TrieNode children[];
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    class Trie{
        TrieNode root;
        Trie(){
            this.root = new TrieNode();
        }
        public void insert(String word){
            TrieNode curr = root;
            for(int i=0; i<word.length(); i++){
                if(curr.children[word.charAt(i)-'a']==null){
                    curr.children[word.charAt(i)-'a'] = new TrieNode();
                }
                curr = curr.children[word.charAt(i)-'a'];
            }
            curr.isEnd=true;
        }
        public boolean search(String s, TrieNode currRoot, int ind){
            if(s.length()<=ind){
                if(currRoot == null) return false;
                return currRoot.isEnd;
            }
            TrieNode curr = root;
            while(ind<s.length()){
                if(curr.children[s.charAt(ind)-'a'] == null){
                    return false;
                }
                curr = curr.children[s.charAt(ind)-'a'];
                if(curr.isEnd && search(s, curr, ind+1)){
                    return true;
                }
                ind++;
            }
            return curr.isEnd;
        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for(String word:wordDict){
            trie.insert(word);
        }
        return trie.search(s, trie.root, 0);
    }
}
*/

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();

        for(String word: wordDict) {
            trie.add(word);
        }

        return search(s, 0, trie.root, new Boolean[s.length()]);
    }
    
    private boolean search(String s, int ind, TrieNode root, Boolean[] memo) {
        if (ind == s.length()) return true;
        if(memo[ind] != null) {
            return memo[ind];
        }
        TrieNode node = root;
        for(int i=ind; i<s.length(); i++) {
            char c = s.charAt(i);
            if(node.children[c - 'a'] == null) {
                return memo[ind] = false;
            }
            node = node.children[c - 'a'];
            if(node.isEnd) {
                if(search(s, i+1, root, memo)) {
                    return memo[ind] = true;
                }
            }
        }
        return memo[ind] = false;
    }
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    class Trie {
        TrieNode root;
        Trie() {
            this.root = new TrieNode();
        }

        public boolean add(String word) {
            TrieNode node = root;

            for(char c : word.toCharArray()) {
                if(node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }

            node.isEnd = true;
            return true;
        }

        public boolean search(String word) {
            TrieNode node = root;

            for(char c : word.toCharArray()) {
                if(node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            
            return node.isEnd;
        }
    }
}