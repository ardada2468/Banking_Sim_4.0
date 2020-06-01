public class Main {

    public static void main(String[] args) {
        Bank_Company BankOfAmerica = new Bank_Company("Bank OF America");
        Bank_Company.Customer Arnav = BankOfAmerica.new Customer("20180635" , "wildcat1","Arnav", 50.00, "ardada2468@gmail.com", "5083733676", "9323 Avalon Gates");
        Bank_Company.Customer Alok  = BankOfAmerica.new Customer(   "Alokd3"  , "Ram" ,  "Alok", 50.00, "Alokd3@yahoo.com", "5087628963", "9323 Avalon Gates");
        Bank_Company.Bank_Employees joe = BankOfAmerica.new Bank_Employees("Joe", "Arn", "arn", 3);
           //BankOfAmerica.ChangeDetailsofArrayListSTR(BankOfAmerica.Bank_Customer_Names, 0, "Arnav Test");
       //BankOfAmerica.ui_InterFace();
        BankOfAmerica.login();

    }

}
