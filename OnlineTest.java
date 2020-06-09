/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

/**
 *
 * @author rajat
 */
public class OnlineTest extends Test{
    ArrayList<Question> q;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];
    public void startTest(Login login,ArrayList<Question> List){
                this.login=login;
                q=List;
                setTitle("Desktop Based Exam");
                l=new JLabel();     l1a=new JLabel();
		add(l);     add(l1a);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
                //b3=new JButton("Logout");
		b1.addActionListener(this);
		b2.addActionListener(this);
                //b3.addActionListener(this);
		add(b1);add(b2);/*add(b3);*/
		set();
		l.setBounds(30,40,450,20);  l1a.setBounds(30,10,100,20);
		jb[0].setBounds(10,80,800,20);
		jb[1].setBounds(10,110,800,20);
		jb[2].setBounds(10,140,800,20);
		jb[3].setBounds(10,170,800,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,150,30);
                //b3.setBounds(150,300,150,30);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(1150,400);
    }
    
    public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Next"))
		{
			if(check() && q.get(current).getLevel().equals("Easy"))
				count=count+1;
                        if(check() && q.get(current).getLevel().equals("Medium"))
				count=count+2;
                        if(check() && q.get(current).getLevel().equals("Hard"))
				count=count+3;
			current++;
                        if(current<q.size())
                            set();	
			if(current==9 || current==q.size()-1 || current==1 && q.size()==1)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
                        JButton ok=new JButton("ok");
			bk.setBounds(920,20+30*x,120,30);
                        ok.setBounds(1050, 20+30*x, 90, 30);
			add(bk);    add(ok);
			bk.addActionListener(this);
                        ok.addActionListener(this);
			m[x]=current;
			x++;
			current++;
                        if(current<q.size())
                            set();	
			if(current==9 || current==q.size()-1)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check() && q.get(current).getLevel().equals("Easy"))
				count=count+1;
                        if(check() && q.get(current).getLevel().equals("Medium"))
				count=count+2;
                        if(check() && q.get(current).getLevel().equals("Hard"))
				count=count+3;
			now=current;
                        
			current=m[y];
                        if(current<q.size())
                            set();
			((JButton)e.getSource()).setEnabled(false);
			//current=now;
                        //System.out.println("yes");
		}
		}
	        
                if(e.getActionCommand().equals("ok")){
                    if(check() && q.get(current).getLevel().equals("Easy"))
				count=count+1;
                        if(check() && q.get(current).getLevel().equals("Medium"))
				count=count+2;
                        if(check() && q.get(current).getLevel().equals("Hard"))
				count=count+3;
                    current=now;
                    ((JButton)e.getSource()).setEnabled(false);
                }
                        
		if(e.getActionCommand().equals("Result"))
		{
			
                        if(check() && q.get(current).getLevel().equals("Easy"))
				count=count+1;
                        if(check() && q.get(current).getLevel().equals("Medium"))
				count=count+2;
                        if(check() && q.get(current).getLevel().equals("Hard"))
				count=count+3;
			current++;
			//System.out.println("correct ans="+count);
                        if(b1.isEnabled())
                            b1.setEnabled(false);
			JOptionPane.showMessageDialog(this,"Score="+count);
                        setVisible(false);
                        login.t1.setText("");
                        login.t2.setText("");
                        login.setVisible(true);
                        
		}
	}
    
    void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
                    l1a.setText(q.get(0).getLevel());
			l.setText(q.get(0).getQues());
			jb[0].setText(q.get(0).getOp1());jb[1].setText(q.get(0).getOp2());jb[2].setText(q.get(0).getOp3());jb[3].setText(q.get(0).getOp4());	
		}
		if(current==1)
		{
                    l1a.setText(q.get(1).getLevel());
			l.setText(q.get(1).getQues());
			jb[0].setText(q.get(1).getOp1());jb[1].setText(q.get(1).getOp2());jb[2].setText(q.get(1).getOp3());jb[3].setText(q.get(1).getOp4());
		}
		if(current==2)
		{
                    l1a.setText(q.get(2).getLevel());
			l.setText(q.get(2).getQues());
			jb[0].setText(q.get(2).getOp1());jb[1].setText(q.get(2).getOp2());jb[2].setText(q.get(2).getOp3());jb[3].setText(q.get(2).getOp4());
		}
		if(current==3)
		{
                    l1a.setText(q.get(3).getLevel());
			l.setText(q.get(3).getQues());
			jb[0].setText(q.get(3).getOp1());jb[1].setText(q.get(3).getOp2());jb[2].setText(q.get(3).getOp3());jb[3].setText(q.get(3).getOp4());
		}
		if(current==4)
		{
                    l1a.setText(q.get(4).getLevel());
			l.setText(q.get(4).getQues());
			jb[0].setText(q.get(4).getOp1());jb[1].setText(q.get(4).getOp2());jb[2].setText(q.get(4).getOp3());jb[3].setText(q.get(4).getOp4());
		}
		if(current==5)
		{
                    l1a.setText(q.get(5).getLevel());
			l.setText(q.get(5).getQues());
			jb[0].setText(q.get(5).getOp1());jb[1].setText(q.get(5).getOp2());jb[2].setText(q.get(5).getOp3());jb[3].setText(q.get(5).getOp4());
		}
		if(current==6)
		{
                    l1a.setText(q.get(6).getLevel());
			l.setText(q.get(6).getQues());
			jb[0].setText(q.get(6).getOp1());jb[1].setText(q.get(6).getOp2());jb[2].setText(q.get(6).getOp3());jb[3].setText(q.get(6).getOp4());
		}
		if(current==7)
		{
                    l1a.setText(q.get(7).getLevel());
			l.setText(q.get(7).getQues());
			jb[0].setText(q.get(7).getOp1());jb[1].setText(q.get(7).getOp2());jb[2].setText(q.get(7).getOp3());jb[3].setText(q.get(7).getOp4());	
		}
		if(current==8)
		{
                    l1a.setText(q.get(8).getLevel());
			l.setText(q.get(8).getQues());
			jb[0].setText(q.get(8).getOp1());jb[1].setText(q.get(8).getOp2());jb[2].setText(q.get(8).getOp3());jb[3].setText(q.get(8).getOp4());
		}
		if(current==9)
		{
                    l1a.setText(q.get(9).getLevel());
			l.setText(q.get(9).getQues());
			jb[0].setText(q.get(9).getOp1());jb[1].setText(q.get(9).getOp2());jb[2].setText(q.get(9).getOp3());jb[3].setText(q.get(9).getOp4());
		}
		l.setBounds(30,40,1000,20);     l1a.setBounds(30,10,100,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(10,80+i,800,20);
	}
	boolean check()
	{
            if(current<q.size()){
		if(current==0){
                    if(jb[0].isSelected())
                        return(jb[0].getText().equals(q.get(0).getRight()));
                    if(jb[1].isSelected())
                        return(jb[1].getText().equals(q.get(0).getRight()));
                    if(jb[2].isSelected())
                        return(jb[2].getText().equals(q.get(0).getRight()));
                    if(jb[3].isSelected())
                        return(jb[3].getText().equals(q.get(0).getRight()));
                }
                
		if(current==1){
                    if(jb[0].isSelected())
                        return(jb[0].getText().equals(q.get(1).getRight()));
                    if(jb[1].isSelected())
                        return(jb[1].getText().equals(q.get(1).getRight()));
                    if(jb[2].isSelected())
                        return(jb[2].getText().equals(q.get(1).getRight()));
                    if(jb[3].isSelected())
                        return(jb[3].getText().equals(q.get(1).getRight()));
                }
                
                if(current==2){
                    if(jb[0].isSelected())
                        return(jb[0].getText().equals(q.get(2).getRight()));
                    if(jb[1].isSelected())
                        return(jb[1].getText().equals(q.get(2).getRight()));
                    if(jb[2].isSelected())
                        return(jb[2].getText().equals(q.get(2).getRight()));
                    if(jb[3].isSelected())
                        return(jb[3].getText().equals(q.get(2).getRight()));
                }
                
                if(current==3){
                    if(jb[0].isSelected())
                        return(jb[0].getText().equals(q.get(3).getRight()));
                    if(jb[1].isSelected())
                        return(jb[1].getText().equals(q.get(3).getRight()));
                    if(jb[2].isSelected())
                        return(jb[2].getText().equals(q.get(3).getRight()));
                    if(jb[3].isSelected())
                        return(jb[3].getText().equals(q.get(3).getRight()));
                }
                
                if(current==4){
                    if(jb[0].isSelected())
                        return(jb[0].getText().equals(q.get(4).getRight()));
                    if(jb[1].isSelected())
                        return(jb[1].getText().equals(q.get(4).getRight()));
                    if(jb[2].isSelected())
                        return(jb[2].getText().equals(q.get(4).getRight()));
                    if(jb[3].isSelected())
                        return(jb[3].getText().equals(q.get(4).getRight()));
                }
                
                if(current==5){
                    if(jb[0].isSelected())
                        return(jb[0].getText().equals(q.get(5).getRight()));
                    if(jb[1].isSelected())
                        return(jb[1].getText().equals(q.get(5).getRight()));
                    if(jb[2].isSelected())
                        return(jb[2].getText().equals(q.get(5).getRight()));
                    if(jb[3].isSelected())
                        return(jb[3].getText().equals(q.get(5).getRight()));
                }
                
                if(current==6){
                    if(jb[0].isSelected())
                        return(jb[0].getText().equals(q.get(6).getRight()));
                    if(jb[1].isSelected())
                        return(jb[1].getText().equals(q.get(6).getRight()));
                    if(jb[2].isSelected())
                        return(jb[2].getText().equals(q.get(6).getRight()));
                    if(jb[3].isSelected())
                        return(jb[3].getText().equals(q.get(6).getRight()));
                }
                
                if(current==7){
                    if(jb[0].isSelected())
                        return(jb[0].getText().equals(q.get(7).getRight()));
                    if(jb[1].isSelected())
                        return(jb[1].getText().equals(q.get(7).getRight()));
                    if(jb[2].isSelected())
                        return(jb[2].getText().equals(q.get(7).getRight()));
                    if(jb[3].isSelected())
                        return(jb[3].getText().equals(q.get(7).getRight()));
                }
                
                if(current==8){
                    if(jb[0].isSelected())
                        return(jb[0].getText().equals(q.get(8).getRight()));
                    if(jb[1].isSelected())
                        return(jb[1].getText().equals(q.get(8).getRight()));
                    if(jb[2].isSelected())
                        return(jb[2].getText().equals(q.get(8).getRight()));
                    if(jb[3].isSelected())
                        return(jb[3].getText().equals(q.get(8).getRight()));
                }
                
                if(current==9){
                    if(jb[0].isSelected())
                        return(jb[0].getText().equals(q.get(9).getRight()));
                    if(jb[1].isSelected())
                        return(jb[1].getText().equals(q.get(9).getRight()));
                    if(jb[2].isSelected())
                        return(jb[2].getText().equals(q.get(9).getRight()));
                    if(jb[3].isSelected())
                        return(jb[3].getText().equals(q.get(9).getRight()));
                }
            }
		return false;
	}
}
