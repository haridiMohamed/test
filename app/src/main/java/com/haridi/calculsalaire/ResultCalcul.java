package com.haridi.calculsalaire;


import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
@RequiresApi(api = Build.VERSION_CODES.N)
public class ResultCalcul extends Fragment {
    TextView txtv;
    Double jour;
    Double heurs1;
    Double prix = 14.13;
    Double jourfree;
    Double jourconge;
    Double sup;
    Double prime;
    Double samdi;
    Double other;
    Double amo =2.26;
    Double cnss=4.48;
    Double igr=0.0;
    int pronsontage=125;
    SharedPreferences shared;
    final String KEY_SAVED_RADIO_BUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";
   // private static DecimalFormat formatter = new DecimalFormat(".##");
    private AdView adView ;

    public ResultCalcul() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_result_calcul, container, false);

        TextView heurs = (TextView)  view.findViewById(R.id.heurs);
        TextView theur = (TextView)  view.findViewById(R.id.theur);
        TextView ttheur = (TextView)  view.findViewById(R.id.jour);
        TextView ttheurs = (TextView)  view.findViewById(R.id.ttheurs);

        TextView tprix = (TextView)  view.findViewById(R.id.prix);
        TextView prixtheurs= (TextView)  view.findViewById(R.id.prixtheurs);
        //___________________________________
        TextView tprix1 = (TextView)  view.findViewById(R.id.prix1);
        TextView tprixtSup = (TextView)  view.findViewById(R.id.prixtSup);
        TextView tsup = (TextView)  view.findViewById(R.id.tsup);
        TextView ttsup = (TextView)  view.findViewById(R.id.ttsup);
        TextView tpronsontage = (TextView)  view.findViewById(R.id.pronsontage);
        //____________________________________
        TextView heurfree = (TextView)  view.findViewById(R.id.theurfree);
        TextView theurfree = (TextView)  view.findViewById(R.id.ttheurfree);
        TextView tprix2 = (TextView)  view.findViewById(R.id.prix2);
        TextView tfree = (TextView)  view.findViewById(R.id.freetheurs);
        //____________________________________
        //____________________________________
        TextView tancin = (TextView)  view.findViewById(R.id.ancin);
        TextView ttancin = (TextView)  view.findViewById(R.id.tancin);
        TextView tpronsAncin = (TextView)  view.findViewById(R.id.pronsAncin);
        TextView ttotalAncien = (TextView)  view.findViewById(R.id.totalAncien);
        //____________________________________
        //____________________________________
        TextView tconge = (TextView)  view.findViewById(R.id.conge);
        TextView ttheurconge = (TextView)  view.findViewById(R.id.theurconge);
        TextView tttheurconge = (TextView)  view.findViewById(R.id.ttheurconge);
        TextView tcongetheurs = (TextView)  view.findViewById(R.id.congetheurs);
        TextView tprix4 = (TextView)  view.findViewById(R.id.prix4);

        //____________________________________

        TextView tprimeV = (TextView)  view.findViewById(R.id.primeV);
        TextView ttprimeV = (TextView)  view.findViewById(R.id.tprimeV);
        TextView tprimeAnnee = (TextView)  view.findViewById(R.id.primeAnnee);
        TextView ttprimeAnnee = (TextView)  view.findViewById(R.id.tprimeAnnee);

        TextView tsalairebrut = (TextView)  view.findViewById(R.id.salairebrut);
        TextView ttsalairebrut = (TextView)  view.findViewById(R.id.tsalairebrut);

        TextView ttcnss = (TextView)  view.findViewById(R.id.cnss);
        TextView tttcnss = (TextView)  view.findViewById(R.id.tcnss);
        TextView ttamo = (TextView)  view.findViewById(R.id.amo);
        TextView tttamo = (TextView)  view.findViewById(R.id.tamo);
        TextView tigr = (TextView)  view.findViewById(R.id.igr);
        TextView ttigr = (TextView)  view.findViewById(R.id.tigr);
        TextView tnet = (TextView)  view.findViewById(R.id.net);
        TextView ttnet = (TextView)  view.findViewById(R.id.tnet);
        adView = (AdView) view.findViewById(R.id.adView);
        // adRequest = new AdRequest.Builder().addTestDevice("5DE009358208E67E37FD2A7F7661044A").build();
        //    adView.loadAd(adRequest);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        shared = getActivity().getSharedPreferences("Mypref", MODE_PRIVATE);
        if (shared != null) {
            int checkedRadioButtonId = shared.getInt(KEY_SAVED_RADIO_BUTTON_INDEX, 0);
            String prix1 = shared.getString("prix", "");
            String sup1 = shared.getString("sups", "");
            String cnss1 = shared.getString("cnss", "");
            String amo1 = shared.getString("amo", "");
            String igr1 = shared.getString("igr", "");
            if (prix1 != "" || cnss1 != "" || amo1 != "" || igr1 != "" || sup1 != "") {
                cnss = Double.valueOf(cnss1);
                prix = Double.valueOf(prix1);
                pronsontage = Integer.valueOf(sup1);
                amo = Double.valueOf(amo1);
                igr = Double.valueOf(igr1);
                System.out.println("checkedRadioButtonId" + checkedRadioButtonId);

                } if (checkedRadioButtonId != 2131230876) {
                ttheur.setText("عدد الساعات");
                ttsup.setText("الساعات الاضافية");
                ttsup.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                theurfree.setText("ايام الاعياد");
                theurfree.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                ttancin.setText("نسبة الاقدمية");
                ttancin.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                tttheurconge.setText(" العطلة السنوية ");
                tttheurconge.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                ttprimeV.setText("الحوافز");
                ttprimeV.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                ttprimeAnnee.setText("اضافات اخرى");
                ttprimeAnnee.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                ttheurs.setText("الساعات العادية");
                ttheurs.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                ttsalairebrut.setText("الراتب إجمالي");
                ttsalairebrut.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                tttcnss.setText(" الضمان الاجتماعي");
                tttcnss.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                tttamo.setText(" التغطية الصحية");
                tttamo.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                ttigr.setText("الضريبة على الدخل");
                ttigr.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                ttnet.setText("الراتب الصافي");
                ttnet.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);

            } else{
                 amo =2.26;
                 cnss=4.48;
                 igr=0.0;
                 pronsontage=125;
                 prix = 14.13;

            }
        }

     //   DecimalFormat formatter = new DecimalFormat("#.##");
        //DecimalFormat formatter = new DecimalFormat("#.00");


        Bundle bundle=getArguments();
     //   heurs.setText(String.valueOf(bundle.getDouble("jour")));

        jour = bundle.getDouble("jour");
        samdi = bundle.getDouble("samdi");
        System.out.println("________________"+jour);
        System.out.println("________________"+samdi);


        if(jour==0.0){
            jour = bundle.getDouble("heurs");
            samdi = bundle.getDouble("heursup1");
            System.out.println("________heurs________"+jour);
            System.out.println("________heursup1________"+samdi);

        }else{
        samdi =samdi*4;
        jour=jour*8;}

//        String dx1 = formatter.format(jour);
//        jour=Double.valueOf(dx1);

       Double Calculnormal =  Calculnormal(jour,samdi);
       Double Calcultotalnormal= Calcultotalnormal(Calculnormal,prix);
    //    String dx1 = formatter.format(Calcultotalnormal);
      //  Calcultotalnormal=Double.valueOf(dx1);
        heurs.setText(jour.toString());
        theur.setText(Calculnormal.toString());
        tprix.setText(prix.toString());
        prixtheurs.setText(String.format("%.2f",Calcultotalnormal));
        //____________________________________

        tprix1.setText(prix.toString());
        tsup.setText(samdi.toString());
        Double calculSup=samdi*prix*pronsontage/100;
        //convert 2 number aftr dot
      //  String dx = formatter.format(calculSup);
     //   calculSup=Double.valueOf(dx);
       // calculSup= Double.valueOf(formatter.format(calculSup));
        tprixtSup.setText(String.format("%.2f",calculSup));
        tpronsontage.setText(String.valueOf(pronsontage));
        //________________________________________

        jourfree = bundle.getDouble("jourFree");
        jourfree=jourfree*8;
        Double totalFree = jourfree*prix;
     //   String dx2 = formatter.format(totalFree);
       // totalFree = Double.valueOf(dx2);
        tprix2.setText(prix.toString());
        heurfree.setText(jourfree.toString());
        tfree.setText(String.format("%.2f",totalFree));
        //_________________________________________
        jourconge = bundle.getDouble("conge");
        jourconge=jourconge*8;
        Double tjourconge = jourconge*prix;
       // String dx3 = formatter.format(tjourconge);
       // tjourconge = Double.valueOf(dx3);
        tprix4.setText(prix.toString());
        ttheurconge.setText(jourconge.toString());
        tcongetheurs.setText(String.format("%.2f",tjourconge));
//        //__________________________________
       Double ancin = bundle.getDouble("ancin");
      Double calculAncien =  calculAncien(Calcultotalnormal,calculSup,totalFree,tjourconge);
//
      //  String dx5 = formatter.format(calculAncien);
      //  calculAncien = Double.valueOf(dx5);
        tancin.setText(String.format("%.2f",calculAncien));
        tpronsAncin.setText(ancin.toString());
        Double totalAncien = (ancin*calculAncien)/100;
      //  String dx4 = formatter.format(totalAncien);
       //  totalAncien=Double.valueOf(dx4);
        ttotalAncien.setText(String.format("%.2f",totalAncien));
        //_________________________________________________

        prime = bundle.getDouble("prime");
        other = bundle.getDouble("other");
        tprimeV.setText(String.valueOf(prime));
        tprimeAnnee.setText(String.valueOf(other));


    Double  tsalaireBrut=    SalaireBrut(Calcultotalnormal,calculSup,totalFree,tjourconge,totalAncien,prime);
 //  String dx9 =formatter.format(tsalaireBrut);
//   tsalaireBrut=Double.valueOf(dx9);
        tsalairebrut.setText(String.format("%.2f",tsalaireBrut));
        Double tcnss = tsalaireBrut*cnss/100;
     //   String dx6 = formatter.format(tcnss);
     //   String.format("%.2f",tcnss);
      //  tcnss=Double.valueOf(dx6);
        Double tamo = tsalaireBrut*amo/100;
        //String dx7 = formatter.format(tamo);
       // tamo = Double.valueOf(dx7);
        ttcnss.setText(String.format("%.2f",tcnss));
        ttamo.setText(String.format("%.2f",tamo));
        Double others= Double.valueOf(other);
        Double SalairImposable = tsalaireBrut+others;
        Double igrs = SalairImposable*igr/100;
      //  String dx10 = formatter.format(igrs);
       // igrs = Double.valueOf(dx10);

        tigr.setText(String.format("%.2f",igrs));


      Double salaireNet=  SalaireNet(tsalaireBrut,tcnss,tamo,igrs);
   //   String dx8 = formatter.format(salaireNet);
    //  salaireNet = Double.valueOf(dx8);
tnet.setText(String.format("%.2f",salaireNet+others));


        return view;
    }
public Double Calculnormal(Double jour, Double samdi){
        Double totalheurs;
        totalheurs=jour-samdi;
        return totalheurs;
}
    public Double Calcultotalnormal(Double jour, Double prix){
        Double totalheurs;
        totalheurs=jour*prix;
        return totalheurs;
    }public Double calculAncien(Double normal , Double sup, Double free,Double conge){
        Double totalAncien = null;
        totalAncien = normal+sup+free+conge;
        return totalAncien;
    }

    public Double SalaireBrut(Double normal , Double sup , Double jourfree , Double jourconge,Double ancien ,Double primeVariable ){

        Double
        salaireBrut = normal+sup+jourfree+jourconge+ancien+primeVariable;
        return salaireBrut;
    }

public Double SalaireNet(Double salairebrut ,Double cnss,Double amo,Double igr){
    Double salaireNet;
         salaireNet = salairebrut-(cnss+amo+igr);
        return salaireNet;
}


}
