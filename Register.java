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

public class Register extends JFrame implements ActionListener { 
        Login login;
	// Components of the Form 
	private Container c; 
	private JLabel title; 
	private JLabel name; 
	private JTextField tname; 
	private JLabel usr; 
	private JTextField tusr; 
	private JLabel gender; 
	private JRadioButton male; 
	private JRadioButton female; 
	private ButtonGroup gengp; 
	private JLabel dob; 
	private JComboBox date; 
	private JComboBox month; 
	private JComboBox year; 
	private JLabel add; 
	private JTextField tadd; 
	private JCheckBox term; 
	private JButton sub; 
	private JButton reset;
        private JButton back; 
	private JLabel res;

	private String dates[] 
		= { "1", "2", "3", "4", "5", 
			"6", "7", "8", "9", "10", 
			"11", "12", "13", "14", "15", 
			"16", "17", "18", "19", "20", 
			"21", "22", "23", "24", "25", 
			"26", "27", "28", "29", "30", 
			"31" }; 
	private String months[] 
		= { "Jan", "feb", "Mar", "Apr", 
			"May", "Jun", "July", "Aug", 
			"Sup", "Oct", "Nov", "Dec" }; 
	private String years[] 
		= { "1995", "1996", "1997", "1998", 
			"1999", "2000", "2001", "2002", 
			"2003", "2004", "2005", "2006", 
			"2007", "2008", "2009", "2010", 
			"2011", "2012", "2013", "2014", 
			"2015", "2016", "2017", "2018", 
			"2019" }; 

	public Register(Login login) 
	{ 
                this.login=login;
		setTitle("Registration Form"); 
		setBounds(300, 90, 750, 600); 
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
		setResizable(false); 

		c = getContentPane(); 
		c.setLayout(null); 

		title = new JLabel("Registration Form"); 
		title.setFont(new Font("Arial", Font.PLAIN, 30)); 
		title.setSize(300, 30); 
		title.setLocation(300, 30); 
		c.add(title); 

		name = new JLabel("Name"); 
		name.setFont(new Font("Arial", Font.PLAIN, 20)); 
		name.setSize(100, 20); 
		name.setLocation(100, 100); 
		c.add(name); 

		tname = new JTextField(); 
		tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tname.setSize(190, 20); 
		tname.setLocation(200, 100); 
		c.add(tname); 

		usr = new JLabel("User Name"); 
		usr.setFont(new Font("Arial", Font.PLAIN, 20)); 
		usr.setSize(150, 20); 
		usr.setLocation(100, 150); 
		c.add(usr); 

		tusr = new JTextField(); 
		tusr.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tusr.setSize(190, 20); 
		tusr.setLocation(250, 150); 
		c.add(tusr); 

		gender = new JLabel("Gender"); 
		gender.setFont(new Font("Arial", Font.PLAIN, 20)); 
		gender.setSize(100, 20); 
		gender.setLocation(100, 250); 
		c.add(gender); 

		male = new JRadioButton("Male"); 
		male.setFont(new Font("Arial", Font.PLAIN, 15)); 
		male.setSelected(true); 
		male.setSize(75, 20); 
		male.setLocation(200, 250); 
		c.add(male); 

		female = new JRadioButton("Female"); 
		female.setFont(new Font("Arial", Font.PLAIN, 15)); 
		female.setSelected(false); 
		female.setSize(80, 20); 
		female.setLocation(275, 250); 
		c.add(female); 

		gengp = new ButtonGroup(); 
		gengp.add(male); 
		gengp.add(female); 

		dob = new JLabel("DOB"); 
		dob.setFont(new Font("Arial", Font.PLAIN, 20)); 
		dob.setSize(100, 20); 
		dob.setLocation(100, 300); 
		c.add(dob); 

		date = new JComboBox(dates); 
		date.setFont(new Font("Arial", Font.PLAIN, 15)); 
		date.setSize(50, 20); 
		date.setLocation(200, 300); 
		c.add(date); 

		month = new JComboBox(months); 
		month.setFont(new Font("Arial", Font.PLAIN, 15)); 
		month.setSize(70, 20); 
		month.setLocation(270, 300); 
		c.add(month); 

		year = new JComboBox(years); 
		year.setFont(new Font("Arial", Font.PLAIN, 15)); 
		year.setSize(90, 20); 
		year.setLocation(350, 300); 
		c.add(year); 

		add = new JLabel("Password"); 
		add.setFont(new Font("Arial", Font.PLAIN, 20)); 
		add.setSize(100, 20); 
		add.setLocation(100, 200); 
		c.add(add); 

		tadd = new JTextField(); 
		tadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tadd.setSize(200, 20); 
		tadd.setLocation(250, 200);
		c.add(tadd); 

		term = new JCheckBox("Accept Terms And Conditions."); 
		term.setFont(new Font("Arial", Font.PLAIN, 15)); 
		term.setSize(250, 20); 
		term.setLocation(150, 400); 
		c.add(term); 

		sub = new JButton("Submit"); 
		sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
		sub.setSize(100, 20); 
		sub.setLocation(150, 450); 
		sub.addActionListener(this); 
		c.add(sub); 

		reset = new JButton("Reset"); 
		reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
		reset.setSize(100, 20); 
		reset.setLocation(270, 450); 
		reset.addActionListener(this); 
		c.add(reset);
                
                back = new JButton("Back"); 
		back.setFont(new Font("Arial", Font.PLAIN, 15)); 
		back.setSize(100, 20); 
		back.setLocation(390, 450); 
		back.addActionListener(this); 
		c.add(back); 

		res = new JLabel(""); 
		res.setFont(new Font("Arial", Font.PLAIN, 20)); 
		res.setSize(500, 25); 
		res.setLocation(100, 500); 
		c.add(res);

		setVisible(true); 
	} 
 
	public void actionPerformed(ActionEvent e) 
	{ 
		if (e.getSource() == sub) { 
			if (term.isSelected() && !"".equals(tname.getText()) && !"".equals(tusr.getText()) && !"".equals(tadd.getText())) {
				String data1;
				if (male.isSelected()) 
					data1 = "Male";
				else
					data1 = "Female"; 
				String data2 = (String)date.getSelectedItem() + "/" + (String)month.getSelectedItem() + "/" + (String)year.getSelectedItem(); //dob

                                login.getMap().put(tusr.getText(), tadd.getText());
                                login.getList().add(new Student(tname.getText(),tusr.getText(),data1,data2,tadd.getText()));
				res.setText("Registration Successfully.."); 
			} 
			else {
				res.setText("Please accept the"
							+ " terms & conditions.."); 
			} 
		} 

		else if (e.getSource() == reset) { 
			String def = ""; 
			tname.setText(def); 
			tadd.setText(def); 
			tusr.setText(def); 
			res.setText(def); 
			term.setSelected(false); 
			date.setSelectedIndex(0); 
			month.setSelectedIndex(0); 
			year.setSelectedIndex(0); 
		}
                
                else if (e.getSource() == back){
                    setVisible(false);
                    login.setVisible(true);
                } 
	}
        
} 