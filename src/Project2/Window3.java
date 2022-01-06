
package Project2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.stream.Collectors;

public class Window3 extends JFrame implements ActionListener
{
    private JPanel paneljoy;           //To reference a panel joy
    private JPanel panelButton;         //To reference a Button panel
    private JPanel panelResult;         //To reference a Result panel 
    private JLabel nameLabel;          // Displays the name
    private JLabel resultLabel;          // Displays the Result
    private JLabel messageLabel;       // Displays the message
    private JLabel joyGft;               // Displays the joy
    private JButton buttonRetry,buttonExit; //To reference a 2 button 
    
    // The following will reference menu components.
   private JMenuBar menuBar;   // The menu bar
   private JMenu fileMenu;      // The File menu
   private JMenuItem exitItem;   // To exit
   private JMenu settingsMenu;  // The settings menu
   private JMenuItem Rules;    // To Rules              
   private JMenuItem restart;         // To restart
   
    /** 
     * constructor
     */
    
    public Window3()
    {
      // Set the title.
      setTitle("Prove That You Are Smart");
   
      // Set the size of the window.
      setSize(400, 400);
      setLocationRelativeTo(null);// Center the frame
      // Specify what happens when the close button is clicked.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Create a BorderLayout manager for the content pane.
      setLayout(new BorderLayout());
      
      // Create a panel.
      panelResult = new JPanel();
      paneljoy = new JPanel();
      panelButton= new JPanel();
       // Create a Retry button.  
      buttonRetry = new JButton("Retry");
      buttonRetry.setBackground(Color.WHITE);
      buttonRetry.setForeground(Color.ORANGE);
      buttonRetry.addActionListener(this);
      buttonRetry.setFont(new Font("MV Boil",Font.BOLD,25));
      buttonRetry.setFocusPainted(false);
       // Create a exit button.   
      buttonExit = new JButton("Exit");
      buttonExit.setBackground(Color.WHITE);
      buttonExit.setForeground(Color.ORANGE);
      buttonExit.addActionListener(this);
      buttonExit.setFont(new Font("MV Boil",Font.BOLD,27));
      buttonExit.setFocusPainted(false);	     
      // Create a gft.   
      joyGft = new JLabel(new ImageIcon("joy.gif"));
      joyGft.setBounds(5, 5, 5, 5);
      joyGft.setOpaque(false);
   
      //Set the layout 
      panelResult.setLayout(new FlowLayout());
       
      // Creating the nameLabel
      nameLabel = new JLabel();
      nameLabel.setForeground(Color.ORANGE);
      nameLabel.setFont(new Font("MV Boli",Font.PLAIN,30));
      nameLabel.setText(FromtheFile());
        
      // Creating the messageLabel
      messageLabel = new JLabel();
      messageLabel.setForeground(Color.ORANGE);
      messageLabel.setFont(new Font("MV Boli",Font.PLAIN,30));
      messageLabel.setText(" you get ");
         
      // Creating the resultLabel
      resultLabel = new JLabel();
      resultLabel.setForeground(Color.ORANGE);
      resultLabel.setFont(new Font("MV Boli",Font.PLAIN,30));
      resultLabel.setText( ReadFile());
        
      // Add the componnets to the panels 
      panelResult.add(nameLabel);
      panelResult.add(messageLabel);
      panelResult.add(resultLabel); 
      paneljoy.add(joyGft);
      panelButton.add(buttonRetry); 
      panelButton.add(buttonExit); 
      // Add the panels to the frame's content pane.
      add(panelResult,BorderLayout.NORTH);
      add(paneljoy,BorderLayout.CENTER);
      add(panelButton,BorderLayout.SOUTH);
      
      buildMenuBar();// Build the menu bar. 
        
      //Display the window   
      setVisible(true);    
        
    }
/**
The buildMenuBar method builds the menu bar
*/
private void buildMenuBar()
{
   
   menuBar = new JMenuBar();

   // Create menus.
    buildFileMenu();
    buildSettingsMenu();
 

    // Add the file and settings menus to the menu bar.
     menuBar.add(fileMenu);
     menuBar.add(settingsMenu);

 
     setJMenuBar(menuBar);
}
private void buildFileMenu()
{
 // Create an Exit menu item.
   exitItem = new JMenuItem("Exit");
   exitItem.addActionListener(new ExitListener());
 // Create an restart menu item.
   restart = new JMenuItem("Retry");
   restart.addActionListener(new restartListener());
 // Create a JMenu object for the File menu.
   fileMenu = new JMenu("File");
   
// Add the Exit menu item and restart menu item to the File menu.
    fileMenu.add(restart);
    fileMenu.add(exitItem);
}
private void buildSettingsMenu()
{
 // Create an Rules menu item.
   Rules = new JMenuItem("How to play");
   Rules.addActionListener(new RulesListener());
   
    
   
 // Create a JMenu object for the Settings menu.
   settingsMenu = new JMenu("Settings");
   

// Add the Rules menu item and music menu item to the Settings menu.
   settingsMenu.add(Rules);
}
private class ExitListener implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
      System.exit(0);
   }
}
private class RulesListener implements ActionListener
{
   public void actionPerformed(ActionEvent e)
   {
    dispose();
    howToPlay howToPlay=new howToPlay();
   }
}


   
private class restartListener implements ActionListener
{
    @Override
   public void actionPerformed(ActionEvent e)
   {
      dispose();
      window1 g = new  window1();
   }   
      
}
  @Override
public void actionPerformed(ActionEvent e)
{
     if(e.getSource()==buttonRetry)
     {
      dispose();
      window1 g = new  window1();
     }
     if(e.getSource()==buttonExit)
     {
         System.exit(0);
     }
}
//Read the name
   private String FromtheFile()
   {
       BufferedReader playerRecordResulteFile;
       String playerName=null;
       try{
         playerRecordResulteFile=new BufferedReader(new FileReader("playerRecordResulteFile.txt"));
         //read
         playerName=playerRecordResulteFile.lines().collect(Collectors.joining(System.lineSeparator()));
//         playerName = playerRecordResulteFile;
         
          System.out.print("\nsuccesfullly read name");
          playerRecordResulteFile.close();
          
       }catch(FileNotFoundException e)
        {
            System.out.print("error");
        }catch(IOException ex)
        {
           System.out.print("error"); 
        }
        return playerName;
       
   }
//read the Result
   private String ReadFile()
   {
       BufferedReader playerRecordResulteFile;
       String playerResulat=null;
       try{
         playerRecordResulteFile=new BufferedReader(new FileReader("playerRecordResulte.txt"));
         //read
         playerResulat=playerRecordResulteFile.lines().collect(Collectors.joining(System.lineSeparator()));
//         playerName = playerRecordResulteFile;
         
          System.out.print("\nsuccesfullly read resulat");
          playerRecordResulteFile.close();
          
       }catch(FileNotFoundException e)
        {
            System.out.print("error");
        }catch(IOException ex)
        {
           System.out.print("error"); 
        }
        return playerResulat;
       
   }

    
}
 