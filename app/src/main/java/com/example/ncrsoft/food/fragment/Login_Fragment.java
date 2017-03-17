package com.example.ncrsoft.food.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ncrsoft.food.R;
import com.example.ncrsoft.food.activity.MyGridActivity;
import com.example.ncrsoft.food.activity.ProfileActivity;
import com.example.ncrsoft.food.utils.ConnectionManager;
import com.example.ncrsoft.food.utils.ExecutePostRequest;
import com.example.ncrsoft.food.utils.PostDataExecute;
import com.example.ncrsoft.food.utils.Pref;
import com.facebook.CallbackManager;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class Login_Fragment extends Fragment implements View.OnClickListener,PostDataExecute{
    private View rootView;
    private ImageView fbbutton;
    private ImageView googleBTN;
    private Button login;
    private TextView register;
    private EditText uNmae, ext_password;
    private static final int RC_SIGN_IN = 0;
    private CallbackManager callbackManager;
    private GoogleApiClient mGoogleApiClient;
    private boolean isInternet;
    private ProgressBar progressBar;
    private Pref mpPref;

    public Login_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_login, container, false);
        init(rootView);
        register.setOnClickListener(this);
        login.setOnClickListener(this);
        isInternet =  ConnectionManager.isNetworkOnline(getActivity());
        return rootView;
    }



    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.text_sign_up:
                 Registration_Fragment mFragment = new  Registration_Fragment();
                 getFragmentManager().beginTransaction().replace(R.id.id_container, mFragment).addToBackStack(null).commit();
                 break;
             case R.id.login_btn:
                 if(!isValid()) {
                     String email = uNmae.getText().toString();
                     String pass = ext_password.getText().toString();
                     if (isInternet){
                         progressBar.setVisibility(View.VISIBLE);

                         RequestBody formBody = new FormEncodingBuilder()
                                 .add("category_name", "noticias")
                                 .add("page", String.valueOf(1))
                                 .build();
                         Gson gson = new Gson();
                         Log.e("myname",email);
                         Log.e("pass",pass);
                         String JsonBody = gson.toJson(new LoginData(email, pass));
                         new ExecutePostRequest(getActivity(), 1, formBody,this , JsonBody)
                                 .execute("http://api.ncrmenu.com/Emenu.svc/LoginUser?UserName=&Password=");

                     }else {
                         final Toast tag = Toast.makeText(getActivity().getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT);
                         tag.show();
                         new CountDownTimer(9000, 1000)
                         {
                             public void onTick(long millisUntilFinished) {tag.show();}
                             public void onFinish() {tag.show();}
                         }.start();
                     }
                 } else {
                     Toast.makeText(getActivity(),"Please enter email id and password",Toast.LENGTH_SHORT).show();
                 }
                 break;
         }
    }

    public boolean isValid() {

        return uNmae.getText().toString().equals("")&&ext_password.getText().toString().equals("");
    }

    private void init(View v) {
        register  = (TextView) v.findViewById(R.id.text_sign_up);
        uNmae  = (EditText) v.findViewById(R.id.edit_uid);
        ext_password  = (EditText) v.findViewById(R.id.edit_password);
        login  = (Button) v.findViewById(R.id.login_btn);
        progressBar = (ProgressBar) v.findViewById(R.id.progressOther);

    }

    @Override
    public void onPostRequestSuccess(int method, String resp) {

        String status ="";
        try {
            JSONObject jsonObject = new JSONObject(resp);
            status = jsonObject.getString("Status");
            if (status.equalsIgnoreCase("false")) {
              //  JSONObject jsonObject1 = jsonObject.getJSONObject("user_Data");
              //  mpPref.setUserName("user", jsonObject1.getString("user_email"));
                progressBar.setVisibility(View.GONE);
                Intent intent = new Intent(getActivity(), MyGridActivity.class);
                intent.putExtra("from", "login");
                startActivity(intent);
                getActivity().finish();
            } else {
                progressBar.setVisibility(View.GONE);
                uNmae.clearComposingText();
                ext_password.clearComposingText();
                Toast.makeText(getActivity(), "wrong user name or password", Toast.LENGTH_SHORT).show();
            }
            } catch(JSONException e){
                e.printStackTrace();
            }
        }


        @Override
    public void onPostRequestFailed(int method, String resp) {
            progressBar.setVisibility(View.GONE);
            uNmae.clearComposingText();
            ext_password.clearComposingText();

            Toast.makeText(getActivity(),"wrong user name or password" ,Toast.LENGTH_SHORT).show();
    }
    public class LoginData {
        private String Password;

        private String UserName;
        public LoginData(String userName, String password) {
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
