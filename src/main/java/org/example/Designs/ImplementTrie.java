package org.example.Designs;

public class ImplementTrie {

        public class TrieNode
        {
            TrieNode[] child;
            public TrieNode()
            {
                //this.val = v;
                child = new TrieNode[26];
            }
            boolean end = false;
        }

        static TrieNode root;
        public ImplementTrie() {
            root = new TrieNode();
        }

        static public void main(String[] args) {
            ImplementTrie trie = new ImplementTrie();
            trie.insert("apple");
            boolean ans1 = trie.search("apple");   // returns true
            boolean ans2 = trie.search("app");     // returns false
            boolean ans3 = trie.startsWith("app"); // returns true
            trie.insert("app");
            boolean ans4 = trie.search("app");     // returns true

            System.out.println(ans1);
            System.out.println(ans2);
            System.out.println(ans3);
            System.out.println(ans4);
        }

         public void insert(String word) {

            TrieNode node = root;
            for(char ch: word.toCharArray())
            {

                if(node.child[ch-'a']==null)
                {
                    node.child[ch-'a'] = new TrieNode();
                }
                node = node.child[ch-'a'];
            }
            node.end = true;
        }

         public boolean search(String word) {

            TrieNode node = root;
            for(char ch: word.toCharArray())
            {

                if(node.child[ch-'a'] == null )
                    return false;
                node = node.child[ch-'a'];
            }
            return node.end;

        }

         public boolean startsWith(String prefix) {

            TrieNode node = root;
            for(char ch: prefix.toCharArray())
            {
                if(node.child[ch-'a'] == null )
                    return false;
                node = node.child[ch-'a'];
            }
            return true;
        }
    }


