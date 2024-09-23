package TrieTrees;

class WordDictionary211 {
    /**bool search(word) 如果数据结构中存在字符串与
     * word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
     If you search for the word "a.d", and your current node is the one corresponding to the letter a, when the search reaches .:

     The loop will consider paths starting with the child nodes for 'b', 'c', etc.
     If one of these paths leads to a valid word ending (e.g., "abd"), the search will return true.

     **/

    private TrieNode root;

    // Initialize the data structure here.
    public WordDictionary211() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEndOfWord = true;
    }

    // Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchInNode(word, root);
    }

    private boolean searchInNode(String word, TrieNode node) {
        //如果进来的组合是a.d recursive其实就直接照顾到。如果recursive全程返回ture，那么外面的for loop就废了，直接得到结果

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : node.children) {
                    if (child != null && searchInNode(word.substring(i + 1), child)) {
                        //sunbtring(1)就会走第一个char，保留后面的
                        return true;
                    }
                }
                return false;
            } else {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
        }
        return node.isEndOfWord;
    }

    // Trie Node class
    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndOfWord = false;
    }
}

