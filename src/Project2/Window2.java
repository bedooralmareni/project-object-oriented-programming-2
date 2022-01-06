/*
 *
 */
package Project2;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Window2 extends JFrame  implements ActionListener
{
   private JPanel QPanel;                    // A panel to hold a label
   private JPanel buttonPanel;                // A panel to hold a button
   private JPanel timePanel;                  // A panel to hold a time
   private JLabel QLabel;                    // A label to hold an image
   private ImageIcon QImageIcon;             // To hold a questions image
   private JButton Truebutton;                // A button if it is true
   private JButton Falsebutton;               // A button if it is false
   private ArrayList<ImageIcon> questionsImageList;  // ArrayList to hold the questions images.
   private JLabel Timelabel;                      // A label to hold a time
   private JLabel secondLift;                     // A label to hold a second
   private Timer timer;
   // The following will reference menu components.
   private JMenuBar menuBar;   // The menu bar
   private JMenu fileMenu;      // The File menu
   private JMenuItem exitItem;   // To exit
   private JMenu settingsMenu;  // The settings menu
   private JMenuItem Rules;    // To Rules              
   private JMenuItem restart;         // To restart
   
   
   public int correctAnswer=0;//to hold correctAnswer
   public int result;         //to hold result
   private int second=5;     //to hold second
   int index;               
   String[] answer = {"true","true","true","true"
                   ,"false","false","false","false","false","false"};//array hold the true answer
   String answer1;         //to hold answer 
   /**
    * method 2 calculate the result 
    * @return result
    */
   public int getresult() 
   {
         this.dispose();
         return correctAnswer;
   }
   /**
    * constructor
    */
  public  Window2()
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
       
     
     
      buildMenuBar();// Build the menu bar.
      
      // Build the questionsimageList
      buildquestionsImageList();

      // Build the panels.
      buildquestionsPanel();
      buildButtonPanel();
      buildTimer();
      
      
      // Add the panels to the content pane.
      add(QPanel, BorderLayout.NORTH);
      add(buttonPanel, BorderLayout.SOUTH);
      add(timePanel,BorderLayout.WEST);
     
      // Display the window.
      setVisible(true);
      nextQuestion();//call next question method
     
}
/**
  The private void buildquestionsPanel method adds a panel of question
 */
private void buildquestionsPanel()
{
      // Create a panel.
      QPanel = new JPanel();
      // Create a label.
      QLabel = new JLabel();
      // Add the label to the panel.
      QPanel.add(QLabel);  
}
/**
  The private void buildButtonPanel method adds a 2 Button to the panel
 */
private void buildButtonPanel()
{
      // Create a panel.
      buttonPanel = new JPanel();
      buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
      // Create a buttons.
      Truebutton = new JButton("TRUE");
      Falsebutton = new JButton("FAlSE");
      
      // Register an action listener with the button.
      Truebutton.addActionListener(this);
      Falsebutton.addActionListener(this);
      
      Truebutton.setBackground(Color.WHITE);
      Falsebutton.setBackground(Color.WHITE);
      Truebutton.setForeground(Color.GREEN);
      Falsebutton.setForeground(Color.RED);
      Truebutton.setFont(new Font("MV Boil",Font.BOLD,25));
      Falsebutton.setFont(new Font("MV Boil",Font.BOLD,25));
      Truebutton.setFocusable(false);
      Falsebutton.setFocusable(false);
      // Add the button to the panel. 
      buttonPanel.add(Truebutton);
      buttonPanel.add(Falsebutton);  
}
/**
  The private void  buildquestionsImageList method 
 */
 private void buildquestionsImageList()
   {
      // Create the cardImageList ArrayList 
      // to hold the ImageIcon objects.
      questionsImageList = new ArrayList<>();
      
      // Add the ImageIcon objects to the QImageList ArrayList
      questionsImageList.add(new ImageIcon("q1T.jpg"));
      questionsImageList.add(new ImageIcon("q2T.jpg"));
      questionsImageList.add(new ImageIcon("q3T.jpg"));
      questionsImageList.add(new ImageIcon("q4T.jpg"));
      
      questionsImageList.add(new ImageIcon("q5F.jpg"));
      questionsImageList.add(new ImageIcon("q6F.jpg"));
      questionsImageList.add(new ImageIcon("q7F.jpg"));
      questionsImageList.add(new ImageIcon("q8F.jpg"));
      questionsImageList.add(new ImageIcon("q9F.jpg"));
      questionsImageList.add(new ImageIcon("q10F.jpg"));
}
/**
  The private void buildTimer method 
 */
private void  buildTimer()
{     // Create a panel.
      timePanel = new JPanel();
      timePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      // Create a Label.
      secondLift = new JLabel();
      Timelabel = new JLabel();
      
      secondLift.setBounds(535,510,50,100);
      secondLift.setForeground(new Color(255,0,0));
      secondLift.setFont(new Font("Ink Free",Font.BOLD,30));
      secondLift.setOpaque(true);
      secondLift.setText(String.valueOf(second));
      Timelabel.setBounds(535,300,100,25);
      Timelabel.setFont(new Font("MV Boli",Font.PLAIN,20));
      Timelabel.setText("Timer");
      
       // Add the label to the panel.
      timePanel.add(Timelabel);
      timePanel.add(secondLift);
      // Register an action listener with the timer.
      timer = new Timer(1000,new ActionListener()
      {
      @Override
      public void actionPerformed(ActionEvent e) 
      {
        second--;
        secondLift.setText(String.valueOf(second));
        if(second <=0)
             {
              disPlayAnswer();   
             }
      }
      });
}
/**
 * The public void nextQuestion method
 */      
public void nextQuestion()
    {
       if(! questionsImageList.isEmpty())
       {
            // Create a reference to a Random object.
           Random rand = new Random();
           // Generate a random number between 0 and the
           // number of card images left in the array list,
           // and store the value in the index variable.
           int index = rand.nextInt(questionsImageList.size());
           // Get a question image from the array list using
           // the index value that was generated randomly.
           QImageIcon = questionsImageList.get(index);
           // Display the question image.
           QLabel.setIcon(QImageIcon);
           // Remove the question image from the array list.
           questionsImageList.remove(index);
           timer.start();//start the time
          
       }else
       {
          writetoFile();//write in file
          this.dispose();
          Window3 results = new Window3(); 
       }
    }
   @Override
public void actionPerformed(ActionEvent e)
{
    //dis enabeled button
    Truebutton.setEnabled(false);
    Falsebutton.setEnabled(false);
    if(e.getSource() == Truebutton)
    {
     answer1 = "true";
     if(answer1 == answer[index])
     {
       correctAnswer+=1;  
     }   
    }
    if(e.getSource() ==Falsebutton)
    {
     answer1 = "false";
     if(answer1 == answer[index])
     {
       correctAnswer+=1;  
     }  
    }
    disPlayAnswer();//call  disPlayAnswer method 
}
public void disPlayAnswer()
{
   timer.stop();//stop the time
   //dis enabeled button
   Truebutton.setEnabled(false);
   Falsebutton.setEnabled(false);
   
    Timer pause = new Timer(2000,new ActionListener()//to stop time
    {
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       second =5;
       secondLift.setText(String.valueOf(second));
       //enabeled button
       Truebutton.setEnabled(true);
       Falsebutton.setEnabled(true);
       index++;
       nextQuestion();//call  nextQuestion method
    }
    });
        pause.setRepeats(false);
        pause.start();
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
    howToPlay howToPlay =new howToPlay();
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
private void writetoFile() 
 { 
   BufferedWriter playerRecordResulteFile;
   try{
      playerRecordResulteFile = new BufferedWriter(new FileWriter("playerRecordResulte.txt",false));
      playerRecordResulteFile.write((String) String.valueOf(getresult())+"/10");
      System.out.print("\nsuccesfullly write Resulte");
      playerRecordResulteFile.close();
      }catch(FileNotFoundException e)
      {
        System.out.print("error");
      }catch(IOException ex)
      {
       System.out.print("error"); 
       }    
  }

}  