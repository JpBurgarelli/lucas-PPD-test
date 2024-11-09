public class Documento {
    private String nome = "Texto";
    private int leitores = 0;
    private boolean escritorAtivo = false;

    public synchronized void ler(String nomeLeitor) throws InterruptedException {
        while (escritorAtivo) {
            wait();
        }
        leitores++;
        System.out.println(nomeLeitor + " esta lendo o " + nome);
        Thread.sleep(1000);
        leitores--;
        System.out.println(nomeLeitor + " terminou de ler.");
        notifyAll();
    }

    public synchronized void escrever(String nomeEscritor) throws InterruptedException {
        while (leitores > 0 || escritorAtivo) {
            wait();
        }
        escritorAtivo = true;
        System.out.println(nomeEscritor + " esta escrevendo no " + nome);
        Thread.sleep(1500);
        escritorAtivo = false;
        System.out.println(nomeEscritor + " terminou de escrever.");
        notifyAll();
    }
}
