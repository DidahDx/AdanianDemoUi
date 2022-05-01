package com.github.didahdx.adaniandemoui.ui.projects_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.github.didahdx.adaniandemoui.R
import com.github.didahdx.adaniandemoui.databinding.ProjectDetailsFragmentBinding
import com.github.didahdx.adaniandemoui.model.Project
import com.github.didahdx.adaniandemoui.util.ColorUtil


class ProjectDetailsFragment : Fragment() {

    companion object {
        const val PROJECT_ID = "projectId"
    }

    private lateinit var viewModel: ProjectDetailsViewModel

    private var _binding: ProjectDetailsFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ProjectDetailsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ProjectDetailsFragmentBinding.inflate(inflater, container, false)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val linearLayoutManagerSubtask =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val commentAdapter = CommentAdapter()
        val subTaskAdapter = SubTaskAdapter()
        val itemDecoration = DividerItemDecoration(
            requireContext(),
            DividerItemDecoration.VERTICAL
        )

        binding.apply {
            rvComments.adapter = commentAdapter
            rvComments.layoutManager = linearLayoutManager
            rvComments.addItemDecoration(itemDecoration)

            rvSubtask.adapter = subTaskAdapter
            rvSubtask.layoutManager = linearLayoutManagerSubtask
        }
        commentAdapter.submitList(viewModel.commentList)
        subTaskAdapter.submitList(viewModel.subTasks)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivBackButton.setOnClickListener { findNavController().navigateUp() }
        val project = viewModel.getProjectById(arguments?.getInt(PROJECT_ID)!!)
        project?.let { setUpBanner(it) }
    }

    private fun setUpBanner(project: Project) {
        binding.tvDate.text = project.date
        binding.tvDate.setTextColor(ContextCompat.getColor(binding.root.context, project.color))
        binding.tvTitle.text = project.name

        Glide.with(binding.root.context)
            .load(project.userIcons[0])
            .centerCrop()
            .into(binding.ivUser1)

        Glide.with(binding.root.context)
            .load(project.userIcons[1])
            .centerCrop()
            .into(binding.ivUser2)

        Glide.with(binding.root.context)
            .load(project.userIcons[2])
            .centerCrop()
            .into(binding.ivUser3)

        val colors = IntArray(2)
        colors[1] = ContextCompat.getColor(binding.root.context, project.color)
        colors[0] = ColorUtil.manipulateColor(
            ContextCompat.getColor(
                binding.root.context,
                project.color
            ), 2.5f
        )
        binding.ivProgress.colors = colors


        val stats = FloatArray(2)
        stats[0] = 100F
        stats[1] = project.progress.toFloat()
        binding.ivProgress.stats = stats
        binding.ivProgress.setStartAnimationDuration(4000)
        binding.ivProgress.text = project.progress.toString() + "%"
        binding.ivProgress.textColor = R.color.black
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}