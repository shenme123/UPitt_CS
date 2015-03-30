/**
 * Sanqiang Zhao Www.131X.Com Mar 12, 2013
 */
package jiangwentao;

public class sbtest {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("anbc");
        System.out.println(sb.toString());
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
