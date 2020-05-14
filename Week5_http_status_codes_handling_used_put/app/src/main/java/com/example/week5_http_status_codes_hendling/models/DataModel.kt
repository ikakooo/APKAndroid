package com.example.week5_http_status_codes_hendling.models

import com.google.gson.annotations.SerializedName
import java.util.*

class DataModel {
    var page: Int = 0
    @SerializedName("per_page")
    var perPage: Int = 0
    var total: Int = 0
    @SerializedName("total_pages")
    var totalPages: Int = 0
    var data = mutableListOf<Data>()

    class Data {
        var id: Int = 0
        var name: String = ""
        var year: Int = 0
        var color: String = ""
        @SerializedName("pantone_value")
        var pantoneValue: String = ""


    }


}