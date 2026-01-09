package org.example.Designs;

import java.util.*;

public class CloneGraph {

    public static void main(String[] args)
    {
       CloneGraph cl = new CloneGraph();

       Node node1 = cl.createGraph();
        Node clonedGraph = cl.cloneGraph(node1);

        System.out.println("Cloned graph node value: " + clonedGraph.val);
        System.out.println("Cloned graph neighbors: ");
        for(Node neighbor : clonedGraph.neighbors)
        {
            System.out.println("Neighbor value: " + neighbor.val);
        }
    }

    public Node createGraph()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        return node1;
    }

    public class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

     public Node cloneGraph(Node headNode) {
            if(headNode == null)
                return null;
            Map<Node, Node> map = new HashMap<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(headNode);
            map.put(headNode, new Node(headNode.val));

            while(!queue.isEmpty())
            {
                Node node = queue.poll();
                //System.out.println(node.val);
                for(Node child : node.neighbors)
                {
                    if(!map.containsKey(child))
                    {
                        map.put(child, new Node(child.val));
                        queue.offer(child);
                    }
                    map.get(node).neighbors.add(map.get(child));

                }
            }

            return map.get(headNode);
        }
    }
