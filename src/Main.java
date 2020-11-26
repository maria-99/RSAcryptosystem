public class Main {

    public static void main(String[] args) {

        RabinMillerTest test = new RabinMillerTest();
        MyRandom rand = new MyRandom();
        /*for(int i = 10; i>0; i--){
            System.out.println(rand.generateRandomPrimeNb(500));
        }*/
        KeyGeneration key = new KeyGeneration();
        //System.out.println(key.gcd(100,75));
        System.out.println(key.modInverse(7, 120));




    }

}
