package com.github.marcelocure.sandbox.scala.akka.servicesapp

import akka.actor.Actor

/**
 * Created by Marcelo Cure on 2/25/2015.
 */

case class SearchSync(searchInput: String)
case class SearchAsync(searchInput: String)

class Search extends Actor{
  def searchSync(searchInput:String): Unit ={
    println("Sync Search " + searchInput + "blabalbla")
  }

  def searchAsync(searchInput:String): Unit ={
    println("Async Search " + searchInput + "blabalbla")
  }

  def receive = {
    case SearchSync(searchInput) => searchSync(searchInput)
    case SearchAsync(searchInput) => searchAsync(searchInput)
  }
}
