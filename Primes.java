public class Primes { // no QA, exceptions checking, serialization capability, annotations, security, immutability, BigInteger, boxing check, static context

    private int minNum = 10001; //start (and end) value, length are hard-coded
    private int maxNum = 99997;

    private int divNumMax = 0;
    private int palind;
       
    private int findMaxPrimeNumber(int maxNumPre) {
        int i;
        int j;
        int z;
        int maxNumNew;

        for (i = maxNumPre; i >= minNum; i = i - 2) {

            for (j = 3; j <= divNumMax; j++) {

                z = i % j;

                if (z == 0 && j <= divNumMax) {
                    break;

                } else if (z != 0 && j == divNumMax) {
                    maxNumNew = i;
                    return maxNumNew;

                }
            }

        }
        return 10000;
    }

    private boolean findPalindrome(int firstPrime, int secondPrime) {

        int resultOfMath = firstPrime * secondPrime;

        String ltrResult = Integer.toString(resultOfMath);
        String rtlResult = new StringBuffer(ltrResult).reverse().toString();

        if (ltrResult.equals(rtlResult)) {

            palind = resultOfMath;
            return false;

        } else {
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
