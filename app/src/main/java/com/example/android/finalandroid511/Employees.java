package com.example.android.finalandroid511;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.finalandroid511.entitiy.Person;
import com.example.android.finalandroid511.server.ServerConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Employees extends Fragment {

    Context context;
    ArrayList<Person> employeesArr;

    public Employees(){
        employeesArr = new ArrayList<>();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();

        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, ServerConfig.employeesUrl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response){

                        boolean error = false;
                        JSONArray employeesJsonArray = null;
                        try {
                            error = response.getBoolean("error");
                            if (!error) {
                                employeesJsonArray = response.getJSONArray("employees");
                                for(int i =0;i<employeesJsonArray.length();i++){
                                    JSONObject personJsonObject = employeesJsonArray.getJSONObject(i);
                                    Person person = new Person(personJsonObject);
                                    employeesArr.add(person);
                                }

                            } else {
                                String errorMsg = response.getString("error_msg");
                                Toast.makeText(context,errorMsg,Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment_one, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView employeesGridLayout = getView().findViewById(R.id.employees_recycleView);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getContext(), 4);
        employeesGridLayout.setLayoutManager(mLayoutManager);
        EmployeesAdapter adapter = new EmployeesAdapter(getContext(), employeesArr);
        employeesGridLayout.setAdapter(adapter);
    }

}

