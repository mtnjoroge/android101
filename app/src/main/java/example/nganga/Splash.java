/**
 * Created by nganga on 7/24/15.
 */

package example.nganga;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Splash extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);

    // Intitializing the thread that allows splash image show before the main activity

    Thread startTimer = new Thread(){
        public void run(){
            try {
                sleep(5000);
                Intent i = new Intent(Splash.this, Main.class);
                startActivity(i);
                finish();
            }
             catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    };
    startTimer.start();
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
