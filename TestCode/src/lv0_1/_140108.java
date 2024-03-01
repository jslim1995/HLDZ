package lv0_1;

import java.util.Arrays;
import java.util.Iterator;

public class _140108 {
    public static void main(String[] args) {

        String s = "banana";
        String s1 = "abracadabra";

        char[] charArray = s.toCharArray();

        // 기준문자, 기준문자갯수, 그 외 문자 갯수
        char charTemp = 0;
        int temp1 = 0;
        int temp2 = 0;

        boolean check = false;
        int answer = 0;

        for(char c : charArray){
            if(!check){
                check = true;
                charTemp = c;
                temp1 = 0;
                temp2 = 0;
                answer++;
            }

            if(charTemp == c){
                temp1++;
            }else {
                temp2++;
            }

            if(temp1 == temp2){
                check = false;
            }

        }

        System.out.println("--------------------");
        System.out.println(answer);


    }
}
