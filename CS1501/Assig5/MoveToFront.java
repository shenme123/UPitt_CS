
public class MoveToFront {
    static char[] list = new char[256];
    // apply move-to-front encoding, reading from standard input and writing to standard output

    public static void encode() {
        String s = BinaryStdIn.readString();
        char[] ch = s.toCharArray();
        for (char c: ch){
            int index = 0;
            for (int ind = 0; ind<256; ind++){
                if (c == list[ind]){
                    index = ind;
                    break;
                }
            }
			BinaryStdOut.write((byte)index) ;
            for ( ; index>0; index--) {
                list[index] = list[index-1];
            }
            list[0] = c;
        }
		BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        String s = BinaryStdIn.readString();
		char[] by = s.toCharArray();
		for (char b: by){
			int index = (int)b;
			char c = list[index];
			BinaryStdOut.write(c);
			for (; index>0; index-- ){
				list[index] = list[index-1];
			}
			list[0] = c;
		}
		BinaryStdOut.close();
    }

    // if args[0] is '-', apply move-to-front encoding - 5 points
    // if args[0] is '+', apply move-to-front decoding - 5 points
    public static void main(String[] args) {
        
        for (int counter = 0; counter<256; counter++){
            list[counter] = (char)counter;
        }
        if (args[0].equals("-")) encode();
        else if (args[0].equals("+")) decode();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}
