package be.pxl.elision.wristlist.View.Profile;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import be.pxl.elision.wristlist.Model.Profile.Address;
import be.pxl.elision.wristlist.Model.Profile.Country;
import be.pxl.elision.wristlist.Model.Profile.Region;
import be.pxl.elision.wristlist.Model.Profile.User;
import be.pxl.elision.wristlist.R;
import be.pxl.elision.wristlist.View.BaseDrawerActivity;

/**
 * @author Timothy Vanderaerden
 */
public class ProfileActivity extends BaseDrawerActivity {
    private boolean isInEditingMode = false;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText emailEditText;
    private EditText addressEditText;
    private EditText cityEditText;
    private EditText postcodeEditText;
    private EditText phoneEditText;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAppBar(R.layout.app_bar_profile);
        getLayoutInflater().inflate(R.layout.activity_profile, (FrameLayout) findViewById(R.id.profileFrame));

        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.appbar_profile);

        // Set profile image
        ImageView profileImage = (ImageView) findViewById(R.id.image);
        profileImage.getLayoutParams().width = 460;
        profileImage.getLayoutParams().height = 460;
        profileImage.setImageResource(R.drawable.ic_person_white_48dp);

        setToolbarTitle(getResources().getString(R.string.profile));

        // FAB actions
        final FloatingActionButton actionButton = (FloatingActionButton) findViewById(R.id.fabAction);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isInEditingMode) {
                    isInEditingMode = true;
                    enableEditText(true);
                    Snackbar snackbar = Snackbar
                            .make(coordinatorLayout,
                                    getResources().getText(R.string.snackbar_profile_editing),
                                    Snackbar.LENGTH_LONG);
                    snackbar.show();
                    actionButton.setImageResource(R.drawable.ic_done_white_24dp);
                } else {
                    isInEditingMode = false;
                    enableEditText(false);
                    Snackbar snackbar = Snackbar
                            .make(coordinatorLayout,
                                    getResources().getText(R.string.snackbar_profile_saved),
                                    Snackbar.LENGTH_LONG)
                            .setActionTextColor(ContextCompat.getColor(v.getContext(), R.color.colorPrimaryDark))
                            .setAction(getResources().getText(R.string.button_undo), new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                }
                            });
                    snackbar.show();
                    actionButton.setImageResource(R.drawable.ic_mode_edit_white_24dp);
                }
            }
        });

        //Dummy Data
        User dummyUser = new User();
        Address dummyAddress = new Address();
        Country dummyCountry = new Country();
        Region dummyRegion = new Region();
        dummyUser.setFirstName("Timothy");
        dummyUser.setLastName("Vanderearden");
        dummyAddress.setEmail("timothyvanderaerden@gmail.com");
        dummyAddress.setPhone("0496348231");
        dummyCountry.setName(1);
        dummyAddress.setCountry(dummyCountry);
        dummyAddress.setTown("Lummen");
        dummyAddress.setFormattedAddress("Geneikenstraat 60");
        dummyRegion.setName("Limburg");
        dummyAddress.setRegion(dummyRegion);
        dummyAddress.setPostalCode("3560");
        dummyUser.setDefaultAddress(dummyAddress);
        //set dummy gui
        firstNameEditText = (EditText) findViewById(R.id.firstnameEditText);
        firstNameEditText.setText(dummyUser.getFirstName());
        lastNameEditText = (EditText) findViewById(R.id.lastnameEditText);
        lastNameEditText.setText(dummyUser.getLastName());
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        emailEditText.setText(dummyUser.getDefaultAddress().getEmail());
        addressEditText = (EditText) findViewById(R.id.addressLineEditText);
        addressEditText.setText(dummyAddress.getFormattedAddress());
        cityEditText = (EditText) findViewById(R.id.cityEditText);
        cityEditText.setText(dummyAddress.getTown());
        postcodeEditText = (EditText) findViewById(R.id.postcodeEditText);
        postcodeEditText.setText(dummyAddress.getPostalCode());
        phoneEditText = (EditText) findViewById(R.id.phoneEditText);
        phoneEditText.setText(dummyUser.getDefaultAddress().getPhone());
    }

    @Override
    protected void onResume() {
        super.onResume();
        // to check current activity in the navigation drawer
        setSelectedNavigationItem(1);
    }

    /**
     * Enable or disable all 'EditText' widgets
     * @param enable
     */
    private void enableEditText(boolean enable) {
        firstNameEditText.setEnabled(enable);
        lastNameEditText.setEnabled(enable);
        emailEditText.setEnabled(enable);
        addressEditText.setEnabled(enable);
        cityEditText.setEnabled(enable);
        postcodeEditText.setEnabled(enable);
        phoneEditText.setEnabled(enable);
    }
}