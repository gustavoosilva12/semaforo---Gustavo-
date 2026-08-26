import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * JPanel customizado: herda de JPanel e sobrescreve paintComponent
 * para desenhar os 3 círculos do semáforo (herança/polimorfismo).
 * Ele não guarda regra de negócio nenhuma — só pergunta à lógica
 * qual é o estado atual e desenha de acordo.
 */
public class PainelSemaforo extends JPanel {

    private LogicaSemaforo logica;

    public PainelSemaforo(LogicaSemaforo logica) {
        this.logica = logica;
        setBackground(Color.DARK_GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        String estado = logica.estadoAtual();

        int diametro = 70;
        int x = (getWidth() - diametro) / 2;
        int espacamento = 20;
        int yVermelho = 20;
        int yAmarelo = yVermelho + diametro + espacamento;
        int yVerde = yAmarelo + diametro + espacamento;

        desenharCirculo(g2, x, yVermelho, diametro, "VERMELHO".equals(estado) ? Color.RED : Color.GRAY.darker());
        desenharCirculo(g2, x, yAmarelo, diametro, "AMARELO".equals(estado) ? Color.YELLOW : Color.GRAY.darker());
        desenharCirculo(g2, x, yVerde, diametro, "VERDE".equals(estado) ? Color.GREEN : Color.GRAY.darker());
    }

    private void desenharCirculo(Graphics2D g2, int x, int y, int diametro, Color cor) {
        g2.setColor(cor);
        g2.fillOval(x, y, diametro, diametro);
        g2.setColor(Color.BLACK);
        g2.drawOval(x, y, diametro, diametro);
    }
}
