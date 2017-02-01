import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GridPanel extends JPanel{
	ArrayList<JLabel> squares = new ArrayList<JLabel>();
	/* 
	 * -------------
	 * | 0 | 1 | 2 |    
	 * -------------
	 * | 3 | 4 | 5 |
	 * -------------
	 * | 6 | 7 | 8 |
	 * -------------
	 */
	
	GridPanel(){
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		this.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.BLACK));
		
		c.gridheight = 1;
		c.gridwidth  = 1;
		c.weightx	 = 1;
		c.weighty	 = 1;
		c.anchor     = GridBagConstraints.CENTER;
		
		JLabel num_0 = new JLabel();
		c.gridx = 0; c.gridy = 0;
		this.add(num_0, c);
		
		JLabel num_1 = new JLabel();
		c.gridx = 1; c.gridy = 0;
		this.add(num_1, c);
		
		JLabel num_2 = new JLabel();
		c.gridx = 2; c.gridy = 0;
		this.add(num_2, c);
		
		JLabel num_3 = new JLabel();
		c.gridx = 0; c.gridy = 1;
		this.add(num_3, c);
		
		JLabel num_4 = new JLabel();
		c.gridx = 1; c.gridy = 1;
		this.add(num_4, c);
		
		JLabel num_5 = new JLabel();
		c.gridx = 2; c.gridy = 1;
		this.add(num_5, c);
		
		JLabel num_6 = new JLabel();
		c.gridx = 0; c.gridy = 2;
		this.add(num_6, c);
		
		JLabel num_7 = new JLabel();
		c.gridx = 1; c.gridy = 2;
		this.add(num_7, c);
		
		JLabel num_8 = new JLabel();
		c.gridx = 2; c.gridy = 2;
		this.add(num_8, c);
		
		
		squares.add(num_0);
		squares.add(num_1);
		squares.add(num_2);
		squares.add(num_3);
		squares.add(num_4);
		squares.add(num_5);
		squares.add(num_6);
		squares.add(num_7);
		squares.add(num_8);
		setVisible(true);
	}
	public void updateGrid(int[] state){
		for (int i=0; i<9; i++){
			if(state[i] == 0){
				squares.get(i).setText("");
			} else {
				squares.get(i).setText(String.valueOf(state[i]));
			}
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		Line2D l1 = new Line2D.Float(this.getWidth()/3,    0, 					  this.getWidth()/3, 	this.getHeight());
		Line2D l2 = new Line2D.Float(this.getWidth()*2/3,  0, 					  this.getWidth()*2/3, 	this.getHeight());
		Line2D l3 = new Line2D.Float(0, 				   this.getHeight()/3, 	  this.getWidth(), 		this.getHeight()/3);
		Line2D l4 = new Line2D.Float(0,                    this.getHeight()*2/3,  this.getWidth(), 		this.getHeight()*2/3);
		g2.draw(l1);
		g2.draw(l2);
		g2.draw(l3);
		g2.draw(l4);
	}
}
