package com.example.urgentcheer.ui.activity

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.urgentcheer.R
import com.example.urgentcheer.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.jsoup.Jsoup

class MainActivity : AppCompatActivity(){

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!
    lateinit var navControl : NavController
    private val tempUrl = "https://api.hangang.msub.kr/"


    //    var array = ArrayList<String>()
    var hangang = mutableMapOf<String, String>()


    lateinit var jsonQuote : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navControl = findNavController(R.id.fr_main)
        findViewById<BottomNavigationView>(R.id.bnv_main).setupWithNavController(navControl)



        CoroutineScope(Dispatchers.IO).launch {

            val doc = Jsoup.connect(tempUrl).ignoreContentType(true).get()

            try{
                val status = JSONObject(doc.text()).getString("status")
                val temp = JSONObject(doc.text()).getString("temp")
                val time = JSONObject(doc.text()).getString("time")

                val quote =


                Log.d(TAG, "onCreate: $status $temp $time")
                Log.d(TAG, "onCreate: $quote")
//                array.add(temp)
//                array.add(status)
//                array.add(time)
//                Log.d(TAG, "onCreate: "+ array)
                hangang["temp"] = temp
                hangang["status"] = status
                hangang["time"] = time

            } catch (e: JSONException){
                e.printStackTrace()
            }
        }
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }

    fun getHangang(key : String) : String? {
        return hangang[key]
    }

    fun getQuote(): JSONArray {
        jsonQuote = assets.open("data.json").reader().readText()
        return JSONArray(jsonQuote)
    }

}