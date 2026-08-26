import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Font;

public class TelaSemaforo extends JFrame {

    private LogicaSemaforo logica;
    private PainelSemaforo painelSemaforo;
    private JLabel labelEstado;

    public TelaSemaforo() {
        logica = new LogicaSemaforo();

        setTitle("Semáforo Interativo");
        setSize(250, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        painelSemaforo = new PainelSemaforo(logica);
        add(painelSemaforo, BorderLayout.CENTER);

        labelEstado = new JLabel(logica.estadoAtual(), SwingConstants.CENTER);
        labelEstado.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(labelEstado, BorderLayout.NORTH);

        JButton botaoAvancar = new JButton("Avançar");
        // O listener só chama métodos da lógica — nenhuma regra de negócio aqui
        botaoAvancar.addActionListener(e -> {
            logica.avancar();
            labelEstado.setText(logica.estadoAtual());
            painelSemaforo.repaint();
        });
        add(botaoAvancar, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaSemaforo());
    }
}
