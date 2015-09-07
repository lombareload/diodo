package diodo;

import diodo.controller.NodoController;
import sun.awt.VerticalBagLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private JPanel panel = new JPanel();
    private JPanel leftPanel = new JPanel(new VerticalBagLayout(20));
    private JPanel rightPanel = new JPanel(new VerticalBagLayout(20));
    private JPanel centerPanel = new JPanel();
    private JTextField textField = new JTextField(10);

    private NodoController nodoController = new NodoController();

    public App() {
        panel.setLayout(new BorderLayout());
        panel.add(new Label("Root!!", Label.CENTER), BorderLayout.NORTH);
        panel.add(leftPanel, BorderLayout.EAST);
        panel.add(rightPanel, BorderLayout.WEST);
        centerPanel.add(textField);
        panel.add(centerPanel, BorderLayout.CENTER);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nodoController.push(textField.getText());
            }
        });

        leftPanel.add(new Label("left 1"), CENTER_ALIGNMENT);
        leftPanel.add(new Label("left 2"));

        rightPanel.add(new Label("right 1"));
        rightPanel.add(new Label("right 2"));

        this.setContentPane(panel);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}
