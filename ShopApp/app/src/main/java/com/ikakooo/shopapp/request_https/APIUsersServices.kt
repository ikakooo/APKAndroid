package com.ikakooo.shopapp.request_https

import retrofit2.Call
import retrofit2.http.*


interface APIUsersServices {
    @GET("{path}")
    fun getListRepos(
        @Path("path") path: String?,
        @QueryMap parameters: MutableMap<String, String>
    ): Call<String?>?

    @FormUrlEncoded
    @POST("{path}")
    fun postListRepos(
        @Path("path") path: String?,
        @FieldMap parameters: MutableMap<String, String>
    ): Call<String?>?

}