package blind75.tree;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	Map<Character, Trie> children;
	boolean leaf;
	
	 /** Initialize your data structure here. */
    public Trie() {
    	children = new HashMap<>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	Trie current = this;
        for (int i = 0; i < word.length(); i++) {
        	Character c = word.charAt(i);
        	Trie node = current.children.get(c);
        	if (node == null) {
        		// word doesn't exist
        		Trie newNode = new Trie();
        		current.children.put(c, newNode);
        		current = newNode;
        	}else {
        		current = node;
        	}
        }
        
        current.leaf = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	Trie current = this;
    	for (int i = 0; i < word.length(); i++) {
        	Character c = word.charAt(i);
        	Trie node = current.children.get(c);
        	if (node == null) {
        		return false;
        	}
        	
        	current = node;
    	}
    	
        return current.leaf;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	Trie current = this;
    	for (int i = 0; i < prefix.length(); i++) {
        	Character c = prefix.charAt(i);
        	Trie node = current.children.get(c);
        	if (node == null) {
        		return false;
        	}
        	
        	current = node;
    	}
    	
    	return true;
    }

    public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("Anill");
		System.out.println(t.search("Anil"));
	}
}
