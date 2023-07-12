package AWTProject;



import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;


import java.time.LocalDate;

import java.time.LocalDate;
class Transaction {
	private int transno;
	private int accno;
	private LocalDate transdate;
	private String transtype;
	private double tamount;

	public Transaction(String transno, String accno, String transdate, String transtype, String tamount) {
		super();
		this.transno = Integer.parseInt(transno);
		this.accno = Integer.parseInt(accno);
		this.transdate = LocalDate.parse(transdate);
		this.transtype = transtype;
		this.tamount = Double.parseDouble(tamount);
	}

	public int getTransno() {
		return transno;
	}

	public void setTransno(int transno) {
		this.transno = transno;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public LocalDate getTransdate() {
		return transdate;
	}

	public void setTransdate(LocalDate transdate) {
		this.transdate = transdate;
	}

	public String getTranstype() {
		return transtype;
	}

	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}

	public double getTamount() {
		return tamount;
	}

	public void setTamount(double tamount) {
		this.tamount = tamount;
	}

}
class Acc {
	private int accno;
	private String type;
	private LocalDate openingdate;
	private double openingbal;

	public Acc(String accno, String type, String openingdate, String openingbal) {
		this.accno = Integer.parseInt(accno);
		this.type = type;
		this.openingdate = LocalDate.parse(openingdate);
		this.openingbal = Double.parseDouble(openingbal);
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getOpeningdate() {
		return openingdate;
	}

	public void setOpeningdate(String openingdate) {
		this.openingdate = LocalDate.parse(openingdate);
	}

	public double getOpeningbal() {
		return openingbal;
	}

	public void setOpeningbal(double openingbal) {
		this.openingbal = openingbal;
	}

}
public class Bankintrest {
	public static ArrayList<Transaction> alltrans(ArrayList<Transaction> t, Acc c) {
		ArrayList<Transaction> tra = new ArrayList<>();
		for (int i = 0; i < t.size(); i++) {
			if ((t.get(i).getAccno()) == c.getAccno()) {
				tra.add(t.get(i));
			}
		}
		// System.out.println(tra.size() + " size of transaction");
		return tra;
	}

	public static double getBalanceAsOndate(Acc a, LocalDate dt, ArrayList<Transaction> tra) {
		double bal = a.getOpeningbal();
		int i = tra.size() - 1;
		//System.out.println(i);
		while (i != -1) {
			//System.out.println(dt.compareTo(tra.get(i).getTransdate())+" "+dt+" "+tra.get(i).getTransdate());
			if (dt.compareTo(tra.get(i).getTransdate())<=0) {
				
				if (tra.get(i).getTranstype().equals("c")) {
					bal -= tra.get(i).getTamount();
				} else {
					bal += tra.get(i).getTamount();
				}
			}
			i--;
			
		}
		return bal;
	}

		

	public static double getMinbalance(Acc a, ArrayList<Transaction> tra, LocalDate dt) {
		double currbal= getBalanceAsOndate(a, LocalDate.of(dt.getYear(), dt.getMonthValue(), 10), tra);
		double minbal=currbal;
		for (int i = 0; i < tra.size(); i++) {
			if (dt.getYear() == tra.get(i).getTransdate().getYear() && dt.getMonth() == tra.get(i).getTransdate().getMonth()) {

				if (tra.get(i).getTransdate().getDayOfMonth() > 10 && dt.getMonth().equals(tra.get(i).getTransdate().getMonth())) {
					
					//System.out.println("diffrence in months" + currbal + "   " + dt.getMonthValue());
					if (tra.get(i).getTranstype().equals("c")) {
						currbal = currbal + tra.get(i).getTamount();
					} else {
						currbal = currbal - tra.get(i).getTamount();
					}
					if (minbal >currbal) {
						minbal = currbal;
					}
					//dt=dt.minusMonths(1);
				}//System.out.println("this");
			}
		}
		//System.out.println(minbal+"  "+"minballl");
		return minbal;
	}

	public static double getcalIntrest(Acc a, ArrayList<Transaction> tra) {
		double intrest = 0;
		int months;

		LocalDate curentdate = LocalDate.now().minusMonths(1);
		int x = curentdate.getMonthValue();
		// long monthsBetween = ChronoUnit.MONTHS.between(curentdate, a.getOpeningdate());
		// System.out.println("diffrence in months" + monthsBetween);
		int day = curentdate.getDayOfMonth();
		Period p = Period.between(a.getOpeningdate(), curentdate);
		int monthsBetween1 = (int) p.toTotalMonths();
		if (monthsBetween1 > 6) {
			months = 6;
		} else {
			months = (int) monthsBetween1;
		}
		int i = 1;
		double totmin;
		// System.out.println(months + "hi");
		while (i <= months) {
		// System.out.println(months + " hello");
			if (curentdate.getDayOfMonth() - i >= 10 && a.getOpeningdate().compareTo(curentdate) <= 0
					&& monthsBetween1 < 6) {
				
				totmin = getMinbalance(a, tra, curentdate);
				//System.out.println(totmin+" "+curentdate);
				// System.out.println(totmin + " " + a);
				i++;
				intrest += (totmin * 0.375) / 1200;

			} else {
				totmin = getMinbalance(a, tra, curentdate);
				//System.out.println(totmin+" "+curentdate);
				intrest += (totmin * 0.375) / 1200;
				i++;
			}
			curentdate=curentdate.minusMonths(1);
			//System.out.println(intrest + " " + totmin);

		}

		return intrest;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
				new FileReader("C:\\Users\\pothana madhu\\eclipse-workspace\\Java\\src\\Output.txt"));
		ArrayList<Acc> a1 = new ArrayList<>();
		String str = "";
		while ((str = br.readLine()) != null) {
			String s[] = str.split(",");
			//System.out.println(s[2]);
			a1.add(new Acc(s[0], s[1], s[2], s[3]));
		}

		BufferedReader brr = new BufferedReader(
				new FileReader("C:\\Users\\pothana madhu\\eclipse-workspace\\Java\\src\\Employees.txt"));
		ArrayList<Transaction> a2 = new ArrayList<>();
		String strr = "";
		while ((strr = brr.readLine()) != null) {
			String aa[] = strr.split(",");
			 //System.out.println(aa[2]);
			a2.add(new Transaction(aa[0], aa[1], aa[2], aa[3], aa[4]));
		}
		//System.out.println(getBalanceAsOndate(a1.get(0), LocalDate.of(2023, 01, 01), alltrans(a2, a1.get(0))));
		//System.out.println(getMinbalance(a1.get(0), alltrans(a2, a1.get(0)),LocalDate.of(2023, 06, 01)));
		for (int i=0;i<a1.size();i++) {
		double it = Bankintrest.getcalIntrest(a1.get(i), alltrans(a2, a1.get(i)));
		System.out.println("intrest for the account:"+a1.get(i).getAccno()+"  "+it);
		}

	}
}
