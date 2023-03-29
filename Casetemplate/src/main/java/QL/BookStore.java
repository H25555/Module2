package QL;

import java.util.*;

public class BookStore {
        List<Book> books;
        private Scanner scanner = new Scanner(System.in);
        public BookStore(){
            books = new ArrayList<>();
            Book book = new Book(1L, "Chị Dậu", "Chị Dậu", new Date(), 120000);
            books.add(book);
            books.add(new Book(23L, "Chí Phèo", "Chí Phèo", new Date(), 300000));
            books.add(new Book(211L, "Injustice", "A product from Dc comic", new Date(), 288000));
        }
        public void showBooks(){
            System.out.printf("%5s | %30s | %20s | %30s | %10s \n", "ID", "Name", "Description", "Date", "Price");
            for (int i = 0;i < books.size(); i++){
                Book book = books.get(i);
                System.out.printf("%5s | %30s | %20s | %30s | %10s \n",
                        book.getId(),book.getName(),book.getDescription(),
                        book.getEntryDate(), book.getPrice());
            }
        }
        public void showBooks(List<Book> books){
            System.out.printf("%5s | %30s | %20s | %30s | %10s \n", "ID", "Name", "Description", "Date", "Price");
            for (int i = 0; i < books.size(); i++){
                Book book = books.get(i);
                System.out.printf("%5s | %30s | %20s | %30s | %10s \n",
                        book.getId(),book.getName(),book.getDescription(),
                        book.getEntryDate(), book.getPrice());
            }
        }
        public void addbook(){
            System.out.println("Nhập thông tin sách:");
            System.out.println("Nhập tên sách:");
            String name = scanner.nextLine();
            System.out.println("Nhập mô tả");
            String description = scanner.nextLine();
            System.out.println("Nhập giá");
            double price = Double.parseDouble(scanner.nextLine());
            Comparator comparator = new ComparatorById();
            books.sort(comparator);
            long maxId = books.get(books.size()-1).getId();
            Book book = new Book();
            book.setId(maxId+1);
            book.setName(name);
            book.setDescription(description);
            book.setEntryDate(new Date());
            book.setPrice(price);
            books.add(book);
            showBooks();
        }
        public void editBook(){
            System.out.println("Nhập ID Của sách");
            Long id = Long.parseLong(scanner.nextLine());
            System.out.println("Nhập tên mới:");
            String newname = scanner.nextLine();
            System.out.println("Nhập mô tả:");
            String newdescription = scanner.nextLine();
            System.out.println("Nhập giá mới");
            double newprice = Double.parseDouble(scanner.nextLine());

            for (int i = 0; i < books.size();i++){
                if (id == books.get(i).getId()){
                    books.get(i).setName(newname);
                    books.get(i).setPrice(newprice);
                    books.get(i).setDescription(newdescription);
                }
            }
            showBooks();
        }
        public void deleteBook(){
            System.out.println("Nhập id sách muốn xóa:");
            long id = Long.parseLong(scanner.nextLine());

            for (int i = 0; i < books.size(); i++){
                if(id == books.get(i).getId()){
                    books.remove(i);
                }
            }
            showBooks();
        }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BookStore bookStore = new BookStore();
        boolean checkActionMenu = true;
        do {
            System.out.println("Menu quản lý sách: ");
            System.out.println("Nhấn 1. Xem danh sách");
            System.out.println("Nhấn 2. Thêm sách");
            System.out.println("Nhấn 3. Sửa sách");
            System.out.println("Nhấn 4. Xóa sách");
            System.out.println("Nhấn 5. Sắp xếp sách theo giá ");
            System.out.println("Nhấn 6. Sắp xếp sách theo tên ");
            System.out.println("Nhấn 7. Tìm kiếm sách theo tên");
            int actionMenu = Integer.parseInt(scan.nextLine());
            switch (actionMenu){
                case 1:
                    bookStore.showBooks();
                    break;
                case 2:
                    bookStore.addbook();
                    break;
                case 3:
                    bookStore.editBook();
                    break;
                case 4:
                    bookStore.deleteBook();
                    break;
                case 5:
                    bookStore.sortByPrice();
                    break;
                case 6:
                    bookStore.sortByname();
                    break;
                case 7:
                    bookStore.searchByName();
                    break;
                default:
                    System.out.println("Không hợp lệ. Vui lòng nhập lại !!!");
            }
            boolean checkActionMenuContinue = true;
            do {
                System.out.println("Bạn có muốn tiếp tục hay không: Y/N");
                String actionMenuContinue = scan.nextLine();
                switch (actionMenuContinue){
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
            } while (checkActionMenuContinue);
        }while (checkActionMenu);
    }
    private void searchByName(){
        System.out.println("Nhập tên bạn muốn tìm kiếm: ");
        String kw = scanner.nextLine();
        List<Book> results = new ArrayList<>();
        for (int i = 0; i < books.size(); i++){
            if (books.get(i).getName().contains(kw)){
                results.add(books.get(i));
            }
        }
        showBooks(results);
    }
    private void sortByname(){
            books.sort(new ComparatorByName());
            showBooks();
    }
    private void sortByPrice(){
            books.sort(new ComparatorByPrice());
            showBooks();
    }
}
