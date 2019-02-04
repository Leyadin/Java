package assignment1;

public class StopWatch {
	private long startTime;
	private long endTime;
	
	public StopWatch()	{
		//Intentionally empty
	}
	
	public void start() {
		this.startTime = System.currentTimeMillis();
	}
	
	public void stop() {
		this.endTime = System.currentTimeMillis();
	}
	
	public long getElapsedTime() {
		return endTime - startTime;
	}
	
	public static void selectionSort(int[] data) {
		
		
	}
	
	public static void main(String[] args) {
		
		StopWatch timer = new StopWatch();
		
		//Generate a randomized array of size 100000 with values from 0 to 500
		int[] data = new int[100000];
		for (int i = 0; i < data.length; i++)
			data[i] = (int) (Math.random() * 501);
		
		timer.start();
		 
		//Selection sort algorithm
		for (int flag = 0; flag <= data.length - 2; flag++) {
			int temp = flag;

			for (int i = flag + 1; i <= data.length - 1; i++)
				if (data[temp] > data[i])
					temp = i;

			if (data[flag] > data[temp]) {
				int tempArray = data[flag];
				data[flag] = data[temp];
				data[temp] = tempArray;
			}

		}

		timer.stop();
		
		System.out.println("========== Selection Sort ==========");
		System.out.print("Every 10,000th entry of the sorted array: ");
		for (int i = 0; i < data.length; i += 10000)
			System.out.print(data[i] + " ");
		System.out.println();
		System.out.println("Time elapsed: " + timer.getElapsedTime() + "ms");
		System.out.println();

	}
	
	
}