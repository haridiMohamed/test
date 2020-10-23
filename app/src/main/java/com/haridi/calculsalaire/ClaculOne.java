package com.haridi.calculsalaire;


import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClaculOne extends Fragment {
    private  AdView adView;
Button btnCalcul;
    EditText jour,ancin,jourFree,samdi,conge,prime,other;
    Double jour1,ancin1,jourFree1,samdi1,conge1,prime1,other1;
    SharedPreferences shared,shared1;
    final String KEY_SAVED_RADIO_BUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";


    public ClaculOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clacul_one, container, false);
        jour = (EditText) view.findViewById(R.id.jour);
        ancin =(EditText) view.findViewById(R.id.ancin);
        jourFree =(EditText) view.findViewById(R.id.jourFree);
        samdi =(EditText) view.findViewById(R.id.samdi);
        conge =(EditText) view.findViewById(R.id.conge);
        prime =(EditText) view.findViewById(R.id.prime);
        other =(EditText) view.findViewById(R.id.other);
        shared = getActivity().getSharedPreferences("Mypref", MODE_PRIVATE);
        btnCalcul = (Button) view.findViewById(R.id.calcul);

        if (shared!=null) {
            int checkedRadioButtonId = shared.getInt(KEY_SAVED_RADIO_BUTTON_INDEX, 0);
            System.out.println("checkedRadioButtonId" + checkedRadioButtonId);
            if (checkedRadioButtonId == 2131230876) {

                        jour.setHint("Nombre de Jours");
                ancin.setHint("Prime Anciennete");
                samdi.setHint("Nombre de samedis");
                conge.setHint("Jours conge");
                prime.setHint("Prime Variable");
                other.setHint("Prime Annuelle");
                jourFree.setHint("Jours Ferie ");
                btnCalcul.setText("Claculer");
                btnCalcul.setTextSize(12);

            }
        }

        btnCalcul.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
              //  calculOne(jour1,prix1);
                String jours= jour.getText().toString();
                String ancins =ancin.getText().toString();
                String jourFrees =jourFree.getText().toString();
                String samdis =samdi.getText().toString();
                String conges = conge.getText().toString();
                String primes =prime.getText().toString();
                String others =other.getText().toString();




                if(jours.isEmpty()||ancins.isEmpty()||jourFrees.isEmpty()||samdis.isEmpty()||conges.isEmpty()||primes.isEmpty()||others.isEmpty()){
                    int checkedRadioButtonId = shared.getInt(KEY_SAVED_RADIO_BUTTON_INDEX, 0);
                    System.out.println("checkedRadioButtonId" + checkedRadioButtonId);
                    if (checkedRadioButtonId == 2131230876) {
                        Toast.makeText(getActivity(), "Remplissez le vide", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(getActivity(), "يجب ملئ الفراغات ", Toast.LENGTH_SHORT).show();

                    }
                }
                else {

                    jour1 = Double.valueOf(jours);
                    ancin1 = Double.valueOf(ancins);
                    jourFree1 = Double.valueOf(jourFrees);
                    samdi1 = Double.valueOf(samdis);
                    conge1 = Double.valueOf(conges);
                    prime1 = Double.valueOf(primes);
                    other1 = Double.valueOf(others);
                    FragmentTransaction transection = getFragmentManager().beginTransaction();
                    ResultCalcul mfragment = new ResultCalcul();
                    //using Bundle to send data
                    Bundle bundle = new Bundle();
                    //  bundle.putDouble("textbox",prix1);
                    bundle.putDouble("jour", jour1);
                    bundle.putDouble("ancin", ancin1);
                    bundle.putDouble("jourFree", jourFree1);
                    bundle.putDouble("samdi", samdi1);
                    bundle.putDouble("conge", conge1);
                    bundle.putDouble("prime", prime1);
                    bundle.putDouble("other", other1);

                    mfragment.setArguments(bundle); //data being send to SecondFragment
                    transection.replace(R.id.frame, mfragment);
                    transection.isAddToBackStackAllowed();
                    transection.addToBackStack(null);
                    transection.commit();
                }
            }
        });

//        adView = (AdView) view.findViewById(R.id.adView);
//        // adRequest = new AdRequest.Builder().addTestDevice("5DE009358208E67E37FD2A7F7661044A").build();
//        //    adView.loadAd(adRequest);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);

        return view;
    }

    public double calculOne(Double jour){
        Double total;
        total = jour*8;
        return total;
    }

}
