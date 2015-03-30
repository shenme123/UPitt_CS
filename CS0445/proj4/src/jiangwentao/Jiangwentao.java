/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jiangwentao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import Trie.Trie;
import Trie.TrieResult;

/**
 *
 * @author Sanqiang
 */
public class Jiangwentao {

    private static Trie tree = new Trie();
    private static String[][] bog = null;

    public static void main(String[] args) throws FileNotFoundException, IOException {
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

        //test
        for (int col = 0; col < bog.length; col++) {
            for (int row = 0; row < bog[0].length; row++) {
                System.out.print(bog[col][row] + " ");
            }
            System.out.println();
        }


        //recursive
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < bog.length; col++) {
            for (int row = 0; row < bog[0].length; row++) {
                recursive("", col, row);
            }
        }

        long t2 = System.currentTimeMillis();
        System.out.println("Time:" + (t2 - t1));
    }

    private static void recursive(String str, int col, int row) {
        str += bog[col][row];

        if (str.length() >= 0) {
            TrieResult reuslt = tree.search(str.toString());
            switch (reuslt) {
                case FindWithEnd:
                    System.out.println(str.toString());
                    break;
                case FindWithoutEnd:
                    System.out.println(str.toString());
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
            recursive(str, col - 1, row);
        }

        if (col + 1 < bog.length) {
            recursive(str, col + 1, row);
        }
        if (row - 1 >= 0) {
            recursive(str, col, row - 1);
        }
        if (row + 1 < bog[0].length) {
            recursive(str, col, row + 1);
        }

    }
}
