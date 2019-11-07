import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.JButton;

public class TagAdder extends JFrame {

	private JPanel contentPane;
	private JTextField FromLotTB;
	private JTextField ToLotTB;
	private JTextField OutputTB;
	
	ParkingSpotTag currentTag;

	public TagAdder() {
		super.setTitle("Tag Adder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1450, 400, 470, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel FromLotLabel = new JLabel("From Lot:");
		GridBagConstraints gbc_FromLotLabel = new GridBagConstraints();
		gbc_FromLotLabel.anchor = GridBagConstraints.WEST;
		gbc_FromLotLabel.insets = new Insets(0, 0, 5, 5);
		gbc_FromLotLabel.gridx = 0;
		gbc_FromLotLabel.gridy = 1;
		contentPane.add(FromLotLabel, gbc_FromLotLabel);
		
		FromLotTB = new JTextField();
		GridBagConstraints gbc_FromLotTB = new GridBagConstraints();
		gbc_FromLotTB.anchor = GridBagConstraints.WEST;
		gbc_FromLotTB.insets = new Insets(0, 0, 5, 5);
		gbc_FromLotTB.gridx = 0;
		gbc_FromLotTB.gridy = 2;
		contentPane.add(FromLotTB, gbc_FromLotTB);
		FromLotTB.setColumns(10);
		
		JLabel ToLotLabel = new JLabel("To Lot");
		GridBagConstraints gbc_ToLotLabel = new GridBagConstraints();
		gbc_ToLotLabel.anchor = GridBagConstraints.WEST;
		gbc_ToLotLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ToLotLabel.gridx = 0;
		gbc_ToLotLabel.gridy = 4;
		contentPane.add(ToLotLabel, gbc_ToLotLabel);
		
		ToLotTB = new JTextField();
		GridBagConstraints gbc_ToLotTB = new GridBagConstraints();
		gbc_ToLotTB.anchor = GridBagConstraints.WEST;
		gbc_ToLotTB.insets = new Insets(0, 0, 5, 5);
		gbc_ToLotTB.gridx = 0;
		gbc_ToLotTB.gridy = 5;
		contentPane.add(ToLotTB, gbc_ToLotTB);
		ToLotTB.setColumns(10);
		
		JButton btnAddTag = new JButton("Add Tag");
		GridBagConstraints gbc_btnAddTag = new GridBagConstraints();
		gbc_btnAddTag.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddTag.gridx = 1;
		gbc_btnAddTag.gridy = 5;
		contentPane.add(btnAddTag, gbc_btnAddTag);
		
		OutputTB = new JTextField();
		OutputTB.setEditable(false);
		GridBagConstraints gbc_OutputTB = new GridBagConstraints();
		gbc_OutputTB.gridwidth = 2;
		gbc_OutputTB.insets = new Insets(0, 0, 0, 5);
		gbc_OutputTB.fill = GridBagConstraints.HORIZONTAL;
		gbc_OutputTB.gridx = 0;
		gbc_OutputTB.gridy = 8;
		contentPane.add(OutputTB, gbc_OutputTB);
		OutputTB.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(" ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridheight = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 6;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		//Arraylist with names of all tags
		ArrayList<String> Tags = new ArrayList<>();
		
		Tags.add("Handicap");
		Tags.add("Near IT");
		Tags.add("Near Landrum");
		Tags.add("Near RAC");
		
		JSpinner spinner = new JSpinner(new SpinnerListModel(Tags));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 0);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 2;
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(spinner, gbc_spinner);
		
		btnAddTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String stringTag = (String) spinner.getValue();
				
				if (stringTag.equals("Handicap")) {
					currentTag = new TAG_Handicap();
				} else if (stringTag.equals("Near IT")) {
					currentTag = new TAG_NearIT();
				} else if (stringTag.equals("Near Landrum")) {
					currentTag = new TAG_NearLandrum();
				} else if (stringTag.equals("Near RAC")) {
					currentTag = new TAG_NearRAC();
				}
				
				int from = Integer.parseInt(FromLotTB.getText());
				int to = Integer.parseInt(ToLotTB.getText());
				
				if (from >= 0 && from < (simulator.carSpotCount + simulator.motorcycleSpotCount)) {
					for (int x = from; x < (to + 1); x++) {
						simulator.ParkingSpotsList.get(x).addTag(currentTag);
					}
					currentTag.Describe();
					OutputTB.setText("Tag "+ currentTag.getDescription() +" Added.");
				} else {
					OutputTB.setText("ERROR invalid car spot number range.");
				}
			}
		});
	}

}