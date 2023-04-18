package org.example.service;

import org.example.model.Product;
import org.example.model.Payment;
import org.example.service.impl.PaymentServiceImpl;
import org.example.ultis.CSVUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class PaymentService extends ProductService implements PaymentServiceImpl {
    List<Payment> paymentList = new ArrayList<>();
    private List<Payment> list = new ArrayList<>();
    private String filename = "src/data/payment.csv";
    @Override
    public List<Payment> getPayment() {
        List<Payment> newPaymentList = new ArrayList<>();
        List<String> reads = CSVUtils.read(filename);
        for (String read:reads) {
            String[] payment = read.split(",");

            newPaymentList.add(new Payment(
                    parseInt(payment[0]),
                    parseInt(payment[1]),
                    payment[2],
                    payment[3],
                    payment[4],
                    Long.parseLong(payment[5])
            ));
        }
        return newPaymentList;
    }
    public long showTotal (){
        getPayment();
        long a = 0;
        for (Payment p:paymentList) {
            double x = p.getRevenue();
            a+=x;
        }
        return a;
    }




    @Override
    public void add(Payment newPayment) {
        list = getPayment();
        int id = list.get(list.size() - 1).getId() + 1;
        list.add(newPayment);
        try {
            PrintWriter print = new PrintWriter(filename);
            for (Payment item: list) {
                String res = id + "," + item.getQuantity() + "," +item.getName() + "," + item.getPhoneNumber() + "," + item.getAddress() + "," + item.getRevenue();
                print.println(res);
            }
            print.flush();
            print.close();

        } catch (IOException e) {

        }

    }



}
