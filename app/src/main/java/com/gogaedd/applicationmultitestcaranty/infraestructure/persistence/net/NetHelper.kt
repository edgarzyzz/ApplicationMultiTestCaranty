package com.gogaedd.applicationmultitestcaranty.infraestructure.persistence.net

open class NetHelper() {
    protected var apiService : ApiWsService
    var mListener: NetHelperListener?=null
    init {
        val retrofit = ApiWsClient.getRetrofit()
        apiService = retrofit.create(ApiWsService::class.java)
    }


    public fun setListener(listener:NetHelperListener){
        mListener = listener
    }
}