package com.vedworx.sastanetflix.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import authentication
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.vedworx.sastanetflix.R
import kotlinx.android.synthetic.main.profile.*

class profile : AppCompatActivity() {
    private lateinit var db: FirebaseDatabase
    private lateinit var auth: FirebaseAuth
    private  var profileName:String="ads"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)



        db = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()
        val ref = db.getReference("users").child(auth.uid.toString())
            .addListenerForSingleValueEvent(object :
                ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onDataChange(p0: DataSnapshot) {
                    profileName = p0.children.toString()
                }

            })



        nameofUser.text=profileName
        logoutButton.setOnClickListener {
            auth.signOut()
            authentication()
        }
    }
}