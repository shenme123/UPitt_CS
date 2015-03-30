/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projmatching;
import java.util.*;
/**
 *
 * @author shenme
 */
public class ProjMatching {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        int[] tids = {1, 2, 3};
        
        ArrayList[] tagInfo = new ArrayList[3];
        ArrayList tag0 = new ArrayList();
        tag0.add(1);
        tag0.add("php");
        tag0.add(1);
        tag0.add(1);
        tag0.add(1);
        tagInfo[0]=tag0;
        
        ArrayList tag1 = new ArrayList();
        tag1.add(2);
        tag1.add("java");
        tag1.add(2);
        tag1.add(2);
        tag1.add(2);
        tagInfo[1]=tag1;
        
        ArrayList tag2 = new ArrayList();
        tag2.add(3);
        tag2.add("hello");
        tag2.add(3);
        tag2.add(3);
        tag2.add(3);
        tagInfo[2]=tag2;
        
        ArrayList[] p_tagInfo = new ArrayList[1];
        ArrayList p = new ArrayList();
        p.add(5);
        p.add(2);
        p.add(3);
        p_tagInfo[0] = p;
        
        CalcMatchingIndex cmi = new CalcMatchingIndex(tids, tagInfo, p_tagInfo);
        double score = cmi.getScore();
        System.out.println(score);
        List<ArrayList> list2 = new ArrayList<ArrayList>();
    }
    
}
