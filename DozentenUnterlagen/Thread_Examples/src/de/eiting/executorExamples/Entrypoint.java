package de.eiting.executorExamples;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Entrypoint {
	public static void main(String[] args) {
//		Executor ex = Executors.newSingleThreadExecutor();
//		
//		ex.execute(new ExampleTask());
//
//		ex.execute(new ExampleTask());
//		
//		ExecutorService ex2 = Executors.newCachedThreadPool();
//		
//		ex2.submit(new ExampleTask());
		
//		ExecutorService ex3 = Executors.newFixedThreadPool(2);
//		
//		ex3.submit(new ExampleTask("Hanny"));
//		ex3.submit(new ExampleTask("Nanny"));
//		
//		ex3.shutdown();
//		
//		ExecutorService ex4 = Executors.newSingleThreadExecutor();
//		
//		Future<Integer> result = ex4.submit(new ExampleCallable(4));
//		
//		try {
//			System.out.println(result.get());
//		} catch (InterruptedException | ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		
		ses.scheduleAtFixedRate(new TimemeassueringRunnable(), 5, 1, TimeUnit.SECONDS);
	}
}
