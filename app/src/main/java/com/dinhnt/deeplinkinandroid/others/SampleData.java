package com.dinhnt.deeplinkinandroid.others;

import com.dinhnt.deeplinkinandroid.models.Product;

import java.util.ArrayList;

public class SampleData {

    public ArrayList<Product> getAll() {
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product("SP01", "Oshi", "bịch", "Việt Nam", 5000));
        list.add(new Product("SP02", "Tea Plus", "chai", "Việt Nam", 12000));
        list.add(new Product("SP03", "Balo", "cái", "Việt Nam", 500000));
        list.add(new Product("SP04", "Mũ", "cái", "Việt Nam", 15000));
        list.add(new Product("SP05", "Ghế", "cái", "Việt Nam", 50000));
        return list;
    }

    public Product getDetail(String masp) {
        Product pr = new Product();
        for (Product product : getAll()) {
            if (product.getMasp().equals(masp)) {
                pr = product;
                break;
            }
        }
        return pr;
    }
}
