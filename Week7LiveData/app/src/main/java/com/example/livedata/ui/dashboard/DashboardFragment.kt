package com.example.livedata.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.livedata.R
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    var counter = 0

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboardID)

        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
            button4_dashboard.setOnClickListener(){
                textView.text = (10 + counter).toString()
                counter++
            }
            button3_dashboardID.setOnClickListener(){
                textView.text = (10 + counter).toString()
                counter--
            }

        })
        return root
    }

}

//private operator fun View.plus(toInt: Int): CharSequence? = (10 + counter).toString()
