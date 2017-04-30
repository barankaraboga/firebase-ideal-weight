package com.rankend.barankaraboa.vkeproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    //cihazın idsini alıyorum.


    EditText edtBoy,edtKilo,edtName;
    Button btnHesapla;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //id alma kısmı
        config.android_id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        context = this;

        edtBoy=(EditText)(findViewById(R.id.editTextBoy));
        edtKilo=(EditText)(findViewById(R.id.editTextKilo));
        edtName=(EditText)(findViewById(R.id.editTextName));
        btnHesapla=(Button)(findViewById(R.id.button));

        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Bu kısımda boş olup olmadıklarını kontrol ettirdik. (isempty fonksiyonu)
                if(edtBoy.getText().toString().isEmpty() || edtName.getText().toString().isEmpty() || edtKilo.getText().toString().isEmpty()  )
                {

                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                    alert.setTitle("Uyarı").setMessage("Lütfen tüm alanları doldurunuz").show();

                }else
                {
                    double boy=Double.parseDouble(edtBoy.getText().toString())/100;
                    double kilo=Double.parseDouble(edtKilo.getText().toString());
                    double sonuc=hesapla(kilo,boy);
                    Intent i=new Intent(MainActivity.this,SonucActivity.class);
                    i.putExtra("sonuc",sonuc);
                    /*

                      Aldığım id'yi firebaseın en üstteki parentına ekliyorum
                     çünki bu uygulamayı herkese açtığımızda veriler birbirine karışmasın
                     istiyorum

                     */
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child(config.android_id);
                    uygModel model = new uygModel();
                    model.isim = edtName.getText().toString();
                    model.boy = String.valueOf(boy);
                    model.kilo = String.valueOf(kilo);
                    model.sonuc = String.valueOf(sonuc);
                    dbRef.push().setValue(model);
                    startActivity(i);
                }


            }
        });

    }
    public double hesapla(double kilo,double boy){
        double islem=kilo/(boy*boy);
        return islem;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.gecmis:
                Toast.makeText(getApplicationContext(),"Dokunuldu",Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this,GecmisActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
