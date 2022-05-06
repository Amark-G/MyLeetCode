package com.zkp.tree;

/**题208
 * 字典树
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
public class Trie {
    private boolean isEnd;
    private Trie[] children;
    public Trie() {
        children = new Trie[26];
        isEnd = false;//根节点为空,不可能是单词结尾
    }
    public void insert(String word) {
        int len = word.length();
        Trie node = this;
        for (int i = 0; i < len; i++) {
            int index = word.charAt(i)-'a';
            if(node.children[index]==null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        //node节点已经为该单词末尾节点
        node.isEnd = true;//表示该节点是一个单词的结尾
    }

    //如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
    public boolean search(String word) {
        Trie trie = preSearch(word);
        return trie!=null && trie.isEnd;
    }

    //如果之前已经插入的字符串word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
    public boolean startsWith(String prefix) {
        return preSearch(prefix)!=null;
    }

    //寻找字符串str再字典树中的结尾节点,如果不存在则返回空
    public Trie preSearch(String str){
        Trie node = this;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if(node.children[str.charAt(i)-'a']==null){
                return null;
            }else{
                node = node.children[str.charAt(i)-'a'];
            }
        }
        return node;
    }

}
