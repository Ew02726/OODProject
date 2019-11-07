import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ParkingLotGUI extends JFrame implements Observer{
	JTextField vType = new JTextField();
	JTextField vMake = new JTextField();
	JTextField vModel = new JTextField();
	JTextField vPlateNum = new JTextField();
	static ArrayList<JButton> vSpotList = new ArrayList<JButton>();
	
	//used for adding action listeners
	static int bIndex;
	
	public void update(Observable o, Object arg) {
		ParkingSpot observed = (ParkingSpot)o;
		int btnIndex = observed.spotNum;
		if (observed.isOpen) {
			vSpotList.get(btnIndex).setBackground(Color.GREEN);
		} else {
			vSpotList.get(btnIndex).setBackground(Color.RED);
		}
	}
	
	
	public ParkingLotGUI() {
		super.setTitle("Parking Lot Availabilities");
		Container mainC = getContentPane();
		this.setBounds(0, 0, 1450, 1040);
		
		//main layout for gui
		mainC.setLayout(new BorderLayout());
		
		//sub panel with 5 columns and dynamic amount of rows
		JPanel btnSubPanel = new JPanel();
		btnSubPanel.setLayout(new GridLayout(0, 5));
		
		//sub panel for text fields and jlabels
		JPanel fieldsSubPanel = new JPanel();
		fieldsSubPanel.setLayout(new BoxLayout(fieldsSubPanel, BoxLayout.Y_AXIS));
		
		//hard coded 100 car lots. can make dynamic if needed
		for (int x = 0; x < 100; x++) {
			JButton newButton = new JButton("cSpot" + x);
			newButton.setBackground(Color.GREEN);
			vSpotList.add(newButton);
		}
		
		//hard coded 20 motorcycle lots. can make dynamic if needed
		for (int x = 100; x < 120; x++) {
			JButton newButton = new JButton("mSpot" + x);
			newButton.setBackground(Color.GREEN);
			vSpotList.add(newButton);
		}
		
		//add action listeners to all buttons. can make dynamic if needed
		for (int x = 0; x < 120; x++) {
			bIndex = x;
			vSpotList.get(x).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton tempButton = (JButton) e.getSource();
					
					String strIndex = tempButton.getText().substring(5);
					
					int intIndex = Integer.parseInt(strIndex);
					
					ParkingSpot tempSpot = simulator.ParkingSpotsList.get(intIndex);
					
					if(tempSpot.containedVehicle == null) {
						vType.setText("");
						vMake.setText("");
						vModel.setText("");
						vPlateNum.setText("");
					} else {
						vType.setText(tempSpot.containedVehicle.getType());
						vMake.setText(tempSpot.containedVehicle.getMake());
						vModel.setText(tempSpot.containedVehicle.getModel());
						vPlateNum.setText(tempSpot.containedVehicle.getPlateNum());
					}
					
					if (tempSpot.ParkingSpotTags.isEmpty()) {
						System.out.println("This spot has no tags.");
					} else {
						System.out.println("This spot has tags:");
						for (int x = 0; x < tempSpot.ParkingSpotTags.size(); x++) {
							String a = tempSpot.ParkingSpotTags.get(x).getDescription();
							System.out.println(a);
						}
						System.out.println();
					}
					
				}
			});
		}
		
		//add buttons to arraylist of box layout JPanels
		for (int x = 0; x < 120; x++) {
			btnSubPanel.add(vSpotList.get(x));
		}
		
		//add text fields and labels to right side of gui
		JLabel vehicleType = new JLabel("Vehicle Type");
		JLabel vehicleMake = new JLabel("Vehicle Make");
		JLabel vehicleModel = new JLabel("Vehicle Model");
		JLabel vehiclePlateNum = new JLabel("Vehicle License Plate Number");
		
		
		fieldsSubPanel.add(vehicleType);
		fieldsSubPanel.add(vType);
		fieldsSubPanel.add(vehicleMake);
		fieldsSubPanel.add(vMake);
		fieldsSubPanel.add(vehicleModel);
		fieldsSubPanel.add(vModel);
		fieldsSubPanel.add(vehiclePlateNum);
		fieldsSubPanel.add(vPlateNum);
		
		//add all the layouts to main layout
		mainC.add(fieldsSubPanel, BorderLayout.EAST);
		mainC.add(btnSubPanel, BorderLayout.CENTER);
		
		//make output text boxes uneditabe
		vType.setEditable(false);
		vMake.setEditable(false);
		vModel.setEditable(false);
		vPlateNum.setEditable(false);
		
	}

}
