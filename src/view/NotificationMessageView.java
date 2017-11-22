package view;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class NotificationMessageView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4537906728418354979L;
	private JLabel label;

	public NotificationMessageView (String pMessage, int color){
		this.setLayout(null);
		label = new JLabel(pMessage);
		label.setBounds(10, 10, 555, 30);		
		if (color == 1) {
			this.setBackground(new Color(130, 255, 130));
			this.label.setForeground(new Color(100, 162, 100));			
		}
		else {
			this.setBackground(new Color(255, 92, 92));
			this.label.setForeground(new Color(255, 25, 25));
		}
		add(label);
		
		Timer timer = new Timer(); 
		timer.schedule(new TimerTask() {			
			@Override
			public void run() {
				//label.setVisible(false);
				timer.cancel();
			}
		}, 0, 5000);
	}
}
