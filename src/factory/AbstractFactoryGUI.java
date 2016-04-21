package factory;

import java.awt.event.*;
import java.awt.*;
import java.net.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.io.File;
import java.io.IOException;


public class AbstractFactoryGUI extends JFrame
{
  private JSplitPane  bigSplitPane;
  private JScrollPane showInfoPane;
  private JPanel btnPanel;
  private JEditorPane editorPane;
  private JComboBox cmbHouseClass, cmbHouseType;
  private JLabel lblHouseClass, lblHouseType;
  private Dimension   minimumSize;

  public static final String SEARCH = "Search";
  public static final String EXIT = "Exit";
  public static final String BAOXIAN = "baoxian";
  public static final String JIJIN = "jijin";


  public AbstractFactoryGUI() {
     super("Abstract factory Pattern-Search for houses. ");
     minimumSize = new Dimension(130, 100);
     setUpChoicePanel();
     setUpScrollPanes();
   }

  private void setUpChoicePanel() {

      cmbHouseClass = new JComboBox();
	  cmbHouseClass.addItem("man class");
	  cmbHouseClass.addItem( "women class");
	

	  cmbHouseType = new JComboBox();
	  cmbHouseType.addItem(BAOXIAN);
	  cmbHouseType.addItem(JIJIN);

	  lblHouseClass = new JLabel("sex Class:");
	  lblHouseType = new JLabel("Type:");

	  //Create the open button
	  JButton openButton = new JButton(SEARCH);
	  openButton.setMnemonic(KeyEvent.VK_S);
	  JButton exitButton = new JButton(EXIT);
	  exitButton.setMnemonic(KeyEvent.VK_X);

	  ButtonListener btnListener = new ButtonListener();

	  // add action Listener
	  openButton.addActionListener(btnListener);
	  exitButton.addActionListener(btnListener);

	  btnPanel = new JPanel();

	  //------------------------------------------------
	  GridBagLayout gridbag = new GridBagLayout();
	  btnPanel.setLayout(gridbag);
	  GridBagConstraints gbc = new GridBagConstraints();

	  btnPanel.add(lblHouseClass);
	  btnPanel.add(cmbHouseClass);
	  btnPanel.add(lblHouseType);
	  btnPanel.add(cmbHouseType);
	  btnPanel.add(openButton);
	  btnPanel.add(exitButton);

      gbc.insets.top = 5;
      gbc.insets.bottom = 5;
      gbc.insets.left = 5;
      gbc.insets.right = 5;

      gbc.gridx = 0;
      gbc.gridy = 0;
      gridbag.setConstraints(lblHouseClass, gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gridbag.setConstraints(cmbHouseClass, gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      gridbag.setConstraints(lblHouseType, gbc);
      gbc.gridx = 1;
      gbc.gridy = 1;
      gridbag.setConstraints(cmbHouseType, gbc);
      gbc.insets.left = 2;
      gbc.insets.right = 2;
      gbc.insets.top = 15;
      gbc.gridx = 0;
      gbc.gridy = 5;
      gridbag.setConstraints(openButton, gbc);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 1;
      gbc.gridy = 5;
      gridbag.setConstraints(exitButton, gbc);
      //-----------------------------------------------
   }

   private void setUpScrollPanes() {
   	  Border raisedbevel = BorderFactory.createRaisedBevelBorder();
  	  editorPane = new JEditorPane();

  	  showInfoPane = new JScrollPane(editorPane);
  	  bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, showInfoPane, btnPanel);
  	  bigSplitPane.setDividerLocation(220);

      getContentPane().add(bigSplitPane);
  	  setSize(new Dimension(500, 300));
      setVisible(true);
   }

   class ButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent ae) {

		if (ae.getActionCommand().equals(AbstractFactoryGUI.EXIT)) {
		    System.exit(1);
		}

		if (ae.getActionCommand().equals(AbstractFactoryGUI.SEARCH)) {

		    String clas = (String) cmbHouseClass.getSelectedItem();
		    String type = (String) cmbHouseType.getSelectedItem();

		    System.out.println(clas);
		    System.out.println(type);
		    
		    BuildingFactory bf = BuildingFactory.getBuildingFactory(clas);

		    if (type.equals(AbstractFactoryGUI.BAOXIAN)) {
		         BaoXian bx = bf.getBaoxian();
		         String fileNm = bx.getBaoXianInfo();
		         putHouseInfoToScreen(fileNm);
		    }

		    if (type.equals(AbstractFactoryGUI.JIJIN)) {
		         JiJin jj = bf.getJijin();
		         String fileNm =jj.getJiJinInfo();
		         putHouseInfoToScreen(fileNm);
		     }
          }
      }

      private void putHouseInfoToScreen(String fileName) { 
		  	 try {
		  		URL url = (new File(fileName)).toURL();
				editorPane.setPage(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	  }
  }

   public static void main(String args[])
   {
      try {
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      }
      catch (Exception evt) {}

      AbstractFactoryGUI frame = new AbstractFactoryGUI();
      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e)
         {
            System.exit(0);
         }
      }
      );
      frame.setSize(500, 420);
      frame.setVisible(true);
   }
}

