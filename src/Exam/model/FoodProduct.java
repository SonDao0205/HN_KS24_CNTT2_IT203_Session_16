package Exam.model;

public class FoodProduct extends Product {
    private int discountPercent;

    public FoodProduct(String id, String name, double price, int discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculateFinalPrice() {
        double price = super.getPrice();
        return price - (price * this.discountPercent / 100);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.print("\nDiscount percent : "+this.discountPercent+"\n");
    }
}
