package hr.algebra.mvpexample

interface MainMVP {

    interface Presenter {
        fun emailUpdated( newEmail : String )
        fun nameUpdated( newName : String )
    }

    interface Model {
        fun emailUpdated( newEmail : String )
        fun nameUpdated( newName : String )
        fun displayData( ) : String
    }

    interface View {
        fun updateUserInfo( info : String )
    }

}