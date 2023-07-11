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

	public static double getBalanceAsOndate(Acc a, LocalDate dt, ArrayList<Transaction> tra) {
		double bal = 0;
		int i = tra.size() - 1;
		while (i != -1) {
			if (dt.compareTo(tra.get(i).getTransdate()) >= 0 && dt.compareTo(a.getOpeningdate()) >= 0) {
				if (tra.get(i).getTranstype().equals('c')) {
					bal += tra.get(i).getTamount();
				} else {
					bal -= tra.get(i).getTamount();
				}
				i--;

			}
		}

		return bal;

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
