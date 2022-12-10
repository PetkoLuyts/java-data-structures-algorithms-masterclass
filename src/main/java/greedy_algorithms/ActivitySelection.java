package greedy_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ActivitySelection {

    public static class Activity {
        private String name;
        private int startTime;
        private int finishTime;

        public Activity(String name, int startTime, int finishTime) {
            this.name = name;
            this.startTime = startTime;
            this.finishTime = finishTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getFinishTime() {
            return finishTime;
        }

        public void setFinishTime(int finishTime) {
            this.finishTime = finishTime;
        }

        @Override
        public String toString() {
            return "Activity: " + name + ", start time = " + startTime + ", finish time = " + finishTime;
        }
    }

    public static void activitySelection(ArrayList<Activity> activityList) {
        Comparator<Activity> finishTimeComparator = new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.getFinishTime() - o2.getFinishTime();
            }
        };

        Collections.sort(activityList, finishTimeComparator);
        Activity previousActivity = activityList.get(0);

        System.out.println("Recommended Schedule: \n" + activityList.get(0));

        for (int i = 1; i < activityList.size(); i++) {
            Activity currentActivity = activityList.get(i);

            if (currentActivity.getStartTime() >= previousActivity.getFinishTime()) {
                System.out.println(currentActivity);
                previousActivity = currentActivity;
            }
        }
    }
}
