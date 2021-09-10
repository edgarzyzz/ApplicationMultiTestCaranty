package com.gogaedd.applicationmultitestcaranty.characters_in_string.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.gogaedd.applicationmultitestcaranty.R
import com.gogaedd.applicationmultitestcaranty.characters_in_string.viewmodel.CharactersInTextViewModel
import com.gogaedd.applicationmultitestcaranty.databinding.FragmentFormCharactersBinding
import kotlinx.android.synthetic.main.fragment_form_characters.*
import java.util.*
import kotlin.collections.HashMap

class FormCharactersFragment : Fragment() {

    lateinit var viewModel: CharactersInTextViewModel
    lateinit var binding: FragmentFormCharactersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormCharactersBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this).get(CharactersInTextViewModel::class.java)
        binding.viewmodeL = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etTextToCountFgmntfc.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.countLetters(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }




}