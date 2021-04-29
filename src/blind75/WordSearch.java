package blind75;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
	
	public static void main(String[] args) {
		char[][] board = {
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
		};
		
		new WordSearch().findWords(board, new String[]{"oath","pea","eat","rain"});
		
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();

		for (String word : words) {
			if (search(board, word)) {
				System.out.println(word);
				result.add(word);
			}
		}

		return result;
	}

	private boolean search(char[][] board, String word) {
		int r = board.length;
		int c = board[0].length;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean dfs(char[][] board, String word, int index, int i, int j) {
		if (word.length() == index) {
			return true;
		}

		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length 
				|| board[i][j] != word.charAt(index)) {
			return false;
		}

		char temp = board[i][j];
		board[i][j] = ' ';
		
		index++;
		
		boolean found = dfs(board, word, index, i , j - 1) || dfs(board, word, index, i, j + 1)
		|| dfs(board, word, index, i - 1, j) || dfs(board, word, index, i + 1, j);
		
		board[i][j] = temp;
		
		return found;

	}
}
