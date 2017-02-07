import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class Gui extends JFrame{
		private Solver solv;
		private JPanel contentPane;
		private Node displayedNode;
		
		//contents
		private GridPanel 	 puzzlePanel		= new GridPanel();
		private JRadioButton dfsButton 			= new JRadioButton("Depth-First Search");
		private JRadioButton bfsButton 			= new JRadioButton("Breadth-First Search");
		private JRadioButton aStarOneButton 	= new JRadioButton("A*1 Search");
		private JRadioButton aStarTwoButton 	= new JRadioButton("A*2 Search");
		private JRadioButton aStarThreeButton 	= new JRadioButton("A*3 Search");
		private JButton 	 resetButton 		= new JButton("Reset");
		private JButton 	 goButton 			= new JButton("Go");
	
	public Gui(Solver s){
		solv = s;
		setResizable(false);
		setSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel(new GridBagLayout());
		setContentPane(contentPane);
		GridBagConstraints c = new GridBagConstraints();
		
		displayedNode = solv.createRandomNode(); //initial random node
		
		//display panel
		c.gridx      = 0;
		c.gridy      = 0;
		c.gridheight = 7;
		c.gridwidth  = 1;
		c.weightx    = 1;
		c.weighty    = 1;
		c.fill       = 1;
		contentPane.add(puzzlePanel, c);
				
		//radio buttons - search type options
		ButtonGroup searchType = new ButtonGroup();
		
		//bfs button
		bfsButton.setSelected(true);
		c.gridx      = 1;
		c.gridy      = 0;
		c.gridheight = 1;
		c.gridwidth  = 1;
		c.weightx    = 0;
		c.weighty    = 0.2;
		c.fill       = 0;
		c.anchor 	 = GridBagConstraints.WEST;
		searchType.add(bfsButton);
		contentPane.add(bfsButton, c);
				
		//dfs button
		c.gridx      = 1;
		c.gridy      = 1;
		c.gridheight = 1;
		c.gridwidth  = 1;
		c.weightx    = 0;
		c.weighty    = 0.2;
		c.fill       = 0;
		c.anchor 	 = GridBagConstraints.WEST;
		searchType.add(dfsButton);
		contentPane.add(dfsButton, c);
		
		
		
		//A*1 button
		c.gridx      = 1;
		c.gridy      = 2;
		c.gridheight = 1;
		c.gridwidth  = 1;
		c.weightx    = 0;
		c.weighty    = 0.2;
		c.fill       = 0;
		c.anchor 	 = GridBagConstraints.WEST;
		searchType.add(aStarOneButton);
		contentPane.add(aStarOneButton, c);
		
		//A*2 button
		c.gridx      = 1;
		c.gridy      = 3;
		c.gridheight = 1;
		c.gridwidth  = 1;
		c.weightx    = 0;
		c.weighty    = 0.2;
		c.fill       = 0;
		c.anchor 	 = GridBagConstraints.WEST;
		searchType.add(aStarTwoButton);
		contentPane.add(aStarTwoButton, c);
		
		//A*3 button
		c.gridx      = 1;
		c.gridy      = 4;
		c.gridheight = 1;
		c.gridwidth  = 1;
		c.weightx    = 0;
		c.weighty    = 0.2;
		c.fill       = 0;
		c.anchor 	 = GridBagConstraints.WEST;
		searchType.add(aStarThreeButton);
		contentPane.add(aStarThreeButton, c);
		
		//Reset button
		resetButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){	resetButtonHandler();}	
		});
		c.gridx      = 1;
		c.gridy      = 5;
		c.gridheight = 1;
		c.gridwidth  = 1;
		c.weightx    = 0;
		c.weighty    = 0.5;
		c.fill       = 2;
		c.anchor     = GridBagConstraints.SOUTH;
		contentPane.add(resetButton, c);
		
		
		//GO! button
		goButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){	goButtonHandler();}	
		});
		c.gridx      = 1;
		c.gridy      = 6;
		c.gridheight = 1;
		c.gridwidth  = 1;
		c.weightx    = 0;
		c.weighty    = 0.5;
		c.fill       = 2;
		c.anchor     = GridBagConstraints.CENTER;
		contentPane.add(goButton, c);
		
		update();
		setVisible(true);
	}
	private void resetButtonHandler(){
		displayedNode = solv.createRandomNode();
		update();
	}
	
	private void goButtonHandler(){
		
		//select search method
		if(dfsButton.isSelected()){
			displayedNode = solv.solveDFS(displayedNode);
		} else if(bfsButton.isSelected()) {
			displayedNode = solv.solveBFS(displayedNode);
		} else if(aStarOneButton.isSelected()) {
			displayedNode = solv.solveAStarOne(displayedNode);
		} else if(aStarTwoButton.isSelected()) {
			
		} else if(aStarThreeButton.isSelected()) {
			
		}
		
		//print path if successful
		if (!displayedNode.getPath().isEmpty()){ //if it didnt fail, print path to console
			for(int i=0; i<displayedNode.getPath().size(); i++){
				System.out.print((i)+": ");
				for (int j=0; j<9; j++){
					System.out.print(displayedNode.getPath().get(i)[j]+" ");
				}
				System.out.print("\n");
			}
			System.out.println("depth: " + displayedNode.getDepth());
		}
		update();
	}
	
	private void update(){
		puzzlePanel.updateGrid(displayedNode.getState());
		
	}
	
	
	
};
