package com.example.spaceapp.ui.start

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.spaceapp.SpaceApp
import com.example.spaceapp.databinding.FragmentStartBinding
import com.example.spaceapp.di.ViewModelFactory
import com.github.chrisbanes.photoview.PhotoViewAttacher
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

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val photoView = binding.DayPictureImg

        val attacher = PhotoViewAttacher(photoView)
        attacher.isZoomable = true

        viewModel.dayPictureLiveData.observe(viewLifecycleOwner){
            Glide
                .with(view)
                .load(it.url)
                .into(binding.DayPictureImg)
            binding.PictureTitleTv.text = it.title
            binding.PictureDateTv.text = it.data
            binding.PictureExplanationTv.text = it.explanation
        }

        viewModel.getDayPicture()
        viewModel.setToken("quGv1lODdLOb0ylZ0oecDmaIZekZ3HAdvyaQxjtV")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}