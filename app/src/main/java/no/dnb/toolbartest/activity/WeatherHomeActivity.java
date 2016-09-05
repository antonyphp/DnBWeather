package no.dnb.toolbartest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import no.dnb.toolbartest.R;
import no.dnb.toolbartest.application.WeatherApplication;

public class WeatherHomeActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    private FragmentDrawer drawerFragment;
    @BindView(R.id.toolbar)public Toolbar mToolbar;
    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;
    private final String TAG = "WeatherHomeActivity";
    @BindString(R.string.title_overview) String title_overview;
    @BindString(R.string.title_hourly_forecast) String hourly_forecast;
    @BindString(R.string.title_daily_forecast) String daily_forecast;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        openFragment(new WeatherOverviewFragment(), getString(R.string.title_overview));

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
        if (id == R.id.action_search) {
            try {
                Intent intent =
                        new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                                .build(this);
                startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
            } catch (GooglePlayServicesRepairableException e) {
                // TODO: Handle the error.
            } catch (GooglePlayServicesNotAvailableException e) {
                // TODO: Handle the error.
            }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new WeatherOverviewFragment();
                title = title_overview;
                break;
            case 1:
                fragment = new DailyForecastFragment();
                title = daily_forecast;
                break;
            case 2:
                fragment = new HourlyForecastFragment();
                title = hourly_forecast;
                break;
            default:
                break;
        }
    openFragment(fragment, title);
    }

    private void openFragment(Fragment newFragment, String title) {
        if (newFragment != null) {
            Fragment containerFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
            if (containerFragment.getClass().getName().equalsIgnoreCase(newFragment.getClass().getName())) {
                return;
            }
            else{
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_body, newFragment);
                fragmentTransaction.commitAllowingStateLoss();

                // set the toolbar title
                getSupportActionBar().setTitle(title);

            }

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    }

    private void openFragment(Fragment fragment){
        String title;

        if(fragment instanceof WeatherOverviewFragment){
            title = title_overview;
        }
        else if(fragment instanceof HourlyForecastFragment){
            title = hourly_forecast;
        }
        else{
            title = daily_forecast;
        }
        openFragment(fragment,title);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(this, data);
                ((WeatherApplication)getApplication()).setLocation(place.getName().toString() + "," + place.getLocale());
                Log.i(TAG, "Place: " + place.getName().toString().split(",")[0]);
                Fragment fragment = new WeatherOverviewFragment();
                String title = getString(R.string.title_overview);
                openFragment(fragment,title);
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                // TODO: Handle the error.
                Log.i(TAG, status.getStatusMessage());

            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }
    }
}
