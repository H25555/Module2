package org.example.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeView {
    static PaymentView paymentView = new PaymentView();
    static Menu menu =new Menu();
    static ProductView productView = new ProductView();
    static Scanner scanner = new Scanner(System.in);

    public static void select() {
        do {
            selectView();
            try {
                System.out.println("\nChọn chức năng ");
                System.out.print("\t➺ ");
                int number = scanner.nextInt();
                System.out.println("number " + number);
                switch (number) {
                    case 1:
                        productView.showProduct();
                        break;
                case 2:
                    productView.findProductbyName();
                    break;
                case 3:
                    productView.findProductbyTypeGuest();
                    break;
                case 4:
                    productView.sortASC();
                    break;
                case 5:
                    productView.sortDESC();
                    break;

                    case 6:
                    paymentView.buy();
                    break;
                    case 7:
                        menu.select();
                        break;
                    case 8:
                        menu.exitProgram();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        select();
                }
            } catch (Exception e) {
                System.out.println("Nhập sai! vui lòng nhập lại1111");
                select();
            }
        } while(true);
    }
    public static void selectView() {
        System.out.println("⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪");
        System.out.println("⚪                                              ⚪");
        System.out.println("⚪     1. Hiển thị danh sách sản phẩm           ⚪");
        System.out.println("⚪     2. Tìm kiếm sản phẩm theo tên            ⚪");
        System.out.println("⚪     3. Tìm kiếm sản phẩm theo loại           ⚪");
        System.out.println("⚪     4. Sắp xếp sản phẩm theo giá tăng dần    ⚪");
        System.out.println("⚪     5. Sắp xếp sản phẩm theo giá giảm dần    ⚪");
        System.out.println("⚪     6. Mua sản phẩm                          ⚪");
        System.out.println("⚪     7. Quay lại                              ⚪");
        System.out.println("⚪     8. Thoát                                 ⚪");
        System.out.println("⚪                                              ⚪");
        System.out.println("⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ");
    }
}
