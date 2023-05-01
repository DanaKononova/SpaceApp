package com.example.spaceapp.ui.earth

import android.R
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.spaceapp.SpaceApp
import com.example.spaceapp.databinding.FragmentEarthBinding
import com.example.spaceapp.di.ViewModelFactory
import com.example.spaceapp.domain.models.DateData
import com.toptoche.searchablespinnerlibrary.SearchableListDialog
import javax.inject.Inject

class EarthFragment : Fragment() {

    private var _binding: FragmentEarthBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: EarthViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        (activity?.applicationContext as SpaceApp).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEarthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val spinner = binding.dateSpinner
        var items = listOf<DateData>()
        var adapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.setOnSearchTextChangedListener { text -> adapter.filter.filter(text) }

        viewModel.datesLiveData.observe(viewLifecycleOwner){
            items = it
            adapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, items)
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        viewModel.getDates()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}