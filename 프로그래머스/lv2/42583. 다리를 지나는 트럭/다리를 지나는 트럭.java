import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0; 
        int time = 0;
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int truckWeight : truck_weights) {
            while(true) {
                if(q.isEmpty()) {
                    q.add(truckWeight); 
                    sum += truckWeight; 
                    time ++;
                    break; 
                } else if (q.size() == bridge_length) { 
                    sum -= q.remove(); 
                } else {
                    time++;
                    if(sum + truckWeight <= weight){
                        q.add(truckWeight); 
                        sum += truckWeight; 
                        break;
                    } else {
                        q.add(0);
                    }
                }
            }
        }
        return time + bridge_length;
    }
}