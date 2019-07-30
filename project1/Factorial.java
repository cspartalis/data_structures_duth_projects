import java.lang.*;

public class Factorial {

	public static long compute(long x) {
		long fact= 1;
		for (int i=2; i<=x; i++) fact*= i;
		return fact;
	}
	
	public static void main(String[] args){
		int x = Integer.parseInt(args[0]);
		System.out.println("factorial = " + compute(x));
	}
}