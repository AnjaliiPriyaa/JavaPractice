import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;


class Product {
	int productId;
	String productName;
    int stock;
	double price;
    
    public Product() { }
    
    Product(int pid, String pname, int pst, double ppr) {
        this.productId = pid;
        this.productName = pname;
        this.stock = pst;
        this.price = ppr;
    }
    
    @Override
    public String toString(){
        return "\n     "+productId+"     |     "+productName+"     |     "+stock+"      |      "+price;
    }
    
    
    void setProductId(int productId) 
    { this.productId = productId; }
    
    void setProductName(String productName) 
    { this.productName = productName; }
    
    void setProductStock(int stock) 
    { this.stock = stock; }
    
    void setProductPrice(double price) 
    { this.price = price; }
}