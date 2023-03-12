package com.github.didahdx.adaniandemoui.data

import com.github.didahdx.adaniandemoui.R
import com.github.didahdx.adaniandemoui.model.*

/**
 * @author Daniel Didah on 4/29/22
 */
object DummyData {

    val sortByItems: ArrayList<String> = ArrayList<String>().apply {
        add("Project progress")
        add("Project name")
        add("Project date")
    }

    val chipItems = listOf<ProjectStatus>(
        ProjectStatus(true, "All", 9),
        ProjectStatus(false, "Pending", 3),
        ProjectStatus(false, "Complete", 5),
        ProjectStatus(false, "In progress", 1),
    )

    val projects = listOf(
        Project(
            0, R.color.spotify_green, R.drawable.spotify_music_logo,
            "Music App", "October 25, Mon 2019", 88,
            listOf(
                R.drawable.alyona_grishina_unsplash,
                R.drawable.emma_lyons_unsplash,
                R.drawable.prince_akachi_unsplash_2,
            )
        ),
        Project(
            1, R.color.red, R.drawable.google_home_emblem,
            "Smart Home App", "December 22, Tue 2019", 55,
            listOf(
                R.drawable.jassir_jonis_unsplash,
                R.drawable.lucas_gouvea_unsplash,
                R.drawable.mateus_campos_unsplash,
            )
        ),
        Project(
            2, R.color.light_blue, R.drawable.google_play_books,
            "G-Books Re-Design", "October 10, Wed 2019", 30,
            listOf(
                R.drawable.mateus_campos_unsplash,
                R.drawable.prince_akachi_unsplash_1,
                R.drawable.alyona_grishina_unsplash,
            )
        )
    )

    val subTaskList = listOf(
        SubTask(0, "Competitive Research", false),
        SubTask(1, "Design Presentation", false),
    )


    val commentsList = listOf(
        CommentMessage(
            0,
            R.drawable.mateus_campos_unsplash,
            "Antonio Tyler",
            "UI Moldboard",
            "Just Now",
            CommentType.IMAGE,
            listOf(
                R.drawable.project_image_1,
                R.drawable.project_image_2,
                R.drawable.project_image_3
            ),
            null
        ),
        CommentMessage(
            1,
            R.drawable.prince_akachi_unsplash_1,
            "Antonio Tyler",
            "Added 2 file",
            "Yesterday",
            CommentType.FILE,
            null,
            listOf(
                File(
                    R.drawable.pdf,
                    "Presentation.pdf",
                    "5MB"
                ),
                File(
                    R.drawable.adobe_illustrator,
                    "Logo.ai",
                    "10MB"
                ),
            )
        ),

        )
}