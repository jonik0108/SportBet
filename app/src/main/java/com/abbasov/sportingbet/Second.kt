package com.abbasov.sportingbet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.abbasov.sportingbet.databinding.ActivitySecondBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_second.*

class Second : AppCompatActivity() {
    lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.foot.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_down))
        binding.tennis.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_down))
        binding.ski.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_down))

        val anim = AnimationUtils.loadAnimation(this,R.anim.anim2)
        FirebaseDatabase.getInstance().getReference("settings2").child("link").addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val link = snapshot.getValue(String::class.java)

                    val webView = findViewById<WebView>(R.id.webView)
                    webView.settings.javaScriptEnabled = true

                    webView.webViewClient = object : WebViewClient() {
                        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                            view?.loadUrl(url!!)
                            return true
                        }
                    }

                    if (savedInstanceState == null) {
                        if (link != null) {
                            webView.loadUrl(link)
                        };
                    }else{
                        webView.loadUrl(link!!)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

        FirebaseDatabase.getInstance().getReference("settings2").child("isEnabled").addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val isEnabled = snapshot.getValue(String::class.java)

                    if (isEnabled == "no"){
                        findViewById<WebView>(R.id.webView).visibility = View.GONE
                        linear1.visibility=View.VISIBLE
                    }else{
                        findViewById<WebView>(R.id.webView).visibility = View.VISIBLE
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

        FirebaseDatabase.getInstance().getReference("settings2").child("allow").addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val isEnabled = snapshot.getValue(String::class.java)

                    if (isEnabled == "no"){
                        finishAffinity()
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        binding.name.setOnClickListener {
            binding.name.startAnimation(anim)
        }
        binding.foot.setOnClickListener {
            startActivity(Intent(this@Second,One::class.java))
        }
        binding.tennis.setOnClickListener {
            startActivity(Intent(this@Second,Two::class.java))
        }

        binding.ski.setOnClickListener {
            startActivity(Intent(this@Second,Three
            ::class.java))

        }
    }

}