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
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Student{
    String name,usr,gender,dob,password;
    Student(String name,String usr,String gender,String dob,String password){
        this.name=name;
        this.usr=usr;
        this.gender=gender;
        this.dob=dob;
        this.password=password;
    }
}
public class Login extends JFrame implements ActionListener{
    JLabel l1,l2;
    JButton b1,b2;
    JTextField t1;
    JPasswordField t2;
    private HashMap<String, String> Map = new HashMap<>(); // <User name, password>
    private ArrayList<Student> List= new ArrayList<>();
    private boolean Start=false;
    // make an object of online test;
    Test onlineTest = new Test();
    public Login(){
        super("Login");
        l1= new JLabel("User Name"); 
        l2= new JLabel("Password");
        t1= new JTextField();
        t2 =new JPasswordField();
        l1.setBounds(100, 30, 100, 30);     t1.setBounds(200, 30, 150, 30);
        l2.setBounds(100, 80, 100, 30);     t2.setBounds(200, 80, 150, 30);
        b1= new JButton("Register");
        b2= new JButton("Login");
        b1.setBounds(120, 170, 100, 30);
        b2.setBounds(300, 170, 100, 30);
        b1.addActionListener(this);     b2.addActionListener(this);
        add(l1);    add(l2);    add(t1);    add(t2);    add(b1);   add(b2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
	setLocation(250,100);
	setVisible(true);
	setSize(500,300);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Login")){
            String key=new String(t2.getPassword());
            if(t1.getText().equals("ADMIN") && key.equals("ADMIN")){
                setVisible(false);
                //use object of Online Test;
                onlineTest.setQues(this);
            }
            if(Map.containsKey(t1.getText())==true && Map.get(t1.getText()).equals(key) && Start==true){
                setVisible(false);
                // use object of online test;
                new OnlineTest().startTest(this,onlineTest.getQuesList());
            }
            if(Map.containsKey(t1.getText())==true && Map.get(t1.getText()).equals(key) && Start==false){
                t1.setText("");
                t2.setText("");
                JOptionPane.showMessageDialog(this, "No questions to attempt");
            }
            if("".equals(t1.getText()) || "".equals(key)){
                JOptionPane.showMessageDialog(this, "Invalid Entry");
            }
        }
        else if(e.getActionCommand().equals("Register")){
            setVisible(false);
            // make an object of register
            // store entries into hashmap
            Register register= new Register(this);
        }
        
    }
    public ArrayList<Student> getList(){return List;}
    public HashMap<String, String> getMap(){return Map;}
    public void setStart(boolean bool){Start=bool;}
}
