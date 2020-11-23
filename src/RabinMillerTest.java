import java.math.BigInteger;
import java.util.Random;

public class RabinMillerTest {

    private final int k = 5;

    private int factorOutPowersOf2 (int p){
        int b = 0;
        int evenP = p-1;
        while ( evenP % 2 == 0 ){
            b++;
            evenP /= 2;
        }
        return b;
    }

    public boolean probablyPrime (int input){

        if ( input % 2 == 0 || input < 3){
            System.out.println("Input is wrong");
            return false;
        }
        int b = factorOutPowersOf2(input);
        int m = (int)((input - 1) / Math.pow(2, b));
        System.out.println(input + " = 2^" + b + " * " + m + " + 1");

        MyRandom random = new MyRandom();
        WitnessLoop:
        for(int i = k; i>0; i-- ){
            System.out.println("i = "+ i);
            int a = 0;
            while (a < 2){
                a = random.generateRandomNb() % input;
            }
            BigInteger A = new BigInteger(String.valueOf(a));
            //BigInteger M = new BigInteger(String.valueOf(m));
            BigInteger INPUT = new BigInteger(String.valueOf(input));

            BigInteger Z = new BigInteger(String.valueOf(a));
            Z = Z.pow(m);
            Z = Z.remainder(INPUT);
            //long z = (long) Math.pow(a, m) % input;

            System.out.println("a= " + a + ";   z = " + Z.doubleValue());
            if (Z.doubleValue() == 1 || Z.doubleValue() == input - 1){
                continue;
            }
            for (int j = b-1; j>0; j--){
                Z = Z.pow(2);
                Z = Z.remainder(INPUT);
                //z = (long) Math.pow(z, 2) % input;

                System.out.println("j = " + j + ";   z = " + Z.doubleValue()) ;
                if(Z.doubleValue() == input -1){
                    continue WitnessLoop;
                }
            }
            return false;

        }

        return true;
    }



}