package Exam.run;

import Exam.business.ProductRepository;
import Exam.model.ElectronicProduct;
import Exam.model.FoodProduct;
import Exam.model.Product;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        Product elec1 = new ElectronicProduct("1", "Máy giặt", 5000000, 24);
        Product elec2 = new ElectronicProduct("2", "Tủ lạnh", 3000000, 6);

        Product food1 = new FoodProduct("3", "Thịt gà", 100000, 20);
        Product food2 = new FoodProduct("4", "Thịt trâu", 300000, 10);

        if (productRepository.add(elec1)) {
            System.out.println("Thêm sản phẩm thành công!");
        } else {
            System.out.println("Thêm sản phẩm thất bại!");
        }
        if (productRepository.add(elec2)) {
            System.out.println("Thêm sản phẩm thành công!");
        } else {
            System.out.println("Thêm sản phẩm thất bại!");
        }
        if (productRepository.add(food1)) {
            System.out.println("Thêm sản phẩm thành công!");
        } else {
            System.out.println("Thêm sản phẩm thất bại!");
        }
        if (productRepository.add(food2)) {
            System.out.println("Thêm sản phẩm thành công!");
        } else {
            System.out.println("Thêm sản phẩm thất bại!");
        }

//        1. Hiển thị toàn bộ danh sách sản phẩm
        List<Product> allProduct = productRepository.findAll();
        if (allProduct.isEmpty()) {
            System.out.println("Danh sách sản phẩm rỗng!");
        } else {
            System.out.println("Danh sách sản phẩm : ");
            for (Product product : allProduct) {
                product.displayInfo();
                System.out.println("Thành tiền : " + product.calculateFinalPrice());
            }
        }


//        2. Tìm sản phẩm theo id và hiển thị kết quả
        String id = "2";
        Product findProduct = productRepository.findById(id);
        if (findProduct == null) {
            System.out.println("Không tìm thấy sản phẩm!");
        } else {
            System.out.println("\nThông tin sản phẩm : ");
            findProduct.displayInfo();
        }

//        3. Sắp xếp danh sách theo giá tăng dần
        List<Product> sortedProducts = new ArrayList<>(allProduct);

        Collections.sort(sortedProducts, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.calculateFinalPrice(), p2.calculateFinalPrice());
            }
        });

        System.out.println("\nDanh sách đã sắp xếp : ");
        for (Product product : sortedProducts) {
            product.displayInfo();
            System.out.println("Thành tiền : " + product.calculateFinalPrice());
        }

//        4. Thống kê số lượng sản phẩm theo từng loại
        Map<String,Integer> countMap = new LinkedHashMap<>();
        countMap.put("electronic", 0);
        countMap.put("food", 0);
        for (Product product : productRepository.findAll()) {
            if (product instanceof ElectronicProduct) {
                countMap.put("electronic", countMap.get("electronic") + 1);
            } else if (product instanceof FoodProduct) {
                countMap.put("food", countMap.get("food") + 1);
            }
        }

        System.out.println(countMap);
    }
}
