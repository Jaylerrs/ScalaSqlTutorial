package com.tradion.jaylerr.components

import com.tradion.jaylerr.connection.DBComponent
import com.tradion.jaylerr.model.{Users, UsersTable}

import scala.concurrent.Future


trait UsersComponent$ extends UsersTable {

  this: DBComponent =>
  import driver.api._

  def create = db.run(usersTableQuery.schema.create)

  def insert(user: Users) = db run {
    usersTableQuery += user
  }

  def delete(mail: String) = {
    val query = usersTableQuery.filter(x => x.email === mail).delete
    db.run(query)
  }

  def getAll : Future[List[Users]] = db run {
    usersTableQuery.to[List].result
  }

  def sortByUsersName() {
    val sortedNames = usersTableQuery.sortBy(x => x.name)
    println(sortedNames)
  }

  def getMember : Future[List[Users]] = db run {
    usersTableQuery.sortBy(x => x.name).to[List].result
  }
}


object UsersComponent$ extends UsersComponent$