package com.aurx.main.stringproblem;

public class ReverseAtSamePosition {
    public static void main(String[] args) {
        String str="sky is the blue";
        System.out.println(reverseAtPlace(str));
    }

    private static String reverseAtPlace(String str) {
        StringBuilder sb=new StringBuilder();
        String[] words=str.split(" ");
        for(String word:words){
            for(int i=word.length()-1;i>=0;i--)
            {
                sb.append(word.charAt(i));
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
