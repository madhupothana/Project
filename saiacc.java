package collections;

import java.time.LocalDate;

public class Acc {
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
