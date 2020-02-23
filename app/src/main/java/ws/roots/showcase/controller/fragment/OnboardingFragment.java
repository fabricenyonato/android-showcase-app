package ws.roots.showcase.controller.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ws.roots.showcase.R;


public class OnboardingFragment extends Fragment {
    public OnboardingFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.onboarding_fragment, container, false);

        v.findViewById(R.id.onboarding_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return  v;
    }
}
