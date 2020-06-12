package com.example.quiz7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quiz7.adapters.FieldsRecyclerViewAdapter
import com.example.quiz7.models.RecyclerviewModel
import com.example.quiz7.models.ServerJSonModel
import com.example.quiz7.models.ServerJSonModelSubList
import com.example.quiz7.models.field.FieldsRecyclerviewModel
import com.example.quiz7.models.field.FieldsRecyclerviewModelItem
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var fieldsRecyclerViewAdapter: FieldsRecyclerViewAdapter
    private val fields = mutableListOf<RecyclerviewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }







private fun init(){
    fieldsRecyclerViewAdapter = FieldsRecyclerViewAdapter(fields)
    RecyclerviewID.layoutManager = LinearLayoutManager(this)
    RecyclerviewID.adapter = fieldsRecyclerViewAdapter



    val gson = GsonBuilder().create()
    val itemsArray = gson.fromJson(Json , ServerJSonModel::class.java).toList()
    (itemsArray.indices).forEach{it->
d("dwedweewfe",it.toString())
        (0 until itemsArray[it].size).forEach{it2 ->
            d("dwedweewfesffeesefs",it2.toString())
            fields.add(RecyclerviewModel(itemsArray[it][it2].field_id,itemsArray[it][it2].hint,itemsArray[it][it2].field_type,itemsArray[it][it2].keyboard,itemsArray[it][it2].required,itemsArray[it][it2].is_actove,itemsArray[it][it2].icon))
           //fields.add(it, ServerJSonModelSubList[it][it2])
            // fields.add(FieldsRecyclerviewModel(FieldsRecyclerviewModelItem(itemsArray[it][it2].field_id,itemsArray[it][it2].hint,itemsArray[it][it2].field_type,itemsArray[it][it2].keyboard,itemsArray[it][it2].required,itemsArray[it][it2].is_actove,itemsArray[it][it2].icon)))
        }
    }
}



    private val Json = "[\n" +
            "   [\n" +
            "      {\n" +
            "         \"field_id\":1,\n" +
            "         \"hint\":\"UserName\",\n" +
            "         \"field_type\":\"input\",\n" +
            "         \"keyboard\":\"text\",\n" +
            "         \"required\":false,\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://jemala.png\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"field_id\":2,\n" +
            "         \"hint\":\"Email\",\n" +
            "         \"field_type\":\"input\",\n" +
            "         \"required\":true,\n" +
            "         \"keyboard\":\"text\",\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://jemala.png\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"field_id\":3,\n" +
            "         \"hint\":\"phone\",\n" +
            "         \"field_type\":\"input\",\n" +
            "         \"required\":true,\n" +
            "         \"keyboard\":\"number\",\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://jemala.png\"\n" +
            "      }\n" +
            "   ],\n" +
            "   [\n" +
            "      {\n" +
            "         \"field_id\":4,\n" +
            "         \"hint\":\"Full Name\",\n" +
            "         \"field_type\":\"input\",\n" +
            "         \"keyboard\":\"text\",\n" +
            "         \"required\":true,\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://jemala.png\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"field_id\":14,\n" +
            "         \"hint\":\"Jemali\",\n" +
            "         \"field_type\":\"input\",\n" +
            "         \"keyboard\":\"text\",\n" +
            "         \"required\":false,\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://jemala.png\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"field_id\":89,\n" +
            "         \"hint\":\"Birthday\",\n" +
            "         \"field_type\":\"chooser\",\n" +
            "         \"required\":false,\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://jemala.png\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"field_id\":898,\n" +
            "         \"hint\":\"Gender\",\n" +
            "         \"field_type\":\"chooser\",\n" +
            "         \"required\":\"false\",\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://jemala.png\"\n" +
            "      }\n" +
            "   ]\n" +
            "]\n"

    val JSon2 = "[\n" +
            "   [\n" +
            "      {\n" +
            "         \"field_id\":1,\n" +
            "         \"hint\":\"UserName\",\n" +
            "         \"field_type\":\"input\",\n" +
            "         \"keyboard\":\"text\",\n" +
            "         \"required\":false,\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://i.ibb.co/dPZ2zVw/user.png\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"field_id\":2,\n" +
            "         \"hint\":\"Email\",\n" +
            "         \"field_type\":\"input\",\n" +
            "         \"required\":true,\n" +
            "         \"keyboard\":\"text\",\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://i.ibb.co/LDKc5J1/email.png\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"field_id\":3,\n" +
            "         \"hint\":\"phone\",\n" +
            "         \"field_type\":\"input\",\n" +
            "         \"required\":true,\n" +
            "         \"keyboard\":\"number\",\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://i.ibb.co/jgk9FFR/phone.png\"\n" +
            "      }\n" +
            "   ],\n" +
            "   [\n" +
            "      {\n" +
            "         \"field_id\":4,\n" +
            "         \"hint\":\"Full Name\",\n" +
            "         \"Field_type\":\"input\",\n" +
            "         \"keyboard\":\"text\",\n" +
            "         \"required\":true,\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://i.ibb.co/dPZ2zVw/user.png\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"field_id\":14,\n" +
            "         \"hint\":\"Jemali\",\n" +
            "         \"Field_type\":\"input\",\n" +
            "         \"keyboard\":\"text\",\n" +
            "         \"required\":false,\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://jemala.png\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"field_id\":89,\n" +
            "         \"hint\":\"Birthday\",\n" +
            "         \"field_type\":\"chooser\",\n" +
            "         \"required\":false,\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://i.ibb.co/S0FnzrQ/birthday.png\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"field_id\":898,\n" +
            "         \"hint\":\"Gender\",\n" +
            "         \"field_type\":\"chooser\",\n" +
            "         \"required\":\"false\",\n" +
            "         \"is_active\":true,\n" +
            "         \"icon\":\"https://i.ibb.co/t2C06j7/gender-fluid.png\"\n" +
            "      }\n" +
            "   ]\n" +
            "]\n"
}