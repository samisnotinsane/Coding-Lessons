public class SyncApp {

	private int count = 0; 


	public synchronized void increment() {
		count++;
	}


	public static void main(String[] args) {
		SyncApp app = new SyncApp();
		app.doWork();

	}

	public void doWork() {

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for(int i=0; i<10000; i++) {
					increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for(int i=0; i<10000; i++) {
					increment();
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

		try {
			t2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Count is: "+count);
	}
}