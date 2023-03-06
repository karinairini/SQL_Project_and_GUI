package ColocviuFinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

public class Pagina7 implements ActionListener{
	
	JPanel panel = new JPanel();
	JFrame frame;
	JTable table;
	JButton returnBtn = new JButton("REVENIRE");

	Color colorFundal = new Color(173, 184, 235);
	Color colorRowsTable = new Color(255, 240, 245);
	Color colorHeader = new Color(243, 156, 18);
	Color colorX = new Color(210, 43, 43);
	Color colorCerinta = new Color(218, 240, 227);
	
	JPanel cerintaPanel = new JPanel(new BorderLayout());
	JPanel cerintaPanel1 = new JPanel(new BorderLayout());
	JPanel cerintaPanel2 = new JPanel(new BorderLayout());
	
	JLabel label1 = new JLabel("               Găsiți timpul de preparare minim, mediu și maxim");
	JLabel label2 = new JLabel("                            pentru fiecare categorie de rețetă.");
	 	
	Border border = BorderFactory.createLineBorder(Color.BLACK);
	Border border1 = BorderFactory.createLineBorder(colorFundal);
	
    Pagina7(Vector data, Vector columnNames)
    {
    	frame = new JFrame();
	    frame.setTitle("Rezultat interogare 7");
	    frame.setSize(650, 450);
	    frame.setResizable(false);
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) /2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight() - 10) /2);
	    frame.setLocation(x, y);
	    
	    table = new JTable(data, columnNames){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
	    table.setBounds(0, 10, 630, 307);
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
	    
	    cerintaPanel.setBounds(5, 230, 625, 70);
	    cerintaPanel.setBorder(border);
	    cerintaPanel.setBackground(colorCerinta);
	
	    cerintaPanel1.setBounds(5, 230, 625, 35);
	    cerintaPanel1.setBackground(colorCerinta);

	    cerintaPanel2.setBounds(5, 265, 625, 35);
	    cerintaPanel2.setBackground(colorCerinta);
	    
	    label1.setBounds(0, 50, 450, 35);
	    label1.setBackground(colorCerinta);
	    label1.setFont(new Font("TAHOMA", Font.BOLD, 17));
	    label1.setForeground(Color.BLACK);
	    
	    label2.setBounds(0, 85, 450, 35);
	    label1.setBackground(colorCerinta);
	    label2.setFont(new Font("TAHOMA", Font.BOLD, 17));
	    label2.setForeground(Color.BLACK);
	    
	    cerintaPanel1.add(label1);
	    cerintaPanel2.add(label2);
	    cerintaPanel.add(cerintaPanel1, BorderLayout.CENTER);
	    cerintaPanel.add(cerintaPanel2, BorderLayout.CENTER);
	    BoxLayout b = new BoxLayout(cerintaPanel, BoxLayout.Y_AXIS);
	    cerintaPanel.setLayout(b);
	    frame.add(cerintaPanel);
		
		returnBtn.setBounds(490, 370, 140, 40);
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
		sp.setBounds(10,10,580,300);
		sp.setPreferredSize(new Dimension(630, 307));
		panel.add(sp);
		panel.setBackground(colorFundal);
		
	    frame.add(panel);
	    frame.setVisible(true);
    }


	 public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == returnBtn)
		 {
			 frame.setVisible(false);
			 Meniu meniu = new Meniu();
		 }
	 }

}

