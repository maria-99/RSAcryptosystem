public class MyRandom {

    private final long seed = System.currentTimeMillis();
    private final int a = 57, c = 461, m = 10007;
    private int x = (int) (seed % m);


    public int generateRandomNb(){
        int newX = ((a * x) + c) % m;
        x = newX;
        return newX;
    }

}