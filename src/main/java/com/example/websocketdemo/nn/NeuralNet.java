/**
 * 
 */
package com.example.websocketdemo.nn;

/**
 * @author amkumar
 *
 */
public class NeuralNet {

	/**
	 * @param args
	 * 
	 * costfn=(prediction-target)^2
	 */
	public static void main(String[] args) {
		
		System.out.println(Math.random());
//		double ws=getWeightedSum(1,2,RandomUtils.nextDouble(),RandomUtils.nextDouble(),RandomUtils.nextDouble());
//		System.out.println(getWeightedSum(1,2,RandomUtils.nextDouble(),RandomUtils.nextDouble(),RandomUtils.nextDouble()));
//		costFn(ws);
	}
	
	/**
	 * NeuralNet
	 * @param m1
	 * @param m2
	 * @param w1
	 * @param w2
	 * @param b
	 * @return
	 */
	private static double getWeightedSum(double m1,double m2,double w1,double w2,double b) {
		
		double sum=m1*w1+m2*w2+b;
		
		return sigMoid(sum);
	}

	private static double sigMoid(double x) {
		return 1/(1+Math.exp(x));
		
	}
	
	/**
	 * 	Original cod ebut due to stack overflow lets not put this
		System.out.println(b);
		if(b==TARGET) 
			return 1;
		else {
		return costFn(b-0.1*slope(b));
		}
	 * @param b
	 */
	
	private static void costFn(double b) {
		
		for (int i = 0; i < 30; i++) {
			b=b-0.1*slope(b);//Learning rate
			System.out.println(b);
		}
	}
	
	/**
	 * Slope function
	 * @param b
	 * @return
	 */
	
	private static  double slope(double b) {
		return 2*(b-TARGET);
	}
	
	private static final double TARGET=5;
}
