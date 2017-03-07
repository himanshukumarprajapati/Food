package com.example.ncrsoft.food.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ncrsoft.food.R;
import com.example.ncrsoft.food.utils.PostDataExecute;
import com.facebook.CallbackManager;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * A simple {@link Fragment} subclass.
 */
public class Login_Fragment extends Fragment implements View.OnClickListener {
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
//    private Pref mpPref;

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
        return rootView;
    }



    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.text_sign_up:
                 Registration_Fragment mFragment = new  Registration_Fragment();
                 getFragmentManager().beginTransaction().replace(R.id.id_container, mFragment).addToBackStack(null).commit();
                 break;
         }

    }

    private void init(View v) {
        register  = (TextView) v.findViewById(R.id.text_sign_up);
    }
}
