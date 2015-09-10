package diodo;

import diodo.controller.NodoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    // layout
    private JPanel panel = new JPanel();
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private JPanel centerPanel = new JPanel();

    // controls
    private JButton leftAddButton = new JButton("<<");
    private JButton rightAddButton = new JButton(">>");
    private JButton leftRemoveButton = new JButton("X");
    private JButton rightRemoveButton = new JButton("X");
    private JTextField textField = new JTextField(10);

    private NodoController nodoController = new NodoController(this);

    public App() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        panel.setLayout(new BorderLayout());
        panel.add(new Label("Root!!", Label.CENTER), BorderLayout.NORTH);
        panel.add(leftPanel, BorderLayout.WEST);
        panel.add(rightPanel, BorderLayout.EAST);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(textField);
        JPanel addButtons = new JPanel();
        addButtons.add(leftAddButton);
        addButtons.add(rightAddButton);
        centerPanel.add(addButtons);

        JPanel removeButtons = new JPanel();
        removeButtons.add(leftRemoveButton);
        removeButtons.add(rightRemoveButton);
        centerPanel.add(removeButtons);

        panel.add(centerPanel, BorderLayout.CENTER);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nodoController.push(textField.getText());
                textField.setText("");
            }
        });
        rightAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nodoController.pushRight(textField.getText());
                textField.setText("");
                textField.requestFocus();
            }
        });

        leftAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nodoController.pushLeft(textField.getText());
                textField.setText("");
                textField.requestFocus();
            }
        });

        rightRemoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nodoController.removeRight();
                textField.requestFocus();
            }
        });

        leftRemoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nodoController.removeLeft();
                textField.requestFocus();
            }
        });

        this.setContentPane(panel);
        this.pack();
        this.setVisible(true);
    }

    public void setLeftAddState(boolean enabled) {
        leftAddButton.setEnabled(enabled);
    }

    public void setRightAddState(boolean enabled) {
        rightAddButton.setEnabled(enabled);
    }

    public void setLeftRemoveState(boolean enabled) {
        leftRemoveButton.setEnabled(enabled);
    }

    public void setRightRemoveState(boolean enabled) {
        rightRemoveButton.setEnabled(enabled);
    }

    public void agregarItemALaDerecha(Component component){
        rightPanel.add(component);
    }

    public void agregarItemALaIzquierda(Component component){
        leftPanel.add(component);
    }

    public static void main(String[] args) {
        new App();
    }

    public void removerEnIzquierda(Component label) {
        leftPanel.remove(label);
        repaint();
    }

    public void removerEnDerecha(Component label) {
        rightPanel.remove(label);
        repaint();
    }
}
