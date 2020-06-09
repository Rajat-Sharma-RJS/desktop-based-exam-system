/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author rajat
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Question{
    private String level,quesNo,ques,op1,op2,op3,op4,right;
    public Question(String level,String quesNo,String ques,String op1,String op2,String op3,String op4,String right){
        this.level=level;
        this.op1=op1;
        this.op2=op2;
        this.op3=op3;
        this.op4=op4;
        this.ques=ques;
        this.quesNo=quesNo;
        this.right=right;
    }
    public String getLevel(){return level;}
    public String getQuesNo(){return quesNo;}
    public String getQues(){return ques;}
    public String getOp1(){return op1;}
    public String getOp2(){return op2;}
    public String getOp3(){return op3;}
    public String getOp4(){return op4;}
    public String getRight(){return right;}
    
}
