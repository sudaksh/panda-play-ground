package bambooSwords;

public class StairCaseProblem {
	
	
//	f(n) = f(n-1) + f(n-2)
// f(1) = 1
// f(2) = 2
// f(0) = 1
	public int findWays(int n) {
		if(n == 0 || n == 1)
			return 1;
		return findWays(n-1) + findWays(n-2);
	}

}
