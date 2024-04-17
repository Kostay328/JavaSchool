package ru.progwards.java1.lessons.datetime;

import java.time.Instant;
import java.util.*;

public class Profiler {
    private static Map<String, StatisticInfo> allSections = new HashMap<>();  // словарь из уникальных секций
    private static ArrayList<StatisticInfo> sectionsList = new ArrayList<>();  // текущий список уникальных секций

    public static void enterSection(String name) {
        long enterTime = Instant.now().toEpochMilli();
        if (allSections.putIfAbsent(name, new StatisticInfo()) == null) {
            allSections.get(name).sectionName = name;
            sectionsList.add(allSections.get(name));
        }
        allSections.get(name).lastEnterTime = enterTime;
        allSections.get(name).selfTimeCorrection = 0;
    }

    public static void exitSection(String name) {
        long exitTime = Instant.now().toEpochMilli();
        long lastDuration = exitTime - allSections.get(name).lastEnterTime;
        allSections.get(name).fullTime += (int) lastDuration;
        allSections.get(name).selfTime += (int) (lastDuration + allSections.get(name).selfTimeCorrection);
        allSections.get(name).lastExitTime = exitTime;
        allSections.get(name).count++;

        for (StatisticInfo s : sectionsList) {
            if (s.lastEnterTime >= s.lastExitTime) {
                s.selfTimeCorrection -= lastDuration + allSections.get(name).selfTimeCorrection;
            }
        }
    }

    public static List<StatisticInfo> getStatisticInfo() {
        sectionsList.sort(Comparator.comparing(o -> o.sectionName));
        return sectionsList;
    }

    public static class StatisticInfo {
        private String sectionName;
        private int fullTime;
        private int selfTime;
        private int count;

        public long lastEnterTime;
        public long lastExitTime;
        public long selfTimeCorrection;

        public StatisticInfo(String sectionName, int fullTime, int selfTime, int count) {
            this.sectionName = sectionName;
            this.fullTime = fullTime;
            this.selfTime = selfTime;
            this.count = count;
        }

        public StatisticInfo() {

        }

        public String getSectionName() {
            return sectionName;
        }

        public int getFullTime() {
            return fullTime;
        }

        public int getSelfTime() {
            return selfTime;
        }

        public int getCount() {
            return count;
        }

        public int compareTo(StatisticInfo other) {
            return this.sectionName.compareTo(other.sectionName);
        }

        @Override
        public String toString() {
            return "StatisticInfo{" +
                    "sectionName='" + sectionName + '\'' +
                    ", fullTime=" + fullTime +
                    ", selfTime=" + selfTime +
                    ", count=" + count +
                    '}';
        }
    }
}
