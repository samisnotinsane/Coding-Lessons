import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class BasicComponents extends JFrame {
	public static void main(String[] args) {
		new BasicComponents();
	}

	public BasicComponents() { 
		this.setSize(400,400);

		Toolkit tk = Toolkit.getDefaultToolkit();

		Dimension dim = tk.getScreenSize();

		int xPos = (dim.width/2) - (this.getWidth() / 2);
		int yPos = (dim.height/2) - (this.getHeight() / 2);

		this.setPosition(xPos, yPos);
		//this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}