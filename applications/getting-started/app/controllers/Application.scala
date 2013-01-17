package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
    Ok("This is our first Play application. And it is written in Scala")
  }
  
}