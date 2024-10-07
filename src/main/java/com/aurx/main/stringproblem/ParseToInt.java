package com.aurx.main.stringproblem;

public class ParseToInt {
    public static void main(String[] args) {
//        String str = "0009";
//        str=str.replace('0',' ').trim();
//        int num =str.charAt(0)-'0';
//    /*    char[] charArray = str.toCharArray();
//   for(int i=0;i<charArray.length;i++){
//       if(charArray[i]>'0'){
//           num=charArray[i]-'0';
//
//       }
//   }*/
//        System.out.println(num);

        String str = "0009";
        str=str.replace("0","").trim();
//        int num =str.charAt(0)-'0';
    /*    char[] charArray = str.toCharArray();
   for(int i=0;i<charArray.length;i++){
       if(charArray[i]>'0'){
           num=charArray[i]-'0';

       }
   }*/
        System.out.println(str);
    }
}
