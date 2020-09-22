package com.spine.printutils;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

public class DeleteSyncPrintCont extends AsyncTask<Void, Void, Void> {
    Context context;
    boolean proceed;
    private OutputStream outputStream;
    private Socket socket;

    private String Floor,OrderID,OrderType,TableNumber,SubTable,Orderer;
    private ArrayList<String> Floors=new ArrayList<>();
    private TextView Sum;
    int x=0;
    static int f=10;
    TPrinter Printer;
    String IP,IP2;
    Map<String, Object> DEL = new HashMap<>();
    boolean SuccessK=true   ,SuccessF=true;

    public DeleteSyncPrintCont(Context context, String IP, String IP2, String floor, String orderID, String orderType, String tableNumber, String subTable, String orderer, ArrayList<String> floors, TextView sum, Map<String, Object> DEL) {
        this.context = context;
        Floor = floor;
        OrderID = orderID;
        OrderType = orderType;
        TableNumber = tableNumber;
        SubTable = subTable;
        Orderer = orderer;
        Floors = floors;
        Sum = sum;

        this.IP = IP;
        this.DEL = DEL;
        this.IP2=IP2;
    }

    @Override
    protected Void doInBackground(Void... voids) {




        //final TPrinter FChecker=new TPrinter(IP,context);
  /*      final TPrinter2 FChecker=new TPrinter2(IP,context);
        if(!FChecker.getStatus()) {
SuccessF=false;

        }else {


            FChecker.Finish();

/*


            final TPrinter2 KChecker = new TPrinter2(IP2, context);

            if (!KChecker.getStatus()) {
SuccessK=false;
            } else {

                KChecker.Finish();

                SuccessK=true;
                SuccessF=true;

                */
        synchronized (this){






            Printer = new TPrinter();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.resetPrint();
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printInitFormat();
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printText(new byte[]{0x1B, 0x21, 0x19});
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            Printer.printCustom("KOT : " + OrderID, 3, 1);
            //  Printer.printNewLine();
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String Date = Printer.getDateTime()[0], Time = Printer.getDateTime()[1];
            // Printer.printNewLine();
            Printer.printCustom(OrderType, 3, 1);
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }   //Printer.printNewLine();
            Printer.printCustom(Floors.get(Integer.valueOf(Floor)), 2, 1);
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }   //Printer.printNewLine();
            Printer.printCustom(Date + "  " + Time, 3, 1);
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }     //Printer.printNewLine();
            Printer.printCustom("TABLE : " + TableNumber + "  SUB ORDER" + SubTable, 2, 1);
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //i++;

            Printer.printNewLine();
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printText(PrintService.LEFT_MARGIN);
            //i++;
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printCustom("ORDERED BY : " + Orderer, 1, 0);
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //    Printer.printCustom("KITCHEN : " + ds.getString("Name"), 1, 0);
            //i++;
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.PrintLine();
            //i++;
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String P = String.valueOf(DEL.get("Item"));
            String Q = String.valueOf(DEL.get("Quantity"));
            Log.v("poiuy",P+" "+Q);

            //   Printer.FourColumAlighPrint(P, "CANCEL", "".toUpperCase(), Q);
            Printer.IndexColumnPrint(Q+"",P);
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printCustom("ORDER CANCELLED",5,1);

            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //  }
            // i++;
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.PrintLine();
            //i++;
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printCustom("THIS IS NOT A BILL ONLY THE TABULATED ORDER", 0, 1);
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printCustom(">..**"+Sum.getText().toString()+"**..<", 0, 1);
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printNewLine();
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printLongFeed();
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.Finish();
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }





            Printer = new TPrinter();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.resetPrint();
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printInitFormat();
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printText(new byte[]{0x1B, 0x21, 0x19});
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            Printer.printCustom("KOT : " + OrderID, 3, 1);
            //  Printer.printNewLine();
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Printer.printNewLine();
            Printer.printCustom(OrderType, 3, 1);
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }   //Printer.printNewLine();
            Printer.printCustom(Floors.get(Integer.valueOf(Floor)), 2, 1);
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }   //Printer.printNewLine();
            Printer.printCustom(Date + "  " + Time, 3, 1);
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }     //Printer.printNewLine();
            Printer.printCustom("TABLE : " + TableNumber + "  SUB ORDER" + SubTable, 2, 1);
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //i++;

            Printer.printNewLine();
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printText(PrintService.LEFT_MARGIN);
            //i++;
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printCustom("ORDERED BY : " + Orderer, 1, 0);
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //    Printer.printCustom("KITCHEN : " + ds.getString("Name"), 1, 0);
            //i++;
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.PrintLine();
            //i++;
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //    String P = String.valueOf(DEL.get("Item"));
            //  String Q = String.valueOf(DEL.get("Quantity"));
            //   Printer.FourColumAlighPrint(P, "CANCEL", "".toUpperCase(), Q);
            Printer.IndexColumnPrint(Q+"",P);
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printCustom("ORDER CANCELLED",5,1);

            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //  }
            // i++;
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.PrintLine();
            //i++;
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printCustom("THIS IS NOT A BILL ONLY THE TABULATED ORDER", 0, 1);
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printCustom(">..**"+Sum.getText().toString()+"**..<", 0, 1);
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printNewLine();
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Printer.printLongFeed();
            try {
                Thread.sleep(f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Print(Printer.Finish());




















        }
        //   }


        //}



        return null;
    }

    private void Print(final byte[] printdata) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                proceed =false;
                while (true) {
                    x++;

                    if(x==3){

                        ((Activity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Toast.makeText(context, "PRINTER FAILED TRYING TO RECONNECT...", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    if(x==5000){
                        ((Activity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context, "Printer Not Connected", Toast.LENGTH_SHORT).show();
                                proceed=true;
                                SuccessF=false;
                                SuccessK=false;
                            }
                        });
                    }
                    try {

                        SharedPreferences FloorIP= context.getSharedPreferences("FloorIP",MODE_PRIVATE);

                        SharedPreferences KitchenIP= context.getSharedPreferences("KitchenIP",MODE_PRIVATE);
                        socket = new Socket(KitchenIP.getString("0","192.168.1.165"), 9100);
                        //  outputStream2=socket.getOutputStream();
                        //       Log.v("QWERTY",String.valueOf(socket.getInputStream().read()));
                        // outputStream2.write(new byte[]{0x1B, 0x21, 0x03});
//                        for(int i=0; i<printdata.length/2; i++){
//                            int temp = printdata[i];
//                            printdata[i] = printdata[printdata.length -i -1];
//                            printdata[printdata.length -i -1] = temp;
//                        }

                   /*     byte[] New=printdata;

                        for(int x=0;x<printdata.length;x++){
                            printdata[x]=New[printdata.length-x];
                        }
                        */

                        outputStream=socket.getOutputStream();
                        // outputStream.write(PrintService.FEED_LINE);
                        outputStream.write(printdata);

                        Log.v("QWERTY", "inside Hi "+ String.valueOf(printdata));

                        outputStream.close();
                        socket.close();
                        socket = null;

                        // outputStream.write(PrintService.FEED_LINE);
                        Log.v("QWERTY", "+1");
                        Log.v("QWERTY", String.valueOf(x) + "X");

                        Thread.sleep(10);

                        //proceed=true;

                        proceed =false;
                        while (true) {
                            x++;

                            if(x==3){

                                ((Activity) context).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {

                                        Toast.makeText(context, "PRINTER FAILED TRYING TO RECONNECT...", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(x==5000){
                                ((Activity) context).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(context, "Printer Not Connected", Toast.LENGTH_SHORT).show();
                                        proceed=true;
                                        SuccessF=false;
                                        SuccessK=false;
                                    }
                                });
                            }
                            try {

                                socket = new Socket(KitchenIP.getString("0","192.168.1.165"), 9100);
                                //  outputStream2=socket.getOutputStream();
                                //       Log.v("QWERTY",String.valueOf(socket.getInputStream().read()));
                                // outputStream2.write(new byte[]{0x1B, 0x21, 0x03});
//                        for(int i=0; i<printdata.length/2; i++){
//                            int temp = printdata[i];
//                            printdata[i] = printdata[printdata.length -i -1];
//                            printdata[printdata.length -i -1] = temp;
//                        }

                   /*     byte[] New=printdata;

                        for(int x=0;x<printdata.length;x++){
                            printdata[x]=New[printdata.length-x];
                        }
                        */

                                outputStream=socket.getOutputStream();
                                // outputStream.write(PrintService.FEED_LINE);
                                outputStream.write(printdata);

                                Log.v("QWERTY", "inside Hi "+ String.valueOf(printdata));

                                outputStream.close();
                                socket.close();
                                socket = null;

                                // outputStream.write(PrintService.FEED_LINE);
                                Log.v("QWERTY", "+1");
                                Log.v("QWERTY", String.valueOf(x) + "X");

                                Thread.sleep(10);

                                proceed=true;







                            } catch (IOException e) {
                                //          Toast.makeText(context, "Printer Connection Failed", Toast.LENGTH_SHORT).show();
                                //   QWERTY = false;
                                Log.v("QWERTY", "-1" + x);
                            }

                            catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            if(proceed){

                                break;
                            }

                        }





                    } catch (IOException e) {
                        //          Toast.makeText(context, "Printer Connection Failed", Toast.LENGTH_SHORT).show();
                        //   QWERTY = false;
                        Log.v("QWERTY", "-1" + x);
                    }

                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(proceed){
                        break;
                    }

                }


            }}).start();
    }
    @Override
    protected void onPreExecute() {
        Log.v("ssss","opened");

    }

    @Override
    protected void onPostExecute(Void aVoid) {

//if(!SuccessF){
//    Toast.makeText(context, "FLOOR PRINTER NOT CONNECTED", Toast.LENGTH_SHORT).show();
//
//}else if(!SuccessK){
//    Toast.makeText(context, "KITCHEN PRINTER NOT CONNECTED", Toast.LENGTH_SHORT).show();
//
//}else{
        Toast.makeText(context, "ORDER CANCELLED SUCCESSFULLY", Toast.LENGTH_SHORT).show();

//}




    }


}
