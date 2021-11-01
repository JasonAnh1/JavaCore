package update;

import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachMonHoc {
	static Scanner sc = new Scanner(System.in);
	public static ArrayList<MonHoc> list = new ArrayList<MonHoc>();

	public static void capNhat() {
		int chon;
		do {
			System.out.println("\n-------CAP NHAT DANH SACH MON HOC--------");
			System.out.println("Lua chon chuc nang cap nhat");
			System.out.println("\t1. Them mon hoc moi vao danh sach");
			System.out.println("\t2. Sua thong tin mon hoc");
			System.out.println("\t3. Xoa thong tin mon hoc");
			System.out.println("\t4. Hien thi thong tin mon hoc sap xep theo ten");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon chuc nang cap nhat thong tin mon hoc: ");
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
			case 4:
				hienThi();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon chuc nang cap nhat khong dung");
			}
		} while (true);

	}

	private static void themMoi() {
		System.out.println("\n------Them moi mon hoc-------");

		System.out.print("\tNhap ma mon hoc: ");
		int maMonHoc = Integer.parseInt(sc.nextLine());
		if (maMonHoc == 0) {
			System.out.println("ma mon hoc khong duoc de trong");
			return;
		}
		for (MonHoc mh : list) {
			if (mh.getMaMonHoc() == maMonHoc) {
				System.out.println("ma bi trung");
				return;
			}
		}

		System.out.print("\tNhap ten mon hoc: ");
		String tenMonHoc = sc.nextLine();
		if (tenMonHoc.length() == 0) {
			System.out.println("\tten mon hoc khong duoc de trong");
			return;
		}

		System.out.print("\tNhap he so mon hoc: ");
		double hsMon = Double.parseDouble(sc.nextLine());
		if (hsMon == 0) {
			System.out.println("\the so mon hoc khong duoc de trong");
			return;
		}

		MonHoc mh = new MonHoc(maMonHoc, tenMonHoc, hsMon);
		list.add(mh);
		System.out.println("\tThem moi mon hoc thanh cong...!");
	}
	// lay index,kiem tra

	public static int indexOfmonhoc(int maMonHoc) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getMaMonHoc() == maMonHoc) {
				return i;
			}
		}
		return -1;
	}

	private static void sua() {
		System.out.println("\n------Sua thong tin mon hoc------");
		System.out.print("\tNhap ma mon hoc can sua: ");
		int maMonHoc = Integer.parseInt(sc.nextLine());
		int index = indexOfmonhoc(maMonHoc);
		if (index == -1) {
			System.out.println("\tmon hoc chua co trong danh sach");
			return;
		}
		int chon;
		do {
			System.out.println("Chon thong tin can sua");
			System.out.println("\t1. Sua ten ");
			System.out.println("\t2. Sua he so mon");

			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				suaTen(list.get(index));
				break;
			case 2:
				suahsMon(list.get(index));
				break;
			case 0:
				return;
			default:
				System.out.println("\tChon sua khong hop le");

			}
		} while (true);
	}
//nhap ma mon hoc tra ve ten mon
	public static String mmhtomh(int mmh) {
		for(MonHoc mh : list) {
			if (mh.getMaMonHoc() == mmh) {
				return mh.getTenMonHoc();
			}
		}
		return null;
			
	}
	// tra ve hesomon
	public static double mmhtohsm(int mmh) {
		for(MonHoc mh : list) {
			if (mh.getMaMonHoc() == mmh) {
				return mh.getHsMon();
			}
		}
		return 0;	
	}
	// sua ho dem
	public static void suaTen(MonHoc mh) {
		System.out.println("\n-------Sua ten mon hoc--------");
		System.out.print("\tNhap ten mon hoc: ");
		String tenMonHoc = sc.nextLine();
		if (tenMonHoc.length() == 0) {
			System.out.println("\tho dem mon hoc khong duoc de trong");
			return;
		}
		mh.setTenMonHoc(tenMonHoc);
		System.out.println("\tSua ten mon hoc thanh cong...!");
	}

	public static void suahsMon(MonHoc mh) {
		System.out.println("\n-------Sua he so mon-------");
		System.out.print("\tNhap he so : ");
		double hsMon = Double.parseDouble(sc.nextLine());
		if (hsMon == 0) {
			System.out.println("\the so mon khong duoc de trong");
			return;
		}
		mh.setHsMon(hsMon);
		System.out.println("\tSua ten mon hoc thanh cong...!");
	}

	private static void xoa() {
		System.out.println("\n------Xoa thong tin mon hoc------");
		System.out.print("\tNhap ma mon hoc can xoa: ");
		int maMonHoc = Integer.parseInt(sc.nextLine());
		int index =  indexOfmonhoc(maMonHoc);
		if (index == -1) {
			System.out.println("\tmon hoc chua co trong danh sach");
			return;
		}
		else if(DanhSachBangDiem.returndiem3(maMonHoc) == -1) {
			System.out.println("\tkhong the xoa mon da co diem cua hoc sinh");
			return;
		}
		list.remove(index);
		System.out.println("\tXoa mon hoc thanh cong...!");
	}

	private static void hienThi() {
		System.out.println("\n----------Danh sach mon hoc-----------");
		System.out.printf("%-10s %-30s %8.2s%n", "ma mon", "ten mon hoc", "he so");
		for (MonHoc mh : list) {
			mh.display();
		}
	}
}
