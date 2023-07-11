package transproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;

import collections.Acc;

public class Bankintrest {
	public static ArrayList<Transaction> alltrans(ArrayList<Transaction> t, Acc c) {
		ArrayList<Transaction> tra = new ArrayList<>();
		for (int i = 0; i < t.size(); i++) {
			if ((t.get(i).getAccno()) == c.getAccno()) {
				tra.add(t.get(i));
			}
		}
		//System.out.println(tra);
		return tra;
	}

	 public static double getBalanceAsOndate(Acc a, LocalDate dt,ArrayList<Transaction> tra) {
		double bal=0;
		for(int i=0;i<tra.size();i++) {
			if(dt<tra.get(i).gettransdate() && dt>a.getOpeningdate() )
		}
		 
		 
		 return 0;
		
	 }

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
				new FileReader("D:\\TEST1\\collections\\src\\transproject\\account.txt"));
		ArrayList<Acc> a1 = new ArrayList<>();
		String str = "";
		while ((str = br.readLine()) != null) {
			String s[] = str.split(",");
			// System.out.println(s[2]);
			a1.add(new Acc(s[0], s[1], s[2], s[3]));
		}

		BufferedReader brr = new BufferedReader(
				new FileReader("D:\\TEST1\\collections\\src\\transproject\\transactions.txt"));
		ArrayList<Transaction> a2 = new ArrayList<>();
		String strr = "";
		while ((strr = brr.readLine()) != null) {
			String aa[] = strr.split(",");
			// System.out.println(aa[2]);
			a2.add(new Transaction(aa[0], aa[1], aa[2], aa[3], aa[4]));
		}

		alltrans(a2, a1.get(0));

	}
}
