package com.lukehere.app.icondsc.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.lukehere.app.icondsc.R;
import com.lukehere.app.icondsc.pojo.Attendee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore mDb;

    private TextInputEditText mFirstNameEditText;
    private TextInputEditText mLastNameEditText;
    private TextInputEditText mEmailAddressEditText;
    private TextInputEditText mPasswordEditText;
    private TextInputEditText mRepeatPasswordEditText;
    private TextInputEditText mPhoneNumberEditText;
    private TextInputEditText mOrganizationEditText;
    private TextInputEditText mPaperIdEditText;
    private ProgressBar mSignUpProgressBar;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
        builder.setMessage(getString(R.string.are_you_sure_you_want_to_exit_the_signup_process))
                .setTitle(getString(R.string.warning));
        builder.setPositiveButton(getString(R.string.okay), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                SignUpActivity.super.onBackPressed();
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        mDb = FirebaseFirestore.getInstance();

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.sign_up_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mFirstNameEditText = findViewById(R.id.sign_up_first_name);
        mLastNameEditText = findViewById(R.id.sign_up_last_name);
        mEmailAddressEditText = findViewById(R.id.sign_up_email);
        mPasswordEditText = findViewById(R.id.sign_up_password);
        mRepeatPasswordEditText = findViewById(R.id.sign_up_repeat_password);
        mPhoneNumberEditText = findViewById(R.id.sign_up_phone_number);
        mOrganizationEditText = findViewById(R.id.sign_up_organization);
        mPaperIdEditText = findViewById(R.id.sign_up_paper_id);
        mSignUpProgressBar = findViewById(R.id.sign_up_progress_bar);
        Button mSignUpButton = findViewById(R.id.sign_up_button);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = true;

                final String firstName = mFirstNameEditText.getText().toString().trim();
                final String lastName = mLastNameEditText.getText().toString().trim();
                final String email = mEmailAddressEditText.getText().toString().trim();
                String password = mPasswordEditText.getText().toString().trim();
                String repeatPassword = mRepeatPasswordEditText.getText().toString().trim();
                final String phoneNumber = mPhoneNumberEditText.getText().toString().trim();
                final String organization = mOrganizationEditText.getText().toString().trim();
                final String paperId = mPaperIdEditText.getText().toString().trim();


                if (TextUtils.isEmpty(firstName)) {
                    mFirstNameEditText.setError(getString(R.string.please_enter_your_first_name));
                    if (check) {
                        check = false;
                    }
                } else {
                    mFirstNameEditText.setError(null);
                }

                if (TextUtils.isEmpty(lastName)) {
                    mLastNameEditText.setError(getString(R.string.please_enter_your_last_name));
                    if (check) {
                        check = false;
                    }
                } else {
                    mLastNameEditText.setError(null);
                }

                if (TextUtils.isEmpty(email) || !isEmailValid(email)) {
                    mEmailAddressEditText.setError(getString(R.string.please_enter_a_valid_email_address));
                    if (check) {
                        check = false;
                    }
                } else {
                    mEmailAddressEditText.setError(null);
                }

                if (TextUtils.isEmpty(password)) {
                    mPasswordEditText.setError(getString(R.string.please_enter_a_password));
                    if (check) {
                        check = false;
                    }
                } else {
                    mPasswordEditText.setError(null);
                }

                if (password.length() < 7) {
                    mPasswordEditText.setError(getString(R.string.password_must_be_more_than_7_characters));
                    if (check) {
                        check = false;
                    }
                } else {
                    mPasswordEditText.setError(null);
                }

                if (TextUtils.isEmpty(repeatPassword)) {
                    mRepeatPasswordEditText.setError(getString(R.string.please_enter_your_password_again));
                    if (check) {
                        check = false;
                    }
                } else {
                    mRepeatPasswordEditText.setError(null);
                }

                if (!repeatPassword.equals(password)) {
                    mRepeatPasswordEditText.setError(getString(R.string.passwords_do_not_match));
                    if (check) {
                        check = false;
                    }
                } else {
                    mRepeatPasswordEditText.setError(null);
                }

                if (TextUtils.isEmpty(phoneNumber) || !isValidMobile(phoneNumber)) {
                    mPhoneNumberEditText.setError(getString(R.string.please_enter_a_valid_phone_number));
                    if (check) {
                        check = false;
                    }
                } else {
                    mPhoneNumberEditText.setError(null);
                }

                if (TextUtils.isEmpty(organization)) {
                    mOrganizationEditText.setError(getString(R.string.please_enter_your_organization_name));
                    if (check) {
                        check = false;
                    }
                } else {
                    mOrganizationEditText.setError(null);
                }

                if (check) {
                    mSignUpProgressBar.setVisibility(View.VISIBLE);

                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        Attendee attendee = new Attendee(firstName, lastName, email, phoneNumber, organization, paperId);
                                        DocumentReference docRef = mDb.collection("attendees").document(String.valueOf(mAuth.getUid()));
                                        docRef.set(attendee);

                                        Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                                        startActivity(intent);
                                        finishAffinity();
                                    } else {
                                        Toast.makeText(SignUpActivity.this, getString(R.string.account_already_exists),
                                                Toast.LENGTH_SHORT).show();
                                    }
                                    mSignUpProgressBar.setVisibility(View.GONE);
                                }
                            });
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
            builder.setMessage(getString(R.string.are_you_sure_you_want_to_exit_the_signup_process))
                    .setTitle(getString(R.string.warning));
            builder.setPositiveButton(getString(R.string.okay), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    SignUpActivity.super.onBackPressed();
                }
            });
            builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }

        return super.onOptionsItemSelected(item);
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidMobile(String phone) {
        boolean check;
        if (!Pattern.matches("[a-zA-Z]+", phone)) {
            check = phone.length() >= 6 && phone.length() <= 13;
        } else {
            check = false;
        }
        return check;
    }
}