package com.spine.printutils;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Map;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class PrinterIntent extends IntentService {

    PrintBuilder Printer;
    ArrayList<Map<String, Object>> KOTS=new ArrayList<>();
    ArrayList<String> Kitchens=new ArrayList<>();
    private String Floor,OrderID,OrderType,TableNumber,SubTable,Orderer,CustomText;
    private ArrayList<String> Floors=new ArrayList<>();

    ArrayList<String> KitchenNames=new ArrayList<>();
    static int f=10;

String Sum;


    public PrinterIntent() {
        super("PrinterIntent");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {

       synchronized (this) {

           assert intent != null;
           Sensor sensor = (Sensor) intent.getExtras().getSerializable("Sensor");
           assert sensor != null;
           this.KOTS = sensor.getKOTS();
           this.Kitchens = sensor.getKitchens();
           this.Floor = sensor.getFloor();
           this.OrderID = sensor.getOrderID();
           this. OrderType = sensor.getOrderType();
           this.TableNumber = sensor.getTableNumber();
           this.SubTable = sensor.getSubTable();
           this.Orderer = sensor.getOrderer();
           this.CustomText = sensor.getCustomText();
           this.Floors = sensor.getFloors();
           this.Sum = sensor.getSum();
           this.KitchenNames = sensor.getKitchenNames();



            Printer = new PrintBuilder(PrinterIP.FetchIP(0, Floor), getApplicationContext());
            try {
                wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }



        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

synchronized (this){

    {





        Log.v("SSS","1");

        int p=2;

        if(Floor.equals("4")){
            p=1;

        }

        //   int itemCount=0;
        for (int k = 0; k < p; k++) {

            Log.v("SSS", "4");





            Printer.resetPrint();

            Printer.printInitFormat();
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printText(new byte[]{0x1B, 0x21, 0x19});
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printCustom("Consolidated", 3, 1);
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            Printer.printNewLine();
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printCustom("KOT : " + OrderID, 3, 1);
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //    Printer.printNewLine();
            Printer.printCustom(OrderType, 3, 1);
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String Date = Printer.getDateTime()[0], Time = Printer.getDateTime()[1];
            Printer.printCustom(Floors.get(Integer.valueOf(Floor)), 2, 1);
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }           //  Printer.printNewLine();
            Printer.printCustom(Date + "  " + Time, 3, 1);
            // Printer.printNewLine();
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printCustom("TABLE : " + TableNumber, 2, 1);
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printCustom("SUB ORDER : " + SubTable, 2, 1);
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Printer.printNewLine();


            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            // Printer.printCustom("KOT : "+OrderID,3,1);

            Printer.printCustom("ORDERED BY : " + Orderer, 1, 0);
            //i++;
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printText(PrintService.LEFT_MARGIN);
            //i++;
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.PrintLine();
            //i++;
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int y = 0;
            for (int w = 0; w < KOTS.size(); w++) {

                try {
                    wait(f);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                y++;
                String P = String.valueOf(KOTS.get(w).get("Item"));
                String Q = String.valueOf(KOTS.get(w).get("Quantity"));

                //  Printer2.FourColumAlighPrint(P, "QTY", "".toUpperCase(), Q);
                if (!Q.equals("0")) {
                    Printer.IndexColumnPrint(Q + ".", P);
                }
                if (KOTS.get(w).get("Note") != null) {
                    try {
                        wait(f);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //    itemCount++;
                    Printer.printNote("(" + String.valueOf(KOTS.get(w).get("Note")) + ")");
                    // Printer.printNewLine();
                }

            }
            // i++;
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.PrintLine();
            //i++;

            //Printer2.printCustom("THIS IS NOT A BILL ONLY THE TABULATED ORDER",0,1);
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (CustomText != null) {
                try {
                    wait(f);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Printer.printNewLine();
                try {
                    wait(f);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (!CustomText.trim().equals("")) {
                    Printer.printNewLine();
                    Printer.printCustom(("SPECIAL NOTE  :" + CustomText).toUpperCase(), 1, 1);
                }
            }
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printCustom(">..**" + Sum + "**..<", 0, 1);
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printNewLine();


                                 /*   if(CustomText!=null){
                                     //   Printer2.printNewLine();
                                        Printer2.printCustom("**Special Note :"+CustomText,1,0);
                                    }*/

            //i++;
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printLongFeed();

            //i++;
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for( int q=0;q<Kitchens.size();q++){



            final int finalQ = q;


            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }




            int SItemCount=0;

            //  Printer.FourColumAlighPrint("PRODUCT","RATE","QTY","TOTAL");

            try {
                wait(75);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.resetPrint();
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printInitFormat();
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printText(new byte[]{0x1B, 0x21, 0x19});

            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Printer.FourColumAlighPrint("IAM Ashhar","MyN","124","120");
            //  Printer.FourColumAlighPrint("IAM Ashhar","MyN","124","2120");
            // Printer.FourColumAlighPrint("IAM Ashhar","MyN","124","5124578.00");




            //  Printer.PrintLine();
            //  Printer.printNewLine();
            //  Printer.printTextO(Printer.FourColumAligh("IAM Ashhar","MyN","124","120"));




            Printer.printCustom("KOT : " + OrderID, 3, 1);
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //String Date = Printer.getDateTime()[0], Time = Printer.getDateTime()[1];
            // Printer.printNewLine();
            Printer.printCustom(OrderType, 3, 1);
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }           //Printer.printNewLine();
            Printer.printCustom(Floors.get(Integer.valueOf(Floor)), 2, 1);
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }           //Printer.printNewLine();
            //  Printer.printCustom(Date + "  " + Time, 2, 1);
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }           //Printer.printNewLine();
            Printer.printCustom("TABLE : " + TableNumber , 2, 1);
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }           //  Printer.printNewLine();
            String Date = Printer.getDateTime()[0], Time = Printer.getDateTime()[1];
            Printer.printCustom(Date + "  " + Time, 3, 1);


            Printer.printCustom("SUB ORDER : " + SubTable, 2, 1);
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }           //i++;

            Printer.printNewLine();
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printText(PrintService.LEFT_MARGIN);
            //i++;
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printCustom("ORDERED BY : " + Orderer, 1, 0);
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Printer.printNewLine();
            Printer.printCustom("KITCHEN : " + KitchenNames.get(Integer.valueOf(Kitchens.get(finalQ))), 1, 0);

            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Printer.PrintLine();
            //i++;
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int y = 0;

            for(int a=0;a<KOTS.size();a++){
                if(String.valueOf(KOTS.get(a).get("Kitchen")).equals(Kitchens.get(finalQ))){

                    try {
                        wait(f);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    SItemCount++;

                    y++;
                    String P = String.valueOf(KOTS.get(a).get("Item"));
                    String Q = String.valueOf(KOTS.get(a).get("Quantity"));

                    //  Printer.FourColumAlighPrint(P, "QTY", "".toUpperCase(), Q);
                    if(!Q.equals("0")) {
                        Printer.IndexColumnPrint(Q + ".", P);
                    }
                    if(KOTS.get(a).get("Note")!=null){

                        try {
                            wait(f);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Printer.printNote("("+ String.valueOf(KOTS.get(a).get("Note"))+")");


                        // Printer.printNewLine();
                    }


                }





            }
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.PrintLine();
            //i++;
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(CustomText!=null){
                try {
                    wait(f);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Printer.printNewLine();
                try {
                    wait(f);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(!CustomText.trim().equals("")) {
                    Printer.printCustom(("SPECIAL NOTE  :" + CustomText).toUpperCase(), 1, 1);
                }
            }
            //  Printer.printCustom("THIS IS NOT A BILL ONLY THE TABULATED ORDER", 0, 1);

            Printer.printCustom(">..**"+Sum+"**..<", 0, 1);
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printNewLine();

            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                                                                    /*    if(CustomText!=null){
                                                                            //Printer.printNewLine();
                                                                            Printer.printCustom("**Special Note :"+CustomText,0,0);
                                                                        }
                                                                        */
            // i++;

            //i++;

            Printer.printLongFeed();
            try {
                wait(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //i++;









            //  Printer.printInitFormat();
            // String Date=Printer.getDateTime()[0] ,Time=Printer.getDateTime()[1];
            //    Printer.printUnicode();
            //  Printer.printNewLine();


        }





    }






}


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Printer.Finish();

        Toast.makeText(this, "ORDER GENERATED SUCCESSFULLY 1", Toast.LENGTH_SHORT).show();

    }
}
