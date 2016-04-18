/**
 * Created by joaocraveiro on 05/04/16.
 */
public class Transfere extends Evento {

    //Construtor
    Transfere(double i, Simulador s, Servico servico){
        super (i, s, servico);
    }

    @Override
    void executa() {
        Cliente c;
        //servico aqui é de ser gasolina
        c = servico.removeServico();
        s.getLoja().insereServico(c);
    }
}
