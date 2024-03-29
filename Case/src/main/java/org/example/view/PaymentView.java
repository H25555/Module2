package org.example.view;

import org.example.model.Product;
import org.example.model.Payment;
import org.example.service.ProductService;
import org.example.service.PaymentService;
import org.example.ultis.ValidateUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentView {
    private ProductService productService = new ProductService();
    private PaymentService paymentService = new PaymentService();
    DecimalFormat format = new DecimalFormat("###,###,###" + " đ");
    Scanner scanner = new Scanner(System.in);

    List<Payment> list = new ArrayList<>();
    Menu menu = new Menu();
    int id1 = 0;

    int quantityPurchased = 0;

    String name;
    String phone;
    String address;
    double revenue;
    int realQuantity;
    int quantity;

    int currentQuantity;


    Product product = null;


    public PaymentView() {
    }




    public void buy() {
        while (true) {

            System.out.println("Nhập ID sản phẩm cần mua");
            System.out.print("\t➺ ");
            try {
                id1 = Integer.parseInt(scanner.nextLine());
                if (id1 > 0) {
                    if (paymentService.existProduct(id1)) {
                        product = paymentService.findProductbyID(id1);
                        break;
                    } else {
                        System.out.println("ID này không tồn tại");
                    }
                } else {
                    System.out.println("\t  ID phải lớn hơn 0 ");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("\t  ID phải là 1 số ");
                System.out.println();
            }
        }

            System.out.println("Nhập số lượng sản phẩm: ");
            System.out.print("\t➺ ");
            quantity = Integer.parseInt(scanner.nextLine());

        double price = product.getPrice();
        revenue = price * quantity;
        Payment p = new Payment(id1, quantity, revenue);
        list.add(p);
        System.out.println(list);

        option();

    }

    public void showTotal() {
        System.out.println("Danh sách sản phẩm mua");
        System.out.println("______________________");
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            double total;
            total = list.get(i).getQuantity() * productService.findProductbyID(list.get(i).getId()).getPrice();
            System.out.printf("Tổng tiền sản phẩm %s là : %s\n", productService.findProductbyID(list.get(i).getId()).getName(), format.format(total));
            sum += total;

        }
        System.out.println("________________________________________");
        System.out.println(" ☛ Số tiền cần thanh toán: " + format.format(sum));
        System.out.println("________________________________________");

        check();
    }

    public void showInformation(){
        System.out.println("Thông tin đơn hàng");
        System.out.println("__________________");
        System.out.println("Tên khách hàng: "+ list.get(0).getName());
        System.out.println("Số điện thoại: "+ list.get(0).getPhoneNumber());
        System.out.println("Địa chỉ: "+ list.get(0).getAddress());
        System.out.println("Danh sách sản phẩm mua");
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            double total;
            total = list.get(i).getQuantity() * productService.findProductbyID(list.get(i).getId()).getPrice();
            System.out.printf("Tổng tiền sản phẩm %s là : %s\n", productService.findProductbyID(list.get(i).getId()).getName(), format.format(total));
            sum += total;

        }
        System.out.println("________________________________________");
        System.out.println("Số tiền cần thanh toán: " + format.format(sum));
        System.out.println("________________________________________\n\n");
        paymentService.add(new Payment(0, 0, list.get(0).getName(), list.get(0).getPhoneNumber(), list.get(0).getAddress(), sum));
        afterPay();
    }



    public void option() {
        System.out.println("\t\t\t\tNhập 1 để mua thêm sản phẩm");
        System.out.println("\t\t\t\tNhập 2 để xem tổng tiền");
        System.out.print("\t➺ ");
        int options;
        try {
            options = Integer.parseInt(scanner.nextLine());
            switch (options) {
                case 1:
                    buy();
                    break;
                case 2:
                    showTotal();
                    break;
                default:
                    System.out.println("\t\t\tNhập không đúng! Vui lòng nhập lại");
                    option();
            }
        } catch (Exception e) {
            System.out.println("\t  lựa chọn phải là 1 số ");
            System.out.println();
            option();

        }
    }

    public void check() {
        System.out.println("Bạn có muốn thanh toán đơn hàng này không?");
        System.out.println("nhập 1 để thanh toán");
        System.out.println("nhập 2 để mua lại");
        System.out.print("\t➺ ");
        int options;
        try {

            options = scanner.nextInt();
            switch (options) {
                case 1:
                    pay();
                    return;
                case 2:
                    list.clear();
                    buy();
                    break;
                default:
                    System.out.println("Nhập không đúng! Vui lòng nhập lại");
                    check();
            }
        } catch (Exception e) {
            System.out.println("\t  lựa chọn phải là 1 số ");
            System.out.println();
            check();
        }
    }

    public void pay() {
        System.out.println(" ☟ Nhập thông tin cá nhân để ship hàng ☟");
        System.out.println("∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘∘");
        System.out.println("Nhập họ và tên: ");
        System.out.print("\t➺ ");
        name = scanner.nextLine();
        while (!ValidateUtils.isNameValid(name)) {
            System.out.println("Tên " + name + " không đúng định dạng." + " Vui lòng nhập lại!" + " (Tên phải viết hoa chữ cái đầu)");
            System.out.println("Nhập tên: ");
            System.out.print("\t➺ ");
            name = scanner.nextLine();
        }
        System.out.println("Nhập số điện thoại : ");
        System.out.print("\t➺ ");
        phone = scanner.nextLine();
        while (!ValidateUtils.isPhoneValid(phone)) {
            System.out.println("Số " + phone + " của bạn không đúng định dạng. Vui lòng nhập lại! " + "(Số điện thoại bao gồm 10 số và bắt đầu là số 0)");
            System.out.println("Nhập số điện thoại ");
            System.out.print("\t➺ ");
            phone = scanner.nextLine();
        }
        System.out.println("Nhập địa chỉ:");
        System.out.print("\t➺ ");
        address = scanner.nextLine();
        while (!ValidateUtils.isAddValid(address)) {
            System.out.println("Nhập địa chỉ ");
            System.out.print("\t➺ ");
            address = scanner.nextLine();
        }
        for (Payment p : list) {
            p.setName(name);
            p.setPhoneNumber(phone);
            p.setAddress(address);
        }

        System.out.println("Thanh toán thành công");
        afterPay();

    }



    public void afterPay() {
        System.out.println("Bạn có muốn kiểm tra thông tin thanh toán không?");
        System.out.println("1. Để xem thông tin thanh toán");
        System.out.println("2. Để quay lại menu");
        System.out.println("3. Để thoát");
        System.out.print("\t➺ ");
        int options;
        try {

            options = scanner.nextInt();
            switch (options) {
                case 1:
                    showInformation();
                    break;
                case 2:
                    EmployeeView.select();
                    break;
                case 3:
                    System.out.println("∼∼∼∼∼∼∼∼∼∼See you again∽∽∽∽∽∽∽∽∽∽\n\n");
                    menu.exitProgram();
                    break;
                default:
                    System.out.println("Nhập không đúng! Vui lòng nhập lại");
                    check();
            }
        } catch (Exception e) {
            System.out.println("\t  Lựa chọn phải là 1 số ");
            System.out.println();
            check();
        }
    }}
