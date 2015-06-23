package de.eiting.executorExamples;

public class ExampleTask implements Runnable{
	private static int counter;
	private String name = null;
	
	public ExampleTask(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		String text = "";
		
		for(int counter = 0; counter < 100000; counter++){
			text += "A";
			
			if(counter % 10000 == 0){
				System.out.println(name + " is working");
			}
		}
	}
}
