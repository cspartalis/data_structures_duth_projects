import java.lang.*;

public class GCD {

	/* υπολογισμός του μέγιστου κοινού διαιρέτη δύο ακεραίων */ 
	public static int gcd1(int x, int y){
		while (y!=0) {
			int r= x % y; //υπόλοιπο ακέραιας διαίρεσης
			x= y;
			y= r;
		}
		return x;
	}
	
	public static void main(String args[]) {
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		
		System.out.println("gcd1 = " + gcd1(x,y));
	}
}