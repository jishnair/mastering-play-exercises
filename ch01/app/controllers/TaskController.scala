package controllers

import models.Task
import play.api.mvc.{Action, Controller}


/**
  * Created by jishnair on 24/01/2017.
  */


class TaskController extends Controller {

  def index = Action {
    Redirect(routes.TaskController.tasks)
  }

  def tasks = Action {
    Ok(views.html.index(Task.all))
  }

  def newTask=Action(parse.urlFormEncoded){
    implicit request =>
      Task.add(request.body.get("taskName").get.head)

      Redirect(routes.TaskController.index)
  }

  def deleteTask(id: Int)=Action{

    Task.delete(id)
    Ok
  }


}
