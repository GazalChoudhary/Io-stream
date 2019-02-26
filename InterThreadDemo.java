package Thread;

public class InterThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Customer2 c=new Customer2();
		new Thread()
		{
			public void run()
			{
				c.withdraw(15000);
			}
		}.start();
		new Thread() {
			public void run() {
				c.deposit(10000);
			}
		}.start();
		new Thread()
		{
			public void run() {
				c.deposit(10000);
			}
		}.start();

	}

}
class Customer2{
	int amount=10000;
	synchronized void withdraw(int amount) {
		System.out.println("Available Balance"+this.amount);
		System.out.println("Going to withdraw"+amount);
		
		if(this.amount<amount) {
			System.out.println("Insufficient balance waiting for deposit");
			try {
				wait();
			}catch(Exception e) {
				System.out.println("Interruption occured");
			}
		}
		this.amount-=amount;
		System.out.println("Detected amount:"+amount);
		System.out.println("Balance amount:"+this.amount);
	}
	synchronized void deposit(int amount) {
		System.out.println("Going to deposit"+amount);
		this.amount+=amount;
		System.out.println("Available balance:"+this.amount);
		System.out.println("Transaction completed.\n");
		notify();
	}
}