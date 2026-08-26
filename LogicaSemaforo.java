public class LogicaSemaforo {

    private String[] estados = {"VERMELHO", "AMARELO", "VERDE"};
    private int indiceAtual = 0;

    public String estadoAtual() {
        return estados[indiceAtual];
    }

    public void avancar() {
        // avança para o próximo índice do array, voltando ao início
        // depois do último estado (por isso o uso do operador %)
        indiceAtual = (indiceAtual + 1) % estados.length;
    }

    public static void main(String[] args) {
        LogicaSemaforo semaforo = new LogicaSemaforo();
        System.out.println(semaforo.estadoAtual());
        semaforo.avancar();
        System.out.println(semaforo.estadoAtual());
        semaforo.avancar();
        System.out.println(semaforo.estadoAtual());
        semaforo.avancar(); // deve voltar para VERMELHO
        System.out.println(semaforo.estadoAtual());
    }
}
