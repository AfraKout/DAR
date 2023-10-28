package TP3;

import java.io.Serializable;

public class operation implements Serializable {
    private int op1;
    private int op2;
    private char op;
    private int res;

    public operation(int nb1, int nb2, char op){
        this.op1 = nb1;
        this.op2 = nb2;
        this.op = op;
    }

    public int getOp1(){
        return op1;
    }

    public int getOp2(){
        return op2;
    }

    public char getOp(){
        return op;
    }

    public void setRes(int res){
        this.res = res;
    }

    public int getRes(){
        return res;
    }
}