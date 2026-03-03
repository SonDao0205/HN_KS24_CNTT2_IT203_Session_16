package Exam.model;

public class ElectronicProduct extends Product {
    private int warrantyMonths;

    public ElectronicProduct(String id, String name, double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateFinalPrice() {
        if(this.warrantyMonths > 12){
            return super.getPrice() + 1000000;
        }else{
            return super.getPrice();
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.print("\nwarranty months : "+this.warrantyMonths + "\n");
    }
}
