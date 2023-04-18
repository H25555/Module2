package org.example.ultis;



import org.example.model.Product;

import java.util.Comparator;

    public class PriceSortASC implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            return (int) ((int)o1.getPrice() - (int)o2.getPrice());
        }
    }

