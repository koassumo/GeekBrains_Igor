package lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainSwing {

    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Chat");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel myPanel = new JPanel();                        // основная панель
        BorderLayout myBorderLayout = new BorderLayout();     // подложка для основной панели

        JPanel southPanel = new JPanel();                        // нижняя панель
        FlowLayout southLayout = new FlowLayout(FlowLayout.CENTER);     // подложка для нижней панели


        // поле для всей переписки
        JTextField bigField = new JTextField("",20);
        bigField.setHorizontalAlignment(JTextField.LEFT);                         // выровнить текст по правому краю
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
            public void actionPerformed(ActionEvent e) { bigField.setText(bigField.getText() + "\n" + inputTextField.getText()); inputTextField.setText(""); }
        };

        inputTextField.addActionListener(inputListener);    //  заполнение поля с клавы
        buttonEnter.addActionListener(inputListener);    //  нажатие на кнопку ввод

    }

}
