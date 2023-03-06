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
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Rezultat5 implements ActionListener{
	
	JPanel panel = new JPanel();
	JFrame frame;
	JTable table;
	JButton returnBtn = new JButton("REVENIRE");

	Color colorFundal = new Color(173, 184, 235);
	Color colorRowsTable = new Color(255, 240, 245);
	Color colorHeaderTable = new Color(243, 156, 18);
	
	JLabel nume = new JLabel("Nume: ");
	JLabel timp = new JLabel("Timp de preparare: ");
	JLabel descriere = new JLabel("Descriere: ");
	
	JTextField numeField = new JTextField();
	JTextField timpField = new JTextField();

	JTextArea descriereText = new JTextArea();
	JLabel labelUtiliz = new JLabel("Selectați rețeta pentru a-i vedea detaliile");
	 	
	Border border = BorderFactory.createLineBorder(Color.BLACK);
	Border border1 = BorderFactory.createLineBorder(colorFundal);
	ListSelectionModel model;
	
	Rezultat5(Vector data, Vector columnNames)
	{
		frame = new JFrame();
	    frame.setTitle("Rezultat interogare 5");
	    frame.setSize(750, 500);
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
	    table.setBounds(0, 0, 700, 150);
	    table.setBackground(colorRowsTable);
	    table.setForeground(Color.BLACK);
	    table.setFont(new Font("Calibri", Font.BOLD, 18));
	    table.setBorder(border);
	    table.setRowHeight(25);
	    table.setIntercellSpacing(new Dimension(0, 0));
	    table.setGridColor(Color.BLACK);
	    table.getTableHeader().setBackground(colorHeaderTable);
	    table.getTableHeader().setFont(new Font("TimesNewRoman", Font.BOLD, 20));
	    table.getTableHeader().setForeground(Color.BLACK);
	    table.setCellSelectionEnabled(true);
	    
	    labelUtiliz.setBounds(10, 110, 450, 20);
	    labelUtiliz.setBackground(colorFundal);
	    labelUtiliz.setFont(new Font("TAHOMA", Font.BOLD, 18));
	    labelUtiliz.setForeground(Color.BLACK);
	    frame.add(labelUtiliz);
		
		nume.setBounds(10, 135, 150, 30);
		nume.setFont(new Font("Tahoma", Font.BOLD, 15));
		nume.setForeground(Color.BLACK);
		nume.setBackground(colorFundal);
		frame.add(nume);
		
		numeField.setBounds(165, 135, 200, 30);
		numeField.setFont(new Font("Tahoma", Font.BOLD, 15));
		numeField.setForeground(Color.BLACK);
		numeField.setBackground(colorFundal);
		numeField.setBorder(border1);
		numeField.setFocusable(false);
		frame.add(numeField);
		
		timp.setBounds(10, 165, 180, 30);
		timp.setFont(new Font("Tahoma", Font.BOLD, 15));
		timp.setForeground(Color.BLACK);
		timp.setBackground(colorFundal);
		frame.add(timp);
		
		timpField.setBounds(165, 165, 100, 30);
		timpField.setFont(new Font("Tahoma", Font.BOLD, 15));
		timpField.setForeground(Color.BLACK);
		timpField.setBackground(colorFundal);
		timpField.setBorder(border1);
		timpField.setFocusable(false);
		frame.add(timpField);
		
		descriere.setBounds(10, 195, 150, 30);
		descriere.setFont(new Font("Tahoma", Font.BOLD, 15));
		descriere.setForeground(Color.BLACK);
		descriere.setBackground(colorFundal);
		frame.add(descriere);
		
		descriereText.setBounds(165, 195, 550, 280);
		descriereText.setBorder(border1);
		descriereText.setWrapStyleWord(true);
		descriereText.setLineWrap(true);
		descriereText.setBackground(colorFundal);
		descriereText.setDragEnabled(true);
		descriereText.setFont(new Font("Tahoma", Font.BOLD, 15));
		descriereText.setForeground(Color.BLACK);
		frame.add(descriereText);
		
		returnBtn.setBounds(5, 422, 140, 40);
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
		sp.setPreferredSize(new Dimension(700, 150));
		panel.add(sp);
		panel.setBackground(colorFundal);
		
	    frame.add(panel);
	    frame.setVisible(true);
	    
	    model = table.getSelectionModel();
	    model.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				if(!model.isSelectionEmpty())
				{
					 int column = 0;
					 int row = table.getSelectedRow();
					 String value = table.getModel().getValueAt(row, column).toString();
					 numeField.setText(value);
					 column = 2;
					 value = table.getModel().getValueAt(row, column).toString();
					 timpField.setText(value + " minute");
					 column = 1;
					 value = table.getModel().getValueAt(row, column).toString();
					 descriereText.setText(value);
				}
			}
	    });
	}

	 public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == returnBtn)
		 {
			 frame.setVisible(false);
			 Pagina5 pagina5 = new Pagina5();
		 }
	 }
	 

}
