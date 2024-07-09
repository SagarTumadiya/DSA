package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
class Job{
    char jobId;
    int deadLine;
    int profit;
    Job(char jobId,int deadLine,int profit){
        this.jobId = jobId;
        this.deadLine = deadLine;
        this.profit  = profit;
    }

    @Override
    public String toString() {
        return "Job{Jobid:"+jobId+" Deadline:"+deadLine+" Profit:"+profit+"}";
    }
}
public class JobSequencing {

    public void sortDataOnBasisOfProfitArray(List<Job>jobList){
        Collections.sort(jobList,(jobA,jobB)->{
            int value = jobB.profit-jobA.profit;
            if(value==0){
                value = jobB.deadLine-jobA.deadLine;
            }
            return value;
        });
    }
    public void solve(List<Job>jobList){
        int n = jobList.size();
        int requiredTimeSlots = 0;
        for(int i=0;i<n;i++)
            requiredTimeSlots = Math.max(requiredTimeSlots,jobList.get(i).deadLine);
        boolean []freeTimeSlot = new boolean[requiredTimeSlots];
        char []jobSequence = new char[requiredTimeSlots];
        int totalProfit = 0;
        for(int i=0;i<n;i++){
            for(int j=jobList.get(i).deadLine-1;j>=0;j--){
                if(!freeTimeSlot[j]){
                    freeTimeSlot[j] = true;
                    jobSequence[j] = jobList.get(i).jobId;
                    totalProfit+=jobList.get(i).profit;
                    break;
                }
            }
        }
        for(int i=0;i< jobSequence.length;i++)
            System.out.print(jobSequence[i]
                    +",");

        System.out.println();
        System.out.println(totalProfit);
    }

    public static void main(String[] args) {
     JobSequencing jobSequencing = new JobSequencing();
     List<Job> jobList = new ArrayList<>();
        jobList.add(new Job('A', 2, 100));
        jobList.add(new Job('B', 1, 19));
        jobList.add(new Job('C', 2, 27));
        jobList.add(new Job('D', 1, 25));
        jobList.add(new Job('E', 3, 15));
        jobList.add(new Job('F', 4, 100));

        jobSequencing.sortDataOnBasisOfProfitArray(jobList);
        jobSequencing.solve(jobList);

    }
}
;