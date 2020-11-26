public class KeyGeneration {

    private int p, q, n, CarmichaelsTotient, e, d;
    MyRandom rand = new MyRandom();

    public KeyGeneration(){
        p = rand.generateRandomPrimeNb(500);
        q = rand.generateRandomPrimeNb(500);
        while (q == p){
            q = rand.generateRandomPrimeNb(500);
        }
        n = p * q;
        CarmichaelsTotient = lcm(p-1, q-1);
        e = rand.generateRandomNb() % CarmichaelsTotient;
        while (e <= 1 || gcd(e, CarmichaelsTotient)!=1){
            e = rand.generateRandomNb() % CarmichaelsTotient;
        }
        d = modInverse(e, CarmichaelsTotient);
        /*
        System.out.println("p = " + p + "; q = " + q + ";");
        System.out.println("n = " + n + ";");
        System.out.println("Carmichael's Totient = " + CarmichaelsTotient + ";");
        System.out.println("e = " + e + "; d = " + d + ";");
        System.out.println("d*e = " + (e * d));
        System.out.println("d*e % totient = " + ((d*e) % CarmichaelsTotient));
        */
    }

    private int lcm(int a, int b){
        return a * b / gcd(a, b);
    }

    public int gcd(int a, int b){
        int gcd;
        if (a == b){
            gcd = a;
        }
        else if (a > b){
            gcd = gcd(a-b, b);
        }
        else {
            gcd = gcd(a, b-a);
        }
        return gcd;
    }

    public int modInverse(int a, int n){
        int t = 0, newT = 1;
        int r = n, newR = a;
        int quotient, buffer;

        while (newR != 0){
            quotient = r / newR;

            buffer = newT;
            newT = t - quotient * buffer;
            t = buffer;

            buffer = newR;
            newR = r - quotient * buffer;
            r = buffer;
        }
        if (r > 1){
            System.out.println("error"); //TODO
        }
        if (t < 0){
            t = t + n;
        }
        return t;
    }


}
