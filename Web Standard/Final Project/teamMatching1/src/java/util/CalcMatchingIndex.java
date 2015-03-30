
package util;

import java.util.*;

public class CalcMatchingIndex {
    ArrayList prop2score;
    public CalcMatchingIndex(int [] tids, ArrayList<ArrayList> tagInfo, ArrayList<ArrayList> p_tagInfo) throws Exception{
        HashMap<Integer, ArrayList> tagMap = genTagMap(tagInfo);
        double score = 0;
        for (int i=0; i<3; i++){
            for (ArrayList pTag: p_tagInfo){
                if (Integer.parseInt(pTag.get(2).toString())==(tids[i])){
                    double f = Double.parseDouble( pTag.get(3).toString() );
                    double w = Double.parseDouble( tagMap.get(tids[i]).get(4).toString() );
                    score = score + (5-2*(double)i)*f*w;
                }
            }
        }
        prop2score = new ArrayList();
        prop2score.add(Integer.parseInt( p_tagInfo.get(0).get(1).toString() ));
        prop2score.add(score);
    }
    
    public ArrayList getProp2Score(){
        return this.prop2score;
    }
    
    static HashMap<Integer, ArrayList> genTagMap(ArrayList<ArrayList> tagInfo ){
        HashMap<Integer, ArrayList> tagMap = new HashMap<>();
        for (ArrayList al: tagInfo) {
            tagMap.put(Integer.parseInt(al.get(0).toString()), al);
        }
        return tagMap;
    }
}
