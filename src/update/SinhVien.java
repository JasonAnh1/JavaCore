		package update;

public class SinhVien {
private int msv;
private String hoDem;
private String ten;
private int namSinh;
private String gioiTinh;
public void display() {
	System.out.printf("%-10d %-15s %-15s %-10d %-10s%n",msv,hoDem,ten,namSinh,gioiTinh);
}
public SinhVien(int msv, String hoDem, String ten, int namSinh, String gioiTinh) {
	super();
	this.msv = msv;
	this.hoDem = hoDem;
	this.ten = ten;
	this.namSinh = namSinh;
	this.gioiTinh = gioiTinh;
}
public SinhVien() {
	super();
}
public int getMsv() {
	return msv;
}
public void setMsv(int msv) {
	this.msv = msv;
}
public String getHoDem() {
	return hoDem;
}
public void setHoDem(String hoDem) {
	this.hoDem = hoDem;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public int getNamSinh() {
	return namSinh;
}
public void setNamSinh(int namSinh) {
	this.namSinh = namSinh;
}
public String getGioiTinh() {
	return gioiTinh;
}
public void setGioiTinh(String gioiTinh) {
	this.gioiTinh = gioiTinh;
}

}
