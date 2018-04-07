/**
 * 
 */
package com.example.websocketdemo.nn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amkumar
 *
 */
public class MyNet {

	public static void main(String[] args) {
		MyNet myNet=new MyNet();
		
		double[] dataB1 = { 1, 1, 0 };
		double[] dataB2 = { 2, 1, 0 };
		double[] dataB3 = { 2, 0.5, 0 };
		double[] dataB4 = { 3, 1, 0 };

		double[] dataR1 = { 3, 1.5, 1 };
		double[] dataR2 = { 3.5, .5, 1 };
		double[] dataR3 = { 4, 1.5, 1 };
		double[] dataR4 = { 5.5, 1, 1 };

		List<double[]> list = new ArrayList<>();
//		list.add(dataB1);
//		list.add(dataB2);
//		list.add(dataB3);
//		list.add(dataB4);
//		list.add(dataR1);
//		list.add(dataR2);
//		list.add(dataR3);
//		list.add(dataR4);
		
		
		double[] i1 = { 1, 1, 0 };
		double[] i2 = { 0, 1, 1 };
		double[] i3 = { 1, 0, 1 };
		double[] iu = { 0, 0, 0 };
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(iu);
		
		
		double[] dataU = { 2, 1.1, 0.0 };
		System.out.println(myNet.train(list));
		System.out.println(myNet.predict(iu,myNet.train(list)));
		// unknown
		
	}

	private double sigmoid(double x) {
		return 1 / (1 + Math.exp(-x));
	}

	private double[] train(List<double[]> all_points) {
		
		double w1 = Math.random() * .2 - .1;
		double w2 = Math.random() * .2 - .1;
		double b = Math.random() * .2 - .1;
		double learningRate = 0.2;

		for (int iter = 0; iter < 50000; iter++) {
			
			int randomidx = (int) Math.floor(Math.random() * all_points.size());
			
			double[] point = all_points.get(randomidx);
			
			double target = point[2]; // target stored in 3rd coord of points
			// feed forward
			double z = w1 * point[0] + w2 * point[1] + b;
			double pred = sigmoid(z);

			// now we compare the model prediction with the target
			double cost = Math.pow((pred - target), 2);

			// now we find the slope of the cost w.r.t. each parameter (w1, w2, b)
			// bring derivative through square function
			double dcostdpred = 2 * (pred - target);

			// bring derivative through sigmoid
			// derivative of sigmoid can be written using more sigmoids! d/dz sigmoid(z) =
			// sigmoid(z)*(1-sigmoid(z))
			double dpreddz = sigmoid(z) * (1 - sigmoid(z));

			double dzdw1 = point[0];
			double dzdw2 = point[1];
			double dzdb = 1;

			// now we can get the partial derivatives using the chain rule
			// We're bringing how the cost changes through each
			// function, first through the square, then through the sigmoid
			// and finally whatever is multiplying our parameter of interest becomes the last part

			double dcostdw1 = dcostdpred * dpreddz * dzdw1;
			double dcostdw2 = dcostdpred * dpreddz * dzdw2;
			double dcostdb = dcostdpred * dpreddz * dzdb;

			// now we update our parameters!
			w1 -= learningRate * dcostdw1;
			w2 -= learningRate * dcostdw2;
			b -= learningRate * dcostdb;
		}

		double[] result = { w1, w2, b };

		return result;

	}
	
	private double predict(double[] dataU,double[] weights) {
		double z = weights[0] * dataU[0] + weights[1] * dataU[1]  + weights[2];
		return sigmoid(z);
	}

}
