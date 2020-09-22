package com.spine.printutils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Calendar;
import java.util.TimeZone;

import static android.content.Context.MODE_PRIVATE;

public class TPrintSync  {
    static boolean STATUS;

    private OutputStream staticStream;
    private Socket socket;
    private Context context;
    public static int CHARLENGTH=58;
    private static int C1=27;
    private static int C2=8;
    private static int C3=7;
    private static int C4=14;
    private String IP;


    public  TPrintSync(final String IP, final Context context) {


        this.context=context;
        this.IP=IP;










    }


    public synchronized boolean Engage(){
        new Thread(new Runnable() {
            @Override
            public void run() {

synchronized (this) {
    try {
        socket = new Socket(IP, 9100);
        staticStream = socket.getOutputStream();
        STATUS = true;
    } catch (IOException e) {
        e.printStackTrace();
        STATUS = false;
        Log.v("STATUS", String.valueOf(e.getMessage()));
    }


}
            }}).start();

        Log.v("STATUS", String.valueOf(STATUS));
return STATUS;



    }
    public synchronized boolean getStatus(){





        Log.v("STATUS", String.valueOf(STATUS));
        return STATUS;  //  mTextField.setText("done!");






    }

    public synchronized void printCustom(final String msg, final int size, final int align) {
        //Print config "mode"

        new Thread(new Runnable() {
            @Override
            public void run() {

synchronized (this) {
    byte[] cc = new byte[]{0x1B, 0x21, 0x03};  // 0- normal size text
    // byte[] height = new byte[]{0x1B, 0x21, 0x11};  // 0- normal size text
    //byte[] cc1 = new byte[]{0x1B,0x21,0x00};  // 0- normal size text
    byte[] bb = new byte[]{0x1B, 0x21, 0x08};  // 1- only bold text
    byte[] bb2 = new byte[]{0x1B, 0x21, 0x20}; // 2- bold with medium text
    byte[] bb3 = new byte[]{0x1B, 0x21, 0x10}; // 3- bold with large text
    byte[] bb5 = new byte[]{0x1B, 0x21, 0x02}; // 3- bold with default text
    try {

        switch (size) {
            case 0:

                staticStream.write(cc);


                break;
            case 1:
                staticStream.write(bb);


                break;
            case 2:
                staticStream.write(bb2);

                break;
            case 3:
                staticStream.write(bb3);

                break;
            case 4:
                staticStream.write(bb2);
                staticStream.write(bb3);

                break;
            case 5:

                staticStream.write(bb5);

                break;

        }


        switch (align) {
            case 0:
                //left align\

                staticStream.write(PrintService.ESC_ALIGN_LEFT);


                break;
            case 1:
                //center align
                staticStream.write(PrintService.ESC_ALIGN_CENTER);
                break;
            case 2:
                //right align
                staticStream.write(PrintService.ESC_ALIGN_RIGHT);
                break;
        }
        staticStream.write(msg.getBytes());
        staticStream.write(PrintService.FEED_LINE);

        //staticStream.write(cc);
        //printNewLine();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
            }}).start();

    }

    public synchronized void printUnicode(){


        new Thread(new Runnable() {
            @Override
            public void run() {

synchronized (this) {
    try {
        staticStream.write(PrintService.ESC_ALIGN_CENTER);
    } catch (IOException e) {
        e.printStackTrace();
    }
    printText(Utils.UNICODE_TEXT);

}
            }}).start();
    }



    public synchronized void printLongFeed() {
        //   new Thread(new Runnable() {
        //  @Override
        //     public void run() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {

                        staticStream.write(PrintService.FEED_LINE);

                        staticStream.write(PrintService.FEED_LINE);
                        staticStream.write(PrintService.FEED_LINE);
                        staticStream.write(PrintService.FEED_LINE);
                        staticStream.write(PrintService.PAPER__CUT);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }}).start();
        //    }}).start();
    }
    //print new line
    public  void printNewLine() {

        new Thread(new Runnable() {
            @Override
            public void run() {
synchronized (this) {
    try {
        staticStream.write(PrintService.FEED_LINE);
    } catch (IOException e) {
        e.printStackTrace();
    }

}
            }}).start();
    }

    public  void resetPrint() {

        // new Thread(new Runnable() {
        //    @Override
        //    public void run() {
        new Thread(new Runnable() {
            @Override
            public void run() {
synchronized (this) {
    try {


        staticStream.write(PrintService.ESC_FONT_COLOR_DEFAULT);

        staticStream.write(PrintService.FS_FONT_ALIGN);
        staticStream.write(PrintService.ESC_ALIGN_LEFT);
        staticStream.write(PrintService.ESC_CANCEL_BOLD);
        staticStream.write(PrintService.FEED_LINE);

    } catch (IOException e) {
        e.printStackTrace();
    }

}
            }}).start();
        //   }}).start();

    }

    public synchronized String FourColumAligh(String str1, String str2, String str3, String str4) {

        if(str1.length()>=C1){str1=str1.substring(0,C1);}else
        if(str2.length()>=C2){str2=str2.substring(0,C2);}else
        if(str3.length()>=C3){str3=str3.substring(0,C3);}else
        if(str4.length()>=C4){str4=str4.substring(0,C4);}


        String ans ;

        int gap1=C1-str1.length();
        int gap2=C2-str2.length();
        int gap3=C3-str3.length();
        int gap4=C4-str4.length();
        // int n = (31 - str1.length() + str2.length());
        ans = str1 + new String(new char[gap1]).replace("\0", " ") + str2+ new String(new char[gap2]).replace("\0", " ")+str3+ new String(new char[gap3+gap4]).replace("\0", " ")+str4;

        return ans;
    }



    public synchronized void FourColumAlighPrint(String str1, final String str2, final String str3, final String str4) {

        if(str1.length()>19){
            str1= str1.substring(0,19);
        }
        final String Tempstr1=str1;

        new Thread(new Runnable() {
            @Override
            public void run() {

synchronized (this) {


    byte[] SPEED = new byte[]{0x1B, 0x21, 0x02};

    try {


        staticStream.write(SPEED);

        SPEED = new byte[]{0x1B, 0x44, 20, 26, 32, 00};
        staticStream.write(SPEED);
        // SPEED = new byte[]{0x09};
        // staticStream.write(SPEED);
        staticStream.write(Tempstr1.getBytes());
        SPEED = new byte[]{0x09};
        staticStream.write(SPEED);
        staticStream.write(str2.getBytes());
        SPEED = new byte[]{0x09};
        staticStream.write(SPEED);
        staticStream.write(str3.getBytes());
        SPEED = new byte[]{0x09};
        staticStream.write(SPEED);
        staticStream.write(new String(new char[8 - str4.length()]).replace("\0", " ").getBytes());
        staticStream.write(str4.getBytes());
        staticStream.write(PrintService.FEED_LINE);
    } catch (IOException e) {
        e.printStackTrace();
    }

}
            }}).start();

    }

    public synchronized void printNote(final String str1) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (this) {
                    try {

                        byte[] bb = new byte[]{0x1B, 0x21, 0x02};
                        staticStream.write(bb);
                        byte[] SPEED = new byte[]{0x1B, 0x44, 20, 26, 32, 00};
                        staticStream.write(SPEED);
                        staticStream.write(str1.toUpperCase().getBytes());
                        staticStream.write(PrintService.FEED_LINE);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }}).start();
    }
    public  synchronized void IndexColumnPrint(String index, String str2) {

        if(str2.length()>30){
            str2= str2.substring(0,30);
        }
        if(index.length()>5){
            index= index.substring(0,5);
        }

        final byte[][] SPEED = {new byte[]{0x1B, 0x21, 0x02}};
        final String finalIndex = index;
        final String finalStr = str2;
        new Thread(new Runnable() {
            @Override
            public void run() {
synchronized (this) {
    try {
        staticStream.write(SPEED[0]);

        SPEED[0] = new byte[]{0x1B, 0x44, 3, 7, 00};
        staticStream.write(SPEED[0]);
        // SPEED = new byte[]{0x09};
        // outputStream.write(SPEED);
        staticStream.write(PrintService.ESC_ALIGN_LEFT);

        //   staticStream.write(index.getBytes());
        SPEED[0] = new byte[]{0x09};
        staticStream.write(SPEED[0]);
        staticStream.write(finalIndex.getBytes());
        staticStream.write(SPEED[0]);
        staticStream.write(finalStr.getBytes());

        staticStream.write(PrintService.FEED_LINE);


    } catch (IOException e) {
        e.printStackTrace();
    }

}}}).start();
    }

    public synchronized  void PrintLine() {

        new Thread(new Runnable() {
            @Override
            public void run() {

synchronized (this) {
    byte[] bb = new byte[]{0x1B, 0x21, 0x03};
    try {
        staticStream.write(PrintService.FEED_LINE);

        staticStream.write(PrintService.ESC_ALIGN_CENTER);
        staticStream.write(bb);


        staticStream.write("---------------------------------------------------".getBytes());


        // Print normal text
        // data=concat(msg,data);
        staticStream.write(PrintService.FEED_LINE);

    } catch (IOException e) {
        e.printStackTrace();
    }

}
            }}).start();

    }

    public synchronized void printInitFormat(){

        new Thread(new Runnable() {
            @Override
            public void run() {


synchronized (this) {

    // data=concat(printformat,data);
    //  byte[]      data=new byte[]{0x1B,0x21,0x03};

    try {
        staticStream.write(new byte[]{0x1B, 0x21, 0x03});
    } catch (IOException e) {
        e.printStackTrace();
        //

    }
}
            }}).start();

    }
    //print text
    public synchronized void printText(final String msg) {


        new Thread(new Runnable() {
            @Override
            public void run() {

synchronized (this) {

    byte[] bb = new byte[]{0x1B, 0x21, 0x08};

    try {
        staticStream.write(bb);

        staticStream.write(msg.getBytes());

    } catch (IOException e) {
        e.printStackTrace();
    }

}
            }}).start();
    }
    public  synchronized void printTextO(final String msg) {


        //    new Thread(new Runnable() {
        //       @Override
        //       public void run() {



        //  byte[] bb = new byte[]{0x1B, 0x21, 0x08};

        //     data=concat(bb,data);
        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (this) {
                    try {
                        staticStream.write(msg.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }}).start();
        //    }}).start();
    }

    //print byte[]
    public synchronized void printText(final byte[] msg) {

        //  new Thread(new Runnable() {
        //     @Override
        //    public void run() {


        // Print normal text
        new Thread(new Runnable() {
            @Override
            public void run() {

               synchronized (this) {
                   try {
                       staticStream.write(msg);
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
            }}).start();
        //600
        // ..   }}).start();

    }





    public synchronized String[] getDateTime() {

        SharedPreferences Settings= context.getSharedPreferences("Settings",MODE_PRIVATE);

        final Calendar c = Calendar.getInstance(TimeZone.getTimeZone(Settings.getString("TimeZone","Asia/Kolkata")));

        String dateTime [] = new String[2];
        int Month =c.get(Calendar.MONTH)+1;
        dateTime[0] = c.get(Calendar.DAY_OF_MONTH) +"/"+ Month +"/"+ c.get(Calendar.YEAR);
        String AP;
        switch (c.get(Calendar.AM_PM)){
            case 0:
                AP="AM";
                break;
            default:
                AP="PM";
                break;

        }

        dateTime[1] = c.get(Calendar.HOUR) +":"+ c.get(Calendar.MINUTE)+" "+AP;
        return dateTime;
    }

    public  void Finish() {




        new Thread(new Runnable() {
            @Override
            public void run() {

synchronized (this) {


    try {
        if (socket != null) {

            //  staticStream.write(data);
            staticStream.close();
            socket.close();
            socket = null;


        }
    } catch (IOException e) {
        e.printStackTrace();
    }

}
            }}).start();

    }



    private byte[] concat(byte[] ToAdd,byte[] WithAdd){

        byte[] out = new byte[ToAdd.length + WithAdd.length];


        System.arraycopy(WithAdd, 0, out, 0,WithAdd.length);
        System.arraycopy(ToAdd, 0, out, WithAdd.length, ToAdd.length);
        return out;

    }
    byte[] toPrimitives(Byte[] oBytes)
    {

        byte[] bytes = new byte[oBytes.length];
        for(int i = 0; i < oBytes.length; i++){
            bytes[i] = oBytes[i];
        }
        return bytes;

    }

}

