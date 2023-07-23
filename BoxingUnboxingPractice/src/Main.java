import java.util.ArrayList;

public class Main {

    record Customer(String name, ArrayList<Double> transactions){
        public Customer(String name,double initialDeposit){
            this(name.toUpperCase(),new ArrayList<Double>(500));
            transactions.add(initialDeposit);
        }
    }
    public static void main(String[] args) {

        Customer suv = new Customer("Suvradeep",1000);
        System.out.println(suv);

        Bank bank = new Bank("ABN Amro");
        bank.addNewCustomer("Sweetie Agicha",1000);
        System.out.println(bank);

        bank.addTransaction("Sweetie Agicha",25);
        bank.addTransaction("Sweetie Agicha",-20);
        bank.addTransaction("Sweetie Agicha",65);
        bank.printStatement("Sweetie Agicha");
    }



}

class Bank {
    private String name;

    private ArrayList<Main.Customer> customers = new ArrayList<>(5000);

    public Bank(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }

    private Main.Customer getCustomer(String customerName) {
        for (var customer : customers) {
            if (customer.name().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }

        System.out.printf("Customer (%s) wasn't found %n", customerName);
        return null;
    }

    public void addNewCustomer(String customerName, double initialDeposit) {
        if (getCustomer(customerName) == null) {
            Main.Customer customer = new Main.Customer(customerName, initialDeposit);
            customers.add(customer);
            System.out.println("New customer Added:" + customer);
        }
    }

    public void addTransaction(String name,double transactionAmount){
        Main.Customer  customer = getCustomer(name);
        if(customer !=null){
            customer.transactions().add(transactionAmount);
        }
    }

    public void printStatement(String customerName){
        Main.Customer customer = getCustomer(customerName);
        if(customer==null){
            return;
        }

        System.out.println(("-".repeat(35)));
        System.out.println("Customer name:" + customer.name());
        System.out.println("Transactions");
        for (double d :customer.transactions()){  ///unboxing
            System.out.printf("%10.2f (%s)%n",d,d<0 ? "debit" : "credit");
        }


    }
}