package com.example.cars254

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_car_details.*
import kotlinx.android.synthetic.main.car_ticket.*

class CarDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_details)
        val bundle=intent.extras

        ivCarimage.setImageResource(bundle!!.getInt("image"))
        tvdetails.text=bundle!!.getString("des")
        tvName.text=bundle!!.getString("name")

    }
}
