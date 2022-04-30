package com.github.didahdx.adaniandemoui.ui.projects_details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.didahdx.adaniandemoui.databinding.ItemCommentsBinding
import com.github.didahdx.adaniandemoui.extension.hide
import com.github.didahdx.adaniandemoui.extension.show
import com.github.didahdx.adaniandemoui.model.CommentMessage
import com.github.didahdx.adaniandemoui.model.CommentType

/**
 * @author Daniel Didah on 4/30/22
 */
class CommentAdapter :
    ListAdapter<CommentMessage, CommentAdapter.CommentAdapterViewHolder>(CommentDiffUtil()) {

    inner class CommentAdapterViewHolder(private val binding: ItemCommentsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(commentMessage: CommentMessage) {
            binding.tvUsername.text = commentMessage.userName
            binding.tvDescription.text = commentMessage.description
            binding.tvDate.text = commentMessage.commentDate

            Glide.with(binding.root.context)
                .load(commentMessage.userImage)
                .centerCrop()
                .into(binding.ivUser)

            if (commentMessage.typeOfComment == CommentType.FILE) {
                binding.llImages.hide()
                binding.groupFile.show()

                Glide.with(binding.root.context)
                    .load(commentMessage.files?.get(0)?.image)
                    .centerCrop()
                    .into(binding.ivPdf)
                binding.tvPdfName.text = commentMessage.files?.get(0)?.name
                binding.tvPdfSize.text = commentMessage.files?.get(0)?.size

                Glide.with(binding.root.context)
                    .load(commentMessage.files?.get(1)?.image)
                    .centerCrop()
                    .into(binding.ivAi)
                binding.tvAiName.text = commentMessage.files?.get(1)?.name
                binding.tvAiSize.text = commentMessage.files?.get(1)?.size


            } else {
                binding.groupFile.hide()
                binding.llImages.show()
                Glide.with(binding.root.context)
                    .load(commentMessage.images?.get(0))
                    .centerCrop()
                    .into(binding.ivImage1)

                Glide.with(binding.root.context)
                    .load(commentMessage.images?.get(1))
                    .centerCrop()
                    .into(binding.ivImage2)

                Glide.with(binding.root.context)
                    .load(commentMessage.images?.get(2))
                    .centerCrop()
                    .into(binding.ivImage3)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentAdapterViewHolder {
        val binding = ItemCommentsBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return CommentAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentAdapterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}


class CommentDiffUtil : DiffUtil.ItemCallback<CommentMessage>() {
    override fun areItemsTheSame(oldItem: CommentMessage, newItem: CommentMessage): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CommentMessage, newItem: CommentMessage): Boolean {
        return oldItem == newItem
    }

}