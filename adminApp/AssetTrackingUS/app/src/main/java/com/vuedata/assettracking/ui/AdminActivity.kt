package com.vuedata.assettracking.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.vuedata.assettracking.R
import com.vuedata.assettracking.databinding.ActivityAdminBinding
import com.vuedata.assettracking.databinding.ActivityListOfDeviceBinding

class AdminActivity : AppCompatActivity() {
    lateinit var binding: ActivityAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=
            DataBindingUtil.setContentView(this, R.layout.activity_admin)

        binding.allDeviceTrack.setOnClickListener {
            val intent = Intent(applicationContext, ListOfDeviceActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

        binding.singleDevice.setOnClickListener {
            val intent = Intent(applicationContext, DeleteDeviceIdActivity::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}