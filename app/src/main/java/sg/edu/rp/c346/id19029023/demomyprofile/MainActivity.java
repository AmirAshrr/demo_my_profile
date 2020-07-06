package sg.edu.rp.c346.id19029023.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.PreferenceManager;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
EditText etName, etGPA;
RadioGroup rgGender;
Button save;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etGPA = findViewById(R.id.editTextGPA);
        etName = findViewById(R.id.editTextName);
save = findViewById(R.id.buttonSave);
save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = pref.edit();
        prefEdit.putString("name", etName.getText().toString());
        prefEdit.putFloat("gpa", Float.parseFloat(etGPA.getText().toString()));
        prefEdit.putInt("genderId", R.id.radioGroupGender);
    }
});
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String strName = pref.getString("name", "John");
        float gpa = pref.getFloat("gpa",0);
        int intGenderId = pref.getInt("genderId",R.id.radioButtonGenderMale)

        etName.setText(strName);
        etGPA.setText(gpa+ "");
        rgGender.check(intGenderId);


    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        String gpa1 = etGPA.getText().toString();
        Float gpa = Float.parseFloat(gpa1);
        int intGenderID = rgGender.getCheckedRadioButtonId();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = pref.edit();
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);
        prefEdit.putInt("genderId", intGenderID);
        prefEdit.commit();



    }
}
