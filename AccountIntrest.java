package DateTime;
import java.io.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
public class AccountIntrest {
	static float Rate = 4.5f;
	public static double getMinBal(LocalDate First,double curbal,ArrayList<Transactions> T) {
		double res=curbal;
		for(Transactions t:T) {
			if(First.getYear()==t.getTDate().getYear() && First.getMonthValue()==t.getTDate().getMonthValue()) {
				if(t.getTType().equals("DM")) {
					curbal=curbal+t.gettAmt();
				}
				else {
					curbal=curbal-t.gettAmt();
				}
				if(res>curbal) {
					res=curbal;
				}
			}
		}
		return res;
	}
	public static double BalOnDate(LocalDate Date, ArrayList<Transactions> T, double cur) {
		int i = T.size() - 1;
		while (i!=-1) {
			Transactions X = T.get(i);
			if (X.getTDate().compareTo(Date)>-1) {
				if (X.getTType().equals("DM")) {
					cur = cur - X.gettAmt();
				} else {
					cur = cur + X.gettAmt();
				}
			} else {
				return cur;
			}
			i--;
		}
		return cur;
	}
	public static double calIntrest(Account A, ArrayList<Transactions> T) {
		double res=0;
		LocalDate CD = LocalDate.now();
		CD = CD.minusMonths(1);
		LocalDate AccOpenD = A.getOpenDate();
		int day = AccOpenD.getDayOfMonth();
		if (day > 10) {
			AccOpenD = AccOpenD.plusMonths(1);
		}
		long monthsdiff = ChronoUnit.MONTHS.between(AccOpenD, CD);
		int months = 0;
		if (monthsdiff > 6)
			months = 6;
		else
			months = (int) monthsdiff;
		int y=6;
		while (months != -1 && y!=0) {
			LocalDate onday = LocalDate.of(CD.minusMonths(months).getYear(), CD.minusMonths(months).getMonth(), 1);
			double balFirst = AccountIntrest.BalOnDate(onday, T, A.getCurBal());
			double minbal=AccountIntrest.getMinBal(onday,balFirst,T);
			//System.out.println(minbal+" "+onday+" "+balFirst);
			res+=(minbal*0.375)/1200;
			months--;
			y--;
		}
		return res;
	}
	public static void main(String[] args) throws Exception {
		File AccF = new File("C:\\Users\\madhu.p\\eclipse-workspace\\Collections\\src\\DateTime\\AccountList.txt");
		FileReader FR = new FileReader(AccF);
		BufferedReader BR = new BufferedReader(FR);
		ArrayList<Account> AccList = new ArrayList<>();
		String sa;
		while ((sa = BR.readLine()) != null) {
			StringTokenizer ST = new StringTokenizer(sa, ",");
			String[] temp = new String[4];
			int i = 0;
			while (ST.hasMoreTokens()) {
				temp[i] = ST.nextToken();
				i++;
			}
			if (temp[1].equals("SA")) {
				Account A = new Account(temp[0], temp[1], temp[2], Double.parseDouble(temp[3]));
				AccList.add(A);
			}
		}
		FR = null;
		BR = null;
		File TraF = new File("C:\\\\Users\\\\madhu.p\\\\eclipse-workspace\\\\Collections\\\\src\\\\DateTime\\\\TransactionList.txt");
		FR = new FileReader(TraF);
		BR = new BufferedReader(FR);
		HashMap<String, ArrayList<Transactions>> TrabyAcc = new HashMap<>();
		String st;
		while ((st = BR.readLine()) != null) {
			StringTokenizer ST = new StringTokenizer(st, ",");
			String[] temp = new String[5];
			int i = 0;
			while (ST.hasMoreTokens()) {
				temp[i] = ST.nextToken();
				i++;
			}
			Transactions T = new Transactions(temp[0], temp[1], temp[2], temp[3], Double.parseDouble(temp[4]));
			if (TrabyAcc.containsKey(temp[1])) {
				ArrayList<Transactions> TH = TrabyAcc.get(temp[1]);
				TH.add(T);
				TrabyAcc.put(temp[1], TH);
			} else {
				ArrayList<Transactions> TH = new ArrayList<>();
				TH.add(T);
				TrabyAcc.put(temp[1], TH);
			}

		}
		// All Transactions are Listed into hashmap as (Account,TransactionObject)
		for (Account A : AccList) {
			double INTREST = AccountIntrest.calIntrest(A, TrabyAcc.get(A.getAccNum()));
			String s="Intrest of "+A.getAccNum()+" : "+INTREST+"\n";
			FileWriter FW=new FileWriter("C:\\Users\\madhu.p\\eclipse-workspace\\Collections\\src\\DateTime\\Intrest.txt",true);
			BufferedWriter BW=new BufferedWriter(FW);
			BW.write(s);
			BW.close();
		}
	}
}
class Account {
	private String AccNum, AccType;
	LocalDate OpenDate;
	private double CurBal;
	public Account(String accNum, String accType, String openDate, double curBal) {
		super();
		AccNum = accNum;
		AccType = accType;
		OpenDate = LocalDate.parse(openDate);
		CurBal = curBal;
	}
	public String getAccNum() {return AccNum;}
	public LocalDate getOpenDate() {return OpenDate;}
	public double getCurBal() {return CurBal;}
}
class Transactions {
	private String TraID, AccNum, TType;
	private LocalDate TDate;
	private double tAmt;
	public Transactions(String traID, String accNum, String tDate, String tType, double tAmt) {
		TraID = traID;
		AccNum = accNum;
		TDate = LocalDate.parse(tDate);
		TType = tType;
		this.tAmt = tAmt;
	}
	public String getAccNum() {return AccNum;}
	public LocalDate getTDate() {return TDate;}
	public double gettAmt() {return tAmt;}
	public String getTType() {return TType;}
}
