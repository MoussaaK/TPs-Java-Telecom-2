package org.moussa.serie01.exo2;
import java.math.*;

public class Factorielle {
	
	// Fonction factorielle simple
	public int factorielle(int n) {
		int res = 1;
		if(n<1)
			return 1;
		else {
			for(int i=1; i<=n; i++) {
				res *= i;
			}
		}
		return res;
	}
	
	//Fonction factorielle qui retourne un int 
	public int intFactorielle(int n) {
		int res = 1;
		if(n<1)
			return 1;
		else {
			for(int i=1; i<=n; i++) {
				res *= i;
			}
		}
		return res;
	}
	
	//Fonction factorielle qui retourne un double 
	public double doubleFactorielle(int n) {
		double res = 1;
		if(n<1)
			return 1.0;
		else {
			for(double i=1; i<=n; i++) {
				res *= i;
			}
		}
		return res;
	}
	
	//Fonction factorielle qui retourne un bigInteger
	public BigInteger bigIntFactorielle(int n) {
		//String integer = "1";
		BigInteger tmp =new BigInteger("0");
		BigInteger res = new BigInteger(""+n);
		if(res.compareTo(tmp) != 0)
			res = res.multiply(bigIntFactorielle(n-1));
		else
			return tmp =new BigInteger("1");
		return res;
	}
	
}
