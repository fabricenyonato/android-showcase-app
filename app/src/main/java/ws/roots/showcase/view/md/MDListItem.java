package ws.roots.showcase.view.md;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import ws.roots.showcase.R;


public class MDListItem extends LinearLayout {
    public MDListItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        inflate(context, R.layout.md_list_item, this);

        ImageView imageView = findViewById(R.id.md_list_item_image);
        TextView titleTextView = findViewById(R.id.md_list_item_title);
        TextView subtitleTextView = findViewById(R.id.md_list_item_subtitle);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.MDListItem);

        imageView.setImageDrawable(attributes.getDrawable(R.styleable.MDListItem_image));
        titleTextView.setText(attributes.getString(R.styleable.MDListItem_title));
        subtitleTextView.setText(attributes.getString(R.styleable.MDListItem_subtitle));

        attributes.recycle();
    }
}
