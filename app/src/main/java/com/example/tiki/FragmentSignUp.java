package com.example.tiki;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSignUp#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSignUp extends Fragment {
    EditText name, phone, email, password,ngSinh;
    Button singup;
    FirebaseAuth fAuth;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentSignUp() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSignUp.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSignUp newInstance(String param1, String param2) {
        FragmentSignUp fragment = new FragmentSignUp();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_sign_up, container, false);
        name = v.findViewById(R.id.text_input_name);
        email = v.findViewById(R.id.text_input_email);
        password = v.findViewById(R.id.text_input_matkhau);
        phone = v.findViewById(R.id.text_input_sdt);
        singup = v.findViewById(R.id.bt_SignUp);
        ngSinh = v.findViewById(R.id.text_input_ngaysinh);
        fAuth = FirebaseAuth.getInstance();
        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mEmail = email.getText().toString().trim();
                String mPassword = password.getText().toString().trim();
                if(TextUtils.isEmpty(mEmail)){
                    email.setError("Email is Reuired ");
                    return;
                }
                if(TextUtils.isEmpty(mPassword)){
                    password.setError("Password is Reuired ");
                    return;
                }
                if (password.length() < 6){
                    password.setError("Mật khẩu phải nhiều hơn 6 kí tự ");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(mEmail,mPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(FragmentSignUp.super.getContext(), "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), TrangChu.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(FragmentSignUp.super.getContext(), "Error!" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        return v;
    }
}