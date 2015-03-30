/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

/**
 *
 * @author Administrator
 * this is use bean to count the click number of the index page
 */
public class ClickNumBean {
    private int VisitNum;

    /**
     * Get the value of VisitNum
     *
     * @return the value of VisitNum with everytime add one
     */
    public int getVisitNum() {
        return ++VisitNum;
    }

    /**
     * Set the value of VisitNum
     *
     * @param VisitNum new value of VisitNum
     */
    public void setVisitNum(int VisitNum) {
        this.VisitNum = VisitNum;
    }
}
