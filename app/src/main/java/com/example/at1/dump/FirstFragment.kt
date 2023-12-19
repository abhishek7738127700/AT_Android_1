package com.example.at1.dump

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.at1.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private val TAG = "FirstFragment"
    private lateinit var binding: FragmentFirstBinding
    private lateinit var viewModel: FirstViewModel

    companion object {
        fun newInstance() = FirstFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "FirstFragment :: onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "FirstFragment :: onCreate: ")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "FirstFragment :: onViewCreated: ")

        viewModel = ViewModelProvider(this)[FirstViewModel::class.java]

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "FirstFragment :: onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "FirstFragment :: onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "FirstFragment :: onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "FirstFragment :: onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "FirstFragment :: onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "FirstFragment :: onDestroy: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "FirstFragment :: onDetach: ")
    }
}