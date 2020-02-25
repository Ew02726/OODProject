//
//  ViewController3.swift
//  FinalPlease
//
//  Created by Everrick Wright on 12/2/19.
//  Copyright © 2019 Everrick Wright. All rights reserved.
//

import UIKit

class ViewController3: UIViewController {

    var spot: String!
    var make: String!
    var plateNum: String!
    var handicap: Bool!
    @IBOutlet weak var editTagNumber: UITextField!
    @IBOutlet weak var editHandicap: UITextField!
    @IBOutlet weak var textView: UITextView!
    @IBOutlet weak var send: UIButton!
    @IBOutlet weak var updateVehicle: UIButton!
    @IBOutlet var fullscreen: UIView!
    
    
    @IBAction func Update(_ sender: UIButton) {
        editTagNumber.isHidden = false
        editHandicap.isHidden = false
        updateVehicle.isHidden = true
        send.isHidden = false
        
        self.send(sender)
    }
    @IBAction func send(_ sender: UIButton) {
        
        if(editHandicap.text == "Y" || editHandicap.text == "y"){
            handicap = true
        }
        
        else {
            handicap = false
        }
        
        if(editTagNumber.text == ""){
            
        }
        else{
            plateNum = editTagNumber.text
        }
    }
    
    var c1: Car!
    override func viewDidLoad() {
        super.viewDidLoad()
       
    }
    @IBAction func close() {
           dismiss(animated: true, completion: nil)
       }

    
    @IBAction func display(_ sender: UIButton) {
        
        if handicap == false && spot == "A1" || handicap == false && spot == "A2" || handicap == false && spot == "A3" {
            shake()
           createAlert(title: "Wrong Spot!", message: "This is a handicap spot, you may not park here!")
            
        }
        else {
        textView.text = "Tag Number: \(plateNum ?? "default")\nParking Spot: \(spot ?? "default")\nVehicle Type: \(make ?? "default")\nHandicap: \(handicap ?? false)"
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
           fullscreen.layer.add(animation, forKey: "shake")
       }
}

