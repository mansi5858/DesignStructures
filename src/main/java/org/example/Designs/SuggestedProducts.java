package org.example.Designs;

import java.util.ArrayList;
import java.util.List;

class TrieNode
{
    List<String> str = new ArrayList<>();
    boolean isEnd;
    String word;
    TrieNode[] child = new TrieNode[26];
}

public class SuggestedProducts {

    public static void main(String[] args)
    {
        String[] str = {"mobile","mouse","moneypot","monitor","mousepad"};
        String word = "mouse";

        List<List<String>> answer = suggestedProducts(str, word);

        System.out.println(answer);

    }
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> answer = new ArrayList<>();

        if(searchWord.isEmpty() || products.length == 0)
            return new ArrayList<>();

        TrieNode root = new TrieNode();
            //insert products in Trie

        for(String word: products)
        {
            createTrie(root, word);
        }

        TrieNode node = root;

        StringBuilder str = new StringBuilder();
        int i=0;
        for(; i<searchWord.length(); i++)
        {
            char ch = searchWord.charAt(i);
            if(node.child[ch-'a'] == null)
            {
                break;
            }
            node = node.child[ch-'a'];
            List<String> lst = new ArrayList<>();
            if(node.isEnd == true)
            {
                lst.add(node.word);
            }
            boolean isAdded = false;
            for(int j=0; j<26; j++)
            {
                if(isAdded == true)
                    break;
                if(node.child[j] != null)
                {
                    dfs(node, lst, j);
                    if(isAdded == false && lst.size() >= 3)
                    {
                        lst = lst.subList(0,3);
                            //for(int k =0; k<3; k++)
                            //    answer.add(lst.get(k));
                        answer.add(lst);
                        isAdded = true;
                            continue;
                    }
                }
            }
            if(isAdded == false && lst.size() >= 3)
            {
                lst = lst.subList(0,3);
                answer.add(lst);

            }
            else if(isAdded == false)
                answer.add(lst);



        }
        while(i<searchWord.length())
        {
            answer.add(new ArrayList<>());
            i++;
        }

        return answer;

    }

    static void createTrie(TrieNode root, String word)
    {
        TrieNode node = root;

        for(char ch: word.toCharArray())
        {
            int key = ch-'a';
            if(node.child[key] == null)
                node.child[key] = new TrieNode();

            node = node.child[key];
            node.str.add(word);
        }

        node.isEnd = true;
        node.word = word;

    }

    static void dfs(TrieNode Nnode, List<String> lst, int j) {
        TrieNode node = Nnode;

        if (node.child[j] == null)
            return;
        if (lst.size() >= 3) {
            return;
        }

        node = node.child[j];
        if (node.isEnd) {
            lst.add(node.word);
        }
        for (int i = 0; i < 26; i++) {
            if (node.child[i] != null)
                dfs(node, lst, i);
        }
    }

}
