public class MyRandom {

    private final long seed = System.currentTimeMillis();
    private final int a = 57, c = 461, m = 10007;
    private int x = (int) (seed % m);


    public int generateRandomNb(){
        int newX = ((a * x) + c) % m;
        x = newX;
        return newX;
    }

    public int generateRandomPrimeNb(){
        RabinMillerTest primalityTest = new RabinMillerTest();
        int prime = generateRandomNb();
        while (primalityTest.probablyPrime(prime)==false){
            prime = generateRandomNb();
        }
        return prime;
    }

    public int generateRandomPrimeNb(int ceiling){
        RabinMillerTest primalityTest = new RabinMillerTest();
        int prime = generateRandomNb() % ceiling;
        while (primalityTest.probablyPrime(prime)==false){
            prime = generateRandomNb() % ceiling;
        }
        return prime;
    }

}