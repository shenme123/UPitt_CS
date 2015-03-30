import java.lang.*;
import java.util.*;

public class BaseConverter {

    public static void main(String[] args) {
        String num = args[0];
        //
        //System.out.println(Integer.parseInt("a"));
        //
        int base = Integer.parseInt(args[1]);
        if (base==2){
            int dec = c2to10(num);
            String hex = c10to16(dec);
            while (num.length()<16) num = 0+num;
            System.out.println("Dec: "+dec);
            System.out.println("Bin: "+num);
            System.out.println("Hex: "+hex);
        }
        
        if (base == 16){
            int dec = c16to10(num);
            String bin = c10to2(dec);
            System.out.println("Dec: "+dec);
            System.out.println("Bin: "+bin);
            System.out.println("Hex: "+num);
        }
        
        if (base == 10) {
            int dec = Integer.parseInt(num);
            String bin = c10to2(dec);
            String hex = c10to16(dec);
            System.out.println("Dec: "+dec);
            System.out.println("Bin: "+bin);
            System.out.println("Hex: "+hex);
        }
    }
   
    static int c2to10 (String num){
        int dec = 0;
        for (int i=0; i<num.length(); i++){
            if ( num.charAt(num.length()-i-1)==('1') ){
                dec = dec + (int) Math.pow(2,i);
            }
        }
        return dec;
    }
    
    static int c16to10 (String num){
        int dec = 0;
        for (int i = 0; i< num.length(); i++){
            char dig = num.charAt(num.length()-i-1);
            if ( dig == 'a' || dig == 'b' || dig == 'c' || dig == 'd' || dig == 'e' || dig == 'f'){
                dec = dec + (int) Math.pow(16, i) * ( (int)dig - 87 );
            }
            else {
                dec = dec + (int) Math.pow(16, i) * Character.getNumericValue(dig);
            }
        }
        return dec;
    }
    
    static String c10to2(int dec){
        String bin = "";
        while ( dec!=0 ) {
            int res = dec%2;
            dec = dec/2;
            bin = res + bin;
        }
        while (bin.length()<16) bin = 0+bin;
        return bin;
    }
    
    static String c10to16(int dec) {
        String hex = "";
        while (dec!=0){
            int res = dec%16;
            dec = dec/16;
            if ( res>9 ) {
                hex = (char) (res+87) + hex;
            }
            else {
                hex = res + hex;
            }
        }
        while (hex.length()<4) hex = 0+hex;
        return hex;
    }
}
