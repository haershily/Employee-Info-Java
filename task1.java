import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.StringTokenizer;
public class task1 extends JFrame implements ActionListener,ItemListener
{
	//Variables
	boolean tf=false;
	String str1,str3="",str2="";
	Manager m;
	Executive e;
	
	//Menu
	JMenuBar bar=new JMenuBar();
	JMenu file=new JMenu("File");
	JMenu entry=new JMenu("Entry");
	JMenu report=new JMenu("Report");
	JMenu enquiry=new JMenu("Enquiry");
	JMenu Color1=new JMenu("Color");
	JCheckBoxMenuItem showcolor= new JCheckBoxMenuItem("Show Color");
	JCheckBoxMenuItem showentry= new JCheckBoxMenuItem("Show Entry");
	JCheckBoxMenuItem showreport= new JCheckBoxMenuItem("Show Report");
	JCheckBoxMenuItem showenquiry= new JCheckBoxMenuItem("Show Enquiry");
	JMenuItem exit=new JMenuItem("Exit");
	
	JMenuItem EmployeeEntry=new JMenuItem("Employee Entry");
	JMenuItem EmployeeReport=new JMenuItem("Employee Report");
	JMenuItem EmployeeSearch=new JMenuItem("Employee Search");	
	
	JRadioButtonMenuItem red=new JRadioButtonMenuItem("Red");
	JRadioButtonMenuItem white=new JRadioButtonMenuItem("White");
	JRadioButtonMenuItem green=new JRadioButtonMenuItem("Green");
	JRadioButtonMenuItem blue=new JRadioButtonMenuItem("Blue");
	JRadioButtonMenuItem yellow=new JRadioButtonMenuItem("Yellow");
	JRadioButtonMenuItem magenta=new JRadioButtonMenuItem("Magenta");
	JRadioButtonMenuItem cyan=new JRadioButtonMenuItem("Cyan");
	JRadioButtonMenuItem gray=new JRadioButtonMenuItem("Gray");
	JRadioButtonMenuItem light=new JRadioButtonMenuItem("LightGray");
	JRadioButtonMenuItem pink=new JRadioButtonMenuItem("Pink");
	JRadioButtonMenuItem orange=new JRadioButtonMenuItem("Orange");
	ButtonGroup group=new ButtonGroup();
	
	//Form
	//Panel 1
	JLabel mtitle = new JLabel("Employee Form");
	JPanel p1 = new JPanel();
	
	//Panel 2
	JButton btnadd=new JButton("Add");
	JButton btnsearch=new JButton("Search");
	JButton btnreport=new JButton("Report");
	JPanel p2 = new JPanel();
	
	//Panel 3
	JLabel lblch = new JLabel("Post");
	CheckboxGroup cg1 = new CheckboxGroup();
	Checkbox chkmanager = new Checkbox("Manager",cg1,false);
	Checkbox chkexec = new Checkbox("Executive",cg1,true);
	JPanel p3 = new JPanel();
	
	//Panel 4
	JLabel lblname = new JLabel("Name");
	JLabel lblgender = new JLabel("Gender");
	JLabel lbladd = new JLabel("Address");
	JLabel lblsalary = new JLabel("Salary");
	JLabel lbldep = new JLabel("Department");
	JLabel lbltitle = new JLabel("Title");
	JTextField txtname= new JTextField(20);
	JTextField txtsalary= new JTextField(10);
	Choice cbodep = new Choice();
	JTextField txttitle= new JTextField(15);
	JTextArea txtadd= new JTextArea(3,15);
	CheckboxGroup cg = new CheckboxGroup();
	Checkbox chkmale = new Checkbox("Male",cg,true);
	Checkbox chkfemale = new Checkbox("Female",cg,false);
	JPanel p4 = new JPanel();
	
	//Panel 5
	JButton btnone = new JButton("Save");
	JButton btntwo = new JButton("Clear");
	JPanel p5 = new JPanel();
	
	//Panel 6
	TextArea txtreport= new TextArea(3,20);
	JButton btnclose = new JButton("Close");
	JPanel p6 = new JPanel();
		
	public task1()
	{
		//menu construction
		buildmenu();
		showcolor.setSelected(true);
		showentry.setSelected(true);
		showreport.setSelected(true);
		showenquiry.setSelected(true);
		white.setSelected(true);
		
		this.getContentPane().setLayout(null);
		
		//Panel 1 construction
		p1.setBorder(BorderFactory.createLineBorder(Color.black));
		p1.setBounds(2,5,280,30);
		p1.setLayout(null);
		mtitle.setBounds(100,0,280,30);
		p1.add(mtitle);
		this.getContentPane().add(p1);
		
		//Panel 2 construction
		p2.setBorder(BorderFactory.createLineBorder(Color.black));
		p2.setBounds(2,38,280,30);
		p2.setLayout(null);
		btnadd.setBounds(16,5,75,20);
		btnsearch.setBounds(105,5,75,20);
		btnreport.setBounds(190,5,75,20);
		p2.add(btnadd);
		p2.add(btnsearch);
		p2.add(btnreport);
		this.getContentPane().add(p2);
		
		//Panel 3 construction
		p3.setBorder(BorderFactory.createLineBorder(Color.black));
		p3.setBounds(2,71,280,30);
		p3.setLayout(null);
		lblch.setBounds(5,5,90,20);
		chkmanager.setBounds(100,5,70,20);
		chkexec.setBounds(175,5,70,20);
		p3.add(lblch);
		p3.add(chkmanager);
		p3.add(chkexec);
		this.getContentPane().add(p3);
		
		//Panel 4 construction
		p4.setBorder(BorderFactory.createLineBorder(Color.black));
		p4.setBounds(2,104,280,218);
		p4.setLayout(null);	
		lblname.setBounds(5,10,90,20);
		txtname.setBounds(100,10,170,20);
		lblgender.setBounds(5,40,90,20);
		chkmale.setBounds(100,40,70,20);
		chkfemale.setBounds(175,40,70,20);
		lblsalary.setBounds(5,70,90,20);
		txtsalary.setBounds(100,70,170,20);
		lbladd.setBounds(5,100,90,20);
		txtadd.setBounds(100,100,170,50);
		txtadd.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtadd.setAutoscrolls(true);
		lbldep.setBounds(5,158,90,20);
		cbodep.setBounds(100,158,170,20);
		lbltitle.setBounds(5,188,90,20);
		txttitle.setBounds(100,188,170,20);
		p4.add(lblname);
		p4.add(txtname);
		p4.add(lblgender);
		p4.add(chkmale);
		p4.add(chkfemale);
		p4.add(lblsalary);
		p4.add(txtsalary);
		p4.add(lbladd);
		p4.add(txtadd);
		p4.add(lbldep);
		p4.add(cbodep);
		p4.add(lbltitle);
		p4.add(txttitle);
		this.getContentPane().add(p4);
		
		//Panel 5 construction
		p5.setBorder(BorderFactory.createLineBorder(Color.black));
		p5.setBounds(2,325,280,40);
		p5.setLayout(null);	
		btnone.setBounds(60,10,80,20);
		btntwo.setBounds(150,10,80,20);
		p5.add(btnone);p5.add(btntwo);
		this.getContentPane().add(p5);
		
		//Panel 6 construction
		p6.setBorder(BorderFactory.createTitledBorder("Report of Employee"));
		p6.setBounds(288,5,220,360);
		p6.setLayout(null);
		txtreport.setBounds(10,20,200,290);
		btnclose.setBounds(80,320,80,20);
		p6.add(txtreport);p6.add(btnclose);
		btnclose.setMnemonic('C');
		btnclose.addActionListener(this);
		txtreport.setEditable(false);
		this.getContentPane().add(p6);

		//Form construction
		cbodep.add("Admin");
		cbodep.add("Human Resource");
		cbodep.add("Account");
		cbodep.add("Sales");
		setTitle("Task 1");		
		setResizable(false);
		setBounds(200,80,290,424);
		setVisible(true);
		btnone.addActionListener(this);
		btntwo.addActionListener(this);
		btnadd.addActionListener(this);
		btnsearch.addActionListener(this);
		btnreport.addActionListener(this);
		chkexec.addItemListener(this);
		chkmanager.addItemListener(this);
		disable();
		btnone.setEnabled(false);
		btntwo.setEnabled(false);
		p1.setBackground(Color.white);
		p2.setBackground(Color.white);
		p3.setBackground(Color.white);
		p4.setBackground(Color.white);
		p5.setBackground(Color.white);
		p6.setBackground(Color.white);
		
	}
	
	//File menu construction
	public void FileItem()
	{
		bar.add(file);
		file.add(showcolor);
		file.addSeparator();
		file.add(showentry);
		file.add(showreport);
		file.add(showenquiry);
		file.addSeparator();
		file.add(exit);
		showcolor.addActionListener(this);
		showentry.addActionListener(this);
		showreport.addActionListener(this);
		showenquiry.addActionListener(this);
		exit.addActionListener(this);
	}
	
	//Entry menu construction
	public void EntryItem()
	{
		bar.add(entry);
		entry.add(EmployeeEntry);
		EmployeeEntry.addActionListener(this);
	}
	
	//Report menu construction
	public void ReportItem()
	{
		bar.add(report);
		report.add(EmployeeReport);
		EmployeeReport.addActionListener(this);
	}
	
	//Enquiry menu construction
	public void EnquiryItem()
	{
		bar.add(enquiry);
		enquiry.add(EmployeeSearch);
		EmployeeSearch.addActionListener(this);
	}
	
	//Color menu construction	
	public void ColorItem()
	{
		bar.add(Color1);
		Color1.add(red);
		Color1.add(white);
		Color1.add(green);
		Color1.add(yellow);
		Color1.add(blue);
		Color1.add(magenta);
		Color1.add(cyan);
		Color1.add(gray);
		Color1.add(light);
		Color1.add(pink);
		Color1.add(orange);
		
		group.add(red);
		group.add(green);
		group.add(white);
		group.add(yellow);
		group.add(blue);
		group.add(magenta);
		group.add(cyan);
		group.add(gray);
		group.add(light);
		group.add(pink);
		group.add(orange);
		
		red.addActionListener(this); 
		white.addActionListener(this);
		green.addActionListener(this);
		yellow.addActionListener(this);
		blue.addActionListener(this);
		magenta.addActionListener(this);
		cyan.addActionListener(this);
		gray.addActionListener(this);
		light.addActionListener(this);
		pink.addActionListener(this);
		orange.addActionListener(this);
	}
	
	//Menu bar construction
	public void buildmenu()
	{
		FileItem();
		ColorItem();
		EntryItem();
		ReportItem();
		EnquiryItem();
		setJMenuBar(bar);
	}
	
	//Disabling the form
	public void disable()
	{		
		txtname.setEnabled(false);
		txtsalary.setEnabled(false);
		txtadd.setEnabled(false);
		cbodep.setEnabled(false);
		txttitle.setEnabled(false);
		chkmale.setEnabled(false);
		chkfemale.setEnabled(false);
	}
	
	//Enabling the form
	public void enable()
	{		
		txtname.setEnabled(true);
		txtsalary.setEnabled(true);
		txtadd.setEnabled(true);
		cbodep.setEnabled(true);
		txttitle.setEnabled(true);
		chkmale.setEnabled(true);
		chkfemale.setEnabled(true);
	}
	
	//Clearing the data
	public void clear()
	{
		txtname.requestFocus(true);
		txtname.setText("");
		txtsalary.setText("");
		txtadd.setText("");
		cbodep.select("Admin");
		txttitle.setText("");
		chkmale.setState(true);
	}
	
	//Strating the Form
	public void start()
	{
		btnone.setLabel("Find");
		btntwo.setLabel("Clear");
		btnone.setMnemonic('F');
		btntwo.setMnemonic('C');
		btnone.setEnabled(true);
		btntwo.setEnabled(true);
		txtname.setEnabled(true);
		txtsalary.setEnabled(false);
		txtadd.setEnabled(false);
		cbodep.setEnabled(false);
		txttitle.setEnabled(false);
		chkmale.setEnabled(false);
		chkfemale.setEnabled(false);
	}
	
	//For the Add Button & Employee Entry Menu	
	public void add()
	{
		txtreport.setText("");
		this.setBounds(200,80,290,424);
		this.setVisible(true);
		chkexec.setState(true);
		txttitle.setVisible(true);
		lbltitle.setVisible(true);
		chkexec.setEnabled(true);
		chkmanager.setEnabled(true);
		str1="Add";
		btnadd.setEnabled(false);
		btnsearch.setEnabled(true);
		btnreport.setEnabled(true);
		EmployeeReport.setEnabled(true);
		btnone.setLabel("Save");
		btntwo.setLabel("Clear");
		btnone.setMnemonic('S');
		btntwo.setMnemonic('C');
		btnone.setEnabled(true);
		btntwo.setEnabled(true);
		clear();
		enable();
	}
	
	//For the Search Button & Employee Emquiry Menu	
	public void search()
	{
		txtreport.setText("");
		this.setBounds(200,80,290,424);
		this.setVisible(true);
		str1="Search";
		chkexec.setEnabled(false);
		chkmanager.setEnabled(false);
		btnadd.setEnabled(true);
		btnsearch.setEnabled(false);
		btnreport.setEnabled(true);
		EmployeeReport.setEnabled(true);
		chkexec.setState(true);
		txttitle.setVisible(true);
		lbltitle.setVisible(true);
		start();
		clear();
	}
	
	//For the Report Button & Employee Report Menu
	public void report()
	{
		chkexec.setEnabled(false);
		chkmanager.setEnabled(false);
		btnadd.setEnabled(true);
		btnsearch.setEnabled(true);
		btnreport.setEnabled(false);
		EmployeeReport.setEnabled(false);
		disable();
		clear();
		btnone.setEnabled(false);
		btntwo.setEnabled(false);
		chkexec.setState(true);
		txttitle.setVisible(true);
		lbltitle.setVisible(true);
		this.setBounds(200,80,520,424);
		this.setVisible(true);
		try
		{
			BufferedReader br1 = new BufferedReader(new FileReader("Employee.txt"));
			String str ="";
			String title ="";
			while((str = br1.readLine())!=null)
			{
				StringTokenizer stz = new StringTokenizer(str,"!");
				String name = (String)stz.nextToken();
				String post = (String)stz.nextToken();
				String gender = (String)stz.nextToken();
				String salary = (String)stz.nextToken();
				String add = (String)stz.nextToken();
				String dep = (String)stz.nextToken();
				if(post.equals("Executive"))
				{
					title = (String)stz.nextToken();
					txtreport.append("Name\t= "+name+"\n"+"Post\t= "+post+"\n"+"Gender\t= "+gender+"\n"+"Salary\t= "+salary+"\n"+"Address\t= "+add+"\n"+"Department = "+dep+"\n"+"Title\t= "+title+"\n\n");	
					e = new Executive(name,gender,Double.parseDouble(salary),add,dep,title);						
					System.out.println("Post = Executive\n" + e+"\n");	
				}
				else
				{
					txtreport.append("Name\t= "+name+"\n"+"Post\t= "+post+"\n"+"Gender\t= "+gender+"\n"+"Salary\t= "+salary+"\n"+"Address\t= "+add+"\n"+"Department = "+dep+"\n\n");
					m = new Manager(name,gender,Double.parseDouble(salary),add,dep);						
					System.out.println("Post = Manager\n" + m+"\n");	
				}
			}
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Can't Open File");
		}
	}
	
	//For Checking the null data
	public void data_checking1()
	{
		if(txtname.getText().equals(""))
		{
			str2 = "Name";
		}
		if(txtsalary.getText().equals(""))
		{
			str2 = str2 + " Salary";
		}
		if(txtadd.getText().equals(""))
		{
			str2 = str2 + " Address";
		}
	}
	
	public void data_checking2() 
	{
		data_checking1();
		if(txttitle.getText().equals(""))
		{
			str2 = str2 + " Title";
		}
	}
	
	//For checking not to duplicate the data
	public void duplication_test()
	{		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("Employee.txt"));
			String str1 ="";			
			while((str1 = br.readLine())!=null)
			{
				StringTokenizer stz = new StringTokenizer(str1,"!");
				if(stz.nextToken().equals(txtname.getText()))
				{
					tf=true;break;
				}
				
			}
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Can't Open File");
		}		
	}
	
	//For Saving the data in the file
	public void save()
	{
		duplication_test();
		if(tf == true)
		{
			JOptionPane.showMessageDialog(this,"Person has already existed!");
			txtname.requestFocus(true);
			tf=false;
		}
		else if(tf == false)
		{
			try 
			{	
				String gender;
				if(chkmale.getState()==true)
				gender = "Male";
				else
				gender = "Female";			
				if(chkmanager.getState()==true)
				{										
					data_checking1();		
					if(str2=="")
					{
						try
						{
							double d = Double.parseDouble(txtsalary.getText());							
						}catch(NumberFormatException nfe)
						{
							JOptionPane.showMessageDialog(this,"Can't Allow this format in Salary");
							return;
						}					
						BufferedWriter bw = new BufferedWriter(new FileWriter("Employee.txt",true));
						bw.write(txtname.getText()+ "!" +"Manager!"+ gender + "!" +txtsalary.getText()+ "!" +txtadd.getText() + "!" +cbodep.getSelectedItem()+System.getProperty("line.separator"));
						bw.close();
						m = new Manager(txtname.getText(),gender,Double.parseDouble(txtsalary.getText()),txtadd.getText(),cbodep.getSelectedItem());
						JOptionPane.showMessageDialog(this,"Successfully Save!");
			 			clear();
			 		}
					else
					{
						JOptionPane.showMessageDialog(this,"You have to add "+str2);
						str2="";
					}
				}
				else if(chkexec.getState()==true)
				{		
					data_checking2();
					if(str2=="")
					{	
						try
						{
							double d = Double.parseDouble(txtsalary.getText());							
						}catch(NumberFormatException nfe)
						{
							JOptionPane.showMessageDialog(this,"Can't Allow this format in Salary");
							return;
						}					
						BufferedWriter bw = new BufferedWriter(new FileWriter("Employee.txt",true));
						bw.write(txtname.getText()+ "!" +"Executive!"+ gender + "!" +txtsalary.getText()+ "!" +txtadd.getText() + "!" +cbodep.getSelectedItem()+ "!" +txttitle.getText()+System.getProperty("line.separator"));
						bw.close();
						e = new Executive(txtname.getText(),gender,Double.parseDouble(txtsalary.getText()),txtadd.getText(),cbodep.getSelectedItem(),txttitle.getText());
						JOptionPane.showMessageDialog(this,"Successfully Save!");
			 			clear();
					}
					else
					{
						JOptionPane.showMessageDialog(this,"You have to add "+str2);
						str2="";
					}					
				}		
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,"Can't Open File");
			}	
		}
		
	}
	
	//For Searching the data in the file
	public void searching()
	{
		try
		{
			BufferedReader br1 = new BufferedReader(new FileReader("Employee.txt"));
			String str ="";
			String gender="";
			while((str = br1.readLine())!=null)
			{
				StringTokenizer stz = new StringTokenizer(str,"!");
				if(stz.nextToken().equals(txtname.getText()))
				{
					if(stz.nextToken().equals("Executive"))
					{	
						chkexec.setState(true);
						txttitle.setVisible(true);
						lbltitle.setVisible(true);
					}
					else
					{
						chkmanager.setState(true);
						txttitle.setVisible(false);
						lbltitle.setVisible(false);
					}
					if(stz.nextToken().equals("Male"))
					{
						chkmale.setState(true);
						gender="Male";
					}
					else
					{
						chkfemale.setState(true);
						gender="Female";
					}
					txtsalary.setText((String)stz.nextToken());
					txtadd.setText((String)stz.nextToken());
					cbodep.select((String)stz.nextToken());
					if(chkexec.getState()==true)
					{
						txttitle.setText((String)stz.nextToken());
					}
					txtname.setEnabled(false);
					
					if(chkmanager.getState()==true)
					{
						m = new Manager(txtname.getText(),gender,Double.parseDouble(txtsalary.getText()),txtadd.getText(),cbodep.getSelectedItem());
						System.out.println("Post = Manager\n" + m +"\n");	
					}
					else
					{
						e = new Executive(txtname.getText(),gender,Double.parseDouble(txtsalary.getText()),txtadd.getText(),cbodep.getSelectedItem(),txttitle.getText());						
						System.out.println("Post = Executive\n" + e + "\n");	
					}
				}	
			}
			if(txtsalary.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Person is not Found!");
				txtname.requestFocus(true);	
			}				
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Can't Open File");
		}
	}
	
	public void close()
	{
		txtreport.setText("");
		this.setBounds(200,80,290,424);
		this.setVisible(true);
		btnreport.setEnabled(true);
		EmployeeReport.setEnabled(true);
	}
	
	//For Changing the Manger and Executive
	public void itemStateChanged(ItemEvent ie)
	{
		if(chkmanager.getState()==true)
		{
			txttitle.setVisible(false);
			lbltitle.setVisible(false);
			txtname.requestFocus(true);
		}
		else if(chkexec.getState()==true)
		{
			txttitle.setVisible(true);
			lbltitle.setVisible(true);
			txtname.requestFocus(true);
		}
	}
	
	//For Clicking Buttons and Menu
	public void actionPerformed(ActionEvent ae) 
	{
		//For Clicking the  Add Button
		if(ae.getSource().equals(btnadd))
		{
			add();
		}
		
		//For Clicking the  Employee Entry Menu
		if(ae.getSource().equals(EmployeeEntry))
		{
			add();
		}
		
		//For Clicking the Search Button
		if(ae.getSource().equals(btnsearch))
		{
			search();
		}
		
		//For Clicking the  Employee Search Menu
		if(ae.getSource().equals(EmployeeSearch))
		{
			search();
		}
		
		//For Clicking the  Report Button
		if(ae.getSource().equals(btnreport))
		{
			report();
		}
		
		//For Clicking the  Employee Report Menu
		if(ae.getSource().equals(EmployeeReport))
		{
			report();
		}
		
		if(ae.getSource().equals(btnone))
		{
			//For Clicking the Save Button
			if(str1=="Add")
			{
				int y=JOptionPane.showConfirmDialog(null,"Do You Want to Save?","Warning!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		 		if(y==JOptionPane.YES_OPTION)
		 		{
	 				save();
		 		}	
			}
			//For Clicking the Find Button
			else if(str1=="Search")
			{
				if(txtname.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this,"Please Enter the Name You Want to Find!");
				}
				else
				{
					searching();
				}
			}
		}
		
		if(ae.getSource().equals(btntwo))
		{
			//For Clicking the Clear Button	after clicking the add button
			if(str1=="Add")
			{
				int y=JOptionPane.showConfirmDialog(null,"Do You Want to Clear?","Warning!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
	 			if(y==JOptionPane.YES_OPTION)
	 			{				
					clear();				
				}
			}
			//For Clicking the Clear Button	after clicking the search button
			else if(str1=="Search")
			{
				int y=JOptionPane.showConfirmDialog(null,"Do You Want to Clear?","Warning!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
	 			if(y==JOptionPane.YES_OPTION)
	 			{				
					clear();
					txtname.setEnabled(true);
					chkexec.setState(true);
					txttitle.setVisible(true);
					lbltitle.setVisible(true);
				}
			}
		}
		
		//For Clicking the Exit Menu
		if(ae.getActionCommand().equals("Exit"))
		{
			int y=JOptionPane.showConfirmDialog(null,"Do You Want to Exit?","Warning!",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
	 		if(y==JOptionPane.YES_OPTION)
	 		{	
				System.exit(0);		  
			}
		}
		
		//For Clicking the Show Color CheckBox Menu	
		if(ae.getActionCommand().equals("Show Color"))
		{
			Color1.setVisible(showcolor.isSelected());
		}
		
		//For Clicking the Show Entry CheckBox Menu
		if(ae.getActionCommand().equals("Show Entry"))
		{
			entry.setVisible(showentry.isSelected());
		}
		
		//For Clicking the Show Enquiry CheckBox Menu
		if(ae.getActionCommand().equals("Show Enquiry"))
		{
			enquiry.setVisible(showenquiry.isSelected());
		}
		
		//For Clicking the Show Report CheckBox Menu	
		if(ae.getActionCommand().equals("Show Report"))
		{
			report.setVisible(showreport.isSelected());
		}	
		
		// For Clicking the red color radio menu
		if(ae.getActionCommand().equals("Red"))
		{
			p1.setBackground(Color.red);
			p2.setBackground(Color.red);
			p3.setBackground(Color.red);
			p4.setBackground(Color.red);
			p5.setBackground(Color.red);
			p6.setBackground(Color.red);
		}
		
		// For Clicking the White color radio menu
		if(ae.getActionCommand().equals("White"))
		{
			p1.setBackground(Color.white);
			p2.setBackground(Color.white);
			p3.setBackground(Color.white);
			p4.setBackground(Color.white);
			p5.setBackground(Color.white);
			p6.setBackground(Color.white);
		}
		
		// For Clicking the Green color radio menu
		if(ae.getActionCommand().equals("Green"))
		{
			p1.setBackground(Color.green);
			p2.setBackground(Color.green);
			p3.setBackground(Color.green);
			p4.setBackground(Color.green);
			p5.setBackground(Color.green);
			p6.setBackground(Color.green);
		}
		
		// For Clicking the Yellow color radio menu
		if(ae.getActionCommand().equals("Yellow"))
		{
			p1.setBackground(Color.yellow);
			p2.setBackground(Color.yellow);
			p3.setBackground(Color.yellow);
			p4.setBackground(Color.yellow);
			p5.setBackground(Color.yellow);
			p6.setBackground(Color.yellow);
		}
		
		// For Clicking the Blue color radio menu
		if(ae.getActionCommand().equals("Blue"))
		{
			p1.setBackground(Color.blue);
			p2.setBackground(Color.blue);
			p3.setBackground(Color.blue);
			p4.setBackground(Color.blue);
			p5.setBackground(Color.blue);
			p6.setBackground(Color.blue);
		}
		
		// For Clicking the Magenta color radio menu
		if(ae.getActionCommand().equals("Magenta"))
		{
			p1.setBackground(Color.magenta);
			p2.setBackground(Color.magenta);
			p3.setBackground(Color.magenta);
			p4.setBackground(Color.magenta);
			p5.setBackground(Color.magenta);
			p6.setBackground(Color.magenta);
		}
		
		// For Clicking the Cyan color radio menu
		if(ae.getActionCommand().equals("Cyan"))
		{
			p1.setBackground(Color.cyan);
			p2.setBackground(Color.cyan);
			p3.setBackground(Color.cyan);
			p4.setBackground(Color.cyan);
			p5.setBackground(Color.cyan);
			p6.setBackground(Color.cyan);
		}
		
		// For Clicking the Gray color radio menu
		if(ae.getActionCommand().equals("Gray"))
		{
			p1.setBackground(Color.gray);
			p2.setBackground(Color.gray);
			p3.setBackground(Color.gray);
			p4.setBackground(Color.gray);
			p5.setBackground(Color.gray);
			p6.setBackground(Color.gray);
		}
		
		// For Clicking the LightGray color radio menu
		if(ae.getActionCommand().equals("LightGray"))
		{
			p1.setBackground(Color.lightGray);
			p2.setBackground(Color.lightGray);
			p3.setBackground(Color.lightGray);
			p4.setBackground(Color.lightGray);
			p5.setBackground(Color.lightGray);
			p6.setBackground(Color.lightGray);
		}
		
		// For Clicking the pink color radio menu
		if(ae.getActionCommand().equals("Pink"))
		{
			p1.setBackground(Color.pink);
			p2.setBackground(Color.pink);
			p3.setBackground(Color.pink);
			p4.setBackground(Color.pink);
			p5.setBackground(Color.pink);
			p6.setBackground(Color.pink);
		}
		
		// For Clicking the orange color radio menu
		if(ae.getActionCommand().equals("Orange"))
		{
			p1.setBackground(Color.orange);
			p2.setBackground(Color.orange);
			p3.setBackground(Color.orange);
			p4.setBackground(Color.orange);
			p5.setBackground(Color.orange);
			p6.setBackground(Color.orange);
		}
		
		// For Closing the report textarea
		if(ae.getSource().equals(btnclose))
		{
			close();
		}
				
	}
	
	public static void main(String args[])
	{
		task1 e = new task1();		
	}
	
}

class Employee
{
	String name,gender,address;
	double salary;
	Employee(String n,String g,double s,String a)
	{
		name = n;		
		gender = g;
		salary = s;
		address = a;
	}
	public String toString()
	{
		return ("Name = "+name+"\nGender = "+gender+"\nSalary = "+salary+"\nAddress = "+address);
	}
	
}

class Manager extends Employee
{
	String department;
	Manager(String n,String g,double s,String a,String d)
	{
		super(n,g,s,a);
		department = d;
	}
	public String toString()
	{
		return (super.toString()+"\nDepartment = "+department);
	}
}

class Executive extends Manager
{
	String title;
	Executive(String n,String g,double s,String a,String d,String t)
	{
		super(n,g,s,a,d);
		title = t;
	}
	public String toString()
	{
		return (super.toString()+"\nTitle = "+title);
	}	
}												