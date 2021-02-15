package com.jovandy.ujiantta.ui.signin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jovandy.ujiantta.R
import com.jovandy.ujiantta.ui.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_signin.*

class SignInActivity: AppCompatActivity(),SignInView {

    private lateinit var signInPresenter: SignInPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        supportActionBar!!.hide()
        signInPresenter = SignInPresenter(this,this)
        setupView()
    }

    private fun setupView() {
        signInPresenter.setProgressBarVisibility(View.GONE)
        loginBtn.setOnClickListener {
            signInPresenter.setProgressBarVisibility(View.VISIBLE)
            signInPresenter.doSignIn(login_mobile,login_password)
        }
        createAccount.setOnClickListener(){
            startActivity(Intent(this,SignUpActivity::class.java))
        }
        forgot_password.setOnClickListener(){
            Toast.makeText(this, "Lupa password masih belum tersedia.", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onSetProgressBarVisibility(visibility: Int) {
        progress_bar.visibility = visibility
    }

    override fun showError(message: String) {

    }
}