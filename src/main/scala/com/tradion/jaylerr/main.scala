package com.tradion.jaylerr

import com.tradion.jaylerr.manager.DatabaseExecutor

object main {
  def startUp(): Unit ={
    println(
      """
        |***************************************************
        |**                                               **
        |**  Welcome to Scala with SQL on Slick tutorial  **
        |**                                               **
        |***************************************************
        |""".stripMargin)
  }
  def main(args: Array[String]): Unit = {
    startUp()
    DatabaseExecutor
  }

}