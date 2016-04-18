// Classe que representa um cliente
// Como s�o indistintos neste exemplo, esta vazia

public class Cliente {
    int tipo; //0 gasolina, 1 gasoleo
    Cliente(){
        tipo = Aleatorio.determinaTipoCliente();
    }

    public int getTipo() { return  tipo;}

}