package com.student;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class Stadd implements ActionListener{
	JFrame screen;
	JPanel title,d,d2,pi,ld,fd,dec,photo;
	JButton min,close,register,back,button;
	JLabel head,pinfo,logdet,famdet,decl,label,idd,id,declare;
	JLabel fname,mname,lname,area,nation,username,password,email,smbno,father,foccup,faddress,fmbno,mother,moccup,maddress,mmbno,regno;
	JTextField first,middle,last,Area,Nation,Username,Email,Smbno,Father,Foccup,Faddress,Fmbno,Mother,Moccup,Mmbno,Maddress;
	JPasswordField Password;
	JRadioButton radiobutton2,radiobutton3;
	JComboBox combobox1,comboboxbranch,comboboxyear;
	JDateChooser chooser;
	String states[] = new String[50];
	String branch[] = new String[5];
	String YEar[] = new String[5];
	static final String DB_URL = "jdbc:mysql://localhost:3306/project";
	 static final String USER = "root";
 	  static final String PASS = "Exact@167";
   	Connection conn = null;
  	 Statement stmt = null;
	 java.sql.Date sqldate;
	 String f,l,m,pop,mum,birth,smobile,fmobile,mmobile,Foccupp,Moccupp,Maddresss,Faddresss,session,mail,user,pas,reg,gend,branchh,statess,Areaa,Nationn,pic;
	public Stadd() throws Exception{
															screen= new JFrame("ADD STUDENT");
															title=new JPanel();
															title.setBounds(0,0,1366,70);
															title.setForeground(new Color(247,202,24));
															title.setBackground(new Color(0,0,0,60));
															title.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															title.setLayout(null);
												screen.add(title);
															d=new JPanel();
															d.setBounds(400,0,50,70);
															d.setForeground(new Color(247,202,24));
															d.setBackground(Color.white);
															d.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															d.setLayout(null);
												title.add(d);
															d2=new JPanel();
															d2.setBounds(1,71,50,695);
															d2.setForeground(new Color(247,202,24));
															d2.setBackground(new Color(1,50,67));
															d2.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															d2.setLayout(null);
												screen.add(d2);
															pi=new JPanel();
															pi.setBounds(52,71,250,30);
															pi.setForeground(new Color(247,202,24));
															pi.setBackground(new Color(1,50,67));
															pi.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															pi.setLayout(null);
												screen.add(pi);
															ld=new JPanel();
															ld.setBounds(52,273,250,30);
															ld.setForeground(new Color(247,202,24));
															ld.setBackground(new Color(1,50,67));
															ld.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															ld.setLayout(null);
												screen.add(ld);
															fd=new JPanel();
															fd.setBounds(52,455,250,30);
															fd.setForeground(new Color(247,202,24));
															fd.setBackground(new Color(1,50,67));
															fd.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															fd.setLayout(null);
												screen.add(fd);
												dec=new JPanel();
															dec.setBounds(52,647,250,30);
															dec.setForeground(new Color(247,202,24));
															dec.setBackground(new Color(1,50,67));
															dec.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															dec.setLayout(null);
												screen.add(dec);
															min= new JButton("-");
															min.setBounds(1260,10,40,50);
															min.setBackground(new Color(0,0,0) );
															min.setForeground(Color.white);
															min.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															min.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															min.addActionListener(this);
												title.add(min);											
															close= new JButton("x");
															close.setBounds(1310,10,40,50);
															close.setForeground(Color.white);
															close.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,11));
															close.setBackground(new Color(0,0,0) );
															close.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															close.addActionListener(this);
												title.add(close);
															register= new JButton("REGISTER");
															register.setBounds(1100,730,120,30);
															register.setForeground(Color.white);
															register.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,11));
															register.setBackground(new Color(0,0,0) );
															register.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															register.addActionListener(this);
												screen.add(register);
															back= new JButton("BACK");
															back.setBounds(1230,730,120,30);
															back.setForeground(Color.white);
															back.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,11));
															back.setBackground(new Color(0,0,0) );
															back.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															back.addActionListener(this);
												screen.add(back);
															head=new JLabel("VIRTUAL INFORMATION PORTAL");
															head.setBounds(2,10,1000,50);
															head.setForeground(new Color(0,0,0));
															head.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,24));
												title.add(head);
															pinfo=new JLabel("PERSONAL INFORMATION :");
															pinfo.setBounds(2,0,200,30);
															pinfo.setForeground(new Color(255,255,255));
															pinfo.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
												pi.add(pinfo);
															logdet=new JLabel("LOGIN DETAILS :");
															logdet.setBounds(2,0,200,30);
															logdet.setForeground(new Color(255,255,255));
															logdet.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
												ld.add(logdet);
															famdet=new JLabel("FAMILY DETAILS :");
															famdet.setBounds(2,0,200,30);
															famdet.setForeground(new Color(255,255,255));
															famdet.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
												fd.add(famdet);
															decl=new JLabel("DECLARATION :");
															decl.setBounds(2,0,200,30);
															decl.setForeground(new Color(255,255,255));
															decl.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
												dec.add(decl);
															fname=new JLabel("FIRST NAME :");
															fname.setBounds(170,105,180,30);
															fname.setForeground(new Color(0, 0, 0));
															fname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(fname);
															mname=new JLabel("MIDDLE NAME :");
															mname.setBounds(147,139,180,30);
															mname.setForeground(new Color(0, 0, 0));
															mname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(mname);
															lname=new JLabel("LAST NAME :");
															lname.setBounds(174,173,180,30);
															lname.setForeground(new Color(0, 0, 0));
															lname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(lname);
															fname=new JLabel("GENDER :");
															fname.setBounds(205,207,180,30);
															fname.setForeground(new Color(0, 0, 0));
															fname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(fname);
															fname=new JLabel("STATE :");
															fname.setBounds(225,241,180,30);
															fname.setForeground(new Color(0, 0, 0));
															fname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(fname);
												            fname=new JLabel("DOB:");
															fname.setBounds(740,105,180,30);
															fname.setForeground(new Color(0, 0, 0));
															fname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(fname);
															fname=new JLabel("BRANCH :");
															fname.setBounds(695,139,180,30);
															fname.setForeground(new Color(0, 0, 0));
															fname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(fname);
															fname=new JLabel("YEAR :");
															fname.setBounds(725,173,180,30);
															fname.setForeground(new Color(0, 0, 0));
															fname.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(fname);
															area=new JLabel("AREA :");
															area.setBounds(725,207,180,30);
															area.setForeground(new Color(0, 0, 0));
															area.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(area);
															nation=new JLabel("NATIONALITY :");
															nation.setBounds(640,241,180,30);
															nation.setForeground(new Color(0, 0, 0));
															nation.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(nation);
															username=new JLabel("USERNAME :");
															username.setBounds(178,307,180,30);
															username.setForeground(new Color(0, 0, 0));
															username.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(username);
															password=new JLabel("PASSWORD :");
															password.setBounds(178,341,180,30);
															password.setForeground(new Color(0, 0, 0));
															password.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(password);
															email=new JLabel("EMAIL ID :");
															email.setBounds(197,375,180,30);
															email.setForeground(new Color(0, 0, 0));
															email.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(email);
															smbno=new JLabel("MOBILE NUMBER :");
															smbno.setBounds(117,409,200,30);
															smbno.setForeground(new Color(0, 0, 0));
															smbno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(smbno);
															father=new JLabel("FATHER NAME :");
															father.setBounds(144,490,200,30);
															father.setForeground(new Color(0, 0, 0));
															father.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(father);
															foccup=new JLabel("OCCUPATION :");
															foccup.setBounds(153,524,200,30);
															foccup.setForeground(new Color(0, 0, 0));
															foccup.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(foccup);
															faddress=new JLabel("ADDRESS :");
															faddress.setBounds(195,557,200,30);
															faddress.setForeground(new Color(0, 0, 0));
															faddress.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(faddress);
															fmbno=new JLabel("MOBILE NUMBER :");
															fmbno.setBounds(117,591,200,30);
															fmbno.setForeground(new Color(0, 0, 0));
															fmbno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(fmbno);
															mother=new JLabel("MOTHER NAME :");
															mother.setBounds(657,490,200,30);
															mother.setForeground(new Color(0, 0, 0));
															mother.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(mother);
															moccup=new JLabel("OCCUPATION :");
															moccup.setBounds(676,524,200,30);
															moccup.setForeground(new Color(0, 0, 0));
															moccup.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(moccup);
															maddress=new JLabel("ADDRESS :");
															maddress.setBounds(718,557,200,30);
															maddress.setForeground(new Color(0, 0, 0));
															maddress.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(maddress);
															mmbno=new JLabel("MOBILE NUMBER :");
															mmbno.setBounds(640,591,200,30);
															mmbno.setForeground(new Color(0, 0, 0));
															mmbno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
												screen.add(mmbno);
															/*button = new JButton("Browse");
															button.setBounds(1125,261,100,30);
															button.setForeground(Color.white);
															button.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,11));
															button.setBackground(new Color(0,0,0) );
															button.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(0,0,0)));
															button.addActionListener(this);
												screen.add(button);
												            photo=new JPanel();
															photo.setBounds(1100,105,150,150);
															photo.setBackground(new Color(0,0,0,80));
															label = new JLabel();
															label.setBounds(1100,105,150,150);
		
		                                        screen.add(label);
											    screen.add(photo);*/
															first=new JTextField();
															first.setBounds(327,105,210,30);
															//first.setForeground(new Color(255, 255, 255));
															//first.setBackground(new Color(0,0,0));
															first.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//first.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
												screen.add(first);

															middle=new JTextField();
															middle.setBounds(327,139,210,30);
															//middle.setForeground(new Color(255, 255, 255));
															//middle.setBackground(new Color(0,0,0));
															middle.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//middle.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
												screen.add(middle);
															last=new JTextField();
															last.setBounds(327,173,210,30);
															//last.setForeground(new Color(255, 255, 255));
															//last.setBackground(new Color(0,0,0));
															last.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//last.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
												screen.add(last);
															Area=new JTextField();
															Area.setBounds(830,207,210,30);
															//Area.setForeground(new Color(255, 255, 255));
															//Area.setBackground(new Color(0,0,0));
															Area.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Area.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
												screen.add(Area);
															Nation=new JTextField();
															Nation.setBounds(830,241,210,30);
															//Nation.setForeground(new Color(255, 255, 255));
															//Nation.setBackground(new Color(0,0,0));
															Nation.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Nation.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
												screen.add(Nation);
															Username=new JTextField();
															Username.setBounds(327,307,210,30);
															//Username.setForeground(new Color(255, 255, 255));
															//Username.setBackground(new Color(0,0,0));
															Username.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Username.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
												screen.add(Username);
															Password=new JPasswordField();
															Password.setBounds(327,341,210,30);
															//Password.setForeground(new Color(255, 255, 255));
															//Password.setBackground(new Color(0,0,0));
															Password.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Password.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
												screen.add(Password);
															Email=new JTextField();
															Email.setBounds(327,375,210,30);
															//Email.setForeground(new Color(255, 255, 255));
															//Email.setBackground(new Color(0,0,0));
															Email.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Email.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
												screen.add(Email);
															Smbno=new JTextField();
															Smbno.setBounds(327,409,210,30);
															//Smbno.setForeground(new Color(255, 255, 255));
															//Smbno.setBackground(new Color(0,0,0));
															Smbno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Smbno.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
												screen.add(Smbno);
															Father=new JTextField();
															Father.setBounds(327,490,210,30);
															//Father.setForeground(new Color(255, 255, 255));
															//Father.setBackground(new Color(0,0,0));
															Father.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Father.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
												screen.add(Father);
															Foccup=new JTextField();
															Foccup.setBounds(327,527,210,30);
															//Foccup.setForeground(new Color(255, 255, 255));
															//Foccup.setBackground(new Color(0,0,0));
															Foccup.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Foccup.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
												screen.add(Foccup);
															Faddress=new JTextField();
															Faddress.setBounds(327,557,210,30);
															//Faddress.setForeground(new Color(255, 255, 255));
															//Faddress.setBackground(new Color(0,0,0));
															Faddress.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Faddress.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
												screen.add(Faddress);
															Fmbno=new JTextField();
															Fmbno.setBounds(327,591,210,30);
															//Fmbno.setForeground(new Color(255, 255, 255));
															//Fmbno.setBackground(new Color(0,0,0));
															Fmbno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Fmbno.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
												screen.add(Fmbno);
															Mother=new JTextField();
															Mother.setBounds(830,490,210,30);
															//Mother.setForeground(new Color(255, 255, 255));
															//Mother.setBackground(new Color(0,0,0));
															Mother.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Mother.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
												screen.add(Mother);
															Moccup=new JTextField();
															Moccup.setBounds(830,524,210,30);
															//Moccup.setForeground(new Color(255, 255, 255));
															//Moccup.setBackground(new Color(0,0,0));
															Moccup.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Moccup.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
												screen.add(Moccup);
															Maddress=new JTextField();
															Maddress.setBounds(830,557,210,30);
															//Maddress.setForeground(new Color(255, 255, 255));
															//Maddress.setBackground(new Color(0,0,0));
															Maddress.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Maddress.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
												screen.add(Maddress);
															Mmbno=new JTextField();
															Mmbno.setBounds(830,591,210,30);
															//Mmbno.setForeground(new Color(255, 255, 255));
															//Mmbno.setBackground(new Color(0,0,0));
															Mmbno.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
															//Mmbno.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
												screen.add(Mmbno);

												            radiobutton2=new javax.swing.JRadioButton("MALE");
															radiobutton2.setFont(new Font("Dialog", Font.BOLD, 16));
															radiobutton2.setBounds(325,207,100,30);
												screen.add(radiobutton2);

															radiobutton3=new javax.swing.JRadioButton("FEMALE");
															radiobutton3.setFont(new Font("Dialog", Font.BOLD, 16));
															radiobutton3.setBounds(435,207,100,30);
												screen.add(radiobutton3);

															ButtonGroup jb = new ButtonGroup();
															jb.add(radiobutton2);
															jb.add(radiobutton3);
															combobox1 = new JComboBox();
combobox1.setBounds(330,241,200,30);
combobox1.setFont(new Font("Dialog",Font.BOLD,18));
screen.add(combobox1);

states[0] = "Andhra Pradesh";
states[1] = "Arunachal Pradesh";
states[2] = "Assam";
states[3] = "Bihar";
states[4] = "Chhattisgarh";
states[5] = "Goa";
states[6] = "Gujarat";
states[7] = "Haryana";
states[8] = "Himachal Pradesh";
states[9] = "Jammu and Kashmir";
states[10] = "Jharkhand";
states[11] = "Karnataka";
states[12] = "Kerala";
states[13] = "Madya Pradesh";
states[14] = "Maharashtra";
states[15] = "Manipur";
states[16] = "Meghalaya";
states[17] = "Mizoram";
states[18] = "Nagaland";
states[19] = "Orissa";
states[20] = "Punjab";
states[21] = "Rajasthan";
states[22] = "Sikkim";
states[23] = "Tamil Nadu";
states[24] = "Tripura";
states[25] = "Uttaranchal";
states[26] = "Uttar Pradesh";
states[27] = "West Bengal";
states[28] = "Andaman and Nicobar Islands";
states[29] = "Chandigarh";
states[30] = "Dadar and Nagar Haveli";
states[31] = "Daman and Diu";
states[32] = "Delhi";
states[33] = "Lakshadeep";
states[34] = "Pondicherry";

for (int j= 0 ; j< 35; j++) { combobox1.addItem(states[j]); }
															
														 chooser = new JDateChooser();
														//chooser.setLocale(Locale.US);
														chooser.setBounds(830,105,200,30);

														//JPanel panel = new JPanel();
//panel.add(new JLabel("Date of Birth:"));
											screen.add(chooser);
														comboboxbranch = new JComboBox();
														comboboxbranch.setBounds(830,139,200,30);
														comboboxbranch.setFont(new Font("Dialog",Font.BOLD,18));
											screen.add(comboboxbranch);

branch[0] = "CSE";
branch[1] = "CE";
branch[2] = "ECE";
branch[3] = "EE";
branch[4] = "ME";
//branch[5] = "Goa";
for (int j= 0 ; j< 5; j++) { comboboxbranch.addItem(branch[j]); }
														comboboxyear = new JComboBox();
														comboboxyear.setBounds(830,173,200,30);
														comboboxyear.setFont(new Font("Dialog",Font.BOLD,18));
											screen.add(comboboxyear);

YEar[0] = "FIRST";
YEar[1] = "SECOND";
YEar[2] = "THIRD";
YEar[3] = "FINAL";
//branch[4] = "ME";
//branch[5] = "Goa";
for (int j= 0 ; j< 4; j++) { comboboxyear.addItem(YEar[j]); }
															idd=new JLabel("REGISTRATION NO.:");
															idd.setBounds(900,7,150,50);
															idd.setBackground(new Color(0,0,60) );
															idd.setForeground(Color.white);
															idd.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															//idd.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															
				title.add(idd);
															id=new JLabel();
															id.setBounds(1060,7,150,50);
															id.setBackground(new Color(0,0,60) );
															id.setForeground(Color.white);
															id.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															//id.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															
				title.add(id);	
															declare=new JLabel("By Clicking on Register, I agree that i have given all the correct details that is given by student.");
															declare.setBounds(170,680,1000,50);
															//declare.setBackground(new Color(0,0,60) );
															//declare.setForeground(Color.white);
															declare.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,14));
															//declare.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(255, 255, 255)));
															
				screen.add(declare);	
		        Random ran= new Random();
		int n=ran.nextInt(100000)+1;
		String val=String.valueOf(n);
		id.setText("STREG"+val+"2018");
		
		       screen.setSize(1366,768);
			   screen.setUndecorated(true);
			   screen.setLayout(null);
			   screen.setLocationRelativeTo(null);
			   screen.setVisible(true);
										try{
											Class.forName("com.mysql.cj.jdbc.Driver");
											System.out.println("Connecting to database...");
											conn = DriverManager.getConnection(DB_URL,USER,PASS);
											}
										catch(SQLException e){
											System.out.println(e.getMessage());
											}
		
		
		
	}
	/*public void randomnumbers(){
		Random ran= new Random();
		int n=ran.nextInt(100000)+1;
		String val=String.valueOf(n);
		id.setText("STREG"+val+"2018");
	}*/
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==min){screen.setState(JFrame.ICONIFIED);}
		try{if(e.getSource()==close){screen.dispose();}}catch(Exception ex){ex.getMessage();}
		try{if(e.getSource()==back){screen.dispose();}}catch(Exception ex){ex.getMessage();}
		/*try{if(e.getSource()==button){JFileChooser file = new JFileChooser();
          file.setCurrentDirectory(new File(System.getProperty("user.home")));
          //filter the files
          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
          file.addChoosableFileFilter(filter);
          int result = file.showSaveDialog(null);
           //if the user click on save in Jfilechooser
          if(result == JFileChooser.APPROVE_OPTION){
              File selectedFile = file.getSelectedFile();
              String path = selectedFile.getAbsolutePath();
		  label.setIcon(ResizeImage(path));
		  photo.setVisible(false);}
		  else if(result == JFileChooser.CANCEL_OPTION){
              System.out.println("No File Select");
          }
        }}catch(Exception ex){}*/
	  if(e.getSource()==register){
			String f=first.getText();
			   String l=last.getText();
			   String m=middle.getText();
			   String pop=Father.getText();
			   String mum=Mother.getText();
			   //String birth=chooser.getText();
			   Date BirthDate=(Date) chooser.getDate();
			SimpleDateFormat oDateFormat = new SimpleDateFormat("yyyy/MM/dd");

			String sd = oDateFormat.format(BirthDate);

				//obj.setStartDate(sd);
			   String smobile=Smbno.getText();
			   String fmobile=Fmbno.getText();
			   String mmobile=Mmbno.getText();
			   String Foccupp=Foccup.getText();
			   String Moccupp=Moccup.getText();
			   String Maddresss=Maddress.getText();
			   String Faddresss=Maddress.getText();
			   String session=comboboxyear.getSelectedItem().toString();
			   String mail=Email.getText();
			   String user=Username.getText();
			   String pas=Password.getText();
			   String reg=id.getText();
			   if(radiobutton2.isSelected()) 
        gend="MALE";
else if(radiobutton3.isSelected()) 
        gend="FEMALE";
			   //String gend=gender.getSelectedItem().toString();
			   String branchh=comboboxbranch.getSelectedItem().toString();
			   String statess=combobox1.getSelectedItem().toString();
			   String Areaa=Area.getText();
			   String Nationn=Nation.getText();
			   // File image = new File(label);
            //inputStream = new FileInputStream(image);
			//String pic=label.setBinaryStream(2, (InputStream) inputStream, (int)(image.length()));
			//JTextField first,middle,last,Area,Nation,Username,Password,Email,Smbno,Father,Foccup,Faddress,Fmbno,Mother,Moccup,Mmbno,Maddress;
			try{System.out.println("Creating statement...");
    		  stmt = conn.createStatement();
			  String sql;
			  sql="INSERT INTO member( firstname, middlename, lastname, fathername, mothername, gender, branch, dob, mobileno, year, emailid, username, password, regno, almuni, foccupation, fmbno, faddress, moccupation, mmbno, maddress, area, nationality, state) VALUES ('"+f+"','"+m+"','"+l+"','"+pop+"','"+mum+"','"+gend+"','"+branchh+"','"+sd+"','"+smobile+"','"+session+"','"+mail+"','"+user+"','"+pas+"','"+reg+"','student','"+Foccupp+"','"+fmobile+"','"+Faddresss+"','"+Moccupp+"','"+mmobile+"','"+Maddresss+"','"+Areaa+"','"+Nationn+"','"+statess+"')";
			  stmt.executeUpdate(sql);
			  System.out.println(f+l+m+pop+mum+sd+smobile+fmobile+mmobile+Foccupp+Moccupp+Maddresss+Faddresss+session+mail+user+pas+reg+gend+branchh+statess+Areaa+Nationn);
		        JOptionPane.showMessageDialog(screen,"STUDENT REGISTERED SUCCESSFULLY");
		}catch(SQLException ev){ev.printStackTrace();}}
		
	}
	 /*public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }*/
	public static void main(String[] args) throws Exception{
		new Stadd();
	}
}