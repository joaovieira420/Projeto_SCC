// Classe de onde v�o ser derivados todos os eventos.
// Cont�m apenas os atributos e m�todos comuns a todos os eventos.
// Por isso � uma classe abstracta. N�o haver� inst�ncias desta classe num simulador.

public abstract class Evento {

	protected double instante;  // Instante de ocorrencia do evento
	protected Simulador s;      // Simulador onde ocorre o evento
	protected Servico servico;  // Servico do envento

	//Construtor
    Evento (double i, Simulador s, Servico servico){
		instante = i;
		this.s = s;
		this.servico = servico;
	}

	// Metodo que determina se o evento corrente ocorre primeiro, ou nao, do que o evento e1
	// Se sim, devolve true; se nao, devolve false
	// Usado para ordenar por ordem crescente de instantes de ocorrencia a lista de eventos do simulador
    public boolean menor (Evento e1){
		return (instante < e1.instante);
	}

	// Metodo que executa um evento; a ser definido em cada tipo de evento
    abstract void executa ();

    // Metodo que devolve o instante de ocorrencia do evento
    public double getInstante() {
        return instante;
    }
}