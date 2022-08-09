package com.zkp.string;

/**
 * @author zkp
 * @version 1.0
 */
public class FirstNotRepeatingChar {
    public static void main(String[] args){
        String str = "as ds fg";
        //System.out.println(str.indexOf('s'));

        String regex = "[ ]";
        System.out.println(str.replaceAll(regex, "%20"));
    }
    public int findNotRepeatingIndex(String str) {
        if (str.length() == 0) return -1;
        boolean[] flag = new boolean[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int index = str.indexOf(str.charAt(i));
            if (i != index) {
                flag[index] = true;
                flag[i] = true;
            }
        }
        for(int i = 0;i < str.length();i++){
            if(!flag[i])
                return i;
        }
        return -1;
    }
}
