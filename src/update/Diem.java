package update;

public class Diem {
	private int msv;
	private int maMonHoc;
	private double diemSo;
  public void displaysv() {
	  System.out.printf("%-10d %-30s",msv,DanhSachSinhVien.msvtosv(msv));
  }
	public void display() {
		System.out.printf("%-10d %-30s %-10d %-30s %-8.2f",msv,DanhSachSinhVien.msvtosv(msv),maMonHoc,DanhSachMonHoc.mmhtomh(maMonHoc),diemSo);
	}
	
	public Diem(int msv, int maMonHoc, double diemSo) {
		super();
		this.msv = msv;
		this.maMonHoc = maMonHoc;
		this.diemSo = diemSo;
	}

	public Diem() {
		super();
	}

	public int getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(int maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public double getDiemSo() {
		return diemSo;
	}

	public void setDiemSo(double diemSo) {
		this.diemSo = diemSo;
	}

	public int getMsv() {
		return msv;
	}

	public void setMsv(int msv) {
		this.msv = msv;
	}

}
