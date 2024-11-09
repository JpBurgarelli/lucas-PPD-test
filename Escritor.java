public class Escritor implements Runnable {
    private final Documento documento;
    private final String nome;

    public Escritor(Documento documento, String nome) {
        this.documento = documento;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            while (true) {
                documento.escrever(nome);
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
