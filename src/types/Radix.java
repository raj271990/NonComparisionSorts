package types;

public class Radix {
	
	
	private static int getMax(int[] in, int n) {
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) if(max < in[i]) max = in[i];
		return max;
	}
	
	private static void countSort(int[] in, int n, int exp) {
		
		int[] count = new int[10];
		int[] op = new int[n];
		int i;
		
		// store the count
		for(i=0; i < n; i++) count[(in[i] / exp) % 10 ]++;
		
		// modify the count
		for(i=1; i < count.length ; i++) count[i] += count[i-1];
		
		// loop through in[], identify index of current in[], from the count[],
		// and store in op[]
		for(i = n-1; i>=0; i--) {
			op[count[(in[i]/exp) % 10] - 1] = in[i];
			count[(in[i]/exp) %10]--;
		}
		
		// copy op[] to in[]
		for(i=0;i<n;i++) in[i] = op[i];
		
	}
	
	
	public static void sort(int[] in) {
		
		int n = in.length;
		int max = getMax(in, n);
		
		for(int exp = 1; max/exp > 0; exp *=10 ) {
			countSort(in, n, exp);
		}
		
	}

	public static void main(String[] args) {
		
		int[] in = {170, 45, 75, 90, 802, 24, 2, 66};
		sort(in);
		
		for(int i=0; i<in.length; i++) {
		    System.out.println(in[i]);
		}

	}

}
