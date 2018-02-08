package fyp.lic.com.lic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Muhammad on 13/12/2017.
 */


public class UserProfile extends AppCompatActivity {
    private DatabaseReference mRef;
    private String name,email,phone,id;
    private TextView tv_name, tv_email, tv_phone;
    private FirebaseAuth auth;
    private Button edit_profile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tv_name=findViewById(R.id.tv_name_myprofile);
        tv_email=findViewById(R.id.tv_email_myprofile);
        tv_phone=findViewById(R.id.tv_phone_myprofile);


        mRef= FirebaseDatabase.getInstance().getReference();
        auth = FirebaseAuth.getInstance();
        id = auth.getCurrentUser().getUid();

        edit_profile=findViewById(R.id.buttonedit);

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserProfile.this, ProfileSetting.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                name=dataSnapshot.child("Users").child(id).child("Name").getValue().toString();
                email=dataSnapshot.child("Users").child(id).child("Email").getValue().toString();
                phone=dataSnapshot.child("Users").child(id).child("Phone").getValue().toString();


                if(!name.equals("")||name!=null ) {
                    tv_name.setText(name);
                    tv_email.setText(email);
                    tv_phone.setText(phone);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
