package trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	private class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;
		
		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}
	}
	
	private TrieNode root;
	
	
	public void insert(String word) {
		TrieNode currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node = currentNode.children.get(c);
			if (node == null) {
				node = new TrieNode();
				currentNode.children.put(c, node);
			}
			
			currentNode = node;
		}
		
		currentNode.endOfWord = true;
 	}

	public boolean search(String word) {
		TrieNode currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node = currentNode.children.get(c);
			if (node == null) {
				// char not found .. so false
				return false;
			}
			
			currentNode = node;
		}
		
		if (currentNode.endOfWord) {
			// word exists
		}else {
			// word doesn't exists
		}
		
		return currentNode.endOfWord;
	}
	
	
	public void delete(String word) {
		TrieNode node = root;
		delete(node, word, 0);
	}
	
	private boolean delete(TrieNode parentNode, String word, int index) {
		if (index == word.length()) {
			// this should be end of word node case
			if (!parentNode.endOfWord) {
				return false;
			}
			
			// end of word and children not empty -> it is prefix
			// end of word and children empty -> delete.
			return parentNode.children.isEmpty();
		}
		
		
		char ch = word.charAt(index);
		TrieNode currentNode = parentNode.children.get(ch);
		if (currentNode == null) {
			// word itself not exists
			return false;
		}
		
		// index+1 char node is deleted and current is not end of word -> delete
		boolean canDeleteCurrentNode = delete(parentNode, word, index +1) &&  !currentNode.endOfWord;
		if (canDeleteCurrentNode) {
			// delete the node
			currentNode.children.remove(ch);
			
			// if current node has other children -> not eligible for delete. if no children .. delete
			return currentNode.children.isEmpty();
		}
		
		return false;
	}
	
}
