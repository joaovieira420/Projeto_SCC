// Classe que representa a chegada de um cliente. Deriva de Evento.

public class Chegada extends Evento {

    //Construtor
    Chegada (double i, Simulador s, Servico servico){
		super (i, s, servico);
	}

	// Metodo que executa as accoes correspondentes a chegada de um cliente
    void executa (){
	    // Coloca cliente no servico - na fila ou a ser atendido, conforme o caso
        //de momento esta sempre a inserir na gasolina
        Cliente c = new Cliente();
		servico.insereServico (c);
        // Agenda nova chegada para daqui a Aleatorio.exponencial(s.media_cheg) instantes
        if (c.getTipo() == 0) {
            s.insereEvento(new Chegada(s.getInstante() + Aleatorio.exponencial(s.getMedia_cheg()), s, servico));
        } else {
            s.insereEvento(new Chegada(s.getInstante() + Aleatorio.exponencial(s.getMedia_cheg()), s, s.getGasoleo()));
        }
	}

    // Metodo que descreve o evento.
    // Para ser usado na listagem da lista de eventos.
    public String toString(){
         return "Chegada em " + instante;
    }
}