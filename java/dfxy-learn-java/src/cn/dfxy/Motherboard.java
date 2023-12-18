package cn.dfxy;

public class Motherboard {
    private DDr5 ddr5;

    public void setDdr5(DDr5 ddr5){
        this.ddr5 =ddr5;
    }
    public void read(){
        ddr5.read();
    }
    public void write(){
        ddr5.write();
    }
}
