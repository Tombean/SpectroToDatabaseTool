package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.FileExtractor;

public class SpectroPanel extends JFrame implements ActionListener{
	
	private JPanel panel = new JPanel();
	  private JButton defaultFileBouton = new JButton("Use Default File");
	  private JButton pickFileBouton = new JButton("Find a new file");
	  
	  public SpectroPanel(){
	    this.setTitle("Spectro To Database Tool");
	    this.setSize(300, 75);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    defaultFileBouton.addActionListener(this);
	    pickFileBouton.addActionListener(this);
	    panel.add(defaultFileBouton);
	    panel.add(pickFileBouton);
	    this.setContentPane(panel);
	    this.setVisible(true);
	  }
//change jj
	  
	@Override
	public void actionPerformed(ActionEvent arg0) {
		boolean newFile=false;

		FileExtractor action;
		if(arg0.getSource() == pickFileBouton){
			newFile = true;
		}

		  if(arg0.getSource() == defaultFileBouton){
			  newFile = false;
		  }
		FileExtractor extract = new FileExtractor(newFile);
		extract.readFile();
		
		
	}


}