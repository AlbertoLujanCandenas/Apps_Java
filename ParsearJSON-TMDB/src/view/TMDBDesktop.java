package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import api.Manejador;
import modelPerson.Actor;
import modelPerson.TMDB;
import util.IconCellRenderer;

import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class TMDBDesktop extends JFrame {

	private static JPanel mainPanel;
	private static JTable table;
	private static TMDB tmdb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TMDBDesktop frame = new TMDBDesktop();
					frame.setVisible(true);
					getResults();
					showResults();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			
		});
	}

	protected static void getResults() {
		Manejador manejador = new Manejador("http://api.themoviedb.org/3/person/popular?api_key=b8a40ad963d530b1a6997d1be5fa52cf");
		tmdb = manejador.getDataPerson();
	}
	
	protected static void showResults() {
		showActor();
		showLabels();
		
	}
	
	private static void showLabels() {
		
	}
	

	private static void showActor() {
		
		List<Actor> actores = tmdb.getResults();
		Object[][] resultados = new Object[actores.size()][4];
		Actor actor;
		for(int i = 0; i<actores.size()-1; i++ ) {
			actor = actores.get(i);
			
			resultados[i][0] = getImagen("https://image.tmdb.org/t/p/w500/" + actor.getProfile_path());
			resultados[i][1] = actor.getId();
			resultados[i][2] = actor.getName();
			resultados[i][3] = actor.getPopularity();
		}
		table.setModel(new DefaultTableModel(
				resultados,
				new String[] {
					"ProfilePath", "Id", "Name", "Popularity"
				}
				));
		}

	/**
	 * Create the frame.
	 */
	public TMDBDesktop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 406);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 523, 291);
		mainPanel.add(scrollPane);
		
		table = new JTable();
		
		/**
		 * Truco para poder poner un JLabel con un icono en una celda de la tabla.
		 *  Basta con implementar la clase IconCellRenderer y decirle a la tabla que lo renderice.
		 */
		
		table.setDefaultRenderer(Object.class, new IconCellRenderer());
		table.setRowHeight(64);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"ProfilePath", "Id", "Name", "Popularity"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblProfilePath = new JLabel("");
		lblProfilePath.setBounds(10, 11, 46, 14);
		mainPanel.add(lblProfilePath);
		
		JLabel lblId = new JLabel("");
		lblId.setBounds(139, 40, 46, 14);
		mainPanel.add(lblId);
		
		JLabel lblName = new JLabel("");
		lblName.setBounds(270, 40, 46, 14);
		mainPanel.add(lblName);
		
		JLabel lblPopularity = new JLabel("");
		lblPopularity.setBounds(399, 40, 46, 14);
		mainPanel.add(lblPopularity);
	}
	private static JLabel getImagen(String urlImagen) {
        URL url=null;
        try {
            url = new URL(urlImagen);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        JLabel labelIcono = new JLabel();
        ImageIcon imageIcon = new ImageIcon(url);
        //------------- cambiar size de la image -----------z
        Image imageOriginal = imageIcon.getImage();
        Image newImg = imageOriginal.getScaledInstance(64, 64,  java.awt.Image.SCALE_DEFAULT);
        imageIcon.setImage(newImg);
        //------------- fin cambiar size de la image -----------
        labelIcono.setIcon(imageIcon);

        return labelIcono;
}
}
