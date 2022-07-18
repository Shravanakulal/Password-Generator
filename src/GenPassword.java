import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;
public class GenPassword extends JFrame implements ActionListener {
    JCheckBox j1;
    JCheckBox j2;
    JCheckBox j3;
    JCheckBox j4;
    JTextField length;
    JLabel lblMsg;
    public GenPassword(){
        setSize(400,300);
        setResizable(false);
        JLabel lblselect = getLabel("Select your preferences");
        setTitle("Generate Password");
        
        GridLayout mainLayout = new GridLayout(8,1);
        setLayout(mainLayout);

        j1 = new JCheckBox();
        //j1.setLabel("test1");
        j2 = new JCheckBox();
        
        j3 = new JCheckBox();
        
        j4 = new JCheckBox();
        
        length= new JTextField();

        add(lblselect);
        add(getLabel(" "));
        JLabel lblUppercase = getLabel("uppercase:");
        add(lblUppercase);
        add(j1);

        JLabel lblLowerCase = getLabel("lowercase:");
        add(lblLowerCase);
        add(j2);

        JLabel lblNumber = getLabel("numbers:");
        add(lblNumber);
        add(j3);

        JLabel lblSymbols = getLabel("symbols:");
        add(lblSymbols);
        add(j4);

        JLabel lblLength = getLabel("Enter length:");
        add(lblLength);
        add(length);

        JButton  btnHome = new JButton("Home");
        btnHome.setPreferredSize(new Dimension(40, 40));
        btnHome.addActionListener(this);
        btnHome.setActionCommand("Home");
        add(btnHome);
        
        JButton  btnGenerate = new JButton("Generate");
        btnGenerate.setPreferredSize(new Dimension(40, 40));
        btnGenerate.addActionListener(this);
        btnGenerate.setActionCommand("Generate");
        add(btnGenerate);

                
        
      lblMsg = new JLabel("                    ");
        add(lblMsg);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    JLabel getLabel(String txt) {
        return new JLabel(txt);
      }
      public static void main(String[] args){
      //  new GenPassword();
      }
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if(cmd.equals("Home"))
        {
            dispose();
            new MainScreen();
        }
        if(cmd.equals("Generate"))
        {
            if((j1.isSelected() || j2.isSelected() || j3.isSelected() || j4.isSelected()) && !length.getText().trim().equals("")){
                dispose();
                Generator gen = new Generator(j1.isSelected(), j2.isSelected(), j3.isSelected(), j4.isSelected());
                String password = gen.GeneratePassword(Integer.parseInt(length.getText()));
                new Output(password);
            } else if(length.getText().trim().equals("")) {
                lblMsg.setText("*Please enter length!");
            }
            
            else {
                lblMsg.setText("*Select at least one checkbox!");
            }          
        }
        
    }
}
