import java.util.HashMap;

class TrieNode {
	HashMap<Character, TrieNode> edges = new HashMap<Character, TrieNode>();
	boolean leave = false;
    // Initialize your data structure here.
    public TrieNode() {
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	TrieNode cur = root;
        for (char c: word.toCharArray()){
        	if (!cur.edges.containsKey(c)){
        		TrieNode newNode = new TrieNode();
        		cur.edges.put(c, newNode);
        		cur = newNode;
        		
        	}
        	else {
        		cur = cur.edges.get(c);
        	}
        }
        cur.leave = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c: word.toCharArray()){
        	if (!cur.edges.containsKey(c)){
        		return false;
        	}
        	else{
        		cur = cur.edges.get(c);
        	}
        }
        return cur.leave;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode cur = root;
        for (char c: prefix.toCharArray()){
        	if (!cur.edges.containsKey(c)){
        		return false;
        	}
        	else{
        		cur = cur.edges.get(c);
        	}
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");