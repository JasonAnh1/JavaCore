package update;

public class MonHoc {
private int maMonHoc;
private String tenMonHoc;
private double hsMon;
public void display() {
	System.out.printf("%-10d %-30s %8.2f",maMonHoc,tenMonHoc,hsMon);
}
public MonHoc(int maMonHoc, String tenMonHoc, double hsMon) {
	super();
	this.maMonHoc = maMonHoc;
	this.tenMonHoc = tenMonHoc;
	this.hsMon = hsMon;
}
public MonHoc() {
	super();
}
public int getMaMonHoc() {
	return maMonHoc;
}
public void setMaMonHoc(int maMonHoc) {
	this.maMonHoc = maMonHoc;
}
public String getTenMonHoc() {
	return tenMonHoc;
}
public void setTenMonHoc(String tenMonHoc) {
	this.tenMonHoc = tenMonHoc;
}
public double getHsMon() {
	return hsMon;
}
public void setHsMon(double hsMon) {
	this.hsMon = hsMon;
}

}
