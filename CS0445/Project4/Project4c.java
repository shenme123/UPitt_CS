import java.io.*;
import java.util.*;


public class Project4c
{
	public static void main(String[] args) throws Exception
	{
		long t1 = System.currentTimeMillis();

		Dictionary dic = new Dictionary();
		Dictionary dicR = new Dictionary();
		Crossword cw  = new Crossword();
		Total t = new Total();
		
		// setting up the dictionary
		String line = null;
		BufferedReader infile = new BufferedReader( new FileReader("dictionary.txt") );
		while ((line = infile.readLine()) != null) 
		{
			if (line.length()>=3)
			{
				dicR.hash.add(line);
				for (int i = 2; i<=line.length(); i++)
				{
					String s = line.substring(0, i);
					dic.hash.add(s);
				}
			}
		}
		infile.close();
		
		// setting up the grid
		File fEn = new File(args[0]);
		FileReader frEn = null;
		frEn = new FileReader(fEn);
		BufferedReader brEn = new BufferedReader((Reader) frEn);
		
		int lineNum = -1;
		while ((line = brEn.readLine()) != null) {
			lineNum++;
			if (lineNum == 0){
				line = line.replace(" ",	"");
				cw.width = Integer.parseInt(line);
				break;
			}	
		}
		cw.character = new String[cw.width][cw.width];	
		
		lineNum--;
		while ((line = brEn.readLine()) != null) {
			lineNum++;
			line = line.replace("  ", " ");
			cw.character[lineNum] = line.split(" ");
		}
		frEn.close();
		brEn.close();
		
		for (int i=0;i<cw.width;i++){
			for (int j=0;j<cw.width;j++){
				cw.character[i][j] += i;
				cw.character[i][j] += j;
			}
		}
		
		// preparing the output file
		File file = new File("output.txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for (int i=0;i<cw.width;i++){
			for (int j=0;j<cw.width;j++){
				clearWords(cw);
				dfs(cw,i,j,dic,dicR,t,bw);	
			}
		}
		
		bw.close();
		fw.close();

		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
	}
	
	public static boolean dfs(Crossword cw, int i, int j, Dictionary dic, Dictionary dicR, Total t, BufferedWriter bw) throws Exception{
		boolean flag = false;
		
		for (int change_i = -1;change_i<2;change_i++){
			// check index
			if ((i+change_i < 0) || (i+change_i > cw.width-1)){
				flag = false;
				continue;
			}
			for (int change_j = -1;change_j<2;change_j++){
				// check index
				if ((j+change_j < 0) || (j+change_j > cw.width-1)){
					flag = false;
					continue;
				}
				// prevent not moving
				if (change_i == 0 && change_j == 0){
					continue;
				}
				// prevent cycle
				if (cw.words[i][j].contains(cw.character[i+change_i][j+change_j])){
					flag = false;
					continue;
				}
				// check in lexicon
				// only in lexicon that we continue to search
				String tmp = cw.words[i][j] + cw.character[i+change_i][j+change_j];
				String tmpNoNum = tmp.replaceAll("[0-9]+", "");
				if ( tmp.length()<3 || dic.lookup(tmpNoNum) ){
					cw.words[i+change_i][j+change_j] = tmp;
					if (tmpNoNum.length()>2 && dicR.hash.contains(tmpNoNum) ){
						if ( !t.finds.contains(tmpNoNum) ){
							t.finds.add(tmpNoNum);
							System.out.println(tmpNoNum);
							bw.write(tmpNoNum);
							bw.newLine();
						}
					}
					flag = true;
					dfs(cw, i+change_i, j+change_j, dic, dicR, t, bw);
				}
			}
		}
		
		return flag;
	}
	
	public static boolean clearWords(Crossword cw){
		cw.words = new String[cw.width][cw.width];
		for (int i=0;i<cw.width;i++){
			for (int j=0;j<cw.width;j++){
				String c = cw.character[i][j];
				cw.words[i][j] = c;
			}
		}
		return false;
	}

}

class TreeNode{
	public String character;
	public int i;
	public int j;
}

class Crossword{
	public int width;
	public String[][] character;
	public String[][] words;
}

class Total{
	public List<String> finds = new ArrayList<String>();
}

class Dictionary{
	public HashSet<String> hash = new HashSet<String>();
	public boolean lookup (String word){
		if (hash.contains(word))
			return true;
		return false;
	}
}