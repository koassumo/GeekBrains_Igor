package lesson6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Client2 extends JFrame implements ActionListener, TCPConnectionListener {

    private static final String IP_ADDR = "localhost";
    private static final int PORT = 8189;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    // для вывода свинга в своем потоке, поэтому такая конструкция обязательна
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Client2();
            }
        });
    }

    private final JTextArea log = new JTextArea();
    private final JTextField fieldNickname = new JTextField("Masha");
    private final JTextField fieldInput = new JTextField();

    private TCPConnection connection;

    private Client2 (){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        log.setEditable(false);
        log.setLineWrap(true);

        add(fieldNickname, BorderLayout.NORTH);
        add(log, BorderLayout.CENTER);
        add(fieldInput, BorderLayout.SOUTH);
        fieldInput.addActionListener(this);  // лисенер навешиваем

        setVisible(true);

        try {
            connection = new TCPConnection(this, IP_ADDR, PORT);
        } catch (IOException e) {
            printMSg("Connection exception: " + e);;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = fieldInput.getText();
        if (msg.equals("")) return;
        fieldInput.setText(null);
        connection.sendString(fieldNickname.getText() + ": " + msg);
    }

    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
        printMSg("Connection ready");
    }

    @Override
    public void onReceivedString(TCPConnection tcpConnection, String value) {
        printMSg(value);
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        printMSg("Connection close");
    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {
        printMSg("Connection exception: " + e);
    }

    private synchronized void printMSg (String msg) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.append(msg + "\n");
                log.setCaretPosition(log.getDocument().getLength());
            }
        });
    }
}
