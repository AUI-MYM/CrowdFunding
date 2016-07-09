package com.example.mym.crowdfunding.activities;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mym.crowdfunding.R;
import com.example.mym.crowdfunding.listeners.OnTaskCompleted;
import com.example.mym.crowdfunding.model.UsersEntity;
import com.example.mym.crowdfunding.util.Commons;
import com.example.mym.crowdfunding.util.Json2ObjectFactory;

import butterknife.ButterKnife;
import butterknife.Bind;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";
    private UsersEntity newUser = new UsersEntity();
    @Bind(R.id.input_name) EditText _nameText;
    @Bind(R.id.input_surname) EditText _surnameText;
    @Bind(R.id.input_email) EditText _emailText;
    @Bind(R.id.input_street) EditText _street;
    @Bind(R.id.input_city) EditText _city;
    @Bind(R.id.input_zip_code) EditText _zip_code;
    @Bind(R.id.input_country) EditText _country;
    @Bind(R.id.input_phone) EditText _phone;
    @Bind(R.id.input_website) EditText _website;
    @Bind(R.id.input_company) EditText _company;
    @Bind(R.id.input_password) EditText _passwordText;
    @Bind(R.id.btn_signup) Button _signupButton;
    @Bind(R.id.link_login) TextView _loginLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        String surname = _surnameText.getText().toString();
        String street = _street.getText().toString();
        String city = _city.getText().toString();
        String zip_code = _zip_code.getText().toString();
        String country = _country.getText().toString();
        String phone = _phone.getText().toString();
        String website = _website.getText().toString();
        String company = _company.getText().toString();
        newUser.setFirstname(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setLastname(surname);
        newUser.setStreet(street);
        newUser.setCity(city);
        newUser.setZip_code(zip_code);
        newUser.setCountry(country);
        newUser.setPhone(phone);
        newUser.setWebsite(website);
        newUser.setCompany(company);

        AsyncLoadSignup asynctask = new AsyncLoadSignup(new OnTaskCompleted() {
            @Override
            public void taskCompleted(Object object) {

            }
        });
        asynctask.execute("REGISTER");
    }


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
    public class AsyncLoadSignup extends AsyncTask<String, Void, Void> {
        OnTaskCompleted otc;
        public AsyncLoadSignup(OnTaskCompleted otc) {
            super();
            this.otc = otc;
        }
        @Override
        protected Void doInBackground(String... params) {
            for (String param : params) {
                if(param.equals("REGISTER")) {
                    Commons.loggedInUser = Json2ObjectFactory.registerUser(newUser);
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            otc.taskCompleted(null);
            if (Commons.loggedInUser != null) {
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
                onSignupSuccess();
            }
            else onSignupFailed();
        }
    }
}