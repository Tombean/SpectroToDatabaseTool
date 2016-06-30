package View;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Bouton extends JButton implements MouseListener{
  private String name;
  public Bouton(String str){
    super(str);
    this.name = str;
    
    this.addMouseListener(this);
  }

  
  public void mouseClicked(MouseEvent event) { System.out.println("Bouton "+this.name+" clicked"); }

@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent arg0) {
	
	System.out.println("Bouton "+this.name+" clicked");
	
}

public String getName(){
	return this.name;
}
}