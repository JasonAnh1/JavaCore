package search;

import java.util.Scanner;

import update.DanhSachBangDiem;
import update.DanhSachMonHoc;
import update.DanhSachSinhVien;

public class search {
	static Scanner sc = new Scanner(System.in);
	public static void tk() {
á
		int chon;
		do {
			System.out.println("\n-------Chuc nang tim kiem--------");
			System.out.println("Lua chon chuc nang cap nhat");
			System.out.println("\t1. tim kiem sinh vien");
			System.out.println("\t2. tim kiem mon hoc");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon chuc nang hien thi thong tin bang diem: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				tkSinhVien();
				break;
			case 2:
				tkMonHoc();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon hien thi khong dung");
			}
		} while (true);
	}
public static void tkSinhVien() {
	double diemtk =0;
	System.out.println("nhap ma sinh vien:");
	int msv = Integer.parseInt(sc.nextLine());
	System.out.println("\nMa SV : " + msv + "           Ho ten : " 
			+ DanhSachSinhVien.msvtosv(msv));
for( int i = 0; i<DanhSachBangDiem.list.size();i++) if(msv == DanhSachBangDiem.list.get(i).getMsv())
{
	System.out.println("Ma mon :" + DanhSachBangDiem.list.get(i).getMaMonHoc() + "Ten mon : "
			+ DanhSachMonHoc.mmhtomh(DanhSachBangDiem.list.get(i).getMaMonHoc()) + "diem :"
			+ DanhSachBangDiem.list.get(i).getDiemSo());
	diemtk += DanhSachBangDiem.list.get(i).getDiemSo()
			* DanhSachMonHoc.mmhtohsm(DanhSachBangDiem.list.get(i).getMaMonHoc());
	}
System.out.printf("Diem tong ket %f ",diemtk);
}
public static void tkMonHoc() {
	double diemtb =0;
	int k = 0;
	System.out.println("nhap ma mon hoc:");
	int mmh = Integer.parseInt(sc.nextLine());
	System.out.println("\nMa mon hoc: " + mmh + "           ten mon : " 
			+ DanhSachMonHoc.mmhtomh(mmh));
for( int i = 0; i<DanhSachBangDiem.list.size();i++) if(mmh == DanhSachBangDiem.list.get(i).getMaMonHoc())
{
	System.out.println("msv :" + DanhSachBangDiem.list.get(i).getMsv() + "Ten sinh vien : "
			+ DanhSachSinhVien.msvtosv(DanhSachBangDiem.list.get(i).getMsv() ) + "diem :"
			+ DanhSachBangDiem.list.get(i).getDiemSo());
	diemtb += DanhSachBangDiem.list.get(i).getDiemSo()
			* DanhSachMonHoc.mmhtohsm(DanhSachBangDiem.list.get(i).getMaMonHoc());
	k++;
}
System.out.printf("Diem trung binh mon la %f: ",diemtb/k);
}}�dasdasd

