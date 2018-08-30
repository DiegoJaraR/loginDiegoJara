package com.example.alumnoicin.logindiegojara.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import com.example.alumnoicin.logindiegojara.R;
import com.example.alumnoicin.logindiegojara.adapters.MyAdapter;
import com.example.alumnoicin.logindiegojara.models.alumno;
import com.example.alumnoicin.logindiegojara.models.usuario;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private MyAdapter adapter;

    private Realm realm;
    private RealmResults<alumno> people;
    private RealmResults<usuario> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
        listView = (ListView) findViewById(R.id.listView);

        people = getAllPeople();
        people.addChangeListener(this);

        user = getAllUsuario();
        user.addChangeListener(this);
        
        adapter = new MyAdapter(people, R.layout.list_item_view, this);

        listView.setAdapter(adapter);
    }


    //@Override
    public void onChange(RealmResults<alumno> element) {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        realm.removeAllChangeListeners();
        realm.close();
        super.onDestroy();
    }

    private RealmResults<alumno> getAllPeople() {
        return realm.where(alumno.class).findAll();
    }
    private RealmResults<usuario> getAllUsuario() {
        return realm.where(usuario.class).findAll();
    }

    private void addPeople() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //  Toast.makeText(getApplicationContext(),"hola",Toast.LENGTH_SHORT).show();

                alumno p1 = new alumno("22222222-2", "Diego","direccion",100000,"cargo",21);
                alumno p2 = new alumno("33333333-3", "Diego","direccion",100000,"cargo",25);
                alumno p3 = new alumno("44444444-4", "Diego","direccion",100000,"cargo",30);
                alumno p4 = new alumno("55555555-5", "Diego","direccion",100000,"cargo",22);
                alumno p5 = new alumno("66666666-6", "Diego","direccion",100000,"cargo",19);


                realm.copyToRealmOrUpdate(p1);
                realm.copyToRealmOrUpdate(p2);
                realm.copyToRealmOrUpdate(p3);
                realm.copyToRealmOrUpdate(p4);
                realm.copyToRealmOrUpdate(p5);

                people = getAllPeople();
            }
        });

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //  Toast.makeText(getApplicationContext(),"hola",Toast.LENGTH_SHORT).show();

                usuario p1 = new usuario("22222222-2", "contrasena");
                usuario p2 = new usuario("33333333-3", "contrasena");
                usuario p3 = new usuario("44444444-4", "contrasena");
                usuario p4 = new usuario("55555555-5", "contrasena");
                usuario p5 = new usuario("66666666-6", "contrasena");


                realm.copyToRealmOrUpdate(p1);
                realm.copyToRealmOrUpdate(p2);
                realm.copyToRealmOrUpdate(p3);
                realm.copyToRealmOrUpdate(p4);
                realm.copyToRealmOrUpdate(p5);

                user = getAllUsuario();
            }
        });
    }
}
