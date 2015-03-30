import java.util.*;
public class BurrowsWheeler {
    // apply Burrows-Wheeler encoding, reading from standard input and writing to standard output
	

    public static void encode() {
		String s = BinaryStdIn.readString();
		CircularSuffixArray csa = new CircularSuffixArray(s);
		BinaryStdOut.write(csa.first());
		for (char ch: csa.code()){
			BinaryStdOut.write(ch);
		}
		BinaryStdOut.close();
    }

    // apply Burrows-Wheeler decoding, reading from standard input and writing to standard output
    public static void decode() {
		int first = BinaryStdIn.readInt();
		String s = BinaryStdIn.readString();
		char[] code = s.toCharArray();
		char[] sorted = s.toCharArray();

		int length = code.length;
		Queue<Integer>[] map = new LinkedList<Integer>()[256];
		for (int i=0; i<length; i++){
				map[(int)code[i]].add(i);
		}
		int[] next = new int[length];
		int ind = 0;
		for (int i=0; i<256; i++){
			while (!map[i].isEmpty())
			{
				next[j] = map[i].poll();
			}
		}
		

		for (int i=0; i<length; i++){
			BinaryStdOut.write(sorted[first]);
			first = next[first];
		}
		BinaryStdOut.close();
    }

    // if args[0] is '-', apply Burrows-Wheeler encoding   - 5 points
    // if args[0] is '+', apply Burrows-Wheeler decoding   - 5 points
    public static void main(String[] args) {
		if (args[0].equals("-")) encode();
		else if (args[0].equals("+")) decode();
		else throw new IllegalArgumentException("Illegal command line argument");
    }
}
