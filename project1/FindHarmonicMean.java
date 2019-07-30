import java.lang.*;

public class FindHarmonicMean {

	public static double findHarmonicMean(int[] values) {
		int n= values.length;
		double[] Arr = new double[n];
		double HM=0, sum=0;
		for (int i=0; i<n; i++) {
			Arr[i]= 1. / values[i];
			sum += Arr[i];
		}
		HM = n/sum;	
		return HM;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,4};
		System.out.println(findHarmonicMean(A));
	}
}