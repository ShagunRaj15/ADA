class Practical1 {
    
    static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    
    static long factorialRecursive(int n) {
        if (n <= 1) return 1;
        return n * factorialRecursive(n - 1);
    }

    
    static long fibonacciIterative(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

   
    static long fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    static void run() {
        System.out.println("===== Practical 1: Factorial & Fibonacci =====");
        int n = 10;
        System.out.println("Factorial(" + n + ") Iterative: " + factorialIterative(n));
        System.out.println("Factorial(" + n + ") Recursive: " + factorialRecursive(n));
        System.out.println("Fibonacci(" + n + ") Iterative: " + fibonacciIterative(n));
        System.out.println("Fibonacci(" + n + ") Recursive: " + fibonacciRecursive(n));

        System.out.println("\nComplexity Comparison:");
        System.out.println("+-----------+-------------+-------------+");
        System.out.println("| Algorithm | Iterative   | Recursive   |");
        System.out.println("+-----------+-------------+-------------+");
        System.out.println("| Factorial | O(n)        | O(n)        |");
        System.out.println("| Fibonacci | O(n)        | O(2^n)      |");
        System.out.println("+-----------+-------------+-------------+");
        System.out.println();
    }
}