package com.github.marcelocure.sandbox.scala.akka.servicesapp

import akka.actor.ActorSystem
object ServicesApp extends App {

  val system = ActorSystem("system")
  run()

  def run(): Unit ={
    val router = MessageRouter(system)
    router.sendMessage(Message(SearchService(), "search input for searchSync"))
    router.sendMessage(Message(RetrieveService(), "retrieve input retrieveTrial"))
    system.shutdown()
  }
}