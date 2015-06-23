package de.eiting.executorExamples;

import java.util.concurrent.Callable;

public class ExampleCallable implements Callable<Integer> {
	private int n = 0;
	
	public ExampleCallable(int n) {
		this.n = n;
	}
	
	private int fak(int n){
		if(n < 2){
			return 1;
		} else {
			return n * fak(n-1); 
		}
	}
	
	@Override
	public Integer call() throws Exception {
		Thread.sleep(5000);
		
		return fak(n);
	}
}
