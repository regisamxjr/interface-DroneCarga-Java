import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Janela extends JFrame {
    private JButton cadastrar, mostrarCadastros, sair, limpar;
    private JTextField codigoTexto, autonomiaTexto, pesoMaxTexto;
    private JTextArea mensagem;
    private ArrayList<Drone> drones;

    public Janela() {
        drones = new ArrayList<>();

        setTitle("Interface de Drones");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // para selecionar a posicao x e y desejada
        GridBagConstraints posicao = new GridBagConstraints();
        posicao.fill = GridBagConstraints.HORIZONTAL;
        posicao.insets = new Insets(5, 5, 5, 5);

        posicao.gridx = 0;
        posicao.gridy = 0;
        posicao.gridwidth = 2;
        JLabel titulo = new JLabel("CADASTRO DE DRONES DE CARGA", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(titulo, posicao);
        posicao.gridwidth = 1;

        posicao.gridx = 0;
        posicao.gridy = 1;
        add(new JLabel("Código: "), posicao);
        posicao.gridx = 1;
        codigoTexto = new JTextField(10);
        add(codigoTexto, posicao);

        posicao.gridx = 0;
        posicao.gridy = 2;
        add(new JLabel("Peso Máximo: "), posicao);
        posicao.gridx = 1;
        pesoMaxTexto = new JTextField(10);
        add(pesoMaxTexto, posicao);

        posicao.gridx = 0;
        posicao.gridy = 3;
        add(new JLabel("Autonomia: "), posicao);
        posicao.gridx = 1;
        autonomiaTexto = new JTextField(10);
        add(autonomiaTexto, posicao);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        posicao.gridx = 0;
        posicao.gridy = 5;
        posicao.gridwidth = 2;
        JLabel label1 = new JLabel("Tipo de carga: ");
        add(label1, posicao);

        posicao.gridy = 5;
        JCheckBox opcao1 = new JCheckBox("Viva");
        JCheckBox opcao2 = new JCheckBox("Inanimada");
        JPanel Panel1 = new JPanel();
        Panel1.add(opcao1);
        Panel1.add(opcao2);
        add(Panel1, posicao);


        posicao.gridx = 0;
        posicao.gridy = 6;
        posicao.gridwidth = 2;
        JLabel label2 = new JLabel("Proteção: ");
        add(label2, posicao);

        posicao.gridy = 6;
        JCheckBox op1 = new JCheckBox("Sim");
        JCheckBox op2 = new JCheckBox("Não");
        JPanel Panel2 = new JPanel();
        Panel2.add(op1);
        Panel2.add(op2);
        add(Panel2, posicao);

        posicao.gridx = 0;
        posicao.gridy = 7;
        posicao.gridwidth = 2;
        JLabel label3 = new JLabel("Climatizado: ");
        add(label3, posicao);

        posicao.gridy = 7;
        JCheckBox opt1 = new JCheckBox("Sim");
        JCheckBox opt2 = new JCheckBox("Não");
        JPanel panel3 = new JPanel();
        panel3.add(opt1);
        panel3.add(opt2);
        add(panel3, posicao);

        posicao.gridx = 0;
        posicao.gridy = 8;
        posicao.gridwidth = 2;
        cadastrar = new JButton("Cadastrar");
        add(cadastrar, posicao);
        cadastrar.addActionListener(e -> cadastrarDrone());

        posicao.gridy = 9;
        mostrarCadastros = new JButton("Mostrar Cadastros");
        add(mostrarCadastros, posicao);
        mostrarCadastros.addActionListener(e -> mostrarDronesCadastrados());

        posicao.gridy = 10;
        limpar = new JButton("Limpar");
        add(limpar, posicao);
        limpar.addActionListener(e -> limparCampos());

        posicao.gridy = 11;
        sair = new JButton("Sair");
        add(sair, posicao);
        sair.addActionListener(e -> saida());

        posicao.gridy = 12;
        mensagem = new JTextArea(20, 40);
        mensagem.setEditable(false);
        mensagem.setLineWrap(true);
        mensagem.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(mensagem);
        add(scrollPane, posicao);
    }

    public void limparCampos() {
        codigoTexto.setText("");
        autonomiaTexto.setText("");
        pesoMaxTexto.setText("");
        mensagem.setText("");
    }

    private void mostrarDronesCadastrados() {
        if (drones.isEmpty()) {
            mensagem.setText("Nenhum drone cadastrado.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Drone drone : drones) {
                sb.append(drone).append("\n");
            }
            mensagem.setText(sb.toString());
        }
    }

    public void cadastrarDrone() {
        try {
            int codigo = Integer.parseInt(codigoTexto.getText());
            double pesoMax = Double.parseDouble(pesoMaxTexto.getText());
            double autonomia = Double.parseDouble(autonomiaTexto.getText());

            for (Drone drone : drones) {
                if (drone.getCodigo() == codigo) {
                    mensagem.setText("ERRO: Já existe um drone cadastrado com este código");
                    return;
                }
            }

            Drone novoDrone = new Drone(codigo, pesoMax, autonomia);
            drones.add(novoDrone);
            mensagem.setText("Drone cadastrado com sucesso!");

        } catch (NumberFormatException ex) {
            mensagem.setText("Erro: Verifique se todos os campos numéricos estão preenchidos corretamente.");
        }
    }

    public void saida() {
        System.exit(0);
    }
}