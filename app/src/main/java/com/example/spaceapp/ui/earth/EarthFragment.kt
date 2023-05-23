package com.example.spaceapp.ui.earth

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.spaceapp.SpaceApp
import com.example.spaceapp.databinding.FragmentEarthBinding
import com.example.spaceapp.di.ViewModelFactory
import com.example.spaceapp.domain.models.DateData
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
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentEarthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val spinner = binding.dateSpinner

        val items = mutableListOf<DateData>()
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        var selectedDate = DateData("")
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
                selectedDate = items[position]

                viewModel.getImageName(selectedDate.data)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        viewModel.imageNameLiveData.observe(viewLifecycleOwner) { name ->
            Glide
                .with(view)
                .load("https://api.nasa.gov/EPIC/archive/enhanced/${selectedDate.toRequest()[0]}/${selectedDate.toRequest()[1]}/${selectedDate.toRequest()[2]}/png/${name.image}.png?api_key=quGv1lODdLOb0ylZ0oecDmaIZekZ3HAdvyaQxjtV")
                .into(binding.EarthImg)

        }

        viewModel.datesLiveData.observe(viewLifecycleOwner) { dates ->
            items.clear()
            items.addAll(dates)
            adapter.notifyDataSetChanged()
        }
        viewModel.getDates()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}