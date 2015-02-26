package com.github.marcelocure.sandbox.scala.akka.servicesapp

import akka.actor.Actor

/**
 * Created by Marcelo Cure on 2/25/2015.
 */

case class RetrieveTrial(retrieveTrialInput: String)
case class RetrievePatentFamily(retrievePatentFamilyInput: String)

class Retrieve extends Actor{
  def retrieveTrial(retrieveTrialInput:String): Unit ={
    println("Trial" + retrieveTrialInput + "blabalbla")
  }

  def retrievePatentFamily(retrievePatentFamilyInput:String): Unit ={
    println("Patent Family" + retrievePatentFamilyInput + "blabalbla")
  }

  def receive = {
    case RetrieveTrial(retrieveTrialInput) => retrieveTrial(retrieveTrialInput)
    case RetrievePatentFamily(retrievePatentFamilyInput) => retrievePatentFamily(retrievePatentFamilyInput)
  }
}
