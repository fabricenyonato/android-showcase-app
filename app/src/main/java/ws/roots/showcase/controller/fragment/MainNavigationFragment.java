package ws.roots.showcase.controller.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.navigation.NavigationView;
import ws.roots.showcase.R;


public class MainNavigationFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar _toolbar;
    private DrawerLayout _drawerLayout;

    private Fragment _contactsFragment = new ContactsFragment();
    private Fragment _promotionsFragment = new PromotionsFragment();
    private Fragment _ourServicesFragment = new OurServicesFragment();

    public MainNavigationFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_navigation_fragment, container, false);

        _toolbar = v.findViewById(R.id.main_navigation_fragment_toolbar);
        _drawerLayout = v.findViewById(R.id.main_navigation_fragment_drawer_layout);
        NavigationView navigationView = v.findViewById(R.id.main_navigation_fragment_navigation_view);

        navigationView.setNavigationItemSelectedListener(this);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((AppCompatActivity) getActivity()).setSupportActionBar(_toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            getActivity(),
            _drawerLayout,
            _toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        );

        _drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(android.R.color.white));

        _nav(_ourServicesFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        _drawerLayout.closeDrawer(GravityCompat.START);

        ((OnNavigationItemSelectedListener) getActivity()).onNavigationItemSelected(item);

        int id = item.getItemId();

        if (id == R.id.main_navigation_fragment_menu_contacts)
            _nav(_contactsFragment);
        else if (id == R.id.main_navigation_fragment_menu_promotions)
            _nav(_promotionsFragment);
        else {
            int i = 0;

            if (id == R.id.main_navigation_fragment_menu_outsourcing)
                i = 0;
            else if (id == R.id.main_navigation_fragment_menu_erp)
                i = 1;
            else if (id == R.id.main_navigation_fragment_menu_it_security)
                i = 2;
            else if (id == R.id.main_navigation_fragment_menu_application_development)
                i = 3;

            _nav(_ourServicesFragment);

            ((OurServicesFragment) _ourServicesFragment).setCurrentItem(i);
        }

        return true;
    }

    private void _nav(Fragment fragment) {
        if (fragment.isVisible()) {
            return;
        }

        getFragmentManager()
        .beginTransaction()
        .replace(R.id.main_navigation_fragment_content, fragment)
        .commit();
    }

    public interface OnNavigationItemSelectedListener {
        void onNavigationItemSelected(@NonNull MenuItem item);
    }
}
