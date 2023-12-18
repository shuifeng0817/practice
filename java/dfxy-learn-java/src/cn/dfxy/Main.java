package cn.dfxy;

public class Main {
    public static void main(String[] args) {
        Motherboard motherboard = new Motherboard();
        Kingston kingston = new Kingston();
        Adata adata = new Adata();
        motherboard.setDdr5(adata);
        motherboard.write();
        motherboard.read();
        motherboard.setDdr5(kingston);
        motherboard.write();
        motherboard.read();


    }
}
