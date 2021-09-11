package com.gogaedd.applicationmultitestcaranty.dir_module.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.gogaedd.applicationmultitestcaranty.databinding.FragmentResultDirBinding
import com.gogaedd.applicationmultitestcaranty.dir_module.viewmodel.DirViewModel

class ResultDirFragment : Fragment() {
    lateinit var viewModel: DirViewModel
    lateinit var binding :FragmentResultDirBinding

    private val args: ResultDirFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultDirBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this).get(DirViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner =this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getDirs(args.path)
    }



}