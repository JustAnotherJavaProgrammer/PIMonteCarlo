package pi;

import java.security.SecureRandom;
import java.util.Random;

public class MonteCarlo {
	private int dropTotal = 0;
	Random rand = new SecureRandom();

	/**
	 * Initializes the class
	 * 
	 * @param dropTotal
	 *            The number of drops to be created when calling
	 *            {@link MonteCarlo#calculate(NewDropCallback)}
	 * @param seed
	 *            An optional parameter to specify a seed for the random number
	 *            generator
	 */
	public void init(int dropTotal, Long seed) {
		this.dropTotal = dropTotal;
		rand.setSeed(seed == null ? System.currentTimeMillis() : seed.longValue());
	}

	public int getDropTotal() {
		return dropTotal;
	}

	/**
	 * A method to create a new Drop in a random location and check whether it hit
	 * the circle. The odds of this method returning true are PI/4
	 * 
	 * @return Whether the drop hit the circle
	 */
	private boolean doesRandomDropHit() {
		return Math.pow(rand.nextDouble(), 2) + Math.pow(rand.nextDouble(), 2) < 1;
	}

	public double estimatePI(int dropsTotal, int dropsHit) {
		return ((double) dropsHit) / dropsTotal * 4;
	}

	/**
	 * @param callback
	 *            An optional callback to be invoked when a new estimation for PI is
	 *            available
	 * @return The estimate for PI after generating the number of drops specified in
	 *         {@link MonteCarlo#init(int)} {@link MonteCarlo#getDropTotal()}
	 */
	public double calculate(NewDropCallback callback) {
		if (dropTotal <= 0) {
			System.err.println(
					"The number of drops is <= 0 or has not been initialized!\ncalculate() returns Math.PI as a fallback.");
			return Math.PI;
		}
		double pi = 0;
		int hitDrops = 0;
		for (int dropNo = 1; dropNo <= dropTotal; dropNo++) {
			if (doesRandomDropHit())
				hitDrops++;
			if (callback != null) {
				pi = estimatePI(dropNo, hitDrops);
				callback.newValue(dropTotal, dropNo, pi);
			}
		}
		return callback == null ? estimatePI(dropTotal, hitDrops) : pi;
	}

}
