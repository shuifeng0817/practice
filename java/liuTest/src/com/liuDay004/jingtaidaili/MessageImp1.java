package com.liuDay004.jingtaidaili;

public class MessageImp1 implements IMessage{
    @Override
    public String echo(String str) {
        return "[ECHO]"+str;
    }
}
