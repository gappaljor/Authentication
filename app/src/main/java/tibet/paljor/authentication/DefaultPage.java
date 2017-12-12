package tibet.paljor.authentication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class DefaultPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_page);
        Toolbar myActionbar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(myActionbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.logIn:
                //  Action
                Intent login = new Intent(this, SinginActivity.class);
                startActivity(login);
                Toast.makeText(getApplicationContext(),"Log in", Toast.LENGTH_SHORT).show();
                break;
            case R.id.SignUp:
                //  Action
                Intent signup = new Intent(this, SignupActivity.class);
                startActivity(signup);
                Toast.makeText(getApplicationContext(),"Sign up", Toast.LENGTH_SHORT).show();
                break;
            default:
                // Unknown Error
        }
        return super.onOptionsItemSelected(item);
    }
}
