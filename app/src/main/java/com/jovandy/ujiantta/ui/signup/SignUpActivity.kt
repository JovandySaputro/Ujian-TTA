package com.jovandy.ujiantta.ui.signup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jovandy.ujiantta.MainActivity
import com.jovandy.ujiantta.R
import com.jovandy.ujiantta.ui.signin.SignInActivity
import com.jovandy.ujiantta.utils.hideKeyboard
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : AppCompatActivity(), SignUpView {

    private lateinit var signUpPresenter: SignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar!!.hide()
        signUpPresenter = SignUpPresenter(this,this)
        setupView()

    }
    private fun setupView() {
        signUpPresenter.setProgressBarVisibility(View.GONE)
        signUpBtn.setOnClickListener {
            signUpPresenter.setProgressBarVisibility(View.VISIBLE)
            signUpPresenter.doSignUp(fullName,email,mobileNumber,password,repeat_password,terms_conditions)
        }
        already_user.setOnClickListener(){
            finish()
        }
    }
    override fun onSetProgressBarVisibility(visibility: Int) {
        progress_bar.visibility = visibility
    }

    override fun showError(message: String) {

    }


}
