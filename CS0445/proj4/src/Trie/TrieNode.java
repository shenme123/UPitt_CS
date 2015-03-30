/**
 * Sanqiang Zhao Www.131X.Com Mar 11, 2013
 */
package Trie;

public class TrieNode {

    public char _ch;
    public TrieNode[] _next_nodes = new TrieNode[26];
    public boolean _end_word = false;
    public int _next_count = 0;

    public TrieNode(char ch) {
        this._ch = ch;
    }

    public static void main(String[] args) {
    }
}
