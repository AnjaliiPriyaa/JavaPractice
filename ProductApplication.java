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
    
    /*int getProductId() 
    { return productId; }
    
    String getProductName() 
    { return productName; }
    
    int getProductStock() 
    { return stock; }
    
    double getProductPrice() 
    { return price; }*/
    
    
    
    void setProductId(int productId) 
    { this.productId = productId; }
    
    void setProductName(String productName) 
    { this.productName = productName; }
    
    void setProductStock(int stock) 
    { this.stock = stock; }
    
    void setProductPrice(double price) 
    { this.price = price; }
}

class Operations {
    List<Product> items = new ArrayList<Product>();
    Product p = new Product();
    Scanner scan = new Scanner(System.in);
    int pid1, pst1;
    double ppr1;
    String pname1;
    boolean condition = true;
    
   public int inputFunction() {
        int n = 0;
        try { 
            n = scan.nextInt();
            scan.nextLine();
        }
            
        catch(InputMismatchException e) {
            System.out.println("Invalid input type, enter again:");
            scan.nextLine();
            inputFunction();
        }
        return n;
    }
    
    public String inputFunctionSt() {
        String n = " ";
        try { 
            n = scan.nextLine();
            scan.nextLine();
        }
            
        catch(InputMismatchException e) {
            System.out.println("Invalid input type, enter again:");
            scan.nextLine();
            inputFunctionSt();
        }
        return n;
    }
    
    public Double inputFunctionDb() {
        Double n = 0.0;
        try { 
            n = scan.nextDouble();
            scan.nextLine();
        }
            
        catch(InputMismatchException e) {
            System.out.println("Invalid input type, enter again:");
            scan.nextLine();
            inputFunctionDb();
        }
        return n;
    }

    
    public void userInterface() {
        
        while(condition == true) {
            //scan.nextLine();
			System.out.println("\n--What would you like to do?--\n");
			System.out.println("1. Insert new product \n2. Update existing product \n3. Display product information \n4. Delete a product \n5. Exit Store");
			System.out.println("\nChoose option number:");
		     int choice = 0; 
            
            try { 
                //System.out.print("Enter:");
                //scan.nextLine();
                choice = scan.nextInt();
                //scan.nextLine();
            }
            catch(InputMismatchException e) {
                System.out.println("\nInput type does not match!");
                //scan.nextLine();
                //userInterface();
                //choice = 6;
            }
            
			switch(choice) {
			case 1:
				//call insert fn
                insertNewProduct();
				break;
                    
			case 2:
				//call update fn
                updateProduct();
				break;
                    
			case 3: 
				//call display fn
                displayProducts();
				break;
                    
			case 4:
				//call del fn
                deleteProduct();
				break;
                    
			case 5:
                System.out.println("*************Thank you***************");
				condition = false;
                //System.exit();
                    break;
                    
			default:
				System.out.println("Invalid Input, try again! ");
                    scan.nextLine();
                userInterface();
				break;
			}
		}
    }
    
     void getProductId() {
		  try { 
            System.out.print("Enter:");
              scan.nextLine();
            pid1 = scan.nextInt();
            scan.nextLine();
            }
          catch(InputMismatchException e) {
            System.out.println("\nInvalid input type, try again!");
              //scan.nextInt();
            getProductId();
          }
        }
    
    void getProductName() {
		  try { 
           // System.out.print("Enter:");
              //scan.nextLine();
            pname1 = scan.nextLine();
          }
          catch(InputMismatchException e) {
            System.out.println("\nInvalid input type, try again!");
            getProductName();
          }
        }
    
    
    void getProductStock() {
		  try { 
            //System.out.print("Enter:");
              //scan.nextLine();
            pst1 = scan.nextInt();
              //scan.nextLine();
              
          }
          catch(InputMismatchException e) {
            System.out.println("\nInvalid input type, try again!");
              scan.nextLine();
            getProductStock();
          }
        }
    
    
    void getProductPrice() {
		  try { 
           // System.out.print("Enter:");
             // scan.nextLine();
            ppr1 = scan.nextDouble();
             // scan.nextLine();
          }
          catch(InputMismatchException e) {
            System.out.println("\nInvalid input type, try again!");
              scan.nextLine();
            getProductPrice();
          }
        }
    
    public void insertNewProduct() {
		System.out.println("Enter the following details to add product:");

		System.out.println("\n\nProduct ID (Integer):");
        getProductId();
        
		System.out.println("\n\nProduct Name (String):");
        getProductName();
        
		System.out.println("\n\nProduct Stock (Integer) :");
		getProductStock(); 
        
        System.out.println("\n\nProduct Price (Double) :");
		getProductPrice(); 
        
        items.add(new Product(pid1, pname1, pst1, ppr1));
        displayProducts();
    }
    
    public void updateProduct() {
        System.out.println("\n\nUpdate product by: \n\n1. Id \n\n2.Name \n\nEnter your choice:");
        int ch;
        /*try { ch = scan.nextInt(); }
        catch(InputMismatchException e) {
                System.out.println("Invalid input type");
                ch = scan.nextInt();
        }*/
        ch = inputFunction();
        
        switch (ch) {
            case 1: 
                updateProductById();
                break;
            case 2:
                updateProductByName();
                break;
            default:
                System.out.println("Try again.\n");
                updateProduct();
				break;
        }
    }
    
    public void updateProductById() {
        System.out.println("\nEnter the 'Product ID' of the desired product:");
        int pid = inputFunction();
        System.out.println("\nProduct ID to be updated:" +pid);
        int index = 0;
        for (Product p1: items) {
            if (p1.productId == pid) {
                //System.out.println(index);
                break;
            }
            else {
                System.out.println("\nId does not match!");
                updateProduct();
            }
            index++;
        }
                
        String pname;
        int pst;
        double ppr;
        
        System.out.println("\nDo you want to update Product Name? Press 'y' for yes or any other key to go the next menu:");
        char x = scan.next().charAt(0);
        if (x == 'y') {
            scan.nextLine();
            System.out.println("Enter the product name:");
            scan.nextLine();
            pname = inputFunctionSt();
            items.get(index).setProductName(pname);
        }
        
        System.out.println("\nDo you want to update Product Stock? Press 'y' for yes or any other key to go the next menu:");
        x = scan.next().charAt(0);
        if (x == 'y') {
            System.out.println("Enter the product Stock:");
            scan.nextLine();
            pst = inputFunction();
            items.get(index).setProductStock(pst);
        }
        
        System.out.println("\nDo you want to update Product Price? Press 'y' for yes or any other key to go the next menu:");
        x = scan.next().charAt(0);
        if (x == 'y') {
            System.out.println("Enter the product price:");
            ppr = inputFunctionDb();
            items.get(index).setProductPrice(ppr);
        }
        
        //items.set(index, new Product(pid, pname, pst, ppr));
        displayProducts();
    }
    
    public void updateProductByName() {
        scan.nextLine();
        System.out.println("\nEnter the 'Product Name' of the desired product:");
        String pname = " ";
        try { pname = scan.nextLine(); }
        catch(InputMismatchException e) {
                System.out.println("Invalid input type, enter again:");
                //pname = scan.nextLine();
        }
        
        int index = 0;
        for (Product p1: items) {
            if (p1.productName.equals(pname)) {
                //System.out.println(index);
                break;
            } 
            else {
                System.out.println("\nName does not match!");
                updateProduct();
            }
            index++;
        }
                
        int pid;
        int pst;
        double ppr;
        
        System.out.println("\nDo you want to update Product ID? Press 'y' for yes or any other key to go the next menu:");
        char x = scan.next().charAt(0);
        if (x == 'y') {
            //scan.nextLine();
            System.out.println("Enter the product ID:");
            pid = scan.nextInt();
            items.get(index).setProductId(pid);
        }
        
        System.out.println("\nDo you want to update Product Stock? Press 'y' for yes or any other key to go the next menu:");
        x = scan.next().charAt(0);
        if (x == 'y') {
            System.out.println("Enter the product Stock:");
            pst = scan.nextInt();
            items.get(index).setProductStock(pst);
         }
        
        System.out.println("\nDo you want to update Product Price? Press 'y' for yes or any other key to go the next menu:");
        x = scan.next().charAt(0);
        if (x == 'y') {
            System.out.println("Enter the product price:");
            ppr = scan.nextDouble();
            items.get(index).setProductPrice(ppr);
        }
        
        //items.set(index, new Product(pid, pname, pst, ppr));
        displayProducts();
    }
    
    public void displayProducts() {
        System.out.println("\n| Product Id | Product Name | Product Stock | Product Price | \n");
        System.out.println(items);
    }
    
    public void displayChoice() {
        System.out.println("How would you like to display? \n1. Display selected products \n2. Display entire list \n\nEnter your choice:");
        int ch = scan.nextInt();
        
        switch(ch) {
            case 1:
                
            case 2:
                displayProducts();
                break;
            default:
                System.out.println("Invalid input, try again!");
                displayChoice();
                break;
        }
    }
    
    public void deleteProduct() {
        System.out.println("Delete product by \n1. Id \n2.Name \nEnter your choice");
        int ch = scan.nextInt();
        int index = 0;
        switch (ch) {
            case 1: 
                System.out.println("Enter the product ID:");
                int pid = scan.nextInt();
                
                for (Product p1: items) {
                    if (p1.productId == pid) {
                        //System.out.println(index);
                        break;
                    } 
                    //else { System.out.println("\nID does not match!");
                    index++;
                }
                
                items.remove(index);
                break;
                
            case 2:
                scan.nextLine();
                System.out.println("Enter the product Name:");
                String pname = scan.nextLine();
                
                for (Product p1: items) {
                    if (p1.productName.equals(pname)) {
                        //System.out.println(index);
                        break;
                    } 
                    index++;
                }
                
                items.remove(index);
                break;
                
            default:
                System.out.println("Invalid Input, try again.\n");
                deleteProduct();
				break;
        }
        
        displayProducts();
    }
    
}
        
        





public class ProductApplication {
    
	public static void main(String args[]) {
		System.out.println("\n\n******************___Welcome to AP's Bakery___***********************");
        Operations o = new Operations();
        o.userInterface();
	}
}