package ws.roots.showcase.controller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import ws.roots.showcase.R;


public class OurServicesFragment extends Fragment {
    private ViewPager _viewPager;

    public OurServicesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.our_services_fragment, container, false);

        _viewPager = v.findViewById(R.id.our_services_fragment_view_pager);
        _viewPager.setAdapter(new PageAdapter());

        return v;
    }

    public void setCurrentItem(int position) {
        _viewPager.setCurrentItem(position);
    }

    public class PageAdapter extends FragmentPagerAdapter {
        public PageAdapter() {
            super(OurServicesFragment.this.getFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return ServiceFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
