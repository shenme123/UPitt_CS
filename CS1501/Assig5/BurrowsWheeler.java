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
		Arrays.sort(sorted);

		int length = code.length;
		HashMap<Character, Queue<Integer>> map = new HashMap<Character, Queue<Integer>>();
		for (int i=0; i<length; i++){
			if (map.containsKey(code[i])) {
				map.get(code[i]).add(i);
			}
			else {
				Queue<Integer> qu = new LinkedList<Integer>();
				qu.add(i);
				map.put(code[i], qu);
			}
		}
		int[] next = new int[length];
		for (int i=0; i<length; i++){
			next[i] = map.get(sorted[i]).poll();
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