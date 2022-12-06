package com.example.urgentcheer.ui.activity

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.urgentcheer.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import org.json.JSONException
import org.json.JSONObject
import org.jsoup.Jsoup

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    private val searchUrl = "https://api.hangang.msub.kr/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        CoroutineScope(Dispatchers.IO).launch {

            val doc = Jsoup.connect(searchUrl).ignoreContentType(true).get()

            try{
                val status = JSONObject(doc.text()).getString("status")
                val temp = JSONObject(doc.text()).getString("temp")
                val time = JSONObject(doc.text()).getString("time")

                Log.d(TAG, "onCreate: $status $temp $time")
                withContext(Dispatchers.Main){
                    binding.textView.text = time+"시 기준 한강 수온 : " + temp + "ºC"
                }

            } catch (e:JSONException){
                e.printStackTrace()
            }
        }

    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }

}