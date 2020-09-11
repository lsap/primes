// Copyright (C) 2018-2020 Serhii Kostyrko
import java.util.ArrayList;
import java.util.List;

class Primes { // assert usage, no exceptions checking, serialization capability
    // no cyclomatic complexity calculation
    // no annotations, security, immutability, BigInteger, box check, static context
static final int MAX_MULTIPLIER = 99997; // start (and end) value, length are hard-coded
static final int MIN_MULTIPLIER = 10001;
private static int limit = MAX_MULTIPLIER;
private static boolean[] sieve = new boolean[limit + 1];
private static int limitSqrt = (int)Math.sqrt((double)limit);

static void palindrome(List<Integer> primeNumbers) {
    long palindrome = 0;
    long multiplier1 = 0;
    long multiplier2 = 0;
    for(int j = 0; j < primeNumbers.size(); j++) {
        for(int k = 0; k < primeNumbers.size(); k++) {
            long i = Long.valueOf(primeNumbers.get(j)) * Long.valueOf(primeNumbers.get(k));
            if(palindromeCheck(i)) {
                if(i > palindrome) {
                    palindrome = i;
                    multiplier1 = primeNumbers.get(j);
                    multiplier2 = primeNumbers.get(k);
                }
            }
        }
    }
    assert palindrome == 999949999;
    System.out.println("palindrome = " + palindrome
        + "\nmultiplier1 = " + multiplier1
        + "\nmultiplier2 = " + multiplier2);

}

static List<Integer> seiveAtkin(int limit) {
    var primeNumbers = new ArrayList<Integer>();
    java.util.Arrays.fill(sieve, false);
    sieve[0] = false;
    sieve[1] = false;
    sieve[2] = true;
    sieve[3] = true;
    for(int x = 1; x <= limitSqrt; x++) {
        for(int y = 1; y <= limitSqrt; y++) {
            int n = (4 * x * x) + (y * y);
            if(n <= limit && (n % 12 == 1 || n % 12 == 5)) {
                sieve[n] = !sieve[n];
            }
            n = (3 * x * x) + (y * y);
            if(n <= limit && (n % 12 == 7)) {
                sieve[n] = !sieve[n];
            }
            n = (3 * x * x) - (y * y);
            if (x > y && n <= limit && (n % 12 == 11)) {
                sieve[n] = !sieve[n];
            }
        }
    }
    for(int n = 5; n <= limitSqrt; n++) {
        if(sieve[n]) {
            int x = n * n;
            for(int i = x; i <= limit; i += x) {
                sieve[i] = false;
            }
        }
    }
    for(int i = 0, j = 0; i <= limit; i++) {
        if(sieve[i]) {
            primeNumbers.add(i);
        }
    }
    return primeNumbers;
}

static List<Integer> eratosthenesPrimeNumbers(int max, int min) {
    var primeNumbers = new ArrayList<Integer>();
    boolean[] array = new boolean[max];

    for(int i = 2; Math.pow(i, 2) <= max; i++) {
        if(!array[i]) {

            for(int j = i * i; j < max; j += i) {
                array[j] = true;
            }
        }
    }
    for(int i = max - 1; i >= min; i--) {
        if(!array[i]) {
            primeNumbers.add(i);
        }
    }
    return primeNumbers;
}

static boolean palindromeCheck(long i) {
    char[] palindrome = String.valueOf(i).toCharArray();
    int fromBegin = 0;
    int fromEnd = palindrome.length - 1;
    while(fromBegin < fromEnd) {
        if(palindrome[fromBegin] == palindrome[fromEnd]) {
            fromBegin++;
            fromEnd--;
        } else return false;
    }
    return true;
}

public static void main(String... args) {

    var primeNumbers = eratosthenesPrimeNumbers(MAX_MULTIPLIER, MIN_MULTIPLIER);
    palindrome(primeNumbers);
    primeNumbers = seiveAtkin(MAX_MULTIPLIER);
    palindrome(primeNumbers);
}
}
