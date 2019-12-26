package view.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.FileController;
import controller.TrajectoryController;
import model.dto.Coordinate;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.Color;

public class SwingGui {
	private FileController fileController;
	private TrajectoryController trajectoryController;
	private JFrame frmTracker;
	private JFileChooser chooser;
	private JTextField textField;
	private JTextField yearFrom;
	private JTextField yearTo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingGui window = new SwingGui();
					window.frmTracker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingGui() {
		fileController = new FileController();
		trajectoryController = new TrajectoryController();
		chooser = new JFileChooser();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTracker = new JFrame();
		
		frmTracker.setTitle("Tracker");
		frmTracker.setBounds(100, 100, 1290, 622);
		frmTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Import", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		MapPanel map = new MapPanel();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Coincidence", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(frmTracker.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(map, GroupLayout.PREFERRED_SIZE, 1037, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
					.addGap(24))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(map, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JComboBox<Entry<String, String>> coincidenceBox = new JComboBox<Entry<String, String>>();
		coincidenceBox.setEnabled(false);
		
		JButton btnAdd = new JButton("Add");
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(coincidenceBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(147, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(148, Short.MAX_VALUE)
					.addComponent(btnAdd)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(coincidenceBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAdd)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		//Search layout
		
		JLabel lblDay = new JLabel("Day");
		
		JLabel lblMonth = new JLabel("Month");
		
		JLabel lblYear = new JLabel("Year");
		
		JLabel lblYear_1 = new JLabel("Year");
		
		JLabel lblMonth_1 = new JLabel("Month");
		
		JLabel lblDay_1 = new JLabel("Day");
		
		JComboBox<String> comboBoxPlate = new JComboBox<String>();
    	List<String> plates = trajectoryController.getPlates();
    	for (String plate : plates) 
    		comboBoxPlate.addItem(plate);
		comboBoxPlate.setEnabled(false);
		
		JComboBox<String> dayFrom = new JComboBox<String>();
		dayFrom.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayFrom.setEnabled(false);
		
		JComboBox<String> monthFrom = new JComboBox<String>();
		monthFrom.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthFrom.setEnabled(false);
		
		JComboBox<String> dayTo = new JComboBox<String>();
		dayTo.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayTo.setEnabled(false);
		
		JComboBox<String> monthTo = new JComboBox<String>();
		monthTo.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthTo.setEnabled(false);
		
		yearFrom = new JTextField("1990");
		yearFrom.setEnabled(false);
		yearFrom.setColumns(5);
		
		yearTo = new JTextField("2050");
		yearTo.setEnabled(false);
		yearTo.setColumns(5);
		
		JCheckBox chckbxDate = new JCheckBox("Date from");
		
		chckbxDate.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {
		        	dayFrom.setEnabled(true);
		        	monthFrom.setEnabled(true);
		        	yearFrom.setEnabled(true);
		        } else {
		        	dayFrom.setEnabled(false);
		        	monthFrom.setEnabled(false);
		        	yearFrom.setEnabled(false);
		        };
		    }
		});
		
		JCheckBox chckbxDateTo = new JCheckBox("Date to ");
		
		chckbxDateTo.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {
		        	dayTo.setEnabled(true);
		        	monthTo.setEnabled(true);
		        	yearTo.setEnabled(true);
		        } else {
		        	dayTo.setEnabled(false);
		        	monthTo.setEnabled(false);
		        	yearTo.setEnabled(false);
		        };
		    }
		});
		
		JCheckBox chckbxPlate = new JCheckBox("License plate");
		chckbxPlate.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if(e.getStateChange() == ItemEvent.SELECTED) {
		        	comboBoxPlate.setEnabled(true);
		        } else {
		        	comboBoxPlate.setEnabled(false);
		        };
		    }
		});
		

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dateFrom = null;
				String dateTo = null;
				String plate = null;
				if (chckbxDate.isSelected())
					dateFrom = new String(yearFrom.getText() + '-' + monthFrom.getSelectedItem() + '-' + dayFrom.getSelectedItem());
				if (chckbxDateTo.isSelected())
					dateTo = new String(yearTo.getText() + '-' + monthTo.getSelectedItem() + '-' + dayTo.getSelectedItem());
				if (chckbxPlate.isSelected())
					plate = (String) comboBoxPlate.getSelectedItem();
				List<Coordinate> trajectory = trajectoryController.getTrajectory(dateFrom, dateTo, plate);
				map.showTrajectory(trajectory, "Search");
				
				coincidenceBox.removeAllItems();
				Map<String,String> coincidences = trajectoryController.getCoincidence(trajectory);
				for (Map.Entry<String, String> pair : coincidences.entrySet()) {
					coincidenceBox.addItem(pair);
		        }
				coincidenceBox.setEnabled(true);
				
			}
		});
		

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unchecked")
				Entry<String, String> entry = (Entry<String, String>) coincidenceBox.getSelectedItem();
				List<Coordinate> trajectory = trajectoryController.getTrajectory(null, null, entry.getKey());
				map.showTrajectory(trajectory, entry.getKey());
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxPlate)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMonth)
								.addComponent(lblDay)
								.addComponent(chckbxDate)
								.addComponent(lblYear)
								.addComponent(chckbxDateTo)
								.addComponent(lblYear_1)
								.addComponent(lblMonth_1)
								.addComponent(lblDay_1))
							.addGap(15)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(yearFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(yearTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(dayFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(monthFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(dayTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(monthTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(comboBoxPlate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(41, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(134, Short.MAX_VALUE)
					.addComponent(btnSearch)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxDate)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDay)
						.addComponent(dayFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMonth)
						.addComponent(monthFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYear)
						.addComponent(yearFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxDateTo)
					.addGap(1)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDay_1)
						.addComponent(dayTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMonth_1)
						.addComponent(monthTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYear_1)
						.addComponent(yearTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(chckbxPlate)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBoxPlate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSearch)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		//Import layout
		JButton btnOpenFile = new JButton("Open file");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//filter by extension
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PLT files", "plt");
				chooser.setFileFilter(filter);
				//open in project path
				File workingDirectory = new File(System.getProperty("user.dir"));
				chooser.setCurrentDirectory(workingDirectory);
				
				int returnVal = chooser.showOpenDialog(frmTracker);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("You chose to open this file: " + chooser.getSelectedFile().toString());
					
				}
			}
		});
		
		JLabel lblPlate = new JLabel("License plate");
		
		textField = new JTextField();
		textField.setColumns(5);
		
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				fileController.importData(chooser.getSelectedFile(), textField.getText());
				
	        	comboBoxPlate.removeAllItems();
	        	List<String> plates = trajectoryController.getPlates();
	        	for (String plate : plates) 
	        		comboBoxPlate.addItem(plate);
			}
		});
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOpenFile)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblPlate)
							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnImport, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnOpenFile)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPlate)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnImport)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		frmTracker.getContentPane().setLayout(groupLayout);
	}
}
