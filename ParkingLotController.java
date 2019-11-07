import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ParkingLotController extends JFrame {

	private JPanel contentPane;
	private JTextField lotNumberTB;
	private JTextField vMakeTB;
	private JTextField vModelTB;
	private JTextField vPlateNumTB;
	private JTextField outputTB;
	private JTextField vTypeTB;

	public ParkingLotController() {
		
		//creating the GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1450, 0, 470, 365);
		super.setTitle("Parking Lot Controller");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {144, 115, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Lot Number");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		lotNumberTB = new JTextField();
		GridBagConstraints gbc_lotNumberTB = new GridBagConstraints();
		gbc_lotNumberTB.anchor = GridBagConstraints.WEST;
		gbc_lotNumberTB.insets = new Insets(0, 0, 5, 5);
		gbc_lotNumberTB.gridx = 0;
		gbc_lotNumberTB.gridy = 1;
		contentPane.add(lotNumberTB, gbc_lotNumberTB);
		lotNumberTB.setColumns(10);
		
		JButton btnSetOpen = new JButton("Set Open");
		GridBagConstraints gbc_btnSetOpen = new GridBagConstraints();
		gbc_btnSetOpen.insets = new Insets(0, 0, 5, 5);
		gbc_btnSetOpen.gridx = 2;
		gbc_btnSetOpen.gridy = 1;
		contentPane.add(btnSetOpen, gbc_btnSetOpen);
		
		JLabel lblVehicleType = new JLabel("Vehicle Type");
		GridBagConstraints gbc_lblVehicleType = new GridBagConstraints();
		gbc_lblVehicleType.anchor = GridBagConstraints.WEST;
		gbc_lblVehicleType.insets = new Insets(0, 0, 5, 5);
		gbc_lblVehicleType.gridx = 0;
		gbc_lblVehicleType.gridy = 2;
		contentPane.add(lblVehicleType, gbc_lblVehicleType);
		
		vTypeTB = new JTextField();
		GridBagConstraints gbc_vehicleTypeTB = new GridBagConstraints();
		gbc_vehicleTypeTB.anchor = GridBagConstraints.WEST;
		gbc_vehicleTypeTB.insets = new Insets(0, 0, 5, 5);
		gbc_vehicleTypeTB.gridx = 0;
		gbc_vehicleTypeTB.gridy = 3;
		contentPane.add(vTypeTB, gbc_vehicleTypeTB);
		vTypeTB.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Vehicle Make");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		vMakeTB = new JTextField();
		GridBagConstraints gbc_carMakeTB = new GridBagConstraints();
		gbc_carMakeTB.insets = new Insets(0, 0, 5, 5);
		gbc_carMakeTB.anchor = GridBagConstraints.WEST;
		gbc_carMakeTB.gridx = 0;
		gbc_carMakeTB.gridy = 5;
		contentPane.add(vMakeTB, gbc_carMakeTB);
		vMakeTB.setColumns(10);
		
		JButton btnSetClosed = new JButton("Set Closed");
		GridBagConstraints gbc_btnSetClosed = new GridBagConstraints();
		gbc_btnSetClosed.insets = new Insets(0, 0, 5, 5);
		gbc_btnSetClosed.gridx = 2;
		gbc_btnSetClosed.gridy = 5;
		contentPane.add(btnSetClosed, gbc_btnSetClosed);
		
		JLabel lblNewLabel_2 = new JLabel("Vehicle Model");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 6;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		vModelTB = new JTextField();
		GridBagConstraints gbc_carModelTB = new GridBagConstraints();
		gbc_carModelTB.insets = new Insets(0, 0, 5, 5);
		gbc_carModelTB.anchor = GridBagConstraints.WEST;
		gbc_carModelTB.gridx = 0;
		gbc_carModelTB.gridy = 7;
		contentPane.add(vModelTB, gbc_carModelTB);
		vModelTB.setColumns(10);
		
		JLabel lblCarYear = new JLabel("Vehicle License Plate Number");
		GridBagConstraints gbc_lblCarYear = new GridBagConstraints();
		gbc_lblCarYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblCarYear.anchor = GridBagConstraints.WEST;
		gbc_lblCarYear.gridx = 0;
		gbc_lblCarYear.gridy = 8;
		contentPane.add(lblCarYear, gbc_lblCarYear);
		
		vPlateNumTB = new JTextField();
		GridBagConstraints gbc_carYearTB = new GridBagConstraints();
		gbc_carYearTB.insets = new Insets(0, 0, 5, 5);
		gbc_carYearTB.anchor = GridBagConstraints.WEST;
		gbc_carYearTB.gridx = 0;
		gbc_carYearTB.gridy = 9;
		contentPane.add(vPlateNumTB, gbc_carYearTB);
		vPlateNumTB.setColumns(10);
		
		JButton btnEdit = new JButton("Edit Vehicle");
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 5, 5);
		gbc_btnEdit.gridx = 2;
		gbc_btnEdit.gridy = 9;
		contentPane.add(btnEdit, gbc_btnEdit);
		
		outputTB = new JTextField();
		outputTB.setEditable(false);
		GridBagConstraints gbc_outputTB = new GridBagConstraints();
		gbc_outputTB.gridwidth = 4;
		gbc_outputTB.fill = GridBagConstraints.HORIZONTAL;
		gbc_outputTB.gridx = 0;
		gbc_outputTB.gridy = 11;
		contentPane.add(outputTB, gbc_outputTB);
		outputTB.setColumns(10);
		
		//Action Listeners
		//Button to open up a car spot
		btnSetOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int lotNum = Integer.parseInt(lotNumberTB.getText());
					
					if (lotNum < (simulator.carSpotCount + simulator.motorcycleSpotCount) && lotNum >= 0) {
						if (simulator.ParkingSpotsList.get(lotNum).isOpen) {
							outputTB.setText("ERROR: Spot already open.");
						} else {
							simulator.ParkingSpotsList.get(lotNum).clearSpot();
							outputTB.setText("Spot opened.");
							
							//notify observers that the spot has changed
							simulator.ParkingSpotsList.get(lotNum).setChanged();
							simulator.ParkingSpotsList.get(lotNum).notifyObservers();
						}
					} else {
						outputTB.setText("ERROR: Spot number out of range.");
					}
				} catch(NumberFormatException NFE){
					outputTB.setText("ERROR: Invalid spot number.");
				}
			}
		});
		
		//Button to close a car spot and take the information from the text boxes as variable values for parking spot
		btnSetClosed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int lotNum = Integer.parseInt(lotNumberTB.getText());
					
					if (lotNum < (simulator.carSpotCount + simulator.motorcycleSpotCount) && lotNum >= 0) {
						if (simulator.ParkingSpotsList.get(lotNum).isOpen) {
							if ((simulator.ParkingSpotsList.get(lotNum).type.equals(vTypeTB.getText()) || vTypeTB.getText().equals("Motorcycle"))
									&& lotNum < simulator.carSpotCount) {
								
								if (vTypeTB.getText().equals("Car")) {
									Car newCar = new Car(vMakeTB.getText(), vModelTB.getText(), vPlateNumTB.getText());
									simulator.ParkingSpotsList.get(lotNum).containedVehicle = newCar;
								} else {
									Motorcycle newMotorcycle = new Motorcycle(vMakeTB.getText(), vModelTB.getText(), vPlateNumTB.getText());
									simulator.ParkingSpotsList.get(lotNum).containedVehicle = newMotorcycle;
								}
								
								simulator.ParkingSpotsList.get(lotNum).off();
								
								outputTB.setText("Vehicle placed in spot.");
								
								//notify observers that the spot has changed
								simulator.ParkingSpotsList.get(lotNum).setChanged();
								simulator.ParkingSpotsList.get(lotNum).notifyObservers();
								
							} else if (simulator.ParkingSpotsList.get(lotNum).type.equals(vTypeTB.getText()) && lotNum >= simulator.carSpotCount
									&& lotNum < (simulator.motorcycleSpotCount + simulator.carSpotCount)) {
								
								Motorcycle newMotorcycle = new Motorcycle(vMakeTB.getText(), vModelTB.getText(), vPlateNumTB.getText());
								
								simulator.ParkingSpotsList.get(lotNum).containedVehicle = newMotorcycle;
								
								simulator.ParkingSpotsList.get(lotNum).off();
								
								outputTB.setText("Vehicle placed in spot.");
								
								//notify observers that the spot has changed
								simulator.ParkingSpotsList.get(lotNum).setChanged();
								simulator.ParkingSpotsList.get(lotNum).notifyObservers();
								
							} else {
								outputTB.setText("ERROR: Vehicle and spot type mismatch.");
							}
						} else {
							outputTB.setText("ERROR: Spot already closed.");
						}
					} else {
						outputTB.setText("ERROR: Spot number out of range.");
					}
				} catch(NumberFormatException NFE) {
					outputTB.setText("ERROR: Invalid spot number.");
				}
			}
		});
		
		//Button to just edit the variables of the parking spot with the values of the text boxes.
		//THIS WILL IGNORE VEHICLE TYPE SO YOU CAN'T EDIT THE TYPE OF THE VEHICLE ALREADY IN THE SPOT
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int lotNum = Integer.parseInt(lotNumberTB.getText());
					
					if (lotNum < (simulator.carSpotCount + simulator.motorcycleSpotCount) && lotNum >= 0) {
						if (simulator.ParkingSpotsList.get(lotNum).isOpen) {
							outputTB.setText("ERROR: No car in spot.");
						} else {
							if ((simulator.ParkingSpotsList.get(lotNum).type.equals(vTypeTB.getText()) || vTypeTB.getText().equals("Motorcycle"))
									&& lotNum < simulator.carSpotCount) {
								
								if (vTypeTB.getText().equals("Car")) {
									Car newCar = new Car(vMakeTB.getText(), vModelTB.getText(), vPlateNumTB.getText());
									simulator.ParkingSpotsList.get(lotNum).containedVehicle = newCar;
								} else {
									Motorcycle newMotorcycle = new Motorcycle(vMakeTB.getText(), vModelTB.getText(), vPlateNumTB.getText());
									simulator.ParkingSpotsList.get(lotNum).containedVehicle = newMotorcycle;
								}
								
								outputTB.setText("Vehicle edited.");
								
								//notify observers that the spot has changed
								simulator.ParkingSpotsList.get(lotNum).setChanged();
								simulator.ParkingSpotsList.get(lotNum).notifyObservers();
								
							} else if (simulator.ParkingSpotsList.get(lotNum).type.equals(vTypeTB.getText()) && lotNum >= simulator.carSpotCount
									&& lotNum < (simulator.motorcycleSpotCount + simulator.carSpotCount)) {
								
								if (vTypeTB.getText().equals("Car")) {
									Car newCar = new Car(vMakeTB.getText(), vModelTB.getText(), vPlateNumTB.getText());
									simulator.ParkingSpotsList.get(lotNum).containedVehicle = newCar;
								} else {
									Motorcycle newMotorcycle = new Motorcycle(vMakeTB.getText(), vModelTB.getText(), vPlateNumTB.getText());
									simulator.ParkingSpotsList.get(lotNum).containedVehicle = newMotorcycle;
								}
								
								outputTB.setText("Vehicle edited.");
								
								//notify observers that the spot has changed
								simulator.ParkingSpotsList.get(lotNum).setChanged();
								simulator.ParkingSpotsList.get(lotNum).notifyObservers();
								
							} else {
								outputTB.setText("ERROR: Vehicle and spot type mismatch.");
							}
						}
					} else {
						outputTB.setText("ERROR: Spot number out of range.");
					}
				} catch(NumberFormatException NFE) {
					outputTB.setText("ERROR: Invalid spot number.");
				}
			}
		});
	}
	

}