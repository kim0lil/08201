package concurrency.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Submit {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// 쓰래드를 생성하는 팩토리를 생성합니다.
		ThreadFactory theadFactory = new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				System.out.println("C)Thread Factory");
				return new Thread(r);
			}
		};
		
		// 팩토리를 사용하여 cache 된 쓰래드 풀을 불러 옵니다.
		ExecutorService executorService = Executors.newCachedThreadPool(theadFactory);
		ExecutorService executorServiceFixed = Executors.newFixedThreadPool(10, theadFactory);
		
		Runnable runnable10000 = () ->{
			try {
				System.out.println("sleep 10000 ms");
				Thread.sleep(10000);
				System.out.println("wakeup 10000 ms");
			}catch(Exception e) { }
		};
		Runnable runnable1000 = () ->{
			try {
				System.out.println("sleep 1000 ms");
				Thread.sleep(1000);
				System.out.println("wakeup 1000 ms");
			}catch(Exception e) { }
		};
		
		executorServiceFixed.execute(runnable10000);
		
		if(executorServiceFixed.submit(runnable1000, true).get()) {
			System.out.println("--end");
		}

	}
}
