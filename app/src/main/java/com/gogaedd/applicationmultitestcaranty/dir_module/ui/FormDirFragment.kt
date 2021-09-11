package com.gogaedd.applicationmultitestcaranty.dir_module.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gogaedd.applicationmultitestcaranty.R
import com.gogaedd.applicationmultitestcaranty.infraestructure.utils.showToast
import kotlinx.android.synthetic.main.fragment_form_dir.*

class FormDirFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_dir, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAceptFgmntfd.setOnClickListener {
            etLatFgmntfl.text.toString().let {inputText->
                if (validate(inputText)) {
                    val action = FormDirFragmentDirections.actionFormDirFragmentToResultDirFragment(inputText)
                    findNavController().navigate(action)
                }else{
                    requireContext().showToast("Favor de introducir una ruta")
                    etLatFgmntfl.error=""

                }
            }



        }
    }

    private fun validate(textInput: String): Boolean {
        return !textInput.isNullOrEmpty()

    }


}