import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.LineBorder;
 public class ImprovedCalculator extends JFrame implements ActionListener {
    
    private JTextField display;
    private double num1 = 0,num2 = 0, result = 0;
    private boolean isOperatorPressed = false;
    private char Operator = '\0';
    private boolean hasDecimal = false;

    public ImprovedCalculator(){
        setTitle("Improved Calculator");
        setSize(350,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        display = new JTextField();
        display.setFont(new Font("Arial",Font.BOLD,24));
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        add(display,BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel (new GridLayout(5,4,10,10));
        buttonPanel.setBorder(new LineBorder(Color.black, 20));

        String [] buttons = {
            "/","7","8","9",
            "*","4","5","6",
            "-","1","2","3",
            "+", "0", ".", "=",
            "CLEAR","⌫"
        };

        for(String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial",Font.BOLD,18));


            if(text.matches("[+\\-*/]")){
                btn.setBackground(Color.orange);
            }else if (text.equals("=")) {
                btn.setBackground(Color.lightGray);
            }else if (text.equals("CLEAR")){
                btn.setBackground(Color.orange);

            }else if (text.equals("⌫")) {
                btn.setBackground(Color.lightGray);
            }else{
                btn.setBackground(Color.lightGray);
            }
            btn.addActionListener(this);
            buttonPanel.add(btn);
            buttonPanel.setBackground(Color.black);
            
        }
        add(buttonPanel,BorderLayout.CENTER);
       addKeyListener(new KeyHandler());
        setFocusable(true);

    }
    public void actionPerformed(ActionEvent e) {
        String command = e. getActionCommand();

        if(command.matches("\\d")) {
            if(isOperatorPressed) {
                display.setText(command);
                isOperatorPressed = false;
                hasDecimal = false;

            }else {
                display.setText(display.getText() + command);

            } 
        }else if(command.equals(".")) {
                if(!hasDecimal) {
                    display.setText(display.getText() + ".");
                 }
            }else if (command.equals("CLEAR")) {
                clearAll();
            }else if (command.equals("⌫")) {
                String current = display.getText();
                if(!current.isEmpty()) {
                    display.setText(current.substring(0,current.length() - 1));
                    if(!display.getText().contains(".")) {
                        hasDecimal = false;
                    }
                }
            }else if (command.equals("=")) {
                calculate();
            }else if(command.matches("[+\\-*/]")){
                if(!display.getText().isEmpty()) {
                    num1=Double.parseDouble(display.getText());
                    Operator =  command.charAt(0);
                    isOperatorPressed =  true;
                    display.setText(String.valueOf(Operator)); 
                }
            }
            
        }
        private void clearAll() {

            display.setText("");
            num1 = num2 = result =0;
            Operator = '\0';
            isOperatorPressed= false;
            hasDecimal = false;

        }
        private void calculate() {
            try {
                num2 = Double.parseDouble(display.getText());
                switch(Operator) {
                    case '+':
                    result = num1 +num2;
                    break;
                    case '-':
                    result = num1 - num2;
                    break;
                    case '*':
                    result = num1 * num2;
                    break;
                    case '/':
                   if(num2==0 ) {
                    display.setText("Error /0");
                    return;
                   }
                    result = num1 /num2;
                    break;
                    default:
                    display.setText("Invalid");
                    return;
                }
                DecimalFormat df = new DecimalFormat("####");
                display.setText(df.format(result));
                isOperatorPressed= true;
            } catch (Exception ex) {
                display.setText("Error");
            }
        }
          class KeyHandler extends KeyAdapter {
            public void keyPressed(KeyEvent e) {
                char key = e.getKeyChar();
                int code = e.getKeyCode();

                if(Character.isDigit(key)) {
                    display.setText(display.getText() + key);

                }else if (key == '.'){
                    if(! hasDecimal) {
                        display.setText(display.getText() + ".");
                        hasDecimal = true;
                    }
                }else if (key == '+' || key == '-' || key== '*' || key == '/') {
                    if(!display.getText().isEmpty()) {
                        num1 = Double.parseDouble(display.getText());
                        Operator = key;
                        isOperatorPressed= true;
                        hasDecimal =false;
                    }
                }else if(code == KeyEvent.VK_ENTER) {
                    calculate();
                }else if (code == KeyEvent.VK_BACK_SPACE) {
                    String current= display.getText();
                    if(!current.isEmpty()) {
                        display.setText(current.substring(0,current.length() -1));
                        if(!display.getText().contains(".")) {
                            hasDecimal = false;
                        }
                        
                    }
                }
            }
          }
    public static void main (String [] args){
        SwingUtilities.invokeLater(() -> new ImprovedCalculator().setVisible(true));
    }
}