package com.spine.printutils;

public class PrinterIP {


    public PrinterIP() {
    }


    public static String FetchIP(Integer Type, String Code){

        String IP="192.168.1.161";
String OP="192.168.1.161";
        //0 Indicate Floor
        //1 Indicate Kitchen

        if(Type==0){
            //Floor

            switch (Code){

                case "0":
                    IP="192.168.1.161";

                break;
                case "1":
                    //FAMILY
        //            IP= "192.168.1.163";
                    IP= "192.168.1.162";
                break;


                case "2":


                    IP= "192.168.1.162";
                break;
                case "3":
                    IP= "192.168.1.87";

                break;
                case "4":
                  //  TAKE AWAY
                    IP= "192.168.1.165";
                break;

                case "5":
                //   OTHER
                    IP= "192.168.1.166";
                    break;


            }



        }else if(Type==1){
            //Kitchen

            switch (Code){

                case "0":
        //            IP= "192.168.1.163";
                    IP= "192.168.1.164";
                break;
                case "1":
        //            IP= "192.168.1.163";
                    IP= "192.168.1.164";
                break;
                case "2":
        //            IP= "192.168.1.163";
                    IP= "192.168.1.164";
                break;
                case "3":
        //            IP= "192.168.1.163";
                    IP= "192.168.1.164";
                break;
                case "4":

                    IP= "192.168.1.164";
                break;
                case "10":

                    IP= "192.168.1.164";
                    break;


            }


        }

        return IP;

    }

}
