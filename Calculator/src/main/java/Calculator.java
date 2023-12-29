import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.Desktop;
import java.net.URI;


public class Calculator extends JFrame implements ActionListener, KeyListener{
    private boolean disabled = false;
    private final Random random = new Random();
    private final Sound SOUND_1 = new Sound("C:\\Users\\User\\IdeaProjects\\PP\\Calculator\\calculatorSound1.wav");
    private final Sound SOUND_2 = new Sound("C:\\Users\\User\\IdeaProjects\\PP\\Calculator\\calculatorSound2.wav");
    private final Sound SOUND_3 = new Sound("C:\\Users\\User\\IdeaProjects\\PP\\Calculator\\calculatorSound3.wav");
    private final Sound SOUND_4 = new Sound("C:\\Users\\User\\IdeaProjects\\PP\\Calculator\\calculatorSound4.wav");
    private final Sound[] SOUNDS = {SOUND_1, SOUND_2, SOUND_3, SOUND_4};
    private final JTextField textField;
    private  JButton[] Buttons = new JButton[25];

    private JButton clrButton, leftParButton, rightParButton, divButton, sendButton;
    private JButton mulButton, rootButton;
    private JButton subButton, powerButton;
    private JButton plusButton, piButton;
    private JButton dotButton, delButton, equButton, eButton;
    private Font myFont = new Font("", Font.BOLD, 25);
    Calculator() {
        for (int i = 0; i < SOUNDS.length; i++) {
            SOUNDS[i].play();
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(520, 600);
        this.setResizable(false);
        this.setLayout(null);

        textField = new JTextField();
        textField.setFont(myFont);
        textField.setBounds(20, 20, 466, 60);
        textField.setEditable(false);
        textField.addKeyListener(this);
        textField.setText("(15^2)+√((4^3)*(5^2-8*2))+(7*(3^2)-√(20*2))*(6-2)");
        sendButton = new JButton(Operators.SEND);
        eButton = new JButton(Operators.E);
        piButton = new JButton(Operators.PI);
        powerButton = new JButton(Operators.POWER);
        rootButton = new JButton(Operators.ROOT);
        plusButton = new JButton(Operators.PLUS);
        subButton = new JButton(Operators.MINUS);
        mulButton = new JButton(Operators.MULTIPLY);
        divButton = new JButton(Operators.DIVIDE);
        dotButton = new JButton(Operators.DOT);
        dotButton.setBackground(Color.ORANGE);
        dotButton.setForeground(Color.black);
        equButton = new JButton(Operators.EQUAL);
        delButton = new JButton(Operators.DELETE);
        delButton.setBackground(Color.red);
        delButton.setForeground(Color.white);
        clrButton = new JButton(Operators.CLEAR);
        leftParButton = new JButton(Operators.LEFT_PARENTHESIS);
        rightParButton = new JButton(Operators.RIGHT_PARENTHESIS);

        for (int i = 0; i < 10; i++) {
            Buttons[i] = new JButton(String.valueOf(i));
            Buttons[i].setBackground(Color.GREEN);
        }
        Buttons[10] = sendButton;
        Buttons[11] = eButton;
        Buttons[12] = piButton;
        Buttons[13] = powerButton;
        Buttons[14] = rootButton;
        Buttons[15] = plusButton;
        Buttons[16] = subButton;
        Buttons[17] = mulButton;
        Buttons[18] = divButton;
        Buttons[19] = dotButton;
        Buttons[20] = equButton;
        Buttons[21] = delButton;
        Buttons[22] = clrButton;
        Buttons[23] = leftParButton;
        Buttons[24] = rightParButton;

        for (int i = 0; i < 25; i++) {
            Buttons[i].addActionListener(this);
            Buttons[i].setFont(myFont);
            Buttons[i].setFocusable(false);
        }

        //adding buttons to scene

        clrButton.setBounds(28, 100, 75, 75);
        leftParButton.setBounds(122, 100, 75, 75);
        rightParButton.setBounds(216, 100, 75, 75);
        divButton.setBounds(310, 100, 75, 75);
        sendButton.setBounds(404, 100, 75, 75);

        Buttons[7].setBounds(28, 190, 75, 75);
        Buttons[8].setBounds(122, 190, 75, 75);
        Buttons[9].setBounds(216, 190, 75, 75);
        mulButton.setBounds(310, 190, 75, 75);
        rootButton.setBounds(404, 190, 75, 75);

        Buttons[4].setBounds(28, 280, 75, 75);
        Buttons[5].setBounds(122, 280, 75, 75);
        Buttons[6].setBounds(216, 280, 75, 75);
        subButton.setBounds(310, 280, 75, 75);
        powerButton.setBounds(404, 280, 75, 75);

        Buttons[1].setBounds(28, 370, 75, 75);
        Buttons[2].setBounds(122, 370, 75, 75);
        Buttons[3].setBounds(216, 370, 75, 75);
        plusButton.setBounds(310, 370, 75, 75);
        piButton.setBounds(404, 370, 75, 75);

        dotButton.setBounds(28, 460, 75, 75);
        Buttons[0].setBounds(122, 460, 75, 75);
        delButton.setBounds(216, 460, 75, 75);
        eButton.setBounds(310, 460, 75, 75);
        equButton.setBounds(404, 460, 75, 75);

        for (int i = 0; i < 25; i++) {
            this.add(Buttons[i]);
        }
        this.add(textField);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SOUNDS[random.nextInt(4)].play();
        if (e.getSource() == delButton && !disabled) {
            if (!textField.getText().equals(""))
                textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
        } else if (e.getSource() == clrButton) {
            textField.setText("");
            if (disabled)
                disabled = false;
        } else if (e.getSource() == equButton && !disabled) {
            OperationManager operationManager = new OperationManager();
            textField.setText(operationManager.calculatePolish(operationManager.converToPolish(textField.getText())));
            if (textField.getText().equals("Error")) {
                disabled = true;
            }
        }else if (e.getSource() == sendButton && !disabled) {
            OperationManager operationManager = new OperationManager();
            String urlOperation = operationManager.convertPolishToURL(operationManager.converToPolish(textField.getText()));
            String websiteURL = "https://maselkovol.github.io/operationTreeGenerator/?field=" + urlOperation;
            try {
                // Check if the Desktop is supported (available for the current platform)
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();

                    // Check if browsing is supported (some environments may not support this)
                    if (desktop.isSupported(Desktop.Action.BROWSE)) {
                        URI uri = new URI(websiteURL);
                        desktop.browse(uri);
                    } else {
                        System.out.println("Browsing is not supported on this platform.");
                    }
                } else {
                    System.out.println("Desktop is not supported on this platform.");
                }
            } catch (Exception error) {
            }
        } else if (!disabled) {
            for (int i = 0; i < Buttons.length; i++) {
                if (e.getSource() == Buttons[i])
                    textField.setText(textField.getText() + Buttons[i].getText());
            }
        }
    }
    @Override
    public void keyTyped (KeyEvent e) {
    }
    @Override
    public void keyPressed (KeyEvent e) {
    }
    @Override
    public void keyReleased (KeyEvent e) {
        if (e.getKeyChar() == 27) {
            textField.setText("");
            disabled = false;
        } else if (!disabled) {
            if (e.getKeyChar() == '*') {
                textField.setText(textField.getText() + Operators.MULTIPLY);
            } else if (e.getKeyChar() == '(') {
                textField.setText(textField.getText() + Operators.LEFT_PARENTHESIS);
            } else if (e.getKeyChar() == ')') {
                textField.setText(textField.getText() + Operators.RIGHT_PARENTHESIS);
            }
            else if ((e.getKeyCode() > 47 && e.getKeyCode() < 58)) {
                textField.setText(textField.getText() + String.valueOf(e.getKeyCode() - 48));
            } else if (e.getKeyCode() == 32) {
                OperationManager operationManager = new OperationManager();
                textField.setText(operationManager.calculatePolish(operationManager.converToPolish(textField.getText())));
                if (textField.getText().equals("Error")) {
                    disabled = true;
                }
            } else if (e.getKeyChar() == '+') {
                textField.setText(textField.getText() + Operators.PLUS);
            } else if (e.getKeyChar() == '-') {
                textField.setText(textField.getText() + Operators.MINUS);
            } else if (e.getKeyChar() == '/') {
                textField.setText(textField.getText() + Operators.DIVIDE);
            } else if (e.getKeyChar() == '√') {
                textField.setText(textField.getText() + Operators.ROOT);
            } else if (e.getKeyChar() == '^') {
                textField.setText(textField.getText() + Operators.POWER);
            } else if (e.getKeyChar() == 'e') {
                textField.setText(textField.getText() + Operators.E);
            } else if (e.getKeyChar() == 'π') {
                textField.setText(textField.getText() + Operators.PI);
            } else if (e.getKeyCode() == 8) {
                if (!textField.getText().equals(""))
                    textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
            }
        }
    }
}
