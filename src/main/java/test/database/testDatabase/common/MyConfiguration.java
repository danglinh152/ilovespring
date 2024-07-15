package test.database.testDatabase.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.database.testDatabase.DAO.sinhVienDAOImpl;
import test.database.testDatabase.entity.sinhVien;

import java.util.List;
import java.util.Scanner;

@Configuration
public class MyConfiguration {

    @Bean
    @Autowired
    public CommandLineRunner commandLineRunner(sinhVienDAOImpl sinhVienDAOImpl) {
        return runner -> {
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            while (true) {
                printMenu();
                choice = scanner.nextInt();
                if (choice == -1) {
                    break;
                } else if (choice == 1) {
                    System.out.println("Nhập tên:");
                    scanner.nextLine();
                    String ten = scanner.nextLine();
                    sinhVien sv = new sinhVien(ten);
                    sinhVienDAOImpl.save(sv);
                    System.out.println("ĐÃ THÊM 1 SINH VIÊN THÀNH CÔNG");
                } else if (choice == 2) {
                    List<sinhVien> listOfSV = sinhVienDAOImpl.ListOfSV();
                    if (listOfSV == null) {
                        System.out.println("Không có sinh viên nào hết!");
                    } else {
                        for (int i = 0; i < listOfSV.size(); i++) {
                            System.out.println(listOfSV.get(i));
                        }
                    }
                } else if (choice == 3) {
                    System.out.println("Nhap id: ");
                    int id = scanner.nextInt();
                    sinhVienDAOImpl.delete(id);
                    System.out.println("Da xoa sv " + id);
                } else if (choice == 4) {
                    System.out.println("Nhap id sinh vien muon cap nhat: ");
                    int id = scanner.nextInt();
                    sinhVien sv = sinhVienDAOImpl.getByID(id);
                    if (sv != null) {
                        scanner.nextLine();
                        System.out.println("Nhap ten muon thay doi: ");
                        String ten = scanner.nextLine();
                        sinhVien svUpdated = sv;
                        svUpdated.setten(ten);
                        sinhVienDAOImpl.update(svUpdated);
                        System.out.println("Cap nhat thanh cong sv " + id);

                    } else {
                        System.out.println("Khong co sv nao co id = " + id);
                    }
                } else if (choice == 5) {
                    System.out.println("Nhap id sinh vien muon tim kiem: ");
                    int id = scanner.nextInt();
                    sinhVien sv = sinhVienDAOImpl.getByID(id);
                    if (sv != null) {
                        System.out.println(sv);
                    } else {
                        System.out.println("Khong co sv nao co id = " + id);
                    }
                } else {
                    System.out.println("Error!");
                }
            }

        };
    }

    public void printMenu() {
        System.out.println("1. Them sinh vien \n");
        System.out.println("2. Xem tat ca sinh vien \n");
        System.out.println("3. Xoa sinh vien \n");
        System.out.println("4. Cap nhat sinh vien \n");
        System.out.println("5. Tim kiem sinh vien theo id \n");
        System.out.println("-1. Thoat \n");

    }
}
