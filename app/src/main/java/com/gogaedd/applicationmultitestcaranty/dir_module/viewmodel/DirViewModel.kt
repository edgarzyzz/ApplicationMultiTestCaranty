package com.gogaedd.applicationmultitestcaranty.dir_module.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.gogaedd.applicationmultitestcaranty.dir_module.repository.DirRepository

class DirViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: DirRepository = DirRepository(application)

    private val lvdText = repository.getLvdTextToShow()
    private val lvdMessageError = repository.getLvdErrorMessage()

    fun getLvdTextToShow() = lvdText
    fun getLvdMEssageError() = lvdMessageError

    fun getDirs(path:String) {
        repository.startLoadFilesDir(path)




    }

}