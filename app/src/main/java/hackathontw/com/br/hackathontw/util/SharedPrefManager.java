package hackathontw.com.br.hackathontw.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

import hackathontw.com.br.hackathontw.entity.Usuario;

/**
 * Created by Uehara on 08/04/2017.
 */

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "login";
    private static final String FULL_USER = "full_user";

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }


    public void saveUserInSharedPref(Usuario usuario){
        Gson gson = new Gson();
        String json = gson.toJson(usuario);

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FULL_USER, json);
        editor.apply();
    }

    public Usuario getUserFromSharedPref(){
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String json = sharedPreferences.getString(FULL_USER, "");
        Log.d(FULL_USER, json);
        Usuario usuario = gson.fromJson(json, Usuario.class);
        if ( json != "" ){
            return usuario;
        }else{
            return null;
        }
    }

}

