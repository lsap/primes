// Copyright (C) 2018, 2019 Serhii Kostyrko
final class Primes { // assert usage, no exceptions checking, serialization capability, annotations, security, immutability, BigInteger, boxing check, static context

static final int MAX_MULTIPLIER = 99997; // start (and end) value, length are hard-coded
static final int MIN_MULTIPLIER = 10001;

static void palindrome(ArrayList<Integer> primeNumbers) {
    long palindrome = 0;
    long multiplier1 = 0;
    long multiplier2 = 0;
    for (int j = 0; j < primeNumbers.size(); j++) {
        for (int k = 0; k < primeNumbers.size(); k++) {
            long i = primeNumbers.get(j) * primeNumbers.get(k);
            if (palindromeCheck(i)) {
                if (i > palindrome) {
                    palindrome = i;
                    multiplier1 = primeNumbers.get(j);
                    multiplier2 = primeNumbers.get(k);
                }
            }
        }
    }
assert palind == 999949999;
    System.out.println("palindrome = " + palindrome
            + "\nmultiplier1 = " + multiplier1
            + "\nmultiplier2 = " + multiplier2);

} 

static ArrayList eratosthenesPrimeNumbers(int max, int min) {
    ArrayList<Integer> primeNumbers = new ArrayList<>();
    boolean[] array = new boolean[max];

    for (int i = 2; Math.pow(i, 2) <= max; i++) {
        if (!array[i]) {
            for (int j = (int) Math.pow(i, 2); j < max; j += i) {
                array[j] = true;
            }
        }
    }
    for (int i = max - 1; i >= min; i--) {
        if (!array[i]) {
            primeNumbers.add(i);
        }
    }
    return primeNumbers;
}  

static boolean palindromeCheck(long i) {
    char[] palindrome = String.valueOf(i).toCharArray();
    int fromBegin = 0;
    int fromEnd = palindrome.length - 1;
    while (fromBegin < fromEnd) {
        if (palindrome[fromBegin] == palindrome[fromEnd]) {
            fromBegin++;
            fromEnd--;
        } else return false;
    }
    return true;
}

public static void main(String[] args) {

    ArrayList<Integer> primeNumbers2 = new ArrayList<>(eratosthenesPrimeNumbers(MAX_MULTIPLIER, MIN_MULTIPLIER));
    palindrome(primeNumbers2);
}
} 
