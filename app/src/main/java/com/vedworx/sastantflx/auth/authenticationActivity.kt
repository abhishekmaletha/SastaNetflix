package com.vedworx.sastantflx.auth
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.vedworx.sastantflx.R
import com.vedworx.sastantflx.utils.login
import kotlinx.android.synthetic.main.authentication.*


class authenticationActivity : AppCompatActivity() {
    private lateinit var mAuthLogin: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authentication)
        mAuthLogin = FirebaseAuth.getInstance()
        authenticationbutton.setOnClickListener {
            val intent = Intent(applicationContext, LoginFragment::class.java)
            startActivity(intent)
        }


    }


    override fun onStart() {
        super.onStart()
        mAuthLogin.currentUser?.let {
            login()
        }
    }
}