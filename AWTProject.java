package AWT;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
class Employee{
	private String EmpNum,Name,Job,Depart;
	Double sal;
	public Employee(String empNum, String name, String job, String depart, Double sal) {
		EmpNum = empNum;
		Name = name;
		Job = job;
		Depart = depart;
		this.sal = sal;
	}
	public String getEmpNum() {
		return EmpNum;
	}
	public void setEmpNum(String empNum) {
		EmpNum = empNum;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	public String getDepart() {
		return Depart;
	}
	public void setDepart(String depart) {
		Depart = depart;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
}
public class Project{
	public static void main(String[] args) throws Exception {
		Frame F=new Frame();
		Color skyBlue = new Color(135, 206, 235);
		File FI=new File("C:\\Users\\madhu.p\\eclipse-workspace\\Collections\\src\\AWT\\Employees.txt");
		ArrayList<Employee> AL=new ArrayList<>();
		Reader R=new FileReader(FI);
		BufferedReader BR=new BufferedReader(R); 
		String t;
		while((t=BR.readLine())!=null) {
			StringTokenizer ST=new StringTokenizer(t,",");
			Employee T=new Employee("","","","",0.0);
			int i=0;
			while(ST.hasMoreTokens()) {
				String s=ST.nextToken();
				if(i==0)
				T.setEmpNum(s);
				else if(i==1)
				T.setEmpNum(s);
				else if(i==2)
				T.setEmpNum(s);
				else if(i==3)
				T.setEmpNum(s);
				else
				T.setEmpNum(s);
				i++;	
			}
			AL.add(T);
		}
		System.out.println(AL.toString());
        F.setBackground(skyBlue);
		F.setTitle("EmployeesBlock");
		F.setSize(700,700);
		F.setLayout(null);
		F.setVisible(true);
		Button b1=new Button("First");
		Button b2=new Button("Next");
		Button b3=new Button("Prev");
		Button b4=new Button("Last");
		Button b5=new Button("Add");
		Button b6=new Button("Edit");
		Button b7=new Button("Delete");
		Button b8=new Button("Save");
		Button b9=new Button("Search");
		Button b10=new Button("Clear");
		Button b11=new Button("Exit");
		F.add(b1);
		F.add(b2);
		F.add(b3);
		F.add(b4);
		F.add(b5);
		F.add(b6);
		F.add(b7);
		F.add(b8);
		F.add(b9);
		F.add(b10);
		F.add(b11);
		b1.setBounds(200,400,50,30);
		b2.setBounds(260,400,50,30);
		b3.setBounds(320,400,50,30);
		b4.setBounds(380,400,50,30);
		b5.setBounds(200,440,50,30);
		b6.setBounds(260,440,50,30);
		b7.setBounds(320,440,50,30);
		b8.setBounds(380,440,50,30);
		b9.setBounds(230,480,50,30);
		b10.setBounds(290,480,50,30);
		b11.setBounds(350,480,50,30);
		F.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                F.dispose();
            }
        });
		b11.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				 F.dispose();
				
			}
        });
		
		TextField t1=new TextField();
		TextField t2=new TextField();
		TextField t4=new TextField();
		TextField t3=new TextField();
		TextField t5=new TextField();
		t1.setBounds(300,160,170,30);
		t5.setBounds(300,320,170,30);
		t2.setBounds(300,200,170,30);
		t3.setBounds(300,240,170,30);
		t4.setBounds(300,280,170,30);
		F.add(t1);
		F.add(t2);
		F.add(t3);
		F.add(t4);
		F.add(t5);
		Label l1=new Label("Employee Name   :");
		Label l2=new Label("Employee Number :");
		Label l3=new Label("Job Role        :");
		Label l4=new Label("Salary Amount   :");
		Label l5=new Label("Department      :");
		l1.setBounds(150,160,150,30);
		l2.setBounds(150,200,150,30);
		l3.setBounds(150,240,150,30);
	 	l4.setBounds(150,280,150,30);
	 	l5.setBounds(150,320,150,30);
		F.add(l1);
		F.add(l2);
		F.add(l3);
		F.add(l4);
		F.add(l5);
		Choice ch1=new Choice();
		ch1.setBounds(550, 100, 70, 30);
		F.add(ch1);
		ch1.add("Edit");
		ch1.add("Add");
		ch1.add("Delete");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		b5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				 t1.setText("");
				 t2.setText("");
				 t3.setText("");
				 t4.setText("");
				 t5.setText("");
				
			}
        });
		b6.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				 
			}
        });
		
	}
}
