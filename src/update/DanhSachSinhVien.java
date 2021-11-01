package update;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DanhSachSinhVien {
	static Scanner sc = new Scanner(System.in);
	public static ArrayList<SinhVien> list = new ArrayList<SinhVien>();

	public static void capNhat() {
		int chon;
		do {
			System.out.println("\n-------CAP NHAT DANH SACH SINH VIEN--------");
			System.out.println("Lua chon chuc nang cap nhat");
			System.out.println("\t1. Them sinh vien moi vao danh sach");
			System.out.println("\t2. Sua thong tin sinh vien");
			System.out.println("\t3. Xoa thong tin sinh vien");
			System.out.println("\t4. Hien thi thong tin sinh vien sap xep theo ten");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon chuc nang cap nhat thong tin sinh vien: ");
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
		System.out.println("\n------Them moi sinh vien-------");
		// msv
		System.out.print("\tNhap ma sinh vien: ");
		int msv = Integer.parseInt(sc.nextLine());
		if (msv == 0) {
			System.out.println("ma sinh vien khong duoc de trong");
			return;
		}
		for (SinhVien sv : list) {
			if (sv.getMsv() == msv) {
				System.out.println("ma bi trung");
				return;
			}
		}
		// ho ten
		System.out.print("\tNhap ho Dem sinh vien: ");
		String hoDem = sc.nextLine();
		System.out.print("\tNhap ten sinh vien: ");
		String ten = sc.nextLine();
		if (hoDem.length() == 0 || ten.length() == 0) {
			System.out.println("\tHo dem hoc ten sinh vien khong duoc de trong");
			return;
		}
		// nam sinh
		System.out.print("\tNhap nam sinh sinh vien: ");
		int namSinh = Integer.parseInt(sc.nextLine());
		if (namSinh == 0) {
			System.out.println("\tnam sinh sinh vien khong duoc de trong");
			return;
		}
		// gioi tinh
		System.out.print("\tNhap gioi tinh sinh vien: ");
		String gioiTinh = sc.nextLine();
		if (gioiTinh.length() == 0) {
			System.out.println("\tgioi tinh sinh vien khong duoc de trong");
			return;
		}

		SinhVien sv = new SinhVien(msv, hoDem, ten, namSinh, gioiTinh);
		list.add(sv);
		System.out.println("\tThem moi sinh vien thanh cong...!");
	}
	// lay index,kiem tra

	public static int indexOfsv(int msv) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getMsv() == msv) {
				return i;
			}
		}
		return -1;
	}
//msv tra ve ho ten
	public static String msvtosv(int msv) {
		for(SinhVien sv : list) {
			if (sv.getMsv() == msv) {
				return sv.getHoDem() + "  " +sv.getTen();
			}
		}
		return null;
			
	}
	private static void sua() {
		System.out.println("\n------Sua thong tin sinh vien------");
		System.out.print("\tNhap ma sinh vien can sua: ");
		int msv = Integer.parseInt(sc.nextLine());
		int index = indexOfsv(msv);
		if (index == -1) {
			System.out.println("\tSinh vien chua co trong danh sach");
			return;
		}
		int chon;
		do {
			System.out.println("Chon thong tin can sua");
			System.out.println("\t1. Sua hoDem");
			System.out.println("\t2. Sua ten ");
			System.out.println("\t3. Sua nam sinh");
			System.out.println("\t4. Sua gioi tinh");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				suahoDem(list.get(index));
				break;
			case 2:
				suaTen(list.get(index));
				break;
			case 3:
				suanamSinh(list.get(index));
				break;
			case 4:
				suaDonGioiTinh(list.get(index));
				break;
			case 0:
				return;
			default:
				System.out.println("\tChon sua khong hop le");

			}
		} while (true);
	}

	// sua ho dem
	public static void suahoDem(SinhVien sv) {
		System.out.println("\n-------Sua ho dem--------");
		System.out.print("\tNhap ho dem: ");
		String hoDem = sc.nextLine();
		if (hoDem.length() == 0) {
			System.out.println("\tho dem sinh vien khong duoc de trong");
			return;
		}
		sv.setHoDem(hoDem);
		System.out.println("\tSua ho Dem sinh vien thanh cong...!");
	}

	public static void suaTen(SinhVien sv) {
		System.out.println("\n-------Sua ten-------");
		System.out.print("\tNhap ten: ");
		String ten = sc.nextLine();
		if (ten.length() == 0) {
			System.out.println("\tTen khong duoc de trong");
			return;
		}
		sv.setTen(ten);
		System.out.println("\tSua ten sinh vien thanh cong...!");
	}

	public static void suanamSinh(SinhVien sv) {
		System.out.println("\n-------nam sinh-------");
		System.out.print("\tNhap nam sinh: ");
		int namSinh = Integer.parseInt(sc.nextLine());
		if (namSinh == 0) {
			System.out.println("\tnam sinh sinh vien khong duoc de trong");
			return;
		}
		sv.setNamSinh(namSinh);
		;
		System.out.println("\tSua nam sinh sinh vien thanh cong...!");
	}

	public static void suaDonGioiTinh(SinhVien sv) {
		System.out.println("\n-------Sua gioi tinh-------");
		System.out.print("\tNhap gioi tinh: ");
		String gioiTinh = sc.nextLine();
		if (gioiTinh.length() == 0) {
			System.out.println("\tgioi tinh sinh vien khong duoc de trong");
			return;
		}
		sv.setGioiTinh(gioiTinh);
		;
		System.out.println("\tSua gioi tinh hang thanh cong...!");
	}

	private static void xoa() {
		System.out.println("\n------Xoa thong tin sinh vien------");
		System.out.print("\tNhap ma sinh vien can xoa: ");
		int msv = Integer.parseInt(sc.nextLine());
		int index = indexOfsv(msv);
		if (index == -1) {
			System.out.println("\tSinh Vien chua co trong danh sach");
			return;
		} else if (DanhSachBangDiem.returndiem2(msv) != -1) {
			System.out.println("\tKhong the xoa sinh vien da co diem");return;
		}

		list.remove(index);
		System.out.println("\tXoa Sinh Vien thanh cong...!");
	}

	private static void hienThi() {
		Collections.sort(list, new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				// TODO Auto-generated method stub
				return o1.getTen().compareToIgnoreCase(o2.getTen());
			}
		});
		System.out.println("\n----------Danh sach sinh vien-----------");
		System.out.printf("%-10s %-15s %-15s %-10s %-10s%n", "msv", "ho dem", "ten", "nam sinh", "gioi tinh");
		for (SinhVien sv : list) {
			sv.display();
		}
	}
}
