package ColocviuFinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Pagina2 extends JFrame implements ActionListener {
	
	JFrame frame;
	JPanel panel = new JPanel();
	JLabel labelUtiliz = new JLabel("Introduceți o literă:");
	JTextField litera = new JTextField();
	Border border = BorderFactory.createLineBorder(Color.gray);
	JButton afisareBtn = new JButton("CAUTĂ");
	JButton close = new JButton("X");
	
	JPanel panelBara = new JPanel();
	JLabel titluBara = new JLabel("INTEROGARE 2");
	
	JLabel label1 = new JLabel("              Găsiți ingredientele care conțin a doua literă");
	JLabel label2 = new JLabel("                           dorită în ordine alfabetică.");
	
	JPanel cerintaPanel = new JPanel(new BorderLayout());
	JPanel cerintaPanel1 = new JPanel(new BorderLayout());
	JPanel cerintaPanel2 = new JPanel(new BorderLayout());
	
	Border border1 = BorderFactory.createLineBorder(Color.white);
	Border border2 = BorderFactory.createLineBorder(Color.black);
	
    Color colorFundal = new Color(173, 184, 235); 
    Color colorCerinta = new Color(218, 240, 227);
	Color colorX = new Color(210, 43, 43);
	
	public Pagina2()
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

	    labelUtiliz.setBounds(175, 140, 350, 30);
	    labelUtiliz.setFont(new Font("Tahoma", Font.BOLD, 22));
	    labelUtiliz.setForeground(Color.BLACK);
	    panel.add(labelUtiliz);
	    
	    litera.setBounds(230, 190, 100, 30);
	    litera.setText(null);
	    litera.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    litera.setForeground(Color.BLACK);
	    panel.add(litera);
	    
	    afisareBtn.setBounds(215, 295, 130, 45);
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
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == afisareBtn && litera.getText().length() == 1 && Character.isLetter(litera.getText().charAt(0)) == true)
	     {
				Connection connection = null;
				Statement selectStatement = null;
				ResultSet resultSet = null;
				ResultSet resultSet1 = null;
				java.sql.ResultSetMetaData md = null;
				java.sql.ResultSetMetaData md1 = null;
				
				Vector columnNames = new Vector();
				Vector data = new Vector();
				String count = null;

				try 
				{
					connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bucatarie_retete?user=root&password=GTXEN5RYYZFXXTCN&serverTimezone=UTC");
					selectStatement = connection.createStatement();
					selectStatement.execute("SELECT ingredient FROM Ingredient WHERE ingredient LIKE '_" + litera.getText().toLowerCase().charAt(0) + "%' ORDER BY ingredient;");					
					resultSet = selectStatement.getResultSet();
					md = resultSet.getMetaData();
					
					if(!resultSet.isBeforeFirst())
					{
						this.setVisible(true);
						JLabel label = new JLabel("Momentan nu sunt ingrediente care au a doua literă " + litera.getText().toLowerCase().charAt(0) + ".");
						int result = JOptionPane.showConfirmDialog(this, "Doriți să introduceți altă literă?                                               ", label.getText(), JOptionPane.YES_NO_OPTION);
						if(result == JOptionPane.YES_OPTION)
						{
							this.setVisible(false);
							Pagina2 pagina2 = new Pagina2();
						}
						else
						{
							this.setVisible(false);
							Meniu meniu = new Meniu();
						}
						
					}
					else
					{
						java.sql.CallableStatement call1 = null;
						call1 = connection.prepareCall("call nr_ingrediente(?)");
						call1.setString(1, String.valueOf(litera.getText().toLowerCase().charAt(0)));
						call1.execute();
						resultSet1 = call1.getResultSet();
						md1 = resultSet1.getMetaData();
						int columnsNumber = md1.getColumnCount();
						while (resultSet1.next()) {
							for (int i = 1; i <= columnsNumber; i++) 
							{
								count = resultSet1.getObject(i).toString();
							}
						}
						int nrOfColumns = md.getColumnCount();
						for(int i = 1; i <= nrOfColumns; i++)
						{
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
						this.setVisible(false);
						new Rezultat2(data, columnNames, count);
					}
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
		else if(e.getSource() == afisareBtn && litera.getText().length() != 1)
		{
			JOptionPane.showMessageDialog(this, "Introduceți o literă!", "Avertizare", JOptionPane.WARNING_MESSAGE);
		}
		if(e.getSource() == close)
		{
			this.setVisible(false);
			Meniu meniu = new Meniu();
		}
	}

}
