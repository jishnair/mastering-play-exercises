package models

/**
  * Created by jishnair on 25/01/2017.
  */
case class Task(id: Int, name: String)

object Task {

  private var taskList: List[Task] = List(Task(1,"t"))

  def all: List[Task] = taskList

  def add(taskName: String) = {
    val newId=taskList.last.id+1
    taskList = taskList ++ List(Task(newId, taskName))
  }

  def delete(taskId: Int) = taskList.filterNot(task => taskId == task.id)
}
