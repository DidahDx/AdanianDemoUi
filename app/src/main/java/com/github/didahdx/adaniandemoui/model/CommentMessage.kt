package com.github.didahdx.adaniandemoui.model

/**
 * @author Daniel Didah on 4/30/22
 */
data class CommentMessage(
    var id: Int,
    var userImage: Int,
    var userName: String,
    var description: String,
    var commentDate: String,
    var typeOfComment: CommentType,
    var images: List<Int>?,
    var files: List<File>?
)

enum class CommentType {
    IMAGE, FILE
}