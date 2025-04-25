package org.example.Designs;

import java.util.HashMap;
import java.util.Map;

class Node
{
        int key;
        int val;

        Node prev, next;

        Node()
        {
            this.prev = null;
            this.next = null;
        }

}
public class LRUCache {

    Map<Integer, Node> map;

    Node head, tail;

    int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {

        if(!map.containsKey(key))
            return -1;
        Node node = map.get(key); // get node from map
        removeNode(map.get(key)); // remove from list
        insertNode(node); // insert at the end
        return node.val; // return value
    }

    public void put(int key, int value) {

        if(map.containsKey(key))
        {

            Node node = map.get(key);
            removeNode(node); // remove old node from list
            node.val = value; // update value
            insertNode(node); // insert new node at the end
            map.put(key, node); // update map
            return;
        }

        if(map.size() == capacity)
        {
            //Node node = ;
            //removeNode(node);
            map.remove(head.next.key); // remove from map
            removeNode(head.next); // remove from list
            //head.next = head.next.next;

        }
        Node node = new Node(); // create new node
        node.key = key;
        node.val = value;
        insertNode(node); // insert new node at the end
        map.put(key, node); // add to map

    }

    void removeNode(Node node)
    {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = node.prev = null;
    }

    void insertNode(Node node)
    {

        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    public static void main( String[] args)

    {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1)); // returns 1
        lru.put(3, 3); // evicts key 2
        System.out.println(lru.get(2)); // returns -1 (not found)
        lru.put(4, 4); // evicts key 1
        System.out.println(lru.get(1)); // returns -1 (not found)
        System.out.println(lru.get(3)); // returns 3
        System.out.println(lru.get(4)); // returns 4


    }

}



