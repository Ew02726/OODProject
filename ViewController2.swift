//
//  ViewController2.swift
//  FinalPlease
//
//  Created by Everrick Wright on 12/1/19.
//  Copyright © 2019 Everrick Wright. All rights reserved.
//

import UIKit

class ViewController2: UIViewController {

    @IBAction func close() {
        dismiss(animated: true, completion: nil)
    }
    
    @IBOutlet weak var A1: UIButton!
    @IBOutlet weak var A2: UIButton!
    @IBOutlet weak var A3: UIButton!
    
    @IBOutlet weak var A4: UIButton!
    @IBOutlet weak var A5: UIButton!
    @IBOutlet weak var A6: UIButton!
    
    @IBOutlet weak var B1: UIButton!
    @IBOutlet weak var B2: UIButton!
    @IBOutlet weak var B3: UIButton!
    @IBOutlet weak var B4: UIButton!
    @IBOutlet weak var B5: UIButton!
    @IBOutlet weak var B6: UIButton!
    @IBOutlet weak var fullScreen: UIImageView!
    
    
    @IBOutlet weak var Reserve: UIButton!
    
    var make: String!
    var plateNum: String!
    var handicap: Bool!
    
    
    var spot: String = ""
    
    @IBAction func A1tapped(_ sender: Any) {
        spot = "A1"
    }
    @IBAction func A2tapped(_ sender: Any) {
        spot = "A2"
    }
    @IBAction func A3(_ sender: Any) {
        spot = "A3"
    }
    @IBAction func A4(_ sender: Any) {
        spot = "A4"
    }
    @IBAction func A5tapped(_ sender: Any) {
        spot = "A5"
    }
    
    @IBAction func A6tapped(_ sender: Any) {
        spot = "A6"
    }
    
    @IBAction func B1tapped(_ sender: Any) {
        spot = "B1"
    }
    @IBAction func B2tapped(_ sender: Any) {
        spot = "B2"
    }
    @IBAction func B3tapped(_ sender: Any) {
        spot = "B3"
    }
    @IBAction func B4tapped(_ sender: Any) {
        
        spot = "B4"
        shake()
        createAlert(title: "Reserved Spot!", message: "This spot is already taken!")
    }
    @IBAction func B5tapped(_ sender: Any) {
        spot = "B5"
    }
    @IBAction func B6tapped(_ sender: Any) {
        spot = "B6"
        
        
    }
    
    var v: Vehicle!
    var checked = false
    var checked2 = false
    var checked3 = false
    var arr: Car!
    
    
    func shake() {
        let animation = CAKeyframeAnimation(keyPath: "transform.translation.x")
        animation.timingFunction = CAMediaTimingFunction(name: CAMediaTimingFunctionName.linear)
        animation.duration = 0.6
        animation.values = [-20.0, 20.0, -20.0, 20.0, -10.0, 10.0, -5.0, 5.0, 0.0 ]
        fullScreen.layer.add(animation, forKey: "shake")
    }
    
    //handicap buttons
    @IBAction func tapped(_ sender: UIButton) {
        
        if handicap == false {
            shake()
            createAlert(title: "Wrong Spot!", message: "This is a handicap spot, you may not park here!")
            return
        }
        
        
       
     if checked {
        
        sender.setImage( UIImage(named:"blue.png"), for: .normal)
           checked = false
        Reserve.isHidden = true
       }
        else{
   
           sender.setImage(UIImage(named:"red.png"), for: .normal)
           checked = true
        Reserve.isHidden = false
       
    }
    }
    //motorcycle buttons
    
    @IBAction func reserve(_ sender: UIButton) {
        
        
      performSegue(withIdentifier: "segue2", sender: self)
        
        
    }

    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
          if (segue.identifier == "segue2"){
            let dest: ViewController3 = segue.destination as! ViewController3
        
            dest.spot = self.spot
            dest.make = self.make
            dest.plateNum = self.plateNum
            dest.handicap = self.handicap
          }
    
    }
    var change: Bool!
    
    @IBAction func tappedMotorcycle(_ sender: UIButton) {
        
        if make != "motorcycle"{
            shake()
            createAlert(title: "Wrong Spot!", message: "This is a motorcyle spot, you may not park here!")
            return
        }
        
        if checked2 {
               sender.setImage( UIImage(named:"green.png"), for: .normal)
                  checked2 = false
            Reserve.isHidden = true
              } else {
                  sender.setImage(UIImage(named:"red.png"), for: .normal)
                  checked2 = true
            Reserve.isHidden = false
              }
    }
        
    //car buttons
    @IBAction func tappedCar(_ sender: UIButton) {
        
        if make == "motorcycle" {
        
            createAlert(title: "Adapt?", message: "This is a Car spot, but can be adapted for a motorcycle")

            if checked2 {
                          sender.setImage( UIImage(named:"gold.png"), for: .normal)
                             checked2 = false
                       Reserve.isHidden = true
                         }
            else {
                             sender.setImage(UIImage(named:"purple.png"), for: .normal)
                             checked2 = true
                       Reserve.isHidden = false
                         }
        }
        if make == "car" {
           
            if checked2 {
                          sender.setImage( UIImage(named:"gold.png"), for: .normal)
                             checked2 = false
                       Reserve.isHidden = true
                         }
            else {
                             sender.setImage(UIImage(named:"red.png"), for: .normal)
                             checked2 = true
                       Reserve.isHidden = false
                         }
        }
        
    }
    
    func createAlert (title:String, message:String){
        
        
          let alert = UIAlertController(title: title, message: message, preferredStyle: UIAlertController.Style.alert)
      
        
          
          alert.addAction(UIAlertAction(title: "Ok", style: UIAlertAction.Style.default, handler: { (action) in alert.dismiss(animated: true, completion: nil)
        
          }))
      
          self.present(alert, animated: true, completion: nil)
      }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    
    func incom(vehicle: Car){
        if vehicle.getHandicap() == "y" || vehicle.getHandicap() == "Y" {
            
        }
    }

}
