/*
Group 2: Divisibility and primes
Prime check
Print all primes in a range
Count primes below n using the Sieve of Eratosthenes (LC 204)
Print all factors of n (use the i and n/i pairing)
Prime factorization of n
FizzBuzz (LC 412)

*/

import java.util.ArrayList;
import java.util.List;

public class group_2
{
    public static boolean prime_1(int n)
    {
        if (n <= 1)
            return false;

        if (n == 2)
            return true;

        if (n % 2 == 0)
            return false;

        for (int i = 3; i * i <= n; i += 2)
        {
            if (n % i == 0)
                return false;
            ;
        }
        return true;
    }

    public static void prime_range(int start, int stop)
    {
        for (int i = start; i <= stop; i++)
        {
            if (prime_1(i))
            {
                System.out.println(i + " ");
            }
        }
    }

    public static int countPrimes(int n) // Leetcode 204
    {
        // were just marking the non prime n counting which r not marked

        if (n <= 2)
            return 0;

        boolean crossed[] = new boolean[n];

        for (int i = 2; i * i < n; i++)
        {
            // If not crossed, i is prime
            if (!crossed[i])
            {
                // Cross all multiples of i, starting from 2*i
                for (int j = i * i; j < n; j += i)
                {
                    crossed[j] = true;
                }
            }
        }

        int count = 0;

        for (int i = 2; i < n; i++)
        {
            if (!crossed[i])
            {
                count++;
            }
        }

        return count;
    }

    public static void print_factors_of_n(int n)
    {
        if (n <= 0)
            return;

        for (long i = 1; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                System.out.print(i + " ");
                if (n / i != i)
                    System.out.print(n / i + " ");
            }
        }
    }

    public static void prime_factorisation(int num)
    {
    /*
          1. What is the problem?
          
          Given a number n, break it into prime numbers that multiply together to give n.
          
          n = 60 → 2 × 2 × 3 × 5 n = 84 → 2 × 2 × 3 × 7 n = 13 → 13 n = 1 → nothing (1 has no prime factors)

    */

        if (num <= 1)
        {
            System.out.println(num);
            return;
        }
        long n = num;

        for (long i = 2; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                System.out.println(i);
                n = n / i;
                i--;
            }
        }
        System.out.println(n);
    }

    public static List<String> fizzBuzz(int n)
    {
        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++)
        {
            if (i % 3 == 0 && i % 5 == 0)
            {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0)
            {
                ans.add("Fizz");
            } else if (i % 5 == 0)
            {
                ans.add("Buzz");
            } else
            {
                ans.add(Integer.toString(i));
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        // System.out.println(prime_1(3));

        // prime_range(3, 33);

        // System.out.println(countPrimes(10));

        // print_factors_of_n(36);4

        // prime_factorisation(60);

        System.out.println(fizzBuzz(15));

    }

}
