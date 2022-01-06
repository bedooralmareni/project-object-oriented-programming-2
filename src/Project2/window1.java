package Project2;

import java.awt.*;                        
import java.awt.event.*;                  
import javax.swing.*;                    
import java.io.*;                     


public class window1 extends JFrame implements ActionListener
{
    private JPanel namePanel;            // To reference a panel 
    private JPanel buttonPanelPlay;      // To reference a button panel
    private JLabel nameLabel;            // Displays the message
    private JTextField nameText;         // To reference a text field
    private JButton playButton;          // To reference a button
    private JButton rulesButton;         // To reference a button
    final int WINDOW_WIDTH = 400;        // Window width in pixels
    final int WINDOW_HEIGHT = 400;       // Window height in pixels
    
    // The following will reference menu components.
    private JMenuBar menuBar;            // The menu bar
    private JMenu fileMenu;              // The File menu
    private JMenuItem exitItem;          // To exit
    private JMenu settingsMenu;          // The File menu
    private JMenuItem Rules;             // To exit
    
     Window2 game;
    /** 
     * constructor
     */
    public window1()
    {
        
        // Setting the title
        setTitle("Prove that you're smart!");  
        
        // Set the size of the window.
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        // Setting the action close to the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        // Create a BorderLayout manager for the content pane
        setLayout(new BorderLayout());

        // Build the panel and add it to the frame
        buildnamePanel();
        buttonPanelPlay();
        
        // Build the menu bar
        buildMenuBar();      
        
        // Add the panels to the frame's content pane.
        add(namePanel, BorderLayout.CENTER);
        add(buttonPanelPlay, BorderLayout.SOUTH);
               
        // Center the frame 
        setLocationRelativeTo(null);   
        
        // Display the window  
        setVisible(true);    
    }
    
private void buildMenuBar()
{
   menuBar = new JMenuBar();

   // Create menus.
     buildFileMenu();
    buildSettingsMenu();
 

    // Add the file and restar menus to the menu bar.
     menuBar.add(fileMenu);
     menuBar.add(settingsMenu);

 
     setJMenuBar(menuBar);
}
    
// the buildfile method adds a label, a text field, and a button
private void buildFileMenu()
  {
 // Create an Exit menu item.
   exitItem = new JMenuItem("Exit");
   exitItem.addActionListener(new ExitListener());

 
 // Create a JMenu object for the File menu.
   fileMenu = new JMenu("File");


// Add the Exit menu item to the File menu.
    fileMenu.add(exitItem);
  }

private void buildSettingsMenu()
  {
 // Create an Settings menu item.
   Rules = new JMenuItem("How to play");
   Rules.addActionListener(new RulesListener());
   

    
   
// Create a JMenu object for the Settings menu.
   settingsMenu = new JMenu("Settings");
   

// Add the Rules menu item and music menu item to the Settings menu.
   settingsMenu.add(Rules);
  }
 /**
 Private inner class that handles the event when
 the user selects an item from the list.
 */
private class ExitListener implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
      System.exit(0);
   }
}
 /**
 Private inner class that handles the event when
 the user selects an item from the list.
 */
private class RulesListener implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
    dispose();
    howToPlay howToPlay =new howToPlay();
   }
}


    // The buildnamePanel method adds a label, a text field, and a button
    private void buildnamePanel()
    {
        // Create the panel
        namePanel = new JPanel(); 
        
        // Set a layout
        namePanel.setLayout(null);
        
        // Creating the messageLabel
        nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.ORANGE);
        nameLabel.setFont(new Font("INK Free",Font.BOLD,25));
        nameLabel.setBounds(50, 100, 225, 20);
        
        // Creating the textField
        nameText= new JTextField(10);
        nameText.setForeground(Color.BLACK);
        nameText.setFont(new Font("INK Free",Font.BOLD,20));
        nameText.setBounds(140, 100, 150, 25);
        
        // Add the componnets to the panels 
        namePanel.add(nameLabel);
        namePanel.add(nameText);
    }
    
    // The buttonPanelPlay method adds a label, a text field, and a button
    private void buttonPanelPlay()
    {
        // Create the panel
        buttonPanelPlay = new JPanel();
        buttonPanelPlay.setLayout(new FlowLayout(FlowLayout.CENTER));
       
        // create a button 
        playButton = new JButton("Play");
        playButton.setForeground(Color.ORANGE);
        playButton.setBackground(Color.WHITE);
        playButton.setFont(new Font("MV Boil",Font.BOLD,25));
        playButton.setFocusable(false);
        
        // Add actionListener
        playButton.addActionListener(this); 
        
        // Add the componnets to the panels 
        buttonPanelPlay.add(playButton);
    }      
 /**
  Private inner class that handles the event that is generated when the 
  user click play  
 */    
 @Override
 public void actionPerformed(ActionEvent e)
 {
  String name = "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";
  boolean match = nameText.getText().matches(name);
  boolean Empty = nameText.getText().trim().isEmpty();
            
   if(Empty == true)
   {
   JOptionPane.showMessageDialog(null, "Please enter your name");
   }else
   {                
    if(Empty == false)
   {
       if(match == false)
       {
       JOptionPane.showMessageDialog(null, "Please enter correct name'only letter'!");
       }else
       {
       writetoFile();
       dispose();
       game = new Window2();  
       }
    }
    }    
}
//write to File the name
 private void writetoFile() 
    {
        
        BufferedWriter playerRecordResulte;
        try{
            playerRecordResulte = new BufferedWriter(new FileWriter("playerRecordResulteFile.txt",false));
            //write in file
          
            playerRecordResulte.write((String) nameText.getText() +"\n");
            
            
            System.out.print("\nsuccesfullly write name");
            playerRecordResulte.close();
        }catch(FileNotFoundException e)
        {
            System.out.print("error");
        }catch(IOException ex)
        {
           System.out.print("error"); 
        }
        
        
    }
}
