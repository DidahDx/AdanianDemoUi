package com.github.didahdx.adaniandemoui.ui.projects

import androidx.lifecycle.ViewModel
import com.github.didahdx.adaniandemoui.data.DummyData

class ProjectsViewModel : ViewModel() {

    val sortByItems: ArrayList<String> = DummyData.sortByItems
    val chipItems = DummyData.chipItems

    val projects = DummyData.projects

}