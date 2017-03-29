package com.example.ncrsoft.zopac.fragment;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ncrsoft.zopac.R;
import com.example.ncrsoft.zopac.utils.ConnectionManager;
import com.example.ncrsoft.zopac.utils.ExecutePostRequest;
import com.example.ncrsoft.zopac.utils.PostDataExecute;
import com.google.gson.Gson;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class Registration_Fragment extends Fragment implements PostDataExecute {

    private View rootView;
    private EditText fname;
    private EditText email;
    private EditText password;
    private EditText confirmpass;
    private Button submit;
    private TextView cancle;
    private String firstName, pass, email_id, cpass;
    private ProgressBar progressBar;
    private boolean isInternet;

    public Registration_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        rootView = inflater.inflate(R.layout.fragment_registration, container, false);
        init(rootView);
           isInternet = ConnectionManager.isNetworkOnline(getActivity());
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Canceled", Toast.LENGTH_SHORT).show();
                getActivity().onBackPressed();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    onRequestLogin();
                }
            }
        });
        return rootView;
    }

    private boolean isValid() {
        init(rootView);
        if (firstName.equalsIgnoreCase("") && !isValidNmae(firstName)) {
            Toast.makeText(getActivity(), "Please enter valid first Name", Toast.LENGTH_SHORT).show();
            return false;
        }
            else if(pass.equals("") || pass.length()<5 ){
                Toast.makeText(getActivity(),"please enter valid password",Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;
        }

    private boolean isValidNmae(String str) {

        if (str.length() <= 1) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {

            if ((str.charAt(i) < 65 && str.charAt(i) != 32) || (str.charAt(i) > 90 && str.charAt(i) < 97) || (str.charAt(i) > 122)) {
                return false;
            }
        }
        return true;

}

    private void init(View v) {
        fname = (EditText)v.findViewById(R.id.txt_firstname);
        password = (EditText)v.findViewById(R.id.txt_password);
        submit = (Button)v.findViewById(R.id.button_registration);
        cancle = (TextView)v.findViewById(R.id.text_sign_up);
        firstName =fname.getText().toString();
        pass = password.getText().toString();
        progressBar = (ProgressBar) v.findViewById(R.id.progressOther);


    }


    @Override
    public void onPostRequestSuccess(int method, String resp) {
        Toast.makeText(getActivity(),resp,Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onPostRequestFailed(int method, String resp) {
        Toast.makeText(getActivity(),resp,Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);
    }

    private void onRequestLogin() {

        if (isInternet) {
            progressBar.setVisibility(View.VISIBLE);

            RequestBody formBody = new FormEncodingBuilder()
                    .add("category_name", "noticias")
                    .add("page", String.valueOf(1))
                    .build();
            Gson gson = new Gson();
            Log.e("myname", firstName);
            String JsonBody = gson.toJson(new RegistrationData(firstName, pass));
            new ExecutePostRequest(getActivity(), 1, formBody, this, JsonBody)
                    .execute("http://api.ncrmenu.com/Emenu.svc/CreateUser?UserName=&Password=");

        } else {
            final Toast tag = Toast.makeText(getActivity().getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT);
            tag.show();
            new CountDownTimer(9000, 1000) {
                public void onTick(long millisUntilFinished) {
                    tag.show();
                }

                public void onFinish() {
                    tag.show();
                }
            }.start();
        }

    }

    public class RegistrationData {
        private String Password;

        private String UserName;
        public RegistrationData(String userName, String password) {
            this.UserName=userName;
            this.Password=password;
        }


        public String getPassword() {
            return Password;
        }

        public String getUserName() {
            return UserName;
        }

    }
}
