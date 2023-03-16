package hr.algebra.mvpexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import hr.algebra.mvpexample.databinding.ActivityMainBinding
import hr.algebra.mvpexample.presenter.MainActivityPresenter

class MainActivity : AppCompatActivity( ), MainMVP.View {

    private val TAG = "MainActivity"

    private lateinit var binding   : ActivityMainBinding
    private lateinit var presenter : MainMVP.Presenter

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView( binding.root )

        presenter = MainActivityPresenter( this )

        setupListensers( )
    }

    private fun setupListensers( ) {
        binding.etUsername.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged( s: Editable ) { }
            override fun beforeTextChanged( s: CharSequence, start: Int, count: Int, after: Int ) { }
            override fun onTextChanged( s: CharSequence, start: Int, before: Int, count: Int ) {
                Log.i( TAG, s.toString( ) )
                presenter.nameUpdated( s.toString( ) )
            }
        } )
        binding.etEmail.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged( s: Editable ) { }
            override fun beforeTextChanged( s: CharSequence, start: Int, count: Int, after: Int ) { }
            override fun onTextChanged( s: CharSequence, start: Int, before: Int, count: Int ) {
                Log.i( TAG, s.toString( ) )
                presenter.emailUpdated( s.toString( ) )
            }
        } )
    }

    override fun updateUserInfo( info : String ) {
        Log.i( TAG, "Writing new data to UI." )
        binding.tvUserData.text = info
    }
}