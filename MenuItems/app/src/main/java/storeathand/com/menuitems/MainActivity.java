package storeathand.com.menuitems;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage("fab icon click");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("progress");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.show();
            }
        }, 5000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        }, 10000);
    }

    private void showMessage(String msg) {
        Snackbar.make(fab, msg, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.newOrder:
                showMessage("Create New Order Clicked");
                return true;
            case R.id.sync:
                showMessage("Sync with Server Clicked");
                return true;
            case R.id.pendingOrders:
                showMessage("Pending Order Clicked");
                return true;
            case R.id.completedOrder:
                showMessage("Completed Order Clicked");
                return true;
            case R.id.dailySales:
                showMessage("Day Sales Report Clicked");
                return true;
            case R.id.shoppingList:
                showMessage("Quick Order List Clicked");
                return true;
            case R.id.orderSalesReport:
                showMessage("Order Sales Report Clicked");
                return true;
            case R.id.paymentReport:
                showMessage("Day Statement Clicked");
                return true;
            case R.id.creditReport:
                showMessage("Credit Report Clicked");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
