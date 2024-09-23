package TrieTrees;

public class Trie208 {
    /**
     (root)
     |
     b -> (TrieNode at index 1)
     |      |
     |      a -> (TrieNode at index 0)
     |            |
     |            t -> (TrieNode at index 19, isEndOfWord = true)
     |
     c -> (TrieNode at index 2)
     |
           a -> (TrieNode at index 0)
     |
                t -> (TrieNode at index 19, isEndOfWord = true)
     |
                 r -> (TrieNode at index 17, isEndOfWord = true)

     这是插入了 bat,car,cat的树，可见，如果开头的字母是相同的，那么就公用一个node，后面出现的char都是这个node的children
     但是bat跟car cat开头就不同，所以他自己创了一个母node，然后再在后面接
      **/
    private TrieNode root;

    // TrieNode class to represent each node in the Trie
    private class TrieNode {
        private TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];  // Assuming only lowercase English letters a-z
            isEndOfWord = false;
        }
    }

    // Initialize your data structure here.
    public Trie208() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }

}
