import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;
public class ChkPassword extends JFrame implements ActionListener{
    JTextField textField;
    JLabel lblMsg;
    public ChkPassword(){
        setSize(400,300);
        setResizable(false);
        JLabel lblselect = getLabel("Enter a password-");
        setTitle("Check Password");
        add(lblselect);
      
        GridLayout mainLayout = new GridLayout(3,2);
        setLayout(mainLayout);

        textField = new JTextField();
        add(textField);
        JButton  btnHome = new JButton("Home");
        //btnHome.setPreferredSize(new Dimension(40, 40));
        btnHome.addActionListener(this);
        btnHome.setActionCommand("Home");
        add(btnHome);
        
        JButton btnCheck = new JButton("Check");
        //btnCheck.setPreferredSize(new Dimension(40, 40));
        btnCheck.addActionListener(this);
        btnCheck.setActionCommand("Check");
        add(btnCheck);

        lblMsg = new JLabel("                    ");
        add(lblMsg);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }
    JLabel getLabel(String txt) {
        return new JLabel(txt);
      }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        //System.out.println(cmd);
    
    if(cmd.equals("Home"))
        {
            dispose();
            new MainScreen();
        }

    if(cmd.equals("Check"))
    {   if(!textField.getText().trim().equals("")){
        dispose();
        Generator gen = new Generator();
        String message= gen.checkPassword(textField.getText());
        new Output(message);
    } else{
        lblMsg.setText("*Please enter a password!");
    }
    }

  }
}
