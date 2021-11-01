package update;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DanhSachBangDiem {
	static Scanner sc = new Scanner(System.in);
	public static ArrayList<Diem> list = new ArrayList<Diem>();

	public static void capNhat() {

		int chon;
		do {
			System.out.println("\n-------CAP NHAT DANH SACH BANG DIEM--------");
			System.out.println("Lua chon chuc nang cap nhat");
			System.out.println("\t1. Them diem moi vao danh sach");
			System.out.println("\t2. Sua thong tin diem");
			System.out.println("\t3. Xoa thong tin bang diem");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon chuc nang cap nhat thong tin bang diem: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				themMoi();
				break;
			case 2:
				sua();
				break;
			case 3:
				xoa();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon chuc nang cap nhat khong dung");
			}
		} while (true);
	}

	private static void themMoi() {
		System.out.println("them moi diem");
		// check msv
		System.out.print("\tNhap ma sinh vien: ");
		int msv = Integer.parseInt(sc.nextLine());
		if (msv == 0) {
			System.out.println("ma sinh vien khong duoc de trong");
			return;
		} else if (DanhSachSinhVien.indexOfsv(msv) == -1) {
			System.out.println("sinh vien khong co trong danh sach");
			return;
		}
		;

		// check mon
		System.out.println("Nhap ma mon hoc");
		int maMonHoc = Integer.parseInt(sc.nextLine());
		if (DanhSachMonHoc.indexOfmonhoc(maMonHoc) == -1) {
			System.out.println("mon hoc khong co trong danh sach");
			return;
		} else if (returndiem1(msv, maMonHoc) != -1) {
			System.out.println("mon hoc cua sinh vien nay da co diem");
			return;
		}
		// nhap diem
		System.out.println("nhap diem mon hoc");
		double diemSo = Double.parseDouble(sc.nextLine());
		if (diemSo < 0 || diemSo > 10) {
			System.out.println("vui long nhap lai");
			return;
		}
		Diem Diem = new Diem(msv, maMonHoc, diemSo);
		list.add(Diem);
		System.out.println("\tThem moi diem thanh cong...!");
	}

	// sua
	public static void sua() {
		System.out.print("\tNhap ma sinh vien: ");
		int msv = Integer.parseInt(sc.nextLine());
		if (msv == 0) {
			System.out.println("ma sinh vien khong duoc de trong");
			return;
		} else if (DanhSachSinhVien.indexOfsv(msv) == -1) {
			System.out.println("sinh vien khong co trong danh sach");
			return;
		}
		;
		System.out.println("Nhap ma mon hoc");
		int maMonHoc = Integer.parseInt(sc.nextLine());
		if (DanhSachMonHoc.indexOfmonhoc(maMonHoc) == -1) {
			System.out.println("mon hoc khong co trong danh sach");
			return;
		}
		int index = indexOfBangDiem(msv, maMonHoc);
		if (index == -1) {
			System.out.println("khong co diem cua sv nay");
			return;
		}
		// nhap lai diem
		System.out.println("nhap lai diem mon hoc");
		double diemSo = Double.parseDouble(sc.nextLine());
		if (diemSo < 0) {
			System.out.println("vui long nhap lai");
			return;
		}
		list.get(index).setDiemSo(diemSo);
		System.out.println("\tDa sua thong tin diem");
	}

	public static void xoa() {
		System.out.println("\txoa bang diem");
		System.out.print("\tNhap ma sinh vien: ");
		int msv = Integer.parseInt(sc.nextLine());
		if (msv == 0) {
			System.out.println("ma sinh vien khong duoc de trong");
			return;
		} else if (DanhSachSinhVien.indexOfsv(msv) == -1) {
			System.out.println("sinh vien khong co trong danh sach");
			return;
		}
		;
		System.out.println("Nhap ma mon hoc");
		int maMonHoc = Integer.parseInt(sc.nextLine());
		if (DanhSachMonHoc.indexOfmonhoc(maMonHoc) == -1) {
			System.out.println("mon hoc khong co trong danh sach");
			return;
		}
		int index = indexOfBangDiem(msv, maMonHoc);
		if (index == -1) {
			System.out.println("khong co diem cua sv nay");
			return;
		}
		// nhap lai diem
		list.remove(index);
		System.out.println("\tDa xoa thong tin Bang diem");
	}

//hien thi bang die,
	public static void hienThi() {
		int chon;
		do {
			System.out.println("\n-------CAP NHAT DANH SACH BANG DIEM--------");
			System.out.println("Lua chon chuc nang cap nhat");
			System.out.println("\t1. hien thi diem theo sinh vien");
			System.out.println("\t2. hien thi diem theo mon hoc");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon chuc nang hien thi thong tin bang diem: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				hienThiTheoSinhVien();
				break;
			case 2:
				hienThiTheoMonHoc();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua hien thi khong dung");
			}
		} while (true);
	}

	private static void hienThiTheoSinhVien() {
		int i = 0;
		double diemtk = 0;
		System.out.println("Bang diem");
		while (i < DanhSachBangDiem.list.size()) {
			System.out.println("\nMa SV : " + DanhSachBangDiem.list.get(i).getMsv() + "           Ho ten : "
					+ DanhSachSinhVien.msvtosv(DanhSachBangDiem.list.get(i).getMsv()));
			int j = i;

			while (j < DanhSachBangDiem.list.size()
					&& DanhSachBangDiem.list.get(i).getMsv() == DanhSachBangDiem.list.get(j).getMsv()) {
				System.out.println("Ma mon :" + DanhSachBangDiem.list.get(j).getMaMonHoc() + "           Ten mon : "
						+ DanhSachMonHoc.mmhtomh(DanhSachBangDiem.list.get(j).getMaMonHoc()) + "diem :"
						+ DanhSachBangDiem.list.get(j).getDiemSo());


				diemtk += DanhSachBangDiem.list.get(j).getDiemSo()
						* DanhSachMonHoc.mmhtohsm(DanhSachBangDiem.list.get(j).getMaMonHoc());
				j++;
			}
			i = j;
			System.out.printf("diem tong ket %f", diemtk);
		}

	}

	private static void hienThiTheoMonHoc() {
		int i = 0;
		double tbm = 0;
		System.out.println("Bang diem");
		while (i < DanhSachBangDiem.list.size()) {
			System.out.println("\nMa Mon Hoc: " + DanhSachMonHoc.list.get(i).getMaMonHoc() + "ten mon hoc:"
					+ DanhSachMonHoc.mmhtomh(DanhSachBangDiem.list.get(i).getMaMonHoc()));

			int j = i;
			while (j < DanhSachBangDiem.list.size()
					&& DanhSachBangDiem.list.get(i).getMaMonHoc() == DanhSachBangDiem.list.get(j).getMaMonHoc()) {
				System.out.println("ma sinh vien :" + DanhSachBangDiem.list.get(j).getMsv() + "ten sinh vien : "
						+ DanhSachSinhVien.msvtosv(DanhSachBangDiem.list.get(j).getMsv()) + "diem :"
						+ DanhSachBangDiem.list.get(j).getDiemSo());
				tbm += DanhSachBangDiem.list.get(j).getDiemSo()
						* DanhSachMonHoc.mmhtohsm(DanhSachBangDiem.list.get(i).getMaMonHoc());
				j++;
			}
			i = j;
			System.out.printf("Trung binh mon", tbm / i);
		}
	}

	// cac ham tra ve diem so
	public static double returndiem1(int msv, int maMonHoc) {
		for (Diem d : list) {
			if (d.getMsv() == msv && d.getMaMonHoc() == maMonHoc) {
				return d.getDiemSo();
			}
		}
		return -1;
	}

	public static double returndiem2(int msv) {
		for (Diem d : list) {
			if (d.getMsv() == msv) {
				return d.getDiemSo();
			}
		}
		return -1;
	}

	public static double returndiem3(int maMonHoc) {
		for (Diem d : list) {
			if (d.getMaMonHoc() == maMonHoc) {
				return d.getDiemSo();
			}
		}
		return -1;
	}

	// lay index cua bang diem
	public static int indexOfBangDiem(int msv, int maMonHoc) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getMsv() == msv && list.get(i).getMaMonHoc() == maMonHoc) {
				return i;
			}
		}
		return -1;
	}
}
