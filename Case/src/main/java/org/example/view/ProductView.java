package org.example.view;

import org.example.model.Product;
import org.example.model.Product;
import org.example.model.Product;
import org.example.model.Product;
import org.example.service.ProductService;
import org.example.service.ProductService;
import org.example.ultis.PriceSortASC;
import org.example.ultis.PriceSortDESC;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    DecimalFormat format = new DecimalFormat("###,###,###" + " đ");
    EmployeeView employeeView = new EmployeeView();
    private ProductService productService = new ProductService();
    private List<Integer> idArr = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public void select(){
        do {
        renderView();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nChọn chức năng ");
            System.out.print("\t➺ ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showProduct();
                    return;
                case 2:
                    addProduct();
                    break;
                case 3:
//                    exitProgram();
                    deleteProduct();
                    break;
                case 4:
                    updateProduct();
                    break;
                case 5:
                    AdminView.select();
                default:
                    System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                    select();
                    break;
            }

        } catch (InputMismatchException io) {
            System.out.println("Nhập sai! Vui lòng nhập lại");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        } while (true);
    }
    public static void renderView() {
        System.out.println();
        System.out.println(" ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ");
        System.out.println("⚪                                                ⚪");
        System.out.println("⚪             1.    Xem danh sách sản phẩm       ⚪");
        System.out.println("⚪             2.    Thêm sản phẩm                ⚪");
        System.out.println("⚪             3.    Xóa sản phẩm                 ⚪");
        System.out.println("⚪             4.    Sửa sản phẩm                 ⚪");
        System.out.println("⚪             5.    Thoát                        ⚪");
        System.out.println("⚪                                                ⚪");
        System.out.println(" ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ⚪ ");
    }
    public void showProduct() {
        List<Product> listProduct = productService.getListProduct();
        System.out.println("Thông tin sản phẩm");
        System.out.println("=========================================================================================================================");

        for(Product product:listProduct) {
            System.out.println("\t\t\t\t\n"+ "   "+"ID: "+ product.getId()+ "   "+ product.getName()+ "   "+"Phân loại: "+product.getType()+ "   " +"Giá(VND): "+ product.getPrice());

            idArr.add(product.getId());
        }
        System.out.println("=========================================================================================================================");

    }
    public void addProduct() {
        List<Product> listProduct = productService.getListProduct();
        int id = listProduct.get(listProduct.size() - 1).getId() + 1;
        System.out.println("Nhập tên sản phầm: ");
        String productname = scanner.nextLine();
        System.out.println("Nhập giá tiền ");
        double price = scanner.nextDouble();

        int type;
        String typeName = "";
        do {
            System.out.println("Chọn phân loại (1: Coffee, 2: Tea, 3: Juice):  ");
            type = scanner.nextInt();
            switch (type) {
                case 1:
                    typeName = "coffee";
                    productService.add(new Product(id, productname, typeName, price));
                    break;
                case 2:
                    typeName = "tea";
                    productService.add(new Product(id, productname, typeName, price));
                    break;
                case 3:
                    typeName = "juice";
                    productService.add(new Product(id, productname, typeName, price));
                    break;
                default:
                    System.out.println("Khong hop le, vui long nhap lai");
                    break;
            }
        } while (type > 3 || type == 0);

        System.out.println("Thêm thành công");
    }
    public void updateProduct() {
        showProduct();
        int id;
        do {
            System.out.println("Nhập ID sản phẩm: ");
            id = scanner.nextInt();
        } while(checkExistId(id) == false);
        String productname1 = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        String productname = scanner.nextLine();
        System.out.println("Nập giá sản phẩm: ");
        double price = scanner.nextDouble();
//        System.out.println("Chọn phân loại: ");
        int type;
        String typeName = "";
        do {
            System.out.println("Chọn phần loại (1: Coffee, 2: Tea, 3: Juice):  ");
            type = scanner.nextInt();
            switch (type) {
                case 1:
                    typeName = "coffee";
                    productService.add(new Product(id, productname, typeName, price));
                    break;
                case 2:
                    typeName = "tea";
                    productService.add(new Product(id, productname, typeName, price));
                    break;
                case 3:
                    typeName = "juice";
                    productService.add(new Product(id, productname, typeName, price));
                    break;
                default:
                    System.out.println("Vui lòng nhập lại!");
                    break;
            }
        } while (type > 3 || type == 0);
        if (productService.update(id, new Product(id, productname, typeName, price))) {
            System.out.println("Chỉnh sửa thành công!");
        } else {
            System.out.println("Lỗi");
        }

    }

    public void deleteProduct() {
        showProduct();
        int id;
        do {
            System.out.println("Nhập ID sản phẩm: ");
            id = scanner.nextInt();
        } while(checkExistId(id) == false);
        if (productService.delete(id)) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Lỗi");
        }
    }
    public boolean checkExistId(int id) {
        for (int idProduct:idArr) {
            if (idProduct == id) return true;
        }
        return false;
    }
    public void sortASC() {
        List<Product> p = productService.getListProduct();
        p.sort(new PriceSortASC());
        System.out.println("Danh sách sản phẩm");
        System.out.println("=========================================================================================================================");
//        System.out.printf("\t\t\t\t%-10s %-25s %-30s %-15s %-25s %-25s\n", "ID", "Loại sản phẩm", "Tên sản phẩm", "Số lượng", "Giá(VND)");
        for (Product product : p) {
            System.out.println("\t\t\t\t\n"+ "   "+"ID: "+ product.getId()+ "   "+ product.getName()+ "   "+"Phân loại: "+product.getType()+ "   " +"Giá(VND): "+ product.getPrice());
        }
        System.out.println("=========================================================================================================================\n\n");
        employeeView.select();
    }
    public void sortDESC() {
        List<Product> p = productService.getListProduct();
        p.sort(new PriceSortDESC());
        System.out.println("Danh sách sản phẩm");
        System.out.println("=========================================================================================================================");
//        System.out.printf("\t\t\t\t%-10s %-25s %-30s %-15s %-25s %-25s\n", "ID", "Loại sản phẩm", "Tên sản phẩm", "Số lượng", "Giá(VND)");
        for (Product product : p) {
            System.out.println("\t\t\t\t\n"+ "   "+"ID: "+ product.getId()+ "   "+ product.getName()+ "   "+"Phân loại: "+product.getType()+ "   " +"Giá(VND): "+ product.getPrice());
        }
        System.out.println("=========================================================================================================================");
        employeeView.select();
    }
    public void findProductbyName() {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine().toUpperCase();
        boolean found = false;
        List<Product> p = productService.getListProduct();
        System.out.println("Danh sách sản phẩm");
//        System.out.printf("\t\t\t\t%-10s %-25s %-30s %-15s %-25s %-25s\n", "ID", "Loại sản phẩm", "Tên sản phẩm", "Số lượng", "Giá(VND)", "Trạng thái");
        for (Product product : p) {
            if (product.getName().toUpperCase().contains(name)) {
                        System.out.println("=========================================================================================================================");

                System.out.println("\t\t\t\t\n"+ "   "+"ID: "+ product.getId()+ "   "+ product.getName()+ "   "+"Phân loại: "+product.getType()+ "   " +"Giá(VND): "+ product.getPrice());
                found = true;
            }
        }
        if (!found) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t ✖ Không có sản phẩm này ✖");
        }
                System.out.println("=========================================================================================================================");

        employeeView.select();
    }
    public void findProductbyTypeGuest() {
        System.out.println("⚪ ⚪ ⚪ ⚪ ⚪⚪ ⚪ ⚪ ⚪ ");
        System.out.println("⚪  1. COFFEE            ⚪");
        System.out.println("⚪  2. TEA               ⚪");
        System.out.println("⚪  3. JUICE             ⚪");
        System.out.println("⚪ ⚪ ⚪ ⚪ ⚪⚪ ⚪ ⚪ ⚪ ");
        System.out.print("Nhập số tương ứng với loại sản phẩm cần tìm (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        String type;
        switch (choice) {
            case 1:
                type = "coffee";
                break;
            case 2:
                type = "tea";
                break;
            case 3:
                type = "juice";
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }
        boolean found = false;
        List<Product> products = productService.getListProduct();
        System.out.println("Danh sách sản phẩm");
        System.out.println("=========================================================================================================================");
//        System.out.printf("\t\t\t\t%-10s %-25s %-30s %-15s %-25s %-25s\n", "ID", "Loại sản phẩm", "Tên sản phẩm", "Số lượng", "Giá(VND)", "Trạng thái");
        for (Product product : products) {
            if (product.getType().equalsIgnoreCase(type)) {
                System.out.println("\t\t\t\t\n"+ "   "+"ID: "+ product.getId()+ "   "+ product.getName()+ "   "+"Phân loại: "+product.getType()+ "   " +"Giá(VND): "+ product.getPrice());
                found = true;
            }
        }
        if (!found) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t ✖ Không có sản phẩm này ✖");
        }
        System.out.println("=========================================================================================================================");
        employeeView.select();
    }

}
