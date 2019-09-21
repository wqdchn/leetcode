package src.medium;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: https://leetcode.com/problems/lru-cache/
 * @author: wqdong
 * @create: 2019-09-21 14:04
 **/

//LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//    cache.put(1, 1);
//    cache.put(2, 2);
//    cache.get(1);       // returns 1
//    cache.put(3, 3);    // evicts key 2
//    cache.get(2);       // returns -1 (not found)
//    cache.put(4, 4);    // evicts key 1
//    cache.get(1);       // returns -1 (not found)
//    cache.get(3);       // returns 3
//    cache.get(4);       // returns 4

class Node {

  int key;
  int val;
  Node prev;
  Node next;

  public Node(int key, int val) {
    this.key = key;
    this.val = val;
    this.prev = null;
    this.next = null;
  }
}

class LRUCache {

  int capacity;
  Node head;
  Node tail;
  HashMap<Integer, Node> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.head = new Node(-1, -1);
    this.tail = new Node(-1, -1);
    this.head.next = this.tail;
    this.tail.prev = this.head;
    this.map = new HashMap<Integer, Node>();
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    Node node = map.get(key);
    this.remove(node);
    this.movetohead(node); // 使用过，令其最新
    return node.val;
  }

  public void put(int key, int value) {
    Node node = this.map.get(key);
    if (node != null) {
      node.val = value;
      this.remove(node);
      this.movetohead(node);
    } else {
      if (this.map.size() == this.capacity) {
        this.poptail();
      }
      node = new Node(key, value);
      this.movetohead(node);
      this.map.put(key, node);
    }
  }

  private void movetohead(Node node) {
    node.prev = this.head;
    node.next = this.head.next;
    this.head.next.prev = node;
    this.head.next = node;
  }

  private void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void poptail() {
    Node last = this.tail.prev;
    this.remove(last);
    this.map.remove(last.key);
  }
}

public class LRU_Cache {

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1));        // returns 1
    cache.put(3, 3);                         // evicts key 2
    System.out.println(cache.get(2));        // returns -1 (not found)
    cache.put(4, 4);                         // evicts key 1
    System.out.println(cache.get(1));        // returns -1 (not found)
    System.out.println(cache.get(3));        // returns 3
    System.out.println(cache.get(4));        // returns 4
  }
}
