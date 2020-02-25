//
//  ViewController.swift
//  FinalPlease
//
//  Created by Everrick Wright on 11/30/19.
//  Copyright © 2019 Everrick Wright. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var tagNumber: UITextField!
    @IBOutlet weak var handicap: UITextField!
    @IBOutlet weak var sumbit: UIButton!
    @IBOutlet weak var textView: UITextView!
    @IBOutlet var buttons: [UIButton]!
    @IBOutlet weak var openSpots: UIButton!
    @IBOutlet weak var fullScreen: UIImageView!
    
    var ob: Vehicle!
    var char = ""
    var hand = false
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        tagNumber.delegate = self
        handicap.delegate = self
    }
    @IBAction func reset(_ sender: Any) {
        restartApplication()
    }
    
    func restartApplication () {
               openSpots.isHidden = true
               tagNumber.isHidden = true
               handicap.isHidden = true
               textView.isHidden = true
               sumbit.isHidden = true
        
        tagNumber.text = ""
        handicap.text = ""

    }
    
    @IBAction func handleSelection(_ sender: UIButton) {
        buttons.forEach { (buttons) in buttons.isHidden = !buttons.isHidden}
      
    }
        enum vehicles: String {
            case motercycle = "Motorcycle"
            case car = "Car"
        }
    
    @IBAction func displayParking(_ sender: UIButton) {
        performSegue(withIdentifier: "segue", sender: self)
        
        let p: FacadeParking = FacadeParking()
        
        p.lot?.on()
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
          if (segue.identifier == "segue"){
            let dest: ViewController2 = segue.destination as! ViewController2
              
             print("rEACH")
            dest.make = ob.getMake()
            dest.plateNum = ob.getPlateNum()
            dest.handicap = hand
          }
    
    }
    
    @IBAction func tapped(_ sender: UIButton) {
        
        tagNumber.isHidden = false
        handicap.isHidden = false
        textView.isHidden = false
        sumbit.isHidden = false
        openSpots.isHidden = false
        
        buttons.forEach { (buttons) in buttons.isHidden = true}
          
        
        
        guard let title = sender.currentTitle, let ve = vehicles(rawValue: title) else {
            return
        }
        
        switch ve {
        case .motercycle:
             char = "motorcycle"
            
        case .car:
           
             char = "car"
            }
        
        }
    
    @IBAction func openSpots(_ sender: UIButton) {
        
    
        ob = showSpots()
        
       
       }

    func showSpots() -> Vehicle{
              
                   if char == "car" {
                        
                   
                    
                    print("hi")
                    ob = Car(Make: char, spot: 0, plateNum: tagNumber.text!, Str: handicap.text!)

                    if ob.getHandicap() == "Y" || ob.getHandicap() == "y" {
                        
                        hand = true
                    }
                    else {
                        hand = false
                    }
                    return ob
                   }
                    
                    
                   else {
                    ob = Motorcyle(Make: char, Spot: 0, plateNum: tagNumber.text!, Str: handicap.text!)
                   
                    if ob.getHandicap() == "Y" || ob.getHandicap() == "y" {
                                           
                                           hand = true
                                       }
                            else if ob.getHandicap() == "n" || ob.getHandicap() == "N"{
                                           hand = false
                                       }
                
                    return ob
                   }
    }
    
    
    func createAlert (title:String, message:String){
           
           
             let alert = UIAlertController(title: title, message: message, preferredStyle: UIAlertController.Style.alert)
         
           
             
             alert.addAction(UIAlertAction(title: "Ok", style: UIAlertAction.Style.default, handler: { (action) in alert.dismiss(animated: true, completion: nil)
           
             }))
         
             self.present(alert, animated: true, completion: nil)
         }
    
    
    func shake() {
              let animation = CAKeyframeAnimation(keyPath: "transform.translation.x")
              animation.timingFunction = CAMediaTimingFunction(name: CAMediaTimingFunctionName.linear)
              animation.duration = 0.6
              animation.values = [-20.0, 20.0, -20.0, 20.0, -10.0, 10.0, -5.0, 5.0, 0.0 ]
              fullScreen.layer.add(animation, forKey: "shake")
          }
    
    
    @IBAction func tap(_ sender: UIButton) {
        
        
        if ob.getHandicap() == "Y" || ob.getHandicap() == "y" || ob.getHandicap() == "n" || ob.getHandicap() == "N"{
            

            textView.text = "Tag Number: \(tagNumber.text!)\nHandicap: \(hand)"
            
        }
        else {
        createAlert(title: "Wrong format", message: "Enter either Y for yes or N for no")
        shake()
        return
        
    }
    }

}

extension ViewController : UITextFieldDelegate {
    
    
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        
        return true
    }
}


//start of parkingSpot class
class ParkingSpot{
    var isOpen: Bool = true
    var type: String
    var spotNum: Int
    var array = [ParkingSpotTag]()
    var containedVehicle: Vehicle!
    
    init(type: String, spotNum: Int){
        self.type = type
        self.spotNum = spotNum
    }
   
    func clearSpot() {
        isOpen = true
        containedVehicle = nil
    }
    
    func off() {
        isOpen = false
    }
    
    func getType() -> String {
        return type
    }
    
    func addTag(newTag: ParkingSpotTag!){
        array.append(newTag)
    }
    
    func removeTag(remTag: ParkingSpotTag!){
        array.append(remTag)
    }
    
    func clearChanged(){
        
    }
    
    func setChanged(){
        
    }
} //end of ParkingSpot

protocol ParkingSpotTag { //start of parkingSpotTag
    func getDescription() -> String
} //end


protocol ParkingLot { //start of ParkingLot
    func on()
    func off()
    
}//end

protocol Vehicle {//start of vehicle protocol
    func getType() -> String
    func getMake() -> String
    func getSpot() -> Int
    func getPlateNum() -> String
    func setType(type: String)
    func setMake(make: String)
    func setSpot(spot: Int)
    func setPlateNum(platenum: String)
    func getHandicap() -> String
    func setHandicap(str: String)
    
} //end of vehicle protocol

class Motorcyle: Vehicle {
    
    //start of motercycle class
    var type = "Motorcycle"
    var Make: String
    var Spot: Int
    var plateNum: String
    var Str: String
    
    init(Make: String, Spot: Int, plateNum: String, Str: String){
        self.Make = Make
        self.Spot = Spot
        self.plateNum = plateNum
        self.Str = Str
        
    }
    
    func getHandicap() -> String {
           return Str
       }
       
    func setHandicap(str: String) {
           self.Str = str
       }
    func getType() -> String {
        return type
    }
    
    func getMake() -> String {
        return Make
    }
    
    func getSpot() -> Int {
        return Spot
    }
    
    func getPlateNum() -> String {
        return plateNum
    }
    
    func setType(type: String){
        self.type = type
    }
    
    func setMake(make: String){
        self.Make = make
    }
    
    func setSpot(spot: Int){
        self.Spot = spot
    }
    
    func setPlateNum(platenum: String){
        self.plateNum = platenum
    }
    
}//end of motercycle class


class lot : ParkingLot {//lot start
    func on() {
        print("Lot Open")
    }
    
    func off() {
        print("Lot Clossed")
    }
    
}//end

class FacadeParking {//start of facadeParking
    
    var lot : ParkingLot?
    
    
    }//End of Facade

class Car: Vehicle {
    
    //start of motercycle class
    var type = "Car"
    var Make: String
    var Spot: Int
    var plateNum: String
    var Str: String
    
    init(Make: String, spot: Int, plateNum: String, Str: String){
        self.Make = Make
        self.Spot = spot
        self.plateNum = plateNum
        self.Str = Str
    }
    func getHandicap() -> String {
        return Str
    }
    
    func setHandicap(str: String) {
        self.Str = str
    }
    func getType() -> String {
        return type
    }
    
    func getMake() -> String {
        return Make
    }
    
    func getSpot() -> Int {
        return Spot
    }
    
    func getPlateNum() -> String {
        return plateNum
    }
    
    func setType(type: String){
        self.type = type
    }
    
    func setMake(make: String){
        self.Make = make
    }
    
    func setSpot(spot: Int){
        self.Spot = spot
    }
    
    func setPlateNum(platenum: String){
        self.plateNum = platenum
    }
    
}//end of car class

enum TagType {//start of TagType
    case PROXIMITY, CONSTRAINT
}//End

class TAG_NearLandrum: ParkingSpotTag{
    //start tagNearLandrum
   
    var tagType = TagType.PROXIMITY
    var description = "Near Main Dining Commons"
    
    
    func getDescription() -> String {
        return description
    }
    
}//end

class TAG_NearIT: ParkingSpotTag{
    var tagType = TagType.PROXIMITY
    var description = "Near IT Building"
    
    func getDescription() -> String {
        return description
    }
}

class TAG_NearRac: ParkingSpotTag{
    var tagType = TagType.PROXIMITY
    var description = "Near Rac Building"
    
    func getDescription() -> String {
        return description
    }
}

class TAG_Handicap: ParkingSpotTag{
    var tagType = TagType.CONSTRAINT
    var description = "Handicap Spot"
    
    func getDescription() -> String {
        return description
    }
}

