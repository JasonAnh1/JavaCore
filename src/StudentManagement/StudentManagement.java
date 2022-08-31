package StudentManagement;

import java.util.Scanner;

import search.search;
import update.DanhSachBangDiem;
import update.Update;
public class StudentManagement {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int chon;
		do {
			System.out.println("\n===========CHUONG TRINH QUAN LY SINH VIEN===========");
			System.out.println("Chon 1 chuc nang quan ly");
			System.out.println("\t1. Cap nhat thong tin he thong");
			System.out.println("\t2. Hien thi bang diem");
			System.out.println("\t3. Tim kiem Thong tin");
			System.out.println("\t0. Dong ung dung");
			System.out.print("Lua chon cua ban: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1: Update.update();break;
			case 2: DanhSachBangDiem.hienThi(); break;
			case 3: search.tk();break;
			case 0: 
				System.out.println("Dong ung dung"); 
				System.exit(0);
			default: System.out.println("Lua chon chuc nang khong dung");
			}
		}while (true);

	}
}
 Test Num01




