package com.example.at1.recyclerview.movielist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.at1.databinding.FragmentRecyclerViewBinding
import com.example.at1.recyclerview.movielist.adapters.MovieAdapter

class RecyclerViewFragment : Fragment() {

    private val TAG = "RecyclerViewFragment"

    private lateinit var binding: FragmentRecyclerViewBinding
    private lateinit var viewModel: RecyclerViewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[RecyclerViewViewModel::class.java]

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.adapter = MovieAdapter(listOf(), viewModel)

        viewModel.showToast.observe(viewLifecycleOwner) {
            Log.d(TAG, "RecyclerViewFragment :: onViewCreated :: showToast")
            it.getContentIfNotHandled()?.let { movie ->
                Log.d(TAG, "RecyclerViewFragment :: onViewCreated :: showToast :: 1")
                Toast.makeText(context, "MovieClicked: ${movie.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}