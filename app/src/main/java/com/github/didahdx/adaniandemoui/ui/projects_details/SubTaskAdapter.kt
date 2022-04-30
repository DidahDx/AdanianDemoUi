package com.github.didahdx.adaniandemoui.ui.projects_details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.didahdx.adaniandemoui.databinding.ItemSubtaskBinding
import com.github.didahdx.adaniandemoui.model.SubTask

/**
 * @author Daniel Didah on 4/30/22
 */
class SubTaskAdapter : ListAdapter<SubTask, SubTaskAdapter.SubTaskViewHolder>(SubTaskDiffUtil()) {

    inner class SubTaskViewHolder(private val binding: ItemSubtaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(subTask: SubTask) {
            binding.cbSubtask.text = subTask.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubTaskViewHolder {
        val binding = ItemSubtaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubTaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubTaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class SubTaskDiffUtil : DiffUtil.ItemCallback<SubTask>() {
    override fun areItemsTheSame(oldItem: SubTask, newItem: SubTask): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SubTask, newItem: SubTask): Boolean {
        return oldItem == newItem
    }

}
