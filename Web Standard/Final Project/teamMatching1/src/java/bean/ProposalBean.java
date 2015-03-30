/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.*;

/**
 *
 * @author xmrui_000
 */
public class ProposalBean {

    private List list;
    private ResultSet rs;

// get keyword freq from one proposal;
    public int getProjNumber() {
        DBO dbo = new DBO();
        dbo.open();
        try {
            String sql = "select count(pid) from PROJECTINFO";
            rs = dbo.executeQuery(sql);
            rs.next();
            String projNum = rs.getString(1);
            int Num = Integer.parseInt(projNum);

            return Num;
        } catch (Exception e) {
            e.printStackTrace();
            return Constant.SYSTEM_ERROR;
        } finally {
            dbo.close();
        }
    }

    public List getPropInfo(int pid) {
        String sql = "select pid,proposal from PROJECTINFO where pid=" + pid + " ";
        DBO dbo = new DBO();
        list = new ArrayList();
        dbo.open();
        try {

            rs = dbo.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            dbo.close();
        }
    }

    public List getTagInfo() {
        String sql = "select * from tehctaginfo ";
        DBO dbo = new DBO();
        list = new ArrayList();
        dbo.open();
        try {

            rs = dbo.executeQuery(sql);
            while (rs.next()) {
                List list2 = new ArrayList();
                list2.add(rs.getString(1));
                list2.add(rs.getString(2));
                list2.add(rs.getString(3));
                list2.add(rs.getString(4));
                list2.add(rs.getString(5));

                list.add(list2);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            dbo.close();
        }
    }

    public List getPropFreq(int pid) {
        ArrayList propInfo = (ArrayList) this.getPropInfo(pid);
        ArrayList<ArrayList> tagInfo = (ArrayList<ArrayList>) this.getTagInfo();
        int propNum = this.getProjNumber();

        try {
            PropProcess propProcess = new PropProcess(propInfo, tagInfo, propNum);
            List list = new ArrayList();
            list = propProcess.getP_tagInfo();
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {

        }
    }

    public int getPropFreqUpdate(int pid) {
        DBO dbo = new DBO();
        dbo.open();
        List list = new ArrayList();
        list = this.getPropFreq(pid);

        try {
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    ArrayList list2 = (ArrayList) list.get(i);

                    String id = list2.get(0).toString();
                    String t_id = list2.get(1).toString();
                    String f_req = list2.get(2).toString();

                    int p_id = Integer.parseInt(id);
                    int tid = Integer.parseInt(t_id);
                    int freq = Integer.parseInt(f_req);
                    String sql = "insert into KEYWORDINFO (pid,tid,freq) values (" + p_id + "," + tid + "," + freq + ") ";
                    int j = dbo.executeUpdate(sql);

                }
            }
            return Constant.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return Constant.SYSTEM_ERROR;
        } finally {
            dbo.close();
        }
    }

//tagInfo refresh
    public List preTagInfoUpdate(int pid) {
        ArrayList propInfo = (ArrayList) this.getPropInfo(pid);
        ArrayList<ArrayList> tagInfo = (ArrayList<ArrayList>) this.getTagInfo();
        int propNum = this.getProjNumber();

        try {
            PropProcess propProcess = new PropProcess(propInfo, tagInfo, propNum);
            List list = new ArrayList();
            list = propProcess.getTagInfo();
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {

        }
    }

    public int getTagInfoUpdate(int pid) {
        DBO dbo = new DBO();
        dbo.open();
        List list = new ArrayList();
        list = this.preTagInfoUpdate(pid);

        try {
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    ArrayList list2 = (ArrayList) list.get(i);
                    String id = list2.get(0).toString();
                    String d_freq = list2.get(2).toString();
                    String t_freq = list2.get(3).toString();
                    String w = list2.get(4).toString();

                    int t_id = Integer.parseInt(id);
                    int docfreq = Integer.parseInt(d_freq);
                    int tfreq = Integer.parseInt(t_freq);
                    double weight = Double.parseDouble(w);

                    String sql = "update TEHCTAGINFO set DOCFREQ=" + docfreq + ",TFREQ=" + tfreq + ",WEIGHT=" + weight + " where tid=" + t_id + " ";
                    int j = dbo.executeUpdate(sql);

                }
            }
            return Constant.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return Constant.SYSTEM_ERROR;
        } finally {
            dbo.close();
        }
    }

    //calcMatching score
    public List getKeywordInfo(int pid) {
        String sql = "select * from keywordinfo where pid=" + pid + "";
        DBO dbo = new DBO();
        list = new ArrayList();
        dbo.open();
        try {

            rs = dbo.executeQuery(sql);
            while (rs.next()) {
                List list2 = new ArrayList();
                list2.add(rs.getString(1));
                list2.add(rs.getString(2));
                list2.add(rs.getString(3));
                list2.add(rs.getString(4));
                list.add(list2);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            dbo.close();
        }

    }

    public int[] getUserTags(int uid) {
        String sql = "select TAG_1,TAG_2,TAG_3 from USERINFO where uid=" + uid + "";
        DBO dbo = new DBO();
        dbo.open();
        int[] tag = new int[3];
        String t;
        int i, j;
        try {
            rs = dbo.executeQuery(sql);
            rs.next();
            for (i = 0, j = 1; i < 3; i++, j++) {
                t = rs.getString(j);
                tag[i] = Integer.parseInt(t);
            }

            return tag;
        } catch (Exception e) {
            return null;
        } finally {
            dbo.close();
        }
    }

    public int getRecmdInfo(int uid) {

        int[] tags = this.getUserTags(uid);
        ArrayList<ArrayList> tagInfo = (ArrayList<ArrayList>) this.getTagInfo();
        DBO dbo = new DBO();
        List list = new ArrayList();
        dbo.open();

        String sql = "Select distinct pid from KEYWORDINFO ";
        String sql1 = "select uid from RECMDINFO where uid=" + uid + "";
        try {
            rs = dbo.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getString(1));
            }

            for (int index = 0; index < list.size(); index++) {
                String id = list.get(index).toString();
                int pid = Integer.parseInt(id);

                ArrayList<ArrayList> p_tag2freq = (ArrayList<ArrayList>) this.getKeywordInfo(pid);

                CalcMatchingIndex calcMatchingIndex = new CalcMatchingIndex(tags, tagInfo, p_tag2freq);
                ArrayList list2 = (ArrayList) calcMatchingIndex.getProp2Score();

                if (list2 != null) {

                    String score = list2.get(1).toString();
                    double grade = Double.parseDouble(score);

                    String sql2 = "update RECMDINFO set pid=" + pid + ",grade=" + grade + " where uid=" + uid + "";
                    String sql3 = "insert into RECMDINFO (uid,pid,grade) values (" + uid + "," + pid + "," + grade + ")";
                    
                    rs = dbo.executeQuery(sql1);

                    if (rs.next()) {
                        dbo.executeUpdate(sql2);

                    } else {
                        dbo.executeUpdate(sql3);
                    }

                }
            }
            return Constant.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return Constant.SYSTEM_ERROR;
        } finally {
            dbo.close();
        }
    }

}
