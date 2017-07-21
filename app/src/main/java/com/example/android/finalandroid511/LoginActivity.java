package com.example.android.finalandroid511;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import butterknife.BindView;
import butterknife.ButterKnife;
import static com.example.android.finalandroid511.server.ServerConfig.loginUrl;

public class LoginActivity extends AppCompatActivity {

    Context context;
    @BindView(R.id.button_log_in)
    Button loginButton;
    @BindView(R.id.textView_sign_up)
    TextView signupTextView;
    @BindView(R.id.username_editText)
    EditText userNameEditText;
    @BindView(R.id.password_editText)
    EditText passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initScreen();
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,EmployeeActivity.class));
                /*
                final String userNameStr = userNameEditText.getText().toString().trim();
                final String passwordStr = passwordEditText.getText().toString().trim();

                // 检查数据是否为空。
                if (!userNameStr.isEmpty() && !passwordStr.isEmpty()) {
                    login(userNameStr, passwordStr);
                } else {
                    // 如果数据为空
                    Toast.makeText(context,
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                }
                */
            }
        });

    }

    private void initScreen() {
        context = getApplicationContext();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void login(final String userNameStr, final String passwordStr) {

        /*
        final ProgressDialog pDialog;
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Logging in ...");
        showDialog(pDialog);
        RequestQueue mQueue = Volley.newRequestQueue(context);


        StringRequest stringRequest = new StringRequest(Request.Method.POST, loginUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        hideDialog(pDialog);

                        try {
                            int index=response.indexOf("{");
                            String jsonString= response.substring(index);
                            JSONObject jsonObject = new JSONObject(jsonString);
                            boolean error = jsonObject.getBoolean("error");
                            if (!error) {
                                int id = jsonObject.getInt("userid");
                                startActivity(new Intent(context, MenuActivity.class));
                            } else {
                                // Error in login. Get the error message
                                String errorMsg = jsonObject.getString("error_msg");
                                Toast.makeText(getApplicationContext(), errorMsg, Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parameters = new HashMap<String,String>();
                parameters.put("username",userNameStr);
                parameters.put("password",passwordStr);

                return parameters;
            }


        };
        mQueue.add(stringRequest);
        */
    }

    private void showDialog(ProgressDialog pDialog) {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog(ProgressDialog pDialog) {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}

