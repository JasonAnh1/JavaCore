package update;

import java.util.Scanner;
public class Update {
	static Scanner sc = new Scanner(System.in);
	public static void update() {
		int chon;
		do {
			System.out.println("\n--------CHUC NANG CAP NHAT THONG TIN HE THONG--------------");
			System.out.println("Chon mot chuc nang cap nhat");
			System.out.println("\t1. Cap nhat danh sach sinh vien");
			System.out.println("\t2. Cap nhat danh sach mon hoc");
			System.out.println("\t3. Cap nhat danh sach bang diem");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon chuc nang: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: DanhSachSinhVien.capNhat(); break;
			case 2: DanhSachMonHoc.capNhat(); break;
			case 3: DanhSachBangDiem.capNhat(); break;
			case 0: return;
			default: System.out.println("Lua chon chuc nang khong hop le");
			}
		}while (true);
		//1
	}
}
