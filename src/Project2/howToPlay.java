
package Project2;

import java.awt.*;
import java.awt.event.*;     // Needed for ActionListener Interface
import javax.swing.*;        // Needed for Swing classes
import java.io.*;            // Needed for file I/O classes


public class howToPlay extends JFrame implements ActionListener{
    
    private JTextArea textArea;// To display the text
    private JButton ok;      //To reference a Button 
    
    public howToPlay()
    {
        // Setting the title
        setTitle("Prove that you're smart!");  
        
        // Set the size of the window.
        setSize(400,400);
        
        // Setting the action close to the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(new BorderLayout());
        // Center the frame 
        setLocationRelativeTo(null);
       // Create a ok button.   
       ok = new JButton("OK");
       ok.setBackground(Color.WHITE);
       ok.setForeground(Color.ORANGE);
       ok.setFont(new Font("MV Boil",Font.BOLD,20));
       ok.setFocusable(false);
       ok.addActionListener(this); 
       // Create a textArea
        textArea = new JTextArea(11,25);
    
        textArea.setText("Rules:\n" +
       "There are two buttons (True, False) it is\n" +
       "true if :\n" +
       "-names of colors:\n they are answered" +
       "by the color of the text, and if the text is" +
       "black, they are answered by the color\n" +
       "of the background.\n" +
       "-directions \n they are answered by the" +
       "direction of the arrow not the name.");
        textArea.setFont(new Font("MV Boil",Font.BOLD,20));
        textArea.setBackground(Color.WHITE);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true); 
        textArea.disable();
        textArea.setDisabledTextColor(Color.ORANGE);
    
        // Add the textArea and button to the frame's
        add(textArea,BorderLayout.CENTER);
        add(ok,BorderLayout.SOUTH);  

        //pack and Display the window
        pack();
        setVisible(true);    
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == ok)
            {
             dispose(); 
             window1 window1 = new window1();
               
            }
    }
}
