package ChatGPT.BuilderPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReisePlan {
    private String startort;
    private String zielort;
    private int reisedauer;
    private String transportmittel;
    private List<String> sehenswuerdigkeiten;

    private ReisePlan(ReisePlanBuilder builder) {
        this.startort = builder.startort;
        this.zielort = builder.zielort;
        this.reisedauer = builder.reisedauer;
        this.transportmittel = builder.transportmittel;
        this.sehenswuerdigkeiten = Collections.unmodifiableList(builder.sehenswuerdigkeiten);
    }

    public static class ReisePlanBuilder {
        private String startort;
        private String zielort;
        private int reisedauer;
        private String transportmittel;
        private List<String> sehenswuerdigkeiten = new ArrayList<>();

        public ReisePlanBuilder startort(String startort) {
            this.startort = startort;
            return this;
        }

        public ReisePlanBuilder zielort(String zielort) {
            this.zielort = zielort;
            return this;
        }

        public ReisePlanBuilder reisedauer(int reisedauer) {
            if(reisedauer < 1) {
                throw new IllegalArgumentException("Reisedauer darf nicht kleiner 1 sein");
            }
            this.reisedauer = reisedauer;
            return this;
        }

        public ReisePlanBuilder transportmittel(String transportmittel) {
            this.transportmittel = transportmittel;
            return this;
        }

        public ReisePlanBuilder addSehenswuerdigkeit(String sehenswuerdigkeit) {
            this.sehenswuerdigkeiten.add(sehenswuerdigkeit);
            return this;
        }

        public ReisePlanBuilder printPlan() {
            print();
            return this;
        }

        private void print() {
            System.out.println("Startort: " + startort);
            System.out.println("Zielort: " + zielort);
            System.out.println("Reisedauer: " + reisedauer);
            System.out.println("Transportmittel: " + transportmittel);
            System.out.println("Sehenswuerdigkeiten: ");
            for (String sehenswuerdigkeit : sehenswuerdigkeiten) {
                System.out.println(sehenswuerdigkeit);
            }
        }

        public ReisePlan build() {
            return new ReisePlan(this);
        }
    }
    public String toString() {
        return "ReisePlan{" +
                "startort='" + startort + '\'' +
                ", zielort='" + zielort + '\'' +
                ", reisedauer=" + reisedauer +
                ", transportmittel='" + transportmittel + '\'' +
                ", sehenswuerdigkeiten=" + sehenswuerdigkeiten +
                '}';
    }

    public List<String> getSehenswuerdigkeiten() {
        return sehenswuerdigkeiten;
    }
}
