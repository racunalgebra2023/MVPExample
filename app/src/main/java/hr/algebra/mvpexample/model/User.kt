package hr.algebra.mvpexample.model

import android.util.Log
import hr.algebra.mvpexample.MainMVP

class User( ) : MainMVP.Model {

    private val TAG = "User"

    private var name  : String? = null
    private var email : String? = null

    override fun emailUpdated( newEmail: String ) {
        email = newEmail
        Log.i( TAG, "New data arrived from Presenter (email=$newEmail). Model updated." )
    }

    override fun nameUpdated( newName: String ) {
        name = newName
        Log.i( TAG, "New data arrived from Presenter (name=$newName). Model updated." )
    }

    override fun displayData( ): String {
        Log.i( TAG, "Preparing new display data for Presenter." )
        return "Full name: $name\nE-mail: $email"
    }
}