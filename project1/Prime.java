import java.lang.*;

public class Prime{
	
	public static Boolean isPrime(int x) {
		int i=2;
		boolean boo=true;
    	while (i <= x / 2) {
        	if (x % i == 0) boo= false;
        	i++;
    	}
    	return boo;
	}
	
	public static void main(String[] args){
		int x = Integer.parseInt(args[0]);
		if (isPrime(x)) System.out.println(x + " is prime.");
		else System.out.println(x + " is not prime.");
	}
}