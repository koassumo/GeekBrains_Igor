package lesson6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class A_SERVER_Swing {

    public static void main(String[] args) {

        Socket socket = null;
        DataInputStream in;
        DataOutputStream out;

        // ---------------------- МОЕ РАНЕЕ НАПИСАННОЕ ОКНО НА СВИНГЕ -----------------------------------------------------------

        JFrame myFrame = new JFrame("Сервер");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel myPanel = new JPanel();                        // основная панель
        BorderLayout myBorderLayout = new BorderLayout();     // подложка для основной панели
        JPanel southPanel = new JPanel();                        // нижняя панель
        FlowLayout southLayout = new FlowLayout(FlowLayout.CENTER);     // подложка для нижней панели
        // поле для всей переписки
        JTextArea bigField = new JTextArea(20,20);
        bigField.setFont(new Font("Arial", Font.BOLD,14));           // шрифт
        bigField.setEditable(false);                                               // запрет на редактирование (чтобы с клавы нельзя было поменять текст)
        // строка для ввода текста
        JTextField inputTextField = new JTextField("",33);
        inputTextField.setHorizontalAlignment(JTextField.LEFT);                    // выровнить текст по краю
        inputTextField.setFont(new Font("Courier", Font.BOLD,14));     // шрифт
        inputTextField.setEditable(true);
        //кнопка
        JButton buttonEnter = new JButton("Ввод");
        // разметка панелей с помощью подложек
        myPanel.setLayout(myBorderLayout);
        southPanel.setLayout(southLayout);
        // размещение на основной панеле
        myPanel.add("Center", bigField);
        myPanel.add("South", southPanel);
        // размещение на нижней панеле
        southPanel.add("Left", inputTextField);
        southPanel.add("Right", buttonEnter);
        // вывод окна
        myFrame.setContentPane(myPanel);
        myFrame.setSize(500,500);
        myFrame.setVisible(true);

        ActionListener inputListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                bigField.setText(bigField.getText() + "\n" + inputTextField.getText()); inputTextField.setText("");
//                out.writeUTF("Эхо (с) сервер: " + stringIN);
            }
        };

        //обработчик событий
        inputTextField.addActionListener(inputListener);    //  заполнение поля с клавы
        buttonEnter.addActionListener(inputListener);    //  нажатие на кнопку ввод




        try (ServerSocket serverSocket = new ServerSocket(8189)) {    // только 1 параметр - порт
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();                     // здесь выполнение блокируется до подключения клиента
            System.out.println("Клиент подключился");


            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            // далее бесконечная прослушка канала для приема входящих
            while (true) {
                String stringIN = in.readUTF();
                if (stringIN.equals("/end")) { // это если пришла команда "конец связи" ...
                    break;
                }
                bigField.setText(bigField.getText() + "\n" + "Клиент: " + stringIN); inputTextField.setText("");
                out.writeUTF("Эхо (с) сервер: " + stringIN);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
