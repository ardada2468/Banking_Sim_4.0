import java.util.ArrayList;
import java.util.Scanner;

public   class Bank_Company {
    private ArrayList<String> Bank_Customer_UserName = new ArrayList<>();
    private ArrayList<String> Bank_Customer_Password = new ArrayList<>();
    private ArrayList<String> Bank_Customer_Names = new ArrayList<>();
    private ArrayList<Double> Bank_Customer_Balance = new ArrayList<>();
    private ArrayList<String> Bank_Customer_Email = new ArrayList<>();
    private ArrayList<String> Bank_Customer_Phone =new ArrayList<>();
    private ArrayList<String> Bank_Customer_Address=new ArrayList<>();
    private ArrayList<String> Bank_Customer_Transactions = new ArrayList<>();
    private ArrayList<Integer> Bank_Customer_ID_Number = new ArrayList<>();
    private ArrayList<String> Bank_Employees_UserName = new ArrayList<>();
    private ArrayList<String> Bank_Employees_Name = new ArrayList<>();
    private ArrayList<String> Bank_Employees_Password = new ArrayList<>();
    private ArrayList<String> Bank_Employees_History = new ArrayList<>();
    private ArrayList<Integer> Bank_Employees_Level = new ArrayList<>();
    private ArrayList<Integer> Bank_Employees_ID_Number = new ArrayList<>();

    private String BankCompanyName;
    private int Customer_i = 0;
    private int Employee_i = 0;

    private int CustomerID_Number;
    private int EmployIDNumber;
    private boolean PassCorrect = false;
    private boolean Login = false;
    private boolean EmployeeLogin = false;
    private boolean EmployeePassCorrect = false;

    public class Bank_Employees {

        public Bank_Employees(String name, String username, String password, int level) {
            Bank_Employees_Name.add(Employee_i, name);
            Bank_Employees_UserName.add(Employee_i,username);
            Bank_Employees_Password.add(Employee_i,password);
            Bank_Employees_Level.add(Employee_i, level);
            Bank_Employees_History.add(Employee_i, "<Employee Added>");
            Bank_Employees_ID_Number.add(Employee_i,Employee_i);
            Employee_i++;
        }
    }

    public final void Employee_Directions(){
        System.out.println("Enter 'f' to search customers; Level -- 2;");
        System.out.println("Enter 'u' to update existing customer details; level -- 2; Requires Customer Password!");
        System.out.println("Enter 'd' to initiate the termination of an account; level -- 3; Requires Customer Password;");
        System.out.println("Enter 'add' to create a new account level -- 1");
        System.out.println("Enter 'r' to freeze an account; level -- 3;");
        System.out.println("Enter 'w' to withdraw money; level -- 2; Requires Customer Password;");
        System.out.println("Enter 'h' to view your history");
        System.out.println("Enter 'history' to view other employees history -- level 3 ");
    }

    public final void EmployeeUI(){
        EmpolyeeLogin();
        if(EmployeeLogin){
        Employee_Directions();
        Boolean Quit = false;
        while (!Quit){
            Scanner Userinput = new Scanner(System.in);
            String UserinputSTR = Userinput.nextLine();
            if(UserinputSTR.equals("f")){
                Search();
            }else if (UserinputSTR.equals("u")){
                UpdateCustomerDetails();
            }else if(UserinputSTR.equals("d")){
                System.out.println("that is not configured");
            }else if(UserinputSTR.equals("add")){
                System.out.println("that is not configured");
            }else if(UserinputSTR.equals("r")){
                System.out.println("that is not configured");
            }else if(UserinputSTR.equals("w")){
                System.out.println("that is not configured");
            }else if(UserinputSTR.equals("h")){
                System.out.println(Bank_Employees_History.toString());
                UpdateHistory("Viewed History");
            }else if(UserinputSTR.equals("History")){
                System.out.println("that is not configured");
            }else if(UserinputSTR.contains("help")){
                Employee_Directions();
            }else if(UserinputSTR.equals("Quit!")){
                Quit= true;
            }
            else{
                System.out.println("That command is not reconized");
            }
            System.out.println("============================");
        }


        }
    }


public final  void UpdateHistory(String addedHistory){
       String Temp = Bank_Employees_History.get(EmployIDNumber);
       Bank_Employees_History.set(EmployIDNumber, Temp + " --> <" + addedHistory + ">");
}
    public final void NameSearchChangeCustomerIDNumber(){
        int UserIndex = -1;
        System.out.println("Enter the Name; ");
        Scanner userinput= new Scanner(System.in);
        String UserinputStr = userinput.nextLine();
        UpdateHistory("Searched for " + UserinputStr );
        if(Bank_Customer_Names.contains(UserinputStr)){
            UserIndex = Bank_Customer_Names.indexOf(UserinputStr);
            System.out.println("UserFound");
            CustomerID_Number = UserIndex;
            PrintCustomerDetailsforEmpoyees(CustomerID_Number);
        }else{
            UpdateHistory("Searched for " + UserinputStr );
            System.out.println("Customer not found! Try with different capitalization ");
        }

        }

        public final void ChangeDetailsofArrayListSTR(ArrayList nameOf, int index, String NewValue){
            nameOf.set(index,NewValue);
        }

    public  void UpdateCustomerDetails(){
        NameSearchChangeCustomerIDNumber();
        System.out.println("======================");
        System.out.println("What would you like to change; ");
        System.out.println("Enter 'Address' to change address ");
        System.out.println("Enter 'Email' to change email ");
        System.out.println("Enter 'Phone' to change phone number");
        Scanner UserInput = new Scanner(System.in);
        String SelectionSTR = UserInput.nextLine();
        if(SelectionSTR.equals("Address")){
            System.out.println("Enter the new address; ");
            Scanner AddressScan = new Scanner(System.in);
            String NewAddress = AddressScan.nextLine();
            System.out.println("Before We can Proceed with this  we need to verify the customer's password");
            CheckPassword();
            if(PassCorrect == true) {
                ChangeDetailsofArrayListSTR(Bank_Customer_Address, CustomerID_Number, NewAddress);
                UpdateHistory("Changed Address for " + Bank_Customer_Names.get(CustomerID_Number));
                System.out.println("Address Updated!");
            }else{
                UpdateHistory(" Attempted to Change Address for " + Bank_Customer_Names.get(CustomerID_Number));
                System.out.println("Error");
            }
        }else if(SelectionSTR.equals("Email")){
            System.out.println("Enter the new Email; ");
            Scanner EmailScan = new Scanner(System.in);
            String NewEmail = EmailScan.nextLine();
            System.out.println("Before We can Proceed with this  we need to verify the customer's password");
            CheckPassword();
            if(PassCorrect == true) {
                ChangeDetailsofArrayListSTR(Bank_Customer_Address, CustomerID_Number, NewEmail);
                UpdateHistory("Changed Email for " + Bank_Customer_Names.get(CustomerID_Number));
                System.out.println("Email Updated!");
            }else{
                UpdateHistory("Attempted to Change Email  for " + Bank_Customer_Names.get(CustomerID_Number));
                System.out.println("Error");
            }
        }else if(SelectionSTR.equals("Phone")){
            System.out.println("Enter the new phone number; ");
            Scanner phoneScan = new Scanner(System.in);
            String Newphone = phoneScan.nextLine();
            System.out.println("Before We can Proceed with this  we need to verify the customer's password");
            CheckPassword();
            if(PassCorrect == true) {

                ChangeDetailsofArrayListSTR(Bank_Customer_Address, CustomerID_Number, Newphone);
                UpdateHistory("Changed phone number for " + Bank_Customer_Names.get(CustomerID_Number));
                System.out.println("Email Updated!");
            }else{
                UpdateHistory("Attempted Change phone number for for " + Bank_Customer_Names.get(CustomerID_Number));
                System.out.println("Error");
            }
        }
    }

    public final void NameSearch(){
        System.out.println("Enter the Name; ");
        Scanner userinput= new Scanner(System.in);
        String UserinputStr = userinput.nextLine();
        UpdateHistory("Name Search for" + "'" +UserinputStr + "'");
        if(Bank_Customer_Names.contains(UserinputStr)){
            int UserIndex = Bank_Customer_Names.indexOf(UserinputStr);
            System.out.println("UserFound");
            PrintCustomerDetailsforEmpoyees(UserIndex);
        }else{
            System.out.println("Customer not found! Try with different capitalization ");
        }
    }

    public final void EmailSearch(){
        System.out.println("Enter the Email; ");
        Scanner userinput= new Scanner(System.in);
        String UserinputStr = userinput.nextLine();
        UpdateHistory("Email Search for" + "'" +UserinputStr + "'");
        if(Bank_Customer_Email.contains(UserinputStr)){
            int UserIndex = Bank_Customer_Email.indexOf(UserinputStr);
            System.out.println("UserFound");
            PrintCustomerDetailsforEmpoyees(UserIndex);
        }else{
            System.out.println("Customer not found! Try with different capitalization ");
        }
    }

    public final void PhoneSearch(){
        System.out.println("Enter the phone number; ");
        Scanner userinput= new Scanner(System.in);
        String UserinputStr = userinput.nextLine();
        UpdateHistory("Phone Search for" + "'" +UserinputStr + "'");
        if(Bank_Customer_Phone.contains(UserinputStr)){
            int UserIndex = Bank_Customer_Phone.indexOf(UserinputStr);
            System.out.println("UserFound");
            PrintCustomerDetailsforEmpoyees(UserIndex);
        }else{
            System.out.println("Customer not found! Try with different capitalization ");
        }
    }

    public final void EmpolyeeLogin(){
        System.out.println("Hello, Please Enter your Username; ");
        Scanner username = new Scanner(System.in);
        String UserNameStr = username.nextLine();
        if(Bank_Employees_UserName.contains(UserNameStr)){
            int indextemp;
            indextemp = Bank_Employees_UserName.indexOf(UserNameStr);
            System.out.println("Hello, " + Bank_Employees_Name.get(indextemp) + ", Please Enter your password.");
            Scanner UserPass = new Scanner(System.in);
            String UserPassStr = UserPass.nextLine();
            if(Bank_Employees_Password.contains(UserPassStr)){
                if(UserPassStr.equals(Bank_Employees_Password.get(indextemp))) {
                    EmployIDNumber = indextemp;
                    this.EmployeeLogin = true;
                    System.out.println("Welcome, " + Bank_Employees_Name.get(EmployIDNumber));
                }else{
                    System.out.println("Error");
                }
                }

        }else{
            System.out.println("error");
        }
    }

    public final void Search(){
        if(Bank_Employees_Level.get(EmployIDNumber) >= 2) {
            System.out.println("How would you like to Search");
            System.out.println("Enter 'name' to search by name ");
            System.out.println("Enter 'email' to search by Email");
            System.out.println("Enter 'phone' to search by phone number");
            Scanner userinput= new Scanner(System.in);
            String UserinputStr = userinput.nextLine();
            if(UserinputStr.equals("name")){
                NameSearch();
            }else if(UserinputStr.equals("email")){
                EmailSearch();
            } else if(UserinputStr.equals("phone")){
                PhoneSearch();
            }else {
                System.out.println("That is not a recognized command ");
            }

        }else{
            System.out.println("You do not have the required Authority level; ");
        }
        }

    public Bank_Company(String BankCompanyName){
    this.BankCompanyName = BankCompanyName;
}

    Bank_Company(){}


    public final void login(){
    System.out.println("Hello, Please Enter your Username; ");
    System.out.println("If you are an Employee then enter '!Employ' ");
    Scanner username = new Scanner(System.in);
    String UserName = username.nextLine();
    if(Bank_Customer_UserName.contains(UserName)) {
        int indextemp;
        indextemp = Bank_Customer_UserName.indexOf(UserName);
        System.out.println("Hello, " + Bank_Customer_Names.get(indextemp));
        System.out.println("Please Enter Password;");
        Scanner userpass = new Scanner(System.in);
        String UserPassword = userpass.nextLine();
        if(UserPassword.equals(Bank_Customer_Password.get(indextemp))){
            CustomerID_Number = indextemp;
            System.out.println("Welcome to the Terminal " + Bank_Customer_Names.get(CustomerID_Number));
            Login = true;
            System.out.println("You Have Successfully Logged in!");
            ui_InterFace();
        }
    }else if(UserName.equals("!Employ")){
        EmployeeUI();
    } else{
        System.out.println("Error");
    }
}

    public final void PrintCustomerDetailsforEmpoyees (int index){
        System.out.println("Name -- " + Bank_Customer_Names.get(index));
        System.out.println("Balance -- " + Bank_Customer_Balance.get(index));
        System.out.println("Email -- " + Bank_Customer_Email.get(index));
        System.out.println("Phone -- " + Bank_Customer_Phone.get(index));
        System.out.println("Address -- " + Bank_Customer_Address.get(index));
        System.out.println("Transactions -- " + Bank_Customer_Transactions.get(index));
        System.out.println("Customer ID -- " + Bank_Customer_ID_Number.get(index));
    }

    public final void PrintCustomerDetails(){
        System.out.println("Name -- " + Bank_Customer_Names.get(CustomerID_Number));
        System.out.println("Balance -- " + Bank_Customer_Balance.get(CustomerID_Number));
        System.out.println("Email -- " + Bank_Customer_Email.get(CustomerID_Number));
        System.out.println("Phone -- " + Bank_Customer_Phone.get(CustomerID_Number));
        System.out.println("Address -- " + Bank_Customer_Address.get(CustomerID_Number));
        System.out.println("Transactions -- " + Bank_Customer_Transactions.get(CustomerID_Number));
        System.out.println("Customer ID -- " + Bank_Customer_ID_Number.get(CustomerID_Number));
    }

    public final void WithDraw(){
        System.out.println("Hello, " + Bank_Customer_Names.get(CustomerID_Number) + " How much would you like to Withdraw (Transaction Rates Apply)");
        Scanner TakeoutAmmount = new Scanner(System.in);
        Double WithDrawAmount = TakeoutAmmount.nextDouble();
        CheckPassword();
        if(PassCorrect==true & Login == true){
            System.out.println("Access Granted ");
            double NewBalance = Bank_Customer_Balance.get(CustomerID_Number) - WithDrawAmount;
            if(NewBalance > 0){
                Bank_Customer_Balance.set(CustomerID_Number,NewBalance);
                String TempVar_STR = Bank_Customer_Transactions.get(CustomerID_Number);
                Bank_Customer_Transactions.set(CustomerID_Number, TempVar_STR +" --> [ -" + WithDrawAmount + "]");
                System.out.println("Transaction Completed");
                System.out.println("Balance -- " + Bank_Customer_Balance.get(CustomerID_Number));
            }
            else if(NewBalance < 0){
                System.out.println("After This Transaction You will have a Negitive Balance of " + NewBalance + "\n Would You Like to Continue? (y/n)");
                Scanner YesORNo = new Scanner(System.in);
                String UserConformation = YesORNo.nextLine();
                if(UserConformation.equals("y" )|| UserConformation.equals("Y")){
                    Bank_Customer_Balance.set(CustomerID_Number,NewBalance);
                    String TempVar_STR = Bank_Customer_Transactions.get(CustomerID_Number);
                    Bank_Customer_Transactions.set(CustomerID_Number, TempVar_STR +" --> [ -" + WithDrawAmount + "]");
                    System.out.println("Transaction Completed");
                    System.out.println("Balance -- " + Bank_Customer_Balance.get(CustomerID_Number));
                }else if(NewBalance < -3000){
                    System.out.println("Not Enough Funds; Max Negative Balance is capped at 3,000");
                }else{System.out.println("Error");}
            }

        }

    }

    public final void Deposit (){
        System.out.println("Hello, " + Bank_Customer_Names.get(CustomerID_Number) + " How much would you like to Deposit (Transaction Rates Apply)");
        Scanner DepositScanner = new Scanner(System.in);
        double DepositAmount = DepositScanner.nextDouble();
        if(DepositAmount > 0 ){
            System.out.println("Processing Transaction");
            double TempVar =  Bank_Customer_Balance.get(CustomerID_Number);
            double Total = TempVar + DepositAmount;
            Bank_Customer_Balance.set(CustomerID_Number, Total);
            String TempVar_STR = Bank_Customer_Transactions.get(CustomerID_Number);
            Bank_Customer_Transactions.set(CustomerID_Number, TempVar_STR +" --> [ +" + Total + "]");
            System.out.println("Transaction Completed! ");
        }else{ System.out.println("You Cannot Deposit less than 1 dollars!");}
    }

    public final void CheckPassword(){
        System.out.println("Please Renter your Password " + Bank_Customer_Names.get(CustomerID_Number) );
        Scanner PassCheck = new Scanner(System.in);
        String PassChecker = PassCheck.nextLine();
        if(PassChecker.equals(Bank_Customer_Password.get(CustomerID_Number))){
            System.out.println("Password is Correct; Access Granted. ");
            this.PassCorrect = true;
        }
        else{
            System.out.println("Incorrect Password!");
        }
    }

    public final void PrintTransactions(){
    System.out.println(Bank_Customer_Transactions.get(CustomerID_Number));
    }

    public final void PrintDirections(){
    System.out.println("Enter 'D' to deposit money to your account");
    System.out.println("Enter 'W' to withdraw money from account");
    System.out.println("Enter 'T' to view transactions");
    System.out.println("Enter 'print' to print your details");
    System.out.println("Enter 'Help' to view directions");
    System.out.println("Enter 'Quit!' to quit the program!");
}

    public final void ui_InterFace(){
        boolean Quit = false;
        login();
        if(Login == true){
        PrintDirections();
            while(!Quit) {
                Scanner UserInput = new Scanner(System.in);
                String UserImputSTR = UserInput.nextLine();
                if (UserImputSTR.equals("D")|| UserImputSTR.equals("d")) {
                    Deposit();
                } else if (UserImputSTR.equals("W") || UserImputSTR.equals("w") ) {
                    WithDraw();
                } else if (UserImputSTR.equals("T") || UserImputSTR.equals("t")) {
                    PrintTransactions();
                } else if (UserImputSTR.equals("print") || UserImputSTR.equals("Print")) {
                    PrintCustomerDetails();
                } else if (UserImputSTR.contains("Help") ) {
                    PrintDirections();
                } else if (UserImputSTR.equals("Quit!")) {
                    System.out.println("Exiting Program!");
                    Quit = true;
                } else {
                    System.out.println("Error; Type Help for help!");
                }
            }
     }else{System.out.println("Error");}

    }

    public int getCustomerID_Number() {
        return CustomerID_Number;
    }

    public final class Customer{
        public Customer(String CustomerUserName, String CustomerPassword, String CustomerName, double CustomerBalance, String CustomerEmail, String CustomerPhoneNumber, String CustomerAddress){
            Bank_Customer_UserName.add(CustomerUserName);
            Bank_Customer_Password.add(CustomerPassword);
            Bank_Customer_Names.add(CustomerName);
            Bank_Customer_Balance.add(CustomerBalance);
            Bank_Customer_Email.add(CustomerEmail);
            Bank_Customer_Phone.add(CustomerPhoneNumber);
            Bank_Customer_Address.add(CustomerAddress);
            Bank_Customer_Transactions.add("{Account Created!}");
            Bank_Customer_ID_Number.add(Customer_i);
            CustomerID_Number =Customer_i;
            System.out.println(Bank_Customer_Names.get(Customer_i));
            Customer_i++;

        }







    }


}
