package com.example.spaceapp.ui.start

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.spaceapp.SpaceApp
import com.example.spaceapp.databinding.FragmentStartBinding
import com.example.spaceapp.di.ViewModelFactory
import javax.inject.Inject

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: StartViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        (activity?.applicationContext as SpaceApp).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.dayPictureLiveData.observe(viewLifecycleOwner){
            Glide
                .with(view)
                .load(it.url)
                .into(binding.DayPictureImg)
        }

        viewModel.getDayPicture()
        viewModel.setToken("quGv1lODdLOb0ylZ0oecDmaIZekZ3HAdvyaQxjtV")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}