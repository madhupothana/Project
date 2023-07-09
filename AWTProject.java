package AWTProject;
import java.util.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
class Change {
	public void Run(ArrayList<Employee> AL, Writer FL) throws IOException {
		int i = 0;
		while (i < AL.size()) {
			Employee e = AL.get(i);
			String s;
			s = e.getName() + "," + e.getEmpNum() + "," + e.getJob() + "," + e.getDepart() + "," + e.getSal() + "\n";
			FL.write(s);
			i++;
		}
	}
}
class Employee {
	private String EmpNum, Name, Job, Depart, sal;
	public Employee(String name, String empNum, String job, String sal, String depart) {
		EmpNum = empNum;
		Name = name;
		Job = job;
		Depart = depart;
		this.sal = sal;
	}
	public String getDepart() {return Depart;}
	public String getEmpNum() {return EmpNum;}
	public String getJob() {return Job;}
	public String getName() {return Name;}
	public String getSal() {return sal;}
	public void setDepart(String depart) {Depart = depart;}
	public void setEmpNum(String empNum) {EmpNum = empNum;}
	public void setJob(String job) {Job = job;}
	public void setName(String name) {Name = name;}
	public void setSal(String sal) {this.sal = sal;}
	public void Run(ArrayList<Employee> AL, Writer FL) throws IOException {
		int i = 0;
		while (i < AL.size()) {
			Employee e = AL.get(i);
			String s;
			s = e.getName() + "," + e.getEmpNum() + "," + e.getJob() + "," + e.getDepart() + "," + e.getSal() + "\n";
			FL.write(s);
			i++;
		}
	}
}
class Position {
	private int pos;
	public Position(int a) {pos = a;}
	public int getPos() {return pos;}
	public void setPos(int pos) {this.pos = pos;}
}
class Searching {
	public Employee search(ArrayList<Employee> AL, int p, String tar) {
		String s = "", q = "";
		int i = 0;
		while (i < AL.size()) {
			Employee e = AL.get(i);
			if (p == 0) {
				q = e.getName();
			} else if (p == 1) {
				q = e.getEmpNum();
			} else if (p == 2) {
				q = e.getJob();
			} else if (p == 3) {
				q = e.getSal();
			} else {
				q = e.getDepart();
			}
			if (q.equals(tar)) {
				return e;
			}
			i++;
		}
		return null;
	}
}
class AddEdit {
	String AE;
	public AddEdit(String aE) {AE = aE;}
	public String getAE() {return AE;}
	public void setAE(String aE) {AE = aE;}
}
public class Project {
	public static void main(String[] args) throws Exception {
		Position p = new Position(0);
		Searching Search = new Searching();
		Change Change = new Change();
		AddEdit AE = new AddEdit("Normal");
		Frame F = new Frame();
		Color skyBlue = new Color(135, 206, 235);
		File FI = new File("C:\\Users\\pothana madhu\\eclipse-workspace\\Java\\src\\Employees.txt");
		ArrayList<Employee> AL = new ArrayList<>();
		Reader R = new FileReader(FI);
		BufferedReader BR = new BufferedReader(R);
		String t;
		while ((t = BR.readLine()) != null) {
			StringTokenizer ST = new StringTokenizer(t, ",");
			Employee T = new Employee("", "", "", "", "");
			int j = 0;
			while (ST.hasMoreTokens()) {

				String s = ST.nextToken();
				System.out.println(s);
				if (j == 0)
					T.setName(s);
				else if (j == 1)
					T.setEmpNum(s);
				else if (j == 2)
					T.setJob(s);
				else if (j == 3)
					T.setDepart(s);
				else
					T.setSal(s);
				j++;
			}
			AL.add(T);
		}
		F.setBackground(skyBlue);
		F.setTitle("EmployeesBlock");
		F.setSize(700, 700);
		F.setLayout(null);
		F.setVisible(true);
		Button b1 = new Button("First");
		Button b2 = new Button("Next");
		Button b3 = new Button("Prev");
		Button b4 = new Button("Last");
		Button b5 = new Button("Add");
		Button b6 = new Button("Edit");
		Button b7 = new Button("Delete");
		Button b8 = new Button("Save");
		Button b9 = new Button("Search");
		Button b10 = new Button("Clear");
		Button b11 = new Button("Exit");
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
		b1.setBounds(200, 400, 50, 30);
		b2.setBounds(260, 400, 50, 30);
		b3.setBounds(320, 400, 50, 30);
		b4.setBounds(380, 400, 50, 30);
		b5.setBounds(200, 440, 50, 30);
		b6.setBounds(260, 440, 50, 30);
		b7.setBounds(320, 440, 50, 30);
		b8.setBounds(380, 440, 50, 30);
		b9.setBounds(230, 480, 50, 30);
		b10.setBounds(290, 480, 50, 30);
		b11.setBounds(350, 480, 50, 30);
		F.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				F.dispose();
			}
		});
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t4 = new TextField();
		TextField t3 = new TextField();
		TextField t5 = new TextField();
		t1.setBounds(300, 160, 170, 30);
		t2.setBounds(300, 200, 170, 30);
		t3.setBounds(300, 240, 170, 30);
		t4.setBounds(300, 280, 170, 30);
		t5.setBounds(300, 320, 170, 30);
		F.add(t1);
		F.add(t2);
		F.add(t3);
		F.add(t4);
		F.add(t5);
		Label l2 = new Label("Employee Number   :");
		Label l1 = new Label("Employee Name :");
		Label l3 = new Label("Job Role        :");
		Label l4 = new Label("Salary Amount   :");
		Label l5 = new Label("Department      :");
		l1.setBounds(150, 160, 150, 30);
		l2.setBounds(150, 200, 150, 30);
		l3.setBounds(150, 240, 150, 30);
		l4.setBounds(150, 280, 150, 30);
		l5.setBounds(150, 320, 150, 30);
		F.add(l1);
		F.add(l2);
		F.add(l3);
		F.add(l4);
		F.add(l5);
		Choice ch1 = new Choice();
		ch1.setBounds(550, 100, 70, 30);
		F.add(ch1);
		ch1.add("Read");
		ch1.add("Edit");
		ch1.add("Add");
		ch1.add("Delete");
		if (AL.size() > 0) {
			t1.setText(AL.get(0).getName());
			t2.setText(AL.get(0).getEmpNum());
			t3.setText(AL.get(0).getJob());
			t4.setText(AL.get(0).getSal());
			t5.setText(AL.get(0).getDepart());
		}
		// First Button
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (p.getPos() != -1 || AL.size()!=0) {
					t1.setText(AL.get(0).getName());
					t2.setText(AL.get(0).getEmpNum());
					t3.setText(AL.get(0).getJob());
					t4.setText(AL.get(0).getSal());
					t5.setText(AL.get(0).getDepart());
				} else {
					JOptionPane.showMessageDialog(F, "No Employees");
				}
			}
		});

		// Next Button
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (0 == AL.size()) {
					JOptionPane.showMessageDialog(F, "No Employees.");
					return;
				}
				int l = p.getPos() + 1;
				if (l == AL.size()) {
					JOptionPane.showMessageDialog(F, "You Reached to end.");
				} else {
					t1.setText(AL.get(l).getName());
					t2.setText(AL.get(l).getEmpNum());
					t3.setText(AL.get(l).getJob());
					t4.setText(AL.get(l).getSal());
					t5.setText(AL.get(l).getDepart());
					p.setPos(l);
				}
			}
		});
		// prev Button
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (0 == AL.size()) {
					JOptionPane.showMessageDialog(F, "No Employees.");
					return;
				}
				int l = p.getPos() - 1;
				if (l == -1) {
					JOptionPane.showMessageDialog(F, "No Previous Record,You are at first Record");
				} else {
					t1.setText(AL.get(l).getName());
					t2.setText(AL.get(l).getEmpNum());
					t3.setText(AL.get(l).getJob());
					t4.setText(AL.get(l).getSal());
					t5.setText(AL.get(l).getDepart());
					p.setPos(l);
				}
			}
		});
		// Last Button
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (0 == AL.size()) {
					JOptionPane.showMessageDialog(F, "No Employees.");
					return;
				}
				int l = AL.size() - 1;
				t1.setText(AL.get(l).getName());
				t2.setText(AL.get(l).getEmpNum());
				t3.setText(AL.get(l).getJob());
				t4.setText(AL.get(l).getSal());
				t5.setText(AL.get(l).getDepart());
				p.setPos(l);
			}
		});
		// Add Button
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!ch1.getItem(ch1.getSelectedIndex()).equals("Add"))
				{
					JOptionPane.showMessageDialog(F, "You are not in Add Mode");	
					return;
				}
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				AE.setAE("Add");
			}
		});
		// Edit Button
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!ch1.getItem(ch1.getSelectedIndex()).equals("Edit"))
				{
					JOptionPane.showMessageDialog(F, "You are not in Edit Mode");	
					return;
				}
				System.out.println(p.getPos());
				t1.setText(t1.getText());
				t2.setText(t2.getText());
				t3.setText(t3.getText());
				t4.setText(t4.getText());
				t5.setText(t5.getText());
				AE.setAE("Edit");

			}
		});
		// Delete Button
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Writer W = new FileWriter(FI);
				BufferedWriter WR=new BufferedWriter(W);
				if(!ch1.getItem(ch1.getSelectedIndex()).equals("Delete"))
				{
					JOptionPane.showMessageDialog(F, "You are not in Delete Mode");	
					return;
				}
				int l = p.getPos();
				if (AL.size() != 0) {
					JOptionPane.showMessageDialog(F, AL.get(l).getEmpNum() + " is Deleted");
					p.setPos(0);
					AL.remove(l);
					if (l == 0) {
						l = 1;
					}
				} else {
					JOptionPane.showMessageDialog(F, "No Employees");
					return;
				}
				if (AL.size() != 0) {
					l = 0;
					t1.setText(AL.get(l).getName());
					t2.setText(AL.get(l).getEmpNum());
					t3.setText(AL.get(l).getJob());
					t4.setText(AL.get(l).getSal());
					t5.setText(AL.get(l).getDepart());
				} else {
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					p.setPos(-1);
				}
				Change.Run(AL, W);
				W.flush();
				p.setPos(AL.size()-1);			}
			catch(IOException e1) {
					e1.printStackTrace();
			}
			}

		});
		// Save button
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Writer W = new FileWriter(FI);
					BufferedWriter WR=new BufferedWriter(W);
					if (t1.getText().length() != 0 && t2.getText().length() != 0 && t3.getText().length() != 0
							&& t4.getText().length() != 0 && t5.getText().length() != 0) {
						if (AE.getAE().equals("Edit")) {
							AL.get(p.getPos()).setName(t1.getText());
							AL.get(p.getPos()).setEmpNum(t2.getText());
							AL.get(p.getPos()).setJob(t3.getText());
							AL.get(p.getPos()).setSal(t4.getText());
							AL.get(p.getPos()).setDepart(t5.getText());
							JOptionPane.showMessageDialog(F, "Done!");

						} else if (AE.getAE().equals("Normal")) {
							JOptionPane.showMessageDialog(F, "You are not in Editing or Adding Mode");
						} else {
							Employee T = new Employee("", "", "", "", "");
							T.setName(t1.getText());
							T.setEmpNum(t2.getText());
							T.setJob(t3.getText());
							T.setSal(t4.getText());
							T.setDepart(t5.getText());
							AL.add(T);
						}
						Change.Run(AL, W);
						W.flush();

					} else {
						JOptionPane.showMessageDialog(F, "Enter All The Fileds");
					}
					AE.setAE("Normal");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		// Search Button
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int f = 0;
				String s1 = t1.getText();
				String s2 = t2.getText();
				String s3 = t3.getText();
				String s4 = t4.getText();
				String s5 = t5.getText();
				Employee res = null;
				if (s1.length() > 0) {
					res = Search.search(AL, 0, s1);
				} else if (s2.length() > 0) {
					res = Search.search(AL, 1, s2);
				} else if (s3.length() > 0) {
					res = Search.search(AL, 2, s3);
				} else if (s4.length() > 0) {
					res = Search.search(AL, 3, s4);
				} else if (s5.length() > 0) {
					res = Search.search(AL, 4, s4);
				} else {
					f = 1;
					JOptionPane.showMessageDialog(F, "Enter Atleast One Field");
					return;
				}
				if (f == 0) {
					if (res != null) {
						t1.setText(res.getName());
						t2.setText(res.getEmpNum());
						t3.setText(res.getJob());
						t4.setText(res.getSal());
						t5.setText(res.getDepart());
					} else {
						JOptionPane.showMessageDialog(F, "There is no file like that");
					}
				}
			}
		});
		// Clear Button
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
			}
		});
		//Exit Button
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F.dispose();
			}
		});
	}
}
