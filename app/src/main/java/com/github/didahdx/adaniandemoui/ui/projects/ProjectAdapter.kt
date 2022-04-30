package com.github.didahdx.adaniandemoui.ui.projects

import android.R
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.didahdx.adaniandemoui.databinding.ItemProjectBinding
import com.github.didahdx.adaniandemoui.model.Project
import com.github.didahdx.adaniandemoui.util.ColorUtil


/**
 * @author Daniel Didah on 4/28/22
 */
class ProjectAdapter(private val clickListener: OnItemClickListener) : ListAdapter<Project, ProjectAdapter.ProjectViewHolder>(ProjectDiffUtil()) {

    inner class ProjectViewHolder(val binding: ItemProjectBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init{
            binding.apply {
                root.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION){
                        clickListener.onItemClick(getItem(position))
                    }
                }
            }
        }

        fun bind(project: Project) {
            binding.tvTitle.text = project.name
            binding.tvDate.text = project.date
            binding.tvDate.setTextColor(ContextCompat.getColor(binding.root.context,project.color))
            Glide.with(binding.root.context)
                .load(project.icon)
                .centerCrop()
                .into(binding.ivIcon)

            Glide.with(binding.root.context)
                .load(project.userIcons[0])
                .centerCrop()
                .into(binding.ivUser1)

            Glide.with(binding.root.context)
                .load(project.userIcons[1])
                .centerCrop()
                .into(binding.ivUser2)

            val colors = IntArray(2)
            colors[1] = ContextCompat.getColor(binding.root.context,project.color)
            colors[0] = ColorUtil.manipulateColor(ContextCompat.getColor(binding.root.context,project.color),2.5f)
            binding.ivProgress.colors = colors


            val stats = FloatArray(2)
            stats[0] = 100F
            stats[1] = project.progress.toFloat()
            binding.ivProgress.stats = stats
            binding.ivProgress.setStartAnimationDuration(4000)
            binding.ivProgress.text = project.progress.toString() + "%"
            binding.ivProgress.textColor = R.color.black
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val binding = ItemProjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

interface OnItemClickListener {
    fun onItemClick(project: Project)
}

class ProjectDiffUtil : DiffUtil.ItemCallback<Project>() {
    override fun areItemsTheSame(oldItem: Project, newItem: Project): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Project, newItem: Project): Boolean {
        return oldItem == newItem
    }

}