/* This is the main class that controls the UI and puts everything together */
package natalie.project.possystem.ui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;        
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;






import natalie.project.possystem.domain.Flavor;
import natalie.project.possystem.domain.FlavoredSellable;
import natalie.project.possystem.domain.GenericDecorator;
import natalie.project.possystem.domain.IceCream;

import java.util.ArrayList;
import java.util.List;
 
public class PoSSystem extends JPanel implements ActionListener {

	
		/* the left JPanel that contains the Flavor buttons */
	   private final 	JPanel flavorPanel = new JPanel();
	   
	   /* the middile JPanel that contains the decorator buttons */
	   private final 	JPanel decoratorPanel = new JPanel();
	   /* the Panel that contains the Textpane that displays the chosen flavor and amount total */
	   private final 	JPanel infoPanel = new JPanel();
	   
	   /* the Dialog that prompt user to enter info when adding a new flavor or decorator */
	   private  	JDialog jd; 
	   /* textfields that appears on the dialog */
	   private JTextField textField1 ;
   	   private JTextField textField2 ;
   	   
   	   /*TextPane that displays the the chosen flavor and amount total */
       private	JTextPane infoPane ;
       private JTextPane totalText;
       
       /*array of buttons of flavors and decorators */
   	  private List<JButton> flavorButtons = new ArrayList<JButton>();
   	  private List<JButton> decoratorButtons = new ArrayList<JButton>();
   	  
   	  /*The icecream that the customer is ordering */
   	  private FlavoredSellable _icecream = new IceCream();
   	  
   // private  void createAndShowGUI() {
	   public PoSSystem(){
        //Create and set up the GUI.

        this.setLayout(new BorderLayout());
        JPanel midPanel =  new JPanel();
		midPanel.setPreferredSize(new Dimension(800, 600));
		midPanel.setLayout(new GridLayout(0,3));

		
	    //create the default flavor buttons 
		flavorPanel.setLayout(new GridLayout(15,1));
		JButton flavorButton =  new JButton("Chocolate, $20");
		flavorButton.setActionCommand("pick_flavor");
		flavorButton.addActionListener(this);
		flavorButtons.add(flavorButton);
		flavorPanel.add(flavorButton);
		
		flavorButton =  new JButton("Vanilla, $20");
		flavorButton.setActionCommand("pick_flavor");
		flavorButton.addActionListener(this);
		flavorButtons.add(flavorButton);
		flavorPanel.add(flavorButton);

		//create the default decorator buttons 
		decoratorPanel.setLayout(new GridLayout(15,1));
		JButton decoratorButton =  new JButton("M&M, $5");
		decoratorButton.setActionCommand("pick_decorator");
		decoratorButton.addActionListener(this);
		decoratorButtons.add(decoratorButton);
		decoratorPanel.add(decoratorButton);
		
		decoratorButton =  new JButton("Strawberry, $4");
		decoratorButton.setActionCommand("pick_decorator");
		decoratorButton.addActionListener(this);
		decoratorButtons.add(decoratorButton);
		decoratorPanel.add(decoratorButton);
		
		
		//set up the info panel, set the text to right align
		infoPanel.setLayout(new BorderLayout());
	    StyleContext context = new StyleContext();
	    Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
	    StyleConstants.setAlignment(style, StyleConstants.ALIGN_RIGHT);
	    StyledDocument document_info = new DefaultStyledDocument(context);		
		infoPane = new JTextPane(document_info);
		infoPane.setEditable(false);
		infoPane.setAlignmentX(JEditorPane.RIGHT_ALIGNMENT);
		JScrollPane infoScroll = new JScrollPane(infoPane);
		infoPanel.add(infoScroll, BorderLayout.CENTER);
		
		JPanel totalPane = new JPanel();
		totalPane.setLayout(new BorderLayout());
		JLabel total_label = new JLabel("Total:");
		totalPane.add(total_label, BorderLayout.WEST);
	    StyledDocument document_total = new DefaultStyledDocument(context);
	    totalText = new JTextPane(document_total);
		totalPane.add(totalText, BorderLayout.CENTER);
		totalText.setEditable(false);
		infoPanel.add(totalPane, BorderLayout.SOUTH);
		
		
		//a big panel that goes to the center of the borderlayout, this panel contains the left, mid and right panel
		midPanel.add(flavorPanel);
		midPanel.add(decoratorPanel);
		midPanel.add(infoPanel);
		this.add(midPanel, BorderLayout.CENTER);

		//a top panel that goes to the top of the border layout, this panel hosts and menu bar
        JPanel topPanel =  new JPanel();
   		topPanel.setPreferredSize(new Dimension(800, 50));
   		topPanel.setLayout(new BorderLayout());
   		
   		//create the menu bar for the system administrator buttons 
   		JMenuBar menuBar = new JMenuBar();
   		JMenu menu = new JMenu("System Administration");
   		JMenuItem menuItemA = new JMenuItem("Add New Flavor");
   		JMenuItem menuItemB = new JMenuItem("Add New Decorator");
   		menuItemA.setActionCommand("add_flavor");
   		menuItemA.addActionListener(this);
   		menuItemB.setActionCommand("add_decorator");
   		menuItemB.addActionListener(this);
   		menu.add(menuItemA);
   		menu.add(menuItemB);
   		menuBar.add(menu);
   		topPanel.add(menuBar, BorderLayout.PAGE_START);
   		
   		//add a panel that displays some label
   		JPanel topLabelPanel = new JPanel();
   		topLabelPanel.setLayout(new GridLayout(1,3));
   		JLabel flavor_label = new JLabel("Ice-cream Flavor", JLabel.CENTER);
   		JLabel decorator_label = new JLabel("Decorator", JLabel.CENTER);
   		JLabel info_label = new JLabel("", JLabel.CENTER);
   		topLabelPanel.add(flavor_label);
   		topLabelPanel.add(decorator_label);
   		topLabelPanel.add(info_label);
   		topPanel.add(topLabelPanel, BorderLayout.PAGE_END);
   		
        this.add(topPanel, BorderLayout.PAGE_START);
        
        JPanel bottomPanel =  new JPanel();
        
        //add a new icecream button 
        JButton newButton = new JButton("New Icecream");
        newButton.setActionCommand("new_icecream");
        newButton.addActionListener(this);
        
        bottomPanel.add(newButton);
   		//topPanel.setPreferredSize(new Dimension(800, 600));
        this.add(bottomPanel, BorderLayout.PAGE_END);
  
    }
 
    /** Handle ActionEvents. */
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();
        
        // the actions for when clicking the new icecream button 
        if ("new_icecream".equals(cmd)) {
        	totalText.setText("");
        	infoPane.setText("");
        	//reset the flavor buttons the enable
        	for (int i = 0; i < flavorButtons.size(); i++) {
        		flavorButtons.get(i).setEnabled(true);
    		}
        	// new an icecream
        	 _icecream = new IceCream();
        }
        
        // the actions for when the user selects a flavor
        if ("pick_flavor".equals(cmd)) {
        	
        	//get the amount and flavor name from the button text
           	JButton sourceButton = (JButton)e.getSource();
           	String button_text = sourceButton.getText();
           	String[] tmpsplit= button_text.split(", ");
           	tmpsplit[1] = tmpsplit[1].replace("$", "");
        	Flavor f = new Flavor(tmpsplit[0], Double.parseDouble(tmpsplit[1]));
            
        	//set the icecream flavor
        	_icecream. setFlavor(f);

        	//set the initial cost total for the base icecream
        	totalText.setText(_icecream.getCost()+"");
        	
        	//update the information pane on the right
        	String tmpinfo = infoPane.getText();
        	if (!tmpinfo.equals("")) tmpinfo =tmpinfo +"\n";
        	
        	infoPane.setText(tmpinfo+_icecream.getDescription());
        	for (int i = 0; i < flavorButtons.size(); i++) {
        		flavorButtons.get(i).setEnabled(false);
    		}
        	
        	
        }
        //actions for selecting a decorator 
        if ("pick_decorator".equals(cmd)) {
        	//check and continue only if a flavor is selected 
        	Flavor f =  _icecream.getFlavor();
        	if (f == null) {
        		JOptionPane.showMessageDialog(jd,
            		    "Please select a flavor 1st.",
            		    "Select decorator error",
            		    JOptionPane.ERROR_MESSAGE);
        	}else{
    
        	//get the decorator and cost from button text 	
        	JButton sourceButton = (JButton)e.getSource();
           	String button_text = sourceButton.getText();
          	String[] tmpsplit= button_text.split(", ");
           	tmpsplit[1] = tmpsplit[1].replace("$", "");
           	
           	//new a decorator, passing the icecream, decorator text, and cost to its constructor 
           	GenericDecorator deco = new GenericDecorator(_icecream, tmpsplit[0], Double.parseDouble( tmpsplit[1]));
           //	_icecream = deco;
        	
            //update the total and other information
           	String tmpinfo = infoPane.getText();
        	if (!tmpinfo.equals("")) tmpinfo =tmpinfo +"\n";
        	infoPane.setText(tmpinfo+"with "+deco.getDescription()+ " + " +deco.getCost());
        	//infoPane.setText(deco.getDescription());
        	for (int i = 0; i < flavorButtons.size(); i++) {
        		flavorButtons.get(i).setEnabled(false);
    		}
        	
        	totalText.setText(_icecream.getCost()+"");
        	}
        }
        
        //the action for cancel the add dialog 
        if ("dialog_cancel".equals(cmd)) {
            jd.setVisible(false);
        }
        
        //the following code for displaying the add flavor and decorator has been combined, since more of the code are the same, a new action that combines the 2 is created 
     /*   
        if ("flavor_dialog_add".equals(cmd)) {
        	boolean continue_add = true;
        	String _price = textField2.getText().trim();
        	String _flavor_descr = textField1.getText().trim();
        	if ( _flavor_descr.trim().equals("")) {
        		JOptionPane.showMessageDialog(jd,
        		    "Flavor description cannot be blank.",
        		    "Flavor description error",
        		    JOptionPane.ERROR_MESSAGE);
        		continue_add = false;
        	}
        	if ( _price.trim().equals("")) {
        		JOptionPane.showMessageDialog(jd,
        			"Flavor price cannot be blank.",
        		    "Flavor price error",
        		    JOptionPane.ERROR_MESSAGE);
        		continue_add = false;
        	}
        
        		
        		 if   ((!_price.matches("-?\\d+(\\.\\d+)?")) &&(continue_add) ) {
            		 JOptionPane.showMessageDialog(jd,
                   		    "Flavor price must be numeric.",
                   		    "Flavor price error",
                   		    JOptionPane.ERROR_MESSAGE);
            		 continue_add = false;
        		 }
        		 if (continue_add ){
         
         		
        		JButton flavorButton =  new JButton(_flavor_descr+", $"+_price);
        		flavorButton.setActionCommand("pick_flavor");
        		flavorButton.addActionListener(this);
        		flavorButtons.add(flavorButton);
        		flavorPanel.add(flavorButton);
         		flavorPanel.validate();
                jd.setVisible(false);
        		 }
        }
        if ("decorator_dialog_add".equals(cmd)) {
        	boolean continue_add = true;
        	String _price = textField2.getText().trim();
        	String _flavor_descr = textField1.getText().trim();
        	if ( _flavor_descr.trim().equals("")) {
        		JOptionPane.showMessageDialog(jd,
        		    "Decorator description cannot be blank.",
        		    "Decorator description error",
        		    JOptionPane.ERROR_MESSAGE);
        		continue_add = false;
        	}
        	if ( _price.trim().equals("")) {
        		JOptionPane.showMessageDialog(jd,
        			"Decorator price cannot be blank.",
        		    "Decorator price error",
        		    JOptionPane.ERROR_MESSAGE);
        		continue_add = false;
        	}
        
        		
        		 if   ((!_price.matches("-?\\d+(\\.\\d+)?")) && (continue_add) ) {
            		 JOptionPane.showMessageDialog(jd,
                   		    "Decorator price must be numeric.",
                   		    "Decorator price error",
                   		    JOptionPane.ERROR_MESSAGE);
            		 continue_add = false;
        		 }
        		 if (continue_add ){
             		JButton decoratorButton =  new JButton(_flavor_descr+", $"+_price);
             		decoratorButton.setActionCommand("pick_decorator");
             		decoratorButton.addActionListener(this);
             		decoratorButtons.add(decoratorButton);
             		decoratorPanel.add(decoratorButton);
            		
        	
        			 decoratorPanel.validate();
                jd.setVisible(false);
        		 }
        }
        */
        
        //when the button event name is add_*
        //i.e., when users selects an Add * from the the system admin menu
        String tmpbreakcmdstring[] = cmd.split("_");
        if ((tmpbreakcmdstring[0].equals("add")) && (tmpbreakcmdstring.length == 2)) {
        	//build the dialog components for adding a flavor, decorator 
         	 textField1 = new JTextField(20);
        	 textField2 = new JTextField(20);
        	JButton dialog_ok = new JButton("Add");
        	JButton dialog_cancel = new JButton("Cancel");
        	
        	//set the event name for add
        	dialog_ok.setActionCommand(tmpbreakcmdstring[1]+"_dialog_add");
        	dialog_ok.addActionListener(this);
        	
        	//set the event name for cancel
        	dialog_cancel.setActionCommand("dialog_cancel");
        	dialog_cancel.addActionListener(this);
        	
        	Object[] array = {"Enter the name of the new "+ tmpbreakcmdstring[1],  textField1,"Enter the price of the new "+tmpbreakcmdstring[1],  textField2,dialog_ok,dialog_cancel};
        	Object[] diagbuttons ={};
        	JOptionPane jp = new JOptionPane(array, JOptionPane.QUESTION_MESSAGE,JOptionPane. DEFAULT_OPTION, null,diagbuttons);
        	jd = jp.createDialog(this, "Add A New "+tmpbreakcmdstring[1]);
        	
        	
            //show the dialog
        	jd.pack();
        	jd.setVisible(true);
        }
        
        //when the button event name is *_dialog_add
        //when user clicks the Add button on the add flavor/decorator dialog
        if ( (tmpbreakcmdstring.length == 3)  &&  (tmpbreakcmdstring[1].equals("dialog")) &&  (tmpbreakcmdstring[2].equals("add")) ) {
        	boolean continue_add = true;
        	String _price = textField2.getText().trim();
        	String _descr_to_add = textField1.getText().trim();
        	
        	//checks if user has input a description and cost
        	if ( _descr_to_add.trim().equals("")) {
        		JOptionPane.showMessageDialog(jd,
        		    "Description cannot be blank.",
        		    "Set Description error",
        		    JOptionPane.ERROR_MESSAGE);
        		continue_add = false;
        	}
        	if ( _price.trim().equals("")) {
        		JOptionPane.showMessageDialog(jd,
        			"Price cannot be blank.",
        		    "Set price error",
        		    JOptionPane.ERROR_MESSAGE);
        		continue_add = false;
        	}
        
        		//check if the cost does not contain non-numeric characters 
        		 if   ((!_price.matches("-?\\d+(\\.\\d+)?")) &&(continue_add) ) {
            		 JOptionPane.showMessageDialog(jd,
                   		    "Price must be numeric.",
                   		    "Set price error",
                   		    JOptionPane.ERROR_MESSAGE);
            		 continue_add = false;
        		 }
        		 if (continue_add ){
         
         		//add and new button to the relevant button panel, set the label
        		JButton tmpButton =  new JButton(_descr_to_add+", $"+_price);
        		tmpButton.setActionCommand("pick_"+tmpbreakcmdstring[0]);
        		tmpButton.addActionListener(this);
        		switch (tmpbreakcmdstring[0]) {
        		case "flavor":

            		flavorButtons.add(tmpButton);
            		flavorPanel.add(tmpButton);
            		if 	(!flavorButtons.get(0).isEnabled()) {
            			flavorButtons.get(flavorButtons.size()-1).setEnabled(false);
            		}
             		flavorPanel.validate();
        			break;
        		case "decorator":
             		decoratorButtons.add(tmpButton);
             		decoratorPanel.add(tmpButton);
            	    decoratorPanel.validate();
        			break;
        		}

                jd.setVisible(false);
        		 }
        }
        //the following actions for when clicking the add flavor or add decorator button on the dialog have been combine into 1 action to avoid duplicate codes 
     /*   
        if ("add_flavor".equals(cmd)) {
        	 textField1 = new JTextField(10);
        	 textField2 = new JTextField(10);
        	JButton dialog_ok = new JButton("Add");
        	JButton dialog_cancel = new JButton("Cancel");
        	
        	dialog_ok.setActionCommand("flavor_dialog_add");
        	dialog_ok.addActionListener(this);
            
        	dialog_cancel.setActionCommand("dialog_cancel");
        	dialog_cancel.addActionListener(this);
        	
        	Object[] array = {"Enter the name of the new flavor",  textField1,"Enter the price of the new flavor",  textField2,dialog_ok,dialog_cancel};
        	Object[] diagbuttons ={};
        	JOptionPane jp = new JOptionPane(array, JOptionPane.QUESTION_MESSAGE,JOptionPane. DEFAULT_OPTION, null,diagbuttons);
        	jd = jp.createDialog(this, "Add A New Flavor");
        	
        	
     
        	jd.pack();
        	jd.setVisible(true);
        	
 

        }


        if ("add_decorator".equals(cmd)) {
       	 textField1 = new JTextField(10);
       	 textField2 = new JTextField(10);
       	JButton dialog_ok = new JButton("Add");
       	JButton dialog_cancel = new JButton("Cancel");
       	
       	dialog_ok.setActionCommand("decorator_dialog_add");
       	dialog_ok.addActionListener(this);
           
       	dialog_cancel.setActionCommand("dialog_cancel");
       	dialog_cancel.addActionListener(this);
       	
       	Object[] array = {"Enter the name of the new decorator",  textField1,"Enter the price of the new decorator",  textField2,dialog_ok,dialog_cancel};
       	Object[] diagbuttons ={};
       	JOptionPane jp = new JOptionPane(array, JOptionPane.QUESTION_MESSAGE,JOptionPane. DEFAULT_OPTION, null,diagbuttons);
       	jd = jp.createDialog(this, "Add A New Decorator");
       	
       	
    
       	jd.pack();
       	jd.setVisible(true);
       	


       }
       */
    }
    
    
    public static void main(String[] args) {

        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

            	JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new PoSSystem());
                frame.setTitle("Natalie's Icecream Sale system");
                //Display the window.
                frame.pack();
                frame.setVisible(true);
            }
        });
        
        
        
     
    }
}