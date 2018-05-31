package com.inredec.atutor.model.persistencelayer.impl.flatfile.daos;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.inredec.atutor.model.businesslayer.entities.User;
import com.inredec.atutor.model.persistencelayer.api.IUserDAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class UserDAO implements IUserDAO {

    private Context context;

    public UserDAO(Context context) {
        this.context = context;
    }

    @Override
    public User getUserByMail(String email) {
        List<User>users = getUsersFromFlatFile();

        User user = null;

        for(User userTemp:users){
            if(user.getMail().equals(email)){
                user = userTemp;
                break;
            }
        }
        return user;

    }


    @Override
    public void userSave(List<User> users) {
        Gson gson = new Gson();
        String json = gson.toJson(users);
        OutputStreamWriter osr = null;
        try{
            osr = new OutputStreamWriter(
                    context.openFileOutput("users.json",
                            Context.MODE_PRIVATE));
            osr.write(json);
            osr.close();
        }catch(Exception ex){
            throw
                    new RuntimeException(
                            "Petazo al guardar los usuarios en disco!!!");
        }
    }

    @Override
    public void userSave(User user) {
        List<User>users = getUsersFromFlatFile();

        users.add(user);
        userSave(users);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        users =  getUsersFromFlatFile();
        return users;
    }

    private List<User> getUsersFromFlatFile() {

        Gson gson = new Gson();
        String usersFromFileJSON="";
        try{
            BufferedReader br=
                    new BufferedReader(
                            new InputStreamReader(
                                    context.openFileInput("users.json")
                            )
                    );
            usersFromFileJSON = br.readLine();
            br.close();
        }
        catch(Exception ex){}
        ArrayList<User> users =
                gson.fromJson(usersFromFileJSON, new TypeToken<List<User>>(){}.getType());
        return  users;
    }

}
