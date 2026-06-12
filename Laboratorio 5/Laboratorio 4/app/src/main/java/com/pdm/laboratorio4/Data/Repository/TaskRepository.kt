package com.pdm.laboratorio4.Data.Repository

import com.pdm.laboratorio4.Data.Database.TaskDAO
import com.pdm.laboratorio4.Model.Task
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDAO: TaskDAO) {

val allTasks: Flow<List<Task>> = taskDAO.getAllTasks()

    suspend fun insertTask(task: Task) = taskDAO.insertTask(task)

    suspend fun deleteTask(task: Task) = taskDAO.deleteTask(task)

    suspend fun updateTask(task: Task) = taskDAO.updateTask(task)

}