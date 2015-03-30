import java.util.*;

public class Lab6
{
    public static void main(String[] args)
    {
        HashMap<String, Integer> histogram = new HashMap<String, Integer>();

        // Initialize frequency table from command line - YOU MODIFY TO READ FROM A FILE
        for (String w : args)
        {
            Integer freq = histogram.get(w);
            histogram.put(w, (freq == null) ? 1 : freq + 1);
        }

        System.out.println(histogram); // 	CHANGE THIS TO EXTRACT THE WORDS INTO AN ARRAY AND SORT THEN PRINT THEM
    }
}