package com.atguigu.linkedlist;

import java.util.Stack;

public class SingleLinkedList {
    public static void main(String[] args) {
        //创建几个节点
        HeroNode heroNode = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode1 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode2 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode3 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList1 singleLinkedList1 = new SingleLinkedList1();
        //加入
        /*singleLinkedList1.add(heroNode);
        singleLinkedList1.add(heroNode1);
        singleLinkedList1.add(heroNode2);
        singleLinkedList1.add(heroNode3);*/


        //加入按照编号的顺序
        singleLinkedList1.addByOrder(heroNode);
        singleLinkedList1.addByOrder(heroNode3);
        singleLinkedList1.addByOrder(heroNode1);
        singleLinkedList1.addByOrder(heroNode2);
        singleLinkedList1.addByOrder(heroNode2);


        System.out.println("原链表的情况");
        singleLinkedList1.list();;

        /*System.out.println("反转单链表");
        reverseList(singleLinkedList1.getHead());
        singleLinkedList1.list();
*/

        System.out.println("逆序打印单链表");
        reversePrint(singleLinkedList1.getHead());
       /* singleLinkedList1.list();
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟12");
        singleLinkedList1.update(newHeroNode);


        //显示
        singleLinkedList1.list();

        //删除一个节点
        singleLinkedList1.dela(1);
        singleLinkedList1.dela(2);
        singleLinkedList1.list();

        System.out.println(getLength(singleLinkedList1.getHead()));

        HeroNode res = findLastIndexNode(singleLinkedList1.getHead(),1);
        System.out.println("res="+res);*/

    }

    //使用栈逆序打印
    public static  void  reversePrint(HeroNode head){
        if(head.next==null){
            return;
        }
        //创建一个栈将各个节点压入栈中

        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur!=null){//将链表所用节点压入栈
            stack.push(cur);
            cur =cur.next;
        }
        //将栈中节点进行打印
        while (stack.size()>0){
            System.out.println(stack.pop());//stack的特点是先进后出
        }
    }


    //将单链表反转
    public static  void reverseList(HeroNode head){
        if(head.next ==null ||head.next.next ==null){
            return;
        }

        HeroNode cur =head.next;
        HeroNode next =null;//指向当前节点的下一个节点
        HeroNode reverseHead =new HeroNode(0,"","");
        while (cur != null){
            next =cur .next;//暂时保存当前节点的下一个节点
            cur.next=reverseHead.next;
            reverseHead.next =cur;
            cur =next;
        }
        head.next=reverseHead.next;
    }







    public  static  HeroNode findLastIndexNode(HeroNode head,int index){
        if(head.next == null){
            return null;
        }
        int size =getLength(head);
        if(index <=0 || index>size){
            return  null;
        }
        HeroNode cur =head.next;
        for(int i =0;i<size - index;i++){
            cur =cur.next;
        }
        return  cur;

    }



    public static  int getLength(HeroNode head){
        if(head.next ==null){
            return 0 ;
        }
        int length =0;
        HeroNode cur =head.next;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

}


//定义SingleLinkedList管理我们的英雄
class SingleLinkedList1 {
    //先初始化一个头结点，头结点不要动
    private HeroNode head = new HeroNode(0, "", "");

    public  HeroNode getHead(){
        return head;
    }
    public void add(HeroNode heroNode) {

        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    //插入
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;//添加的编号是否存在，默认为false
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > heroNode.no){
                break;
            }else if(temp.next.no==heroNode.no){
                flag =true;//说明编号存在
            break;
            }
            temp =temp.next;
        }
        //判断flag的值
        if(flag){
            System.out.println("准备插入的数据存在"+heroNode.no);
        }else {
            heroNode.next=temp.next;
            temp.next =heroNode;
        }
    }


    public  void  update(HeroNode newHeroNode){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp =head.next;
        boolean flag =false;
        while (true){
            if(temp ==null){
                break;
            }
            if(temp.no==newHeroNode.no){
                flag=true;
                break;
            }
            temp =temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname =newHeroNode.nickname;
        }else {
            System.out.println("没有找到编号"+newHeroNode.no+"的节点");
        }
    }
    public void dela(int no){
        HeroNode temp =head;
        boolean flag =false;
        while (true){
            if(temp.next ==null){
                break;
            }
            if(temp.next.no==no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next =temp.next.next;
        }else {
            System.out.println("没有找到要删除的节点"+no);
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

}
