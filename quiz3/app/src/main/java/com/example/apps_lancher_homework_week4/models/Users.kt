package com.example.apps_lancher_homework_week4.models

class Users{
    var page:Int = 0
    var perPage:Int = 0
    var total:Int = 0
    var totalPage:Int = 0
    lateinit var date: MutableList<Date>
    class  Date{
        var ID: Int =0
        var firstName: String = ""
        var lastName: String = ""
        var Email: String = ""
        var avatar:String = ""
    }
   // class Date(var ID: Int, var firstName: String, var lastName: String, var Email: String, var avatar:String)
}

