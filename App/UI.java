import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException; 
    
class UI {  
    public void userInterface() {
        
        Operations o = new Operations();
        Scanner scan = new Scanner(System.in);
        boolean condition = true;

        while(condition) {
            
			System.out.println("\n--What would you like to do?--\n");
			System.out.println("1. Add new product  \n2. Update existing product \n3. Display product information \n4. Delete a product \n5. Exit Store");
			System.out.println("\nChoose option number (between 1-5):");
            
            int choice = 0; 
            
            
            //Exceptional handling
            try { 
                choice = scan.nextInt();
            }
            
            catch(InputMismatchException e) {
                System.out.println("\nPlease enter a number between 1-5!");
            }
            
            
            
            
			switch(choice) {
                    
                case 1:
                    //calling insert fn
                    o.insertNewProduct();
                    break;

                case 2:
                    //calling update fn
                    o.updateProduct();
                    break;

                case 3: 
                    //calling display fn
                    o.display();
                    break;

                case 4:
                    //calling delete fn
                    o.deleteProduct();
                    break;

                case 5:
                    //Exiting store menu
                    System.out.println("*************Thank you***************");
                    condition = false;
                    break;

                default:
                    System.out.println("Invalid Input, try again!");
                    scan.nextLine();
                    continue;
                    
			}
            
		}
    }
    
}