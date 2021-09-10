package com.gogaedd.applicationmultitestcaranty.infraestructure.persistence.net

interface NetHelperListener {
    fun onResultOk(any:Any, code: Int)
    fun onResultError(meesageError:String, code: Int)
}