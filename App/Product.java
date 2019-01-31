import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;


class Product {
    
    //Structure : Information about a product
	int productId;
	String productName;
    int stock;
	double price;
    
    public Product() { } //Parameterless constructor
    
    Product(int pid, String pname, int pst, double ppr) {   //Parameterised constructor
        
        this.productId = pid;
        this.productName = pname;
        this.stock = pst;
        this.price = ppr;
        
    }
    
    //Setter methods
    void setProductId(int productId) { 
        
        this.productId = productId; 
    
    }
    
    void setProductName(String productName) { 
        
        this.productName = productName; 
        
    }
    
    void setProductStock(int stock) { 
        
        this.stock = stock; 
    
    }
    
    void setProductPrice(double price) {
    
        this.price = price; 
    
    }
    
    
    
    
    //Getter methods
    int getProductId() { 
        
        return  productId;
    
    }
    
    String getProductName() { 
    
        return productName; 
    
    }
    
    int getProductStock() { 
        
        return stock; 
    
    }
    
    double getProductPrice() {
    
        return price; 
    
    }


}