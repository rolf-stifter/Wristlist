package be.pxl.elision.wristlist.View.Profile;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import be.pxl.elision.wristlist.Model.Profile.Address;
import be.pxl.elision.wristlist.Model.Profile.Country;
import be.pxl.elision.wristlist.Model.Profile.Region;
import be.pxl.elision.wristlist.Model.Profile.User;
import be.pxl.elision.wristlist.R;
import be.pxl.elision.wristlist.View.BaseDrawerActivity;


public class ProfileActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAppBar(R.layout.app_bar_profile);
        getLayoutInflater().inflate(R.layout.activity_profile, (FrameLayout) findViewById(R.id.profileFrame));

        // Set profile image
        ImageView profileImage = (ImageView) findViewById(R.id.image);
        profileImage.getLayoutParams().width = 460;
        profileImage.getLayoutParams().height = 460;
        profileImage.setImageResource(R.drawable.ic_person_white_48dp);

        setToolbarTitle(getResources().getString(R.string.profile));

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
        EditText firstNameEditText = (EditText) findViewById(R.id.firstnameEditText);
        firstNameEditText.setText(dummyUser.getFirstName());
        EditText lastNameEditText = (EditText) findViewById(R.id.lastnameEditText);
        lastNameEditText.setText(dummyUser.getLastName());
        EditText emailEditText = (EditText) findViewById(R.id.emailEditText);
        emailEditText.setText(dummyUser.getDefaultAddress().getEmail());
        EditText addressEditText = (EditText) findViewById(R.id.addressLineEditText);
        addressEditText.setText(dummyAddress.getFormattedAddress());
        EditText cityEditText = (EditText) findViewById(R.id.cityEditText);
        cityEditText.setText(dummyAddress.getTown());
        EditText poscodeEditText = (EditText) findViewById(R.id.postcodeEditText);
        poscodeEditText.setText(dummyAddress.getPostalCode());
        EditText phoneEditText = (EditText) findViewById(R.id.phoneEditText);
        phoneEditText.setText(dummyUser.getDefaultAddress().getPhone());
    }

    @Override
    protected void onResume() {
        super.onResume();
        // to check current activity in the navigation drawer
        setSelectedNavigationItem(1);
    }
}
