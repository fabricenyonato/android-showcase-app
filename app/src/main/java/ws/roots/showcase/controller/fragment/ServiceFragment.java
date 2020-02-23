package ws.roots.showcase.controller.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ws.roots.showcase.R;


public class ServiceFragment extends Fragment {
    public static String ARGS_POSITION = "position";
    private int[] _imageResource = {
        R.drawable.outsourcing,
        R.drawable.erp,
        R.drawable.it_security,
        R.drawable.application_development
    };
    private int[] _title = {
            R.string.outsourcing,
            R.string.erp,
            R.string.it_security,
            R.string.application_development
    };

    public ServiceFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.service_fragment, container, false);

        int position = getArguments().getInt(ARGS_POSITION);

        String content = getResources().getStringArray(R.array.our_services_content_text)[position];

        ((ImageView) v.findViewById(R.id.service_fragment_image_view)).setImageResource(_imageResource[position]);
        ((TextView) v.findViewById(R.id.service_fragment_title_text_view)).setText(_title[position]);
        ((TextView) v.findViewById(R.id.service_fragment_content_text_view)).setText(content);

        return v;
    }

    public static ServiceFragment newInstance(int position) {
        ServiceFragment f = new ServiceFragment();

        Bundle args = new Bundle();
        args.putInt(ARGS_POSITION, position);

        f.setArguments(args);

        return f;
    }
}
