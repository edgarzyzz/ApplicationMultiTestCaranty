package com.gogaedd.applicationmultitestcaranty.dir_module.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.gogaedd.applicationmultitestcaranty.dir_module.model.TreeDir
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.io.File

class DirRepository(val application: Application) {
    val mLvdTextToShow =  MutableLiveData<String>("")
    val mLvdErrorMessage =  MutableLiveData<String>("")
    fun getLvdTextToShow ()= mLvdTextToShow
    fun getLvdErrorMessage ()= mLvdErrorMessage


    companion object {
        val SPACE = "   "

    }

    fun startLoadFilesDir(s: String) {
        runBlocking(Dispatchers.Default) {

            if (isValidPath(s)){
                val dirs = getDirs(File(s))
                mLvdTextToShow.postValue(getTextDrTree(dirs, 0))
            }

        }

    }

    fun isValidPath(path:String): Boolean {
        val fileRoot = File(path)
        return if (!fileRoot.exists()){
            mLvdErrorMessage.postValue("Directorio no existe")
            false
        }else if (!fileRoot.canRead()) {
            mLvdErrorMessage.postValue("Favor de Permitir permisos de lectura del dispositivo",)
            false
        }else{
            true
        }
    }


    fun getDirs(fileRoot: File): TreeDir {

        val listFiles: MutableList<File> = mutableListOf()
        val listDirs: MutableList<TreeDir> = mutableListOf()

            fileRoot.listFiles()?.forEach { aFile ->
                if (aFile.isDirectory) {
                    listDirs.add(getDirs(aFile))
                } else {
                    listFiles.add(aFile)
                }
            }




        val treeDir = TreeDir(listFiles, listDirs, fileRoot.name)
        treeDir.listDir.size
        return treeDir
    }


    fun getTextDrTree(treeDir: TreeDir, loopSpace: Int): String {
        var textToShow = ""
        treeDir.listFiles.forEach { file ->

            var lineText = getLineSpaces(loopSpace) + file.name

            textToShow += "$lineText \n"
        }

        treeDir.listDir.forEach { treeDir ->
            var lineParent = getLineSpaces(loopSpace) + treeDir.rootpath
            textToShow += "$lineParent \n"


            textToShow += getTextDrTree(treeDir, loopSpace + 1)
        }
        return "$textToShow \n"

    }

    fun getLineSpaces(loopSpace: Int): String {
        var lineText = ""
        var count = 0
        if (loopSpace == 0) {
            lineText += "|_"
        } else {
            while (count < loopSpace) {
                lineText += SPACE
                if (count == loopSpace - 1) lineText += "|_"
                count++
            }
        }

        return lineText
    }
}