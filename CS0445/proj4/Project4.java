
import java.io.*;
import java.util.*;

public class Project4 {

    private static Trie tree = new Trie();
    private static String[][] bog = null;
    private static HashSet<String> dup = new HashSet<String>();

    public static void main(String[] args) throws Exception {
        long t1 = System.currentTimeMillis();
        //pre-processing dic
        BufferedReader infile = new BufferedReader(new FileReader("dictionary.txt"));
        while (infile.ready()) {
            tree.add(infile.readLine());
        }
        infile.close();

        //process the matrix
        infile = new BufferedReader(new FileReader("4x4-input.txt"));
        int n = Integer.parseInt(infile.readLine());
        int r = 0;
        bog = new String[n][];
        while (infile.ready()) {
            String line = infile.readLine();
            line = line.replace("  ", " ");
            bog[r] = line.split(" ");
            r++;
        }
        infile.close();
		
		String s="abcde";
		System.out.println(  s.substring(1,4)  );
//	    long t2 = System.currentTimeMillis();
//      System.out.println("Time:" + (t2 - t1));

        //recursive
        boolean[][] cache = new boolean[bog.length][bog[0].length];
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < bog.length; col++) {
            for (int row = 0; row < bog[0].length; row++) {
                cache = new boolean[bog.length][bog[0].length];
                recursive("", col, row, cache);
            }
        }
        
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }

    private static void recursive(String str, int col, int row, boolean[][] cache) {
        str += bog[col][row];

        if (cache[col][row]) {
            return;
        }

        if (str.length() >= 3) {
            TrieResult reuslt = tree.search(str.toString());
            switch (reuslt) {
                case FindWithEnd:
                    if (!dup.contains(str.toString())) {
                        dup.add(str.toString());
                        System.out.println(str.toString());
                    }
                    break;
                case FindWithoutEnd:
                    if (!dup.contains(str.toString())) {
                        dup.add(str.toString());
                        System.out.println(str.toString());
                    }
                    return;
                //break;
                case NotFindWithEnd:
                    //do nothing
                    break;
                case NotFindWithoutEnd:
                    return;
                //break;
            }
        }
        if (col - 1 >= 0) {
            cache[col][row] = true;
            recursive(str, col - 1, row, cache);
            cache[col][row] = false;
        }

        if (col + 1 < bog.length) {
            cache[col][row] = true;
            recursive(str, col + 1, row, cache);
            cache[col][row] = false;
        }
        if (row - 1 >= 0) {
            cache[col][row] = true;
            recursive(str, col, row - 1, cache);
            cache[col][row] = false;
        }
        if (row + 1 < bog[0].length) {
            cache[col][row] = true;
            recursive(str, col, row + 1, cache);
            cache[col][row] = false;
        }

        if (col - 1 >= 0 && row - 1 >= 0) {
            cache[col][row] = true;
            recursive(str, col - 1, row - 1, cache);
            cache[col][row] = false;
        }

        if (col + 1 < bog.length && row + 1 < bog[0].length) {
            cache[col][row] = true;
            recursive(str, col + 1, row + 1, cache);
            cache[col][row] = false;
        }

        if (col - 1 >= 0 && row + 1 < bog[0].length) {
            cache[col][row] = true;
            recursive(str, col - 1, row + 1, cache);
            cache[col][row] = false;
        }

        if (col + 1 < bog.length && row - 1 >= 0) {
            cache[col][row] = true;
            recursive(str, col + 1, row - 1, cache);
            cache[col][row] = false;
        }


    }
}

class TrieNode {

    public char _ch;
    public TrieNode[] _next_nodes = new TrieNode[26];
    public boolean _end_word = false;
    public int _next_count = 0;

    public TrieNode(char ch) {
        this._ch = ch;
    }
}

class Trie {

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
            } else {
                return TrieResult.FindWithEnd;
            }
        } else {
            return TrieResult.NotFindWithEnd;
        }
    }
}

enum TrieResult {

    FindWithEnd,
    NotFindWithEnd,
    FindWithoutEnd,
    NotFindWithoutEnd
}