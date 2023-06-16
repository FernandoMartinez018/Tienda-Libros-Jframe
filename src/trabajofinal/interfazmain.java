package trabajofinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfazmain extends JFrame {

	private JPanel contentPane;
	private JTable catalogo;
	
	catalogo1 comp = new catalogo1();
	DefaultTableModel modelocomprar = new DefaultTableModel();
	
	catalogolibros libr = new catalogolibros();
	DefaultTableModel modelocatalogo = new DefaultTableModel();
	private JTextField txtcantidad;
	private JTable tabladecompra;
	private JTable tablacatalogo;
	private JTextField txttotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazmain frame = new interfazmain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public interfazmain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollcatalogo = new JScrollPane();
		scrollcatalogo.setBounds(10, 77, 437, 117);
		contentPane.add(scrollcatalogo);
		
		tablacatalogo = new JTable();
		scrollcatalogo.setColumnHeaderView(tablacatalogo);
		
		modelocatalogo.addColumn("ISBN");
		modelocatalogo.addColumn("Titulo");
		modelocatalogo.addColumn("Precio");
		tablacatalogo.setModel(modelocatalogo);
		modelocatalogo.setRowCount(0);
		
		for (int i = 0; i < libr.tamaño(); i++) {
			Object[] fila = {
				libr.Obtener(i).getISBN(),
				libr.Obtener(i).getTitulo(),
				libr.Obtener(i).getPrecio(),
			};
			modelocatalogo.addRow(fila);
		}
		
			
		
		JButton btnAñadir = new JButton("A\u00F1adir Libro");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ISBN = JOptionPane.showInputDialog("ingrese el ISBN");
				String Titulo= JOptionPane.showInputDialog("ingrese el tiltulo del libro");
				float Precio;
				try {
					do {
					Precio=Float.parseFloat( JOptionPane.showInputDialog("ingrese el precio"));
				}while(Precio<0);
					libro1 lib = new libro1(ISBN, Titulo, Precio);
					libr.Añadir(lib);
					modelocatalogo.setRowCount(0);
					
					for (int i = 0; i < libr.tamaño(); i++) {
						Object[] fila = {
							libr.Obtener(i).getISBN(),
							libr.Obtener(i).getTitulo(),
							libr.Obtener(i).getPrecio(),
						};
						modelocatalogo.addRow(fila);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ocurre un error, verifique que el dato sea numero", "ERROR", JOptionPane.ERROR_MESSAGE, null);
				}

				
			}
		});
		btnAñadir.setBounds(10, 11, 89, 23);
		contentPane.add(btnAñadir);
				
		JLabel lblNewLabel = new JLabel("detalle del carrito de compras");
		lblNewLabel.setBounds(10, 260, 184, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblcantidad = new JLabel("cantidad");
		lblcantidad.setBounds(193, 205, 55, 14);
		contentPane.add(lblcantidad);
		
		txtcantidad = new JTextField();
		txtcantidad.setBounds(176, 230, 86, 20);
		contentPane.add(txtcantidad);
		txtcantidad.setColumns(10);
		
		JScrollPane scrollcarrito = new JScrollPane();
		scrollcarrito.setBounds(10, 285, 437, 117);
		contentPane.add(scrollcarrito);
		
		
		tabladecompra = new JTable();
		scrollcarrito.setViewportView(tabladecompra);
		modelocomprar.addColumn("ISBN");
		modelocomprar.addColumn("Titulo");
		modelocomprar.addColumn("Cantidad");
		modelocomprar.addColumn("subTotal");
		
		tabladecompra.setModel(modelocomprar);
		
		JButton btncomprar = new JButton("comprar");
		btncomprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				 int filaselec = tablacatalogo.getSelectedRow();
				 if (filaselec==-1) {
					 JOptionPane.showMessageDialog(null, "selecciona una fila", "ERROR", JOptionPane.ERROR_MESSAGE, null);
					 txtcantidad.setText("");
				}else {
				int Cantidad = Integer.parseInt(txtcantidad.getText());
				if (Cantidad<=0) {
					JOptionPane.showMessageDialog(null, "escriba un numero positivo", "ERROR", JOptionPane.ERROR_MESSAGE, null);
					txtcantidad.setText("");
				}else {
					 String ISBN = tablacatalogo.getValueAt(filaselec, 0).toString();
					 String Titulo= tablacatalogo.getValueAt(filaselec, 1).toString();
					 float subTotal= Float.parseFloat(tablacatalogo.getValueAt(filaselec,2).toString())*Cantidad;
					 
					 clasecompra compr =new clasecompra(ISBN, Titulo, Cantidad, subTotal);
					 comp.adiccionar(compr);
					 modelocomprar.setRowCount(0);
					 
					 for (int i = 0; i < comp.tamaño(); i++) {
							Object[] fila = {
								comp.Obtener(i).getISBN(),
								comp.Obtener(i).getTitulo(),
								comp.Obtener(i).getCantidad(),
								comp.Obtener(i).getsubTotal()
							};
							modelocomprar.addRow(fila);
						}
					 txtcantidad.setText("");
					 float total = comp.Compra_total();
					 txttotal.setText(total+"");
				}

				}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ocurre un error, verifique que el dato sea numero", "ERROR", JOptionPane.ERROR_MESSAGE, null);
				}

				
			}
		});
		
		btncomprar.setBounds(295, 229, 89, 23);
		contentPane.add(btncomprar);
		
	
		
		JLabel lblNewLabel_1 = new JLabel("TOTAL:");
		lblNewLabel_1.setBounds(10, 431, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txttotal = new JTextField();
		txttotal.setBounds(74, 428, 86, 20);
		contentPane.add(txttotal);
		txttotal.setColumns(10);
		
		JButton btnborrar = new JButton("borrar");
		btnborrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaselec = tabladecompra.getSelectedRow();
				if(filaselec==-1) {
					JOptionPane.showInternalConfirmDialog(null,"debe oprimir el libro que desea borrar","Advertencia",JOptionPane.WARNING_MESSAGE);
					
				}else {
					int bor = JOptionPane.showConfirmDialog(null, "se va a eliminar este opcion","Eliminar",JOptionPane.YES_NO_OPTION);
					if(bor==JOptionPane.YES_NO_OPTION) {
						comp.eliminar(tabladecompra.getValueAt(filaselec,0).toString());
						modelocomprar.removeRow(filaselec);
						float total= comp.Compra_total();
						txttotal.setText(total+"");
											}
				}
				
			}
		});
		btnborrar.setBounds(318, 427, 89, 23);
		contentPane.add(btnborrar);
		
		JLabel lblNewLabel_2 = new JLabel("detalles del catalogo");
		lblNewLabel_2.setBounds(10, 45, 166, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("opcion 1");
		btnNewButton.setBounds(164, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("opcion2");
		btnNewButton_1.setBounds(335, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
	}

	}

