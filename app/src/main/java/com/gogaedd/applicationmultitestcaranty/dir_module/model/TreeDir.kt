package com.gogaedd.applicationmultitestcaranty.dir_module.model

import java.io.File

data class TreeDir(
    var listFiles: MutableList<File> =  mutableListOf(),
    var listDir: MutableList<TreeDir> = mutableListOf(),
    var rootpath: String =""


)
