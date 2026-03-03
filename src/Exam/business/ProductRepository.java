package Exam.business;

import Exam.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductRepository implements IRepository<Product> {
    ArrayList<Product> products = new ArrayList<>();
    HashMap<String,Product> productMap = new HashMap<>();

    @Override
    public boolean add(Product item) {
        if(item == null) return false;
        productMap.put(item.getId(),item);
        return products.add(item);
    }

    @Override
    public boolean removeById(String id) {
        Product product = productMap.get(id);
        if(product!=null){
            products.remove(product);
            productMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Product findById(String id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return List.of(products.toArray(new Product[0]));
    }
}
