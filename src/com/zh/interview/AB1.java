package com.zh.interview;

import java.util.Scanner;

/**
 * @program: data-structures-and-algorithms
 * @author: AlbertZhang
 * @create: 2024-07-20 20:07
 * @description: A+B第一题
 **/
public class AB1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            int n=sc.nextInt();
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                System.out.println(a+b);
            }
        }
    }
}
