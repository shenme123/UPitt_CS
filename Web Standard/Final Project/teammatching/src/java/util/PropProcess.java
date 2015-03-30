package util;


import java.util.*;

public class PropProcess {
    ArrayList<ArrayList> tagInfo;
    ArrayList<ArrayList> p_tagInfo;
    HashMap<String, Integer> p_tag2freq;
    public PropProcess(ArrayList propInfo, ArrayList<ArrayList> tagInfo, int propNum) throws Exception{
        int pid = Integer.parseInt(propInfo.get(0).toString());
        String s = propInfo.get(1).toString();
        this.tagInfo = tagInfo;
        this.p_tag2freq = readProp(s);
        HashMap<String, ArrayList> tagMap = genTagMap(tagInfo);
        
        // remove non-tag words in p_tag2freq, and update tagInfo
        ArrayList<String> pTag = new ArrayList<>();
        for (String word: p_tag2freq.keySet()){
            if ( tagMap.containsKey(word) ){
                int df = Integer.parseInt( tagMap.get(word).get(2).toString() )+1;
                int tf = Integer.parseInt( tagMap.get(word).get(3).toString() )+ p_tag2freq.get(word);
 //               double w = Math.log10((double)propNum/(double)df);
                tagMap.get(word).set(2, df);
                tagMap.get(word).set(3, tf);     
 //               tagMap.get(word).set(4, w);
                pTag.add(word);
            }
        }
        
        for (String tag: tagMap.keySet()){
            int df = Integer.parseInt( tagMap.get(tag).get(2).toString() );
            double w = Math.log10((double)propNum/(double)df);
            tagMap.get(tag).set(4, w);
        }
        //turn p_tag2freq to an ArrayList[]   
        //format:  (pid, tid, freq)
        
        p_tagInfo = new ArrayList<>();
        for (String tag: pTag){
            ArrayList tagEntry = new ArrayList();
            tagEntry.add(pid);
            tagEntry.add(Integer.parseInt(tagMap.get(tag).get(0).toString() ));
            tagEntry.add( p_tag2freq.get(tag) );
            p_tagInfo.add(tagEntry);
        }
    }

    static HashMap<String, ArrayList> genTagMap(ArrayList<ArrayList> tagInfo ){
        HashMap<String, ArrayList> tagMap = new HashMap<>();
        for (ArrayList al: tagInfo) {
            tagMap.put(al.get(1).toString(), al);
        }
        return tagMap;
    }


    
    //format: (tid, tagName, df, tf, weight)
    public ArrayList<ArrayList> getTagInfo(){
        return this.tagInfo;
    }
    
    //format:  (pid, tid, freq);
    public ArrayList<ArrayList> getP_tagInfo(){
        return this.p_tagInfo;
    }
    
    // read in proposal and parse it to a hashmap with words as keys and freq as values
    static HashMap<String, Integer> readProp(String prop) throws Exception {
        HashMap<String, Integer> word2freq = new HashMap<>();
        int wordNo = 0;
        prop = prop.toLowerCase();
        for (int i = 0; i < prop.length(); i++) {
            if ((Character.isDigit(prop.charAt(i)) || Character.isLetter(prop.charAt(i)))) {
                int j = i + 1;
                boolean flag = true;
                while (flag) {

                    if (j == prop.length() || !(Character.isDigit(prop.charAt(j)) || Character.isLetter(prop.charAt(j)))) {
                        flag = false;
                        String s = prop.substring(i, j);
//								System.out.println(s);
                        if (word2freq.containsKey(s)) {
                            word2freq.put(s, word2freq.get(s) + 1);
                        } else {
                            word2freq.put(s, 1);
                        }
                        wordNo++;
                        i = j;
                    } else {
                        j++;
                    }
                }
            }
        }
        return word2freq;
    }
}
