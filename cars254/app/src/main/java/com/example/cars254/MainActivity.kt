package com.example.cars254

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.car_ticket.view.*

class MainActivity : AppCompatActivity() {
            var listofCar=ArrayList<Car>()
            var adapter:CarAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listofCar.add(Car("Chevy","It's a muscle car with 12Cylinder engines giving you the power you need",R.drawable.camaro))
        listofCar.add(Car("Ford","It's a muscle car with 12Cylinder and a turbo giving you the power and speed",R.drawable.mustang))
        listofCar.add(Car("Evo12","This is your car if you are in need of speed",R.drawable.mitsubishi))
        listofCar.add(Car("Q7","It's a speeds car with stylish look",R.drawable.audiq))
        listofCar.add(Car("Ford","If you need speed,This is definitely your ride",R.drawable.bravaria))
        listofCar.add(Car("Ford","Car designed for luxury",R.drawable.hammer))
        adapter=CarAdapter(listofCar,this)
        gvlistcar.adapter=adapter
    }
    class CarAdapter:BaseAdapter{
       var listofcar = ArrayList<Car>()
        var context:Context?=null



        constructor() : super()
        constructor(listofcar: ArrayList<Car>, context: Context?) : super() {
            this.listofcar = listofcar
            this.context = context
        }


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val car=this.listofcar[position]
            var inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var carview=inflator.inflate(R.layout.car_ticket,null)
            carview.ivCarimage.setImageResource(car.image!!)
            carview.ivCarimage.setOnClickListener {
                val intent=Intent(context,CarDetails::class.java)
                intent.putExtra("name",car.name!!)
                intent.putExtra("des",car.des!!)
                intent.putExtra("image",car.image!!)
                context!!.startActivity(intent)
            }
            carview.tvName.text=car.name!!
            return carview
        }

        override fun getItem(position: Int): Any {
            return listofcar[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listofcar.size
        }


    }



}
