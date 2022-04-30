package com.github.didahdx.adaniandemoui.model

/**
 * @author Daniel Didah on 4/28/22
 */
data class Project(
    var id: Int,
    var color: Int,
    var icon: Int,
    var name: String,
    var date: String,
    var progress: Int,
    var userIcons: List<Int>
)
