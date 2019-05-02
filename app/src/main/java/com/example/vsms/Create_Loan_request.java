package com.example.vsms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Create_Loan_request extends AppCompatActivity {
    Toolbar loan_toolbar;
    ImageView imgName,imgGender,imgAge,imgJob,imgIncome,imgExpense,imgPhone,imgAddress,imgAmount,
            imgDuration,imgPurpose,imgStatus,imgStateID,imgFamily,imgStaff,imgHourse;
    EditText etName,etGender,etAge,etJob,etIncome,etExpense,etPhone,etAddress,etAmount,etDuration,etPurpose,etStatus,etStateID,
            etFamily,etStaff,etHourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create__loan_request);

        loan_toolbar = (Toolbar)findViewById(R.id.toolbar_fill_information);
        loan_toolbar.setTitle("");
        setSupportActionBar(loan_toolbar);
        loan_toolbar.setNavigationIcon(R.drawable.back_35px);
        loan_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ID_Field();
        EventText();
    }


    private void ID_Field() {
        imgName =   (ImageView)findViewById(R.id.imgNameL);
        imgGender = (ImageView)findViewById(R.id.imgGenderL);
        imgAge =    (ImageView)findViewById(R.id.imgAgeL);
        imgJob =    (ImageView)findViewById(R.id.imgJobL);
        imgIncome = (ImageView)findViewById(R.id.imgincomeL);
        imgExpense =(ImageView)findViewById(R.id.imgExpenseL);
        imgPhone =  (ImageView)findViewById(R.id.imgPhoneLW);
        imgAddress =(ImageView)findViewById(R.id.imgAddressL);
        imgAmount = (ImageView)findViewById(R.id.imgloanAmmount);
        imgDuration=(ImageView)findViewById(R.id.imgLoanDuration);
        imgPurpose =(ImageView)findViewById(R.id.imgLoanPurpose);
        imgStatus = (ImageView)findViewById(R.id.imgloanstatus);
        imgStateID =(ImageView)findViewById(R.id.imgstateid);
        imgStaff =  (ImageView)findViewById(R.id.imgstaff);
        imgFamily = (ImageView)findViewById(R.id.imgfamily);
        imgHourse = (ImageView)findViewById(R.id.imgHours);

       etName =   (EditText) findViewById(R.id.etNameL);
       etGender = (EditText) findViewById(R.id.etGenderL);
       etAge =    (EditText) findViewById(R.id.etAgeL);
       etJob =    (EditText) findViewById(R.id.etJobL);
       etIncome = (EditText) findViewById(R.id.etIncomeL);
       etExpense =(EditText) findViewById(R.id.etExpenseL);
       etPhone =  (EditText) findViewById(R.id.etPhoneLW);
       etAddress =(EditText) findViewById(R.id.etAddressL);
       etAmount = (EditText) findViewById(R.id.etLoanAmount);
       etDuration=(EditText) findViewById(R.id.etLoanDuration);
       etPurpose =(EditText) findViewById(R.id.etLoanPurpose);
       etStatus = (EditText) findViewById(R.id.etStatus);
       etStateID =(EditText) findViewById(R.id.etStateID);
       etStaff =  (EditText) findViewById(R.id.etstaff);
       etFamily = (EditText) findViewById(R.id.etfamily);
       etHourse = (EditText) findViewById(R.id.etHours);

    }

    private void EventText() {

        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgName.setImageResource(R.drawable.icons8_circle_null_24);
                } else if (s.length() < 3) {
                    imgName.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgName.setImageResource(R.drawable.icons8_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
            });

        etGender.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgGender.setImageResource(R.drawable.icons8_circle_null_24);
                } else if (s.length() < 3) {
                    imgGender.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgGender.setImageResource(R.drawable.icons8_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etAge.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgAge.setImageResource(R.drawable.icons8_circle_null_24);
                } else if (s.length() < 3) {
                    imgAge.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgAge.setImageResource(R.drawable.icons8_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etJob.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgJob.setImageResource(R.drawable.icons8_circle_null_24);
                } else if (s.length() < 3) {
                    imgJob.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgJob.setImageResource(R.drawable.icons8_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etIncome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgIncome.setImageResource(R.drawable.icons8_circle_null_24);
                } else if (s.length() < 3) {
                    imgIncome.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgIncome.setImageResource(R.drawable.icons8_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etExpense.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgExpense.setImageResource(R.drawable.icons8_circle_null_24);
                } else if (s.length() < 3) {
                    imgExpense.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgExpense.setImageResource(R.drawable.icons8_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgPhone.setImageResource(R.drawable.icons8_circle_null_24);
                } else if (s.length() < 3) {
                    imgPhone.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgPhone.setImageResource(R.drawable.icons8_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgAddress.setImageResource(R.drawable.icons8_circle_null_24);
                } else if (s.length() < 3) {
                    imgAddress.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgAddress.setImageResource(R.drawable.icons8_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgAmount.setImageResource(R.drawable.icons8_circle_null_24);
                } else if (s.length() < 3) {
                    imgAmount.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgAmount.setImageResource(R.drawable.icons8_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etDuration.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgDuration.setImageResource(R.drawable.icons8_circle_null_24);
                } else if (s.length() < 3) {
                    imgDuration.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgDuration.setImageResource(R.drawable.icons8_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etPurpose.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgPurpose.setImageResource(R.drawable.icons8_circle_null_24);
                } else if (s.length() < 3) {
                    imgPurpose.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgPurpose.setImageResource(R.drawable.icons8_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etStatus.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgStatus.setImageResource(R.drawable.icons8_circle_null_24);
                } else if (s.length() < 3) {
                    imgStatus.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgStatus.setImageResource(R.drawable.icons8_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etStaff.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgStaff.setImageResource(R.drawable.icons8_circle_null_24);
                } else if (s.length() < 3) {
                    imgStaff.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgStaff.setImageResource(R.drawable.icons8_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etStateID.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgStateID.setImageResource(R.drawable.icons8_circle_null_24);
                } else if (s.length() < 3) {
                    imgStateID.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgStateID.setImageResource(R.drawable.icons8_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etFamily.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgFamily.setImageResource(R.drawable.icons8_circle_null_24);
                } else if (s.length() < 3) {
                    imgFamily.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgFamily.setImageResource(R.drawable.icons8_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etHourse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    imgHourse.setImageResource(R.drawable.icons8_circle_null_24);
                } else if (s.length() < 3) {
                    imgHourse.setImageResource(R.drawable.ic_error_black_24dp);
                } else imgHourse.setImageResource(R.drawable.icons8_ok_24px);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }  // event text

}
