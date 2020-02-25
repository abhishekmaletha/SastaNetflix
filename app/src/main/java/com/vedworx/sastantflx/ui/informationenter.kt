package com.vedworx.sastantflx.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.vedworx.sastantflx.R
import com.vedworx.sastantflx.utils.login

import kotlinx.android.synthetic.main.informationenter.*


class informationenter : AppCompatActivity() {
    private lateinit var db: FirebaseDatabase
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.informationenter)

        db = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()

        proceedbutton.setOnClickListener {
            val nameOfUser = name_informationenter.text.toString()
            val uuid = auth.uid
            db.getReference("users").child(uuid.toString()).child("name")
                .setValue(nameOfUser.toString()).addOnSuccessListener {
                    login()
                }
        }

    }
}