package org.example.service;

import org.example.model.Product;
import org.example.model.ProductType;
import org.example.model.Product;
import org.example.model.Product;
import org.example.service.impl.ProductServiceImpl;
import org.example.ultis.CSVUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ProductService implements ProductServiceImpl {
    private List<Product> list = new ArrayList<>();
    private String filename = "src/data/product.csv";
    @Override
    public List<Product> getListProduct() {
        List<Product> newProductList = new ArrayList<>();
        List<String> reads = CSVUtils.read(filename);
        for (String read:reads) {
            String[] product = read.split(",");

            newProductList.add(new Product(
                    parseInt(product[0]),
                    product[1],
                    product[2],
                    Double.parseDouble(product[3])
            ));
        }
        return newProductList;
    }

    @Override
    public Product getProductDetail(int productId) {
        list = getListProduct();
        for (Product product: list){
            if (product.getId() == productId){
                return product;
            }
        }
        return null;
    }

    @Override
    public void add(Product newProduct) {
        list = getListProduct();
        list.add(newProduct);
        try {
            PrintWriter print = new PrintWriter(filename);
            for (Product item: list) {
                String res = item.getId() + "," + item.getName() + "," +item.getType() + "," + item.getPrice();
                print.println(res);
            }
            print.flush();
            print.close();

        } catch (IOException e) {

        }

    }

    @Override
    public boolean update(int productId, Product updtProduct) {
        list = getListProduct();
        for (Product product: list){
            if (product.getId() == productId){
                product.setName(updtProduct.getName());
                product.setType(updtProduct.getType());
                product.setPrice(updtProduct.getPrice());

            }

        }
        try {
            PrintWriter print = new PrintWriter(filename);
            for (Product item: list) {
                String res = item.getId() + "," + item.getName() + "," +item.getType() + "," + item.getPrice();
                print.println(res);
            }
            print.flush();
            print.close();
            return true;
        } catch (IOException e) {

        }
        return false;
    }

    @Override
    public boolean delete(int productId) {
        list = getListProduct();
        Product product = this.getProductDetail(productId);
        if (product != null) {
            list.remove(product);
            try {
                PrintWriter print = new PrintWriter(filename);
                for (Product item: list) {
                    String res = item.getId() + "," + item.getName()  + "," + item.getType() + "," +item.getPrice();
                    print.println(res);
                }
                print.flush();
                print.close();
                return true;
            } catch (IOException e) {

            }
            return true;
        }
        return false;
    }
    public boolean existProduct(int id){
        list = getListProduct();

        for (Product product: list) {
            if (product.getId() == id){
                return true;
            }
        }
        return false;
    }
    public Product findProductbyID(int id){
        list = getListProduct();
        for (Product product : list) {
            if (product.getId() == id){
                return product;
            }
        }
        System.out.println("\t\t\t\tKhông có sản phẩm này");
        return null;
    }
}
