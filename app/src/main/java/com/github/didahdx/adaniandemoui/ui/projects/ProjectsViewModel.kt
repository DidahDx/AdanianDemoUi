package com.github.didahdx.adaniandemoui.ui.projects

import androidx.lifecycle.ViewModel
import com.github.didahdx.adaniandemoui.util.DummyData

class ProjectsViewModel : ViewModel() {

    val sortByItems: ArrayList<String> = DummyData.sortByItems
    val chipItems = DummyData.chipItems

    val projects = DummyData.projects

}