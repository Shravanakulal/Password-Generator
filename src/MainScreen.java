import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
public class MainScreen extends JFrame implements ActionListener {
  JRadioButton j1;
  JRadioButton j2;
  

    public MainScreen() {
        setSize(400,300);
        setResizable(false);
        JLabel lblselect = getLabel("Select a choice");
        setTitle("Home");
        
        GridLayout mainLayout = new GridLayout(5,1);
        setLayout(mainLayout);
        ButtonGroup mainGrp = new ButtonGroup();
        j1 = new JRadioButton();
        //j1.setLabel("test1");
        j2 = new JRadioButton();

        
        mainGrp.add(j1);
        mainGrp.add(j2);
        


        add(lblselect);
        add(getLabel(" "));
        JLabel lblGeneratePassword = getLabel("Generate Password:");
        add(lblGeneratePassword);
        add(j1);

        JLabel chkPassword = getLabel("Check Password:");
        add(chkPassword);
        add(j2);

        


        JButton  btnNext = new JButton("Next");
        /*btnNext.setPreferredSize(new Dimension(40, 40));*/
        btnNext.addActionListener(this);
        btnNext.setActionCommand("Next");
        add(btnNext);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
      
    }
    public 
    JLabel getLabel(String txt) {
      return new JLabel(txt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if(cmd.equals("Next"))
        {
          if (j1.isSelected()){
            dispose();
            new GenPassword();
          }
          if (j2.isSelected()){
            dispose();
            new ChkPassword();
          }
            
            /*dispose();
            new GenPassword(j1.isSelected(), j2.isSelected(), j3.isSelected());*/
        }
        
    }

    public static void main(String[] args){
      new MainScreen();
    }
}