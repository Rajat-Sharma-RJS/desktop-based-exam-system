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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Test extends JFrame implements ActionListener{
    JTextField field1,field1a,field2,field3,field4,field5,field6,field7;
    JLabel l1,l1a,l2,l3,l4,l5,l6,l7;
    
    JLabel l;
    JRadioButton jb[]=new JRadioButton[5];
    JButton b1,b2,b3,b4,b5,b6;
    ButtonGroup bg;
    private ArrayList<Question> QuesList= new ArrayList<>();
    Login login;
    public void setQues(Login login){
        this.login=login;
        setTitle("ADMIN");
        l1= new JLabel("Ques no.");     l1a= new JLabel("Level");
        l1.setBounds(30, 50, 150, 30);  l1a.setBounds(300, 50, 150, 30);
        l2= new JLabel("Question");
        l2.setBounds(30, 100, 150, 30);
        l3= new JLabel("Option1");
        l3.setBounds(30, 150, 150, 30);
        l4= new JLabel("Option2");
        l4.setBounds(30, 200, 150, 30);
        l5= new JLabel("Option3");
        l5.setBounds(30, 250, 150, 30);
        l6= new JLabel("Option4");
        l6.setBounds(30, 300, 150, 30);
        l7= new JLabel("Right Answer");
        l7.setBounds(30, 350, 150, 30);
        field1= new JTextField();       field1a= new JTextField();
        field1.setBounds(170, 50, 50, 30);      field1a.setBounds(450, 50, 100, 30);
        field2= new JTextField();
        field2.setBounds(170, 100, 1000, 30);
        field3= new JTextField();
        field3.setBounds(170, 150, 200, 30);
        field4= new JTextField();
        field4.setBounds(170, 200, 200, 30);
        field5= new JTextField();
        field5.setBounds(170, 250, 200, 30);
        field6= new JTextField();
        field6.setBounds(170, 300, 200, 30);
        field7= new JTextField();
        field7.setBounds(170, 350, 200, 30);
        
        b1 = new JButton("Add Question");
        b2 = new JButton("Delete Question");
        b3 = new JButton("Logout");
        b4 = new JButton("Reset");
        b5 = new JButton("Import Data");
        b6 = new JButton("Show Questions");
        b1.setBounds(100, 400, 170, 30);
        b2.setBounds(600, 400, 220, 30);
        b3.setBounds(100, 470, 150, 30);
        b4.setBounds(350, 400, 120, 30);
        b5.setBounds(350, 470, 170, 30);
        b6.setBounds(620, 470, 220, 30);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        add(b1);    add(b2);    add(b3);    add(l1);    add(l1a);   add(l2);    add(l3);    add(l4);    add(l5);    add(l6);    add(b4);    add(b5);
        add(l7);    add(field1);    add(field1a);   add(field2);    add(field3);    add(field4);    add(field5);    add(field6);    add(field7);    add(b6);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(null);
	setLocation(250,100);
	setVisible(true);
	setSize(1200,600);
    }
    public boolean attempt(){
        if(QuesList.size()>0)
            return true;
        return false;
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Add Question") && QuesList.size()<10){//change
            
                if(!"".equals(field1.getText())){
                    QuesList.add(new Question(field1a.getText(),field1.getText(),field2.getText(),field3.getText(),field4.getText(),field5.getText(),field6.getText(),field7.getText()));
                }
            
        }
        if(e.getActionCommand().equals("Add Question") && QuesList.size()>=10){
            JOptionPane.showMessageDialog(this,"Limit Crossed");
        }
        if(e.getActionCommand().equals("Delete Question")){
            JTextField field = new JTextField();
            
            Object[] message = {
                "Question No. :", field,
            };
            int a=JOptionPane.showConfirmDialog(this,message,"Delete Question",JOptionPane.OK_CANCEL_OPTION);  
            if(a==JOptionPane.OK_OPTION){
                if(!"".equals(field.getText())){
                    int d=Integer.parseInt(field.getText());
                    d--;
                    QuesList.remove(d);
                }
            }
        }
        if(e.getActionCommand().equals("Logout")){
            setVisible(false);
            login.setStart(attempt());
            login.t1.setText("");
            login.t2.setText("");
            login.setVisible(true);
        }// more if statements
        if(e.getActionCommand().equals("Reset")){
            field1.setText("");     field1a.setText("");
            field2.setText("");
            field3.setText("");
            field4.setText("");
            field5.setText("");
            field6.setText("");
            field7.setText("");
        }
        if(e.getActionCommand().equals("Import Data")){
            JFileChooser fc=new JFileChooser();
		int i=fc.showOpenDialog(this);
		if(i==JFileChooser.APPROVE_OPTION){
			File f=fc.getSelectedFile();
			try{
                            BufferedReader br=new BufferedReader(new FileReader(f));
                            String line;
                            int test=0,t=0;
                            if((line=br.readLine())!=null)
				test=Integer.parseInt(line);
                            while(t<test && test<=10){
                                if((line=br.readLine())!=null){
                                    String level=line;
                                    String ques=br.readLine(),  op1=br.readLine(),   op2=br.readLine(),  op3=br.readLine(),  op4=br.readLine(),  right=br.readLine();
                                    QuesList.add(new Question(level,Integer.toString(t+1),ques,op1,op2,op3,op4,right));
                                    t++;
                                }
                            }
			}
			catch(Exception ex){ex.printStackTrace();}
		}
        }
        if(e.getActionCommand().equals("Show Questions")){
            JTextArea textArea = new JTextArea(10, 75);
            String show="";
            for(int q=0;q<QuesList.size();q++){
                show+=Integer.toString(q+1)+") "+QuesList.get(q).getQues()+"\n\n";
            }
            textArea.setText(show);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(this, scrollPane);
        }
    }
    public ArrayList<Question> getQuesList(){return QuesList;}
    public void setQuesList(ArrayList<Question> List){QuesList=List;}
}
