package src.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/word-search-ii/
 * Example:
 *
 * Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 * @author: wqdong
 * @create: 2019-08-27 09:57
 **/
class TrieNode {

  public boolean isWord;
  public TrieNode[] children = new TrieNode[26];
  public TrieNode() {
  }
}

class Trie{

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode ws = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (ws.children[c - 'a'] == null) {
        ws.children[c - 'a'] = new TrieNode();
      }
      ws = ws.children[c - 'a'];
    }
    ws.isWord = true;
  }

  public boolean search(String word) {
    TrieNode ws = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (ws.children[c - 'a'] == null) {
        return false;
      }
      ws = ws.children[c - 'a'];
    }
    return ws.isWord;
  }

  public boolean startsWith(String prefix) {
    TrieNode ws = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (ws.children[c - 'a'] == null) {
        return false;
      }
      ws = ws.children[c - 'a'];
    }
    return true;
  }
}

public class Word_Search_II {

  Set<String> res = new HashSet<String>();

  public static void main(String[] args){
    char[][] board = new char[][] {{'o','a','a','n'},
    {'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'} };

    String[] words = new String[]{"oath","pea","eat","rain"};

    Word_Search_II s = new Word_Search_II();

    System.out.println(s.findWords(board, words));
  }

  public List<String> findWords(char[][] board, String[] words) {
    Trie trie = new Trie();
    for (String word : words) {
      trie.insert(word);
    }

    int m = board.length;
    int n = board[0].length;
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        dfs(board, visited, "", i, j, trie);
      }
    }

    return new ArrayList<String>(res);
  }

  public void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
    if (visited[x][y]) return;

    str += board[x][y];
    if (!trie.startsWith(str)) return;

    if (trie.search(str)) {
      res.add(str);
    }

    visited[x][y] = true;
    dfs(board, visited, str, x - 1, y, trie);
    dfs(board, visited, str, x + 1, y, trie);
    dfs(board, visited, str, x, y - 1, trie);
    dfs(board, visited, str, x, y + 1, trie);
    visited[x][y] = false;
  }
}
