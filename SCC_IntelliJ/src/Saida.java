// Classe que representa a sa�da de um cliente. Deriva de Evento.

public class Saida extends Evento {

	//Construtor
	Saida (double i, Simulador s, Servico servico){
		super(i, s, servico);
	}

	// Metodo que executa as accoes correspondentes a saida de um cliente
	void executa (){
		// Retira cliente do servi�o
        servico.removeServico();
    }

    // Metodo que descreve o evento.
    // Para ser usado na listagem da lista de eventos.
    public String toString(){
         return "Saida em " + instante;
    }


}