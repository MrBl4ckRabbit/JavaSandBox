package HyperSkill;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Task completed";
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        MyCallable callableTask = new MyCallable();

        try {
            Future<String> future = executor.submit(callableTask);
            String result = future.get();
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}

