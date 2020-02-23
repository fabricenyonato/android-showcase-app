package ws.roots.showcase.controller.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import ws.roots.showcase.controller.fragment.MainNavigationFragment;
import ws.roots.showcase.R;


public class MainActivity extends AppCompatActivity implements MainNavigationFragment.OnNavigationItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        setTitle(R.string.our_services);

        MainNavigationFragment mainNavigationFragment = new MainNavigationFragment();
//        OnboardingFragment onboardingFragment = new OnboardingFragment();

        getSupportFragmentManager()
        .beginTransaction()
        .add(R.id.main_activity_frame_layout, mainNavigationFragment)
        .commit();
    }

    @Override
    public void onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_navigation_fragment_menu_contacts:
                setTitle(R.string.contacts);
                break;

            case R.id.main_navigation_fragment_menu_promotions:
                setTitle(R.string.promotions);
                break;
            default:
                setTitle(R.string.our_services);
        }
    }
}
