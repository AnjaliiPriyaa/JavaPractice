import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;


class Operations {
    List<Product> items = new ArrayList<Product>();
    Product p = new Product();
    Scanner scan = new Scanner(System.in);
    int pid1, pst1;
    double ppr1;
    String pname1;
    boolean condition = true;
    
    
    
    public void userInterface() {
        
        while(condition == true) {
            //scan.nextLine();
			System.out.println("\n--What would you like to do?--\n");
			System.out.println("1. Insert new product \n2. Update existing product \n3. Display product information \n4. Delete a product \n5. Exit Store");
			System.out.println("\nChoose option number (between 1-5):");
		     int choice = 0; 
            
            try { 
                choice = scan.nextInt();
            }
            catch(InputMismatchException e) {
                System.out.println("\nPlease enter a number between 1-5!");
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
                display();
				break;
                    
			case 4:
				//call del fn
                deleteProduct();
				break;
                    
			case 5:
                System.out.println("*************Thank you***************");
				condition = false;
                break;
                    
			default:
				System.out.println("Invalid Input, try again!");
                scan.nextLine();
                userInterface();
				break;
			}
		}
    }
    
     /*void getProductId() {
		  try { 
            System.out.print("Enter:");
              scan.nextLine();
            pid1 = scan.nextInt();
            scan.nextLine();
            }
          catch(InputMismatchException e) {
            System.out.println("\nInvalid input type, try again!");
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
    */
    
    
    
    public void insertNewProduct() {
		System.out.println("Enter the following details to add product:");
        int n = 0;

		System.out.println("\n\nProduct ID (Number):");
        while(n == 0) {
            try {
                pid1 = scan.nextInt();
                n = 1;
            }
          catch(InputMismatchException e) {
                System.out.println("\nInvalid input type, try again!");
                scan.nextLine();
                continue;
          }
        }
        
        scan.nextLine();
		System.out.println("\n\nProduct Name (String):");
        pname1 = scan.nextLine();
        
		System.out.println("\n\nProduct Stock (Integer) :");
		n = 0;
        while(n == 0) {
            try {
                pst1 = scan.nextInt();
                n = 1;
            }
          catch(InputMismatchException e) {
                System.out.println("\nInvalid input type, try again!");
                scan.nextLine();
                continue;
          }
        }
        
        System.out.println("\n\nProduct Price (Double) :");
		n = 0;
        while(n == 0) {
            try {
                ppr1 = scan.nextDouble();
                n = 1;
            }
          catch(InputMismatchException e) {
                System.out.println("\nInvalid input type, try again!");
                scan.nextLine();
                continue;
          }
        }
        
        items.add(new Product(pid1, pname1, pst1, ppr1));
        displayProducts();
    }
    
    public void updateProduct() {
        System.out.println("\n\nUpdate product by: \n\n1. Id \n\n2.Name \n\nEnter your choice:");
        int ch = 0;
        int n = 0;
        
        while(n == 0) {
            try {
                ch = scan.nextInt();
                n = 1;
            }
          catch(InputMismatchException e) {
                System.out.println("\nInvalid input type, try again!");
                scan.nextLine();
                continue;
          }
        }
        
        switch (ch) {
            case 1: 
                updateProductById();
                break;
                
            case 2:
                updateProductByName();
                break;
                
            default:
                System.out.println("Try again. Enter option no. 1 or 2.\n");
                updateProduct();
				break;
        }
    }
    
    public void updateProductById() {
        System.out.println("\nEnter the 'Product ID' of the desired product:");
        int pid=0, n=0;
        
        while(n == 0) {
            try {
                pid = scan.nextInt();
                n = 1;
            }
          catch(InputMismatchException e) {
                System.out.println("\nInvalid input type, try again!");
                scan.nextLine();
                continue;
          }
        }
        
        
        int index = -1;
        
        for (Product p1: items) 
        {
            if (p1.productId == pid) {
                //System.out.println(index);
                index = items.indexOf(p1);
                break;
            }
            else {
                //index++;
                continue;
            }
            //index++;
        }
        
            
            
        if(index == -1) {
            System.out.println("\nId does not match!");
            //updateProductById();
        }
                
        else {
            System.out.println("\nProduct ID to be updated:" +pid);
        
            String pname;
            int pst = 0;
            double ppr = 0;
        
            System.out.println("\nDo you want to update Product Name? Press 'y' for yes or any other key to go the next menu:");
            char x = scan.next().charAt(0);
            if (x == 'y') {
                //scan.nextLine();
                System.out.println("Enter the product name:");
                scan.nextLine();
                pname = scan.nextLine();
                items.get(index).setProductName(pname);
            }
        
            System.out.println("\nDo you want to update Product Stock? Press 'y' for yes or any other key to go the next menu:");
            x = scan.next().charAt(0);
            if (x == 'y') {
                System.out.println("Enter the product Stock:");
                scan.nextLine();
                
                n =0 ;
                while(n == 0) {
                    try {
                        pst = scan.nextInt();
                        n = 1;
                    }
                    
                    catch(InputMismatchException e) {
                        System.out.println("\nInvalid input type, try again!");
                        scan.nextLine();
                        continue;
                    }
                }
                items.get(index).setProductStock(pst);
            }
        
            System.out.println("\nDo you want to update Product Price? Press 'y' for yes or any other key to go the next menu:");
            x = scan.next().charAt(0);
            if (x == 'y') {
                System.out.println("Enter the product price:");
                scan.nextLine();
                
                n =0 ;
                while(n == 0) {
                    try {
                        ppr = scan.nextDouble();
                        n = 1;
                    }
                    
                    catch(InputMismatchException e) {
                        System.out.println("\nInvalid input type, try again!");
                        scan.nextLine();
                        continue;
                    }
                }
                
                items.get(index).setProductPrice(ppr);
            }
        
            //items.set(index, new Product(pid, pname, pst, ppr));
            displayProducts();
            //scan.nextLine();
        }
    }
    
    public void updateProductByName() {
        scan.nextLine();
        System.out.println("\nEnter the 'Product Name' of the desired product:");
        String pname = scan.nextLine(); 
        
        int index = -1;
                
        for (Product p1: items) 
        {
            if (p1.productName.equals(pname)) {
                //System.out.println(index);
                index = items.indexOf(p1);
                break;
            }
            else {
                //index++;
                continue;
            }
            //index++;
        }
        
            
            
        if(index == -1) {
            System.out.println("\nName does not match!");
        }
             
        else {
            int pid = 0;
            int pst = 0;
            double ppr = 0;
            int n = 0;
            
            System.out.println("\nDo you want to update Product ID? Press 'y' for yes or any other key to skip this and update other details:");
            char x = scan.next().charAt(0);
            if (x == 'y') {
                //scan.nextLine();
                System.out.println("Enter the product ID:");
                scan.nextLine();
                
                n = 0 ;
                while(n == 0) {
                    try {
                        pid = scan.nextInt();
                        n = 1;
                    }
                    
                    catch(InputMismatchException e) {
                        System.out.println("\nInvalid input type, try again!");
                        scan.nextLine();
                        continue;
                    }
                }
                items.get(index).setProductId(pid);
            }
        
        
        
            System.out.println("\nDo you want to update Product Stock? Press 'y' for yes or any other key to skip this and update other details:");
            x = scan.next().charAt(0);
            if (x == 'y') {
                System.out.println("Enter the product Stock:");
                scan.nextLine();
                
                n = 0 ;
                while(n == 0) {
                    try {
                        pst = scan.nextInt();
                        n = 1;
                    }
                    
                    catch(InputMismatchException e) {
                        System.out.println("\nInvalid input type, try again!");
                        scan.nextLine();
                        continue;
                    }
                }
                items.get(index).setProductStock(pst);
             }



            System.out.println("\nDo you want to update Product Price? Press 'y' for yes or any other key to skip this:");
            x = scan.next().charAt(0);
            if (x == 'y') {
                System.out.println("Enter the product price:");
                scan.nextLine();
                
                n = 0 ;
                while(n == 0) {
                    try {
                        ppr = scan.nextDouble();
                        n = 1;
                    }
                    
                    catch(InputMismatchException e) {
                        System.out.println("\nInvalid input type, try again!");
                        scan.nextLine();
                        continue;
                    }
                }
                items.get(index).setProductPrice(ppr);
            }
        
        
            //Displaying products after update
            displayProducts();
        }
    }
    
    public void displayProducts() {
        System.out.println("\n| Product Id | Product Name | Product Stock | Product Price | \n");
        System.out.println(items);
    }
    
    public void display() {
        System.out.println("How would you like to display? \n1. Display selected products \n2. Display entire list \n\nEnter your choice:");
        int ch = 0;
        int n = 0;
        
        while(n == 0) {
            try {
                ch = scan.nextInt();
                n = 1;
            }
          catch(InputMismatchException e) {
                System.out.println("\nInvalid input type, try again!");
                scan.nextLine();
                continue;
          }
        }
        
        switch(ch) {
            case 1:
                displayByChoice();
                break;
                
            case 2:
                displayProducts();
                break;
            
            default:
                System.out.println("Invalid input, try again!");
                display();
                break;
                }
    }
    
    public void displayByChoice() {
        System.out.println("\n\nDisplay product by: \n\n1. Id \n\n2.Name \n\nEnter your choice:");
        int ch=0, n=0;
        
        while(n == 0) {
            try {
                ch = scan.nextInt();
                n = 1;
            }
          catch(InputMismatchException e) {
                System.out.println("\nInvalid input type, try again!");
                scan.nextLine();
                continue;
          }
        }
        
        switch (ch) {
            case 1: 
                displayProductById();
                break;
                
            case 2:
                displayProductByName();
                break;
                
            default:
                System.out.println("Try again. Enter option no. 1 or 2.\n");
                updateProduct();
				break;
        }
        
    }
    
    public void displayProductById() {
        System.out.println("\nEnter the 'Product ID' of the desired product:");
        int pid=0, n=0;
        
        while(n == 0) {
            try {
                pid = scan.nextInt();
                n = 1;
            }
          catch(InputMismatchException e) {
                System.out.println("\nInvalid input type, try again!");
                scan.nextLine();
                continue;
          }
        }
        
        int index = -1;
        
        for (Product p1: items) 
        {
            if (p1.productId == pid) {
                //System.out.println(index);
                index = items.indexOf(p1);
                break;
            }
            else {
                //index++;
                continue;
            }
            //index++;
        }
        
            
            
        if(index == -1) {
            System.out.println("\nId does not match!");
            //updateProductById();
        }
                
        else {
            System.out.println("\nProduct ID to be diplayed:" +pid);
            System.out.println("\n| Product Id | Product Name | Product Stock | Product Price | \n");
            System.out.println(items.get(index));
        }
    }
    
    public void displayProductByName() {
        scan.nextLine();
        System.out.println("\nEnter the 'Product Name' of the desired product:");
        String pname = scan.nextLine(); 
        
        int index = -1;
        
        for (Product p1: items) {
            if (p1.productName.equals(pname)) {
                //System.out.println(index);
                index = items.indexOf(p1);
                break;
            } 
            else {
                continue;
            }
            //index++;
        }
        
        
        if(index == -1) {
            System.out.println("\nName does not match!");
            //updateProductById();
        }
                
        else {
            System.out.println("\nProduct Name to be diplayed:" +pname);
            System.out.println("\n| Product Id | Product Name | Product Stock | Product Price | \n");
            System.out.println(items.get(index));
        }
    }
    
    
    public void deleteProduct() {
        System.out.println("Delete product by \n1. Id \n2.Name \nEnter your choice");
        int ch=0, n=0;
        int pid = 0;
        
        while(n == 0) {
            try {
                ch = scan.nextInt();
                n = 1;
            }
          catch(InputMismatchException e) {
                System.out.println("\nInvalid input type, try again!");
                scan.nextLine();
                continue;
          }
        }
        n = 0;
        int index = -1;
        
        switch (ch) {
            case 1: 
                System.out.println("Enter the product ID:");
                while(n == 0) {
                    try {
                        pid = scan.nextInt();
                        n = 1;
                    }
                    catch(InputMismatchException e) {
                        System.out.println("\nInvalid input type, try again!");
                        scan.nextLine();
                        continue;
                    }
                }   
                
                for (Product p1: items) {
                    if (p1.productId == pid) {
                        //System.out.println(index);
                        index = items.indexOf(p1);
                        break;
                    } 
                    else {
                        continue;
                    }
                    //index++;
                }
        
        
                if(index == -1) {
                    System.out.println("\nId does not match!");
                    //updateProductById();
                }

                else {
                    items.remove(index);
                    index = -1;
                }
                    break;
                
            case 2:
                scan.nextLine();
                System.out.println("Enter the product Name:");
                scan.nextLine();
                String pname = scan.nextLine();
                
                for (Product p1: items) {
                    if (p1.productName.equals(pname)) {
                        //System.out.println(index);
                        index = items.indexOf(p1);
                        break;
                    } 
                    else {
                        continue;
                    }
                }
                
                if(index == -1) {
                    System.out.println("\nName does not match!");
                    //updateProductById();
                }

                else {
                    items.remove(index);
                    index = -1;
                }
                break;
                
            default:
                System.out.println("Invalid Input, try again.\n");
                deleteProduct();
				break;
        }
        
        displayProducts();
    }
    
}