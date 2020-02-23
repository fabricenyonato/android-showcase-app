package ws.roots.showcase.controller.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ws.roots.showcase.R;


public class PromotionsFragment extends Fragment {
    public PromotionsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.promotions_fragment, container, false);
    }
}
