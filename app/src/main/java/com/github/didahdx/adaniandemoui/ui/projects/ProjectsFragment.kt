package com.github.didahdx.adaniandemoui.ui.projects

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.didahdx.adaniandemoui.R
import com.github.didahdx.adaniandemoui.databinding.ProjectsFragmentBinding
import com.github.didahdx.adaniandemoui.extension.navigateSafe
import com.github.didahdx.adaniandemoui.model.Project
import com.github.didahdx.adaniandemoui.ui.projects_details.ProjectDetailsFragment
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils
import com.google.android.material.chip.Chip


class ProjectsFragment : Fragment() {


    private lateinit var viewModel: ProjectsViewModel

    private var _binding: ProjectsFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(this).get(ProjectsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ProjectsFragmentBinding.inflate(inflater, container, false)
        val manager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val adapter = ProjectAdapter(object : OnItemClickListener {
            override fun onItemClick(project: Project) {
                val bundle = bundleOf(ProjectDetailsFragment.PROJECT_ID to project.id)
                findNavController().navigateSafe(R.id.action_projectsFragment_to_projectDetailsFragment,bundle)
            }
        })

        binding.apply {
            rvProjects.adapter = adapter
            rvProjects.layoutManager = manager

        }

        adapter.submitList(viewModel.projects)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpChip()
        val customerList: ArrayList<String> = viewModel.sortByItems

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext(),
            R.layout.item_spinner,
            customerList
        )
        binding.spinner.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.project_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    @SuppressLint("UnsafeOptInUsageError")
    private fun setUpChip() {
        binding.chipGroup.removeAllViews()
        for (item in viewModel.chipItems) {
            val chip = Chip(binding.chipGroup.context)
            chip.text = item.statusName
            if (item.isSelected) chip.isChecked = true
            chip.id = item.count
            chip.height = 110
            chip.width = 180
            showBadgeOnView(chip, item.count, binding.chipGroup.context)
            binding.chipGroup.addView(chip)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("UnsafeOptInUsageError")
    fun showBadgeOnView(view: View, someNumber: Int, context: Context) {
        val badgeDrawable = BadgeDrawable.create(context)
        badgeDrawable.number = someNumber
        badgeDrawable.verticalOffset = 25
        badgeDrawable.horizontalOffset = 15
        badgeDrawable.backgroundColor = ContextCompat
            .getColor(binding.chipGroup.context, R.color.white)
        badgeDrawable.badgeTextColor = ContextCompat
            .getColor(binding.chipGroup.context, R.color.black)
        view.post { BadgeUtils.attachBadgeDrawable(badgeDrawable, view, null) }
    }
}