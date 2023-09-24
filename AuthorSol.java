import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class AuthorSol {
	
	static int[] choose;
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt(), q = fs.nextInt();
			int[] a = fs.readArray(n);
			choose = new int[n];
			int low = 0, high = n - 1;
			while (low <= high) {
				int mid = low + (high - low) / 2;
				if (check(a, mid, q)) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			boolean temp = check(a, high + 1, q);
			for (int x : choose) {
				System.out.print(x);
			}
			System.out.println();
		}
		out.close();
	}
	
	static boolean check(int[] a, int mid, int q) {
		for (int i = 0; i < choose.length; i++) {
			choose[i] = 0;
		}
		int iq = q;
		for (int i = 0; i < mid; i++) {
			if (a[i] <= iq) {
				choose[i] = 1;
			}
		}
		for (int i = mid; i < choose.length; i++) {
			choose[i] = 1;
			if (iq == 0) {
				return false;
			}
			if (a[i] > iq) {
				--iq;
			}
		}
		if (iq < 0) {
			return false;
		}
		return true;
	}
	
	static final Random rnd = new Random();
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
