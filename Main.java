// Classe base da fábrica
abstract class FabricaNotificacao {
    public abstract void enviar(String mensagem);
}

// Fábricas concretas
class FabricaEmail extends FabricaNotificacao {
    public void enviar(String mensagem) {
        System.out.println("Enviando e-mail: " + mensagem);
    }
}

class FabricaSMS extends FabricaNotificacao {
    public void enviar(String mensagem) {
        System.out.println("Enviando SMS: " + mensagem);
    }
}

// Programa principal
public class Main {
    public static void main(String[] args) {
        FabricaNotificacao fabrica = new FabricaEmail();
        fabrica.enviar("Bem-vindo!");
    }
}
