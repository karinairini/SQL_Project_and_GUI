package ColocviuFinal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Rezultat2 implements ActionListener{
	
	JPanel panel = new JPanel();
	JFrame frame;
	JTable table;
	JButton returnBtn = new JButton("REVENIRE");

	Color colorFundal = new Color(173, 184, 235);
	Color colorRowsTable = new Color(255, 240, 245);
	Color colorHeader = new Color(243, 156, 18);
	Color colorX = new Color(210, 43, 43);
	 	
	Border border = BorderFactory.createLineBorder(Color.BLACK);
	Border border1 = BorderFactory.createLineBorder(colorFundal);
	
    Rezultat2(Vector data, Vector columnNames, String count)
    {
    	frame = new JFrame();
	    frame.setTitle("Rezultat interogare 2");
	    frame.setSize(600, 400);
	    frame.setResizable(false);
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) /2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight() - 10) /2);
	    frame.setLocation(x, y);
	    
	    JLabel label = new JLabel();
	    label.setForeground(Color.BLACK);
	    label.setFont(new Font("Calibri", Font.BOLD, 18));
	    label.setBackground(colorFundal);
	    label.setBorder(null);
	    label.setBounds(10, 320, 400, 30);
	    if(Integer.parseInt(count) == 1)
	    	label.setText("S-a găsit " + count + " ingredient cu a doua literă introdusă.");
	    else
	    	label.setText("S-au găsit " + count + " ingrediente cu a doua literă introdusă.");
	    frame.add(label);
	    
	    table = new JTable(data, columnNames){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
	    table.setBounds(0, 0, 580, 300);
	    table.setBackground(colorRowsTable);
	    table.setForeground(Color.BLACK);
	    table.setFont(new Font("Calibri", Font.BOLD, 18));
	    table.setBorder(border);
	    table.setRowHeight(25);
	    table.setIntercellSpacing(new Dimension(0, 0));
	    table.setGridColor(Color.BLACK);
	    table.getTableHeader().setBackground(colorHeader);
	    table.getTableHeader().setFont(new Font("TimesNewRoman", Font.BOLD, 20));
	    table.getTableHeader().setForeground(Color.BLACK);
	    table.setCellSelectionEnabled(true);
		
		returnBtn.setBounds(440, 320, 140, 40);
		returnBtn.setBorder(border); 
		returnBtn.setBackground(Color.white);
		returnBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		returnBtn.setForeground(Color.black);
		returnBtn.setFocusable(false);
		returnBtn.addActionListener(this);
		frame.add(returnBtn);
		
		JScrollPane sp = new JScrollPane(table);
		sp.setBackground(colorFundal);
		sp.getViewport().setBackground(colorFundal);
		sp.setBorder(border1);
		sp.setBounds(10, 0, 580, 300);
		sp.setPreferredSize(new Dimension(580, 300));
		panel.add(sp);
		panel.setBackground(colorFundal);
		
	    frame.add(panel);
	    frame.setVisible(true);
    }
	
	 public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == returnBtn)
		 {
			 frame.setVisible(false);
			 Pagina2 pagina2 = new Pagina2();
		 }
	 }
	 

}
