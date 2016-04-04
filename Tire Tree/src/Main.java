import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		Trie t = new Trie();
		
		int num = Integer.parseInt(in.nextLine());
		for (int i = 0; i < num; i++) 
			t.insert(in.nextLine().trim());
		
		num = Integer.parseInt(in.nextLine());
		for (int i = 0; i < num; i++) 
			System.out.println(t.count(in.nextLine().trim()));
		
		in.close();
	}

}

class TrieNode {
	HashMap<Character, TrieNode> edges = new HashMap<Character, TrieNode>();
	int num = 0;
	boolean leave = false;
    // Initialize your data structure here.
    public TrieNode() {
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	if (word == null || word.length() == 0)
    		return;
    	TrieNode cur = root;
        for (char c: word.toCharArray()){
        	if (!cur.edges.containsKey(c)){
        		TrieNode newNode = new TrieNode();
        		cur.edges.put(c, newNode);
        		cur = newNode;
        		cur.num++;
        	}
        	else {
        		cur = cur.edges.get(c);
        		cur.num++;
        	}
        }
        cur.leave = true;
    }
    
    public int count(String prefix) {
    	TrieNode cur = root;
    	for (char c: prefix.toCharArray()) {
    		if (!cur.edges.containsKey(c))
    			return 0;
    		else {
    			cur = cur.edges.get(c);
    		}
    	}
    	return cur.num;
    }

}