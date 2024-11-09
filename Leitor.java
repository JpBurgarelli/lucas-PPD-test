public class Leitor implements Runnable {
    private final Documento documento;
    private final String nome;

    public Leitor(Documento documento, String nome) {
        this.documento = documento;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            while (true) {
                documento.ler(nome);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
