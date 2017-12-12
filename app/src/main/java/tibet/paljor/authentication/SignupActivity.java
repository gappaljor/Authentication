package tibet.paljor.authentication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.TestLooperManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private Button registerBtn;
    private EditText email;
    private EditText passwordA;
    private EditText passwordB;
    private TextView signin;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar myActionbar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(myActionbar);

        firebaseAuth = FirebaseAuth.getInstance();

        registerBtn = (Button)findViewById(R.id.signupBtn);
        email = (EditText)findViewById(R.id.email);
        passwordA = (EditText)findViewById(R.id.pass1);
        passwordB = (EditText)findViewById(R.id.pass2);
        progressDialog = new ProgressDialog(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.login_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.logIn:
                //  Action
                Intent intent = new Intent(this, SinginActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Log in", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home:
                Intent homeIntent = new Intent(this, DefaultPage.class);
                startActivity(homeIntent);
                Toast.makeText(getApplicationContext(),"Home", Toast.LENGTH_SHORT).show();
                break;
            default:
                // Unknown Error
        }
        return super.onOptionsItemSelected(item);
    }

    public void register(View view){
        String userEmail = email.getText().toString().trim();
        String pass1 = passwordA.getText().toString().trim();
        String pass2 = passwordB.getText().toString().trim();

        if(TextUtils.isEmpty(userEmail)){
            //  email is empty

            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass1)){
            //  first password is empty
            Toast.makeText(this, "Please enter password correctly", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass2)){
            //  Second password is empty
            Toast.makeText(this, "Please enter password correctly", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!(pass1.equals(pass2))){
            //  Passwords did not matched
            Toast.makeText(this, "Passwords did not matched", Toast.LENGTH_SHORT).show();
            return;
        }

        //  if everything checks out fine
        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(userEmail, pass1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            // Successful registration
                            Toast.makeText(SignupActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(SignupActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
