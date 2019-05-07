// Copyright (C) 2018, 2019 Serhii Kostyrko
final class Primes { // assert usage, no exceptions checking, serialization capability, annotations, security, immutability, BigInteger, boxing check, static context

    private final int minNum = 10001; //start (and end) value, length are hard-coded
    private final int maxNum = 99997;

    private int divNumMax = 0;
    private int palind;
       
    private int findMaxPrimeNumber(int maxNumPre) {

        int z;
        int maxNumNew;

        for (int i = maxNumPre; i >= minNum; i = i - 2) {

            for (int j = 3; j <= divNumMax; j++) {

                z = i % j;

                if (z == 0 && j <= divNumMax) {
                    break;

                } else if (z != 0 && j == divNumMax) {
                    maxNumNew = i;
                    return maxNumNew;

                }
            }

        }
        return 10001;
    }

    private boolean findPalindrome(int firstPrime, int secondPrime) {

        int resultOfMul = firstPrime * secondPrime;

        String ltrResult = Integer.toString(resultOfMul);
        String rtlResult = new StringBuffer(ltrResult).reverse().toString();

        if (ltrResult.equals(rtlResult)) {

            palind = resultOfMul;
            return false;

        } else {
assert palind == 999949999;
            return true;
        }
    }
   
    public void start() {
        divNumMax = (int) Math.sqrt(maxNum);

        int fPN;
        int sPN;
        boolean isNotPalind;

        fPN = findMaxPrimeNumber(maxNum);
        sPN = findMaxPrimeNumber(fPN - 2);
        isNotPalind = findPalindrome(fPN, sPN);

        while (isNotPalind) {

            if (sPN <= fPN && sPN > minNum) {
                sPN = findMaxPrimeNumber(sPN - 2);
                isNotPalind = findPalindrome(fPN, sPN);

            } else if (sPN <= minNum) {
                fPN = findMaxPrimeNumber(fPN - 2);
                sPN = fPN;
            }
        }
       
        System.out.println("1st prime number: " + fPN);
        System.out.println("2nd prime number: " + sPN);
        System.out.println("1st * 2nd = " + palind);
    }
   
    public static void main(String[] args) {   
        new Primes().start();
    }
}
