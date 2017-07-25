package com.samisnotinsane.code;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        runnableBasic();
        runnableWithDelay();
        executorsBasic();
        callable();
        timeouts();
        invokeAllCallables();
    }

    public static void invokeAllCallables() {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3");

        try {
            executor.invokeAll(callables)
                    .stream()
                    .map(future -> {
                        try {
                            return future.get();
                        }
                        catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdownNow();
    }

    private static void timeouts() {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<Integer> future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });

        try {
            future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private static void callable() {
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return 123;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);

        System.out.println("future determinable? " + future.isDone());

        Integer result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("future determinable? " + future.isDone());
        System.out.print("result: " + result);
        executor.shutdownNow();
    }

    private static void executorsBasic() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });

        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }


    private static void runnableWithDelay() {
        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + name);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static void runnableBasic() {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");
    }
}
