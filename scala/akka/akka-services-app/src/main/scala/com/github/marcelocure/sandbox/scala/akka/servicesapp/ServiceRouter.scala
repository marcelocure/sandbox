package com.github.marcelocure.sandbox.scala.akka.servicesapp

import akka.actor.{ActorSystem, Props, Actor}

/**
 * Created by Marcelo Cure on 2/25/2015.
 */

case class Message(service:Service, input:String)
sealed trait Service
case class SearchService() extends Service
case class RetrieveService() extends Service

case class MessageRouter(system: ActorSystem){
  val retrieve = system.actorOf(Props[Retrieve], "retrieve")
  val search = system.actorOf(Props[Search], "search")

  def callSearchService(input: String): Unit = {
    input match  {
      case i if i.contains("searchSync") => search ! SearchSync(input)
      case i if i.contains("searchAsync")  => search ! SearchAsync(input)
    }
  }

  def callRetrieveService(input: String): Unit = {
    input match {
      case i if i.contains("retrieveTrial") => retrieve ! RetrieveTrial(input)
      case i if i.contains("retrievePatentFamily")  => retrieve ! RetrievePatentFamily(input)
    }
  }

  def sendMessage(message: Message) = {
    message.service match {
      case SearchService() => callSearchService(message.input)
      case RetrieveService() => callRetrieveService(message.input)
      case _ => println("invalid message")
    }
  }
}