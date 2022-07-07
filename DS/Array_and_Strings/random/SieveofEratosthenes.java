// https://www.geeksforgeeks.org/sieve-of-eratosthenes/
// Time complexity: O(n log (log n)) + O(n) = O(n log (log n))

class SieveofEratosthenes {

	public static void main(String[] args) {
		int n = 20;
		int [] primes = new int[n+1];
		// Intiallly make numbers prime
		for(int i=0; i<primes.length; i++) 
			primes[i] = 1;
		// But 0 and 1 are not prime
		primes[0] = 0;
		primes[1] = 0;
		// Now for rest of the numbers
		// Also we can just iterate till sqrt of n
		for(int i=2; i<=Math.sqrt(n); i++) {
			// Only to change those numbers who have primes values as 1
			if(primes[i] == 1) {
				// Now for all multiples till n make prime flag value as 0
				// Starting from 2 because let's say if i = 5, so we want to check its multiple not 5
				// i*j<=n because, i*j will give multiple value

				for(int j=2; i*j<=n; j++)
					primes[i*j] = 0;
			}
		}

		for(int i=0; i<primes.length; i++) {
			if(primes[i] == 1)
				System.out.print(i + " ");
		}
	}
}