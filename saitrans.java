package transproject;

import java.time.LocalDate;

public class Transaction {
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
