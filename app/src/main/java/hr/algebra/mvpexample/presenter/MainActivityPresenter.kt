package hr.algebra.mvpexample.presenter

import android.util.Log
import hr.algebra.mvpexample.MainMVP
import hr.algebra.mvpexample.model.User

class MainActivityPresenter( private val view : MainMVP.View ) : MainMVP.Presenter {

    private val TAG = "MainActivityPresenter"

    private val model : MainMVP.Model  = User( )

    override fun emailUpdated( newEmail: String ) {
        Log.i( TAG, "Getting information from View: E-mail changed to: $newEmail... Info will be forwarded to Model" )
        model.emailUpdated( newEmail )
        Log.i( TAG, "Model informed. New data will be retrieved from Model and sent to View" )
        view.updateUserInfo( model.displayData ( ) )
    }

    override fun nameUpdated( newName: String ) {
        Log.i( TAG, "Getting information from View: Name changed to: $newName... Info will be forwarded to Model" )
        model.nameUpdated( newName )
        Log.i( TAG, "Model informed. New data will be retrieved from Model and sent to View")
        view.updateUserInfo( model.displayData ( ) )
    }
}