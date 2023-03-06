package ColocviuFinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;

import com.mysql.cj.jdbc.result.ResultSetMetaData;


public class Pagina6 extends JFrame implements ActionListener{
	
	JPanel panel = new JPanel();
	JLabel labelUtiliz = new JLabel("Selectați numele rețetei dorite: ");
	JTextField litera = new JTextField();
	Border border = BorderFactory.createLineBorder(Color.gray);
	JButton afisareBtn = new JButton("CAUTĂ");
	JButton close = new JButton("X");
	
	JComboBox categorieComboBox = new JComboBox();
	Connection connection = null;
	Statement selectStatement = null;
	ResultSet resultSet = null;
	
	JPanel panelBara = new JPanel();
	JLabel titluBara = new JLabel("INTEROGARE 6");

	JLabel label1 = new JLabel("       Găsiți detaliile rețetelor care folosesc cel puțin un");
	JLabel label2 = new JLabel("          ingredient folosit la rețeta cu numele selectat.");
	
	JPanel cerintaPanel = new JPanel(new BorderLayout());
	JPanel cerintaPanel1 = new JPanel(new BorderLayout());
	JPanel cerintaPanel2 = new JPanel(new BorderLayout());
	
	Border border1 = BorderFactory.createLineBorder(Color.white);
	Border border2 = BorderFactory.createLineBorder(Color.black);
	
    Color colorFundal = new Color(173, 184, 235); 
    Color colorCerinta = new Color(218, 240, 227);
	Color colorX = new Color(210, 43, 43);
    
	public Pagina6()
	{
		this.setUndecorated(true); 
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		this.setSize(600, 400);
		this.setResizable(false);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
	    
	    panelBara.setBounds(0, 0, 550, 30);
	    panelBara.setBackground(Color.white);
	    titluBara.setBounds(0, 0, 30, 30);
	    titluBara.setFont(new Font("TAHOMA", Font.BOLD, 20));
	    titluBara.setForeground(Color.BLACK);
	    titluBara.setFocusable(false);
	    panelBara.add(titluBara);
	    panel.add(panelBara);
	    
	    try
	    {
	    	connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bucatarie_retete?user=root&password=GTXEN5RYYZFXXTCN&serverTimezone=UTC");
			selectStatement = connection.createStatement();
			selectStatement.execute("SELECT nume FROM Reteta ORDER BY nume;");
			resultSet = selectStatement.getResultSet();
			while(resultSet.next())
			{
				categorieComboBox.addItem(resultSet.getString(1));
			}
	    }
	    catch(Exception e)
	    {
	    	JOptionPane.showMessageDialog(null, "ERROR");
	    }
	    finally
	    {
	    	try
	    	{
	    		selectStatement.close();
	    		resultSet.close();
	    		connection.close();
	    	}
	    	catch(Exception e)
	    	{
	    		JOptionPane.showMessageDialog(null, "ERROR");
	    	}
	    }
	    
	    cerintaPanel.setSize(600, 70);
	    cerintaPanel.setBounds(0, 50, 600, 70);
	    cerintaPanel.setBorder(border2);
	    cerintaPanel.setBackground(colorCerinta);
	
	    cerintaPanel1.setSize(600, 35);
	    cerintaPanel1.setBounds(0, 50, 600, 35);
	    cerintaPanel1.setBackground(colorCerinta);

	    cerintaPanel2.setSize(600, 35);
	    cerintaPanel2.setBounds(0, 85, 600, 35);
	    cerintaPanel2.setBackground(colorCerinta);
	    
	    label1.setBounds(0, 50, 450, 35);
	    label1.setBackground(colorCerinta);
	    label1.setFont(new Font("TAHOMA", Font.BOLD, 20));
	    label1.setForeground(Color.BLACK);
	    
	    label2.setBounds(0, 85, 450, 35);
	    label1.setBackground(colorCerinta);
	    label2.setFont(new Font("TAHOMA", Font.BOLD, 20));
	    label2.setForeground(Color.BLACK);
	    
	    cerintaPanel1.add(label1);
	    cerintaPanel2.add(label2);
	    cerintaPanel.add(cerintaPanel1, BorderLayout.CENTER);
	    cerintaPanel.add(cerintaPanel2, BorderLayout.CENTER);
	    BoxLayout b = new BoxLayout(cerintaPanel, BoxLayout.Y_AXIS);
	    cerintaPanel.setLayout(b);
	    panel.add(cerintaPanel);

	    labelUtiliz.setBounds(10, 150, 380, 30);
	    labelUtiliz.setFont(new Font("Tahoma", Font.BOLD, 22));
	    labelUtiliz.setForeground(Color.BLACK);
	    panel.add(labelUtiliz);
	    
	    categorieComboBox.setBounds(370, 150, 220, 30);
	    categorieComboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    categorieComboBox.setForeground(Color.BLACK);
	    categorieComboBox.setFocusable(false);
	    categorieComboBox.setBackground(Color.white);
	    panel.add(categorieComboBox);
	    
	    afisareBtn.setBounds(220, 295, 130, 45);
	    afisareBtn.setBackground(Color.white);
	    afisareBtn.setFont(new Font("Tahoma", Font.BOLD, 25));
	    afisareBtn.setFocusable(false);
	    afisareBtn.setForeground(Color.black);
	    panel.add(afisareBtn);
	    afisareBtn.addActionListener(this);
	    
	    close.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	            close.setBackground(colorX);
	        }

	        public void mouseExited(java.awt.event.MouseEvent evt) {
	            close.setBackground(Color.white);
	            close.setBorder(border1);
	        }
	    });
	    close.setBounds(550, 0, 50, 30);
	    close.setBorder(border1);
	    close.setBackground(Color.white);
	    close.setFont(new Font("Tahoma", Font.BOLD, 18));
	    close.setFocusable(false);
	    panel.add(close);
	    close.addActionListener(this);
	   
	    panel.setBackground(colorFundal);
	    this.setContentPane(panel);
	    this.setLayout(null);
	    this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == afisareBtn)
     {
			this.setVisible(false);
			Connection connection = null;
			Statement selectStatement = null;
			ResultSet resultSet = null;
			ResultSetMetaData md = null;
			
			Vector columnNames = new Vector();
			Vector data = new Vector();

			try 
			{
				connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bucatarie_retete?user=root&password=GTXEN5RYYZFXXTCN&serverTimezone=UTC");
				selectStatement = connection.createStatement();
				selectStatement.execute("SELECT DISTINCT r.nume, r.timp_preparare, r.portii, r.autor\r\n"
						+ "FROM Reteta r JOIN Set_ingrediente s ON (r.reteta_id = s.reteta_id)\r\n"
						+ "WHERE LOWER(r.nume) !=\"" +  categorieComboBox.getSelectedItem() + "\" AND s.ingred_id IN\r\n"
						+ "(SELECT s.ingred_id\r\n"
						+ "FROM Reteta r JOIN Set_ingrediente s ON (r.reteta_id = s.reteta_id)\r\n"
						+ "WHERE UPPER(nume) =\"" + categorieComboBox.getSelectedItem() + "\")\r\n"
						+ "ORDER BY r.reteta_id;");
				resultSet = selectStatement.getResultSet();
				md = (ResultSetMetaData)resultSet.getMetaData();
				int nrOfColumns = md.getColumnCount();
				for(int i = 1; i <= nrOfColumns; i++)
				{
					if(i == 2)
						columnNames.addElement("TIMP PREPARARE");
					else if(i == 3)
						columnNames.addElement("PORȚII");
					else
						columnNames.addElement(md.getColumnName(i).toUpperCase());
				}
				while(resultSet.next())
				{
					Vector row = new Vector(nrOfColumns);
					for(int i = 1; i <= nrOfColumns; i++)
					{
						row.addElement(resultSet.getObject(i));
					}
					data.addElement(row);
				}
             
				new Rezultat6(data, columnNames);
			}
			catch(SQLException sqlex) 
			{
				System.err.println("An SQL Exception occured. Details are provided below:");
				sqlex.printStackTrace(System.err);
			}
			finally 
			{
				if (resultSet != null) 
				{
					try 
					{
						resultSet.close();
					}
					catch(SQLException e1) {}
					resultSet = null;
				}
				if (selectStatement != null) 
				{
					try 
					{
						selectStatement.close();
					}
					catch(SQLException e1) {}
					selectStatement = null;
				}
				if (connection != null) 
				{
					try 
					{
                     connection.close();
					}
					catch(SQLException e1) {}
					connection = null;
				}
			}   
     	}
		if(e.getSource() == close)
		{
			this.setVisible(false);
			Meniu meniu = new Meniu();
		}
	 }
}
