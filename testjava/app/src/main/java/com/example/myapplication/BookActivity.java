package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class BookActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private Button requestButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initializeViews();
        setupViewPager();
        setupListeners();
    }

    private void initializeViews() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        requestButton = findViewById(R.id.requestButton);
        cancelButton = findViewById(R.id.cancelButton);
    }

    private void setupViewPager() {
        HolidayPagerAdapter pagerAdapter = new HolidayPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(position == 0 ? "Upcoming" : "Previous")
        ).attach();
    }

    private void setupListeners() {
        requestButton.setOnClickListener(v -> handleRequestClick());
        cancelButton.setOnClickListener(v -> handleCancelClick());
    }

    private void handleRequestClick() {
        // TODO: Implement request holiday logic
    }

    private void handleCancelClick() {
        finish();
    }

    private static class HolidayPagerAdapter extends FragmentStateAdapter {
        public HolidayPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return HolidayListFragment.newInstance(position == 0);
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }

    public static class HolidayListFragment extends Fragment {
        private static final String ARG_IS_UPCOMING = "isUpcoming";

        public static HolidayListFragment newInstance(boolean isUpcoming) {
            HolidayListFragment fragment = new HolidayListFragment();
            Bundle args = new Bundle();
            args.putBoolean(ARG_IS_UPCOMING, isUpcoming);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_edit, container, false);

            boolean isUpcoming = getArguments() != null &&
                    getArguments().getBoolean(ARG_IS_UPCOMING, true);

            TextView messageView = view.findViewById(R.id.street);
            messageView.setText(isUpcoming ? "No Upcoming Requests" : "No Previous Requests");

            return view;
        }
    }
}
