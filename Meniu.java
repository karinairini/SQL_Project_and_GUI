package ColocviuFinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

public class Meniu extends JFrame implements ActionListener{

JFrame frame = new JFrame();
	
	JPanel panel1 = new JPanel();
	JPanel panelImage = new JPanel();
	JPanel panelMeniu = new JPanel(new BorderLayout());
	JPanel panelCheckBox = new JPanel();
	JPanel panelSelect = new JPanel();
	JPanel panelBtn = new JPanel();
	JPanel generalPanel = new JPanel();
	
    Color c1 = new Color(224, 215, 255); 
    Border border = BorderFactory.createLineBorder(Color.black);
    
	ButtonGroup checkBox = new ButtonGroup(); 
	JCheckBox check1 = new JCheckBox("Interogare 1", false); 
	JCheckBox check2 = new JCheckBox("Interogare 2", false); 
	JCheckBox check3 = new JCheckBox("Interogare 3", false); 
	JCheckBox check4 = new JCheckBox("Interogare 4", false); 
	JCheckBox check5 = new JCheckBox("Interogare 5", false); 
	JCheckBox check6 = new JCheckBox("Interogare 6", false); 
	JCheckBox check7 = new JCheckBox("Interogare 7", false); 
	JCheckBox check8 = new JCheckBox("Interogare 8", false);
	
	JButton selectBtn= new JButton("SELECTEAZĂ");
	
	JLabel imageLabel;
	ImageIcon image;
	
	public Meniu()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(840, 635); 
		frame.setTitle("Rețete de Bucătărie");
		frame.setResizable(false);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	    
	    panel1.setSize(370, 600);
	    panel1.setBackground(c1);
	    panelMeniu.setBackground(c1);
	    panelCheckBox.setBackground(c1);
	    panelSelect.setBackground(c1);
	    panelBtn.setBackground(c1);
	    
	    check1.setFont(new Font("Calibri", Font.BOLD, 28));
	    check2.setFont(new Font("Calibri", Font.BOLD, 28));
	    check3.setFont(new Font("Calibri", Font.BOLD, 28));
	    check4.setFont(new Font("Calibri", Font.BOLD, 28));
	    check5.setFont(new Font("Calibri", Font.BOLD, 28));
	    check6.setFont(new Font("Calibri", Font.BOLD, 28));
	    check7.setFont(new Font("Calibri", Font.BOLD, 28));
	    check8.setFont(new Font("Calibri", Font.BOLD, 28));
	   
	    check1.setForeground(Color.black);
	    check2.setForeground(Color.black);
	    check3.setForeground(Color.black);
	    check4.setForeground(Color.black);
	    check5.setForeground(Color.black);
	    check6.setForeground(Color.black);
	    check7.setForeground(Color.black);
	    check8.setForeground(Color.black);
	   
	    check1.setFocusable(false);
	    check2.setFocusable(false);
	    check3.setFocusable(false);
	    check4.setFocusable(false);
	    check5.setFocusable(false);
	    check6.setFocusable(false);
	    check7.setFocusable(false);
	    check8.setFocusable(false);
	    
	    check1.setBackground(c1);
	    check2.setBackground(c1);
	    check3.setBackground(c1);
	    check4.setBackground(c1);
	    check5.setBackground(c1);
	    check6.setBackground(c1);
	    check7.setBackground(c1);
	    check8.setBackground(c1);
	    
	    JLabel meniu = new JLabel("MENIU");
	    meniu.setBounds(0, 0, 370, 30);
	    meniu.setFont(new Font("Tahoma", Font.BOLD, 30));
	    meniu.setForeground(Color.BLACK);
	    panelMeniu.add(meniu, BorderLayout.CENTER);
	    
	    JLabel instructiune = new JLabel("Selectați o interogare:");
	    instructiune.setFont(new Font("Tahoma", Font.BOLD, 25));
	    instructiune.setForeground(Color.BLACK);
	    instructiune.setFocusable(false);
	    panelSelect.add(instructiune);
	   
	    panelCheckBox.setSize(370, 590);
	    panelCheckBox.setBounds(45, 0, 370, 585);
	    checkBox.add(check1); 
	    checkBox.add(check2); 
	    checkBox.add(check3);
	    checkBox.add(check4); 
	    checkBox.add(check5); 
	    checkBox.add(check6);
	    checkBox.add(check7); 
	    checkBox.add(check8);
	    
	    panelCheckBox.add(check1); 
	    panelCheckBox.add(check2); 
	    panelCheckBox.add(check3);
	    panelCheckBox.add(check4);
	    panelCheckBox.add(check5); 
	    panelCheckBox.add(check6);
	    panelCheckBox.add(check7);
	    panelCheckBox.add(check8);
	
	    add(panelCheckBox);
	    BoxLayout boxLayout = new BoxLayout(panelCheckBox, BoxLayout.Y_AXIS);
	    panelCheckBox.setLayout(boxLayout);
	  
	    selectBtn.setBackground(Color.white);
	    selectBtn.setFont(new Font("Tahoma", Font.BOLD, 25));
	    selectBtn.setForeground(Color.black);
	    selectBtn.setFocusable(false);
	    selectBtn.addActionListener(this);
	    panelBtn.add(selectBtn);
	    
	    panel1.add(panelMeniu);
	    panel1.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    gbc.anchor = GridBagConstraints.PAGE_START;
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.5;
	    gbc.gridx=0;
	    gbc.gridy=0;
	    panel1.add(panelMeniu, gbc);
	    
	    gbc.weightx = 0.5;
	    gbc.weighty = 0.5;
	    gbc.gridx=0;
	    gbc.gridy=1;
	    panel1.add(panelSelect, gbc);
	   
	    gbc.gridx=0;
	    gbc.gridy=2;
	    panel1.add(panelCheckBox,gbc);
	   
	    gbc.gridx=0;
	    gbc.gridy=3;
	    panel1.add(panelBtn, gbc);

	    panelImage.setSize(452, 600);
	    panelImage.setBounds(380, 0, 452, 600);
	    panelImage.setBackground(c1);
	    try
	    {
		    image = new ImageIcon(getClass().getResource("chef_picture.png"));
		    imageLabel = new JLabel(image);
		    panelImage.add(imageLabel);
	    }
	    catch(Exception e)
	    {
		    System.out.println("Image cannot be found!");
	    }
	   
	    generalPanel.add(panel1);
	    generalPanel.add(panelImage);
	    generalPanel.setBackground(c1);
	    GroupLayout flowLayout = new GroupLayout(generalPanel);
	    generalPanel.setLayout(flowLayout);
	   
	    frame.setContentPane(generalPanel);
	    frame.setVisible(true);
	 }
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == selectBtn)
		{
			if(check1.isSelected())
			{
				frame.setVisible(false);
				Pagina1 pagina1 = new Pagina1();
			}
			else if(check2.isSelected())
			{
				frame.setVisible(false);
				Pagina2 pagina2 = new Pagina2();
			}
			else if(check3.isSelected())
			{
				frame.setVisible(false);
				Pagina3 pagina3 = new Pagina3();
			}
			else if(check4.isSelected())
			{
				frame.setVisible(false);
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
					selectStatement.execute("SELECT DISTINCT LEAST(r1.reteta_id, r2.reteta_id) AS \"reteta_id1\", GREATEST(r1.reteta_id, r2.reteta_id) AS \"reteta_id2\"\r\n"
							+ "FROM Set_ingrediente r1 JOIN Set_ingrediente r2 ON (r1.ingred_id = r2.ingred_id)\r\n"
							+ "WHERE r1.reteta_id <> r2.reteta_id AND r1.cantitate = r2.cantitate AND r1.um = r2.um\r\n"
							+ "ORDER BY \"reteta_id1\";");
					resultSet = selectStatement.getResultSet();
					md = (ResultSetMetaData)resultSet.getMetaData();
					int nrOfColumns = md.getColumnCount();
					for(int i = 1; i <= nrOfColumns; i++)
					{
						columnNames.addElement(md.getColumnName(i));
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
	             
					new Pagina4(data, columnNames);
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
			else if(check5.isSelected())
			{
				frame.setVisible(false);
				Pagina5 pagina5 = new Pagina5();
			}
			else if(check6.isSelected())
			{
				frame.setVisible(false);
				Pagina6 pagina6 = new Pagina6();
			}
			else if(check7.isSelected())
			{
				frame.setVisible(false);
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
					selectStatement.execute("SELECT c.tip AS `Categorie`, MIN(r.timp_preparare) AS `Timpul minim`, ROUND(AVG(r.timp_preparare), 2) \r\n"
							+ "AS `Timpul mediu`, MAX(r.timp_preparare) AS `Timpul maxim`\r\n"
							+ "FROM Categorie c JOIN Reteta r ON (c.categ_id = r.categ_id)\r\n"
							+ "GROUP BY c.tip;");
					resultSet = selectStatement.getResultSet();
					md = (ResultSetMetaData)resultSet.getMetaData();
					int nrOfColumns = md.getColumnCount();
					for(int i = 1; i <= nrOfColumns; i++)
					{
						if(i == 1)
							columnNames.addElement("CATEGORIE");
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
	             
					new Pagina7(data, columnNames);
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
			else if(check8.isSelected())
			{
				frame.setVisible(false);
				Pagina8 pagina8 = new Pagina8();
			}
			else
			{
				JOptionPane.showMessageDialog(frame, "Selectați interogarea dorită!", "Avertizare", JOptionPane.WARNING_MESSAGE);
			}
			
		} 
	}
}
