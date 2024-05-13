package com.liuday001;

public class MaoPao {

    public int[] sort(int[] num){
        for (int i = 0; i < num.length-1; i++) {
            for (int j = 0; j < num.length-1-i; j++) {
                if(num[j]>num[j+1]){
                    int tmp =num[j];
                    num[j]=num[j+1];
                    num[j+1]=tmp;
                }
            }
        }
        return num;
    }
    public static void main(String[] args) {
        int [] num={36,12,16,11};

        MaoPao maoPao = new MaoPao();
        num = maoPao.sort(num);
        for (int i : num) {
            System.out.print(i+" ");
        }
    }
}
