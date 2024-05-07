package edu.tacoma.uw.animalkingdomapp;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.tacoma.uw.animalkingdomapp.databinding.FragmentAddAnimalBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddAnimalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddAnimalFragment extends Fragment {
    private FragmentAddAnimalBinding mBinding;
    private AnimalViewModel animalViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        animalViewModel = new ViewModelProvider(getActivity()).get(AnimalViewModel.class);

        mBinding = FragmentAddAnimalBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }
@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        animalViewModel.addResponseObserver(getViewLifecycleOwner(), response -> {

            observeResponse(response);

        });

        mBinding.addanimalbutton.setOnClickListener(button -> processAddAnimal());

    }

    private void processAddAnimal() {

        final String id = mBinding.id.getText().toString();

        final String kind = mBinding.kind.getText().toString();

        final String name = mBinding.name.getText().toString();



        Log.i(TAG, "Data is " + id + ", " + kind + ", " + name);

        animalViewModel.addAnimal(id, kind, name);



    }



    private void observeResponse(final JSONObject response) {

        if (response.length() > 0) {

            if (response.has("error")) {

                try {

                    Toast.makeText(this.getContext(),

                            "Error Adding Animal: " +

                                    response.get("error"), Toast.LENGTH_LONG).show();

                } catch (JSONException e) {

                    Log.e("JSON Parse Error", e.getMessage());

                }

            } else {

                Toast.makeText(this.getContext(),"Animal added", Toast.LENGTH_LONG).show();

            }

        } else {

            Log.d("JSON Response", "No Response");

        }

    }


}