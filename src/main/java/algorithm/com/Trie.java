package com;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    class TrieNode{
        TrieNode[] nodes = new TrieNode[26];//
        char c;
        boolean isLeaf;//这个节点是否是叶子节点
        int count;//以当前节点为结尾的单词数
        int frequency;//以当前节点为结尾的单词出现的频次
        public TrieNode(char c) {
            this.c = c;
            isLeaf = false;
        }
    }

    TrieNode root;
    public Trie(){
        this.root = new TrieNode(' ');
    }

    //word 插入到一棵树中
    public void insert(String word){
        TrieNode cur = root;
        if(word == null) return;
        char[] cs = word.toLowerCase().toCharArray();
        for (int i=0; i< cs.length; i++) {
            int index = cs[i]-'a';
            if (cur.nodes[index] == null) {
                //树中还没这个节点
                cur.nodes[index] = new TrieNode(cs[i]);
            }
            cur = cur.nodes[index]; //指向新插入的节点
            cur.count++; //以当前前缀字符为结尾的单词数量 abc,abcd,abcde 都是以abc为前缀
        }
        cur.isLeaf = true;
        cur.frequency++; //该单词在树中出现的次数。abc,abcd 分别出现的次数
    }

    //word是否存在这棵树中
    public boolean search(String word){
        TrieNode cur = root;
        char[] cs = word.toLowerCase().toCharArray();
        for (int i=0; i< cs.length; i++) {
            int index = cs[i]-'a';
            if (cur.nodes[index] == null) {
                return false;
            }
            cur = cur.nodes[index];
        }
        return cur.isLeaf;
    }

    public HashMap<String,Integer> getWordsFromPrefix(String prefix) {
        return getWordsFromPrefix(root, prefix);
    }

    public HashMap<String,Integer> getWordsFromPrefix(TrieNode root, String prefix) {
        HashMap<String, Integer> hashMap = new HashMap<String,Integer>();
        char[] data = prefix.toLowerCase().toCharArray();
        for(int i=0;i<data.length;i++) {
            if(root.nodes[data[i]-'a'] == null) {
                return hashMap;
            }
            root = root.nodes[data[i]-'a'];
        }
        System.out.println("-->" + root.c);
        return helper(root,prefix);
    }

    public HashMap<String, Integer> helper(TrieNode cur, String s){
        HashMap<String, Integer> hashMap = new HashMap<String,Integer>();
        if(cur != null) {
            if(cur.isLeaf) {
                hashMap.put(s,cur.frequency);
            }
        }
        for (int i = 0; i < cur.nodes.length; i++) {
            if(cur.nodes[i]!=null) {
                String tmp = s + (char)(i + 'a');
                System.out.println("--> tmp: " + tmp);
                hashMap.putAll(helper(cur.nodes[i], tmp));
            }
        }
        return hashMap;
    }

    public HashMap<String, Integer> getAllWords() {
        return helper(root, "");
    }

    public void print(Map<String,Integer> map){
        if (map != null) {
            for(Map.Entry<String,Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }


    public static void main(String args[]) {
        Trie t = new Trie();
        t.insert("abc");
        t.insert("abd");
        t.insert("abcd");
        System.out.println(t.search("abc"));
//        t.print(t.getAllWords());
        t.print(t.getWordsFromPrefix("ab"));
    }
}

