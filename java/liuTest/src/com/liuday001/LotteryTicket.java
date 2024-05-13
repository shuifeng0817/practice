package com.liuday001;

import java.util.Arrays;
import java.util.Random;

public class LotteryTicket {
    private int index;
    private int[] data;
    private Random rand = new Random();
    public LotteryTicket(){
        this.data=new int[7];
    }
    public void create(){
        while (this.index<this.data.length){
            int code =this.rand.nextInt(37);
            if(this.isExists(code)){
                this.data[this.index++]=code;
            }
        }
    }
    private boolean isExists(int code){
        if(code==0){
            return false;
        }
        for (int datum : this.data) {
            if(datum==code){
                return false;
            }
        }
        return true;
    }
    public int[] getData(){
        Arrays.sort(this.data);//排序方法！！！
        return data;
    }


}
