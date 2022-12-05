package com.example.urgentcheer

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

    private val searchUrl = "https://api.hangang.msub.kr"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
            throwable.printStackTrace()
        }

        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            val doc = Jsoup.connect(searchUrl).get().getElementsByTag("pre")[0].text()
            delay(1000)
            Log.d(TAG, "onCreate: $doc")

//            try{
//                val status = JSONObject(doc).getString("status")
//                val temp = JSONObject(doc).getString("temp")
//                val time = JSONObject(doc).getString("time")
//
//                Log.d(TAG, "onCreate: $status $temp $time")
//            } catch (e:JSONException){
//                e.printStackTrace()
//            }
        }

    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }

}