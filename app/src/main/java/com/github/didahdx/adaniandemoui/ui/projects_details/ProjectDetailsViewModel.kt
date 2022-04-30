package com.github.didahdx.adaniandemoui.ui.projects_details

import androidx.lifecycle.ViewModel
import com.github.didahdx.adaniandemoui.model.Project
import com.github.didahdx.adaniandemoui.util.DummyData

class ProjectDetailsViewModel : ViewModel() {

    val commentList = DummyData.commentsList
    val subTasks = DummyData.subTaskList

    fun getProjectById(projectId:Int): Project?{
       return DummyData.projects.find { project -> project.id == projectId  }
    }

}