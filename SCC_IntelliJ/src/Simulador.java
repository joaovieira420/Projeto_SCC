public class Simulador {

 	// Relogio de simulacao - variavel que contem o valor do tempo em cada instante
    private double instante;
    // Medias das distribuicoes de chegadas e de atendimento no servico
	private double media_cheg, media_serv;
	// Numero de clientes que vao ser atendidos
	private int n_clientes;
	// Servico - pode haver mais do que um num simulador
    private Servico gasolina; // gasolina
	private Servico loja; // loja
	private Servico gasoleo; //gasoleo
    // Lista de eventos - onde ficam registados todos os eventos que vao ocorrer na simulacao
    // Cada simulador so tem uma
	private ListaEventos lista;

	//Tempo que queremos que a simulação dure
	private int finalSimulationTime;

    // Construtor
    public Simulador() {
		// Inicializacao de parametros do simulador
        media_cheg = 1.2;
		media_serv = 4;
		n_clientes = 100;
		finalSimulationTime = 120;
		// Inicializacao do relogio de simulacao
		instante = 0;
		// Criacao do servico
		gasolina = new Servico (this, 3, 0); //isto é a gasolina

		gasoleo = new Servico(this, 1, 0); //isto e o gasoleo

		loja = new Servico(this, 1, 1);  // isto é a loja


		// Criacao da lista de eventos
		lista = new ListaEventos(this);
		// Agendamento da primeira chegada
        // Se nao for feito, o simulador nao tem eventos para simular
		insereEvento (new Chegada(instante, this, gasolina));
    }

        // programa principal
        public static void main(String[] args) {
            // Cria um simulador e
            Simulador s = new Simulador();
            // poe-o em marcha
            s.executa();
        }

    // Metodo que insere o evento e1 na lista de eventos
	void insereEvento (Evento e1){
		lista.insereEvento (e1);
	}

    // Metodo que actualiza os valores estatisticos do simulador
	private void act_stats(){
		gasolina.act_stats();
		gasoleo.act_stats();
		loja.act_stats();
	}

    // Metodo que apresenta os resultados de simulacao finais
	private void relat (){
    	System.out.println();
    	System.out.println("------- Resultados finais -------");
    	System.out.println();
		gasolina.relat();
		gasoleo.act_stats();
		loja.act_stats();
	}

    // Metodo executivo do simulador
	public void executa (){
		Evento e1;
		// Enquanto nao atender todos os clientes
		while (getInstante() <= finalSimulationTime){
    	//	lista.print();  // Mostra lista de eventos - desnecessario; e apenas informativo
			e1 = (Evento)(lista.removeFirst());  // Retira primeiro evento (e o mais iminente) da lista de eventos
			instante = e1.getInstante();         // Actualiza relogio de simulacao
			act_stats();                         // Actualiza valores estatisticos
			e1.executa();                    // Executa evento
		};
		relat();  // Apresenta resultados de simulacao finais
	}

    // Metodo que devolve o instante de simulacao corrente
    public double getInstante() {
        return instante;
    }

    // Metodo que devolve a media dos intervalos de chegada
    public double getMedia_cheg() {
        return media_cheg;
    }

    // Metodo que devolve a media dos tempos de servico
    public double getMedia_serv() {
        return media_serv;
    }

	//Metodo que devolve a loja
	public Servico getLoja() { return  loja;}

	//Metodo que devolve a gasolina
	public Servico getGasolina() { return  gasolina;}

	//Metodo que devolve a gasoleo
	public Servico getGasoleo() { return  gasolina;}

}