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

        int fPM;
        int sPM;
        boolean isNotPalind;

        fPM = findMaxPrimeNumber(maxNum);
        sPM = findMaxPrimeNumber(fPM - 2);
        isNotPalind = findPalindrome(fPM, sPM);

        while (isNotPalind) {

            if (sPM <= fPM && sPM > minNum) {
                sPM = findMaxPrimeNumber(sPM - 2);
                isNotPalind = findPalindrome(fPM, sPM);

            } else if (sPM <= minNum) {
                fPM = findMaxPrimeNumber(fPM - 2);
                sPM = fPM;
            }
        }
       
        System.out.println("1-st prime number: " + fPM);
        System.out.println("2-nd prime number: " + sPM);
        System.out.println("1-st * 2-nd = " + palind);
    }
   
    public static void main(String[] args) {   
        new Primes().start();
    }
}
