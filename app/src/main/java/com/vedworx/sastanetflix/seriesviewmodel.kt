package com.vedworx.sastanetflix

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import java.lang.Exception

class seriesviewmodel:ViewModel(){

        var seriesReference = FirebaseDatabase.getInstance().getReference("series")



        private val result = MutableLiveData<Exception?>()

        private val listings = MutableLiveData<series>()

        val _listings: LiveData<series>
            get() = listings


        val _result: LiveData<Exception?>
            get() = result





        fun getRealitimeUpdates() {
            seriesReference.addChildEventListener(childEventListener)
        }





        private val childEventListener = object : ChildEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                val listing = p0.getValue(series::class.java)
                listing?.id = p0.key
                listings.value = listing
            }

            override fun onChildRemoved(p0: DataSnapshot) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }

        override fun onCleared() {
            super.onCleared()
            seriesReference.removeEventListener(childEventListener)
        }


    }

