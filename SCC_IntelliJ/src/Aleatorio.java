// Classe para gera��o de n�meros aleat�rios segundos v�rias distribui��es
// Apenas a distribui��o exponencial negativa est� definida

import java.lang.reflect.Array;
import java.util.Random;

public class Aleatorio {

	// Gera um numero segundo uma distribuicao exponencial negativa de media m
    static double exponencial (double m){
		return (-m*Math.log(RandomGenerator.rand64(0)));
	}




	public static synchronized double[] getGaussian(double mean, double stdDev, int seed) {
		double spare = 0;
		boolean isSpareReady = false;

		if (isSpareReady) {
			isSpareReady = false;
			//return spare * stdDev + mean;
		} else {
			double v1, v2, w;
			do {
				v1 = RandomGenerator.rand64(seed) * 2 - 1;
				v2 = RandomGenerator.rand64(seed) * 2 - 1;
				w = v1 * v1 + v2 * v2;
			} while (w > 1);
			double mul = Math.sqrt(-2.0 * Math.log(w) / w);
			spare = v2 * mul;
			isSpareReady = true;
			return mean + stdDev * v1 * mul;
		}
	}

	//metodo que determina se o cliente é do tipo 0 ou 1 (gasolina, gasoleo)
	static int determinaTipoCliente() {
		int tipo;
		double rand;

		rand = RandomGenerator.rand64(80);

		if (rand <= 0.2)
			tipo = 1;
		else {
			tipo = 0;
		}

		return tipo;
	}

}