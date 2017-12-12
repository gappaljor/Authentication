package tibet.paljor.authentication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class SinginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);
        Toolbar myActionbar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(myActionbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.signup_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.SignUp:
                //  Action
                Intent intent = new Intent(this, SignupActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Sign Up", Toast.LENGTH_SHORT).show();
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
}
