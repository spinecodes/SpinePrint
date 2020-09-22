package com.spine.printutils;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Calendar;

public class WPrinter {
    boolean STATUS;
    boolean proceed;

    private OutputStream outputStream;
    private Socket socket;
    private Context context;
    public static int CHARLENGTH=58;
    private static int C1=27;
    private static int C2=8;
    private static int C3=7;
    private static int C4=14;
    int ftime=0;

    int time = 1;
    byte [] printdata;
    static  int x;
    String IP;


    public WPrinter() {

        printdata=PrintService.ESC_FONT_COLOR_DEFAULT;

//
//        this.context=context;
//        this.IP=IP;
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//// socket creating loop
//
//                x=1;
//                boolean proceed=false;
//                printdata=PrintService.ESC_FONT_COLOR_DEFAULT;
//
//
//
//
////                try {
////                    ftime=0;
////                    Log.v("QWERTY",ftime+"");
////                    socket = new Socket(IP, 9100);
////                    outputStream=socket.getOutputStream();
////             //       Log.v("QWERTY",String.valueOf(socket.getInputStream().read()));
////                   // outputStream.write(new byte[]{0x1B, 0x21, 0x03});
////                    QWERTY=true;
////                    Log.v("QWERTY","+1");
////                } catch (IOException e) {
////          //          Toast.makeText(context, "Printer Connection Failed", Toast.LENGTH_SHORT).show();
////                    QWERTY=false;
////                    Log.v("QWERTY","-1");
////
////                    try {
////                        Thread.sleep(time );
////                    } catch (InterruptedException e10) {
////                        e10.printStackTrace();
////                    }
////
////                    try {
////
////                        ftime=ftime+time;
////                        Log.v("QWERTY",ftime+"");
////
////                        socket = new Socket(IP, 9100);
////                        outputStream=socket.getOutputStream();
////                        //       Log.v("QWERTY",String.valueOf(socket.getInputStream().read()));
////                        // outputStream.write(new byte[]{0x1B, 0x21, 0x03});
////                        QWERTY=true;
////                        Log.v("QWERTY","+1");
////                    } catch (IOException e1) {
////                        //          Toast.makeText(context, "Printer Connection Failed", Toast.LENGTH_SHORT).show();
////                        QWERTY=false;
////                        Log.v("QWERTY","-1");
////
////                        try {
////                            Thread.sleep(time );
////                        } catch (InterruptedException e10) {
////                            e10.printStackTrace();
////                        }
////
////                        try {
////                            ftime=ftime+time;
////                            Log.v("QWERTY",ftime+"");
////                            socket = new Socket(IP, 9100);
////                            outputStream=socket.getOutputStream();
////                            //       Log.v("QWERTY",String.valueOf(socket.getInputStream().read()));
////                            // outputStream.write(new byte[]{0x1B, 0x21, 0x03});
////                            QWERTY=true;
////                            Log.v("QWERTY","+1");
////                        } catch (IOException e2) {
////                            //          Toast.makeText(context, "Printer Connection Failed", Toast.LENGTH_SHORT).show();
////                            QWERTY=false;
////                            Log.v("QWERTY","-1");
////
////                            try {
////                                Thread.sleep(time );
////                            } catch (InterruptedException e10) {
////                                e10.printStackTrace();
////                            }
////
////                            try {
////
////                                ftime=ftime+time;
////                                Log.v("QWERTY",ftime+"");
////                                socket = new Socket(IP, 9100);
////                                outputStream=socket.getOutputStream();
////                                //       Log.v("QWERTY",String.valueOf(socket.getInputStream().read()));
////                                // outputStream.write(new byte[]{0x1B, 0x21, 0x03});
////                                QWERTY=true;
////                                Log.v("QWERTY","+1");
////                            } catch (IOException e3) {
////                                //          Toast.makeText(context, "Printer Connection Failed", Toast.LENGTH_SHORT).show();
////                                QWERTY=false;
////                                Log.v("QWERTY","-1");
////
////                                try {
////                                    Thread.sleep(time );
////                                } catch (InterruptedException e10) {
////                                    e10.printStackTrace();
////                                }
////
////                                try {
////
////                                    ftime=ftime+time;
////                                    Log.v("QWERTY",ftime+"");
////                                    socket = new Socket(IP, 9100);
////                                    outputStream=socket.getOutputStream();
////                                    //       Log.v("QWERTY",String.valueOf(socket.getInputStream().read()));
////                                    // outputStream.write(new byte[]{0x1B, 0x21, 0x03});
////                                    QWERTY=true;
////                                    Log.v("QWERTY","+1");
////                                } catch (IOException e4) {
////                                    //          Toast.makeText(context, "Printer Connection Failed", Toast.LENGTH_SHORT).show();
////                                    QWERTY = false;
////                                    Log.v("QWERTY", "-1");
////
////                                    try {
////                                        Thread.sleep(time );
////                                    } catch (InterruptedException e10) {
////                                        e10.printStackTrace();
////                                    }
////
////                                    try {
////
////                                        ftime=ftime+time;
////                                        Log.v("QWERTY",ftime+"");
////
////                                        socket = new Socket(IP, 9100);
////                                        outputStream=socket.getOutputStream();
////                                        //       Log.v("QWERTY",String.valueOf(socket.getInputStream().read()));
////                                        // outputStream.write(new byte[]{0x1B, 0x21, 0x03});
////                                        QWERTY=true;
////                                        Log.v("QWERTY","+1");
////                                    } catch (IOException e5) {
////                                        //          Toast.makeText(context, "Printer Connection Failed", Toast.LENGTH_SHORT).show();
////                                        QWERTY = false;
////                                        Log.v("QWERTY", "-1");
////
////                                        try {
////                                            Thread.sleep(time );
////                                        } catch (InterruptedException e10) {
////                                            e10.printStackTrace();
////                                        }
////
////                                        try {
////
////                                            ftime=ftime+time;
////                                            Log.v("QWERTY",ftime+"");
////                                            socket = new Socket(IP, 9100);
////                                            outputStream=socket.getOutputStream();
////                                            //       Log.v("QWERTY",String.valueOf(socket.getInputStream().read()));
////                                            // outputStream.write(new byte[]{0x1B, 0x21, 0x03});
////                                            QWERTY=true;
////                                            Log.v("QWERTY","+1");
////                                        } catch (IOException e6) {
////                                            //          Toast.makeText(context, "Printer Connection Failed", Toast.LENGTH_SHORT).show();
////                                            QWERTY = false;
////                                            Log.v("QWERTY", "-1");
////
////                                        }
////                                    }
////                                }
////                            }
////
////                        }
////
////                    }
////
////                }
//
//
//            }}).start();


    }

    public boolean getStatus(){
      /*  try {

            Log.v("QWERTY",String.valueOf(socket.getInputStream().read()));

        } catch (IOException e) {
            Log.v("QWERTY",String.valueOf(socket.getInputStream().read()));
        }*/
       /* new CountDownTimer(millse, 100) {

            public void onTick(long millisUntilFinished) {


                public void onFinish() {


                }

                -}
            }.start();
*/

        //

        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.v("QWERTY", String.valueOf(STATUS));



  /*    new Thread(new Runnable() {
            @Override
            public void run() {




                try {
                    if (socket != null) {

                        //  outputStream.write(data);
                        outputStream.close();
                        socket.close();
                        socket = null;


                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }}).start();

*/
        return STATUS;  //  mTextField.setText("done!")

    }

    public void printCustom(final String msg, final int size, final int align) {
        //Print config "mode"

//        new Thread(new Runnable() {
        // @Override
        //   public void run() {


        byte[] cc = new byte[]{0x1B, 0x21, 0x03};  // 0- normal size text
        // byte[] height = new byte[]{0x1B, 0x21, 0x11};  // 0- normal size text
        //byte[] cc1 = new byte[]{0x1B,0x21,0x00};  // 0- normal size text
        byte[] bb = new byte[]{0x1B, 0x21, 0x08};  // 1- only bold text
        byte[] bb2 = new byte[]{0x1B, 0x21, 0x20}; // 2- bold with medium text
        byte[] bb3 = new byte[]{0x1B, 0x21, 0x10}; // 3- bold with large text
        byte[] bb5 = new byte[]{0x1B, 0x21, 0x02}; // 3- bold with default text
        //            try {

        switch (size) {
            case 0:
                printdata=concat(printdata,cc);

                //       outputStream.write(cc);


                break;
            case 1:
                printdata=concat(printdata,bb);
                //  outputStream.write(bb);


                break;
            case 2:
                printdata = concat(printdata, bb2);

                //    outputStream.write(bb2);

                break;
            case 3:

                printdata = concat(printdata, bb3);

                //    outputStream.write(bb3);

                break;
            case 4:

                printdata = concat(printdata, bb2);
                printdata = concat(printdata, bb3);
                Log.v("QWERTY", String.valueOf(printdata));

                //    outputStream.write(bb2);
                //    outputStream.write(bb3);

                break;
            case 5:

                printdata = concat(printdata, bb5);

                //    outputStream.write(bb5);

                break;

        }


        switch (align) {
            case 0:
                //left align

                printdata = concat(printdata, PrintService.ESC_ALIGN_LEFT);

                //    outputStream.write(PrintService.ESC_ALIGN_LEFT);



                break;
            case 1:
                //center align

                printdata = concat(printdata, PrintService.ESC_ALIGN_CENTER);

                //    outputStream.write(PrintService.ESC_ALIGN_CENTER);
                break;
            case 2:
                //right align
                printdata = concat(printdata, PrintService.ESC_ALIGN_RIGHT);

                //    outputStream.write(PrintService.ESC_ALIGN_RIGHT);
                break;
        }

        printdata = concat(printdata, (msg).getBytes());
        printdata = concat(printdata, PrintService.FEED_LINE);

        //    outputStream.write((msg).getBytes());
        //    outputStream.write(PrintService.FEED_LINE);

        //outputStream.write(cc);
        //printNewLine();
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }

        //     }}).start();

    }

    //print photo
    public void printPhoto(final int img) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {


                    Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), img);
                    if (bmp != null) {
                        byte[] command = Utils.decodeBitmap(bmp);

                        printdata = concat(printdata, PrintService.ESC_ALIGN_CENTER);
                        printdata = concat(printdata, PrintService.SELECT_BIT_IMAGE_MODE);

                        //    outputStream.write(PrintService.ESC_ALIGN_CENTER);
                        //    outputStream.write(PrintService.SELECT_BIT_IMAGE_MODE);
                        printText(command);
                    } else {
                        Log.e("Print Photo error", "the file isn't exists");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("PrintTools", "the file isn't exists");
                }

            }}).start();
    }

    //print unicode
    public void printUnicode(){


        new Thread(new Runnable() {
            @Override
            public void run() {


                //        try {

                printdata = concat(printdata, PrintService.ESC_ALIGN_CENTER);

                //    outputStream.write(PrintService.ESC_ALIGN_CENTER);
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
                printText(Utils.UNICODE_TEXT);


            }}).start();
    }


    public void printImg(final int r) {



        new Thread(new Runnable() {
            @Override
            public void run() {


                Bitmap bitmap= BitmapFactory.decodeResource(context.getResources(), r);
                ByteArrayOutputStream stream=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);


                byte[] image=stream.toByteArray();
                //        try {

                printdata = concat(printdata, image);

                //    outputStream.write(image);
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }


            }}).start();
    }
    public void printLongFeed() {
        //   new Thread(new Runnable() {
        //  @Override
        //     public void run() {


        //            try {

        printdata = concat(printdata, PrintService.FEED_LINE);
        printdata = concat(printdata, PrintService.FEED_LINE);
        printdata = concat(printdata, PrintService.FEED_LINE);
        printdata = concat(printdata, PrintService.FEED_LINE);
        printdata = concat(printdata, PrintService.PAPER__CUT);


        //    outputStream.write(PrintService.FEED_LINE);

//                outputStream.write(PrintService.FEED_LINE);
//                outputStream.write(PrintService.FEED_LINE);
//                outputStream.write(PrintService.FEED_LINE);
//                outputStream.write(PrintService.PAPER__CUT);
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }

        //    }}).start();
    }
    //print new line
    public void printNewLine() {

        // new Thread(new Runnable() {
        //    @Override
        //   public void run() {

        //            try {

        printdata = concat(printdata, PrintService.FEED_LINE);

        //    outputStream.write(PrintService.FEED_LINE);
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
        // }}).start();
    }

    public  void resetPrint() {

        // new Thread(new Runnable() {
        //    @Override
        //    public void run() {




        //            try {

        //   outputStream.write(PrintService.ESC_FONT_COLOR_DEFAULT);

        printdata=concat(printdata,PrintService.FS_FONT_ALIGN);
        printdata=concat(printdata,PrintService.ESC_ALIGN_LEFT);
        printdata=concat(printdata,PrintService.ESC_CANCEL_BOLD);
        printdata=concat(printdata,PrintService.FEED_LINE);

        // outputStream.write(PrintService.FS_FONT_ALIGN);
//                outputStream.write(PrintService.ESC_ALIGN_LEFT);
//                outputStream.write(PrintService.ESC_CANCEL_BOLD);
//                outputStream.write(PrintService.FEED_LINE);

//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }

        //   }}).start();

    }

    public String FourColumAligh(String str1, String str2, String str3, String str4) {

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
    public void FourColumAlighPrint(String str1, String str2, String str3, String str4) {

        if(str1.length()>19){
            str1= str1.substring(0,19);
        }

        byte[]    SPEED = new byte[]{0x1B, 0x21, 0x02};

        //    try {

        printdata = concat(printdata, SPEED);

        //    outputStream.write(SPEED);

        SPEED = new byte[]{0x1B,0x44,20,26,32,00};

        printdata = concat(printdata, SPEED);

        //        outputStream.write(SPEED);
        // SPEED = new byte[]{0x09};
        // outputStream.write(SPEED);

        printdata = concat(printdata, str1.getBytes());

        //        outputStream.write(str1.getBytes());
        SPEED = new byte[]{0x09};

        printdata = concat(printdata, SPEED);

        //        outputStream.write(SPEED);

        printdata = concat(printdata, str2.getBytes());

        //        outputStream.write(str2.getBytes());
        SPEED = new byte[]{0x09};

        printdata = concat(printdata, SPEED);

        //        outputStream.write(SPEED);

        printdata = concat(printdata, str3.getBytes());

        //        outputStream.write(str3.getBytes());
        SPEED = new byte[]{0x09};

        printdata = concat(printdata, SPEED);

        //        outputStream.write(SPEED);
//        outputStream.write(new String(new char[8-str4.length()]).replace("\0", " ").getBytes());
//        outputStream.write(str4.getBytes());
//        outputStream.write(PrintService.FEED_LINE);

        printdata = concat(printdata, new String(new char[8-str4.length()]).replace("\0", " ").getBytes());
        printdata = concat(printdata, str4.getBytes());
        printdata = concat(printdata, PrintService.FEED_LINE);


//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    public void PrintUnicode(int UNICODE) {


        try {

            //        printdata = concat(printdata, UNICODE);

            outputStream.write(UNICODE);




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ThreeColumAlighPrint(String str1, String str2, String str4) {

        if(str1.length()>19){
            str1= str1.substring(0,19);
        }

        byte[]    SPEED = new byte[]{0x1B, 0x21, 0x02};

        //    try {

        printdata = concat(printdata, SPEED);

        //        outputStream.write(SPEED);

        printdata = concat(printdata, PrintService.ESC_ALIGN_LEFT);

        //        outputStream.write(PrintService.ESC_ALIGN_LEFT);
        SPEED = new byte[]{0x1B,0x44,2,20,16,00};

        printdata = concat(printdata, SPEED);

        //        outputStream.write(SPEED);
        // SPEED = new byte[]{0x09};
        // outputStream.write(SPEED);
        SPEED = new byte[]{0x09};

        printdata = concat(printdata, SPEED);

        //        outputStream.write(SPEED);

        printdata = concat(printdata, str1.getBytes());

        //        outputStream.write(str1.getBytes());
        SPEED = new byte[]{0x09};

        printdata = concat(printdata, SPEED);

        //        outputStream.write(SPEED);

        printdata = concat(printdata, str2.getBytes());

        //        outputStream.write(str2.getBytes());

        SPEED = new byte[]{0x09};

        printdata = concat(printdata, SPEED);

        //        outputStream.write(SPEED);

        printdata = concat(printdata, new String(new char[15-str4.length()]).replace("\0", " ").getBytes());
        printdata = concat(printdata, str4.getBytes());
        printdata = concat(printdata, PrintService.FEED_LINE);

//            outputStream.write(new String(new char[15-str4.length()]).replace("\0", " ").getBytes());
//            outputStream.write(str4.getBytes());
//            outputStream.write(PrintService.FEED_LINE);



//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    public void IndexColumnPrint(String index, String str2) {

        if(str2.length()>30){
            str2= str2.substring(0,30);
        }
        if(index.length()>5){
            index= index.substring(0,5);
        }

        byte[]    SPEED = new byte[]{0x1B, 0x21, 0x02};

        //    try {

        printdata = concat(printdata, SPEED);

        //        outputStream.write(SPEED);

        SPEED = new byte[]{0x1B,0x44,3,7,00};

        printdata = concat(printdata, SPEED);

        //        outputStream.write(SPEED);
        // SPEED = new byte[]{0x09};
        // outputStream.write(SPEED);

        printdata = concat(printdata, PrintService.ESC_ALIGN_LEFT);

        //        outputStream.write(PrintService.ESC_ALIGN_LEFT);

        //  outputStream.write(index.getBytes());
        SPEED = new byte[]{0x09};

        printdata = concat(printdata, SPEED);

        //        outputStream.write(SPEED);

        printdata = concat(printdata, index.getBytes());
        printdata = concat(printdata, SPEED);
        printdata = concat(printdata, str2.getBytes());
        printdata = concat(printdata, PrintService.FEED_LINE);

//            outputStream.write(index.getBytes());
//            outputStream.write(SPEED);
//            outputStream.write(str2.getBytes());
//
//            outputStream.write(PrintService.FEED_LINE);


//
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    public void printNote(String str1) {

        // new Thread(new Runnable() {
        //    @Override
        //   public void run() {

        //    try {

        byte[] bb = new byte[]{0x1B, 0x21, 0x02};

        printdata = concat(printdata, bb);

        //        outputStream.write(bb);
        byte[]  SPEED = new byte[]{0x1B,0x44,20,26,32,00};

        printdata = concat(printdata, SPEED);
        printdata = concat(printdata, str1.toUpperCase().getBytes());
        printdata = concat(printdata, PrintService.FEED_LINE);


//            outputStream.write(SPEED);
//            outputStream.write(str1.toUpperCase().getBytes());
//            outputStream.write(PrintService.FEED_LINE);

//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
        // }}).start();
    }
    public void PrintLine() {

        // new Thread(new Runnable() {
        //     @Override
        //     public void run() {


        byte[] bb = new byte[]{0x1B, 0x21, 0x03};

        //            try {

        printdata = concat(printdata, PrintService.FEED_LINE);
        printdata = concat(printdata, PrintService.ESC_ALIGN_CENTER);
        printdata = concat(printdata, bb);

//                    outputStream.write(PrintService.FEED_LINE);
//
//                outputStream.write(PrintService.ESC_ALIGN_CENTER);
//                outputStream.write(bb);

        printdata = concat(printdata, "---------------------------------------------------".getBytes());

        //            outputStream.write("---------------------------------------------------".getBytes());


        // Print normal text
        // data=concat(msg,data);

        printdata = concat(printdata, PrintService.FEED_LINE);

        //    outputStream.write(PrintService.FEED_LINE);

//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
        //     }}).start();

    }
    public void PrintLineO() {

        //   new Thread(new Runnable() {
        //     @Override
        //     public void run() {


        byte[] bb = new byte[]{0x1B, 0x21, 0x03};
        //            try {
        //     outputStream.write(PrintService.FEED_LINE);

        printdata = concat(printdata, PrintService.ESC_ALIGN_CENTER);
        printdata = concat(printdata, bb);
        printdata = concat(printdata, "---------------------------------------------------".getBytes());

//                    outputStream.write(PrintService.ESC_ALIGN_CENTER);
//                    outputStream.write(bb);
//
//
//                    outputStream.write("---------------------------------------------------".getBytes());


        // Print normal text
        // data=concat(msg,data);

        printdata = concat(printdata, PrintService.FEED_LINE);

        //    outputStream.write(PrintService.FEED_LINE);

//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
        //   }}).start();

    }
    public void printInitFormat(){

        //new Thread(new Runnable() {
        //   @Override
        //   public void run() {




        // data=concat(printformat,data);
        //  byte[]      data=new byte[]{0x1B,0x21,0x03};

        //            try {

        printdata = concat(printdata, new byte[]{0x1B,0x21,0x03});

        //                outputStream.write(new byte[]{0x1B,0x21,0x03});
//                }
//                catch (IOException e) {
//                  e.printStackTrace();
//                  //
//
//                }

        //   }}).start();

    }
    //print text
    public void printText(final String msg) {


        new Thread(new Runnable() {
            @Override
            public void run() {



                byte[] bb = new byte[]{0x1B, 0x21, 0x08};

                //        try {

                printdata = concat(printdata, bb);
                printdata = concat(printdata, msg.getBytes());

//                    outputStream.write(bb);
//
//                outputStream.write(msg.getBytes());

//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
            }}).start();
    }
    public void printTextO(final String msg) {


        //    new Thread(new Runnable() {
        //       @Override
        //       public void run() {



        //  byte[] bb = new byte[]{0x1B, 0x21, 0x08};

        //     data=concat(bb,data);
        //            try {

        printdata = concat(printdata, msg.getBytes());

        //               outputStream.write(msg.getBytes());
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }


        //    }}).start();
    }

    //print byte[]
    public void printText(final byte[] msg) {

        //  new Thread(new Runnable() {
        //     @Override
        //    public void run() {


        // Print normal text
        //            try {

        printdata = concat(printdata, msg);

        //                outputStream.write(msg);
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }

        //600
        // ..   }}).start();

    }


    public String leftRightAlign(String str1, String str2) {



        String ans = str1 + str2;
        if (ans.length() < 36) {
            int n = (36 - str1.length() + str2.length());
            ans = str1 + new String(new char[n]).replace("\0", " ") + str2;
        }
        return ans;


    }

    public void leftRightAlignPrint(String str1, String str2) {

        //    try {

        printdata = concat(printdata, PrintService.ESC_ALIGN_LEFT);
        printdata = concat(printdata, str1.getBytes());
        printdata = concat(printdata, PrintService.ESC_ALIGN_RIGHT);
        printdata = concat(printdata, str2.getBytes());

//            outputStream.write(PrintService.ESC_ALIGN_LEFT);
//
//        outputStream.write(str1.getBytes());
//        outputStream.write(PrintService.ESC_ALIGN_RIGHT);
//
//        outputStream.write(str1.getBytes());
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }


    }


    public void SelectFontSize(byte[] font) {

        byte[]  NEW= new byte[]{0x1B, 0x21};

        //    try {

        printdata = concat(printdata, NEW);
        printdata = concat(printdata, font);

//            outputStream.write(NEW);
//            outputStream.write(font);
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }


    }

    public String[] getDateTime() {

       /* String date = "dd/MM/YYYY";
        String Time  = "dd/MM/YYYY";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String Now = simpleDateFormat.format(new Date());
*/

        final Calendar c = Calendar.getInstance();

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

    public byte[]  Finish() {

        return printdata;



    }



    private byte[] concat(byte[] WithAdd,byte[] ToAdd){

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












