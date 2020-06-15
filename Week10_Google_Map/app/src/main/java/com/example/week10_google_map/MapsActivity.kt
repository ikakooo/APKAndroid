package com.example.week10_google_map

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.activity_maps.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        init()
    }

    private fun init() {
        mMap.setOnCameraMoveStartedListener {
            start()
        }
        mMap.setOnCameraIdleListener {
            end()
        }
    }

    private fun start() {

        shadowImageViewID.layoutParams.width = 12
        shadowImageViewID.layoutParams.height = 3
        circleRadiusID.visibility = View.INVISIBLE
        pointerImageViewID.animate().translationY(dpToPxl(-66))

    }

    private fun end() {

        circleRadiusID.visibility = View.VISIBLE
        pointerImageViewID.animate().translationY(dpToPxl(0))
        shadowImageViewID.layoutParams.width = 36
        shadowImageViewID.layoutParams.height = 9

    }

    private fun dpToPxl(dp: Int): Float {
        return (dp * applicationContext.resources.displayMetrics.density)

        //val dp: Float = somePxValue / density
    }
}