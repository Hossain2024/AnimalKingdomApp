package edu.tacoma.uw.animalkingdomapp;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.app.BroadcastOptions;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import edu.tacoma.uw.animalkingdomapp.databinding.FragmentAnimalDetailBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnimalDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimalDetailFragment extends Fragment {

    private FragmentAnimalDetailBinding mBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentAnimalDetailBinding.inflate(inflater, container, false);
        return mBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Get a reference to the SafeArgs object
        AnimalDetailFragmentArgs args = AnimalDetailFragmentArgs.fromBundle(getArguments());
        Animal animal = (Animal) args.getAnimal();
        mBinding.idTextView.setText(Integer.toString(animal.getId()));
        mBinding.kindTextView.setText(animal.getKind());
        mBinding.nameTextView.setText(animal.getnName());
    }

}