import java.util.*;

public class CircularSuffixArray {
	private CSuffix[] arr;
	private int first = 0;
	private int length = 0;
	private int[] next;
	private char[] code;

    // circular suffix array of s   - 10 points
    public CircularSuffixArray(String s) {
		this.length = s.length();
		this.arr = new CSuffix[length];
		this.code = new char[length];
		for (int i = 0; i < length; i++){
			arr[i] = new CSuffix(s, i);
		}
		Arrays.sort(arr);
		for (int i=0; i<length; i++){
			if ( index(i) == 0){
				first = i;
				break;
			}
		}
    }
	
	private static class CSuffix implements Comparable<CSuffix> {
		private final String s;
		private final int index;

		private CSuffix(String s, int index){
			this.s = s;
			this.index = index;
		}

		private char charAt(int i) {
			return s.charAt((index + i)%s.length());
		}

		public int compareTo(CSuffix that) {
			if (this == that) return 0;
			for (int i=0; i<s.length(); i++){
				if(this.charAt(i) < that.charAt(i)) return -1;
				if(this.charAt(i) > that.charAt(i)) return 1;
			}
			return 0;
		}
	}
	
	// index of orig string
	public int first() {
		return this.first;
	}

	public char[] code(){
		for (int i=0; i<length; i++){
			code[i] = arr[i].charAt(length-1);
		}
		return code;
	}

    // length of s
    public int length() {
        return arr.length;
    }

    // returns index of ith sorted suffix - 10 points
    public int index(int i) {
		return arr[i].index;
    }
}
