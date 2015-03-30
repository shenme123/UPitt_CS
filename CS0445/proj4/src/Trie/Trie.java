/**
 * Sanqiang Zhao Www.131X.Com Mar 11, 2013
 */
package Trie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Trie {
    
    private TrieNode _root = null;
    
    public Trie() {
        this._root = new TrieNode('$');
    }
    
    public void add(String word) {
        int len = word.length();
        TrieNode looper = _root;
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            if (looper._next_nodes[ch - 'a'] == null) {
                looper._next_nodes[ch - 'a'] = new TrieNode(ch);
            }
            ++looper._next_count;
            looper = looper._next_nodes[ch - 'a'];
        }
        looper._end_word = true;
    }
    
    //0 find it there is something in the end
    //1 find it there is nothing in the end
    //2 not find, there is something in the end
    //3 not find there is nothing in the end
    public TrieResult search(String word) {
        int len = word.length();
        TrieNode looper = _root;
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            if (looper._next_nodes[ch - 'a'] == null) {
                return TrieResult.NotFindWithoutEnd;
            }
            looper = looper._next_nodes[ch - 'a'];
        }
        if (looper._end_word) {
            if (looper._next_count == 0) {
                return TrieResult.FindWithoutEnd;
            }else{
                return TrieResult.FindWithEnd;
            }
        }else{
            return TrieResult.NotFindWithEnd;
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*Trie t = new Trie();
        t.add("abc");
        t.add("abcd");
        System.out.println(t.search("abc"));
        System.out.println(t.search("ab"));
        System.out.println(t.search("abcde"));
        System.out.println(t.search("abcd"));*/
        Trie tree = new Trie();
        BufferedReader infile = new BufferedReader(new FileReader("dictionary.txt"));
        while (infile.ready()) {
            String word = infile.readLine();
            if (word.startsWith("ar") && word.length() <= 3) {
                System.out.println(word);
            }
            tree.add(word);
        }
        infile.close();
        
        System.out.println(tree.search("ark"));
                
    }
}
