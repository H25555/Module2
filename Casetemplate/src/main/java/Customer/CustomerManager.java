package Customer;
import java.util.*;

public class CustomManager {
    List<Customer> customers;
    private Scanner scanner = new Scanner(System.in);
    public CustomManager() {
        // áp dụng tính chất gì ?
        customers = new ArrayList<>();
        //long id, String full name, String email, String address, Date createaAt
        Customer customer = new Customer(1, "Hưng", "minhhung@gmail.com", "Huế", new Date());
        customers.add(customer);
        customers.add(new Customer(2, "Hân Hoàn", "Hoan@gmail.com", "Huế", new Date()));
        customers.add(new Customer(3, "Nghĩa Bida", "Nghia@gmail.com", "Huế", new Date()));
        customers.add(new Customer(4, "Công Bằng", "Bang@gmail.com", "Huế", new Date()));
        customers.add(new Customer(5, "Thiện", "Thien@gmail.com", "Huế", new Date()));

    }

    public void showCustom() {
        System.out.printf("%5s | %30s | %20s | %30s | %10s \n", "ID", "name", "email", "address", "createaAT");
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.printf("%5s | %30s | %20s | %30s | %10s \n",
                    customer.getId(), customer.getFullname(), customer.getEmail(), customer.getAddress(), customer.getCreateAt());
        }
    }
    public void showCustom(List<Customer> customers) {
        System.out.printf("%5s | %20s | %20s | %10s | %10s \n", "ID", "name", "email", "address", "createaAT");
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.printf("%5s | %20s | %20s | %10s | %10s \n",
                    customer.getId(), customer.getFullname(), customer.getEmail(), customer.getAddress(), customer.getCreateAt());
        }
    }
    //thêm khách hàng
    public void addMembers() {
        System.out.println("Nhập tên khách hàng");
        String Fullname = scanner.nextLine();
        System.out.println("Nhập email");
        String email = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String Address = scanner.nextLine();
//       System.out.println("Nhập ngày thêm khách hàng");
        Comparator comparator = new ComparatorById();
        customers.sort(comparator);
        long maxID = customers.get(customers.size()-1).getId();

        Customer customer = new Customer();
        customer.setId(maxID + 1);
        customer.setFullname(Fullname);
        customer.setEmail(email);
        customer.setAddress(Address);
        customer.setCreateAt(new Date());

        customers.add(customer);

        showCustom();
    }

    //sửa khách hàng
    public void editMembers() {
        System.out.println("Nhập ID mà bạn muốn sửa");
        long id = Long.parseLong(scanner.nextLine());

        System.out.println("Nhập tên mới");
        String newName = scanner.nextLine();
        System.out.println("Nhập email mới");
        String newEmail = scanner.nextLine();
        System.out.println("Nhập địa chỉ mới");
        String newAddress = scanner.nextLine();

        for (int i = 0; i < customers.size(); i++) {
            if (id == customers.get(i).getId()) {
                customers.get(i).setFullname(newName);
                customers.get(i).setEmail(newEmail);
                customers.get(i).setAddress(newAddress);
            }
        }
        showCustom();
    }
    // xoá khách hàng
    public void deleteMembers() {
        System.out.println("Nhập tên mà cưng muốn xoá");
        long id = Long.parseLong(scanner.nextLine());

        for (int i = 0; i < customers.size(); i++) {
            if ( id == customers.get(i).getId()) {
                customers.remove(i);
            }
        } showCustom();
    }
    //7. tìm theo tên
    private void searchByName() {
        System.out.println("Nhập tên mà bạn muốn tìm kiếm");
        String kw = scanner.nextLine();
        List<Customer> results = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getFullname().contains(kw)) {
                results.add(customers.get(i));
            }
        }
        showCustom(results);
    }
    //6. sắp xếp theo ngày tạo
    private void sortByDate() {
        customers.sort(new ComparatorByDate());
        showCustom();
    }
    //5. sắp xếp theo tên
    private void sortByName() {
        customers.sort(new ComparatorByName());
        showCustom();
    }
    //8. tìm kiếm theo email
    private void  searchByNameOrEmail() {
        System.out.println("Nhập tên mà bạn muốn tìm kiếm");
        String kw = scanner.nextLine();
        List<Customer> results = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getFullname().contains(kw) ||customers.get(i).getEmail().contains(kw)) {
                results.add(customers.get(i));
            }
        }
        showCustom(results);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CustomManager customer = new CustomManager();
        boolean checkActionMenu = true;
        do {
            System.out.println("Menu quảng lý thành viên");
            System.out.println("Nhấn 1. Xem danh sách");
            System.out.println("Nhấn 2. Thêm thành viên");
            System.out.println("Nhấn 3. Nhập ID muốn sửa");
            System.out.println("Nhấn 4. Nhập tên muốn xoá");
            System.out.println("Nhấn 5. Sắp xếp khách hàng theo tên");
            System.out.println("Nhấn 6. Sắp xếp khách hàng theo ngày tạo");
            System.out.println("Nhấn 7. Tìm kiếm khách hàng theo tên");
            System.out.println("Nhấn 8. Tìm kiếm khách theo tên hoặc email");
            int actionMenu = Integer.parseInt(scan.nextLine());
            switch (actionMenu) {
                case 1:
                    customer.showCustom();
                    break;
                case 2:
                    customer.addMembers();
                    break;
                case 3:
                    customer.editMembers();
                    break;
                case 4:
                    customer.deleteMembers();
                    break;
                case 5:
                    customer.sortByName();
                    break;
                case 6:
                    customer.sortByDate();
                    break;
                case 7:
                    customer.searchByName();
                    break;
                case 8:
                    customer.searchByNameOrEmail();
                    break;
                default:
                    System.out.println("Nhập sai rồi cưng");

            }
            boolean checkActionMenuContinue = true;
            do {
                System.out.println("Bạn có muốn tiếp tục hay không ? Y/N");
                String actionMenuContinue = scan.nextLine();
                switch (actionMenuContinue) {
                    case "Y":
                        checkActionMenu = true;
                        checkActionMenuContinue = false;
                        break;
                    case "N":
                        checkActionMenu = false;
                        checkActionMenuContinue = false;
                        break;
                    default:
                        checkActionMenuContinue = true;
                }

            } while ( checkActionMenuContinue);
        }           while (checkActionMenu);
    }
}
