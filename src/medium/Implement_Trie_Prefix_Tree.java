package src.medium;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/implement-trie-prefix-tree/
 * @author: wqdong
 * @create: 2019-08-26 10:01
 **/
class TrieNode {

  public boolean isWord;
  public TrieNode[] children = new TrieNode[26];
  public TrieNode() {
  }
}

public class Implement_Trie_Prefix_Tree {

  private TrieNode root;

  public Implement_Trie_Prefix_Tree() {
    root = new TrieNode();
  }

  public static void main(String[] args){
    Implement_Trie_Prefix_Tree trie = new Implement_Trie_Prefix_Tree();
    trie.insert("apple");

    if (trie.search("apple")){
      System.out.println("is word! in trie!");
    }
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
