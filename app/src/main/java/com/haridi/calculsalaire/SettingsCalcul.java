package com.haridi.calculsalaire;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsCalcul extends Fragment {

    EditText prix,cnss,amo,igr,sups;
    TextView tprix,tcnss,tamo,tigr,tlange,titlep,supl;
    SharedPreferences shared,shared1;
    int langage ;
    final String KEY_SAVED_RADIO_BUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";

    public SettingsCalcul() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_settings_calcul, container, false);
        prix = (EditText) view.findViewById(R.id.prix);
        sups = (EditText) view.findViewById(R.id.sups);
        cnss = (EditText) view.findViewById(R.id.cnss);
        amo = (EditText) view.findViewById(R.id.amo);
        igr = (EditText) view.findViewById(R.id.igr);
        tprix = (TextView) view.findViewById(R.id.tprix);
        supl = (TextView) view.findViewById(R.id.supl);
        tcnss = (TextView) view.findViewById(R.id.tcnss);
        tamo = (TextView) view.findViewById(R.id.tamo);
        tigr = (TextView) view.findViewById(R.id.tigr);
        tlange = (TextView) view.findViewById(R.id.tlange);
        titlep = (TextView) view.findViewById(R.id.titlep);

        final RadioButton ar = (RadioButton) view.findViewById(R.id.radMale);
        RadioButton fr = (RadioButton) view.findViewById(R.id.radFemale);
        final RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radGroup);
        Button btn = (Button) view.findViewById(R.id.save);
        Button rest = (Button) view.findViewById(R.id.rest);
        //get data with shar preferences
        shared = getActivity().getSharedPreferences("Mypref", MODE_PRIVATE);
       // shared1 = getActivity().getSharedPreferences("Mypref1", MODE_PRIVATE);
        if (shared != null) {
            int checkedRadioButtonId = shared.getInt(KEY_SAVED_RADIO_BUTTON_INDEX, 0);
            System.out.println("checkedRadioButtonId" + checkedRadioButtonId);

            String prix1 = shared.getString("prix", "");
            String sup1 = shared.getString("sups", "");

            String cnss1 = shared.getString("cnss", "");
            String amo1 = shared.getString("amo", "");
            String igr1 = shared.getString("igr", "");
          if(prix1!=""||cnss1!=""||amo1!=""||igr1!=""||checkedRadioButtonId !=0||sup1!="") {
               cnss.setText(cnss1);
                  prix.setText(prix1);
                 sups.setText(sup1);
              System.out.println("  Prix get  "+prix1);
                amo.setText(amo1);
                igr.setText(igr1);
               radioGroup.check(checkedRadioButtonId);
           }else{
              prix.setText("14.13");
              cnss.setText("4.48");
              amo.setText("2.26");
              igr.setText("0.0");
              ar.setChecked(true);


          }
               if (checkedRadioButtonId == 2131230886) {
                   tprix.setText("Taux Heure");
                   tprix.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                   supl.setText("Taux Suplementaire");
                   supl.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                   tcnss.setText("C.N.S.S %");
                   tcnss.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                   tamo.setText("A.M.O  %");
                   tamo.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                   tigr.setText("I.G.R  %");
                   tigr.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                   tlange.setText("Langage");
                   tlange.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                   titlep.setText("Les donnees peuvent etre modifiees");
//                   ar.setText("العربية");
//                   fr.setText("France");
                   btn.setText("Save");
                   rest.setText("Rest");

               }
           }

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(RadioGroup group, int checkedIndex) {

                    if (ar.isChecked()) {
                        Toast.makeText(getActivity(), "العربية", Toast.LENGTH_SHORT).show();
                        langage = checkedIndex;
                        System.out.println(langage);

                    } else {
                        Toast.makeText(getActivity(), "France", Toast.LENGTH_SHORT).show();
                        langage = checkedIndex;
                        System.out.println(langage);
                    }

//
//                      SharedPreferences.Editor editor = shared1.edit();
//                    editor.clear();
//                    editor.putInt(KEY_SAVED_RADIO_BUTTON_INDEX, checkedIndex);
//                    editor.commit();

                }
            });

            //for save data with share preferences
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int checkedRadioButtonId = shared.getInt(KEY_SAVED_RADIO_BUTTON_INDEX, 0);
                    System.out.println("checkedRadioButtonId" + checkedRadioButtonId);
                    final String prixs = prix.getText().toString();
                    final String supss = sups.getText().toString();

                    final String cnsss = cnss.getText().toString();
                   final String amos = amo.getText().toString();
                    final String igrs = igr.getText().toString();

                    if(prixs.isEmpty()||cnsss.isEmpty()||amos.isEmpty()||igrs.isEmpty()){
//
                        if (checkedRadioButtonId == 2131230886) {
                            Toast.makeText(getActivity(), "Remplissez le vide", Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(getActivity(), "يجب ملئ الفراغات او اضغط اعادة الضبط ", Toast.LENGTH_SHORT).show();

                        }
//
                    }else {
                        SharedPreferences.Editor editor = shared.edit();
                       // SharedPreferences.Editor editor1 = shared1.edit();
                        editor.clear();
                        editor.putString("prix", prixs);
                        editor.putString("sups", supss);

                        System.out.println("  Prix Save   "+prixs);

                        editor.putString("cnss", cnsss);
                        editor.putString("amo", amos);
                        editor.putString("igr", igrs);
                        editor.putInt(KEY_SAVED_RADIO_BUTTON_INDEX, langage);

                        editor.commit();

                        if (checkedRadioButtonId == 2131230886) {
                            Toast.makeText(getActivity(), "Donnees sauvegardees avec succes", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(getActivity(), "لقد تم تسجيل البيانات بنجاح", Toast.LENGTH_SHORT).show();
                        }
                        Thread thread = new Thread() {

                            @Override
                            public void run() {
                                try {
                                    sleep(1000);

                                    Intent intent = new Intent(getActivity(), SplashScreen.class);
                                    startActivity(intent);
                                    getActivity().finish();



                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                        };

                        thread.start();
                    }

                }

            });
        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               // shared.edit().remove("text").commit();
                prix.setText("14.13");
                cnss.setText("4.48");
                amo.setText("2.26");
                igr.setText("0.0");
                sups.setText("125");

                ar.setChecked(true);
                System.out.println("shared   "+ shared);


            }
        });



        return view;
        }



    }
