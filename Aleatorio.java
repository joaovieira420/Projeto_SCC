// Classe para gera��o de n�meros aleat�rios segundos v�rias distribui��es
// Apenas a distribui��o exponencial negativa est� definida

public class Aleatorio {

	// Gera um n�mero segundo uma distribui��o exponencial negativa de m�dia m
    static double exponencial (double m){
		return (-m*Math.log(Math.random()));
	}

}