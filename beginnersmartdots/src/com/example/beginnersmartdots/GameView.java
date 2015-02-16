package com.example.beginnersmartdots;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;  
import android.graphics.PorterDuffXfermode; 

public class GameView extends ActionBarActivity {
private LinearLayout mylayout;
public TextView myTextView;
private Bitmap bitmap=Bitmap.createBitmap(800, 480, Bitmap.Config.ARGB_8888);;
Paint paint = new Paint();  ;  
Canvas canvas = new Canvas(bitmap); 
Drawable drawable = new BitmapDrawable(bitmap) ;
int countset = 0;
int set[] = new int [71];
int nset[] =new int [71];
int box[] = new int [30];
int player1[] = new int[31] ;
int player2[] = new int[31] ;
int player1count = 0;
int player2count = 0;
int turn = 11;



		  @Override
		  public void onCreate(Bundle savedInstanceState) {		    
		        super.onCreate(savedInstanceState);
		        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		        		              WindowManager.LayoutParams.FLAG_FULLSCREEN);	       
		        requestWindowFeature(Window.FEATURE_NO_TITLE);
		        setContentView(R.layout.gameview);
		        
		         myTextView = (TextView)findViewById(R.id.textView1);
		         mylayout = (LinearLayout)findViewById(R.id.myLayout); 
		         
		        for(int i=1;i<31;i++){
		        	player1[i]=0;
		        	player2[i]=0;
		        }
		        
		        /*    paint = new Paint();    
				  
			        paint.setStrokeWidth(5);
			        paint.setColor(Color.RED);
			  
			          
			        bitmap = Bitmap.createBitmap(800, 480, Bitmap.Config.ARGB_8888);   
			        canvas = new Canvas(bitmap);  
			        canvas.drawColor(Color.TRANSPARENT,PorterDuff.Mode.CLEAR);
			          
			          
			        canvas.drawLine(87, 79, 204, 79, paint);
			        Drawable drawable = new BitmapDrawable(bitmap) ;    
			        mylayout.setBackgroundDrawable(drawable);
			        */

  }
		  
		  @Override
		  public boolean onTouchEvent(MotionEvent event) {
		      int x = (int)event.getX();
		      int y = (int)event.getY();
		      switch (event.getAction()) {
		          case MotionEvent.ACTION_DOWN:
		          case MotionEvent.ACTION_MOVE:
		          case MotionEvent.ACTION_UP:
		      }		      
		     
              contact(x,y);
		    
              
              countset=0;
              player1count=0;
              player2count=0;
              
              for(int i=0;i<71;i++){
		    	  countset+=set[i];
		      }
              for(int i=1;i<31;i++){
		    	  player1count+=player1[i];
		      }
              for(int i=1;i<31;i++){
		    	  player2count+=player2[i];
		      }
		      
		      if(countset==71){
		    	  if(player1count>player2count){
		    	  myTextView.setText("                BLACK "+player1count+" BLUE "+player2count+"                                                     BLACK WIN");
		    	  }else if(player1count<player2count){
		    	  myTextView.setText("                BLACK "+player1count+" BLUE "+player2count+"                                                     BLUE WIN");  
		    	  }
		    	  else{
		    		  myTextView.setText("                BLACK "+player1count+" BLUE "+player2count+"                                                     PEACE");  
		    	  }
		      }
		      else{
		     // myTextView.setText(x+" "+y+"總共幾條線"+countset);
		      myTextView.setText("BLACK "+player1count+" BLUE "+player2count);
		      }
		      
		  return false;
		  }

		private void contact(int x,int y) {
			// TODO Auto-generated method stub
			  
		      if((x>100 && x <160 ) && (y>=60 && y <=100 ) ) {		      
		         
		          set[0]=1;
		          if(nset[0]==0){
		        	  draw(98,208,60);
		        	  if((set[0]+set[5]+set[35]+set[41])==4){
			  				if(turn>0){
			  					player1[1]=1;
			  				}
			  				else{
			  					player2[1]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
		          nset[0]=1;
		          }

		          }
		      else if((x>210 && x <270 ) && (y>=60 && y <=100 ) ) {		      
			      
			      set[1]=1;
			      if(nset[1]==0){
			    	  draw(210,330,60);
			    	  if((set[1]+set[6]+set[41]+set[47])==4){
			  				if(turn>0){
			  					player1[2]=1;
			  				}
			  				else{
			  					player2[2]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
			          nset[1]=1;
			          }
			      
			      }
		      else if((x>320 && x <380 ) && (y>=60 && y <=100 ) ) {		      

			      set[2]=1;
			      if(nset[2]==0){
			    	  draw(330,450,60);
			    	  if((set[2]+set[7]+set[47]+set[53])==4){
			  				if(turn>0){
			  					player1[3]=1;
			  				}
			  				else{
			  					player2[3]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
			          nset[2]=1;
			          }
			      }
		      else if((x>430 && x <490 ) && (y>=60 && y <=100 ) ) {		      

			      set[3]=1;
			      if(nset[3]==0){
				      draw(460,580,60);
			    	  if((set[3]+set[8]+set[53]+set[59])==4){
			  				if(turn>0){
			  					player1[4]=1;
			  				}
			  				else{
			  					player2[4]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
			          nset[3]=1;
			          }
			      }
		      else if((x>540 && x <600 ) && (y>=60 && y <=100 ) ) {		      

			      set[4]=1;
			      if(nset[4]==0){
				      draw(590,710,60);
			    	  if((set[4]+set[9]+set[59]+set[65])==4){
			  				if(turn>0){
			  					player1[5]=1;
			  				}
			  				else{
			  					player2[5]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
			          nset[4]=1;
			          }
		          }
		      //第一行
		      else if((x>100 && x <160 ) && (y>=185 && y <=215 ) ) {		      

		          set[5]=1;
		          if(nset[5]==0){
			          draw(98,208,185);
		        	  if((set[0]+set[5]+set[35]+set[41])==4){
		  				if(turn>0){
		  					player1[1]=1;
		  				}
		  				else{
		  					player2[1]=1;
		  				}
		  			}
		        	  if((set[5]+set[10]+set[36]+set[42])==4){
			  				if(turn>0){
			  					player1[6]=1;
			  				}
			  				else{
			  					player2[6]=1;
			  				}
			  			}
		        	  
		        	  if(player1[1]+player2[1]+player1[6]+player2[6]>0){
		        		  turn=turn*1;
		        	  }
		        	  else{
		        		  turn=turn*-1;
		        	  }
			          nset[5]=1;
			          }

		          }
		      else if((x>210 && x <270 ) && (y>=185 && y <=215 ) ) {		      

			      set[6]=1;
			      if(nset[6]==0){
				      draw(210,330,185);
			    	  if((set[1]+set[6]+set[41]+set[47])==4){
			  				if(turn>0){
			  					player1[2]=1;
			  				}
			  				else{
			  					player2[2]=1;
			  				}
			  			}
			        	  if((set[6]+set[11]+set[42]+set[48])==4){
				  				if(turn>0){
				  					player1[7]=1;
				  				}
				  				else{
				  					player2[7]=1;
				  				}
				  			}
			        	  
			        	  if(player1[2]+player2[2]+player1[7]+player2[7]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[6]=1;
			          }
			         
			      }
		      else if((x>320 && x <380 ) && (y>=185 && y <=215 ) ) {		      

			      set[7]=1;
			      if(nset[7]==0){
				      draw(330,450,185);
			    	  if((set[2]+set[7]+set[47]+set[53])==4){
			  				if(turn>0){
			  					player1[3]=1;
			  				}
			  				else{
			  					player2[3]=1;
			  				}
			  			}
			        	  if((set[7]+set[12]+set[48]+set[54])==4){
				  				if(turn>0){
				  					player1[8]=1;
				  				}
				  				else{
				  					player2[8]=1;
				  				}
				  			}
			        	  
			        	  if(player1[3]+player2[3]+player1[8]+player2[8]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[7]=1;
			          }
			      }
		      else if((x>430 && x <490 ) && (y>=185 && y <=215 ) ) {		      

			      set[8]=1;
			      if(nset[8]==0){
				      draw(460,580,185);
			    	  if((set[3]+set[8]+set[53]+set[59])==4){
			  				if(turn>0){
			  					player1[4]=1;
			  				}
			  				else{
			  					player2[4]=1;
			  				}
			  			}
			        	  if((set[8]+set[13]+set[54]+set[60])==4){
				  				if(turn>0){
				  					player1[9]=1;
				  				}
				  				else{
				  					player2[9]=1;
				  				}
				  			}
			        	  
			        	  if(player1[4]+player2[4]+player1[9]+player2[9]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[8]=1;
			          }
			      }
		      else if((x>540 && x <1600 ) && (y>=185 && y <=215 ) ) {		      

			      set[9]=1;
			      if(nset[9]==0){
				      draw(590,710,185);
			    	  if((set[4]+set[9]+set[59]+set[65])==4){
			  				if(turn>0){
			  					player1[5]=1;
			  				}
			  				else{
			  					player2[5]=1;
			  				}
			  			}
			        	  if((set[9]+set[14]+set[60]+set[66])==4){
				  				if(turn>0){
				  					player1[10]=1;
				  				}
				  				else{
				  					player2[10]=1;
				  				}
				  			}
			        	  
			        	  if(player1[5]+player2[5]+player1[10]+player2[10]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[9]=1;
			          }
		          }
		      //第二行
		      else if((x>100 && x <160 ) && (y>=305 && y <=335 ) ) {		      

		          set[10]=1;
		          if(nset[10]==0){
			          draw(98,208,305);
			    	  if((set[5]+set[10]+set[36]+set[42])==4){
			  				if(turn>0){
			  					player1[6]=1;
			  				}
			  				else{
			  					player2[6]=1;
			  				}
			  			}
			        	  if((set[10]+set[15]+set[37]+set[43])==4){
				  				if(turn>0){
				  					player1[11]=1;
				  				}
				  				else{
				  					player2[11]=1;
				  				}
				  			}
			        	  
			        	  if(player1[6]+player2[6]+player1[11]+player2[11]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[10]=1;
			          }
		          }
		      else if((x>210 && x <270 ) && (y>=305 && y <=335 ) ) {		      

			      set[11]=1;
			      if(nset[11]==0){
				      draw(210,330,305);
			    	  if((set[6]+set[11]+set[42]+set[48])==4){
			  				if(turn>0){
			  					player1[7]=1;
			  				}
			  				else{
			  					player2[7]=1;
			  				}
			  			}
			        	  if((set[11]+set[16]+set[43]+set[49])==4){
				  				if(turn>0){
				  					player1[12]=1;
				  				}
				  				else{
				  					player2[12]=1;
				  				}
				  			}
			        	  
			        	  if(player1[7]+player2[7]+player1[12]+player2[12]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[11]=1;
			          }
			      }
		      else if((x>320 && x <380 ) && (y>=305 && y <=335 ) ) {		      

			      set[12]=1;
			      if(nset[12]==0){
				      draw(330,450,305);
			    	  if((set[7]+set[12]+set[48]+set[54])==4){
			  				if(turn>0){
			  					player1[8]=1;
			  				}
			  				else{
			  					player2[8]=1;
			  				}
			  			}
			        	  if((set[12]+set[17]+set[49]+set[55])==4){
				  				if(turn>0){
				  					player1[13]=1;
				  				}
				  				else{
				  					player2[13]=1;
				  				}
				  			}
			        	  
			        	  if(player1[8]+player2[8]+player1[13]+player2[13]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[12]=1;
			          }
			      }
		      else if((x>430 && x <490 ) && (y>=305 && y <=335 ) ) {		      

			      set[13]=1;
			      if(nset[13]==0){
				      draw(460,580,305);
			    	  if((set[8]+set[13]+set[54]+set[60])==4){
			  				if(turn>0){
			  					player1[9]=1;
			  				}
			  				else{
			  					player2[9]=1;
			  				}
			  			}
			        	  if((set[13]+set[18]+set[55]+set[61])==4){
				  				if(turn>0){
				  					player1[14]=1;
				  				}
				  				else{
				  					player2[14]=1;
				  				}
				  			}
			        	  
			        	  if(player1[9]+player2[9]+player1[14]+player2[14]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[13]=1;
			          }
			      }
		      else if((x>540 && x <1600 ) && (y>=305 && y <=335 ) ) {		      

			      set[14]=1;
			      if(nset[14]==0){
				      draw(590,710,305);
			    	  if((set[14]+set[19]+set[61]+set[67])==4){
			  				if(turn>0){
			  					player1[15]=1;
			  				}
			  				else{
			  					player2[15]=1;
			  				}
			  			}
			        	  if((set[9]+set[14]+set[60]+set[66])==4){
				  				if(turn>0){
				  					player1[10]=1;
				  				}
				  				else{
				  					player2[10]=1;
				  				}
				  			}
			        	  
			        	  if(player1[10]+player2[10]+player1[15]+player2[15]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[14]=1;
			          }
		          }
		      //第三行
		      else if((x>100 && x <160 ) && (y>=425 && y <=455 ) ) {		      

		          set[15]=1;
		          if(nset[15]==0){
			          draw(98,208,425);
			    	  if((set[10]+set[15]+set[37]+set[43])==4){
			  				if(turn>0){
			  					player1[11]=1;
			  				}
			  				else{
			  					player2[11]=1;
			  				}
			  			}
			        	  if((set[15]+set[20]+set[38]+set[44])==4){
				  				if(turn>0){
				  					player1[16]=1;
				  				}
				  				else{
				  					player2[16]=1;
				  				}
				  			}
			        	  
			        	  if(player1[11]+player2[11]+player1[16]+player2[16]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[15]=1;
			          }
		          }
		      else if((x>210 && x <270 ) && (y>=425 && y <=455 ) ) {		      

			      set[16]=1;
			      if(nset[16]==0){
				      draw(210,330,425);
			    	  if((set[11]+set[16]+set[43]+set[49])==4){
			  				if(turn>0){
			  					player1[12]=1;
			  				}
			  				else{
			  					player2[12]=1;
			  				}
			  			}
			        	  if((set[16]+set[21]+set[44]+set[50])==4){
				  				if(turn>0){
				  					player1[17]=1;
				  				}
				  				else{
				  					player2[17]=1;
				  				}
				  			}
			        	  
			        	  if(player1[12]+player2[12]+player1[17]+player2[17]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[16]=1;
			          }
			      }
		      else if((x>320 && x <380 ) && (y>=425 && y <=455 ) ) {		      

			      set[17]=1;
			      if(nset[17]==0){
				      draw(330,450,425);
			    	  if((set[12]+set[17]+set[49]+set[55])==4){
			  				if(turn>0){
			  					player1[13]=1;
			  				}
			  				else{
			  					player2[13]=1;
			  				}
			  			}
			        	  if((set[17]+set[22]+set[50]+set[56])==4){
				  				if(turn>0){
				  					player1[18]=1;
				  				}
				  				else{
				  					player2[18]=1;
				  				}
				  			}
			        	  
			        	  if(player1[13]+player2[13]+player1[18]+player2[18]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[17]=1;
			          }
			      }
		      else if((x>430 && x <490 ) && (y>=425 && y <=455 ) ) {		      

			      set[18]=1;
			      if(nset[18]==0){
				      draw(460,580,425);
			    	  if((set[13]+set[18]+set[55]+set[61])==4){
			  				if(turn>0){
			  					player1[14]=1;
			  				}
			  				else{
			  					player2[14]=1;
			  				}
			  			}
			        	  if((set[18]+set[23]+set[56]+set[62])==4){
				  				if(turn>0){
				  					player1[19]=1;
				  				}
				  				else{
				  					player2[19]=1;
				  				}
				  			}
			        	  
			        	  if(player1[14]+player2[14]+player1[19]+player2[19]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[18]=1;
			          }
			      }
		      else if((x>540 && x <1600 ) && (y>=425 && y <=455 ) ) {		      

			      set[19]=1;
			      if(nset[19]==0){
				      draw(590,710,425);
			    	  if((set[14]+set[19]+set[61]+set[67])==4){
			  				if(turn>0){
			  					player1[15]=1;
			  				}
			  				else{
			  					player2[15]=1;
			  				}
			  			}
			        	  if((set[19]+set[24]+set[62]+set[68])==4){
				  				if(turn>0){
				  					player1[20]=1;
				  				}
				  				else{
				  					player2[20]=1;
				  				}
				  			}
			        	  
			        	  if(player1[15]+player2[15]+player1[20]+player2[20]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[19]=1;
			          }
		          }
		      //第四行
		      else if((x>100 && x <160 ) && (y>=530 && y <=575 ) ) {		      

		          set[20]=1;
		          if(nset[20]==0){
			          draw(98,208,545);
			    	  if((set[15]+set[20]+set[38]+set[44])==4){
			  				if(turn>0){
			  					player1[16]=1;
			  				}
			  				else{
			  					player2[16]=1;
			  				}
			  			}
			        	  if((set[20]+set[25]+set[39]+set[45])==4){
				  				if(turn>0){
				  					player1[21]=1;
				  				}
				  				else{
				  					player2[21]=1;
				  				}
				  			}
			        	  
			        	  if(player1[16]+player2[16]+player1[21]+player2[21]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[20]=1;
			          }
		          }
		      else if((x>210 && x <270 ) && (y>=530 && y <=575 ) ) {		      

			      set[21]=1;
			      if(nset[21]==0){
				      draw(210,330,545);
			    	  if((set[16]+set[21]+set[44]+set[50])==4){
			  				if(turn>0){
			  					player1[17]=1;
			  				}
			  				else{
			  					player2[17]=1;
			  				}
			  			}
			        	  if((set[21]+set[26]+set[45]+set[51])==4){
				  				if(turn>0){
				  					player1[22]=1;
				  				}
				  				else{
				  					player2[22]=1;
				  				}
				  			}
			        	  
			        	  if(player1[17]+player2[17]+player1[22]+player2[22]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[21]=1;
			          }
			      }
		      else if((x>320 && x <380 ) && (y>=530 && y <=575 ) ) {		      

			      set[22]=1;
			      if(nset[22]==0){
				      draw(330,450,545);
			    	  if((set[17]+set[22]+set[50]+set[56])==4){
			  				if(turn>0){
			  					player1[18]=1;
			  				}
			  				else{
			  					player2[18]=1;
			  				}
			  			}
			        	  if((set[22]+set[27]+set[51]+set[57])==4){
				  				if(turn>0){
				  					player1[23]=1;
				  				}
				  				else{
				  					player2[23]=1;
				  				}
				  			}
			        	  
			        	  if(player1[18]+player2[18]+player1[23]+player2[23]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[22]=1;
			          }
			      }
		      else if((x>430 && x <490 ) && (y>=530 && y <=575 ) ) {		      

			      set[23]=1;
			      if(nset[23]==0){
				      draw(460,580,545);
			    	  if((set[18]+set[23]+set[56]+set[62])==4){
			  				if(turn>0){
			  					player1[19]=1;
			  				}
			  				else{
			  					player2[19]=1;
			  				}
			  			}
			        	  if((set[23]+set[28]+set[57]+set[63])==4){
				  				if(turn>0){
				  					player1[24]=1;
				  				}
				  				else{
				  					player2[24]=1;
				  				}
				  			}
			        	  
			        	  if(player1[19]+player2[19]+player1[24]+player2[24]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[23]=1;
			          }
			      }
		      else if((x>540 && x <1600 ) && (y>=530 && y <=575 ) ) {		      

			      set[24]=1;
			      if(nset[24]==0){
				      draw(590,710,545);
			    	  if((set[19]+set[24]+set[62]+set[68])==4){
			  				if(turn>0){
			  					player1[20]=1;
			  				}
			  				else{
			  					player2[20]=1;
			  				}
			  			}
			        	  if((set[24]+set[29]+set[63]+set[69])==4){
				  				if(turn>0){
				  					player1[25]=1;
				  				}
				  				else{
				  					player2[25]=1;
				  				}
				  			}
			        	  
			        	  if(player1[20]+player2[20]+player1[25]+player2[25]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[24]=1;
			          }
		          }
		      //第五
		      else if((x>100 && x <160 ) && (y>=660 && y <=695 ) ) {		      

		          set[25]=1;
		          if(nset[25]==0){
			          draw(98,208,665);
			    	  if((set[20]+set[25]+set[39]+set[45])==4){
			  				if(turn>0){
			  					player1[21]=1;
			  				}
			  				else{
			  					player2[21]=1;
			  				}
			  			}
			        	  if((set[25]+set[30]+set[40]+set[46])==4){
				  				if(turn>0){
				  					player1[26]=1;
				  				}
				  				else{
				  					player2[26]=1;
				  				}
				  			}
			        	  
			        	  if(player1[21]+player2[21]+player1[26]+player2[26]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[25]=1;
			          }
		          }
		      else if((x>210 && x <270 ) && (y>=660 && y <=695 ) ) {		      

			      set[26]=1;
			      if(nset[26]==0){
				      draw(210,330,665);
			    	  if((set[21]+set[26]+set[45]+set[51])==4){
			  				if(turn>0){
			  					player1[22]=1;
			  				}
			  				else{
			  					player2[22]=1;
			  				}
			  			}
			        	  if((set[26]+set[31]+set[46]+set[52])==4){
				  				if(turn>0){
				  					player1[27]=1;
				  				}
				  				else{
				  					player2[27]=1;
				  				}
				  			}
			        	  
			        	  if(player1[22]+player2[22]+player1[27]+player2[27]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[26]=1;
			          }
			      }
		      else if((x>320 && x <380 ) && (y>=660 && y <=695 ) ) {		      

			      set[27]=1;
			      if(nset[27]==0){
				      draw(330,450,665);
			    	  if((set[22]+set[27]+set[51]+set[57])==4){
			  				if(turn>0){
			  					player1[23]=1;
			  				}
			  				else{
			  					player2[23]=1;
			  				}
			  			}
			        	  if((set[27]+set[32]+set[52]+set[58])==4){
				  				if(turn>0){
				  					player1[28]=1;
				  				}
				  				else{
				  					player2[28]=1;
				  				}
				  			}
			        	  
			        	  if(player1[23]+player2[23]+player1[28]+player2[28]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[27]=1;
			          }
			      }
		      else if((x>430 && x <490 ) && (y>=660 && y <=695 ) ) {		      

			      set[28]=1;
			      if(nset[28]==0){
				      draw(460,580,665);
			    	  if((set[23]+set[28]+set[57]+set[63])==4){
			  				if(turn>0){
			  					player1[24]=1;
			  				}
			  				else{
			  					player2[24]=1;
			  				}
			  			}
			        	  if((set[28]+set[33]+set[58]+set[64])==4){
				  				if(turn>0){
				  					player1[29]=1;
				  				}
				  				else{
				  					player2[29]=1;
				  				}
				  			}
			        	  
			        	  if(player1[24]+player2[24]+player1[29]+player2[29]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[28]=1;
			          }
			      }
		      else if((x>540 && x <1600 ) && (y>=660 && y <=695 ) ) {		      

			      set[29]=1;
			      if(nset[29]==0){
				      draw(590,710,665);
			    	  if((set[24]+set[29]+set[63]+set[69])==4){
			  				if(turn>0){
			  					player1[25]=1;
			  				}
			  				else{
			  					player2[25]=1;
			  				}
			  			}
			        	  if((set[29]+set[34]+set[64]+set[70])==4){
				  				if(turn>0){
				  					player1[30]=1;
				  				}
				  				else{
				  					player2[30]=1;
				  				}
				  			}
			        	  
			        	  if(player1[25]+player2[25]+player1[30]+player2[30]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[29]=1;
			          }
		          }
		      //第六行
		      else if((x>100 && x <160 ) && (y>=775 && y <=815 ) ) {		      

		          set[30]=1;
		          if(nset[30]==0){
			          draw(98,208,785);
		        	  if((set[25]+set[30]+set[40]+set[46])==4){
			  				if(turn>0){
			  					player1[26]=1;
			  				}
			  				else{
			  					player2[26]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
		          nset[30]=1;
		          }
		          }
		      else if((x>210 && x <270 ) && (y>=775 && y <=815 ) ) {		      

			      set[31]=1;
			      if(nset[31]==0){
				      draw(210,330,785);
		        	  if((set[26]+set[31]+set[46]+set[52])==4){
			  				if(turn>0){
			  					player1[27]=1;
			  				}
			  				else{
			  					player2[27]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
		          nset[31]=1;
		          }
			      }
		      else if((x>320 && x <380 ) && (y>=775 && y <=815 ) ) {		      

			      set[32]=1;
			      if(nset[32]==0){
				      draw(330,450,785);
		        	  if((set[27]+set[32]+set[52]+set[58])==4){
			  				if(turn>0){
			  					player1[28]=1;
			  				}
			  				else{
			  					player2[28]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
		          nset[32]=1;
		          }
			      }
		      else if((x>430 && x <490 ) && (y>=775 && y <=815 ) ) {		      

			      set[33]=1;
			      if(nset[33]==0){
				      draw(460,580,785);
		        	  if((set[28]+set[33]+set[58]+set[64])==4){
			  				if(turn>0){
			  					player1[29]=1;
			  				}
			  				else{
			  					player2[29]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
		          nset[33]=1;
		          }
			      }
		      else if((x>540 && x <1600 ) && (y>=775 && y <=815 ) ) {		      

			      set[34]=1;
			      if(nset[34]==0){
				      draw(590,710,785);
		        	  if((set[29]+set[34]+set[64]+set[70])==4){
			  				if(turn>0){
			  					player1[30]=1;
			  				}
			  				else{
			  					player2[30]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
		          nset[34]=1;
		          }
		          }
		      //第七行
		      else if((x>=55 && x <=90 ) && (y>=105 && y <=172 ) ) {		      

		          set[35]=1;
		          if(nset[35]==0){
			          draww(55,120,55);
		        	  if((set[0]+set[5]+set[35]+set[41])==4){
			  				if(turn>0){
			  					player1[1]=1;
			  				}
			  				else{
			  					player2[1]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
				      nset[35]=1;
			          }

		          }
		      else if((x>=55 && x <=90 ) && (y>=215 && y <=285 ) ) {		      

			      set[36]=1;
			      if(nset[36]==0){
				      draww(130,195,55);
			    	  if((set[5]+set[10]+set[36]+set[42])==4){
			  				if(turn>0){
			  					player1[6]=1;
			  				}
			  				else{
			  					player2[6]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
			          nset[36]=1;
			          }
			      }
		      else if((x>=55 && x <=90) && (y>=335 && y <=405 ) ) {		      

			      set[37]=1;
			      if(nset[37]==0){
				      draww(200,260,55);
			    	  if((set[10]+set[15]+set[37]+set[43])==4){
			  				if(turn>0){
			  					player1[11]=1;
			  				}
			  				else{
			  					player2[11]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
			          nset[37]=1;
			          }
			      }
		      else if((x>=55 && x <=90 ) && (y>=450 && y <=520) ) {		      

			      set[38]=1;
			      if(nset[38]==0){
				      draww(270,335,55);
			    	  if((set[15]+set[20]+set[38]+set[44])==4){
			  				if(turn>0){
			  					player1[16]=1;
			  				}
			  				else{
			  					player2[16]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
			          nset[38]=1;
			          }
			      }
		      else if((x>=55 && x <=90 ) && (y>=570 && y <=640 ) ) {		      

			      set[39]=1;
			      if(nset[39]==0){
				      draww(335,400,55);
			    	  if((set[20]+set[25]+set[39]+set[45])==4){
			  				if(turn>0){
			  					player1[21]=1;
			  				}
			  				else{
			  					player2[21]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
			          nset[39]=1;
			          }
		          }
		      else if((x>=55 && x <=90 ) && (y>=685 && y <=765 ) ) {		      

			      set[40]=1;
			      if(nset[40]==0){
				      draww(410,475,55);
			    	  if((set[25]+set[30]+set[40]+set[46])==4){
			  				if(turn>0){
			  					player1[26]=1;
			  				}
			  				else{
			  					player2[26]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
			          nset[40]=1;
			          }
		          }
		      //第一列
		      else if((x>=160 && x <=205 ) && (y>=105 && y <=172 ) ) {		      

		          set[41]=1;

			      if(nset[41]==0){
			          draww(55,120,185);
			    	  if((set[0]+set[5]+set[35]+set[41])==4){
			  				if(turn>0){
			  					player1[1]=1;
			  				}
			  				else{
			  					player2[1]=1;
			  				}
			  			}
			        	  if((set[1]+set[6]+set[41]+set[47])==4){
				  				if(turn>0){
				  					player1[2]=1;
				  				}
				  				else{
				  					player2[2]=1;
				  				}
				  			}
			        	  
			        	  if(player1[1]+player2[1]+player1[2]+player2[2]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[41]=1;
			          }
		          }
		      else if((x>=160 && x <=205 ) && (y>=215 && y <=285 ) ) {		      

			      set[42]=1;

			      if(nset[42]==0){
				      draww(130,195,185);
			    	  if((set[5]+set[10]+set[36]+set[42])==4){
			  				if(turn>0){
			  					player1[6]=1;
			  				}
			  				else{
			  					player2[6]=1;
			  				}
			  			}
			        	  if((set[6]+set[11]+set[42]+set[48])==4){
				  				if(turn>0){
				  					player1[7]=1;
				  				}
				  				else{
				  					player2[7]=1;
				  				}
				  			}
			        	  
			        	  if(player1[6]+player2[6]+player1[7]+player2[7]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[42]=1;
			          }
			      }
		      else if((x>=160 && x <=205) && (y>=335 && y <=405 ) ) {		      

			      set[43]=1;

			      if(nset[43]==0){
				      draww(200,260,185);
			    	  if((set[10]+set[15]+set[37]+set[43])==4){
			  				if(turn>0){
			  					player1[11]=1;
			  				}
			  				else{
			  					player2[11]=1;
			  				}
			  			}
			        	  if((set[11]+set[16]+set[43]+set[49])==4){
				  				if(turn>0){
				  					player1[12]=1;
				  				}
				  				else{
				  					player2[12]=1;
				  				}
				  			}
			        	  
			        	  if(player1[11]+player2[11]+player1[12]+player2[12]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[43]=1;
			          }
			      }
		      else if((x>=160 && x <=205 ) && (y>=450 && y <=520) ) {		      

			      set[44]=1;

			      if(nset[44]==0){
				      draww(270,335,185);
			    	  if((set[15]+set[20]+set[38]+set[44])==4){
			  				if(turn>0){
			  					player1[16]=1;
			  				}
			  				else{
			  					player2[16]=1;
			  				}
			  			}
			        	  if((set[16]+set[21]+set[44]+set[45])==4){
				  				if(turn>0){
				  					player1[17]=1;
				  				}
				  				else{
				  					player2[17]=1;
				  				}
				  			}
			        	  
			        	  if(player1[16]+player2[16]+player1[17]+player2[17]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[44]=1;
			          }
			      }
		      else if((x>=160 && x <=205 ) && (y>=570 && y <=640 ) ) {		      

			      set[45]=1;

			      if(nset[45]==0){
				      draww(335,400,185);
			    	  if((set[20]+set[25]+set[39]+set[45])==4){
			  				if(turn>0){
			  					player1[21]=1;
			  				}
			  				else{
			  					player2[21]=1;
			  				}
			  			}
			        	  if((set[21]+set[26]+set[45]+set[51])==4){
				  				if(turn>0){
				  					player1[22]=1;
				  				}
				  				else{
				  					player2[22]=1;
				  				}
				  			}
			        	  
			        	  if(player1[21]+player2[21]+player1[22]+player2[22]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[45]=1;
			          }
		          }
		      else if((x>=160 && x <=205 ) && (y>=685 && y <=765 ) ) {		      

			      set[46]=1;

			      if(nset[46]==0){
				      draww(410,475,185);
			    	  if((set[25]+set[30]+set[40]+set[46])==4){
			  				if(turn>0){
			  					player1[26]=1;
			  				}
			  				else{
			  					player2[26]=1;
			  				}
			  			}
			        	  if((set[26]+set[31]+set[46]+set[52])==4){
				  				if(turn>0){
				  					player1[27]=1;
				  				}
				  				else{
				  					player2[27]=1;
				  				}
				  			}
			        	  
			        	  if(player1[26]+player2[26]+player1[27]+player2[27]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[46]=1;
			          }
		          }
		      //第二列
		      else if((x>=270 && x <=315 ) && (y>=105 && y <=172 ) ) {		      

		          set[47]=1;
		          if(nset[47]==0){
			          draww(55,120,305);
			    	  if((set[1]+set[6]+set[41]+set[47])==4){
			  				if(turn>0){
			  					player1[2]=1;
			  				}
			  				else{
			  					player2[2]=1;
			  				}
			  			}
			        	  if((set[2]+set[7]+set[47]+set[53])==4){
				  				if(turn>0){
				  					player1[3]=1;
				  				}
				  				else{
				  					player2[3]=1;
				  				}
				  			}
			        	  
			        	  if(player1[2]+player2[2]+player1[3]+player2[3]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[47]=1;
			          }
		          }
		      else if((x>=270 && x <=315 ) && (y>=215 && y <=285 ) ) {		      

			      set[48]=1;
			      if(nset[48]==0){
				      draww(130,195,305);
			    	  if((set[6]+set[11]+set[42]+set[48])==4){
			  				if(turn>0){
			  					player1[7]=1;
			  				}
			  				else{
			  					player2[7]=1;
			  				}
			  			}
			        	  if((set[7]+set[12]+set[48]+set[54])==4){
				  				if(turn>0){
				  					player1[8]=1;
				  				}
				  				else{
				  					player2[8]=1;
				  				}
				  			}
			        	  
			        	  if(player1[7]+player2[7]+player1[8]+player2[8]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[48]=1;
			          }
			      }
		      else if((x>=270 && x <=315) && (y>=335 && y <=405 ) ) {		      

			      set[49]=1;
			      if(nset[49]==0){
				      draww(200,260,305);
			    	  if((set[11]+set[16]+set[43]+set[49])==4){
			  				if(turn>0){
			  					player1[12]=1;
			  				}
			  				else{
			  					player2[12]=1;
			  				}
			  			}
			        	  if((set[12]+set[17]+set[49]+set[55])==4){
				  				if(turn>0){
				  					player1[13]=1;
				  				}
				  				else{
				  					player2[13]=1;
				  				}
				  			}
			        	  
			        	  if(player1[12]+player2[12]+player1[13]+player2[13]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[49]=1;
			          }
			      }
		      else if((x>=270 && x <=315 ) && (y>=450 && y <=520) ) {		      

			      set[50]=1;
			      if(nset[50]==0){
				      draww(270,335,305);
			    	  if((set[16]+set[21]+set[44]+set[50])==4){
			  				if(turn>0){
			  					player1[17]=1;
			  				}
			  				else{
			  					player2[17]=1;
			  				}
			  			}
			        	  if((set[17]+set[22]+set[50]+set[56])==4){
				  				if(turn>0){
				  					player1[18]=1;
				  				}
				  				else{
				  					player2[18]=1;
				  				}
				  			}
			        	  
			        	  if(player1[17]+player2[17]+player1[18]+player2[18]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[50]=1;
			          }
			      }
		      else if((x>=270 && x <=315 ) && (y>=570 && y <=640 ) ) {		      

			      set[51]=1;
			      if(nset[51]==0){
				      draww(335,400,305);
			    	  if((set[21]+set[26]+set[45]+set[51])==4){
			  				if(turn>0){
			  					player1[22]=1;
			  				}
			  				else{
			  					player2[22]=1;
			  				}
			  			}
			        	  if((set[22]+set[27]+set[51]+set[57])==4){
				  				if(turn>0){
				  					player1[23]=1;
				  				}
				  				else{
				  					player2[23]=1;
				  				}
				  			}
			        	  
			        	  if(player1[22]+player2[22]+player1[23]+player2[23]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[51]=1;
			          }
		          }
		      else if((x>=270 && x <=315 ) && (y>=685 && y <=765 ) ) {		      

			      set[52]=1;
			      if(nset[52]==0){
				      draww(410,475,305);
			    	  if((set[26]+set[31]+set[46]+set[52])==4){
			  				if(turn>0){
			  					player1[27]=1;
			  				}
			  				else{
			  					player2[27]=1;
			  				}
			  			}
			        	  if((set[27]+set[32]+set[52]+set[58])==4){
				  				if(turn>0){
				  					player1[28]=1;
				  				}
				  				else{
				  					player2[28]=1;
				  				}
				  			}
			        	  
			        	  if(player1[27]+player2[27]+player1[28]+player2[28]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[52]=1;
			          }
		          }
		      //第三列
		      else if((x>=380 && x <=425 ) && (y>=105 && y <=172 ) ) {		      

		          set[53]=1;
		          if(nset[53]==0){
			          draww(55,120,425); 
			    	  if((set[2]+set[7]+set[47]+set[53])==4){
			  				if(turn>0){
			  					player1[3]=1;
			  				}
			  				else{
			  					player2[3]=1;
			  				}
			  			}
			        	  if((set[3]+set[8]+set[53]+set[59])==4){
				  				if(turn>0){
				  					player1[4]=1;
				  				}
				  				else{
				  					player2[4]=1;
				  				}
				  			}
			        	  
			        	  if(player1[3]+player2[3]+player1[4]+player2[4]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[53]=1;
			          }
		          }
		      else if((x>=380 && x <=425 ) && (y>=215 && y <=285 ) ) {		      

			      set[54]=1;
			      if(nset[54]==0){
				      draww(130,195,425);
			    	  if((set[7]+set[12]+set[48]+set[54])==4){
			  				if(turn>0){
			  					player1[8]=1;
			  				}
			  				else{
			  					player2[8]=1;
			  				}
			  			}
			        	  if((set[8]+set[13]+set[54]+set[60])==4){
				  				if(turn>0){
				  					player1[9]=1;
				  				}
				  				else{
				  					player2[9]=1;
				  				}
				  			}
			        	  
			        	  if(player1[8]+player2[8]+player1[9]+player2[9]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[54]=1;
			          }
			      }
		      else if((x>=380 && x <=425) && (y>=335 && y <=405 ) ) {		      

			      set[55]=1;
			      if(nset[55]==0){
				      draww(200,260,425);
			    	  if((set[12]+set[17]+set[49]+set[55])==4){
			  				if(turn>0){
			  					player1[13]=1;
			  				}
			  				else{
			  					player2[13]=1;
			  				}
			  			}
			        	  if((set[13]+set[18]+set[55]+set[61])==4){
				  				if(turn>0){
				  					player1[14]=1;
				  				}
				  				else{
				  					player2[14]=1;
				  				}
				  			}
			        	  
			        	  if(player1[13]+player2[13]+player1[14]+player2[14]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[55]=1;
			          }
			      }
		      else if((x>=380 && x <=425 ) && (y>=450 && y <=520) ) {		      

			      set[56]=1;
			      if(nset[56]==0){
				      draww(270,335,425);
			    	  if((set[17]+set[22]+set[50]+set[56])==4){
			  				if(turn>0){
			  					player1[18]=1;
			  				}
			  				else{
			  					player2[18]=1;
			  				}
			  			}
			        	  if((set[18]+set[23]+set[56]+set[62])==4){
				  				if(turn>0){
				  					player1[19]=1;
				  				}
				  				else{
				  					player2[19]=1;
				  				}
				  			}
			        	  
			        	  if(player1[18]+player2[18]+player1[19]+player2[19]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[56]=1;
			          }
			      }
		      else if((x>=380 && x <=425 ) && (y>=570 && y <=640 ) ) {		      

			      set[57]=1;
			      if(nset[57]==0){
				      draww(335,400,425);
			    	  if((set[22]+set[27]+set[51]+set[57])==4){
			  				if(turn>0){
			  					player1[23]=1;
			  				}
			  				else{
			  					player2[23]=1;
			  				}
			  			}
			        	  if((set[23]+set[28]+set[57]+set[63])==4){
				  				if(turn>0){
				  					player1[24]=1;
				  				}
				  				else{
				  					player2[24]=1;
				  				}
				  			}
			        	  
			        	  if(player1[23]+player2[23]+player1[24]+player2[24]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[57]=1;
			          }
		          }
		      else if((x>=380 && x <=425 ) && (y>=685 && y <=765 ) ) {		      

			      set[58]=1;
			      if(nset[58]==0){
				      draww(410,475,425);
			    	  if((set[27]+set[32]+set[52]+set[58])==4){
			  				if(turn>0){
			  					player1[28]=1;
			  				}
			  				else{
			  					player2[28]=1;
			  				}
			  			}
			        	  if((set[28]+set[33]+set[58]+set[64])==4){
				  				if(turn>0){
				  					player1[29]=1;
				  				}
				  				else{
				  					player2[29]=1;
				  				}
				  			}
			        	  
			        	  if(player1[28]+player2[28]+player1[29]+player2[29]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[58]=1;
			          }
		          }
		      //第四列
		      else if((x>=490 && x <=540 ) && (y>=105 && y <=172 ) ) {		      

		          set[59]=1;
		          if(nset[59]==0){
			          draww(55,120,545);
			    	  if((set[3]+set[8]+set[53]+set[59])==4){
			  				if(turn>0){
			  					player1[4]=1;
			  				}
			  				else{
			  					player2[4]=1;
			  				}
			  			}
			        	  if((set[4]+set[9]+set[59]+set[65])==4){
				  				if(turn>0){
				  					player1[5]=1;
				  				}
				  				else{
				  					player2[5]=1;
				  				}
				  			}
			        	  
			        	  if(player1[4]+player2[4]+player1[5]+player2[5]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[59]=1;
			          }
		          }
		      else if((x>=490 && x <=540 ) && (y>=215 && y <=285 ) ) {		      

			      set[60]=1;
			      if(nset[60]==0){
				      draww(130,195,545);
			    	  if((set[8]+set[13]+set[54]+set[60])==4){
			  				if(turn>0){
			  					player1[9]=1;
			  				}
			  				else{
			  					player2[9]=1;
			  				}
			  			}
			        	  if((set[9]+set[14]+set[60]+set[66])==4){
				  				if(turn>0){
				  					player1[10]=1;
				  				}
				  				else{
				  					player2[10]=1;
				  				}
				  			}
			        	  
			        	  if(player1[9]+player2[9]+player1[10]+player2[10]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[60]=1;
			          }
			      }
		      else if((x>=490 && x <=540) && (y>=335 && y <=405 ) ) {		      

			      set[61]=1;
			      if(nset[61]==0){
				      draww(200,260,545);
			    	  if((set[13]+set[18]+set[55]+set[61])==4){
			  				if(turn>0){
			  					player1[14]=1;
			  				}
			  				else{
			  					player2[14]=1;
			  				}
			  			}
			        	  if((set[14]+set[19]+set[61]+set[67])==4){
				  				if(turn>0){
				  					player1[15]=1;
				  				}
				  				else{
				  					player2[15]=1;
				  				}
				  			}
			        	  
			        	  if(player1[14]+player2[14]+player1[15]+player2[15]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[61]=1;
			          }
			      }
		      else if((x>=490 && x <=540 ) && (y>=450 && y <=520) ) {		      

			      set[62]=1;
			      if(nset[62]==0){
				      draww(270,335,545);
			    	  if((set[18]+set[23]+set[56]+set[62])==4){
			  				if(turn>0){
			  					player1[19]=1;
			  				}
			  				else{
			  					player2[19]=1;
			  				}
			  			}
			        	  if((set[19]+set[24]+set[62]+set[68])==4){
				  				if(turn>0){
				  					player1[20]=1;
				  				}
				  				else{
				  					player2[20]=1;
				  				}
				  			}
			        	  
			        	  if(player1[19]+player2[19]+player1[20]+player2[20]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[62]=1;
			          }
			      }
		      else if((x>=490 && x <=540 ) && (y>=570 && y <=640 ) ) {		      

			      set[63]=1;
			      if(nset[63]==0){
				      draww(335,400,545);
			    	  if((set[23]+set[28]+set[57]+set[63])==4){
			  				if(turn>0){
			  					player1[24]=1;
			  				}
			  				else{
			  					player2[24]=1;
			  				}
			  			}
			        	  if((set[24]+set[29]+set[63]+set[69])==4){
				  				if(turn>0){
				  					player1[25]=1;
				  				}
				  				else{
				  					player2[25]=1;
				  				}
				  			}
			        	  
			        	  if(player1[24]+player2[24]+player1[25]+player2[25]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[63]=1;
			          }
		          }
		      else if((x>=490 && x <=540 ) && (y>=685 && y <=765 ) ) {		      

			      set[64]=1;
			      if(nset[64]==0){
				      draww(410,475,545);
			    	  if((set[28]+set[33]+set[58]+set[64])==4){
			  				if(turn>0){
			  					player1[29]=1;
			  				}
			  				else{
			  					player2[29]=1;
			  				}
			  			}
			        	  if((set[29]+set[34]+set[64]+set[70])==4){
				  				if(turn>0){
				  					player1[30]=1;
				  				}
				  				else{
				  					player2[30]=1;
				  				}
				  			}
			        	  
			        	  if(player1[29]+player2[29]+player1[30]+player2[30]>0){
			        		  turn=turn*1;
			        	  }
			        	  else{
			        		  turn=turn*-1;
			        	  }
			          nset[64]=1;
			          }
		          }
		      //第五列
		      else if((x>=600 && x <=660 ) && (y>=105 && y <=172 ) ) {		      

		          set[65]=1;
		          if(nset[65]==0){
			          draww(55,120,785);
			    	  if((set[4]+set[9]+set[59]+set[65])==4){
			  				if(turn>0){
			  					player1[5]=1;
			  				}
			  				else{
			  					player2[5]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
			          nset[65]=1;
			          }
		          }
		      else if((x>=600 && x <=660 ) && (y>=215 && y <=285 ) ) {		      

			      set[66]=1;
			      if(nset[66]==0){
				      draww(130,195,785);
			    	  if((set[9]+set[14]+set[60]+set[66])==4){
			  				if(turn>0){
			  					player1[10]=1;
			  				}
			  				else{
			  					player2[10]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
			          nset[66]=1;
			          }
			      }
		      else if((x>=600 && x <=660) && (y>=335 && y <=405 ) ) {		      

			      set[67]=1;
			      if(nset[67]==0){
				      draww(200,260,785);
			    	  if((set[14]+set[19]+set[61]+set[67])==4){
			  				if(turn>0){
			  					player1[15]=1;
			  				}
			  				else{
			  					player2[15]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
			          nset[67]=1;
			          }
			      }
		      else if((x>=600 && x <=660 ) && (y>=450 && y <=520) ) {		      

			      set[68]=1;
			      if(nset[68]==0){
				      draww(270,335,785);
			    	  if((set[19]+set[24]+set[62]+set[68])==4){
			  				if(turn>0){
			  					player1[20]=1;
			  				}
			  				else{
			  					player2[20]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
			          nset[68]=1;
			          }
			      }
		      else if((x>=600 && x <=660 ) && (y>=570 && y <=640 ) ) {		      

			      set[69]=1;
			      if(nset[69]==0){
				      draww(335,400,785);
			    	  if((set[24]+set[29]+set[63]+set[69])==4){
			  				if(turn>0){
			  					player1[25]=1;
			  				}
			  				else{
			  					player2[25]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
			          nset[69]=1;
			          }
		          }
		      else if((x>=600 && x <=660 ) && (y>=685 && y <=765 ) ) {		      

			      set[70]=1;
			      if(nset[70]==0){
				      draww(410,475,785);
			    	  if((set[29]+set[34]+set[64]+set[70])==4){
			  				if(turn>0){
			  					player1[30]=1;
			  				}
			  				else{
			  					player2[30]=1;
			  				}
			  			}			        	  
			        else{
			        		  turn=turn*-1;
			        	}
			          nset[70]=1;
			          }
		          }
		      //第六列
		      
			
		}

	
		private void draw(int x, int y,int drawy) {
			// TODO Auto-generated method stub
			//    paint = new Paint();    
			  
		        paint.setStrokeWidth(8);
		        if(turn>0){
		        paint.setColor(Color.BLACK); 
		        }
		        else{
		        paint.setColor(Color.BLUE); 	
		        }


		    //  paint.setAntiAlias(false); 
		          
		   //     bitmap = Bitmap.createBitmap(800, 480, Bitmap.Config.ARGB_8888);   
		  //      canvas = new Canvas(bitmap);  
		  //      canvas.drawColor(Color.TRANSPARENT,PorterDuff.Mode.CLEAR);
                  int dx=0;
		          if(drawy==60){
		          dx=55;
		          }
		          else if(drawy==185){
		          dx=125;
		          }
		          else if(drawy==305){
			      dx=195;
			      } 
		          else if(drawy==425){
				  dx=265;
				  }
		          else if(drawy==545){
				  dx=335;
				  }
		          else if(drawy==665){
				  dx=405;
			      }
		          else if(drawy==785){
				  dx=475;
				  }
		          canvas.drawLine(x, dx, y, dx, paint);		        
		   //     Drawable drawable = new BitmapDrawable(bitmap) ;    
		          mylayout.setBackgroundDrawable(drawable);
			
		}
		private void draww(int x, int y,int drawx) {
			// TODO Auto-generated method stub
			//    paint = new Paint();    
			  
		        paint.setStrokeWidth(12);
		        if(turn>0){
			        paint.setColor(Color.BLACK); 
			        }
			        else{
			        paint.setColor(Color.BLUE); 	
			        } 

		    //  paint.setAntiAlias(false); 
		          
		   //     bitmap = Bitmap.createBitmap(800, 480, Bitmap.Config.ARGB_8888);   
		  //      canvas = new Canvas(bitmap);  
		  //      canvas.drawColor(Color.TRANSPARENT,PorterDuff.Mode.CLEAR);
                  int dy=0;
		          if(drawx==55){
		          dy=85;
		          }
		          else if(drawx==185){
		          dy=210;
		          }
		          else if(drawx==305){
			      dy=335;
		          }
		          else if(drawx==425){
				  dy=460;
				  }
		          else if(drawx==545){
				  dy=585;
				  }
		          else if(drawx==785){
				  dy=712;
				  }
		          canvas.drawLine(dy, x, dy, y, paint);		        
		   //     Drawable drawable = new BitmapDrawable(bitmap) ;    
		          mylayout.setBackgroundDrawable(drawable);
			
		}
		  		  
}
