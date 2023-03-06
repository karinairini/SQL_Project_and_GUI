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

public class Rezultat3 implements ActionListener{
	
	JPanel panel = new JPanel();
	JFrame frame;
	JTable table;
	JButton returnBtn = new JButton("REVENIRE");

	Color colorFundal = new Color(173, 184, 235);
	Color colorRowsTable = new Color(255, 240, 245);
	Color colorHeaderTable = new Color(243, 156, 18);
	
	JLabel nume = new JLabel("Nume: ");
	JLabel categorie = new JLabel("Categorie: ");
	JLabel descriere = new JLabel("Descriere: ");
	
	JTextField numeField = new JTextField();
	JTextField categorieField = new JTextField();
	
	JTextArea descriereText = new JTextArea();
	JLabel labelUtiliz = new JLabel("Selectați o rețetă pentru a-i vedea detaliile");
	 	
	Border border = BorderFactory.createLineBorder(Color.BLACK);
	Border border1 = BorderFactory.createLineBorder(colorFundal);
	ListSelectionModel model;
	
	Rezultat3(Vector data, Vector columnNames)
	{
		frame = new JFrame();
	    frame.setTitle("Rezultat interogare 3");
	    frame.setSize(850, 640);
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
	    table.setBounds(0, 0, 800, 250);
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
	    
	    labelUtiliz.setBounds(20, 280, 450, 20);
	    labelUtiliz.setBackground(colorFundal);
	    labelUtiliz.setFont(new Font("TAHOMA", Font.BOLD, 18));
	    labelUtiliz.setForeground(Color.BLACK);
	    frame.add(labelUtiliz);
		
		nume.setBounds(20, 310, 150, 30);
		nume.setFont(new Font("Tahoma", Font.BOLD, 15));
		nume.setForeground(Color.BLACK);
		nume.setBackground(colorFundal);
		frame.add(nume);
		
		numeField.setBounds(165, 310, 200, 30);
		numeField.setFont(new Font("Tahoma", Font.BOLD, 15));
		numeField.setForeground(Color.BLACK);
		numeField.setBackground(colorFundal);
		numeField.setBorder(border1);
		numeField.setFocusable(false);
		frame.add(numeField);
		
		categorie.setBounds(20, 345, 180, 30);
		categorie.setFont(new Font("Tahoma", Font.BOLD, 15));
		categorie.setForeground(Color.BLACK);
		categorie.setBackground(colorFundal);
		frame.add(categorie);
		
		categorieField.setBounds(165, 345, 100, 30);
		categorieField.setFont(new Font("Tahoma", Font.BOLD, 15));
		categorieField.setForeground(Color.BLACK);
		categorieField.setBackground(colorFundal);
		categorieField.setBorder(border1);
		categorieField.setFocusable(false);
		frame.add(categorieField);
		
		descriere.setBounds(20, 380, 150, 30);
		descriere.setFont(new Font("Tahoma", Font.BOLD, 15));
		descriere.setForeground(Color.BLACK);
		descriere.setBackground(colorFundal);
		frame.add(descriere);
		
		descriereText.setBounds(165, 380, 650, 200);
		descriereText.setBorder(border1);
		descriereText.setWrapStyleWord(true);
		descriereText.setLineWrap(true);
		descriereText.setBackground(colorFundal);
		descriereText.setDragEnabled(true);
		descriereText.setFont(new Font("Tahoma", Font.BOLD, 15));
		descriereText.setForeground(Color.BLACK);
		frame.add(descriereText);
		
		returnBtn.setBounds(5, 562, 140, 40);
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
		sp.setPreferredSize(new Dimension(800, 257));
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
					 categorieField.setText(value);
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
			 Pagina3 pagina3 = new Pagina3();
		 }
	 }
	 

}
