import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;
public class Output extends JFrame implements ActionListener{
    public Output(String password){
        setSize(400,300);
        setResizable(false);
        JLabel lblselect = getLabel("output");
        setTitle("Output");
        lblselect.setText(password.toString());
        add(lblselect);
      
        GridLayout mainLayout = new GridLayout(5,2);
        setLayout(mainLayout);

        JButton  btnHome = new JButton("Home");
        btnHome.setPreferredSize(new Dimension(40, 40));
        btnHome.addActionListener(this);
        btnHome.setActionCommand("Home");
        add(btnHome);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }
    JLabel getLabel(String txt) {
        return new JLabel(txt);
      }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
    
    if(cmd.equals("Home"))
        {
            dispose();
            new MainScreen();
        }
    }


  }
