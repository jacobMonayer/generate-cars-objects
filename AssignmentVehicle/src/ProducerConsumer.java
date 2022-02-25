
//Java program to implement solution of producer
//consumer problem.

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
enum Type {
	  car,
	  ElectricCar,
	  ElectricMotorCycle,
	  MotorCycle,
	  truck
	}
public class ProducerConsumer {
	public static void main(String[] args)
		throws InterruptedException
	{
		// Object of a class that has both produce()
		// and consume() methods
		final PC pc = new PC();
		// Create producer thread
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run()
			{
				while ((!Thread.currentThread().isInterrupted()))
					try {
						pc.produce();
					}
				catch(InterruptedException e){
				    Thread.currentThread().interrupt();
				}
			}
		});

		// Create consumer thread
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run()
			{
				while((!Thread.currentThread().isInterrupted()))
					try {
						pc.consume();
					}
				 catch(InterruptedException e){
				        Thread.currentThread().interrupt();
				    }
			}
		});

		// Start both threads
		t1.start();
		t2.start();
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		exec.schedule(new Runnable(){
		    @Override
		    public void run(){
		        t1.interrupt();
		        t2.interrupt();
		        
		    }
		}, 60, TimeUnit.SECONDS);
	}

	
	// This class has a list, producer (adds items to list
	// and consumer (removes items).
	public static class PC {

		// Create a list shared by producer and consumer
		// Size of list is 2.
		LinkedList<Vehicle> list = new LinkedList<>();
		int capacity = 100_000_000;// no limit only for 1 minute creating objects 

		// Function called by producer thread
		public void produce() throws InterruptedException
		{
			 
			while ((!Thread.currentThread().isInterrupted())) {
				synchronized (this)
				{
					// producer thread waits while list
					// is full
					while (list.size() == capacity)
						wait();

					   Type[] values = Type.values();
				       int length = values.length;
				       int randIndex = new Random().nextInt(length);
				  
				       switch(values[randIndex]) {
				       case car:
				    	   Car c = new Car();
				    	   list.add(c);
				    	   notify();
				    	   break;
				       case  ElectricCar:
				    	   ElectricCar e = new ElectricCar();
				    	   list.add(e);
				    	   notify();
				    	   break;
				       case ElectricMotorCycle:
				    	   ElectricCar em = new ElectricCar();
				    	   list.add(em);
				    	   notify();
				    	   break;
				       case  MotorCycle:
				    	   MotorCycle m = new MotorCycle();
				    	   list.add(m);
				    	   notify();
				    	   break;
				       case  truck:
				    	   Truck t = new Truck();
				    	   list.add(t);
				    	   notify();
				    	   break;
				       }
				}
			}
		}

		// Function called by consumer thread
		public void consume() throws InterruptedException
		{
			while ((!Thread.currentThread().isInterrupted())) {
				synchronized (this)
				{
					// consumer thread waits while list
					// is empty
					while (list.size() == 0)
						wait();

					// to retrieve the first job in the list
					Vehicle val = list.removeFirst();
					System.out.println("Consumer consumed-"
									+ val.toString());

					// Wake up producer thread
					notify();

				}
			}
		}
		
		
	}
	
}


