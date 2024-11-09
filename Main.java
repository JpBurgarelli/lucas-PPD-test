public class Main {
    public static void main(String[] args) {
        Documento documento = new Documento();

        Thread leitor1 = new Thread(new Leitor(documento, "Leitor 1"));
        Thread leitor2 = new Thread(new Leitor(documento, "Leitor 2"));
        Thread leitor3 = new Thread(new Leitor(documento, "Leitor 3"));

        Thread escritor1 = new Thread(new Escritor(documento, "Escritor 1"));
        Thread escritor2 = new Thread(new Escritor(documento, "Escritor 2"));

        leitor1.start();
        leitor2.start();
        leitor3.start();

        escritor1.start();
        escritor2.start();
    }
}
