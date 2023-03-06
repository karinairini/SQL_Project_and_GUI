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

public class Rezultat6 implements ActionListener{
	
	JPanel panel = new JPanel();
	JFrame frame;
	JTable table;
	JButton returnBtn = new JButton("REVENIRE");

	Color colorFundal = new Color(173, 184, 235);
	Color colorRowsTable = new Color(255, 240, 245);
	Color colorHeaderTable = new Color(243, 156, 18);
	
	JLabel autor = new JLabel("Autor: ");
	JLabel nume = new JLabel("Nume: ");
	JLabel timp = new JLabel("Timp de preparare: ");
	JLabel portii = new JLabel("Număr de porții: ");
	
	JTextField autorField = new JTextField();
	JTextField numeField = new JTextField();
	JTextField timpField = new JTextField();
	JTextField portiiField = new JTextField();

	JLabel labelUtiliz = new JLabel("Selectați o rețetă pentru a-i vedea detaliile");
	 	
	Border border = BorderFactory.createLineBorder(Color.BLACK);
	Border border1 = BorderFactory.createLineBorder(colorFundal);
	ListSelectionModel model;
	
	Rezultat6(Vector data, Vector columnNames)
	{
		frame = new JFrame();
	    frame.setTitle("Rezultat interogare 6");
	    frame.setSize(850, 590);
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
	    table.setBounds(0, 0, 800, 257);
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
	    
	    labelUtiliz.setBounds(10, 320, 450, 20);
	    labelUtiliz.setBackground(colorFundal);
	    labelUtiliz.setFont(new Font("TAHOMA", Font.BOLD, 18));
	    labelUtiliz.setForeground(Color.BLACK);
	    frame.add(labelUtiliz);
		
	    autor.setBounds(10, 345, 150, 30);
	    autor.setFont(new Font("Tahoma", Font.BOLD, 15));
	    autor.setForeground(Color.BLACK);
	    autor.setBackground(colorFundal);
		frame.add(autor);
		
		autorField.setBounds(165, 345, 200, 30);
		autorField.setFont(new Font("Tahoma", Font.BOLD, 15));
		autorField.setForeground(Color.BLACK);
		autorField.setBackground(colorFundal);
		autorField.setBorder(border1);
		autorField.setFocusable(false);
		frame.add(autorField);
		
		nume.setBounds(10, 375, 150, 30);
		nume.setFont(new Font("Tahoma", Font.BOLD, 15));
		nume.setForeground(Color.BLACK);
		nume.setBackground(colorFundal);
		frame.add(nume);
		
		numeField.setBounds(165, 375, 200, 30);
		numeField.setFont(new Font("Tahoma", Font.BOLD, 15));
		numeField.setForeground(Color.BLACK);
		numeField.setBackground(colorFundal);
		numeField.setBorder(border1);
		numeField.setFocusable(false);
		frame.add(numeField);
		
		timp.setBounds(10, 405, 180, 30);
		timp.setFont(new Font("Tahoma", Font.BOLD, 15));
		timp.setForeground(Color.BLACK);
		timp.setBackground(colorFundal);
		frame.add(timp);
		
		timpField.setBounds(165, 405, 100, 30);
		timpField.setFont(new Font("Tahoma", Font.BOLD, 15));
		timpField.setForeground(Color.BLACK);
		timpField.setBackground(colorFundal);
		timpField.setBorder(border1);
		timpField.setFocusable(false);
		frame.add(timpField);
		
		portii.setBounds(10, 435, 180, 30);
		portii.setFont(new Font("Tahoma", Font.BOLD, 15));
		portii.setForeground(Color.BLACK);
		portii.setBackground(colorFundal);
		frame.add(portii);
		
		portiiField.setBounds(165, 435, 30, 30);
		portiiField.setFont(new Font("Tahoma", Font.BOLD, 15));
		portiiField.setForeground(Color.BLACK);
		portiiField.setBackground(colorFundal);
		portiiField.setBorder(border1);
		portiiField.setFocusable(false);
		frame.add(portiiField);
		
		returnBtn.setBounds(5, 512, 140, 40);
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
		sp.setPreferredSize(new Dimension(800, 307));
		panel.add(sp);
		panel.setBackground(colorFundal);
		
	    frame.add(panel);
	    frame.setVisible(true);
	    
	    model = table.getSelectionModel();
	    model.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				if(!model.isSelectionEmpty())
				{
					 int column = 3;
					 int row = table.getSelectedRow();
					 String value = table.getModel().getValueAt(row, column).toString();
					 autorField.setText(value);
					 column = 1;
					 value = table.getModel().getValueAt(row, column).toString();
					 timpField.setText(value + " minute");
					 column = 2;
					 value = table.getModel().getValueAt(row, column).toString();
					 portiiField.setText(value);
					 column = 0;
					 value = table.getModel().getValueAt(row, column).toString();
					 numeField.setText(value);
				}
			}
	    });
	}

	 public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == returnBtn)
		 {
			 frame.setVisible(false);
			 Pagina6 pagina6 = new Pagina6();
		 }
	 }
	 

}
