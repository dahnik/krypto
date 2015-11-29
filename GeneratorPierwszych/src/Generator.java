import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Generator {

	static int d,k;

	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		d=2048;
		k=5;
		
		Runnable task = new Runnable(){
		    public synchronized void run(){
		    	SecureRandom secureRandom = new SecureRandom();
				try {
					secureRandom = SecureRandom.getInstance("SHA1PRNG");
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	byte seed[]=secureRandom.generateSeed(d);
				secureRandom.setSeed(seed);
				BigInteger nextPrime = null;
				nextPrime=BigInteger.probablePrime(d,secureRandom);
				AKS isprime = new AKS(nextPrime);
				if(isprime.isPrime()) 
					System.out.println(nextPrime);
				else run();
		    }
		};
		Thread thread[]=new Thread[k];
		for(int i=0;i<k;i++){
			thread[i] = new Thread(task);
			thread[i].start();
		}
		
	}

}
