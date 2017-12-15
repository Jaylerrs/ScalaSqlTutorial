package com.tradion.jaylerr.manager

import com.tradion.jaylerr.components.{UsersComponent$}
import com.tradion.jaylerr.model.{Users}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object DatabaseExecutor extends App {
  println(
    """
      |***************************************************
      |**                                               **
      |**  Welcome to Scala with SQL on Slick tutorial  **
      |**                                               **
      |***************************************************
      |""".stripMargin)

  println("Starting on users . . .")
  UsersComponent$.create
  UsersComponent$.insert(Users(4, "email1@email.com", "email1", "01012017"))
  UsersComponent$.insert(Users(5, "email2@email.com", "email2", "02012017"))
  UsersComponent$.insert(Users(6, "email3@email.com", "email3", "03012017"))

  UsersComponent$.sortByUsersName()
  val res = Await.result(UsersComponent$.getAll, Duration.Inf)
  println("The users data : " + res)

  val res2 = Await.result(UsersComponent$.getMember, Duration.Inf)
  println("The sorted data : " + res2)

  Thread.sleep(1000)
}
