package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    /** Initialize your data structure here. */
    private TrieNode root;
    public Trie() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null) return;
        TrieNode ws = root;
        char[] ds = word.toCharArray();
        for (int i=0;i<ds.length;i++) {
            int index = ds[i]-'a';
            if(ws.child[index] == null) {
                ws.child[index] = new TrieNode(ds[i]);
            }
            //创建好了ws 下的这个节点，那么将ws指向当前创建好的节点
            ws = ws.child[ds[i]-'a'];
            /**
             * 插入ab
             * 比如当前先从root开始，创建root->a,然后ws指向a, 然后创建b，ws指向b，这个动作本可以省略掉，但是如果不带，后续的确认这个字符串已经到了
             * 末尾 并且这个字符串存在树中
             */
        }
        ws.isWorld = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null) return false;
        TrieNode ws = root;
        char ds[] = word.toCharArray();
        for (int i=0;i<ds.length;i++) {
            if (ws.child[ds[i]-'a'] == null) {
                return false;
            }
            ws = ws.child[ds[i]-'a'];
        }
        return ws.isWorld;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        TrieNode ws = root;
        char []ds = prefix.toCharArray();
        for (char c : ds) {
            if (ws.child[c-'a'] == null) {
                return false;
            }
            ws = ws.child[c-'a'];
        }
        return true;
    }

    //找出以 prefix 为 前缀的字符串
    public List<String> foundStrWithPrefix(String prefix) {
        List<String> list = new ArrayList<String>();
        return list;
    }

    //获取树中所有的字符串
    public List<String> getAllWordsInTrie() {
        return helper(root);
    }

    //拿到这个node开始往下的所有字符串
    String s = "";
    public List<String> helper(TrieNode node) {
        //每次递归进来 都是生成一个新的list，
        List<String> list = new ArrayList<String>();
        if (node.isWorld) {
            list.add(s);
        }
        for (int i=0;i<node.child.length;i++) {
            TrieNode curNode = node.child[i];
            if (curNode != null) {
                s += (char)(i + 'a');
                System.out.println("ok:" + s);
                List<String> l = helper(curNode);
                System.out.println("55:" + l);
                list.addAll(l);
            }
        }
        System.out.println("44:" +list);
        return list;
    }

    public void printList(List<String> list) {
         for (String s: list) {
             System.out.print(s + ",");
         }
    }

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        char c;
        boolean isWorld;
        TrieNode(char c) {
            this.c = c;
            this.isWorld = false;
        }
    }

    public static void main(String args[]) {
        String s[] = {"ab","abc","abcd"};
        Trie trie = new Trie();
        for (String str : s) {
          trie.insert(str);
        }
        trie.printList(trie.getAllWordsInTrie());
//        trie.printList(trie.foundStrWithPrefix("ab"));
    }
}
