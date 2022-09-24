import java.util.*;
import java.io.*;
import java.util.stream.Stream;

    class Solution {
        public static String solution(String play_time, String adv_time, String[] logs) {
            String answer = "";

            int play_sec = timeToSec(play_time);
            int adv_sec = timeToSec(adv_time);
            int play[] = new int[play_sec+1];

            // 재생 기록 누적
            for(int i=0;i<logs.length;i++){
                String log[] = logs[i].split("-");
                int start_sec = timeToSec(log[0]);
                int end_sec = timeToSec(log[1]);
                
                for(int j=start_sec;j<end_sec;j++){
                    play[j]+=1;
                }
            }

            
            long max_time = 0;
            for(int i=0;i<adv_sec;i++){
                max_time+=play[i];
            }
            
            // 최대 광고
            long cur = max_time;
            int result = 0;
            for(int i=0,j=adv_sec; j<play_sec; i++,j++) {
                cur = cur-play[i]+play[j];
                if (max_time < cur) {
                    max_time = cur;
                    result = i+1;
                }
            }
            return secToTime(result);
        }

        public static int timeToSec(String time){
            String parse[] = time.split(":");
            int sec = Integer.parseInt(parse[0])*3600+Integer.parseInt(parse[1])*60+Integer.parseInt(parse[2]);
            return sec;
        }
        public static String secToTime(int sec){
            String time = "";
            int div = 3600;
            while(div>59){
                if((sec/div)<10){
                    time+="0"+sec/div+":";
                }
                else time+=sec/div+":";
                sec%=div;
                div/=60;
            }
            if(sec<10) time+="0"+sec;
            else time+=""+sec;
            return time;
        }
    }