package com.github.didahdx.adaniandemoui.util

import com.github.didahdx.adaniandemoui.R
import com.github.didahdx.adaniandemoui.model.Project
import com.github.didahdx.adaniandemoui.model.ProjectStatus

/**
 * @author Daniel Didah on 4/29/22
 */
object DummyData {

    val sortByItems: ArrayList<String> = ArrayList<String>().apply{
        add("Project progress")
        add("Project name")
        add("Project date")
    }
    val chipItems = listOf<ProjectStatus>(
        ProjectStatus(true,"All",9),
        ProjectStatus(false,"Pending",3),
        ProjectStatus(false,"Complete",5),
        ProjectStatus(false,"In progress",1),
    )

    val projects = listOf<Project>(
        Project(0, R.color.spotify_green, R.drawable.spotify_music_logo,
            "Music App","October 25, Mon 2019",88,
            listOf(
                R.drawable.alyona_grishina_unsplash,
                R.drawable.emma_lyons_unsplash,
                R.drawable.prince_akachi_unsplash_2,
            )),
        Project(1, R.color.red, R.drawable.google_home_emblem,
            "Smart Home App","December 22, Tue 2019",55,
            listOf(
                R.drawable.jassir_jonis_unsplash,
                R.drawable.lucas_gouvea_unsplash,
                R.drawable.mateus_campos_unsplash,
            )),
        Project(2, R.color.light_blue, R.drawable.google_play_books,
            "G-Books Re-Design","October 10, Wed 2019",30,
            listOf(
                R.drawable.mateus_campos_unsplash,
                R.drawable.prince_akachi_unsplash_1,
                R.drawable.alyona_grishina_unsplash,
            ))
    )
}