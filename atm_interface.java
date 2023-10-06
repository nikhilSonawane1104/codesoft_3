import java.util.Scanner;

class Bank{
    private double balance;

    public Bank(double balance)
    {
        this.balance=balance;
    }

    public double getBalance()
    {
        return balance;
    }

    public void deposite(double amount)
    {
        if(amount > 0)
        {
            balance+=amount;
            System.out.println("deposite amount successfully ");

        }
        else
        {
            System.out.println("Invalid deposite amount");
        }
    }

    public boolean withdraw(double amount)
    {
        if(amount > 0 && balance >=amount)
        {
            balance-=amount;
            System.out.println("Withdraw successfully");
            return true;
        }
        else
        {
             System.out.println("invalid withdrawel");
             return false;
        }
    }
}


class ATM{
    private Bank bank;
    private Scanner sc;

    public ATM(Bank acoount)
    {
        bank=acoount;
        sc=new Scanner(System.in);
    }

    public void displayOptions()
    {
        System.out.println("ATM options :");
        System.out.println("1 . Check Balance");
        System.out.println("2 . Deposite");
        System.out.println("3 . Withdraw");
        System.out.println("4. Exit");

    }

    public void run()
    {
        while(true)
        {
            displayOptions();
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:  chechBalance();
                break;
                case 2: deposite();
                break;
                case 3: withdraw();
                break;
                case 4: System.out.println("Thank you for using ATM ....");
                        sc.close();
                        return;
                default: System.out.println("invalid options");
            }
        }
    }

    private void chechBalance()
    {
        double balance= bank.getBalance();
        System.out.println("Bank balance is :" + balance);
    }

    private void deposite()
    {
        System.out.println("Enter deposite amount");
        double amount=sc.nextDouble();
        bank.deposite(amount);
    }

    private void withdraw()
    {
        System.out.println("Enter withdraw amount");
        double amount=sc.nextDouble();
        boolean success=bank.withdraw(amount);
        if(success)
        {
            System.out.println("please take cash");
        }
    }
    
}
public class atm_interface {
    public static void main(String [] args) {
      Bank b=new Bank(1000);
      ATM a=new ATM(b);
      a.run();   
    }
}
